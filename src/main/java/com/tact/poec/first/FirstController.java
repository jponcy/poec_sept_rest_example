
package com.tact.poec.first;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @RequestMapping("hello/string")
    public String helloS() {
        return "Salut"; // Not valid JSON.
    }

    @RequestMapping("hello/map")
    public Map<String, String> helloM() {
        return Collections.singletonMap("message", "Salut");
    }

    @RequestMapping("values")
    public Map<String, Object> values() {
        Map<String, Object> result = new HashMap<>();

        result.put("message", "Salut");
        result.put("age", 424332);
        result.put("enabled", true);
        result.put("values", new int[] {1, 2, 4, 2});

        return result;
    }


    public class HelloMessage {
        private final String message;

        public HelloMessage(final String message) {
            super();
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    @RequestMapping("hello/object")
    public HelloMessage helloMessage() {
        return new HelloMessage("Salut");
    }
}
