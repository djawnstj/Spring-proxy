package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    public void noDecorator() throws Exception {
        final Component realComponent = new RealComponent();
        final DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    public void decorator1() throws Exception {
        final Component realComponent = new RealComponent();
        final Component messageDecorator = new MessageDecorator(realComponent);
        final DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    public void decorator2() throws Exception {
        final Component realComponent = new RealComponent();
        final Component messageDecorator = new MessageDecorator(realComponent);
        final Component timeDecorator = new TimeDecorator(messageDecorator);
        final DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
