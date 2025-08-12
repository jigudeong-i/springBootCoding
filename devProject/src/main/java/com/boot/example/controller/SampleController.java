package com.boot.example.controller;

import com.boot.example.domain.ExampleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController     // 포워드 안 하고 모든 페이지 데이터 주겠다.
@RequestMapping("/sample")   // 공통 맵핑
public class SampleController {

    //@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    @GetMapping(value = "/getText", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getText(){
        return "안녕하세요?";
    }

    //@GetMapping(value = "/getExample", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getExample")
    public ExampleVO getSample(){
        return new ExampleVO(1, "홍길동", "010-4568-7785");
    }

    @GetMapping("/getList")
    public List<ExampleVO> getList() {
        List<ExampleVO> list = new ArrayList<>();
        list.add(new ExampleVO(1, "홍길동", "010-6703-1209"));
        list.add(new ExampleVO(2, "한늘봄", "010-9427-8930"));
        list.add(new ExampleVO(3, "이진희", "010-1295-4510"));
        list.add(new ExampleVO(4, "박철희", "010-3492-6711"));

        return list;
    }

    @GetMapping(value = "/getMap", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, ExampleVO> getMap() {
        Map<String, ExampleVO> map = new HashMap<>();
        map.put("First", new ExampleVO(5, "이진수", "010-2356-3390"));

        return map;
    }
}
