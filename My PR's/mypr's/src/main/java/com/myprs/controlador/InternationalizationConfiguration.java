package com.myprs.controlador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;


@Configuration
public class InternationalizationConfiguration implements WebMvcConfigurer {

    /**
     * Configura el resolvedor de locales de sesión.
     *
     * @return El resolvedor de locales de sesión configurado.
     */
    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH); // Idioma predeterminado
        return localeResolver;
    }

    /**
     * Configura la fuente de mensajes recargable para la internacionalización.
     *
     * @return La fuente de mensajes recargable configurada.
     */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600); // Recarga las propiedades cada 1 hora
        return messageSource;
    }

    /**
     * Configura el interceptor de cambio de idioma.
     *
     * @return El interceptor de cambio de idioma configurado.
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang"); // Cambia el idioma cuando se recibe un parámetro 'lang'
        return interceptor;
    }

    /**
     * Agrega el interceptor de cambio de idioma al registro de interceptores.
     *
     * @param registry El registro de interceptores.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}

