package routis.examples.spring.defimpl;

import lombok.NonNull;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import routis.examples.EchoEjbImpl;

/**
 * This represents a component that is being defined in "live" profile.
 *
 * The purpose of this, is to verify that is being inject into {@link EchoEjbImpl#greetingSrv}
 * as long as the "live" profile is being activated.
 */
@Component
@Profile("live")
public class GreetingSrvDefaultImpl implements EchoEjbImpl.GreetingSrv {

    @Override
    @NonNull
    public String greeting(final @NonNull String s) {
        return "Hello: " + s;
    }
}
