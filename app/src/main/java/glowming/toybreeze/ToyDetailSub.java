package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ToyDetailSub extends AppCompatActivity {
    private static final String TAG = ToyDetailSub.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy_details_sub);
        Button gotoOrderList = findViewById(R.id.gotoOrderList);

        ImageView btn = findViewById(R.id.button8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        gotoOrderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToyDetailSub.this, ConsumerMainActivity.class);
                intent.putExtra("order", "2");
                startActivity(intent);
            }
        });
    }
}
