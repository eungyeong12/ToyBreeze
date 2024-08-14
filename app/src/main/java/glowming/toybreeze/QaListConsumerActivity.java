package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class QaListConsumerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_qalist_consumer);

        Button button5_s = findViewById(R.id.button5_s);
        button5_s.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(QaListConsumerActivity.this, QaConsumerActivity.class);
                startActivity(intent);
            }
        });

        ImageView exampleImageView = findViewById(R.id.imageView5_s);
        exampleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QaListConsumerActivity.this, QaConsumerChatActivity.class);
                startActivity(intent);
            }
        });

        ImageView buttonback = findViewById(R.id.imageView4_s);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
