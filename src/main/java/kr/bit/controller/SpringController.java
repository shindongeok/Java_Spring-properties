package kr.bit.controller;


import kr.bit.beans.Data;
import kr.bit.beans.Data2;
import kr.bit.beans.Data3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class SpringController {

    @Autowired
    Data data1;  //RootAppContext에 Bean으로 등록한 Data주소값을 자동주입받고있다.(session영역)

    @Resource(name = "session2")
    Data2 data2;

    @Autowired
    Data3 data3;


    @GetMapping("/t1")
    public String t1(){
        data1.setStr1("aa");
        data1.setStr2("bb");
        data2.setStr3("cc");
        data2.setStr4("dd");
        data3.setStr5("ee");
        data3.setStr6("ff");

        return "test1";
    }

    @GetMapping("/s1")
    public String s1(Model model){
        model.addAttribute("data1",data1);
        model.addAttribute("data2",data2);
        model.addAttribute("data3",data3);
        return "spring1";
    }

}
