
interface Network{
	public void browse();
}

//被代理类
class RealServer implements Network{
	@Override
	public void browse(){
		System.out.println("真实服务器上网浏览信息");
	}
}
//代理类
class ProxyServer implements Network{
	private Network network;
	public ProxyServer(Network network){
		this.network=network;
	}
	public void check(){
		System.out.println("检查网络连接等操作");
	}
	public void browse(){
		check();
		network.browse();
	}
}

class Outer{
	private int s;
	private String name="外部类";
	public class Inner{
		private String name="内部类";
		public void mb(String name){
			//成员内部类可以直接使用外部类的所有成员，包括私有的数据
			s=100;
			System.out.println("在内部类Inner中s="+s);

			System.out.println("局部变量name="+name);
			System.out.println("内部类对象的属性name="+this.name);
			System.out.println("外部类对象属性name="+Outer.this.name);
		}
	}
	public void ma(){
		Inner i=new Inner();
		i.mb("XXX");

	}
}

public class TestProxy{
	public static void main(String[] args) {
		//Network net=new ProxyServer(new RealServer());
		//net.browse();
		Outer o=new Outer();
		o.ma();
		Outer.Inner b=o.new Inner();
		b.mb("OOOO");
	}
}

