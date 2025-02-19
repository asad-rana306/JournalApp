package net.engineeringdigest.journalApp.cache;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.ConfigJournalAppEntity;
import net.engineeringdigest.journalApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class AppCache {

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> appCache;

    @PostConstruct
    public Map<String, String> init() {
        appCache = new HashMap<>();
        log.info("Initializing AppCache...");
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();

        if (all.isEmpty()) {
            log.warn("ConfigJournalAppRepository returned an empty list!");
        } else {
            log.info("Loaded {} entries into AppCache.", all.size());
        }

        for (ConfigJournalAppEntity entity : all) {
            appCache.put(entity.getKey(), entity.getValue());
        }

        log.info("AppCache initialized with keys: {}", appCache.keySet());
        return appCache;
    }

}
