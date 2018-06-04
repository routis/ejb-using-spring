package routis.examples.spring.tstimpl;

import lombok.NonNull;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import routis.examples.EchoEjbImpl;

/**
 * This is an alternative implementation of {@link routis.examples.EchoEjbImpl.GreetingSrv}
 * which is defined in "test" profile.
 *
 * The purpose of this is to verify that is being injected into {@link EchoEjbImpl#greetingSrv}
 * as long as "test" profile is being activated
 */
@Component
@Profile("test")
public class GreetingSrvTestImpl implements EchoEjbImpl.GreetingSrv {

    public GreetingSrvTestImpl() {
        System.out.println("=================> Initialized");
    }

    @Override
    @NonNull
    public String greeting(final @NonNull String s) {
        return "Test: " + s;
    }


}

