package br.com.project.authentication.infra.security;

import br.com.project.authentication.common.ServiceContext;
import br.com.project.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Component
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ServiceContext serviceContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .ifPresent(context -> repository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                        .ifPresent(user -> serviceContext.setCurrentUser(user)));

        chain.doFilter(request, response);
    }
}
