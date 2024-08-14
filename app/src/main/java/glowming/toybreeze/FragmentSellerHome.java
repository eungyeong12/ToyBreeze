package glowming.toybreeze;

import static glowming.toybreeze.FragmentToyRegistration.isRegist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSellerHome extends Fragment {
    private static final String TAG = FragmentSellerHome.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_seller_home, container, false);

        ImageButton newImage = view.findViewById(R.id.imageButton5);

        if(isRegist) {
            newImage.setVisibility(View.VISIBLE);
        }
        return view;
    }
}
