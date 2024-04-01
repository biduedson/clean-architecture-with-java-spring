package br.com.curso.infrastructure.controller;

import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.infrastructure.dto.request.CreateUserRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.infrastructure.mapper.UserMapper;
import br.com.curso.usecase.CreateUserUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static br.com.curso.infrastructure.utils.Utilities.log;


@Controller
@RequestMapping("api/v1/user")
public class UserController {
    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    public BaseResponse createUser(@RequestBody CreateUserRequest request) throws Exception, TransactionPinException {
        log.info("Inicio da criação do usuario::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("Usuario criado com sucesso::UserController");

       return BaseResponse.builder().success(true).message("Usuario Criado com sucesso.").build();
    }
}
