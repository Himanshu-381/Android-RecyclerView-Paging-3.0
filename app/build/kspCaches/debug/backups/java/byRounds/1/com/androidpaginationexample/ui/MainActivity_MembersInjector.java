package com.androidpaginationexample.ui;

import com.androidpaginationexample.adapter.PostsAdapter;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<PostsAdapter> postsAdapterProvider;

  public MainActivity_MembersInjector(Provider<PostsAdapter> postsAdapterProvider) {
    this.postsAdapterProvider = postsAdapterProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<PostsAdapter> postsAdapterProvider) {
    return new MainActivity_MembersInjector(postsAdapterProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectPostsAdapter(instance, postsAdapterProvider.get());
  }

  @InjectedFieldSignature("com.androidpaginationexample.ui.MainActivity.postsAdapter")
  public static void injectPostsAdapter(MainActivity instance, PostsAdapter postsAdapter) {
    instance.postsAdapter = postsAdapter;
  }
}
