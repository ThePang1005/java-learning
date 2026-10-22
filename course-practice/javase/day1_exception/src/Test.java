public class Test {
    public static void main(String[] args) {
        try {
            throw new MyException("这是一个自定义异常");
        } catch (MyException e) {
            System.out.println(e.getMessage()); // 这是一个自定义异常
            e.printStackTrace(); // 打印异常信息
        }

        testTryCatchFinally();

        // 调用带 throws 声明的方法：方法内 throw 扔出，throws 上传，这里接住
        try {
            throwIt();
        } catch (MyException e) {
            System.out.println("main 接住了: " + e.getMessage());
        }
    }

    // 自定义异常类（继承 Exception，无参+带消息两个构造）
    public static class MyException extends Exception {
        public MyException() {
            super();
        }
        public MyException(String message) {
            super(message);
        }
    }
    //try-catch-finally 示例（finally 写收尾逻辑）、try-catch 示例（catch 处理异常）、try 示例（try 语句块）
    public static void testTryCatchFinally() {
        try {
            throw new MyException("这是一个自定义异常");
        } catch (MyException e) {
            System.out.println(e.getMessage()); // 这是一个自定义异常
            e.printStackTrace(); // 打印异常信息
        } finally {
            System.out.println("finally 语句块"); // 会执行
        }
    }

    // throw：真的扔出一个异常对象
    // throws：声明"我可能扔，接了往上传，调用方自己处理"
    public static void throwIt() throws MyException {
        throw new MyException("这个异常抛给调用方处理");
    }

}
