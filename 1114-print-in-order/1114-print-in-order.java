class Foo {
    private int a;
    // private boolean twoDone;
    
    public Foo() {
        a=0;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        a=1;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (a!=1) {
            wait();
        }
        printSecond.run();
        a=2;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (a!=2) {
            wait();
        }
        printThird.run();
    }
}