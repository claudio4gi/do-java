package br.com.project.authentication.infra.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("br.com.project.authentication")
@EnableAspectJAutoProxy
public class AspectConfiguration {
}

