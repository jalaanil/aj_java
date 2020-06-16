package aj;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.sql.*;  


public class MyCustomHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {
		
		String response = "This is the response from Custom Handler \n";
		DBCon db = new DBCon();
		response +=  db.getRecords();
		
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
}