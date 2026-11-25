package org.msa.msa5spring.error;

import org.msa.msa5spring.response.GlobalResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class) // Exception 만 적으면 데이터 타입으로 인식하기 때문에 .class를 붙여줘야 함
    public ResponseEntity<GlobalResponseDTO<Void>> handle() {
        return ResponseEntity
                .status(500)
                .body(
                        new GlobalResponseDTO<>(
                                "E99",
                                "시스템 에러",
                                null
                        )
                );
    }
}
