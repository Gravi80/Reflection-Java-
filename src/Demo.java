
public class Demo {
    private int privateIntVariable;
    private String privateStringVariable;
    public int publicIntVariable;
    public String publicStringVariable;

    public Demo(int var1,int var2){
        this.privateIntVariable = var1;
        this.publicIntVariable = var2;
    }

    public Demo(String var1,String var2){
        this.privateStringVariable = var1;
        this.publicStringVariable = var2;
    }

    private void privateMethod1(){
        System.out.println("privateMethod1");

    }
    private void privateMethod2(){
        System.out.println("privateMethod2");

    }
    public void publicMethod1(){
        System.out.println("PublicMethod1");

    }
    public void publicMethod2(){
        System.out.println("PublicMethod2");

    }

    private int getSum(int var1,int var2){
      return var1+var2;
    }


}
