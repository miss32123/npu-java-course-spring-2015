/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable{
  String s="",Symbol;
  int num1=0,num2=0;
   
    
    /**
     * The available operators of the calculator.
     */

    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
  
    public void appendDigit(int digit) {
      s+=String.valueOf(digit);
      getDisplay();
    }
    
    public void appendDot(String Dot) {
       s += Dot;
         getDisplay();
    }
    
    public void performOperation(Operator operator) {
       switch(operator){
           case PLUS:
          num1 = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          Symbol = "+";
               break;
           case MINUS:
               num1 = Integer.parseInt(s);
               s= "";
               getDisplay() ;
               Symbol = "-";
               break;
           case TIMES:
                num1 = Integer.parseInt(s);
                s= "";
                getDisplay() ;
                Symbol = "*";
               break;
           case OVER:
                num1 = Integer.parseInt(s);
                s= "";
                getDisplay() ;
                Symbol = "/";
               break;
           case CLEAR:
               s="";
               getDisplay();
               Symbol="0";
               break;
           case EQUAL:
               if(Symbol=="+"){
                num2 = Integer.parseInt(s);
                s = String.valueOf(num1+num2);
                getDisplay();
                s= "";
               }
     
           if(Symbol=="-"){
               num2 = Integer.parseInt(s);
                s = String.valueOf(num1-num2);
                getDisplay();
                s= "";
           }
            if(Symbol=="*"){
                num2= Integer.parseInt(s);
                s=String.valueOf(num1*num2);
                getDisplay();
                s= "";
            }
            if(Symbol=="/"){
                num2= Integer.parseInt(s);
                s=String.valueOf(num1/num2);
                getDisplay();
                s= "";
            }
           if(Symbol=="0"){
                s="";
                num1=0;num2=0;
                getDisplay();
            }
           
           break;
       }
    }
    
    public String getDisplay() {
         setChanged();
	notifyObservers(s);
        return null;
    }

}
 
