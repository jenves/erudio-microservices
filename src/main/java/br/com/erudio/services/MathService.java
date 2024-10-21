package br.com.erudio.services;

import br.com.erudio.exceptions.UnsuportedMathOperationException;
import br.com.erudio.utils.MathUtils;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public double sum(String n1, String n2){
        isNumeric(n1, n2);
        return MathUtils.convertToDouble(n1) + MathUtils.convertToDouble(n2);
    }

    public double sub(String n1, String n2) {
        isNumeric(n1, n2);
        return MathUtils.convertToDouble(n1) - MathUtils.convertToDouble(n2);
    }

    public double mult(String n1, String n2){
        isNumeric(n1, n2);
        return MathUtils.convertToDouble(n1) * MathUtils.convertToDouble(n2);
    }

    private static void isNumeric(String n1, String n2) {
        if(!MathUtils.isNumeric(n1) || !MathUtils.isNumeric(n2)){
            throw new UnsuportedMathOperationException("Por favor use apenas números.");
        }
    }

}
