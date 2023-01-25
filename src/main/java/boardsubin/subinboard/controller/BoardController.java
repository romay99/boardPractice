package boardsubin.subinboard.controller;

import boardsubin.subinboard.domain.Content;
import boardsubin.subinboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")  //게시글 리스트
    public String boardList(Model model) {
        model.addAttribute("board", boardService.allContent());
        return "boards";
    }

    @PostMapping("/post")  // 폼으로 데이터오면 저장소에 저장하는 메소드
    public String postContent(Content content) {
        boardService.writeContent(content);
        return "redirect:/board/list";
    }

    @GetMapping("/post")  //게시글 작성 폼
    public String toPostContent() {
        return "contentForm";
    }

    @GetMapping("/view/{id}")  //게시물 조회 폼
    public String contentView(@PathVariable("id") int id, Model model) {
        Content content = boardService.searchContentById(id);
        model.addAttribute("id", content.getId());
        model.addAttribute("title", content.getTitle());
        model.addAttribute("content", content.getContent());
        return "contentView";
    }

    @GetMapping("/view/update/{id}")  // 게시물 수정 폼
    public String updateForm(@PathVariable("id") int id, Model model) {
        Content content = boardService.searchContentById(id);
        model.addAttribute("id", content.getId());
        model.addAttribute("title", content.getTitle());
        model.addAttribute("content", content.getContent());
        return "updateForm";
    }

    @PostMapping("/view/update/{id}")  // 게시물 수정 기능
    public String updateMethod(@PathVariable("id") int id, Content content) {
        boardService.reWriteContent(content.getId(), content);
        return "redirect:/board/list";
    }

    @GetMapping("/view/delete/{id}")  // 게시물 삭제 기능
    public String deleteContent(@PathVariable("id") int id) {
        boardService.removeContent(id);
        return "redirect:/board/list";
    }
}
