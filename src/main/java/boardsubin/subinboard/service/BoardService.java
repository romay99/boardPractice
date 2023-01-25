package boardsubin.subinboard.service;


import boardsubin.subinboard.domain.Content;
import boardsubin.subinboard.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private RepositoryInterface repository;

    public Content writeContent(Content content) {
        repository.saveContent(content);
        return content;
    }

    public List<Content> allContent(){
        return repository.findAll();
    }

    public Content searchContentById(Integer id) {
        return repository.findContentById(id);
    }

    public void removeContent(Integer id) {
        repository.deleteContent(id);
    }

    public Content reWriteContent(Integer id, Content content) {
        repository.updateContent(id, content);
        return content;
    }


}
