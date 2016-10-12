package myservice.NIO;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import java.nio.ByteBuffer;

public class ClientHandler implements Runnable{
	
	Selector selector;
	
	public ClientHandler(Selector selector){
		this.selector = selector;
	}
	
	public void run() {
		
		while(true){
			try {
				selector.select();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> it = keys.iterator();
			
			while(it.hasNext()){
				SelectionKey key = it.next();
				//移除当前key
				it.remove();
				if(key.isReadable()){
					SocketChannel socketChannel = (SocketChannel) key.channel();
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					try {
						socketChannel.read(byteBuffer);
					} catch (IOException e) {
						e.printStackTrace();
					}
					byte[] bytes = byteBuffer.array();
					System.out.println(new String(bytes));
				}
			}
		}
	}

}
