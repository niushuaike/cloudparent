package com.nsk.improve.springcloud.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author Niusk
 * @create 2018/10/31
 */
@Component
public class MyFilter extends ZuulFilter {

    /**
     * 返回一个字符串用来代表过滤的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre:路由之前
     * routing: 路由之时
     * post：路由之后
     * error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 可以写逻辑来判断是否进行过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURI()));
        String token = request.getParameter("token");
        if (token == null) {
            System.out.println("token is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("token is is empty");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
        System.out.println("ok");
        return null;
    }
}
