package сalculator;

//Хранит значение чисел, их тип и знак
public class ValAndOperation {
    ValueWithType valI, valII;
    String operation;
    
    
    int getValI(){
        return valI.value;
    }
    
    int getValII(){
        return valII.value;
    }
    
    String getOperation(){
        return operation;
    }
    
    void setValI(int value){
        valI.value = value;
    }
    
    void setValII(int value){
        valI.value = value;
    }
    
    void setOperation(String value){
        operation = value;
    }
    
}
