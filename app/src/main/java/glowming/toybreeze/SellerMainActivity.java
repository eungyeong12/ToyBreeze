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

public class SellerMainActivity extends AppCompatActivity {
    private static final String TAG = SellerMainActivity.class.getSimpleName();

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentToyRegistration fragmentToyRegist = new FragmentToyRegistration();
    private FragmentOrderManagement fragmentOrderManagement = new FragmentOrderManagement();
    private FragmentSellerHome fragmentSellerHome = new FragmentSellerHome();
    private FragmentSellerMyPage fragmentSellerMyPage = new FragmentSellerMyPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_seller);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragmentSellerHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.clearAnimation();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int id = item.getItemId();
                if(id == R.id.category) {
                    transaction.replace(R.id.main_container, fragmentToyRegist).commitAllowingStateLoss();
                    return true;
                } else if(id == R.id.order) {
                    transaction.replace(R.id.main_container, fragmentOrderManagement).commitAllowingStateLoss();
                    return true;
                } else if(id == R.id.home) {
                    transaction.replace(R.id.main_container, fragmentSellerHome).commitAllowingStateLoss();
                    return true;
                } else if(id == R.id.q) {
                    startActivity(new Intent(SellerMainActivity.this, QaListSellerActivity.class));
                    return true;
                } else if(id == R.id.mypage) {
                    transaction.replace(R.id.main_container, fragmentSellerMyPage).commitAllowingStateLoss();
                    return true;
                }
                return false;
            }
        });
    }
}
