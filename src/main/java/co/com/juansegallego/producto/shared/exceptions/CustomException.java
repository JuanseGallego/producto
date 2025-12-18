package co.com.juansegallego.producto.shared.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException {

    private Date date;

    public CustomException(String message, Date date) {
        super(message);
        this.date = date;
    }
}
