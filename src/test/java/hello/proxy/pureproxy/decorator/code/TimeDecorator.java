package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component {
    private final Component component;

    public TimeDecorator(final Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");

        final long startTime = System.currentTimeMillis();

        final String result = component.operation();

        final long endTime = System.currentTimeMillis();
        final long resultTime = endTime - startTime;
        log.info("TimeDecorator 종료. resultTime={}ms", resultTime);

        return result;
    }
}
