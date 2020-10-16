package com.slingr.math.services;

import com.slingr.math.dtos.PostDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    private MathService mathService = new MathService();

    @Test
    void solveExpressionWithoutPrecision() throws Exception {
        String response = mathService.solveExpression("2*(7-3)+(-5/(2^3)*25)", 0);
        assertEquals("-7.625", response);
        response = mathService.solveExpression("2*(7-3)+(-5/(2^3)*25)", 2);
        assertEquals("-7.6", response);
    }

    @Test
    void solveExpressionWithPrecision() throws Exception {
        String response = mathService.solveExpression("2*(7-3)+(-5/(2^3)*25)", 2);
        assertEquals("-7.6", response);
    }

    @Test
    void solvePostExpressionWithoutPrecision() throws Exception {
        String response = mathService.solvePostExpression(new PostDTO("2*(7-3)+(-5/(2^3)*25)",0));
        assertEquals("-7.625", response);
    }

    @Test
    void solvePostExpressionWithPrecision() throws Exception {
        String response = mathService.solvePostExpression(new PostDTO("2*(7-3)+(-5/(2^3)*25)",2));
        assertEquals("-7.6", response);
    }

    @Test
    void truncateDecimalTrue() {
        String response = mathService.truncateDecimal("8.0");
        assertEquals("8", response);
    }

    @Test
    void truncateDecimalFalse() {
        String response = mathService.truncateDecimal("8.0456");
        assertEquals("8.0456", response);
    }
}