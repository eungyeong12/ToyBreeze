package glowming.toybreeze;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOrderManagementList extends Fragment {
    private static final String TAG = FragmentOrderManagementList.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_management_list, container, false);

        TextView date = view.findViewById(R.id.list_date_jo);
        TextView count = view.findViewById(R.id.list_count_jo);
        Button delivery =view.findViewById(R.id.list_delivery_jo);

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.setText("2024.09.02");
                count.setText("2회 남음");
            }
        });

        return view;
    }
}
