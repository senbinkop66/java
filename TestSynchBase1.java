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

	public void transfer(int from,int to,double amount) throws InterruptedException{
		bankLock.lock();
		try{
			while(accounts[from]<amount){
				sufficientFunds.await();
			}
			System.out.print(Thread.currentThread());
			accounts[from]-=amount;
			System.out.printf(" %10.2f from %d to %d",amount,from,to);
			accounts[to]+=amount;
			System.out.printf(" 总额: %10.2f%n",getTotalBalance());
			sufficientFunds.signalAll();
		}finally{
			bankLock.unlock();
		}
	}
	public double getTotalBalance(){
		bankLock.lock();
		try{
			double sum=0;
			for (double a:accounts){
				sum+=a;
			}
			return sum;
		}finally{
			bankLock.unlock();
		}
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


java.util.concurrent.locks.Lock
	Condition newCondition( )  //返回一个与该锁相关的条件对象。
java.util.concurrent.locks.Condition
	void await( )  //将该线程放到条件的等待集中。
	void signalA11( )  //解除该条件的等待集中的所有线程的阻塞状态。
	void signal ( )  //从该条件的等待集中随机地选择一个线程， 解除其阻塞状态。