package org.study.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.study.board.dto.ArticleCommentDto;
import org.study.board.repository.ArticleCommentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;


    public List<ArticleCommentDto> searchArticleComment(long articleId) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentDto dto) {
    }
}
