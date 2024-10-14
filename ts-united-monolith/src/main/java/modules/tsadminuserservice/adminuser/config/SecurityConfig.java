package modules.tsadminuserservice.adminuser.config;
import modules.tscommon.edu.fudan.common.security.jwt.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import static org.springframework.web.cors.CorsConfiguration.ALL;
/**
 *
 * @author fdse
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * load password encoder
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    String admin = "ADMIN";

    String stations = "/api/v1/stationservice/stations";

    String order = "/api/v1/orderservice/order";

    String prices = "/api/v1/priceservice/prices";

    String trips = "/api/v1/travel2service/trips";

    String orderOther = "/api/v1/orderOtherService/orderOther";

    /**
     * allow cors domain
     * header  By default, only six fields can be taken from the header, and the other fields can only be specified in the header.
     * credentials   Cookies are not sent by default and can only be true if a Cookie is needed
     * Validity of this request
     *
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(ALL).allowedMethods(ALL).allowedHeaders(ALL).allowCredentials(false).maxAge(3600);
            }
        };
    }

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // close session
        // close default csrf
        httpSecurity.httpBasic().disable().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/adminuserservice/users/**").hasRole("ADMIN").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.DELETE, "/api/v1/userservice/users/*").hasAnyRole("ADMIN", "USER").antMatchers("/api/v1/userservice/users/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/user/**").permitAll().antMatchers(HttpMethod.DELETE, "/api/v1/users/*").hasRole("ADMIN").antMatchers(HttpMethod.GET, "/api/v1/users").hasRole("ADMIN").antMatchers("/api/v1/users/login").permitAll().antMatchers("/api/v1/auth", "/api/v1/auth/hello", "/api/v1/user/hello").permitAll().antMatchers("/api/v1/verifycode/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.POST, "/api/v1/foodservice/orders").hasAnyRole(admin).antMatchers(HttpMethod.PUT, "/api/v1/foodservice/orders").hasAnyRole(admin).antMatchers(HttpMethod.DELETE, "/api/v1/foodservice/orders/*").hasAnyRole(admin).antMatchers("/api/v1/foodservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/stationfoodservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/trainfoodservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/fooddeliveryservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/securityservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/consignservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/consignpriceservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/contactservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/assuranceservice/**").hasRole("USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/adminbasicservice/**").hasRole("ADMIN").antMatchers(HttpMethod.GET, "/api/v1/adminbasicservice/adminbasic/contacts").permitAll().antMatchers(HttpMethod.GET, "/api/v1/adminbasicservice/adminbasic/configs").permitAll().antMatchers(HttpMethod.GET, "/api/v1/adminbasicservice/adminbasic/prices").permitAll().antMatchers(HttpMethod.GET, "/api/v1/adminbasicservice/adminbasic/trains").permitAll().antMatchers(HttpMethod.GET, "/api/v1/adminbasicservice/adminbasic/stations").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/preserveservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/preserveotherservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/cancelservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/executeservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/paymentservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/rebookservice/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/travelservice/**").permitAll().antMatchers(HttpMethod.DELETE, "/api/v1/travelservice/trips/*").hasAnyRole("ADMIN").antMatchers(HttpMethod.PUT, "/api/v1/travelservice/trips").hasAnyRole("ADMIN").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.DELETE, trips).hasAnyRole(admin).antMatchers(HttpMethod.POST, trips).hasAnyRole(admin).antMatchers(HttpMethod.PUT, trips).hasAnyRole(admin).antMatchers("/api/v1/travel2service/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/admintravelservice/**").hasRole("ADMIN").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/travelplanservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/routeplanservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.POST, "/api/v1/seatservice/seats").hasAnyRole("ADMIN").antMatchers("/api/v1/seatservice/**").permitAll().antMatchers(HttpMethod.POST, "/api/v1/orderservice/getVoucher").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/orderservice/order/**").permitAll().antMatchers(HttpMethod.PUT, "/api/v1/orderservice/order/admin").hasAnyRole(admin).antMatchers(HttpMethod.POST, "/api/v1/orderservice/order/admin").hasAnyRole(admin).antMatchers(HttpMethod.DELETE, order).hasAnyRole(admin, "USER").antMatchers(HttpMethod.PUT, order).hasAnyRole(admin, "USER").antMatchers(HttpMethod.POST, order).hasAnyRole(admin, "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.PUT, "/api/v1/orderOtherService/orderOther/admin").hasAnyRole(admin).antMatchers(HttpMethod.POST, "/api/v1/orderOtherService/orderOther/admin").hasAnyRole(admin).antMatchers(HttpMethod.DELETE, orderOther).hasAnyRole(admin, "USER").antMatchers(HttpMethod.PUT, orderOther).hasAnyRole(admin, "USER").antMatchers(HttpMethod.POST, orderOther).hasAnyRole(admin, "USER").antMatchers("/api/v1/orderOtherService/orderOther/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/adminorderservice/**").hasRole("ADMIN").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/inside_pay_service/**").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/adminrouteservice/**").hasRole("ADMIN").antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.DELETE, "/api/v1/configservice/configs/*").hasAnyRole(admin).antMatchers(HttpMethod.PUT, "/api/v1/configservice/configs").hasAnyRole(admin).antMatchers(HttpMethod.POST, "/api/v1/configservice/configs").hasAnyRole(admin).antMatchers("/api/v1/configservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/basicservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.PUT, prices).hasAnyRole(admin).antMatchers(HttpMethod.DELETE, prices).hasAnyRole(admin).antMatchers(HttpMethod.POST, prices).hasAnyRole(admin).antMatchers("/api/v1/priceservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/stationservice/**").permitAll().antMatchers(HttpMethod.DELETE, stations).hasAnyRole(admin).antMatchers(HttpMethod.PUT, stations).hasAnyRole(admin).antMatchers(HttpMethod.POST, stations).hasAnyRole(admin).antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.DELETE, "/api/v1/trainservice/trains/*").hasAnyRole(admin).antMatchers(HttpMethod.PUT, "/api/v1/trainservice/trains").hasAnyRole(admin).antMatchers(HttpMethod.POST, "/api/v1/trainservice/trains").hasAnyRole(admin).antMatchers("/api/v1/trainservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/notifyservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers(HttpMethod.DELETE, "/api/v1/routeservice/routes/*").hasAnyRole("ADMIN").antMatchers(HttpMethod.POST, "/api/v1/routeservice/routes").hasAnyRole("ADMIN").antMatchers("/api/v1/routeservice/**").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/avatar").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/office/**").permitAll().antMatchers(HttpMethod.POST, "/getVoucher").permitAll().antMatchers("/swagger-ui.html", "/webjars/**", "/images/**", "/configuration/**", "/swagger-resources/**", "/v2/**").permitAll().antMatchers("/api/v1/orderservice/order/**").permitAll().antMatchers(HttpMethod.PUT, "/api/v1/orderservice/order/admin").hasAnyRole(admin).antMatchers(HttpMethod.POST, "/api/v1/orderservice/order/admin").hasAnyRole(admin).antMatchers(HttpMethod.DELETE, order).hasAnyRole(admin, "USER").antMatchers(HttpMethod.PUT, order).hasAnyRole(admin, "USER").antMatchers(HttpMethod.POST, order).hasAnyRole(admin, "USER").anyRequest().authenticated().and().addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class);
        // close cache
        httpSecurity.headers().cacheControl();
    }
}