package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QaConsumerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa_consumer);

        Button buttonCancel = findViewById(R.id.button7_s);
        Button buttonSubmit = findViewById(R.id.button8_s);
        EditText editTextContent = findViewById(R.id.editTextContent_s);
        ImageView imageView4 = findViewById(R.id.backImage);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // QAlistConsumerActivity로 돌아가기
                Intent intent = new Intent(QaConsumerActivity.this, QaListConsumerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editTextContent.getText().toString();
                if (content.isEmpty()) {
                    Toast.makeText(QaConsumerActivity.this, "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QaConsumerActivity.this, "문의가 제출되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QaConsumerActivity.this, QaListConsumerActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QaConsumerActivity.this, "사진 추가 기능", Toast.LENGTH_SHORT).show();
                // 사진 선택 구현 해야함, 위에는 임시
            }
        });

        ImageView buttonback = findViewById(R.id.backImage);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
