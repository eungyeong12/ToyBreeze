package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ConsumerMainActivity extends AppCompatActivity  {
    private static final String TAG = ConsumerMainActivity.class.getSimpleName();

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentCategory fragmentCategory = new FragmentCategory();
    private FragmentCompaniesList fragmentCompaniesList = new FragmentCompaniesList();
    private FragmentConsumerHome fragmentConsumerHome = new FragmentConsumerHome();
    private FragmentConsumerMyPage fragmentConsumerMyPage = new FragmentConsumerMyPage();
    private ConsumeringOrderHistory consumeringOrderHistory = new ConsumeringOrderHistory();
    private ConsumeringOrderHistorySub consumeringOrderHistorySub = new ConsumeringOrderHistorySub();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_consumer);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.clearAnimation();

        Intent getIntent = getIntent();
        String s = getIntent.getStringExtra("order");

        if (s == null || s.equals("")) {
            transaction.replace(R.id.main_container, fragmentConsumerHome).commitAllowingStateLoss();
        } else if (s.equals("1")) {
            transaction.replace(R.id.main_container, consumeringOrderHistory).commitAllowingStateLoss();
        } else if (s.equals("2")) {
            transaction.replace(R.id.main_container, consumeringOrderHistorySub).commitAllowingStateLoss();
        }


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int id = item.getItemId();
                if(id == R.id.category) {
                    transaction.replace(R.id.main_container, fragmentCategory).commitAllowingStateLoss();
                    return true;
                } else if(id == R.id.order) {
                    transaction.replace(R.id.main_container, fragmentCompaniesList).commitAllowingStateLoss();
                    return true;
                } else if(id == R.id.home) {
                    transaction.replace(R.id.main_container, fragmentConsumerHome).commitAllowingStateLoss();
                    return true;
                } else if(id == R.id.q) {
                    startActivity(new Intent(ConsumerMainActivity.this, QaListConsumerActivity.class));
                    return true;
                } else if(id == R.id.mypage) {
                    transaction.replace(R.id.main_container, fragmentConsumerMyPage).commitAllowingStateLoss();
                    return true;
                }
                return false;
            }
        });

    }

}
