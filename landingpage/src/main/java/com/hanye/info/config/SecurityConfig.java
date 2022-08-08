package com.hanye.info.config;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.hanye.info.repository.mysql.UserRepository;
import com.hanye.info.security.SysLoginFailureHandler;
import com.hanye.info.security.SysLoginSuccessHandler;

@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private SysLoginSuccessHandler sysLoginSuccessHandler;
	
	@Autowired
    private SysLoginFailureHandler sysLoginFailureHandler;
	
	@Autowired
    private UserRepository  userRepository;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		userRepository.findAll().forEach(u -> {
			manager.createUser(User.withUsername(u.getUid()).password(u.getPwd()).roles(
					u.getRoles().stream().map(r -> r.getName()).collect(Collectors.toList()).toArray(new String[0]))
					.build());
		});
		return manager;
	}
	
	
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    	
        http.csrf().disable().cors().and().authorizeRequests()
                .antMatchers("/auth/**","/api/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(sysLoginSuccessHandler)
                .failureHandler(sysLoginFailureHandler)
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

       http.sessionManagement()
                .invalidSessionUrl("/login")
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
                .expiredUrl("/login?expired")
                .sessionRegistry(sessionRegistry());
        
        http.userDetailsService(userDetailsService());
        
        return http.build();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
    
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/css/**", "/fonts/**", "/js/**");
    }

}
