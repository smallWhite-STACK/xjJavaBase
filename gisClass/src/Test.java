class Test{
    static int j=20;
    public void method(int x){
        x=x*2;
        j=j*2;

    }

    public static void main(String[] args) {
        int i=10;
        Test p=new Test();
        p.method(i);
        System.out.println(i+""+j);
    }
}