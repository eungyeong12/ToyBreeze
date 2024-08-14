package glowming.toybreeze;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentOrderManagement extends Fragment {
    private static final String TAG = FragmentOrderManagement.class.getSimpleName();
    boolean isCategory1Selected;
    boolean isBeforeDeliverySelected;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_management, container, false);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentOrderManagementList orderManagementList = new FragmentOrderManagementList();
        FragmentOrderManagementList2 orderManagementList2 = new FragmentOrderManagementList2();
        FragmentOrderManagementListCompleted orderManagementListCompleted = new FragmentOrderManagementListCompleted();
        FragmentOrderManagementList2Completed orderManagementList2Completed = new FragmentOrderManagementList2Completed();

        TextView category1 = view.findViewById(R.id.order_management_category1_jo);
        TextView category2 = view.findViewById(R.id.order_management_category2_jo);
        Button beforeDelivery = view.findViewById(R.id.beforeDelivery_jo);
        Button afterDelivery = view.findViewById(R.id.afterDelivery_jo);

        isCategory1Selected = true;
        isBeforeDeliverySelected = true;

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.list_container, orderManagementList).commitAllowingStateLoss();


        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isCategory1Selected) {
                    category1.setBackground(getResources().getDrawable(R.drawable.category_backgorund3_left_checked, null));
                    category2.setBackground(null);
                    category1.setTextColor(Color.WHITE);
                    category2.setTextColor(Color.BLACK);
                    isCategory1Selected = true;
                    if(!isBeforeDeliverySelected) {
                        beforeDelivery.setTextColor(Color.BLACK);
                        afterDelivery.setTextColor(Color.parseColor("#686868"));
                        isBeforeDeliverySelected = true;
                    }
                }
                fragmentManager.beginTransaction().replace(R.id.list_container, orderManagementList).commitAllowingStateLoss();
            }
        });

        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCategory1Selected) {
                    category1.setBackground(null);
                    category2.setBackground(getResources().getDrawable(R.drawable.category_background3_right_clicked, null));
                    category1.setTextColor(Color.BLACK);
                    category2.setTextColor(Color.WHITE);
                    isCategory1Selected = false;
                    if(!isBeforeDeliverySelected) {
                        beforeDelivery.setTextColor(Color.BLACK);
                        afterDelivery.setTextColor(Color.parseColor("#686868"));
                        isBeforeDeliverySelected = true;
                    }
                }
                fragmentManager.beginTransaction().replace(R.id.list_container, orderManagementList2).commitAllowingStateLoss();
            }
        });

        beforeDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isBeforeDeliverySelected) {
                    beforeDelivery.setTextColor(Color.BLACK);
                    afterDelivery.setTextColor(Color.parseColor("#686868"));
                    isBeforeDeliverySelected = true;
                }
                if(isCategory1Selected)
                    fragmentManager.beginTransaction().replace(R.id.list_container, orderManagementList).commitAllowingStateLoss();
                else
                    fragmentManager.beginTransaction().replace(R.id.list_container, orderManagementList2).commitAllowingStateLoss();
            }
        });

        afterDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBeforeDeliverySelected) {
                    beforeDelivery.setTextColor(Color.parseColor("#686868"));
                    afterDelivery.setTextColor(Color.BLACK);
                    isBeforeDeliverySelected = false;
                }
                if(isCategory1Selected)
                    fragmentManager.beginTransaction().replace(R.id.list_container, orderManagementList2Completed).commitAllowingStateLoss();
                else
                    fragmentManager.beginTransaction().replace(R.id.list_container, orderManagementListCompleted).commitAllowingStateLoss();
            }
        });

        return view;
    }
}
