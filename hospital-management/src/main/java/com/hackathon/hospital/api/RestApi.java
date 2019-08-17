package com.hackathon.hospital.api;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;

import com.hackathon.hospital.model.CamEvent;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.client.urlconnection.HTTPSProperties;

public class RestApi {

	private String host;

	public List<CamEvent> doREST(String method, String context, String arg) throws Exception {
		host = "http://10.1.37.52:48462"; 
		ClientConfig config = getClientConfig();
		Client client = Client.create(config);
		List<CamEvent> camEvents = null;
		WebResource webResource;
		if ("GET".equalsIgnoreCase(method)) {
			webResource = client.resource(this.host + context + arg);
		} else {
			webResource = client.resource(this.host + context);
		}
		WebResource.Builder builder = webResource.type("application/json").accept("application/json");
		ClientResponse response;
		if ("GET".equalsIgnoreCase(method)) {
			camEvents = builder.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<CamEvent>>(){});
		} else if ("POST".equalsIgnoreCase(method)) {
			response = builder.post(ClientResponse.class, arg);
		} else if ("PUT".equalsIgnoreCase(method)) {
			response = builder.put(ClientResponse.class, arg);
			System.out.println(response);
		} else {
			response = builder.method(method, ClientResponse.class);
		}
		return camEvents;
	}

	public List<CamEvent> doGET(String context, String arg) throws Exception {
		context = "/v1/json/events?limit=200&timeout=5";
		return doREST("GET", context, arg);
	}

	private ClientConfig getClientConfig() {
		try {
			TrustManager[] trustAllCerts;
			trustAllCerts = new TrustManager[] { new X509TrustManager() {
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}

				@Override
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			// Ignore differences between given hostname and certificate
			// hostname
			HostnameVerifier hv = new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new SecureRandom());

			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(hv);

			HTTPSProperties prop = new HTTPSProperties(hv, sc);

			ClientConfig config = new DefaultClientConfig();
			config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, prop);

			return config;
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			System.err.println(e);
		}

		return null;
	}

}
