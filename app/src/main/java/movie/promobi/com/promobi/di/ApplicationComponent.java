package movie.promobi.com.promobi.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import movie.promobi.com.promobi.MyApplication;
import movie.promobi.com.promobi.data.remote.ApiInterface;
import movie.promobi.com.promobi.di.module.ActivityModule;
import movie.promobi.com.promobi.di.module.AppModule;
import movie.promobi.com.promobi.di.module.ViewModelModule;

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, AndroidInjectionModule.class, ViewModelModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        public ApplicationComponent.Builder application(Application application);

        ApplicationComponent build();
    }

    public ApiInterface getApiInterface();

    public void inject(MyApplication myApplication);

}
