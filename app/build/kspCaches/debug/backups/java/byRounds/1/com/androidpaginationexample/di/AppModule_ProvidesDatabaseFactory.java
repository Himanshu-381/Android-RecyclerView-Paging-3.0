package com.androidpaginationexample.di;

import android.app.Application;
import com.androidpaginationexample.data.database.Database;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppModule_ProvidesDatabaseFactory implements Factory<Database> {
  private final Provider<Application> contextProvider;

  public AppModule_ProvidesDatabaseFactory(Provider<Application> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Database get() {
    return providesDatabase(contextProvider.get());
  }

  public static AppModule_ProvidesDatabaseFactory create(Provider<Application> contextProvider) {
    return new AppModule_ProvidesDatabaseFactory(contextProvider);
  }

  public static Database providesDatabase(Application context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesDatabase(context));
  }
}
