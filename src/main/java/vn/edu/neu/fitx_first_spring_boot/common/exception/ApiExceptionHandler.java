package vn.edu.neu.fitx_first_spring_boot.common.exception;

import com.mongodb.MongoCommandException;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.edu.neu.fitx_first_spring_boot.common.response.ApiResponse;

import java.util.stream.Collectors;

@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Log4j2
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {
        return responseEntity(e.getErrorCode(), e.getHttpStatus(), e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        String supportedMethods = ex.getSupportedMethods() == null ? null : String.join(",", ex.getSupportedMethods());

        String msg = String.format("Method not supported: %s, only support %s", ex.getMethod(), supportedMethods);

        return responseEntity(HttpStatus.METHOD_NOT_ALLOWED.value(), status, msg);
    }

    @ExceptionHandler(value = MongoCommandException.class)
    public ResponseEntity<?> handleAuthException(MongoCommandException e) {
        log.error("Error handle::: ", e);
        return responseEntity(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    private ResponseEntity<Object> responseEntity(Integer errorCode, @NonNull HttpStatusCode statusCode, String msg) {
        return new ResponseEntity<>(
                ApiResponse.builder().errorCode(errorCode).statusCode(statusCode.value()).message(msg).build(),
                statusCode);
    }
}