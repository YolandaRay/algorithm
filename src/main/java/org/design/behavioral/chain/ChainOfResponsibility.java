package org.design.behavioral.chain;

import java.util.ArrayList;
import java.util.List;

/*
责任链模式（Chain of Responsibility Pattern）
很多设计模式的区别不是语法的区别，而是语义的区别。
最难的是proxy，其次是chain of responsibility，Reactor 也当作设计模式。
所谓设计模式 就是把简单问题复杂化，那部分变化封装那部分。"封装变化"
设计模式的大部分都是利用Java多态，多态是Java面向对象的核心。

需求：
    在公众号上发表文章，后台要经过处理才能发表和存如数据库，每个处理策略都要检查一遍。

 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Article article = new Article();
        article.setArticle("Hello every one,(--)<script> This is a sensitive word! 666");
        //java是值传递，函数调用的时候如果是基本类型，传值的copy，如果是引用类型，传的是引用类型地址的copy

        //version 1 需要过滤文章中恶意脚本和敏感词
        /*
        String str = article.getArticle();
        //过滤恶意脚本
        str = str.replace("<","[");
        str = str.replace(">","]");
        //过滤敏感词
        str = str.replace("sensitive","*");
        article.setArticle(str);
        System.out.println(article);
         */

        //version 2 将过滤策略封装到Filter类中
        /*
        Filter scriptFilter = new ScriptFilter();
        scriptFilter.doFilter(article);
        Filter sensitiveFilter = new SensitiveFilter();
        sensitiveFilter.doFilter(article);
        System.out.println(article);
        */

        //version 3  借助list，形成链
        /*
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(new ScriptFilter());
        filters.add(new SensitiveFilter());
        filters.add(new ExpressionFilter());
        filters.add(new NumberFilter());
        for(Filter f:filters){
            f.doFilter(article);
        }
        System.out.println(article);
        */

        //version 4 filter chain，与version相比，只不过把add 和遍历方法放到FilterChainV1中了。
        //编程小技巧：将Filter们构成链条，链式编程。
        /*
        FilterChainV1 chainV1 = new FilterChainV1();
        chainV1.add(new ScriptFilter()).add(new NumberFilter());
        chainV1.doFilter(article);
        System.out.println(article);

        FilterChainV1 chainV2 = new FilterChainV1();
        chainV2.add(new ExpressionFilter()).add(new SensitiveFilter());
        chainV2.doFilter(article);
        System.out.println(article);
        */
        /*
        version 5 FilterChain其实自己也是一个Filter，像递归。
        FilterChainV2 implements Filter

        FilterChainV2 chainV21 = new FilterChainV2();
        chainV21.add(new ScriptFilter()).add(new NumberFilter());

        FilterChainV2 chainV22 = new FilterChainV2();
        chainV22.add(new ExpressionFilter()).add(new SensitiveFilter());

        chainV21.add(chainV22);
        chainV21.doFilter(article);
        System.out.println(article);
        */
        /*
        version 6 由FilterChain中的某一个Filter决定链条是否继续。Filter中增加返回值，继续返回true，终止返回false。
        判断逻辑放在FilterChain中不合适，由Filter自己决定是否继续更合理。
        因为扩展Filter的时候，应该由扩展的Filter决定是否继续，不用修改FilterChain。
        */
        FilterChin chain = new FilterChin();
        chain.add(new ScriptFilter()).add(new NumberFilter()).add(new ExpressionFilter()).add(new SensitiveFilter());
        chain.doFilter(article);
        System.out.println(article);


    }
}

class Article {
    public String article;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article='" + article + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Article article);
}

class ScriptFilter implements Filter {

    @Override
    public boolean doFilter(Article article) {
        System.out.println("Exec ScriptFilter");
        //过滤恶意脚本
        String str = article.getArticle();
        str = str.replace("<", "[");
        str = str.replace(">", "]");
        article.setArticle(str);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Article article) {
        System.out.println("Exec SensitiveFilter");
        //过滤敏感词
        String str = article.getArticle();
        str = str.replace("sensitive", "*");
        article.setArticle(str);
        return false;
    }
}

class ExpressionFilter implements Filter {

    @Override
    public boolean doFilter(Article article) {
        System.out.println("Exec ExpressionFilter");
        //过滤表情
        String str = article.getArticle();
        str = str.replace("(--)", "@");
        article.setArticle(str);
        return true;
    }
}

class NumberFilter implements Filter {

    @Override
    public boolean doFilter(Article article) {
        System.out.println("Exec NumberFilter");
        //过滤数字
        String str = article.getArticle();
        str = str.replaceAll("\\d", "000");
        article.setArticle(str);
        return true;
    }
}

class FilterChainV1 {
    List<Filter> filters = new ArrayList<Filter>();

    ////编程小技巧：return FilterChain，将FilterChain形成链 类似StringBuffer.append();
    public FilterChainV1 add(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    public void doFilter(Article article) {
        for (Filter f : filters) {
            f.doFilter(article);
        }
    }
}

class FilterChainV2 implements Filter {
    List<Filter> filters = new ArrayList<Filter>();

    ////编程小技巧：return FilterChain，将FilterChain形成链 类似StringBuffer.append();
    public FilterChainV2 add(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    public boolean doFilter(Article article) {
        for (Filter f : filters) {
            f.doFilter(article);
        }
        return true;
    }
}

class FilterChin implements Filter {
    List<Filter> filters = new ArrayList<Filter>();

    FilterChin add(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Article article) {
        for (Filter f : filters) {
            if (!f.doFilter(article)) ;
            return false;
        }
        return true;
    }
}
/*
1.replace的参数是char和CharSequence,即可以支持字符的替换,也支持字符串的替换(CharSequence即字符串序列的意思,说白了也就是字符串);
2.replaceAll的参数是regex或者char,即基于规则表达式的替换,比如,可以通过replaceAll("\\d", "*")把一个字符串所有的数字字符都换成星号;
相同点是都是全部替换,即把源字符串中的某一字符或字符串全部换成指定的字符或字符串。
如果只想替换第一次出现的,可以使用replaceFirst(),这个方法也是基于规则表达式的替换,但与replaceAll()不同的时,只替换第一次出现的字符串;
另外,如果replaceAll()和replaceFirst()所用的参数据不是基于规则表达式的,则与replace()替换字符串的效果是一样的,即这两者也支持字符串的操作;
 */