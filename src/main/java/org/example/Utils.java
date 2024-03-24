package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;


public class Utils
{
    public static String getUrl(String nasaURL){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        HttpGet request = new HttpGet(nasaURL);
        try{
            CloseableHttpResponse response = httpClient.execute(request);
            Nasa answer = mapper.readValue(response.getEntity().getContent(),Nasa.class);
            return answer.url;
        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }
}
