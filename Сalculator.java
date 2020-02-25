package сalculator;

import java.util.Scanner;

public class Сalculator {


    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        System.out.print("Вводитье в формате \"ЧИСЛО\" + \"Пробел\" + \"Знак операции\" + \"Пробел\" + \"ЧИСЛО\"\n"); 
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.print("Input:");        
            String inLine = in.nextLine();            
            ParseFromLines lines = new ParseFromLines(inLine); 
            ValAndOperation element = lines.StartParseFromLines(); //Перевод из строки в числа
            Calculate calculate = new Calculate(element); //Подсчет выражения из строки и его вывод 
        }
    }
    
    
    
}
