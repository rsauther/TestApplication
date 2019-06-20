//package com.example.rsauther.testapplication;
//
//import android.content.Context;
//
//import dagger.Module;
//import dagger.Provides;
//
//@Module
//public class AppModule {
//
//    private final Context context;
//
//    public AppModule(Context context) {
//        this.context = context.getApplicationContext();
//    }
//
//    @Provides @AppScope public Context provideAppContext() {
//        return context;
//    }
//
//    @Provides public WeatherApiClient provideWeatherApiClient() {
//        return new RestAdapter.Builder()
//                .setEndpoint(WeatherApiClient.ENDPOINT)
//                .setRequestInterceptor(apiKeyRequestInterceptor())
//                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
//                .build()
//                .create(WeatherApiClient.class);
//    }
//
//    private RequestInterceptor apiKeyRequestInterceptor() {
//        return new ApiKeyRequestInterceptor(context.getString(R.string.open_weather_api_key));
//    }
//
//}
