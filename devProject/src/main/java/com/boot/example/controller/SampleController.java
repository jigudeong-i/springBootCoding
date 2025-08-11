package com.boot.example.controller;

import com.boot.example.domain.ExampleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // 포워드 안 하고 모든 페이지 데이터 주겠다.
@RequestMapping("/sample")   // 공통 맵핑
public class SampleController {

    //@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    @GetMapping(value = "/getText", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getText(){
        return "안녕하세요?";
    }

    @GetMapping("/getExample")
    public ExampleVO getSample(){
        return new ExampleVO(1, "홍길동", "010-4568-7785");
    }
}
