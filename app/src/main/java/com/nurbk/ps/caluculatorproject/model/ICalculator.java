package com.nurbk.ps.caluculatorproject.model;


public interface ICalculator {

     void pushOperand(String operand);

     double pushOperate(String operate);

     void reset();

}
