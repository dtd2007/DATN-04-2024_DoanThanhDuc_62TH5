package com.example.datn_apphoctienganh_doanthanhduc.taikhoan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.datn_apphoctienganh_doanthanhduc.MessageObject;
import com.example.datn_apphoctienganh_doanthanhduc.R;

public class LoginActivity extends AppCompatActivity {
    Button btnDangnhap;
    TextView tvDangky;
    EditText edttaikhoan, edtmatkhau;

    private final MessageObject messageObject = MessageObject.getInstance();
    public static LoginActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        instance = this;


        AnhXa();
        //Đăng nhập thành công chuyển sang MainActivity
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edttaikhoan.getText().toString().trim();
                String matkhau = edtmatkhau.getText().toString().trim();


                // validations for input email and password // check th trong
                if (TextUtils.isEmpty(email)) {
                    messageObject.ShowDialogMessage(Gravity.CENTER,
                            LoginActivity.this,
                            "Hãy nhập Email của bạn!!",
                            0);
                    return;
                }

                if (TextUtils.isEmpty(matkhau)) {
                    messageObject.ShowDialogMessage(Gravity.CENTER,
                            LoginActivity.this,
                            "Hãy nhập mật khẩu của bạn!!",
                            0);
                    return;
                }
            }
        });
        tvDangky.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }
    private void AnhXa()
    {
        btnDangnhap=(Button) findViewById(R.id.buttonDangnhap);
        tvDangky = (TextView) findViewById(R.id.textView_register);
        edttaikhoan = (EditText) findViewById(R.id.editTextUser);
        edtmatkhau = (EditText) findViewById(R.id.editTextPass);

    }
}

