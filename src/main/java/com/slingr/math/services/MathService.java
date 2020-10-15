package com.slingr.math.services;

import com.slingr.math.dtos.PostDTO;
import org.mariuszgromada.math.mxparser.Expression;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class MathService {

    public String solveExpression(String expression, int precision) throws Exception {

        try{

            Expression e = new Expression(expression);

            Double result = e.calculate();

            if(precision >= 0){
                Double roundedResult = new BigDecimal(result).round(new MathContext(precision)).doubleValue();
                return roundedResult.toString();
            } else {
                return result.toString();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public String solvePostExpression(PostDTO postDTO) throws Exception {
        try {
            return solveExpression(postDTO.getExpression(), postDTO.getPrecision());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
