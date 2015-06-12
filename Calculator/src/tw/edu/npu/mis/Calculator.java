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
  double num1=0,num2=0;
  double x ;
    
    /**
     * @param Symbol 判斷使用者按下何種運算符號
     * @param num1,num2 用來儲存運算數字
     * @param s 用來顯示
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
  /**
   * 
   * @param digit 增加位數
   */
    public void appendDigit(int digit) {
      s+=String.valueOf(digit);
      getDisplay();
    }
    /**
     * 
     * @param Dot 小數點
     */
    public void appendDot(String Dot) {
       if (s.indexOf(".")<0)
        {
                   s += Dot;
                 getDisplay();  
       }
        
    }
    /**
     * 運算功能
     * @param operator 運算符號
     */
    public void performOperation(Operator operator) {
       switch(operator){
           case PLUS:
          num1 = Double.valueOf(s);
          s= "";
          getDisplay() ;
          Symbol = "+";
               break;
           case MINUS:
               num1 = Double.valueOf(s);
               s= "";
               getDisplay() ;
               Symbol = "-";
               break;
           case TIMES:
                num1 = Double.valueOf(s);
                s= "";
                getDisplay() ;
                Symbol = "*";
               break;
           case OVER:
                num1 = Double.valueOf(s);
                s= "";
                getDisplay() ;
                Symbol = "/";
               break;
           case CLEAR:
               s="";
               getDisplay();
               Symbol="0";
               break;
           case PERCENT:
               num1 = Double.valueOf(s);
               s=String.valueOf(num1*0.01);
                getDisplay();
               s="";
               break;
           case  RECIPROCAL:
               num1 = Double.valueOf(s);
               s = String.valueOf(1/num1);
               getDisplay();
               s="";
               break;
           
           case EQUAL:
               if(Symbol=="+"){
                num2 = Double.valueOf(s);
                s = String.valueOf(num1+num2);
                getDisplay();
                s= "";
               }
     
           if(Symbol=="-"){
               num2 = Double.valueOf(s);
                s = String.valueOf(num1-num2);
                getDisplay();
                s= "";
           }
            if(Symbol=="*"){
                num2= Double.valueOf(s);
                s=String.valueOf(num1*num2);
                getDisplay();
                s= "";
            }
            if(Symbol=="/"){
                num2= Double.valueOf(s);
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
 
