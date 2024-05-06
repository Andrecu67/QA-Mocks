package example3staticMock;

//Dev Andrea -- << no esta implementado >>
public class ServiceCalcStatic {

    public static int add(int a, int b){
        return 0;
    }

    public static int sub(int a, int b){
        return 0;
    }

    public static int mult(int a, int b){
        System.out.println("****** usando el metodo real*****");
        return 0;
    }

    public static int div(int a, int b){
        return 0;
    }
}
