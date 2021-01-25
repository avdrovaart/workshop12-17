public class Loom2 {
    public static void main(String[] args) {
        var scope = new ContinuationScope("C1");
        var c = new Continuation(scope, () -> {
            System.out.println("Start C1");
            Continuation.yield(scope);
            System.out.println("End C1");
        });

        while (!c.isDone()) {
            System.out.println("Start run()");
            c.run();
            System.out.println("End run()");
        }
    }
}
