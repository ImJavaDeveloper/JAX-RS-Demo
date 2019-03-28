# JAX-RS-Demo
RESTful JAX-RS

JAX-RS is a specification for implementing REST web services in Java, currently defined by the JSR-370. It is part of the Java EE technologies, currently defined by the JSR 366.

Jersey (shipped with GlassFish and Payara) is the JAX-RS reference implementation, however there are other implementations such as RESTEasy (shipped with JBoss EAP and WildFly) and Apache CXF (shipped with TomEE and WebSphere).

Jersey Rest, spring rest and Jersey Rest with spring. Both of them are very rich frameworks with nice implementations. I would suggest it's better to go with Spring rest if you are using other Spring services such as ORM ,Spring security and DI etc. Both are spring libraries so I feel little bit essay for managing code and dependencies

JAX-RS pros:

JSR standard can be run without servlet container (grizzly, simple, ...)
Production-ready implementations (jersey, cxf, resteasy, restlet, ...) designed for REST applications only
