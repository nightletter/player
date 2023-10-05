package me.nightletter.video;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class InitializeFilter implements Filter {

	private final String USER_COOKIE_PREFIX = "userId";

	@Override
	public void init( FilterConfig filterConfig ) throws ServletException {
		Filter.super.init( filterConfig );
	}

	@Override
	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = ( HttpServletRequest ) request;
		HttpServletResponse httpServletResponse = ( HttpServletResponse ) response;

		Arrays.stream( httpServletRequest.getCookies() )
			.forEach( cookie -> {
				String getUserId = cookie.getAttribute( USER_COOKIE_PREFIX );

				if (getUserId == null || getUserId.isEmpty()) {
					Cookie newCookie = new Cookie( USER_COOKIE_PREFIX, "1" );
					newCookie.setMaxAge( Integer.MAX_VALUE );

					httpServletResponse.addCookie( newCookie );
				}
			} );

		chain.doFilter( request, response );
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
