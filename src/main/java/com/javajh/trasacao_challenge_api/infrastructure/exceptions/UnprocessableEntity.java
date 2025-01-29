package main.java.com.javajh.trasacao_challenge_api.infrastructure.exceptions;


@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends RuntimeException{
    public UnprocessableEntity(String message){ super(message); }
}
