package personalproject.contentcalendar.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        Status status,
        String desc,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url) {

}