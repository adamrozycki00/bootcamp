package pl.sda.Bootcamp.security; // plik konfiguracyjny skopiowany od Wojtka

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    // do obsługi bazy danych
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        auth.jdbcAuthentication()
            // sprawdzenie i pobranie loginu i hasła użytkownika po adresie email
            // który jest u nas w systemie loginem
            .usersByUsernameQuery("SELECT mail, password, 1 FROM user WHERE mail=?")
            //pobranie roli uzytkownika z bazy danych po podanym emailu (loginie)
            .authoritiesByUsernameQuery("SELECT u.mail, r.role_name FROM user u inner join role r " +
                    "on r.id=u.role_id WHERE u.mail=?")
            //ustawienie klasy odpowiedzialnej za nawiazanie połączenia do bazy danych
            .dataSource(dataSource)
            //ustawienie sposobu kodowania hasła w bazie danych
            .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/user/trenerzy/lista", "/admin/kurs/lista").permitAll()
                .antMatchers("/user/edytuj", "/user/usun", "/user/trenerzy/**").hasAuthority("admin")
                .antMatchers("/user/lista").hasAnyAuthority("admin", "trainer")
                .antMatchers("/admin/**", "/admin").hasAuthority("admin")
                .antMatchers("/user/**", "/user").hasAuthority("user")
                .anyRequest().permitAll()
            .and()
            .formLogin()
//                .loginPage("/logowanie")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
            .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");
    }
}
