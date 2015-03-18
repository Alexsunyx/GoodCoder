package parser;


import model.UnreliableNumber;

public class UnreliableParser implements CommonParser<UnreliableNumber> {

    private UnreliableNumber result;

    @Override
    public UnreliableNumber parse(String readIn) {
        int i = readIn.indexOf('|');
        UnreliableNumber number = new UnreliableNumber();
        number.setReal(Integer.parseInt(readIn.substring(0,1)));
        number.setUnreal(Integer.parseInt(readIn.substring(2, 3)));
        result = number;
        return number;
    }

    @Override
    public UnreliableNumber getResult() {
        return result;
    }

    @Override
    public void setResult(UnreliableNumber result) {
        this.result = result;
    }
}
