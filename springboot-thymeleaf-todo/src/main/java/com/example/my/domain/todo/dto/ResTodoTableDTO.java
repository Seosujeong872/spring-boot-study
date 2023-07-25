package com.example.my.domain.todo.dto;

import com.example.my.model.todo.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResTodoTableDTO {

    private List<Todo> todoList;
    private List<Todo> doneList;

    public static ResTodoTableDTO of(List<TodoEntity> todoEntityList) {
        return ResTodoTableDTO.builder()
                .todoList(
                        todoEntityList.stream()
                                .filter(todoEntity -> todoEntity.getDoneYn().equals('N'))
                                .map(todoEntity -> Todo.fromEntity(todoEntity))
                                .toList()
                )
                .doneList(
                        todoEntityList.stream()
                                .filter(todoEntity -> todoEntity.getDoneYn().equals('Y'))
                                .map(todoEntity -> Todo.fromEntity(todoEntity))
                                .toList()
                )
                .build();
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Todo {
        private Long idx;
        private String content;
        private Character doneYn;

        public static Todo fromEntity(TodoEntity todoEntity) {
            return Todo.builder()
                    .idx(todoEntity.getIdx())
                    .content(todoEntity.getContent())
                    .doneYn(todoEntity.getDoneYn())
                    .build();
        }
    }
}
