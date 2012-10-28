//print pattern "hello1,hello2,...hello10" using 2 threads
class hel extends Thread
{
	static int i=1;
	lock L = new lock();
	hel(lock l) {
		this.L = l;
	}
	public  void printhel() {
		synchronized(L) {
			for(;i<=10 ;i++) {
				L.notify();
				try{L.wait();}catch(InterruptedException e){}
				System.out.println(i+".Hello by thread with name "+Thread.currentThread().getName());
			}
			System.exit(0); //try{this.join();} catch (InterruptedException e){}
		}
	}
	public void run() { //overriding
		printhel();
	}
}

class hello
{
	public static void main(String[] args) {
		lock l = new lock();
		hel h1 = new hel(l);	//Thread1 declared and object allocated
		hel h2 = new hel(l);	//Thread2 declared and object allocated
		h1.start();
		h2.start();
	}
}
