package com.example.my.domain.todo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ReqTodoTableUpdateDoneYnDTO {

    @Valid
    @NotNull(message = "내용을 양식에 맞게 입력해주세요.")
    private Todo todo;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Todo {
        @NotNull(message = "완료 여부를 입력해주세요.")
        // 캐릭터 대신 문자열을 사용해야 패턴이나 NotBlank, NotEmpty 등의 어노테이션을 사용할 수 있음
        // @Pattern(regexp = "^[NY]$", message = "doneYn은 N 또는 Y로 입력해주세요.")
        private Character doneYn;
    }

}
