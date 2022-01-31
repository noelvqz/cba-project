package org.cba.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by noel on 31/1/22
 */
@RestController
public class CbaProjectIndex {

    @RequestMapping("/")
    public String index() {
        return "CBA REST Application";
    }

}
