# servlet-jsp-practice
## Project structure and configuration
### Maven dependencies
``` xml
        <dependencies>
            <dependency>
              <groupId>javax.servlet</groupId>
              <artifactId>javax.servlet-api</artifactId>
              <version>4.0.1</version>
            </dependency>
        
            <dependency>
              <groupId>javax.servlet.jsp</groupId>
              <artifactId>javax.servlet.jsp-api</artifactId>
              <version>2.3.3</version>
            </dependency>
        
            <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.47</version>
            </dependency>
        
            <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>4.12</version>
            </dependency>
        
            <dependency>
              <groupId>javax.servlet.jsp.jstl</groupId>
              <artifactId>jstl-api</artifactId>
              <version>1.2</version>
            </dependency>
        
            <dependency>
              <groupId>taglibs</groupId>
              <artifactId>standard</artifactId>
              <version>1.1.2</version>
            </dependency>
          </dependencies>
```

### Tomcat, web.xml and registered
``` xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                          http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
             version="4.0"
             metadata-complete="true">
    </web-app>
```

