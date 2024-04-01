package hello.proxy.pureproxy.concreteProxy.code;

public class ConcreteClient {

    private final ConcreteLogic concreteLogic;

    public ConcreteClient(final ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    public void execute() {
        concreteLogic.operation();
    }
}
