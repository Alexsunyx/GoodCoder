package parser;

public interface CommonParser<T> {

    public T parse(String readIn);

    public T getResult();

    public void setResult(T result);

}
