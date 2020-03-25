package br.ucsal.sistema.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.sistema.model.Usuario;

/**
 * Servlet Filter implementation class AcessoFilter
 */
//@WebFilter(urlPatterns = {"/dashboard.jsp", "/usuario.jsp"})
@WebFilter("/private/*")
public class AcessoFilter implements Filter {


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		System.out.println("FILTREI: " + httpServletRequest.getRequestURL());
		
		
		Object object = httpServletRequest.getSession().getAttribute("USUARIO");
		
		if(object != null) {
			Usuario usuario = (Usuario) object;
			System.out.println(usuario.getLogin());

			chain.doFilter(request, response);

		}else {
			System.out.println("SEM USUARIO NA SESSION");
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect("/sistema/index.jsp?erro=Usuario não logado");
		}
		
	}



}
