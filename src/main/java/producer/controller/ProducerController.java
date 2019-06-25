package producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import producer.Service.ProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class ProducerController {

    private final ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/publish")
    public void sendMessage(@RequestParam("message") String message){
        producerService.sendMessage(message);
    }
}
