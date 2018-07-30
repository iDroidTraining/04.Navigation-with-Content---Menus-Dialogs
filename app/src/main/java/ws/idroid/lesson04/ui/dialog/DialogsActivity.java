package ws.idroid.lesson04.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.*;
import android.view.View;
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

        dialog.show();
    }

    private void initCustomDialogViews(Dialog dialog) {
        Context context=  DialogsActivity.this;
        TextView tvFirst = dialog.findViewById(R.id.tv_dialog_custom_first);
        TextView tvSecond = dialog.findViewById(R.id.tv_dialog_custom_second);
        tvSecond.setVisibility(View.GONE);
        tvFirst.setText(R.string.custom_dialog);
        tvSecond.setText(R.string.how_to_dismiss);
        Button btnDismiss = dialog.findViewById(R.id.btn_dialog_custom_dismiss);
        btnDismiss.setOnClickListener(v1 -> {
            Toast.makeText(context, "button pressed", Toast
                    .LENGTH_SHORT).show();
            dialog.dismiss();
        });
    }

    private void showAlertDialog() {

        Button button = new Button(DialogsActivity.this);
        button.setOnClickListener(v -> {

        });
        AlertDialog.Builder builder = new
                AlertDialog.Builder(DialogsActivity.this).setTitle("Alert Dialog")
                .setMessage("This is an example Alert Dialog")
                .setPositiveButton("OK", (dialog, which) -> Toast.makeText(DialogsActivity
                        .this, "OK!", Toast.LENGTH_SHORT).show())
                .setNegativeButton("No", (dialog, which) ->
                Toast.makeText(DialogsActivity.this, "Cancel!", Toast.LENGTH_SHORT).show());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
