package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        final long startTime = System.currentTimeMillis();

        final Object result = invocation.proceed();

        final long endTime = System.currentTimeMillis();
        final long resultTime = endTime - startTime;

        log.info("TimeProxy 종료, resultTime={}", resultTime);

        return result;
    }
}
