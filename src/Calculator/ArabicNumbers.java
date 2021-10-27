package Calculator;

public class ArabicNumbers extends Number {
    public ArabicNumbers(String str) throws Exception {
        setNum(Integer.parseInt(str));
        if (getNum() < 1 || getNum() > 10)
            throw new Exception("Число не от 1 до 10");
    }


    public ArabicNumbers(int n) {
        setNum(n);
    }

    @Override
    public String toString() {
        return getNum().toString();
    }
}