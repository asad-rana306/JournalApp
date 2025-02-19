package net.engineeringdigest.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class WeatherResponse{

    private Current current;

    @Getter
    @Setter
    public class Current{

        @JsonProperty("Observation_time")
        private String observationTime;

        private int temperature;

        @JsonProperty("weather_code")
        private int weatherCode;

        @JsonProperty("weather-description")
        private List<String> weatherDescriptions;
        private int feelslike;
        private int uv_index;
        private int visibility;

        @JsonProperty("is_day")
        private String isDay;
    }


}





