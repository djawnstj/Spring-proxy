package hello.proxy.pureproxy.concreteProxy;

import hello.proxy.pureproxy.concreteProxy.code.ConcreteClient;
import hello.proxy.pureproxy.concreteProxy.code.ConcreteLogic;
import hello.proxy.pureproxy.concreteProxy.code.TimeProxy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    public void noProxy() throws Exception {
        final ConcreteLogic concreteLogic = new ConcreteLogic();
        final ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }
    
    @Test
    public void addProxy() throws Exception {
        final ConcreteLogic concreteLogic = new ConcreteLogic();
        final TimeProxy timeProxy = new TimeProxy(concreteLogic);
        final ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
