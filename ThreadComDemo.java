// A simple demonstration of wait() and notify().

class SyncOb {
	boolean ready = false;

	// This method waits until it receives notification that the ready variable is true.
	synchronized void waitFor() {
		String thrdName = Thread.currentThread().getName();
		System.out.println(thrdName + " is entering waitFor().");
		System.out.println(thrdName +" calling wait() to wait for notification to proceed.\n");
		try {
			while(!ready) wait();// wait for notification.
			} catch(InterruptedException exc) {}
		System.out.println(thrdName +" received notification and is resuming execution.");
	}

	// this method sets the ready variable to true and then sends a notification
	synchronized void goAhead() {
		String thrdName = Thread.currentThread().getName();
	System.out.println("\n" + thrdName +" thread calling notify() inside goAhead(). This will let MyThread resume execution.\n");
	ready = true;
	notify(); // Set ready and notify
	}
}

// A thread class that uses SyncOb.
class MyThread implements Runnable {
	SyncOb syncOb;

	// Construct a new thread.
	MyThread(String name, SyncOb so) {
		syncOb = so;
		new Thread(this, name).start();
	}

	// Begin execution of the thread.
	public void run() {
		syncOb.waitFor();
	}
}

class ThreadComDemo {
	public static void main(String args[]) {
	try {
		SyncOb sObj = new SyncOb();

		// Construct a thread on sObj that waits for a notification.
		new MyThread("MyThread", sObj);
	
		// Burn some CPU time.
	for(int i=0; i < 10; i++) {
		Thread.sleep(250);
		System.out.print(".");
	}
	System.out.println();
	// The main thread will now notify sObj.
	sObj.goAhead();
	// At this point, MyThread resumes execution.
	} catch(InterruptedException exc) {}
	}
}

