package org.astro.aboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Log4j2
public class FileController {

    // 예외처리 생성자.
    public static class DataNotFoundException extends RuntimeException {

        public DataNotFoundException(String msg) {
            super(msg);
        }
    }
    
}
