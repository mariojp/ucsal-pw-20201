package br.ucsal.sistema.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class PerformanceFilter implements Filter{


	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long tempoInicial = new Date().getTime();
		chain.doFilter(request, response);
		long tempoFinal = new Date().getTime();
		System.out.println("PERFORMANCE FILTER : "+ ( tempoFinal-tempoInicial ) );
	}

}
