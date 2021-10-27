package Calculator;

public class Operation {

    private String operationString;
    private Number x, y;

    public Operation(String operationString) throws Exception
    {
        String[] numbers;

        if (operationString.indexOf("+") > -1)
        {
            numbers = operationString.split("\\+");
            this.operationString = "+";
        }
        else if (operationString.indexOf("-") > -1)
        {
            numbers = operationString.split("-");
            this.operationString = "-";
        }
        else if (operationString.indexOf("*") > -1)
        {
            numbers = operationString.split("\\*");
            this.operationString = "*";
        }
        else if (operationString.indexOf("/") > -1)
        {
            numbers = operationString.split("/");
            this.operationString = "/";
        }
        else
            throw new Exception("Строчка не является записью математической операции!");

        if (numbers.length > 2)
            throw new Exception("В строке > 1 знака операции" + this.operationString + "!");

        try
        {
            x = new ArabicNumbers(numbers[0].trim());
        }
        catch (Exception ex)
        {
            try
            {
                x = new RomanNumbers(numbers[0].trim());
            }
            catch (Exception ex1)
            {
                throw new Exception("Нет 1-го числа от 1 до 10!");
            }
        }

        try
        {
            y = new ArabicNumbers(numbers[1].trim());
        }
        catch (Exception ex)
        {

            try
            {
                y = new RomanNumbers(numbers[1].trim());
            }
            catch (Exception ex1)
            {
                throw new Exception("Нет 2-го числа от 1 до 10!");
            }
        }
    }

    public Number work() throws Exception
    {
        Number result;

        if (x instanceof ArabicNumbers) //если 1-е число - арабское
        {
            if (y instanceof ArabicNumbers) //если 2-е тоже арабское
            {
                if (operationString.equals("+"))
                    result = new ArabicNumbers(x.getNum() + y.getNum());
                else if (operationString.equals("-"))
                    result = new ArabicNumbers(x.getNum() - y.getNum());
                else if (operationString.equals("*"))
                    result = new ArabicNumbers(x.getNum() * y.getNum());
                else
                    result = new ArabicNumbers(x.getNum() / y.getNum());
            }
            else
                throw new Exception("1-е число - арабское, 2-е - римское!");
        }
        else //если 1-е число - римское
        {
            if (y instanceof RomanNumbers) //если второе - тоже римское число
            {
                if (operationString.equals("+"))
                result = new RomanNumbers(x.getNum() + y.getNum());
                else if (operationString.equals("-"))
                result = new RomanNumbers(x.getNum() - y.getNum());
                else if (operationString.equals("*"))
                result = new RomanNumbers(x.getNum() * y.getNum());
             else
                result = new RomanNumbers(x.getNum() / y.getNum());

            if (result.getNum() <= 0)
                throw new Exception("т.к. в римской системе нет отрицательных чисел!");
            }
            else
                throw new Exception("1-e число - римское, 2-е - арабское!");
        }

        return result;
    }

}
