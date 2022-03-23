public class TestClass {
    public static void main(String args[]) {
        int a = 5, b = 6;
        String str3;

        PrintStatement test = new PrintStatement();

        String str1 = new String("Hello1");
        String str2 = "Hello2";
        str3 = new String("Hello3");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        System.out.println("Adding " + a + " and " + b + " gives: " + test.AddTwo(a, b));
        test.Funs();
    }
}
