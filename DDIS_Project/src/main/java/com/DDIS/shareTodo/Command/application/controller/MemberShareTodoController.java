package com.DDIS.shareTodo.Command.application.controller;

import com.DDIS.shareTodo.Command.application.dto.CompleteTodoRequest;
import com.DDIS.shareTodo.Command.application.dto.MemberShareTodoResponseDTO;
import com.DDIS.shareTodo.Command.application.service.MemberShareTodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member-share-todo")
@RequiredArgsConstructor
public class MemberShareTodoController {

    private final MemberShareTodoService memberShareTodoService;

    // ✅ 공동투두 완료 체크
    @PostMapping("/complete")
    public ResponseEntity<Void> completeTodo(@RequestBody CompleteTodoRequest request) {
        memberShareTodoService.completeTodo(request.getMemberShareTodoNum());
        return ResponseEntity.ok().build();
    }

    // ✅ 공동투두 완료 취소 (선택)
    @PostMapping("/uncomplete")
    public ResponseEntity<Void> uncompleteTodo(@RequestBody CompleteTodoRequest request) {
        memberShareTodoService.uncompleteTodo(request.getMemberShareTodoNum());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/client/{clientNum}")
    public ResponseEntity<List<MemberShareTodoResponseDTO>> getMemberShareTodosByMember(@PathVariable Integer clientNum){
        List<MemberShareTodoResponseDTO> result = memberShareTodoService.getByClientNum(clientNum);
        return ResponseEntity.ok(result);
    }


}
