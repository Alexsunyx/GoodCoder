package parser;

public class IntegerParser implements CommonParser<Integer> {

    private Integer result;

    public IntegerParser() {

    }

    public IntegerParser(Integer result) {
        this.result = result;
    }

    @Override
    public Integer parse(String readIn) {
        try {
            setResult(Integer.valueOf(readIn));
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            setResult(null);
        }
        return getResult();
    }

    @Override
    public Integer getResult() {
        return result;
    }

    @Override
    public void  setResult(Integer result) {
        this.result = result;
    }

}
