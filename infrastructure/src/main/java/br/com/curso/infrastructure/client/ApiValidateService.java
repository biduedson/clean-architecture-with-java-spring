
package br.com.curso.infrastructure.client;

import br.com.curso.infrastructure.client.dto.response.ApiValidateResponse;
import org.springframework.stereotype.Service;
@Service
public class ApiValidateService implements  ApiValidateClient {


   @Override
    public ApiValidateResponse validate(){

      return new ApiValidateResponse(true,"Autorizado");
    }
}
