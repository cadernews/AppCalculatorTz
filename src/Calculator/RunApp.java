package Calculator;

import java.util.Scanner;

public class RunApp {

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите два целых числа от 1 до 10 и один из знаков '+', '-', '*', '/' между ними:");
        String inf = scanner.nextLine();
        try
        {
            Operation action = new Operation(inf);
            Number answer = action.work();
            System.out.println(answer);
        }
        catch (Exception ex)
        {
            System.out.println("Возникла ошибка: " + ex.getMessage());
        }

    }
}
