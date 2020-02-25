package сalculator;

import java.io.IOException;

public class ParseFromLines {
    private String inLine;
    private ValAndOperation element = new ValAndOperation();
    private String[] rome = new String[]{"X","I","II","III","IV","V","VI","VII","VIII","IX"};
    private String[] availableOperations = new String[]{"+", "-", "/", "*"};
    //ValueWithType valueWithType = new ValueWithType();
    
    public ParseFromLines(String inLine) {
        this.inLine = inLine;
    }
    
    //Начальная проверка строки и возврат переведенной строки
    public ValAndOperation StartParseFromLines() {
        if (inLine.isEmpty())
            System.exit(0);
        String[] elementInLine = inLine.split(" ");
        if (!(elementInLine.length == 3))
            System.exit(0);        
        if (checkingAvailableOperations(elementInLine[1])) 
            element.operation = elementInLine[1];
        else System.exit(0);
        element.valI = checkingTheNumber(elementInLine[0]);
        element.valII = checkingTheNumber(elementInLine[2]);
        if (element.valI.typeValue.equals(element.valII.typeValue))
            return element;
        else
        {
            System.exit(0);
            return null;
        }        
    }
    
    //Проверка на допустим ли знак
    private boolean checkingAvailableOperations(String stringValue){
        for (int i = 0; i < availableOperations.length ; i++) {
            if (availableOperations[i].equals(stringValue))
               return true;
        }       
        return false;
    }
    
    //Проверка на Арабское число и его величину
    private ValueWithType checkingTheNumber(String stringValue){        
        ValueWithType valueWithType = new ValueWithType();try
        {            
            valueWithType.value = Integer.parseInt(stringValue);
            if (valueWithType.value > 0 && valueWithType.value < 11)
            {
                valueWithType.typeValue = "Arabic";
                return valueWithType;
            }
            else System.exit(0);
        } catch (Exception e) {
            
        }
        valueWithType = translationToArabicNumbers(stringValue);
        return valueWithType;
    }
    
    //Проверка на Римское число
    private ValueWithType translationToArabicNumbers(String stringValue){
        ValueWithType valueWithType = new ValueWithType();
        for (int i = 0; i < rome.length; i++) {
            if (rome[i].equals(stringValue)){
                valueWithType.typeValue = "Rome";
                valueWithType.value = (i==0) ? 10 : i;
                return valueWithType;
            }
//            if (i == 0) 
//                {
//                   valueWithType.value = 10;                   
//                   return valueWithType;
//                }               
//            else             
//            {
//               valueWithType.value = i;                   
//               return valueWithType;
//            }
        }
        System.exit(0);
        return null;
    }
}
