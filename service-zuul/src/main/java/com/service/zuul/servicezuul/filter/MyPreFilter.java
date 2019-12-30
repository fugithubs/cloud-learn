package com.service.zuul.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName MyPreFilter
 * @Description TODO
 * @date 2019/12/28 14:00
 **/
@Component
public class MyPreFilter extends ZuulFilter {
    /**
     * 过滤器类型 - 路由之前
     */
    protected static final String FILTERTYPE_PRE = "pre";
    /**
     * 过滤器类型 - 路由之时
     */
    protected static final String FILTERTYPE_ROUTING = "routing";
    /**
     * 过滤器类型 - 路由之后
     */
    protected static final String FILTERTYPE_POST = "post";
    /**
     * 过滤器类型 - 发送错误调用
     */
    protected static final String FILTERTYPE_ERROR = "error";

    @Override
    public String filterType() {
        return FILTERTYPE_PRE;
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
     * 是否要过滤：这里可以写逻辑判断，本文true，永远过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        System.out.println(String.format("%s>>>%s", request.getMethod(), request.getRequestURL().toString()));
        String parameter = request.getParameter("token");
        if (parameter == null) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("parameter is empty");
            } catch (IOException e) {
            }
        }
        return null;
    }
}
