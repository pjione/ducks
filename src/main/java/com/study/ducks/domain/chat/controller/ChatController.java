package com.study.ducks.domain.chat.controller;

import com.study.ducks.domain.chat.dto.ChatCreateRequest;
import com.study.ducks.domain.chat.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "채팅 API", description = "채팅 관련 API 입니다.")
@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    // 커미션 생성
    @Operation(summary = "채팅방 생성", description = "새로운 채팅방을 생성합니다.")
    @PostMapping
    public ResponseEntity<Long> createChat(@RequestBody @Valid ChatCreateRequest chatCreateRequest) {
        return ResponseEntity.ok(chatService.createChat(chatCreateRequest));
    }

//    // 모든 커미션 조회
//    @Operation(summary = "모든 커미션 조회", description = "모든 커미션을 조회합니다.")
//    @GetMapping
//    public ResponseEntity<List<CommissionResponseDTO>> getAllCommissions() {
//        List<CommissionResponseDTO> responseList = commissionService.commissionLists();
//        return ResponseEntity.ok(responseList);
//    }
//
//    // 커미션 단건 조회
//    @Operation(summary = "커미션 단건 조회", description = "커미션 ID를 기반으로 단건 커미션을 조회합니다.")
//    @GetMapping("/{commissionId}")
//    public ResponseEntity<CommissionResponseDTO> getCommission(@PathVariable Long commissionId) {
//        CommissionResponseDTO response = commissionService.getCommission(commissionId);
//        return ResponseEntity.ok(response);
//    }
//
//    // 커미션 수정
//    @Operation(summary = "커미션 수정", description = "커미션 ID를 기반으로 해당 커미션을 수정합니다.")
//    @PutMapping("/{commissionId}")
//    public ResponseEntity<CommissionResponseDTO> updateCommission(
//            @PathVariable Long commissionId,
//            @Valid @RequestBody CommissionRequestDTO commissionRequestDTO) {
//        CommissionResponseDTO response = commissionService.updateCommission(commissionId, commissionRequestDTO);
//        return ResponseEntity.ok(response);
//    }
//
//    // 커미션 삭제
//    @Operation(summary = "커미션 삭제", description = "커미션 ID를 기반으로 해당 커미션을 삭제합니다.")
//    @DeleteMapping("/{commissionId}")
//    public ResponseEntity<Void> deleteCommission(@PathVariable Long commissionId) {
//        commissionService.deleteCommission(commissionId);
//        return ResponseEntity.noContent().build();
//    }
}
