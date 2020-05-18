package hu.horvathnorbert.kotlin_hw.config

import hu.horvathnorbert.kotlin_hw.security.JWTAuthorizationFilter
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
class WebSecurityConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http!!.csrf().disable()
                .addFilterAfter(JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers(HttpMethod.GET, "/user").permitAll()
                .anyRequest().authenticated()
    }
}