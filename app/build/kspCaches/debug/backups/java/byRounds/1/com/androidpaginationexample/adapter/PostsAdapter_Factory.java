package com.androidpaginationexample.adapter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class PostsAdapter_Factory implements Factory<PostsAdapter> {
  @Override
  public PostsAdapter get() {
    return newInstance();
  }

  public static PostsAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PostsAdapter newInstance() {
    return new PostsAdapter();
  }

  private static final class InstanceHolder {
    private static final PostsAdapter_Factory INSTANCE = new PostsAdapter_Factory();
  }
}
