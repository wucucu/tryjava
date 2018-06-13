package fcknojob.java.basic.example;

public class CloneExample{
    private int a;
    private int b;

    @Override
    protected CloneExample clone() throws CloneNotSupportedException{
        return (CloneExample)super.clone();
    }
}
