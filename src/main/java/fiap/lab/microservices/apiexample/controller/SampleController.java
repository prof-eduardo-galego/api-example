package fiap.lab.microservices.apiexample.controller;

import fiap.lab.microservices.apiexample.model.Sample;
import fiap.lab.microservices.apiexample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/samples", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

    @Autowired
    private SampleService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Sample> save(@RequestBody Sample sample) {
        return ResponseEntity.ok(service.save(sample));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sample> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Sample>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}