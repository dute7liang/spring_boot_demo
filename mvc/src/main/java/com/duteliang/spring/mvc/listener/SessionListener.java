package com.duteliang.spring.mvc.listener;

import com.duteliang.spring.mvc.constanst.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

/**
 * @Description: session监听器
 * @Auther: zl
 * @Date: 2018-8-31 11:36
 */
@WebListener
@Slf4j
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		log.info("sessionCreated");
		HttpSession session = se.getSession();
		Object attribute = session.getAttribute(Constants.SESSION_STATUS);
		Object attribute1 = session.getAttribute(Constants.SESSION_USER_ID);
		log.info(attribute == null ? "" : attribute.toString());
		log.info(attribute1 == null ? "" : attribute1.toString());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		log.info("sessionDestroyed");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		log.info("attributeAdded");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		log.info("attributeRemoved");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		log.info("attributeReplaced");
	}
}
