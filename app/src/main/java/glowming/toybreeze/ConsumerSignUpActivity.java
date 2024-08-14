package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ConsumerSignUpActivity extends AppCompatActivity {
    private static final String TAG = ConsumerSignUpActivity.class.getSimpleName();

    EditText addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_consumer);

        EditText name = findViewById(R.id.consumer_signup_name_jo);
        EditText email = findViewById(R.id.consumer_signup_email_jo);
        EditText password = findViewById(R.id.consumer_signup_password_jo);
        EditText phone = findViewById(R.id.consumer_signup_phone_jo);
        addr = findViewById(R.id.consumer_signup_addr_jo);
        Button signup = findViewById(R.id.consumer_signup_button_jo);

        addr.setFocusable(false);
        addr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsumerSignUpActivity.this, SearchAddressActivity.class);
                getSearchResult.launch(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(name.getText().toString().equals("") || email.getText().toString().equals("") || password.getText().toString().equals("") || phone.getText().toString().equals("") || addr.getText().toString().equals(""))
                    Toast.makeText(ConsumerSignUpActivity.this, "내용을 모두 입력해주세요", Toast.LENGTH_SHORT).show();
                else*/
                    startActivity(new Intent(ConsumerSignUpActivity.this, ConsumerMainActivity.class));
            }
        });
    }

    private final ActivityResultLauncher<Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // Search Address Activitiy로부터의 결과 값이 전달
                if(result.getResultCode() == RESULT_OK) {
                    if(result.getData() != null) {
                        String data = result.getData().getStringExtra("data");
                        addr.setText(data);
                    }
                }
            }
    );

}
