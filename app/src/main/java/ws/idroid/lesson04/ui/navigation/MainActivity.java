package ws.idroid.lesson04.ui.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import ws.idroid.lesson04.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGo;
    private EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnGo.setOnClickListener(this);
    }

    private void initViews() {
        btnGo = findViewById(R.id.btn_main_go);
        edtName = findViewById(R.id.et_main_name);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name",edtName.getText().toString());
        startActivity(intent);
    }
}
