package photoCurd.filter;

import photoCurd.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lixuefeng
 * @date 2021-08-23 21:37
 * @description:用户配置过滤器
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp=(HttpServletResponse)response;
        HttpServletRequest req=(HttpServletRequest) request;
        HttpSession session= req.getSession();
        User user= (User) session.getAttribute("user");
        //获取ip后的jsp
        String uri=req.getRequestURI();
        if(user==null){
            if(uri.endsWith("index.jsp")||uri.endsWith("index.do")||uri.endsWith("/User/login")){
                chain.doFilter(request,response);
            }else{
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
            }
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
