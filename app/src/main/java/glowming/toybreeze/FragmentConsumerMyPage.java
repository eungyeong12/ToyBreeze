package glowming.toybreeze;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentConsumerMyPage extends Fragment {
    /*ConsumerMyPageActivity activity;

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (ConsumerMyPageActivity) getActivity();
    }
    public void onDetach() {
        super.onDetach();
    }*/
    static boolean isFirst = true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage_consumer, container, false);

        /* if(fragmentNum == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, reviewing).commit();
        } else if(fragmentNum == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, orderhistory).commit();
        } else if (fragmentNum == 3) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myPage).commit();
        }
         */
        TextView reviewCount = view.findViewById(R.id.review_count);

        /*Button reviewbtn = view.findViewById(R.id.review_button);
        reviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ConsumerReviewing consumerReviewing = new ConsumerReviewing();
                transaction.replace(R.id.main_container, consumerReviewing);
                transaction.commit();
            }
        });*/

        if(!isFirst) {
            reviewCount.setText("2건");
        }

        Button orderhistorybtn =  view.findViewById(R.id.order_history_button);
        orderhistorybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFirst = false;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ConsumeringOrderHistorySub consumeringOrderHistory = new ConsumeringOrderHistorySub();
                transaction.replace(R.id.main_container, consumeringOrderHistory);
                transaction.commit();
            }
        });

        return  view;
    }
    /*public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }*/
}

