package com.dom.apiRest.apiRestFull.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UsuarioAspect {
	public UsuarioAspect() {}
	
	@Before("execution(public * getUsuario(*))")//Toma todos los metodos de getusuarios que tienen el mismo nombre
	public void interceptorGetUsuario(JoinPoint jp) { 
		System.out.println("Ingresando al metodo Usuario");
		System.out.println(jp.getSignature());
		System.out.println("Con los parametros: " + jp.getArgs()[0]);
		
		
	}

}
