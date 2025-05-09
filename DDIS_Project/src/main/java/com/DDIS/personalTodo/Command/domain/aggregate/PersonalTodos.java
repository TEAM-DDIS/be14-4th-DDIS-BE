package com.DDIS.personalTodo.Command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "personal_todos")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonalTodos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_num", nullable = false)
    private Long todoNum;

    @Column(name = "todo_content", nullable = false)
    private String todoContent;

    @Column(name = "personal_category_num", nullable = true)
    private Long personalCategoryNum;

    @Column(name = "client_num", nullable = false)
    private Long clientNum;

    // 카테고리 연결 끊기
    public void detachCategory() {
        this.personalCategoryNum = null;
    }

    public void updateContent(String todoContent) {
        this.todoContent = todoContent;
    }
}
