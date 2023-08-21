package personalproject.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import personalproject.contentcalendar.model.Content;
import personalproject.contentcalendar.model.Status;
import personalproject.contentcalendar.model.Type;

@Repository
public class ContentCollectionRepository {
    // in memory collection of information
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        contentList.sort(Comparator.comparingInt(c -> c.id()));
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c1 = new Content(1, "Write about a cat", Status.IDEA, "Great idea", Type.ARTICLE, LocalDateTime.now(),
                null, "");
        contentList.add(c1);
        Content c2 = new Content(2, "Write about a dog", Status.IN_PROGRESS, "The dog I saw today.", Type.ARTICLE,
                LocalDateTime.now(),
                null, "");
        contentList.add(c2);
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().anyMatch(c -> c.id().equals(id));

    }

    public boolean delete(Integer id) {
        return contentList.removeIf(c -> c.id().equals(id));
    }

}
