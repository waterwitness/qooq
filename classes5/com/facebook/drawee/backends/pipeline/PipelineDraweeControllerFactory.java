package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;

public class PipelineDraweeControllerFactory
{
  private AnimatedDrawableFactory mAnimatedDrawableFactory;
  private DeferredReleaser mDeferredReleaser;
  private Resources mResources;
  private Executor mUiThreadExecutor;
  
  public PipelineDraweeControllerFactory(Resources paramResources, DeferredReleaser paramDeferredReleaser, AnimatedDrawableFactory paramAnimatedDrawableFactory, Executor paramExecutor)
  {
    this.mResources = paramResources;
    this.mDeferredReleaser = paramDeferredReleaser;
    this.mAnimatedDrawableFactory = paramAnimatedDrawableFactory;
    this.mUiThreadExecutor = paramExecutor;
  }
  
  public PipelineDraweeController newController(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, Object paramObject)
  {
    return new PipelineDraweeController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, paramSupplier, paramString, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\backends\pipeline\PipelineDraweeControllerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */