package myservice.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Service {
	
	public void test(){
		ServerSocketChannel serverSocketChannel; 
		Selector selector;
		try {
			//开启服务器
			serverSocketChannel = ServerSocketChannel.open();
			
			//绑定端口
			serverSocketChannel.socket().bind(new InetSocketAddress(9090));
			//非阻塞方式
			serverSocketChannel.configureBlocking(false);
			//创建选择器
			selector = Selector.open();
			
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			new Thread(new Reactor(selector)).start();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		Service service = new Service();
		service.test();
	}
}
