package tom.topica.deadlock;

public class DeadlockDemo {

	public static void main(String[] args) {

		final String resource1 = "resource A";
		final String resource2 = "resource B";

		Thread thread1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: resouce A is locked");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}

					synchronized (resource2) {
						System.out.println("Thread 1: resource B is locked");
					}
				}
			}
		};

		Thread thread2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: resource B is locked");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}

					synchronized (resource1) {
						System.out.println("Thread 2: resource A is locked");
					}
				}
			}
		};

		thread1.start();
		thread2.start();
	}
}
