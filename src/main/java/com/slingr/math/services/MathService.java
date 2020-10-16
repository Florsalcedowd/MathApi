package com.slingr.math.services;

import com.slingr.math.dtos.PostDTO;
import org.mariuszgromada.math.mxparser.Expression;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class MathService {

    /*
     * @desc This method is used to solve the expression given,
     * rounding the result number if precision value is greater than 0
     * @return String result
     * */
    public String solveExpression(String expression, int precision) throws Exception {

        try{

            Expression e = new Expression(expression);

            double result = e.calculate();

            if(precision >= 0){
                result = new BigDecimal(result).round(new MathContext(precision)).doubleValue();
            }

            return truncateDecimal(Double.toString(result));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    /*
     * @desc This method is used to solve math expressions passed through POST
     * It make use of solveExpression
     * @return String result
     * */
    public String solvePostExpression(PostDTO postDTO) throws Exception {
        try {
            return solveExpression(postDTO.getExpression(), postDTO.getPrecision());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
     * @desc This method is used to truncate the ending ".0" of the String given
     * @return String finalResult
     * */
    public String truncateDecimal(String result) {
        return result.endsWith(".0") ? result.substring(0, result.indexOf(".0")) : result;
    }

}
