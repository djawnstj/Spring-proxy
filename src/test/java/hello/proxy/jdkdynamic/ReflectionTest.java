package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    public void reflection0() throws Exception {
        final Hello target = new Hello();

        // 공통 로직 1 시작
        log.info("start");
        final String result1 = target.callA();
        log.info("result={}", result1);
        // 공통 로직 1 종료

        // 공통 로직 2 시작
        log.info("start");
        final String result2 = target.callB();
        log.info("result={}", result2);
        // 공통 로직 2 종료
    }

    @Test
    public void reflection1() throws Exception {
        // 클래스 정보
        final Class<?> classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        final Hello target = new Hello();
        // callA 메서드 정보
        final Method methodCallA = classHello.getMethod("callA");
        final Object result1 = methodCallA.invoke(target);
        log.info("result1={}", result1);

        // callB 메서드 정보
        final Method methodCallB = classHello.getMethod("callB");
        final Object result2 = methodCallB.invoke(target);
        log.info("result2={}", result2);
    }

    @Test
    public void reflection2() throws Exception {
        // 클래스 정보
        final Class<?> classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        final Hello target = new Hello();
        // callA 메서드 정보
        final Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        // callB 메서드 정보
        final Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(final Method method, final Object target) throws Exception {
        log.info("start");
        final Object result = method.invoke(target);
        log.info("result={}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }

}
