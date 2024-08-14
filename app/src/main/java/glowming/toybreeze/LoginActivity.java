package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.signin_button_jo);
        EditText email = findViewById(R.id.signin_email_jo);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("1234@email.com")) {
                    startActivity(new Intent(LoginActivity.this, ConsumerMainActivity.class));
                } else {
                    startActivity(new Intent(LoginActivity.this, SellerMainActivity.class));
                }
            }
        });
    }
}
