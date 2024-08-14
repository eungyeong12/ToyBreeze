package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOrderManagementList2 extends Fragment {
    private static final String TAG = FragmentOrderManagementList2.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_management_list2, container, false);

        Button toySelectionButton = view.findViewById(R.id.toy_selection_button_jo);
        ImageView newImage = view.findViewById(R.id.newimage);
        TextView toyName = view.findViewById(R.id.toy_name);

        toySelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //newImage.setImageDrawable(getResources().getDrawable(R.drawable.toyimage5, null));
                        toyName.setText("미니 공룡 장난감");
                        toySelectionButton.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
                startActivity(new Intent(getActivity(), ToyListActivity.class));
            }
        });

        TextView date = view.findViewById(R.id.list2_date_jo);
        TextView count = view.findViewById(R.id.list2_count_jo);
        Button delivery =view.findViewById(R.id.list2_delivery_jo);

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.setText("2024.09.11");
                count.setText("11회 남음");
                toyName.setText("");
                toySelectionButton.setVisibility(View.VISIBLE);
            }
        });


        return view;
    }
}
