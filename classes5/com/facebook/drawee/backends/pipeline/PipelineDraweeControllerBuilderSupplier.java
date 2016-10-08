package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Set;

public class PipelineDraweeControllerBuilderSupplier
  implements Supplier<PipelineDraweeControllerBuilder>
{
  private final Set<ControllerListener> mBoundControllerListeners;
  private final Context mContext;
  private final ImagePipeline mImagePipeline;
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext)
  {
    this(paramContext, ImagePipelineFactory.getInstance());
  }
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory)
  {
    this(paramContext, paramImagePipelineFactory, null);
  }
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, Set<ControllerListener> paramSet)
  {
    this.mContext = paramContext;
    this.mImagePipeline = paramImagePipelineFactory.getImagePipeline();
    this.mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory(paramContext.getResources(), DeferredReleaser.getInstance(), paramImagePipelineFactory.getAnimatedDrawableFactory(), UiThreadImmediateExecutorService.getInstance());
    this.mBoundControllerListeners = paramSet;
  }
  
  public PipelineDraweeControllerBuilder get()
  {
    return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\backends\pipeline\PipelineDraweeControllerBuilderSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */