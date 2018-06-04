package routis.examples.spring;

import org.springframework.stereotype.Component;

/**
 * This is a dummy component, defined in default profile
 *
 * The purpose of this, is to verify that is being injected into
 * {@link routis.examples.EchoEjbImpl#foo} regardless of the actual profile
 */
@Component
public class Foo {
}
