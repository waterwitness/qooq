package com.facebook.imagepipeline.core;

import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.HashMap;
import java.util.Map;

public class ProducerSequenceFactory
{
  private static final int MAX_SIMULTANEOUS_FILE_FETCH_AND_RESIZE = 5;
  @VisibleForTesting
  Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;
  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences;
  private Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
  private final boolean mDownsampleEnabled;
  @VisibleForTesting
  Producer<CloseableReference<PooledByteBuffer>> mEncodedImageProducerSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;
  @VisibleForTesting
  Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
  private final NetworkFetcher mNetworkFetcher;
  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences;
  private final ProducerFactory mProducerFactory;
  private final boolean mResizeAndRotateEnabledForNetwork;
  
  public ProducerSequenceFactory(ProducerFactory paramProducerFactory, NetworkFetcher paramNetworkFetcher, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mProducerFactory = paramProducerFactory;
    this.mNetworkFetcher = paramNetworkFetcher;
    this.mResizeAndRotateEnabledForNetwork = paramBoolean1;
    this.mDownsampleEnabled = paramBoolean2;
    this.mPostprocessorSequences = new HashMap();
    this.mCloseableImagePrefetchSequences = new HashMap();
  }
  
  private Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence()
  {
    try
    {
      if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null) {
        this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence());
      }
      Producer localProducer = this.mBackgroundNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    paramImageRequest = paramImageRequest.getSourceUri();
    Preconditions.checkNotNull(paramImageRequest, "Uri is null.");
    if (UriUtil.isNetworkUri(paramImageRequest)) {
      return getNetworkFetchSequence();
    }
    if (UriUtil.isLocalFileUri(paramImageRequest))
    {
      if (MediaUtils.isVideo(MediaUtils.extractMime(paramImageRequest.getPath()))) {
        return getLocalVideoFileFetchSequence();
      }
      return getLocalImageFileFetchSequence();
    }
    if (UriUtil.isLocalContentUri(paramImageRequest)) {
      return getLocalContentUriFetchSequence();
    }
    if (UriUtil.isLocalAssetUri(paramImageRequest)) {
      return getLocalAssetFetchSequence();
    }
    if (UriUtil.isLocalResourceUri(paramImageRequest)) {
      return getLocalResourceFetchSequence();
    }
    if (UriUtil.isDataUri(paramImageRequest)) {
      return getDataFetchSequence();
    }
    String str = paramImageRequest.toString();
    paramImageRequest = str;
    if (str.length() > 30) {
      paramImageRequest = str.substring(0, 30) + "...";
    }
    throw new RuntimeException("Unsupported uri scheme! Uri is: " + paramImageRequest);
  }
  
  private Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence()
  {
    try
    {
      if (this.mCommonNetworkFetchToEncodedMemorySequence == null)
      {
        this.mCommonNetworkFetchToEncodedMemorySequence = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
        if ((this.mResizeAndRotateEnabledForNetwork) && (!this.mDownsampleEnabled)) {
          this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(this.mCommonNetworkFetchToEncodedMemorySequence);
        }
      }
      Producer localProducer = this.mCommonNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getDataFetchSequence()
  {
    try
    {
      if (this.mDataFetchSequence == null)
      {
        Object localObject3 = this.mProducerFactory.newDataFetchProducer();
        localObject1 = localObject3;
        if (Build.VERSION.SDK_INT < 18) {
          localObject1 = this.mProducerFactory.newWebpTranscodeProducer((Producer)localObject3);
        }
        localObject3 = ProducerFactory.newAddImageTransformMetaDataProducer((Producer)localObject1);
        localObject1 = localObject3;
        if (!this.mDownsampleEnabled) {
          localObject1 = this.mProducerFactory.newResizeAndRotateProducer((Producer)localObject3);
        }
        this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence((Producer)localObject1);
      }
      Object localObject1 = this.mDataFetchSequence;
      return (Producer<CloseableReference<CloseableImage>>)localObject1;
    }
    finally {}
  }
  
  private Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      if (!this.mCloseableImagePrefetchSequences.containsKey(paramProducer))
      {
        SwallowResultProducer localSwallowResultProducer = ProducerFactory.newSwallowResultProducer(paramProducer);
        this.mCloseableImagePrefetchSequences.put(paramProducer, localSwallowResultProducer);
      }
      paramProducer = (Producer)this.mCloseableImagePrefetchSequences.get(paramProducer);
      return paramProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence()
  {
    try
    {
      if (this.mLocalAssetFetchSequence == null) {
        this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
      }
      Producer localProducer = this.mLocalAssetFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence()
  {
    try
    {
      if (this.mLocalContentUriFetchSequence == null) {
        this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newContentUriFetchProducer());
      }
      Producer localProducer = this.mLocalContentUriFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence()
  {
    try
    {
      if (this.mLocalImageFileFetchSequence == null) {
        this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
      }
      Producer localProducer = this.mLocalImageFileFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence()
  {
    try
    {
      if (this.mLocalResourceFetchSequence == null) {
        this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
      }
      Producer localProducer = this.mLocalResourceFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence()
  {
    try
    {
      if (this.mLocalVideoFileFetchSequence == null) {
        this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
      }
      Producer localProducer = this.mLocalVideoFileFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence()
  {
    try
    {
      if (this.mNetworkFetchSequence == null) {
        this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
      }
      Producer localProducer = this.mNetworkFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence()
  {
    try
    {
      if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null) {
        this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
      }
      Producer localProducer = this.mNetworkFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      if (!this.mPostprocessorSequences.containsKey(paramProducer))
      {
        Object localObject = this.mProducerFactory.newPostprocessorProducer(paramProducer);
        localObject = this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer((Producer)localObject);
        this.mPostprocessorSequences.put(paramProducer, localObject);
      }
      paramProducer = (Producer)this.mPostprocessorSequences.get(paramProducer);
      return paramProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheProducer(paramProducer);
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(paramProducer);
    paramProducer = this.mProducerFactory.newBackgroundThreadHandoffProducer(paramProducer);
    return this.mProducerFactory.newBitmapMemoryCacheGetProducer(paramProducer);
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> paramProducer)
  {
    return newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(paramProducer));
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer)
  {
    return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(paramProducer)));
  }
  
  private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> paramProducer)
  {
    Object localObject = paramProducer;
    if (Build.VERSION.SDK_INT < 18) {
      localObject = this.mProducerFactory.newWebpTranscodeProducer(paramProducer);
    }
    paramProducer = this.mProducerFactory.newDiskCacheProducer((Producer)localObject);
    paramProducer = this.mProducerFactory.newEncodedMemoryCacheProducer(paramProducer);
    return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(paramProducer);
  }
  
  private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> paramProducer)
  {
    Object localObject = ProducerFactory.newAddImageTransformMetaDataProducer(paramProducer);
    paramProducer = (Producer<EncodedImage>)localObject;
    if (!this.mDownsampleEnabled) {
      paramProducer = this.mProducerFactory.newResizeAndRotateProducer((Producer)localObject);
    }
    ThrottlingProducer localThrottlingProducer = this.mProducerFactory.newThrottlingProducer(5, paramProducer);
    localObject = this.mProducerFactory.newLocalExifThumbnailProducer();
    paramProducer = (Producer<EncodedImage>)localObject;
    if (!this.mDownsampleEnabled) {
      paramProducer = this.mProducerFactory.newResizeAndRotateProducer((Producer)localObject);
    }
    return ProducerFactory.newBranchOnSeparateImagesProducer(paramProducer, localThrottlingProducer);
  }
  
  private static void validateEncodedImageRequest(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    Preconditions.checkArgument(UriUtil.isNetworkUri(paramImageRequest.getSourceUri()));
    if (paramImageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }
  
  public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    return getDecodedImagePrefetchSequence(getBasicDecodedImageSequence(paramImageRequest));
  }
  
  public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    Producer localProducer2 = getBasicDecodedImageSequence(paramImageRequest);
    Producer localProducer1 = localProducer2;
    if (paramImageRequest.getPostprocessor() != null) {
      localProducer1 = getPostprocessorSequence(localProducer2);
    }
    return localProducer1;
  }
  
  public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    return getNetworkFetchToEncodedMemoryPrefetchSequence();
  }
  
  public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    try
    {
      if (this.mEncodedImageProducerSequence == null) {
        this.mEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
      }
      return this.mEncodedImageProducerSequence;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\core\ProducerSequenceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */