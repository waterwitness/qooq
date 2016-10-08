package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

public class Fresco
{
  private static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;
  
  public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier()
  {
    return sDraweeControllerBuilderSupplier;
  }
  
  public static ImagePipeline getImagePipeline()
  {
    return getImagePipelineFactory().getImagePipeline();
  }
  
  public static ImagePipelineFactory getImagePipelineFactory()
  {
    return ImagePipelineFactory.getInstance();
  }
  
  public static void initialize(Context paramContext)
  {
    ImagePipelineFactory.initialize(paramContext);
    initializeDrawee(paramContext);
  }
  
  public static void initialize(Context paramContext, ImagePipelineConfig paramImagePipelineConfig)
  {
    ImagePipelineFactory.initialize(paramImagePipelineConfig);
    initializeDrawee(paramContext);
  }
  
  private static void initializeDrawee(Context paramContext)
  {
    sDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(paramContext);
    SimpleDraweeView.initialize(sDraweeControllerBuilderSupplier);
  }
  
  public static PipelineDraweeControllerBuilder newDraweeControllerBuilder()
  {
    return sDraweeControllerBuilderSupplier.get();
  }
  
  public static void shutDown()
  {
    sDraweeControllerBuilderSupplier = null;
    SimpleDraweeView.shutDown();
    ImagePipelineFactory.shutDown();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\backends\pipeline\Fresco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */