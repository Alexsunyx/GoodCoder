package model;

public class UnreliableNumber {

    private int real;

    private int unreal;

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getUnreal() {
        return unreal;
    }

    public void setUnreal(int unreal) {
        this.unreal = unreal;
    }

    @Override
    public String toString() {
        return real + "+" + unreal + "i";
    }
}
