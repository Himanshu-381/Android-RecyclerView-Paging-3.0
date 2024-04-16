package com.androidpaginationexample.di;

import com.androidpaginationexample.data.dao.Dao;
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
public final class AppModule_ProvidesDaoFactory implements Factory<Dao> {
  private final Provider<Database> databaseProvider;

  public AppModule_ProvidesDaoFactory(Provider<Database> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public Dao get() {
    return providesDao(databaseProvider.get());
  }

  public static AppModule_ProvidesDaoFactory create(Provider<Database> databaseProvider) {
    return new AppModule_ProvidesDaoFactory(databaseProvider);
  }

  public static Dao providesDao(Database database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesDao(database));
  }
}
