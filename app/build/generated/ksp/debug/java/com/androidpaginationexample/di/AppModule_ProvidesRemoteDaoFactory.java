package com.androidpaginationexample.di;

import com.androidpaginationexample.data.dao.RemoteKeysDao;
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
public final class AppModule_ProvidesRemoteDaoFactory implements Factory<RemoteKeysDao> {
  private final Provider<Database> databaseProvider;

  public AppModule_ProvidesRemoteDaoFactory(Provider<Database> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public RemoteKeysDao get() {
    return providesRemoteDao(databaseProvider.get());
  }

  public static AppModule_ProvidesRemoteDaoFactory create(Provider<Database> databaseProvider) {
    return new AppModule_ProvidesRemoteDaoFactory(databaseProvider);
  }

  public static RemoteKeysDao providesRemoteDao(Database database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesRemoteDao(database));
  }
}
