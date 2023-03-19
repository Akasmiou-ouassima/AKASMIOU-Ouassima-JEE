package ma.enset.nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class NonBlockingServer {

    private static final int BUFFER_SIZE = 1024;
    private static final String RESPONSE = "Hello from Non-Blocking Server!";
    private static final Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(1234));
        serverSocket.configureBlocking(false);

        Map<SocketChannel, ByteBuffer> buffers = new HashMap<>();

        while (true) {
            SocketChannel clientSocket = serverSocket.accept();

            if (clientSocket != null) {
                System.out.println("Accepted connection from " + clientSocket.getRemoteAddress());
                clientSocket.configureBlocking(false);
                buffers.put(clientSocket, ByteBuffer.allocate(BUFFER_SIZE));
            }

            for (SocketChannel socketChannel : buffers.keySet()) {
                ByteBuffer buffer = buffers.get(socketChannel);
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead == -1) {
                    System.out.println("Client closed connection: " + socketChannel.getRemoteAddress());
                    buffers.remove(socketChannel);
                    socketChannel.close();
                } else if (bytesRead > 0) {
                    System.out.println("Received data from " + socketChannel.getRemoteAddress());
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String request = new String(bytes, charset);
                    buffer.clear();
                    String response = RESPONSE + " Request received: " + request;
                    buffer.put(response.getBytes(charset));
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        socketChannel.write(buffer);
                    }
                }
            }
        }
    }
}

