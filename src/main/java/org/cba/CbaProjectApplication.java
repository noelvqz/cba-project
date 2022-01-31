package org.cba;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by noel on 31/1/22
 */
@SpringBootApplication
public class CbaProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(CbaProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CbaProjectApplication.class, args);
    }

}
