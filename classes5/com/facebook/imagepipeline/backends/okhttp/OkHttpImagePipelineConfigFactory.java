package com.facebook.imagepipeline.backends.okhttp;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import com.squareup.okhttp.OkHttpClient;

public class OkHttpImagePipelineConfigFactory
{
  public static ImagePipelineConfig.Builder newBuilder(Context paramContext, OkHttpClient paramOkHttpClient)
  {
    return ImagePipelineConfig.newBuilder(paramContext).setNetworkFetcher(new OkHttpNetworkFetcher(paramOkHttpClient));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\backends\okhttp\OkHttpImagePipelineConfigFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */