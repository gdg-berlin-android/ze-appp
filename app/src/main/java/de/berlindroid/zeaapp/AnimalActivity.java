package de.berlindroid.zeaapp;

import android.app.Activity;
import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AnimalActivity extends Activity {

    final List<String> list = Arrays.asList("https://7esl.com/wp-content/uploads/2018/12/Dog-150x150.png","https://7esl.com/wp-content/uploads/2018/12/Dog-150x150.png","https://7esl.com/wp-content/uploads/2018/12/Ox-150x150.png");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal2);
        final Button button = findViewById(R.id.animalButton);
        final ImageView image = findViewById(R.id.animalPicture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownLoadImage(image).execute(list.get(new Random().nextInt(list.size())));
            }
        });


    }


    //WHY???
    private class DownLoadImage extends AsyncTask<String,Void, Bitmap>
    {
        private ImageView image;
        public DownLoadImage(ImageView image)
        {
            this.image = image;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(url).openStream();
                logo = BitmapFactory.decodeStream(is);

            }catch (Exception ignore)
            {

            }
            return logo;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            image.setImageBitmap(bitmap);
        }
    }
}
