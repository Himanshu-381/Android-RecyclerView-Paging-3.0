package com.androidpaginationexample.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;

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
public final class AppModule_ProvideHttpFactory implements Factory<OkHttpClient> {
  @Override
  public OkHttpClient get() {
    return provideHttp();
  }

  public static AppModule_ProvideHttpFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static OkHttpClient provideHttp() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideHttp());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideHttpFactory INSTANCE = new AppModule_ProvideHttpFactory();
  }
}
