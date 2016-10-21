package cn.lzq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lzq.po.Person;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootDemoApplication {
	
	@RequestMapping("/index")
	public String index(Model model){
		Person single = new Person("zhangsan",10);
		
		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("lisi",11);
		Person p2 = new Person("wangwu",12);
		Person p3 = new Person("zhaoliu",13);
		
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);
		return "index";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class,args);
	}
}
