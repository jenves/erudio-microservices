package br.com.erudio.controller;

import br.com.erudio.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private MathService mathService;

    @RequestMapping("/sum/{n1}/{n2}")
    public double sum(@PathVariable("n1") String n1, @PathVariable("n2")  String n2) throws Exception {
        return mathService.sum(n1, n2);
    }

    @RequestMapping("/sub/{n1}/{n2}")
    public double sub(@PathVariable("n1") String n1, @PathVariable("n2")  String n2) throws Exception {
        return mathService.sub(n1, n2);
    }

    @RequestMapping("/mult/{n1}/{n2}")
    public double mult(@PathVariable("n1") String n1, @PathVariable("n2")  String n2) throws Exception {
        return mathService.mult(n1, n2);
    }

}
