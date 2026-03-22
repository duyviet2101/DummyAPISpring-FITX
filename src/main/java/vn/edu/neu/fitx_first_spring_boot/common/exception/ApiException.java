package vn.edu.neu.fitx_first_spring_boot.common.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class ApiException extends RuntimeException {
    Integer errorCode;
    HttpStatus httpStatus;

    public ApiException(Integer errorCode, HttpStatus httpStatus, String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}