package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import javax.annotation.Nullable;

public class PipelineDraweeControllerBuilder
  extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo>
{
  private final ImagePipeline mImagePipeline;
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;
  
  public PipelineDraweeControllerBuilder(Context paramContext, PipelineDraweeControllerFactory paramPipelineDraweeControllerFactory, ImagePipeline paramImagePipeline, Set<ControllerListener> paramSet)
  {
    super(paramContext, paramSet);
    this.mImagePipeline = paramImagePipeline;
    this.mPipelineDraweeControllerFactory = paramPipelineDraweeControllerFactory;
  }
  
  protected DataSource<CloseableReference<CloseableImage>> getDataSourceForRequest(ImageRequest paramImageRequest, Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mImagePipeline.fetchImageFromBitmapCache(paramImageRequest, paramObject);
    }
    return this.mImagePipeline.fetchDecodedImage(paramImageRequest, paramObject);
  }
  
  protected PipelineDraweeControllerBuilder getThis()
  {
    return this;
  }
  
  protected PipelineDraweeController obtainController()
  {
    Object localObject = getOldController();
    if ((localObject instanceof PipelineDraweeController))
    {
      localObject = (PipelineDraweeController)localObject;
      ((PipelineDraweeController)localObject).initialize(obtainDataSourceSupplier(), generateUniqueControllerId(), getCallerContext());
      return (PipelineDraweeController)localObject;
    }
    return this.mPipelineDraweeControllerFactory.newController(obtainDataSourceSupplier(), generateUniqueControllerId(), getCallerContext());
  }
  
  public PipelineDraweeControllerBuilder setUri(Uri paramUri)
  {
    return (PipelineDraweeControllerBuilder)super.setImageRequest(ImageRequest.fromUri(paramUri));
  }
  
  public PipelineDraweeControllerBuilder setUri(@Nullable String paramString)
  {
    return (PipelineDraweeControllerBuilder)super.setImageRequest(ImageRequest.fromUri(paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\backends\pipeline\PipelineDraweeControllerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */