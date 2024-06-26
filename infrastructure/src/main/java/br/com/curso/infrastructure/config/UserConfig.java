package br.com.curso.infrastructure.config;

import br.com.curso.application.gateway.CreateUserGateway;
import br.com.curso.application.gateway.EmailAvailableGateway;
import br.com.curso.application.gateway.TaxNumberAvailableGateway;
import br.com.curso.application.usecaseImpl.CreateUserUseCaseImpl;
import br.com.curso.application.usecaseImpl.EmailAvailableUseCaseImpl;
import br.com.curso.application.usecaseImpl.TaxNumberAvailableUseCaseImpl;
import br.com.curso.usecase.CreateUserUseCase;
import br.com.curso.usecase.EmailAvailableUseCase;
import br.com.curso.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public  TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }
    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase,emailAvailableUseCase,createUserGateway);
    }
}
