package com.hanthienduc.swipetodismissdialog;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        coordinatorlayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);

        Button addUserButton = (Button) findViewById(R.id.btn_add_user);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddUserDialog();
            }
        });


        Button showAlertButton = (Button) findViewById(R.id.btn_show_alert);
        showAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    private void showAddUserDialog() {
        View dialog = LayoutInflater.from(this).inflate(R.layout.dialog_add_user, null);
        final SwipeDismissDialog swipeDismissDialog = new SwipeDismissDialog.Builder(this)
                .setView(dialog)
                .build()
                .show();

        final EditText userNameEditText = (EditText) dialog.findViewById(R.id.et_username);
        Button addButton = (Button) dialog.findViewById(R.id.btn_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserSuccess(userNameEditText.getText().toString());
                swipeDismissDialog.dismiss();
            }
        });

    }

    private void addUserSuccess(String userName) {
        Snackbar.make(coordinatorlayout, userName + " has been added", Snackbar.LENGTH_SHORT).show();
    }

    private void showAlertDialog() {
        new SwipeDismissDialog.Builder(this)
                .setLayoutResId(R.layout.dialog_success_booking)
                .build()
                .show();
    }
}
