//package com.example.rsauther.testapplication;
//
//import android.app.Application;
//
//public class WeatherApp extends Application {
//
//    private AppComponent appComponent;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        appComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .build();
//    }
//
//    public AppComponent appComponent() {
//        return appComponent;
//    }
//}
