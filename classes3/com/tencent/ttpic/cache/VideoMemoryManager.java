package com.tencent.ttpic.cache;

public class VideoMemoryManager
{
  private static final String TAG = VideoMemoryManager.class.getSimpleName();
  public static final int VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB = 40960;
  private static final VideoMemoryManager mInstance = new VideoMemoryManager();
  private VideoImageCache2 mVideoImageCache2;
  
  public static VideoMemoryManager getInstance()
  {
    return mInstance;
  }
  
  public VideoImageCache2 getVideoImageCache()
  {
    if (this.mVideoImageCache2 == null) {
      this.mVideoImageCache2 = new VideoImageCache2();
    }
    return this.mVideoImageCache2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\cache\VideoMemoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */