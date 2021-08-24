package photoCurd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author lixuefeng
 * @date 2021-08-21 16:38
 * @description:
 */
@Controller
public class Hello {

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable("name")String name , Map<String,Object> map){
        map.put("name",name);
        return "UserDept";
    }

    @RequestMapping("/hello")
    public ModelAndView hello(@RequestParam("name") String name, Map<String,Object> map){
        map.put("name",name);
        return new ModelAndView("/index");
    }
}
