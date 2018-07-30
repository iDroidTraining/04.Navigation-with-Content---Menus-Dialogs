package ws.idroid.lesson04.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.*;
import android.widget.*;

import ws.idroid.lesson04.R;

public class DialogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        initViews();
    }

    private void initViews() {
        Button btnShowDialog = findViewById(R.id.btn_dialogs_alert);
        btnShowDialog.setOnClickListener(v -> showAlertDialog());
        Button btnShowCustomDialog = findViewById(R.id.btn_dialogs_custom);
        btnShowCustomDialog.setOnClickListener(v -> showCustomDialog());
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(DialogsActivity.this);
        dialog.setContentView(R.layout.dialog_custom);
        initCustomDialogViews(dialog);
        Button btnDismiss = dialog.findViewById(R.id.btn_dialog_custom_dismiss);
        btnDismiss.setOnClickListener(v1 -> {
            Toast.makeText(DialogsActivity.this, "button pressed", Toast
                    .LENGTH_SHORT).show();
            dialog.dismiss();
        });
        dialog.show();
    }

    private void initCustomDialogViews(Dialog dialog) {
        TextView tvFirst = dialog.findViewById(R.id.tv_dialog_custom_first);
        TextView tvSecond = dialog.findViewById(R.id.tv_dialog_custom_second);
        tvFirst.setText(R.string.custom_dialog);
        tvSecond.setText(R.string.how_to_dismiss);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(DialogsActivity.this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("This is an example Alert Dialog");
        builder.setPositiveButton("OK", (dialog, which) -> Toast.makeText(DialogsActivity
                .this, "OK!", Toast.LENGTH_SHORT).show()).setNegativeButton("No", (dialog, which) ->
                Toast.makeText(DialogsActivity.this, "Cancel!", Toast.LENGTH_SHORT).show());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
