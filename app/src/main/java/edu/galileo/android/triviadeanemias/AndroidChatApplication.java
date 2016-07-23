package edu.galileo.android.triviadeanemias;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import edu.galileo.android.triviadeanemias.lib.GlideImageLoader;
import edu.galileo.android.triviadeanemias.lib.ImageLoader;

/**
 * Created by ihanaht on 11/06/2016.
 */
public class AndroidChatApplication extends Application {
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
        setupImageLoader();
    }

    private void setupImageLoader() {
        imageLoader = new GlideImageLoader(this);
    }

    public ImageLoader getImageLoader(){
        return imageLoader;
    }

    private void setupFirebase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
