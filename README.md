# Spring beans injected into EJB

This is a sample project that demonstrates the following:
* Spring beans injected into an EJB (running within a web application)
* Spring context initialized by the EJB, instead of the web application
* Selecting an active profile


## Spring context initialization

The sample bootstraps the spring context in the following steps:
* When web application is loaded, the spring context is NOT loaded
* As soon as there is an EJB call, the  interceptor SpringBeanAutowiringInterceptor kicks in and bootstraps spring context described in [beanRefContext.xml](src/main/resources/beanRefContext.xml)
* The "beanRefContex.xml" loads the actual spring configuration [services-context.xml](src/main/resources/services-context.xml)
* The "services-context.xml" looks up a JNDI environment entry named "spring.profiles.active".
* In our example this entry is defined in [web.xml](src/main/webapp/WEB-INF/web.xml)
* Finally, the "services-context.ml" loads the spring beans using <context:component-scan> annotation

## Valid profiles

In "web.xml" we can configure two profile options:
* default,live
* default,test

Note that "live" and "test" profiles are mutually exclusive.

## Components per profile
In "default" profile we have defined the [Foo.java](src/main/java/routis/examples/spring/Foo.java) component
In "live" profile we have defined [GreetingSrvDefaultImpl.java](src/main/java/routis/examples/spring/defimpl/GreetingSrvDefaultImpl.java)
In "test" profile we have defined an alternative implementation of the [GreetingSrvTestImpl.java](src/main/java/routis/examples/spring/tstimpl/GreetingSrvTestImpl.java) 

