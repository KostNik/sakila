package ltd.configure;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import javax.servlet.ServletContext;

/**
 * Created by SweetHome on 13.06.2017.
 */
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {


    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        super.beforeSpringSecurityFilterChain(servletContext);

    }


}
