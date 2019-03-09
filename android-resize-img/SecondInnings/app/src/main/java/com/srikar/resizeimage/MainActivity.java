package com.srikar.resizeimage;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button select, resize;
    ImageView img;
    private static int GALLERY_REQUEST_CODE=1;
    Bitmap bitmap, scaledbitmap;
    int bwidth, bheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        select = (Button)findViewById(R.id.select_button);
        resize = (Button)findViewById(R.id.resize_btn);
        img = (ImageView)findViewById(R.id.imgview);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                String mimetypes[] = {"image/jpeg", "image/png"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),GALLERY_REQUEST_CODE);
            }
        });

        resize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap = ((BitmapDrawable)img.getDrawable()).getBitmap();
                scaledbitmap = Bitmap.createScaledBitmap(bitmap,500,500,true);

                /*bwidth = bitmap.getWidth();
                bheight = bitmap.getHeight();
                float hfactor = 200/bwidth;
                float wfactor = 200/bheight;
                float factorToUse = (hfactor > wfactor) ? wfactor : hfactor;
                Log.d("Factor to use","val : "+ factorToUse);
                scaledbitmap = Bitmap.createScaledBitmap(bitmap, (int)(bwidth*factorToUse), (int)(bheight*factorToUse), true );*/
                img.setImageBitmap(scaledbitmap);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == GALLERY_REQUEST_CODE){
                Uri selectimage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(selectimage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                img.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            }
        }

    }
}
