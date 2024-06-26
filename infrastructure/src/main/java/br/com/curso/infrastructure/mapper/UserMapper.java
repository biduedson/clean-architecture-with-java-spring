package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.TaxNumber;
import br.com.curso.core.domain.User;
import br.com.curso.infrastructure.dto.request.CreateUserRequest;
import br.com.curso.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user){

        return new UserEntity(
           user.getId(),
           user.getEmain(),
           user.getPassword(),
           user.getTaxNumber().getValue(),
           user.getFullname(),
           user.getType(),
           user.getCreateAt(),
           user.getUpdateAt()
        );
    }
    public User toUser(CreateUserRequest request) throws Exception {
        TaxNumber taxNumber =  new TaxNumber(request.taxNumber()) ;

        return new User(
                request.email(),
                request.password(),
                taxNumber,
                request.fullName(),
                request.type()
                );
    }

    public User toUser(UserEntity userEntity) throws Exception {
        TaxNumber taxNumber =  new TaxNumber(userEntity.getTaxNumber()) ;

        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                taxNumber,
                userEntity.getFullName(),
                userEntity.getType()
        );
    }
}
