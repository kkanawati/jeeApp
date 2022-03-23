package myapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hello2Service")
@Qualifier("hi")
public class Hello2service implements IHello{
    String string = "hi";
    @Override
    public void hello() {
        System.out.printf(string);
    }
}
