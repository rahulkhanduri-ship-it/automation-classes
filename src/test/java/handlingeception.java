public class handlingeception {

        public static void main(String[] args) {

            int a = 100;
            int b = 0;

            try {
                int result = a / b;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("FAILED: Division by zero is not allowed test");
            }
        }
    }

