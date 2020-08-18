package coffeeshop.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping
@RestController
public class MonitoringController {
    @GetMapping(value = "/monitoring", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> monitoring() {
        var m = new HashMap<Object, Object>();
        m.put("status", "ok");
        m.put("time", System.currentTimeMillis());
        return Map.of("kafka", m);
    }

    @GetMapping(value = "/monitoring/heart_beat", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> heartBeat() {
        return Map.of("status", "ok");
    }
}
