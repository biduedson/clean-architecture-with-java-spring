package br.com.curso.application.usecaseImpl;

import br.com.curso.application.gateway.TaxNumberAvailableGateway;
import br.com.curso.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {
 public TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public boolean taxNumberAvailable(String taxNumber) {
        return  taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
