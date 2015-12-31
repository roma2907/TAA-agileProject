package fr.istic.agileProjet.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void before(final JoinPoint joinPoint) throws Throwable {
        logger.info("controlleur : " + joinPoint.getSignature().getDeclaringType().getSimpleName()
                + ", method: " + joinPoint.getSignature().getName());
    }
}
