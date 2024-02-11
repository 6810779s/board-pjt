package org.study.board.dto;

import java.time.LocalDateTime;

/**
 * DTO for {@link org.study.board.domain.UserAccount}
 */
public record UserAccountDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String userId,
        String userPassword,
        String email,
        String nickname,
        String memo
) {
    public static UserAccountDto of(LocalDateTime createdAt,
                          String createdBy,
                          LocalDateTime modifiedAt,
                          String modifiedBy,
                          String userId,
                          String userPassword,
                          String email,
                          String nickname,
                          String memo) {
        return new UserAccountDto(createdAt, createdBy, modifiedAt, modifiedBy, userId, userPassword, email, nickname, memo);
    }
}