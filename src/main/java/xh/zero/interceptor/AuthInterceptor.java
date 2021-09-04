package xh.zero.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import xh.zero.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return true;
        } else  {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
    }
}
