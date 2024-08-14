package glowming.toybreeze;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ConsumerToySelect extends AppCompatActivity {

    private View targetView;
    private Button drawerButton;
    private Button button1;
    private ImageView back;
    private boolean drawerToggle = false; // 초기 상태는 false로 설정합니다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyselect);

        targetView = findViewById(R.id.content);
        drawerButton = findViewById(R.id.drawer);
        button1 = findViewById(R.id.button1);
        back = findViewById(R.id.imageView15);

        // drawerButton 클릭 리스너 설정
        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawerToggle) {
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(targetView, "translationY", -1200f);
                    objectAnimator.setDuration(500);
                    objectAnimator.start();
                } else {
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(targetView, "translationY", 0f);
                    objectAnimator.setDuration(500);
                    objectAnimator.start();
                }
                drawerToggle = !drawerToggle;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsumerToySelect.this, ToyDetail.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}