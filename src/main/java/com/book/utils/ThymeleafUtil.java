package com.book.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.Writer;

/**
 * @Author: shlin
 * @Date: 2022/12/5 - 12 - 05 - 20:51
 * @Description: com.book.servlet.utils
 * @Version: 1.0
 */
public class ThymeleafUtil {

    private static final TemplateEngine engine;
    static  {
        engine = new TemplateEngine();
        ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
        r.setCharacterEncoding("UTF-8");
        engine.setTemplateResolver(r);
    }

    public static void process(String template, IContext context, Writer writer){
        engine.process(template, context, writer);
    }
}