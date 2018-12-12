package com.hmelizarraraz.marvelheroesv2.application.builder;

import com.hmelizarraraz.marvelheroesv2.api.HeroApi;
import com.hmelizarraraz.marvelheroesv2.utils.rx.RxSchedulers;

import dagger.Component;

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, HeroesApiServiceModule.class})
public interface AppComponent {

    RxSchedulers rxSchedulers();
    HeroApi apiService();
}
