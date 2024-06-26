package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorPatternClient {
    private final Component component;

    public DecoratorPatternClient(final Component component) {
        this.component = component;
    }

    public void execute() {
        final String result = component.operation();
        log.info("result={}", result);
    }
}
