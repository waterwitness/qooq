package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PipelineDraweeController
  extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo>
{
  private static final Class<?> TAG = PipelineDraweeController.class;
  private final AnimatedDrawableFactory mAnimatedDrawableFactory;
  private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
  private final Resources mResources;
  
  public PipelineDraweeController(Resources paramResources, DeferredReleaser paramDeferredReleaser, AnimatedDrawableFactory paramAnimatedDrawableFactory, Executor paramExecutor, Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, Object paramObject)
  {
    super(paramDeferredReleaser, paramExecutor, paramString, paramObject);
    this.mResources = paramResources;
    this.mAnimatedDrawableFactory = paramAnimatedDrawableFactory;
    init(paramSupplier);
  }
  
  private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
  }
  
  protected Drawable createDrawable(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    paramCloseableReference = (CloseableImage)paramCloseableReference.get();
    if ((paramCloseableReference instanceof CloseableStaticBitmap))
    {
      paramCloseableReference = (CloseableStaticBitmap)paramCloseableReference;
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.mResources, paramCloseableReference.getUnderlyingBitmap());
      if ((paramCloseableReference.getRotationAngle() == 0) || (paramCloseableReference.getRotationAngle() == -1)) {
        return localBitmapDrawable;
      }
      return new OrientedDrawable(localBitmapDrawable, paramCloseableReference.getRotationAngle());
    }
    if ((paramCloseableReference instanceof CloseableAnimatedImage)) {
      return this.mAnimatedDrawableFactory.create(((CloseableAnimatedImage)paramCloseableReference).getImageResult());
    }
    throw new UnsupportedOperationException("Unrecognized image class: " + paramCloseableReference);
  }
  
  protected DataSource<CloseableReference<CloseableImage>> getDataSource()
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
    }
    return (DataSource)this.mDataSourceSupplier.get();
  }
  
  protected int getImageHash(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      return paramCloseableReference.getValueHash();
    }
    return 0;
  }
  
  protected ImageInfo getImageInfo(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    return (ImageInfo)paramCloseableReference.get();
  }
  
  protected Resources getResources()
  {
    return this.mResources;
  }
  
  public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, Object paramObject)
  {
    super.initialize(paramString, paramObject);
    init(paramSupplier);
  }
  
  protected void releaseDrawable(@Nullable Drawable paramDrawable)
  {
    if ((paramDrawable instanceof DrawableWithCaches)) {
      ((DrawableWithCaches)paramDrawable).dropCaches();
    }
  }
  
  protected void releaseImage(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    CloseableReference.closeSafely(paramCloseableReference);
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\backends\pipeline\PipelineDraweeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */