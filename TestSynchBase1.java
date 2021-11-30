import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Bank{
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;

	public Bank(int n,double initialBalance){
		accounts=new double[n];
		Arrays.fill(accounts,initialBalance);
		bankLock=new ReentrantLock();
		sufficientFunds=bankLock.newCondition();
	}

	public synchronized void transfer(int from,int to,double amount) throws InterruptedException{
			while(accounts[from]<amount){
				wait();
			}
			System.out.print(Thread.currentThread());
			accounts[from]-=amount;
			System.out.printf(" %10.2f from %d to %d",amount,from,to);
			accounts[to]+=amount;
			System.out.printf(" 总额: %10.2f%n",getTotalBalance());
			notifyAll();
	}
	public synchronized double getTotalBalance(){
		double sum=0;
		for (double a:accounts){
			sum+=a;
		}
		return sum;
	}
	public int size(){
		return accounts.length;
	}
}

public class TestSynchBase1{
	public static final int NACCOUNTS=100;
	public static final double INITIAL_BALANCE=1000;
	public static final double MAX_AMOUNT=1000;
	public static final int DELAY=10;

	public static void main(String[] args) {
		Bank bank=new Bank(NACCOUNTS,INITIAL_BALANCE);
		for (int i=0; i<NACCOUNTS; i++) {
			int fromAccount=i;
			Runnable r=()->{
				try{
					while(true){
						int toAccount=(int) (bank.size()*Math.random());
						double amount=MAX_AMOUNT*Math.random();
						bank.transfer(fromAccount,toAccount,amount);
						Thread.sleep((int)(DELAY*Math.random()));
					}
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			};
			Thread t=new Thread(r);
			t.start();
		}
	}
}

java.lang.Object 
	void notifyAll()  /*解除那些在该对象上调用 wait 方法的线程的阻塞状态。该方法只能在同步方法或同步块内
	部调用。 如果当前线程不是对象锁的持有者，该方法拋出一个 IllegalMonitorStateException异常。*/

