package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ToyListActivity extends AppCompatActivity {

    private static final String TAG = ToyListActivity.class.getSimpleName();
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentOrderManagement fragmentOrderManagement = new FragmentOrderManagement();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toy_list);

        ImageView back = findViewById(R.id.back_jo);
        LinearLayout list1 = findViewById(R.id.toy_list1);
        Button btn = findViewById(R.id.toy_list_button_jo);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list1.setBackground(getResources().getDrawable(R.drawable.edit_background_color, null));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
