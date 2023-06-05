import java.util.concurrent.*;
public class MultithreadingIntro {
	
	public static void main(String[] args) {
		Runnable printFirst = new PrintChar('a',Integer.MAX_VALUE);
		Runnable printSecond = new PrintNum(55, Integer.MAX_VALUE);
		
		Thread thread1 = new Thread(printFirst);
		Thread thread2 = new Thread(printSecond);
		
		thread1.start();
		thread2.start();
	}

}

class PrintNum extends Thread{
	private int num;
	private int times;
	
	@Override
	public void run() {
		for(int i = 0; i < times; i++) {
			System.out.print(num);
		}
	}
	
	public PrintNum(int num1, int times1) {
		num = num1;
		times = times1;
	}
}

class PrintChar implements Runnable{
	private char letter;
	private int times;
	
	@Override
	public void run() {
		for(int i = 0; i < times; i++) {
			System.out.print(letter);
		}
	}
	
	public PrintChar(char letter1, int times1) {
		letter = letter1;
		times = times1;
	}
	
}
