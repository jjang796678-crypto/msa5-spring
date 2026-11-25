package org.msa.msa5spring.request;

import jakarta.validation.constraints.*;

public record RegistrationRequestDTO(
        @NotBlank(message = "이메일 필수")
        @Pattern(regexp = "^[a-z]{4,8}$", message = "이메일 패턴 틀림")
        String email,

        @NotBlank(message = "비밀번호 필수")
        @Size(min = 2, max = 10, message = "비밀번호는 2~10자")
        String password,

        String name,

        @Min(value = 0, message = "최소 나이는 0살입니다.")
        @Max(value = 999, message = "최대 나이는 999살입니다.")
        Integer age
        ) {}
