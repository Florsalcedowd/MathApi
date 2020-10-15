package com.slingr.math.controllers;

import com.slingr.math.dtos.PostDTO;
import com.slingr.math.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(path = "api/math")
public class MathController {

    private MathService mathService;

    @Autowired
    public MathController(MathService mathService){
        this.mathService = mathService;
    }

    @GetMapping("")
    public ResponseEntity<?> get(@RequestParam String expression, @RequestParam(defaultValue = "0") int precision) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mathService.solveExpression(expression, precision));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> post(@RequestBody PostDTO postDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mathService.solvePostExpression(postDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
}
