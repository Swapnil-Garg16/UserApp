        package com.houssup.userapp;

        import android.app.Activity;
        import android.app.Dialog;
        import android.content.Intent;
        import android.database.Cursor;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.net.Uri;
        import android.os.Parcelable;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.util.TypedValue;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.FrameLayout;
        import android.widget.ImageView;
        import android.widget.Toast;
        import com.hanks.library.AnimateCheckBox;

        import java.io.File;
        import java.util.HashSet;
        import java.util.Iterator;

        import nl.changer.polypicker.Config;
        import nl.changer.polypicker.ImagePickerActivity;
        import nl.changer.polypicker.utils.ImageInternalFetcher;

        public class SelectImagesActivity extends AppCompatActivity {

            private static int RESULT_LOAD_IMAGE = 1;
            HashSet<Uri> mMedia = new HashSet<Uri>();
            private final int SELECT_PHOTO = 1;
            private static final int INTENT_REQUEST_GET_N_IMAGES = 14;
          ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8;
            AnimateCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
            Button btn;
            int count = 0;
            private static int RESULT_LOAD_IMG = 1;
            String imgDecodableString;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_select_images);

                iv1= (ImageView)findViewById(R.id.thumbImage1);
                iv2= (ImageView)findViewById(R.id.thumbImage2);
                iv3= (ImageView)findViewById(R.id.thumbImage3);
                iv4= (ImageView)findViewById(R.id.thumbImage4);
                iv5= (ImageView)findViewById(R.id.thumbImage5);
                iv6= (ImageView)findViewById(R.id.thumbImage6);
                iv7= (ImageView)findViewById(R.id.thumbImage7);
                iv8= (ImageView)findViewById(R.id.thumbImage8);
                  cb1 = (AnimateCheckBox) findViewById(R.id.itemCheckBox);
                btn = (Button)findViewById(R.id.submit);

                ;
                iv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setAlpha(.5f);
                    }
                });

                iv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setAlpha(.5f);
                    }
                });

                iv3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setAlpha(.5f);
                    }
                });

                iv4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setAlpha(.5f);
                    }
                });


                iv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setAlpha(.5f);
                    }
                });

                iv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setAlpha(.5f);
                    }
                });

                iv6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setAlpha(.5f);
                    }
                });

                iv7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        v.setAlpha(.5f);
                    }
                });

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(SelectImagesActivity.this , HomeActivity.class);
                        startActivity(intent);
                    }
                });

                iv8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    getNImages();

                    }
                });




            }

            private void getNImages() {
                Intent intent = new Intent(this, ImagePickerActivity.class);
                Config config = new Config.Builder()
                        .setTabBackgroundColor(R.color.white)    // set tab background color. Default white.
                        .setTabSelectionIndicatorColor(R.color.blue)
                        .setCameraButtonColor(R.color.orange)
                        .setSelectionLimit(30)    // set photo selection limit. Default unlimited selection.
                        .build();
                ImagePickerActivity.setConfig(config);
                startActivityForResult(intent, INTENT_REQUEST_GET_N_IMAGES);
            }



            @Override
            protected void onActivityResult(int requestCode, int resuleCode, Intent intent) {
                super.onActivityResult(requestCode, resuleCode, intent);

                if (resuleCode == Activity.RESULT_OK) {
                    if ( requestCode == INTENT_REQUEST_GET_N_IMAGES) {
                        Parcelable[] parcelableUris = intent.getParcelableArrayExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);

                        if (parcelableUris == null) {
                            return;
                        }

                        // Java doesn't allow array casting, this is a little hack
                        Uri[] uris = new Uri[parcelableUris.length];
                        System.arraycopy(parcelableUris, 0, uris, 0, parcelableUris.length);

                        if (uris != null) {
                            for (Uri uri : uris) {

                                mMedia.add(uri);
                            }

                            showMedia();
                        }
                    }
                }
            }

            private void showMedia() {
                // Remove all views before
                // adding the new ones.

                Iterator<Uri> iterator = mMedia.iterator();
                ImageInternalFetcher imageFetcher = new ImageInternalFetcher(this, 500);
                while (iterator.hasNext()) {
                    Uri uri = iterator.next();


                    View imageHolder = LayoutInflater.from(this).inflate(R.layout.media_layout, null);

                    // View removeBtn = imageHolder.findViewById(R.id.remove_media);
                    // initRemoveBtn(removeBtn, imageHolder, uri);
                    ImageView thumbnail = (ImageView) imageHolder.findViewById(R.id.media_image);

                    if (!uri.toString().contains("content://")) {
                        // probably a relative uri
                        uri = Uri.fromFile(new File(uri.toString()));
                    }

                    imageFetcher.loadImage(uri, thumbnail);


                    // set the dimension to correctly
                    // show the image thumbnail.
                    int wdpx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
                    int htpx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
                    thumbnail.setLayoutParams(new FrameLayout.LayoutParams(wdpx, htpx));
                }
            }

            }







