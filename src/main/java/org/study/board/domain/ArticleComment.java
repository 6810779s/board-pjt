package org.study.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {@Index(columnList = "content"), @Index(columnList = "createdAt"), @Index(columnList = "createdBy")})
@Entity
public class ArticleComment extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) private UserAccount userAccount;
    @Setter @ManyToOne(optional = false) private Article article;
    @Setter @Column(nullable = false, length = 500) private String content;

    protected ArticleComment() {
    }

    private ArticleComment(Article article, UserAccount userAccount, String content) {
        this.article = article;
        this.content = content;
        this.userAccount = userAccount;
    }

    public static ArticleComment of(Article article, UserAccount userAccount, String content) {
        return new ArticleComment(article, userAccount, content);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
