package intro.http.library;

import java.io.IOException;
import java.net.URI;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;



public class ServerTeste {
	
	static String CODE;
	
	public void executeRequst () throws Exception{
		HttpServer server = HttpServer.create();
		server.bind(new InetSocketAddress(8080), 0);
		
		server.createContext("/",
			new HttpHandler() {    
				public void handle(HttpExchange exchange) throws IOException {
					String query = exchange.getRequestURI().getQuery();
					String hello = "Hello word";
					if(query != null) {
						ServerTeste.CODE = query;
						exchange.sendResponseHeaders(200, query.length());
						exchange.getResponseBody().write(query.getBytes());
						exchange.getResponseBody().close();
					}else {
						exchange.sendResponseHeaders(200, hello.length());
						exchange.getResponseBody().write(hello.getBytes());
						exchange.getResponseBody().close();
					}
					
				}
			}
		
		);
		
		server.setExecutor(null); // creates a default executor
        server.start();
	}	

}