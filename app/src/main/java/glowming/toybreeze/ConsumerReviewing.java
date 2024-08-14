package glowming.toybreeze;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class ConsumerReviewing extends Fragment {
    //ConsumerMyPageActivity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consumer_reviewing, container, false);

        //activity = (ConsumerMyPageActivity) getActivity();

        ImageView back = view.findViewById(R.id.arrow);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentConsumerMyPage consumerMyPage = new FragmentConsumerMyPage();
                transaction.replace(R.id.main_container, consumerMyPage);
                transaction.commit();
            }
        });

        Button btn = view.findViewById(R.id.finished);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentConsumerMyPage consumerMyPage = new FragmentConsumerMyPage();
                transaction.replace(R.id.main_container, consumerMyPage);
                transaction.commit();
            }
        });


        return view;
    }
}