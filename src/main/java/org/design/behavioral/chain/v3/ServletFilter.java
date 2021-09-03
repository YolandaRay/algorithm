package org.design.behavioral.chain.v3;

import java.util.ArrayList;
import java.util.List;

/*
需求：
    处理request，response
    请求过来的时候是HtmlFilter处理、SensitiveFilter处理、ScriptFilter处理。
    响应返回的时候是ScriptFilter处理、SensitiveFilter处理、HtmlFilter处理。
 */
public class ServletFilter {
    public static void main(String[] args) {
        Request request = new Request();
        request.requestStr = "I am request ";
        Response response = new Response();
        response.responseStr = "I am response ";
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter()).add(new SensitiveFilter()).add(new ScriptFilter());
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.requestStr);
        System.out.println(response.responseStr);
    }
}

class Request {
    String requestStr;
}

class Response {
    String responseStr;
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain filterChain);
}

class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.requestStr = request.requestStr + " | HtmlFilter deal!";
        filterChain.doFilter(request, response, filterChain);
        response.responseStr = response.responseStr + " | HtmlFilter deal!";
        return true;
    }
}

class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.requestStr = request.requestStr + " | SensitiveFilter deal!";
        filterChain.doFilter(request, response, filterChain);
        response.responseStr = response.responseStr + " |  SensitiveFilter deal!";
        return true;
    }
}

class ScriptFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.requestStr = request.requestStr + " | ScriptFilter deal!";
        filterChain.doFilter(request, response, filterChain);
        response.responseStr = response.responseStr + " | ScriptFilter deal!";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<Filter>();
    int index = 0;

    FilterChain add(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size()) return false;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request, response, filterChain);
        return true;
    }
}