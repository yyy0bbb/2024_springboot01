package com.ict.edu2;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class SampleController {

    //반환형이 String일 때 > 브라우저에 String 자체가 풀력됨
    @GetMapping("/hello")
    public String getHello() {
        return "Hello, world";
    }

    //반환형이 String[]일 때 > 자동으로 json 형식을 가지고 출력
    @GetMapping("/hello2")
    public String[] getHello2() {
        return new String[]{"Hello", "World"};
    }
    
    // 반환형이 객체 일 때 똑같이 json형식으로 나옴
    @GetMapping("/hello3")
    public SampleVO getHello3() {
        SampleVO svo = new SampleVO();
        svo.setName("고길동");
        svo.setAge("24");

        return svo;
    }
    
    // 반환형이 객체 일 때 똑같이 json형식으로 나옴
    @GetMapping("/hello4")
    public List<SampleVO> getHello4() {
        List<SampleVO> list = new ArrayList<>();

        SampleVO svo = new SampleVO();
        svo.setName("고길동");
        svo.setAge("24");
        list.add(svo);

        SampleVO svo2 = new SampleVO();
        svo2.setName("홍길동");
        svo2.setAge("21");
        list.add(svo2);

        SampleVO svo3 = new SampleVO();
        svo3.setName("강길동");
        svo3.setAge("11");
        list.add(svo3);


        return list;
    }

    @GetMapping("/hello5")
    public DataVO getHello5(String number) {
        DataVO dataVO = new DataVO();

        List<SampleVO> list = new ArrayList<>();

        SampleVO svo = new SampleVO("고길동","24");
        SampleVO svo2 = new SampleVO("강길동","11");
        SampleVO svo3 = new SampleVO("김길동","33");
        list.add(svo);
        list.add(svo2);
        list.add(svo3);

        if(number.equals("1")){
            // dataVO.setResultCode(1);
            // dataVO.setMessage("성공");
            // dataVO.setData(list);

            return DataVO.success(list, "성공");

        }else{
            // dataVO.setResultCode(0);
            // dataVO.setMessage("실패");
            // dataVO.setData(null);

            return DataVO.fail(0, "실패");
        }

       
    }


    //반환형이 객체일 때
    @PostMapping("/hi")
    public String getHi() {
       
        
        return "hi, 안녕, ㅎㅇㅎㅇㅎㅇ" ;
    }
    
    @PostMapping("/hi2")
    public String[] getHi2(String idx) {
        return new String[] {"Hello", "World"};
    }
    
    
}
