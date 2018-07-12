package br.com.cq.seguranca.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cp/hello")
public class SecuredController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>("Secured hello!", HttpStatus.OK);
    }
}
