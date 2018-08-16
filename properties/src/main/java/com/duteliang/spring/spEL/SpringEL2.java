package com.duteliang.spring.spEL;

import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-16 14:58
 */
public class SpringEL2 {

	public void test(){
		SpelExpressionParser parser = new SpelExpressionParser();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
		ctx.refresh();
//		Expression exp = parser.parseExpression("i.ss #{@userService.dataDetail(#name)} ", new TemplateParserContext());
		Expression exp = parser.parseExpression("i.ss #{@nameService.getString()} ", new TemplateParserContext());
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setBeanResolver(new BeanFactoryResolver(ctx));
		context.setVariable("name", "name");
		Object value = exp.getValue(context);
		System.out.println(value);
	}


}
