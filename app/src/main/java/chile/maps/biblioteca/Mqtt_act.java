package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt_act extends AppCompatActivity {

    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:13651";
    static String USERNAME = "kqqedkph";
    static String PASSWORD = "ouDbz4vA6UoF";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());
        try
        {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(),"Coneccion exitosa", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(),"Coneccion fallida", Toast.LENGTH_LONG).show();

                }
            });
        }
        catch (MqttException e) {
            //<service android:name="org.eclipse.paho.android.service.MqttService" ></service>
            Toast.makeText(getBaseContext(),"Error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void revival(View v)
    {
        try
        {
            client.publish("Libros","Revival".getBytes(),0,false );
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void farenheit(View v)
    {
        try
        {
            client.publish("Libros","Farenheit".getBytes(),0,false );
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void elAlquimista(View v)
    {
        try
        {
            client.publish("Libros","El Alquimista".getBytes(),0,false );
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void elPoder(View v)
    {
        try
        {
            client.publish("Libros","El Poder".getBytes(),0,false );
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void elDespertar(View v)
    {
        try
        {
            client.publish("Libros","El Despertar".getBytes(),0,false );
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
