package com.hmelizarraraz.marvelheroesv2.api;

import com.hmelizarraraz.marvelheroesv2.models.Heroes;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    Observable<Heroes> getHeroes();

}
