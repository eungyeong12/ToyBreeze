package glowming.toybreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ramotion.fluidslider.FluidSlider;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class FragmentCategory extends Fragment {
    private static final String TAG = FragmentCategory.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ImageButton category1 = view.findViewById(R.id.category1_jo);
        TextView category1Text = view.findViewById(R.id.category1_text_jo);
        ImageButton category2 = view.findViewById(R.id.category2_jo);
        TextView category2Text = view.findViewById(R.id.category2_text_jo);
        ImageButton category3 = view.findViewById(R.id.category3_jo);
        TextView category3Text = view.findViewById(R.id.category3_text_jo);
        ImageButton category4 = view.findViewById(R.id.category4_jo);
        TextView category4Text = view.findViewById(R.id.category4_text_jo);
        ImageButton category5 = view.findViewById(R.id.category5_jo);
        TextView category5Text = view.findViewById(R.id.category5_text_jo);
        ImageButton category6 = view.findViewById(R.id.category6_jo);
        TextView category6Text = view.findViewById(R.id.category6_text_jo);
        Button btn = view.findViewById(R.id.category_button_jo);

        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category1.setBackground(getResources().getDrawable(R.drawable.category_pressed, null));
                category1Text.setVisibility(View.VISIBLE);
            }
        });

        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category2.setBackground(getResources().getDrawable(R.drawable.category_pressed, null));
                category2Text.setVisibility(View.VISIBLE);
            }
        });

        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category3.setBackground(getResources().getDrawable(R.drawable.category_pressed, null));
                category3Text.setVisibility(View.VISIBLE);
            }
        });

        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category4.setBackground(getResources().getDrawable(R.drawable.category_pressed, null));
                category4Text.setVisibility(View.VISIBLE);
            }
        });

        category5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category5.setBackground(getResources().getDrawable(R.drawable.category_pressed, null));
                category5Text.setVisibility(View.VISIBLE);
            }
        });

        category6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category6.setBackground(getResources().getDrawable(R.drawable.category_pressed, null));
                category6Text.setVisibility(View.VISIBLE);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentConsumerMainToy consumerMainToy = new FragmentConsumerMainToy();
                transaction.replace(R.id.main_container, consumerMainToy);
                transaction.commit();
            }
        });

        final int max = 9;
        final int min = 0;
        final int total = max - min;

        final FluidSlider slider = view.findViewById(R.id.fluidSlider);
        slider.setBeginTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                return Unit.INSTANCE;
            }
        });

        slider.setEndTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                return Unit.INSTANCE;
            }
        });

        slider.setPositionListener(pos -> {
            final String value = String.valueOf( (int)(min + total * pos) );
            slider.setBubbleText(value);
            return Unit.INSTANCE;
        });

        slider.setPosition(0.0f);
        slider.setStartText(String.valueOf(min));
        slider.setEndText(String.valueOf(max));
        return view;
    }


}
