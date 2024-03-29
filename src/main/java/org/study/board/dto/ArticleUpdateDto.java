package org.study.board.dto;

/**
 * DTO for {@link org.study.board.domain.Article}
 */
public record ArticleUpdateDto(
        String title,
        String content,
        String hashtag
){
    public static ArticleUpdateDto of(String title, String content, String hashtag) {
        return new ArticleUpdateDto(title, content, hashtag);
    }
}