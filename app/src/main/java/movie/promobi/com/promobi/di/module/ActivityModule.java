package movie.promobi.com.promobi.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import movie.promobi.com.promobi.view.HomeActivity;

/**
 * Created by Admin on 6/8/2019.
 */
@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    public abstract HomeActivity contributeMainActivity();
}
