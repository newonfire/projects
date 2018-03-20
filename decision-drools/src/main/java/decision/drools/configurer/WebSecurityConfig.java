package decision.drools.configurer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.druid.support.json.JSONUtils;

import decision.drools.core.Result;
import decision.drools.core.ResultCode;
import decision.drools.core.ResultGenerator;

/**
 * 登录配置 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

	/**
	 * 登录session key
	 */
	public final static String SESSION_KEY = "user";

	@Bean
	public SecurityInterceptor getSecurityInterceptor() {
		return new SecurityInterceptor();
	}

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

		// 排除配置
		addInterceptor.excludePathPatterns("/error");
		addInterceptor.excludePathPatterns("/login**");

		// 拦截配置
		addInterceptor.addPathPatterns("/**");
	}

	private class SecurityInterceptor extends HandlerInterceptorAdapter {

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			HttpSession session = request.getSession();
			if (session.getAttribute(SESSION_KEY) != null)
				return true;

			Result result = ResultGenerator.genFailResult(ResultCode.UNLANDED.code, "未登陆");
			String rs_str = JSONUtils.toJSONString(result);

			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.append(rs_str);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}

			// 跳转登录
			// String url = "login";
			// response.sendRedirect(url);

			return false;
		}
	}
}
