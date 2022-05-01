/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slack;

/**
 *
 * @author lrmoraes1
 */
import java.io.IOException;
import org.json.JSONObject;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        JSONObject json = new JSONObject();

        json.put("text", "Bem-vindos! :sunglasses:");
        Slack.enviarMensagem(json);
    }
}
