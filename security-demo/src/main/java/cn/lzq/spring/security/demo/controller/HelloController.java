package cn.lzq.spring.security.demo.controller;

import cn.lzq.spring.security.demo.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-31 14:30
 */

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(Model model){
        Msg msg = new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg",msg);
        return "index";
    }
}
