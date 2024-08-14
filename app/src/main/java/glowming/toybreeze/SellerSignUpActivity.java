package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class SellerSignUpActivity extends AppCompatActivity {
    private static final String TAG = SellerSignUpActivity.class.getSimpleName();
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_seller);

        EditText name = findViewById(R.id.seller_signup_name_jo);
        EditText email = findViewById(R.id.seller_signup_email_jo);
        EditText password = findViewById(R.id.seller_signup_password_jo);
        EditText phone= findViewById(R.id.seller_signup_phone_jo);
        EditText business = findViewById(R.id.seller_signup_business_jo);
        Button certificate = findViewById(R.id.seller_signup_business_certificate_jo);
        Button signup = findViewById(R.id.seller_signup_button_jo);

        certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SellerSignUpActivity.this, "인증되었습니다", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(name.getText().toString().equals("") || email.getText().toString().equals("") || password.getText().toString().equals("") || phone.getText().toString().equals("") || business.getText().toString().equals(""))
                    Toast.makeText(SellerSignUpActivity.this, "내용을 모두 입력해주세요", Toast.LENGTH_SHORT).show();
                else*/ if(!check)
                    Toast.makeText(SellerSignUpActivity.this, "사업자등록번호를 인증해주세요", Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(SellerSignUpActivity.this, SellerMainActivity.class));
            }
        });
    }
}
