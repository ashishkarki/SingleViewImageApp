package com.example.ashish.singleviewimageapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ashish karki
 */
public class MainActivity extends ActionBarActivity {
    /**
     * The percentage of dragging after which the whole image is displayed.
     * Please note: this has been set to 30 rather than 60 because of what seems as emulator and OS (Ubuntu 32 bit) issues
     */
    private final float IMAGE_MOVED_THRESHOLD = 30;

    private ImageView imageView;
    private List<Integer> images;
    private int currentImageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadImage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Loads the images, and performs actions on swiping to the left or right
     */
    private void loadImage() {
        this.imageView = (ImageView) findViewById(R.id.imageView1);

        initLoadImages();

        // Set the first image at index = 0 to display on the image view
        imageView.setImageResource(images.get(currentImageIndex));

        final float xOnImage = imageView.getX();

        // Add touch listener
        imageView.setOnTouchListener(new View.OnTouchListener() {
            float firstX = 0f;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // the indices we moved the current image by
                float movedX, movedY;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        firstX = event.getX();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        movedX = event.getX() - firstX;
                        imageView.setTranslationX(movedX);
                        break;

                    case MotionEvent.ACTION_UP:
                        movedX = firstX - event.getX();
                        int percentMoved = (int) (movedX / imageView.getWidth() * 100);
                        if (Math.abs(percentMoved) >= IMAGE_MOVED_THRESHOLD) {
                            // we are swiping to the left: we get a new image if there is one
                            if (percentMoved > 0f && currentImageIndex < images.size() - 1) {
                                currentImageIndex++;
                            }
                            // we are swiping right images: we get our previous/old image if there is one
                            else if (percentMoved < 0f && currentImageIndex > 0) {
                                currentImageIndex--;
                            }

                            imageView.setImageResource(images.get(currentImageIndex));
                        }
                        // because this imageView was moved, bring it back to its original position where it can be viewed
                        imageView.setX(xOnImage);
                        break;
                }

                return true;
            }
        });
    }

    /**
     * Simply add images to a list
     */
    private void initLoadImages() {
        images = new ArrayList<Integer>();
        images.add(R.drawable.frame1);
        images.add(R.drawable.frame2);
        images.add(R.drawable.frame3);
        images.add(R.drawable.frame4);
        images.add(R.drawable.frame5);
        images.add(R.drawable.frame6);
        images.add(R.drawable.frame7);
        images.add(R.drawable.frame8);
        images.add(R.drawable.frame9);
        images.add(R.drawable.frame10);
        images.add(R.drawable.frame11);
        images.add(R.drawable.frame12);
        images.add(R.drawable.frame13);
        images.add(R.drawable.frame14);
        images.add(R.drawable.frame15);
        images.add(R.drawable.frame16);
        images.add(R.drawable.frame17);
        images.add(R.drawable.frame18);
        images.add(R.drawable.frame18);
        images.add(R.drawable.frame19);
        images.add(R.drawable.frame20);
        images.add(R.drawable.frame21);
        images.add(R.drawable.frame22);
        images.add(R.drawable.frame23);
        images.add(R.drawable.frame24);
        images.add(R.drawable.frame25);
        images.add(R.drawable.frame26);
        images.add(R.drawable.frame27);
        images.add(R.drawable.frame28);
        images.add(R.drawable.frame29);
        images.add(R.drawable.frame30);
        images.add(R.drawable.frame31);
        images.add(R.drawable.frame32);
        images.add(R.drawable.frame33);
        images.add(R.drawable.frame34);
        images.add(R.drawable.frame35);
        images.add(R.drawable.frame36);
        images.add(R.drawable.frame37);
        images.add(R.drawable.frame38);
        images.add(R.drawable.frame39);
        images.add(R.drawable.frame40);
        images.add(R.drawable.frame41);
        images.add(R.drawable.frame42);
        images.add(R.drawable.frame43);
        images.add(R.drawable.frame44);
    }
}
