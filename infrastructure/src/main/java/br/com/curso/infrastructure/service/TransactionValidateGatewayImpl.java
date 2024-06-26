package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransactionValidateGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.client.ApiValidateService;


public class TransactionValidateGatewayImpl implements TransactionValidateGateway {

    private ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public boolean validate(Transaction transaction) {
        var response = apiValidateService.validate();
        if(response == null){
            return false;
        }
        return response.success();
    }
}
