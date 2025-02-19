package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_" + city, WeatherResponse.class);
        if (weatherResponse != null) {
            return weatherResponse;
        }

        try {
            String apiTemplate = appCache.init().get("weather_api");
            if (apiTemplate == null) {
                log.error("WEATHER_API is missing from cache");
                return null;
            }

            String finalAPI = apiTemplate.replace("<city>", city).replace("<apiKey>", apiKey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();

            if (body != null) {
                redisService.set("weather_" + city, body, Long.valueOf(300));
            } else {
                log.error("Weather API response body is null for city={}", city);
            }

            return body;
        } catch (Exception e) {
            log.error("Error fetching weather data for city={}", city, e);
            return null;
        }
    }

}
