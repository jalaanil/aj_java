package aj;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.sql.*;  

public class MyWebServer {
	
    public static void main(String[] args) throws Exception {
		
		int port = 8000;
		
		MyConfig cf = new MyConfig();
		String portS = cf.getConfig("webport");
		if ( portS != null )
			port = Integer.parseInt( portS );
		
        HttpServer server = HttpServer.create(new InetSocketAddress( "localhost" , port ), 0);
        server.createContext("/", new MyHandler());
		try
		{
			server.createContext("/custom", new MyCustomHandler());
		}
		catch(Exception e ) {
			System.out.println("Custom Handler could not be loaded");
		}
		
        server.setExecutor(null); // creates a default executor
        server.start();
		System.out.println("Web server started on port : " + port );
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
			
            String response = "Hello World .... \n";			
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}