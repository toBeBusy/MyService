package www.MyService.com.MyService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class VirtualClient {

	public void clientMethod() {
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			// 连接到本机23485端口
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 9090));
			if (socketChannel.finishConnect()) {
				ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
				byteBuffer.put("发一条试试啊!!!!!!!!!".getBytes("UTF-8"));
				//buffer初始模式为读模式，改为写模式
				byteBuffer.flip();
				// 从字节缓存内读取内容
				while (byteBuffer.hasRemaining()) {
					socketChannel.write(byteBuffer);
				}
				socketChannel.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		VirtualClient virtualClient = new VirtualClient();
		virtualClient.clientMethod();
	}
}
