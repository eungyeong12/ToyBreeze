package glowming.toybreeze;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.IOException;
import java.text.DecimalFormat;

public class FragmentToyRegistration extends Fragment {
    private static final String TAG = FragmentToyRegistration.class.getSimpleName();
    private TextView toyImageCount;
    private ImageView toyImage1;
    private ImageView toyImage2;
    private ImageView toyImage3;
    private ImageView toyImageDel1;
    private ImageView toyImageDel2;
    private ImageView toyImageDel3;
    private LinearLayout toyImage1Container;
    private LinearLayout toyImage2Container;
    private LinearLayout toyImage3Container;
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private String result="";
    static boolean isRegist = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toy_registration, container, false);

        EditText name = view.findViewById(R.id.toy_name_jo);
        toyImageCount = view.findViewById(R.id.toy_image_count_jo);
        ImageView gotoGallery = view.findViewById(R.id.gotoGallery_jo);
        toyImage1 = view.findViewById(R.id.toy_image1_jo);
        toyImage2 = view.findViewById(R.id.toy_image2_jo);
        toyImage3 = view.findViewById(R.id.toy_image3_jo);
        toyImageDel1 = view.findViewById(R.id.toy_image_del1_jo);
        toyImageDel2 = view.findViewById(R.id.toy_image_del2_jo);
        toyImageDel3 = view.findViewById(R.id.toy_image_del3_jo);
        toyImage1Container = view.findViewById(R.id.toy_image1_container_jo);
        toyImage2Container = view.findViewById(R.id.toy_image2_container_jo);
        toyImage3Container = view.findViewById(R.id.toy_image3_container_jo);
        EditText price = view.findViewById(R.id.toy_price_jo);
        EditText stock = view.findViewById(R.id.toy_stock_jo);
        EditText toyDescripition = view.findViewById(R.id.toy_description_jo);
        EditText toyDestroyDescription = view.findViewById(R.id.toy_destroy_description_jo);
        Button toyRegistButton = view.findViewById(R.id.toy_registration_button_jo);

        price.addTextChangedListener(textWatcher(price));
        stock.addTextChangedListener(textWatcher(stock));

        gotoGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toyImageCount.getText().equals("3")) return;

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.setAction(Intent.ACTION_PICK);
                activityResultLauncher.launch(intent);
            }
        });

        toyImageDel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toyImage1.setImageDrawable(null);
                toyImageDel1.setVisibility(View.INVISIBLE);
                decrementImageCount();
            }
        });

        toyImageDel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toyImage2.setImageDrawable(null);
                toyImageDel2.setVisibility(View.INVISIBLE);
                decrementImageCount();
            }
        });

        toyImageDel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toyImage3.setImageDrawable(null);
                toyImageDel3.setVisibility(View.INVISIBLE);
                decrementImageCount();
            }
        });

        toyRegistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRegist = true;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentSellerHome sellerHome = new FragmentSellerHome();
                transaction.replace(R.id.main_container, sellerHome);
                transaction.commit();
            }
        });

        return view;
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        Uri uri = intent != null ? intent.getData() : null;
                        if (uri != null) {
                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                                int currentCount = Integer.parseInt(toyImageCount.getText().toString());
                                switch (currentCount) {
                                    case 0:
                                        toyImage1.setImageBitmap(bitmap);
                                        toyImageDel1.setVisibility(View.VISIBLE);
                                        break;
                                    case 1:
                                        toyImage2.setImageBitmap(bitmap);
                                        toyImageDel2.setVisibility(View.VISIBLE);
                                        break;
                                    case 2:
                                        toyImage3.setImageBitmap(bitmap);
                                        toyImageDel3.setVisibility(View.VISIBLE);
                                        break;
                                }
                                toyImageCount.setText(String.valueOf(currentCount + 1));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
    );

    private void decrementImageCount() {
        int currentCount = Integer.parseInt(toyImageCount.getText().toString());
        toyImageCount.setText(String.valueOf(currentCount - 1));
    }

    public TextWatcher textWatcher(EditText editText) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence.toString()) && !charSequence.toString().equals(result)){
                    result = decimalFormat.format(Double.parseDouble(charSequence.toString().replaceAll(",", "")));
                    editText.setText(result);
                    editText.setSelection(result.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }
}
