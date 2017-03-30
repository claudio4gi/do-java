package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProductDAO;

/**
 * Objetivo principal desta classe é expor para a Servlet do Spring MVC quais são as classes que
 * devem ser lidas e carregadas.
 * 
 * @author Claudio.Costa
 *
 */
@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProductDAO.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	/**
	 * O objetivo deste método é informar onde as páginas devem ser encontradas.
	 *
	 * @return Objeto configurado para o Spring MVC.
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

}
