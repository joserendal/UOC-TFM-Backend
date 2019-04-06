package com.uoc.ggymbackend;

import com.uoc.ggymbackend.domain.CuotaAbonado;
import com.uoc.ggymbackend.domain.vo.CuotaAbonadoVO;
import com.uoc.ggymbackend.interceptors.AuthorizationInterceptor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mm = new ModelMapper();

        PropertyMap<CuotaAbonado, CuotaAbonadoVO> propertyMap = new PropertyMap<CuotaAbonado, CuotaAbonadoVO>() {
            protected void configure() {
                map(source.getAbonado().getIdAbonado()).setIdAbonado(null);
            }
        };

        mm.addMappings(propertyMap);
        return mm;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).excludePathPatterns("/usuarios/*", "/credenciales/*");
    }
}
