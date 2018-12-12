package com.hmelizarraraz.marvelheroesv2.utils.rx;


import io.reactivex.Scheduler;

public interface RxSchedulers {

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
