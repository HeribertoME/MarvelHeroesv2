package com.hmelizarraraz.marvelheroesv2.screens.details.dagger;

import com.hmelizarraraz.marvelheroesv2.screens.details.HeroDetailsActivity;

import dagger.Component;

@Component(modules = {HeroDetailsModule.class})
public interface HeroDetailsComponent {

    void inject(HeroDetailsActivity activity);
}
