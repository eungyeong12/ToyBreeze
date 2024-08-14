package glowming.toybreeze;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentSellerMyPage extends Fragment {

    //SellerMyPageActivity activity;

    /*public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (SellerMyPageActivity) getActivity();
    }
    public void onDetach() {
        super.onDetach();
    }*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage_seller, container, false);

        Button detailbtn = view.findViewById(R.id.review_detail_button);
        detailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SellerReviewDetail sellerReviewDetail = new SellerReviewDetail();
                transaction.replace(R.id.main_container, sellerReviewDetail);
                transaction.commit();
            }
        });

        return  view;
    }
}

