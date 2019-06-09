package movie.promobi.com.promobi.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import movie.promobi.com.promobi.di.MovieViewModel;
import movie.promobi.com.promobi.di.ViewModelKey;
import movie.promobi.com.promobi.factory.MovieViewModelFactory;

@Module
public abstract class ViewModelModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(MovieViewModelFactory viewModelFactory);
    //You are able to declare ViewModelProvider.Factory dependency in another module. For example in ApplicationModule.

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel.class)
    public abstract ViewModel movieViewModel(MovieViewModel userViewModel);

    //Others ViewModels
}