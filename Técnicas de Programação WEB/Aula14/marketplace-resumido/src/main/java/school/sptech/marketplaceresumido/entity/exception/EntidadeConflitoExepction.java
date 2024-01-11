package school.sptech.marketplaceresumido.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeConflitoExepction extends RuntimeException{
    public EntidadeConflitoExepction(String message){
        super(message);
    }
}
