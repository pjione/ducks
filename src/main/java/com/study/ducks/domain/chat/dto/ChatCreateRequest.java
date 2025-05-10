package com.study.ducks.domain.chat.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(title = "채팅방 생성 요청")
public record ChatCreateRequest(
        @Schema(description = "커미션 id", example = "1")
        @NotNull(message = "커미션 id는 필수입니다.")
        Long commissionId,
        @Schema(description = "채팅 참여자 id 목록 (2명 이상)", example = "[1, 2]")
        @NotNull(message = "참여자 목록은 필수입니다.")
        List<@NotNull(message = "참여자 id는 null일 수 없습니다.") Long> userIds
) {}
