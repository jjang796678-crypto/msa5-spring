package org.msa.msa5spring.controller;

import org.msa.msa5spring.request.QueryRequestDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
// 클래스 레벨의 리퀘스트 맵핑으로 프리 픽스(접두사) 관리
@RequestMapping("/api")
public class RequestMappingController {
    @GetMapping// @RequestMapping 으로 인해 ("/users")가 생략되어 있음
    public String index() {
        return "유저 조회";
    }

    @PostMapping
    public String store() {
        return "유저 생성";
    }

    @PutMapping
    public String update() {
        return "유저 수정";
    }

    @DeleteMapping
    public String destroy() {
        return "유저 삭제";
    }

    @GetMapping("/query")
    public String query(QueryRequestDTO queryRequestDTO) {
        return String.format("%d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }
    @GetMapping("/segment/{id}/{name}")
    public String segment(@ModelAttribute QueryRequestDTO queryRequestDTO) {
        return String.format("segment = %d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }

    // 세그먼트 파라미터를 이용한 Path 와 겹치지 안도록 주의
    // @GetMapping("/segemnt/1/my")
    // public String test() {
    //     return "Test";
    // }

    @PostMapping("/form")
    public String form(@ModelAttribute MultipartFile file) {
        return String.format("%s : %s", file.getContentType(), file.getOriginalFilename());
    }

    @GetMapping("/json")
    public String json(@RequestBody QueryRequestDTO queryRequestDTO) {
        return String.format("json = %d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }
}
// Query Parameter 방식
// - 어노테이션 X, DTO 객체 생성 // @RequestParam 이 디폴트값임

// Segment Parameter 방식
// - @PathVariable, 각 키에 맞는 파라미터를 별도로 맵핑 메소드의 파라미터로 생성
// - @ModelAttribute, DTO 객체 생성

// Form Data 방식
// - @ModelAttribute, DTO 객체 또는 맵핑 메소드의 파라미터

// JSON 방식
// - @RequestBody, DTO 객체
