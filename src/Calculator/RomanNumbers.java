package Calculator;

public class RomanNumbers extends Number {

    public RomanNumbers(String str) throws Exception {
        setNum(prepareNum(str));
    }

    public RomanNumbers(int value){
        setNum(value);
    }

    @Override
    public String toString() {
        return prepareStr(getNum());
    }

    private static Integer prepareNum(String strValue) throws Exception
    {
        switch (strValue)
        {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new Exception();
        }
    }

    private static String prepareStr(int n)
    {
        String answer = "";
        if (n==100)
            answer="C";
        else {
            int d10=n/10;
            int d1=n%10;

            // запись десятков
            if (d10<=3) //0,1,2,3
                for (int i=1;i<=d10;++i)
                    answer += "X";
                else if (d10==4) //4
                    answer += "XL";
                else if (d10<=8) //5,6,7,8
            {
                answer += "L";
                for (int i=6;i<=d10;++i)
                    answer += "X";
            } else //9
            answer += "XC";


            // запись едениц
            if (d1<=3)
                for (int i=1;i<=d1;++i)
                    answer += "I";
                else if (d1==4)
                    answer +="IV";
                else if (d1<=8) {
                    answer += "V";
                    for (int i=6;i<=d1;++i)
                        answer +="I";
            } else
                answer += "IX";
        }
        return answer;
    }
}

