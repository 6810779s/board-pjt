package org.study.board.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.study.board.domain.Article;
import org.study.board.domain.ArticleComment;
import org.study.board.dto.ArticleCommentDto;
import org.study.board.repository.ArticleCommentRepository;
import org.study.board.repository.ArticleRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {
    @InjectMocks private ArticleCommentService sut;
    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchComments_thenReturnsComments() {
        Long articleId = 1L;
        given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title","content","hashtag")
        ));
        List<ArticleCommentDto> articleComments =  sut.searchArticleComment(1L);
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
    @Test
    void givenCommentContent_whenSavingComment_thenSavesComment() {
        ArticleCommentDto dto = ArticleCommentDto.of(LocalDateTime.now(),"eunhee",LocalDateTime.now(),"eunhee","content");
        given(articleRepository.save(any(Article.class))).willReturn(null);
        sut.saveArticleComment(dto);
        then(articleRepository).should().save(any(Article.class));
    }
}