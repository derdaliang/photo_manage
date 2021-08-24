package photoCurd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import photoCurd.bean.Msg;
import photoCurd.bean.User;
import photoCurd.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lixuefeng
 * @date 2021-08-21 20:19
 * @description:用户相关的控制
 */
@Controller
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model model,
                              HttpServletRequest request){
        if(userService.checkLogin(email,password)){
            User user=userService.getUserByEmail(email);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("redirect:/User/UserDept");
        }else{
            model.addAttribute("Login_Msg","登陆失败");
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping("/UserDept")
    public ModelAndView reGoToUserDep(){

        return new ModelAndView("/UserDept");
    }

    @ResponseBody
    @RequestMapping(value = "/checkUser",method = RequestMethod.GET)
    public Msg checkUserEmail(@RequestParam("email")String email){
        String Email = "[a-zA-Z0-9]{3,20}@([a-zA-Z0-9]{2,10}|[a-zA-Z0-9]{2,10}[.][a-zA-Z0-9]{2,10})[.](com|cn|net)";
        Pattern pattern=Pattern.compile(Email);
        Boolean flag=pattern.matcher(email).matches();
        if (!flag) {
            return Msg.fail().add("email_check_msg","邮箱格式错误");
        }
        if (userService.getUserByEmail(email)!=null){
            return Msg.fail().add("email_check_msg","用户邮箱已存在");
        }
        return Msg.success();
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public Msg addUser(User user){
        userService.addUser(user);
        return Msg.success();
    }
    @ResponseBody
    @RequestMapping(value = "/UserDept/{id}",method = RequestMethod.DELETE)
    public Msg delete(@PathVariable("id")Integer id){
        userService.deleteUser(id);
        return Msg.success();
    }
    @ResponseBody
    @RequestMapping(value = "/UserDept",method = RequestMethod.PUT)
    public Msg update(User user){
        userService.updateUser(user);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "getAllUser",method = RequestMethod.GET)
    public Msg selectAllUser(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<User> list=userService.getAll();
        PageInfo pageInfo=new PageInfo(list,5);
        return Msg.success().add("Users",pageInfo);
    }
}
