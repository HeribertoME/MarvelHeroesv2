package com.hmelizarraraz.marvelheroesv2.application.builder;

import com.hmelizarraraz.marvelheroesv2.utils.rx.AppRxSchedulers;
import com.hmelizarraraz.marvelheroesv2.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
