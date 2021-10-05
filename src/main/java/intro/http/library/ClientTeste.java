package intro.http.library;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientTeste {
	
	public void executeRequst () {
		HttpClient httpClient = HttpClient.newHttpClient();
		
		URI firstWebSiteAddress = URI.create("http://info.cern.ch/hypertext/WWW/TheProject.html");
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(firstWebSiteAddress)
				.GET()
				.build();
		try {
			HttpResponse<String> response = httpClient.send(
				request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.statusCode()); // 200 if everything is OK
			System.out.println(response.body());       // a long HTML text
	
		}catch(Exception e) {
			System.out.println("We cannot access the site. Please, try later.");
		}
	}

}