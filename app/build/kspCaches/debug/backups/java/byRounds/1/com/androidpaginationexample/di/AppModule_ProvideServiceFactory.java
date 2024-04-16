package com.androidpaginationexample.di;

import com.androidpaginationexample.network.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AppModule_ProvideServiceFactory implements Factory<ApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiService get() {
    return provideService(retrofitProvider.get());
  }

  public static AppModule_ProvideServiceFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideServiceFactory(retrofitProvider);
  }

  public static ApiService provideService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideService(retrofit));
  }
}
