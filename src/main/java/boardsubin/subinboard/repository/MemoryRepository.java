package boardsubin.subinboard.repository;

import boardsubin.subinboard.domain.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MemoryRepository implements RepositoryInterface {

    private final Map<Integer, Content> memory ;
    private int contentId = 1;

    private MemoryRepository(){
        memory = new HashMap<Integer,Content>();
    }


    @Override
    public Content saveContent(Content content) {
        content.setId(contentId);
        contentId++;
        memory.put(content.getId(),content);
        return content;
    }

    @Override
    public List<Content> findAll(){
        return new ArrayList<Content>(memory.values());
    }


    @Override
    public Content findContentById(int id) {
        return memory.get(id);
    }

    @Override
    public void deleteContent(int id) {
        memory.remove(id);
    }

    @Override
    public Content updateContent(int id, Content content) {
        memory.put(content.getId(),content);
        return content;
    }
}
