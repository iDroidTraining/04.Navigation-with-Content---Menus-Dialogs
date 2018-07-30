package ws.idroid.lesson04.ui.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import ws.idroid.lesson04.R;
import ws.idroid.lesson04.ui.dialog.DialogsActivity;
import ws.idroid.lesson04.ui.menu.PopupMenuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGo;
    private EditText edtName;
    private Button btnDialogs;
    private Button btnMenu;

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
        btnDialogs = findViewById(R.id.btn_main_dialogs);
        btnMenu = findViewById(R.id.btn_main_menu);
        btnDialogs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,
                DialogsActivity.class)));
        btnMenu.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,
                PopupMenuActivity.class)));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name",edtName.getText().toString());
        startActivity(intent);
    }
}
