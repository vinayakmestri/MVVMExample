package movie.promobi.com.promobi;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import movie.promobi.com.promobi.di.ApplicationComponent;
import movie.promobi.com.promobi.di.DaggerApplicationComponent;

/**
 * Created by Vinayak on 6/8/2019.
 *  MyApplication class initialize appComponent and Fresco library
 *  Fresco library is works similar as Glide for loading image
 */

public class MyApplication extends Application implements HasActivityInjector {

    private ApplicationComponent applicationComponent;
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        applicationComponent.inject(this);
        Fresco.initialize(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
