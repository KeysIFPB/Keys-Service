package servico;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import controller.AdmController;
import controller.AlunoController;

public class RestEasyApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public RestEasyApplication() {
		
		// Multiple client-request: Cross-Filter
		CorsFilter filter = new CorsFilter();
		filter.getAllowedOrigins().add("*");
		filter.setAllowedMethods("POST, GET, DELETE, PUT, OPTIONS");
		filter.setAllowedHeaders("Content-Type, Authorization");
		
		this.singletons.add(filter);
		
		// Controllers disponíveis no serviço.
		this.singletons.add(new AlunoController());
		this.singletons.add(new AdmController());	
	}

	public Set<Class<?>> getClasses() {
		return this.empty;
	}

	public Set<Object> getSingletons() {
		return this.singletons;
	}
}