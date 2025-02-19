package net.engineeringdigest.journalApp.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import net.engineeringdigest.journalApp.enums.Sentiment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection =  "Journal_Entries")
@Data
@NoArgsConstructor
public class JournalEntry {
    @Id
    public String id;
    public String content;
    @NonNull
    public String title;
    public LocalDateTime date;
    private Sentiment sentiment;
    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();


}