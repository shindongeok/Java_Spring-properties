package kr.bit.controller;





import kr.bit.beans.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class SpringController {

    @GetMapping("/t1")
    public String t1(){
        return "test1";
    }

    @PostMapping("test1_proc") //form에 쓴 값이 주입됨
    public String test1_proc(@Valid Data data, BindingResult result){
        //@Valid : 메소드에 주입받는 Bean에 유효성 검사를 하겠다는 선언!!!
        //BindingResult : 유효성 검사를 실행한 결과정보가 저장되어 있음 -> jsp파일

        //코드.이름.메세지
        if(result.hasErrors()){
            for(ObjectError obj: result.getAllErrors()){
                System.out.println("코드 : " + obj.getCode());
                System.out.println("이름 : " + obj.getObjectName());
                System.out.println("메세지 : " + obj.getDefaultMessage());

                String []str = obj.getCodes();  //str[0] : 코드.이름.필드명
                                                //str[1] : 코드.필드명
                                                //str[2] : 코드.자료형
                                                //str[3] : 코드
                for(String s:str){
                    System.out.println(s);
                }
                if(str[0].equals("Size.data.num2")){
                    System.out.println("num2 글자수 졷나 잘못됨!! 다시작서앟세요!");
                }
                else if(str[0].equals("Max.data.num1")){
                    System.out.println("num1 값 최대 100이야 다시작성해!");
                }
            }
            return "test1"; //유효성 검사 위배되면 다시 form형태로 감
        }
        return "test2"; // 유효성검사에 맞으면 test2.jsp가서 내가 입력한 값을 띄운다.
    }



}
