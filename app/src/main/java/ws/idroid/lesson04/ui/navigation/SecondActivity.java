package ws.idroid.lesson04.ui.navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ws.idroid.lesson04.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            TextView tvName = findViewById(R.id.tv_second_name);
            String name = bundle.getString("name");
            tvName.setText(name);
        }
    }
}
