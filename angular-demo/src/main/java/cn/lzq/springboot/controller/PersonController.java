package cn.lzq.springboot.controller;

import cn.lzq.springboot.po.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-21 15:44
 */
@RestController
public class PersonController {

    @RequestMapping(value="/search",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName){
        Person person = new Person();
        person.setAddress("北京");
        person.setAge(22);
        person.setName(personName);
        return person;
    }
}
