package br.com.project.authentication.infra.security;

import br.com.project.authentication.common.ForbiddenException;
import br.com.project.authentication.common.ProfileType;
import br.com.project.authentication.common.ServiceContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrivilegesAspect {

    @Autowired
    private ServiceContext serviceContext;

    @Around("@annotation(Privileges)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        if (serviceContext.getCurrentUser().getProfile() != ProfileType.ADMIN)
            throw new ForbiddenException("Insufficient privileges.");

        return joinPoint.proceed();
    }
}
