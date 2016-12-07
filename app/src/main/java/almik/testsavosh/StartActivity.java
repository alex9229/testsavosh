package almik.testsavosh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import almik.testsavosh.utill.restUtill;

public class StartActivity extends AppCompatActivity {




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restUtill restUtill=new restUtill();
        restUtill.retro();

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d("test1", "Key: " + key + " Value: " + value);
            }
      }

    Button subscribeButton = (Button) findViewById(R.id.FirebaseMessaging1);
    subscribeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // [START subscribe_topics]
            FirebaseMessaging.getInstance().subscribeToTopic("news");
            // [END subscribe_topics]

            // Log and toast
            String msg = getString(R.string.msg_subscribed);
            Log.d("test1", msg);
            Toast.makeText(StartActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    });

    Button logTokenButton = (Button) findViewById(R.id.FirebaseInstanceId1);
    logTokenButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Get token
            String token = FirebaseInstanceId.getInstance().getToken();

            // Log and toast
            String msg = getString(R.string.msg_token_fmt, token);
            Log.d("test1", msg);
            Toast.makeText(StartActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    });
}


}
