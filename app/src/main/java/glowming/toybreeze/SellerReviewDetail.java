package glowming.toybreeze;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SellerReviewDetail extends Fragment {
    //SellerMyPageActivity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_detail, container, false);

        //activity = (SellerMyPageActivity) getActivity();

        ImageView back = view.findViewById(R.id.arrow);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentSellerMyPage sellerMyPage = new FragmentSellerMyPage();
                transaction.replace(R.id.main_container, sellerMyPage);
                transaction.commit();
            }
        });

        return view;
    }
}


