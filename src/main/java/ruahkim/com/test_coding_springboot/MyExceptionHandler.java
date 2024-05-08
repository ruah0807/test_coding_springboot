//package ruahkim.com.test_coding_springboot;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//
//@ControllerAdvice
////    모든 Controller 파일의 에러를 캐치하려면 @ControllerAdvice
////      RestAPI 만들시 가져다씀.
//public class MyExceptionHandler {
//
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<String> handler1(){
//        return ResponseEntity.status(400).body("유저잘못");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handler(){
//        return ResponseEntity.status(400).body("유저잘못");
//    }
//}
