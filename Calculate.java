package сalculator;


public class Calculate {
    private int answer; 
    private String romeAnswer = "";
    private ValAndOperation valAndOperation;
    private String[] romeUnits = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
    private String[] romeDes = new String[]{"C","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};

    //Вывод ответа
    public Calculate(ValAndOperation valAndOperation) {
        this.valAndOperation = valAndOperation;
        answer = CalculateAnswer();
        switch (valAndOperation.valI.typeValue){
            case ("Rome"):
                translationToRome();
                System.out.println("Outpt:" + romeAnswer);
                break;
            case ("Arabic"):
                System.out.println("Outpt:" + answer);
                break;
        }       
    }
    
    //Перевод из арабаских в римские цифры
    private void translationToRome(){
        if (answer == 100)
        {
            romeAnswer = "C";
            return;
        }        
        
        int selectedСategory = answer/10;
        if (selectedСategory > 0) 
            romeAnswer += romeDes[selectedСategory];
        
        selectedСategory = answer % 10;
        if (selectedСategory > 0)
            romeAnswer += romeUnits[selectedСategory];
        
        
    }
    
    //Подсчет выражения
    private int CalculateAnswer(){
        switch (valAndOperation.operation){
            case ("+"):
                return valAndOperation.valI.value + valAndOperation.valII.value;
            case ("-"):
                return valAndOperation.valI.value - valAndOperation.valII.value;
            case ("*"):
                return valAndOperation.valI.value * valAndOperation.valII.value;
            case ("/"):
                return valAndOperation.valI.value / valAndOperation.valII.value;
        }
        return 0;
    }
 
 
}

