package pe.gob.pge.insisi.utility;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.util.stream.Collectors;

public class Auditoria {
    public static boolean envioAuditoria(Long aplicacionId,Long eventoId,Long usuarioId,String metadato) throws UnsupportedEncodingException {

        boolean return_=false;
        // Crear un cliente HTTP
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Crear una solicitud POST
            HttpPost httpPost = new HttpPost("https://srvqa2.pge.gob.pe/auditoria/api/registro_eventos");

            // Configurar el encabezado de la solicitud (si es necesario)
            httpPost.setHeader("Content-Type", "application/json");

            String ipAddressLocal = InetAddress.getLocalHost().getHostAddress();
            URL url = new URL("https://ipinfo.io/ip");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String publicIPAddress = reader.lines().collect(Collectors.joining());
            reader.close();
            URL urlx = new URL("https://ipinfo.io/loc");
            BufferedReader readerL = new BufferedReader(new InputStreamReader(urlx.openStream()));
            String loc = readerL.lines().collect(Collectors.joining());



            // Configurar el cuerpo de la solicitud (en este ejemplo, un JSON)
            String jsonRequestBody = "{\"aplicacionId\":"+aplicacionId+",\n" +
                    "    \"eventoId\":"+eventoId+",\n" +
                    "    \"usuarioId\":"+usuarioId+",\n" +
                    "    \"ipLocal\":\""+ipAddressLocal+"\",\n" +
                    "    \"macPc\":\"\",\n" +
                    "    \"ipPublica\":\""+publicIPAddress+"\",\n" +
                    "    \"dispositivoId\":3,\n" +
                    "    \"georeferenciacion\":\""+loc+"\",\n" +
                    "    \"metadato\":\""+metadato+"\",\n" +
                    "    \"estado\":1}";

            //System.out.println(jsonRequestBody);
            StringEntity requestEntity = new StringEntity(jsonRequestBody);
            httpPost.setEntity(requestEntity);

            // Ejecutar la solicitud y obtener la respuesta
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                // Procesar la respuesta aquí
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("Código de estado: " + statusCode);

                // Leer y procesar la respuesta si es necesario
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Respuesta: " + responseBody);
                return_=true;
            } catch (ClientProtocolException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return return_;
    }




}
