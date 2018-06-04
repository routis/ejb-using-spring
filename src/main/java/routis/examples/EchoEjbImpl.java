package routis.examples;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.util.Assert;
import routis.examples.spring.Foo;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebService;


/**
 * Demonstrates that spring beans can be injected into an EJB.
 *
 * The  interceptor {@link SpringBeanAutowiringInterceptor} is being responsible
 * for bootstrapping the bean context (and not the {@link org.springframework.web.context.ContextLoaderListener})
 * by looking up a "beanRefContext.xml"
 */
@Stateless
@Remote(Echo.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@WebService
@Slf4j
public class EchoEjbImpl implements Echo {

    @Autowired
    @NonNull
    private GreetingSrv greetingSrv;

    @Autowired
    @NonNull
    private Foo foo;

    @Override
    @NonNull
    public String echo(@NonNull String msg) {

        Assert.notNull(foo, "Foo not found");
        return greetingSrv.greeting(msg);
    }


    public interface GreetingSrv {

        @NonNull
        String greeting(final @NonNull String s);

    }


}
