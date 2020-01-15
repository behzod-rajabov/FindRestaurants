package icoder.retrofit.uz.ui;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import icoder.retrofit.uz.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoFragment extends Fragment {

    private ImageView userProfileImage;
    private SubsamplingScaleImageView image;
    private TextView userName, time, caption;


    public PhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container, false);

        image = view.findViewById(R.id.image);
        userProfileImage = view.findViewById(R.id.user_profile_image);
        userName = view.findViewById(R.id.user_name);
        time = view.findViewById(R.id.time);
        caption = view.findViewById(R.id.caption);


        userName.setText(getArguments().getString("user_name"));
        time.setText(getArguments().getString("time"));
        if (getArguments().getString("caption").equals(""))
            caption.setVisibility(View.GONE);
        else
            caption.setText(getArguments().getString("caption"));

        onLoadImage();

        return view;
    }

    private void onLoadImage() {
        assert getArguments() != null;
        Picasso.get().load(getArguments().getString("url")).into(target);
    }

    private Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            image.setImage(ImageSource.bitmap(bitmap));
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            Toast.makeText(getContext(), "Fotosuratni yuklab bo`lmadi boshqadan urunib ko`ring!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    @Override
    public void onDestroy() {
        Picasso.get().cancelRequest(target);
        super.onDestroy();
    }

}
