public class Loader {

    static String loader = "|/-\\";

    public static void startLoader() throws  InterruptedException {
        startLoader(20, 250, "Loading...  ");
    }

    public static void startLoader(int ticks, int delay) throws  InterruptedException {
        startLoader(ticks, delay, "Loading...  ");
    }

    public static void startLoader(int ticks, int delay, String message) throws InterruptedException {

        System.out.print(message);

        for (int i = 0; i < ticks; i++) {
            int index = i % loader.length();
            System.out.print("\r" + message + loader.charAt(index));
            Thread.sleep(delay);
        }
    }

}
