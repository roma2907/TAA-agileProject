package fr.istic.agileProjet.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/test")
@Api(value = "Controlleur de test", description = "test de l'application")
public class TestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Méthde retournant l'adresse ip")
    public @ResponseBody String test() throws UnknownHostException {
        return InetAddress.getLocalHost().toString();
    }

}
