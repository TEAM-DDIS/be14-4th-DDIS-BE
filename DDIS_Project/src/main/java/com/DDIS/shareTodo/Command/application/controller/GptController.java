package com.DDIS.shareTodo.Command.application.controller;

import com.DDIS.approve.Command.application.dto.GenerateTodoRequest;
import com.DDIS.shareTodo.Command.application.dto.MemberShareTodoResponseDTO;
import com.DDIS.shareTodo.Command.application.service.RoomService;
import com.DDIS.shareTodo.Command.domain.aggregate.Entity.ShareTodo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gpt")
@RequiredArgsConstructor
public class GptController {

    private final RoomService roomService;

    @PostMapping("/generate-todos")
    public ResponseEntity<List<MemberShareTodoResponseDTO>> generateAndAssignTodos(@RequestBody GenerateTodoRequest request) {
        List<MemberShareTodoResponseDTO> result = roomService.generateAndSaveGptTodos(request.getRoomNum(), request.getTopic());
        return ResponseEntity.ok(result);
    }
}
