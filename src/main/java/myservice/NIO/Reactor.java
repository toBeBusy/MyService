package myservice.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable {

	Selector selector;

	public Reactor(Selector selector) {
		this.selector = selector;
	}

	public void run() {
		ServerSocketChannel serverSocketChannel;
		SocketChannel socketChannel = null;
		Selector clientSelector = null;
		try {
			clientSelector = Selector.open();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		while (true) {
			try {
				int num = selector.select();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Set<SelectionKey> keySet = selector.selectedKeys();
			Iterator<SelectionKey> it = keySet.iterator();
			while (it.hasNext()) {
				SelectionKey selectionKey = it.next();
				// 如果是连接就绪
				if (selectionKey.interestOps() == SelectionKey.OP_ACCEPT) {
					if (selectionKey.isAcceptable()) {
						serverSocketChannel = (ServerSocketChannel) selectionKey
								.channel();
						try {
							// 获取客户端连接channel
							socketChannel = serverSocketChannel.accept();
							// 设置非阻塞方式
//							socketChannel.configureBlocking(false);
							// 注册到客户端选择器上
//							socketChannel.register(clientSelector,
//									SelectionKey.OP_READ);
							// 读取数据
							ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

							// 将内容写入缓存
							while (socketChannel.read(byteBuffer) != -1) {
								byte[] bytes = byteBuffer.array();
								// 打印通道中获取的内容
								System.out.print(new String(bytes, "UTF-8"));
								byteBuffer.clear();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				// 移除当前key
				it.remove();
			}
		}
	}
}
