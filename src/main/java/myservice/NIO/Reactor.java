package myservice.NIO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import myservice.Util.HttpUtil;
import myservice.request.Request;
import myservice.request.RequestBase;
import myservice.request.RequestGet;
import myservice.request.RequestPost;

public class Reactor implements Runnable {

	Selector selector;

	public Reactor(Selector selector) {
		this.selector = selector;
	}

	public void run() {
		ServerSocketChannel serverSocketChannel;
		SocketChannel socketChannel = null;

		while (true) {
			try {
				selector.select();
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
							// socketChannel.configureBlocking(false);
							// 注册到客户端选择器上
							// socketChannel.register(clientSelector,
							// SelectionKey.OP_READ);
							// 读取数据

							// 将内容写入缓存
							ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

							this.clientHandler(socketChannel);

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

	public void clientHandler(SocketChannel socketChannel) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		StringBuilder sb = new StringBuilder();
		try {
			//TODO 不能循环读取
			socketChannel.read(byteBuffer);
			byte[] bytes = byteBuffer.array();
			sb.append(new String(bytes));
			byteBuffer.clear();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] message = sb.toString().split("\r\n");
		//判断请求类型
		String requestType = message[0].split(" ")[0];
		RequestBase request = null;
		if(Request.GET.equals(requestType)){
			request = new RequestGet();
			//设置请求头
			request.setHeaders(HttpUtil.getHeaders(message));
			//设置请求路径和http类型
			HttpUtil.getRequestMessge(request, message);
		} else if(Request.POST.equals(requestType)){
			request = new RequestPost();
			request.setHeaders(HttpUtil.getHeaders(message));
			//设置请求路径和http类型
			HttpUtil.getRequestMessge(request, message);
		}
	}
}
