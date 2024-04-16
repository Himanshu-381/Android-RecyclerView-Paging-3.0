package com.androidpaginationexample.ui;

import com.androidpaginationexample.data.database.Database;
import com.androidpaginationexample.network.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<Database> dbProvider;

  private final Provider<ApiService> apiServiceProvider;

  public MainViewModel_Factory(Provider<Database> dbProvider,
      Provider<ApiService> apiServiceProvider) {
    this.dbProvider = dbProvider;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(dbProvider.get(), apiServiceProvider.get());
  }

  public static MainViewModel_Factory create(Provider<Database> dbProvider,
      Provider<ApiService> apiServiceProvider) {
    return new MainViewModel_Factory(dbProvider, apiServiceProvider);
  }

  public static MainViewModel newInstance(Database db, ApiService apiService) {
    return new MainViewModel(db, apiService);
  }
}
