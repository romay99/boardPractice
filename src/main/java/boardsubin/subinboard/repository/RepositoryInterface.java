package boardsubin.subinboard.repository;

import boardsubin.subinboard.domain.Content;

import java.util.List;


public interface RepositoryInterface {

    Content saveContent(Content content);

    List<Content> findAll();

    Content findContentById(int id);

    void deleteContent(int id);

    Content updateContent(int id,Content content);
}
