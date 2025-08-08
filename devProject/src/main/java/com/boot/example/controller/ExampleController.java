package com.boot.example.controller;

import com.boot.example.domain.ExampleDTO;
import com.boot.example.domain.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/example")  // 공통주소 잡기. 전부 '/example'로 맵핑 잡겠다.
public class ExampleController {

    @GetMapping("/exam01") // '/example/exam01'
    public String example(Model model){
        model.addAttribute("data", "현재 페이지에 출력 데이터"); //속성은 데이터(변수명), 값은 문자열
        return "/example/exam01";  //example 폴더에 exam01 파일을 model로 열겠다. (포워드)
    }

    @GetMapping("/form")
    public String form(){
        return "example/form";
    }

    @GetMapping("/exam03")
    //public String exam03(@RequestParam String name, @RequestParam int age, Model model){
    public String exam03(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") int age, Model model){  //나이는 필수가 아니다. 입력 안할시 0으로 처리.
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "example/exam03";
    }

    // @ModelAttribute는 전달받은 파라미터를 Model에 담아서 전달하는 어노테이션
    @PostMapping("/exam04")
    //public String exam04(@ModelAttribute SampleDTO dto, Model model){
    public String exam04(@ModelAttribute SampleDTO dto){

        //model.addAttribute("dto", dto);
        return "example/exam04";
    }

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("data1", "뷰에 출력할 데이터");
        model.addAttribute("data2", "뷰에 출력할 <strong>데이터</strong>");

        model.addAttribute("number", 3);

        model.addAttribute("data", "Spring!");

        model.addAttribute("auth", "admin");

        ExampleDTO exampleDTO = new ExampleDTO();
        exampleDTO.setName("홍길동");
        exampleDTO.setAge(38);
        exampleDTO.setEmail("javauser@naver.com");
        model.addAttribute("exampleDTO", exampleDTO);

        List<ExampleDTO> list = new ArrayList<>();
        list.add(new ExampleDTO("김철수", 26, "spinguser@naver.com"));
        list.add(new ExampleDTO("한늘봄", 32, "jsp1234@gmail.com"));
        model.addAttribute("list", list);
        Map<Integer, ExampleDTO> map = new HashMap<>();
        map.put(1, new ExampleDTO("김미숙", 30, "javauser@naver.com"));
        map.put(2, new ExampleDTO("조한미", 23, "bootuser@naver.com"));
        model.addAttribute("map", map);

        model.addAttribute("localDateTime", LocalDateTime.now());

        return "example/test";
    }
//
//    @GetMapping("/exam02")
//    //public String exam02(Model model, @RequestParam String language, @RequestParam String word){
//    public String exam01(Model model,
//                         @RequestParam(required = false, defaultValue = "java") String language,
//                         @RequestParam(required = false) String word){
//        model.addAttribute("language", language);
//        model.addAttribute("word", word);
//
//        return "example/exam02";
//    }
}
