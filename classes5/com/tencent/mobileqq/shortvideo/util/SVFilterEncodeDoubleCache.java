package com.tencent.mobileqq.shortvideo.util;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicInteger;

public class SVFilterEncodeDoubleCache
{
  public static final int a = 0;
  public static final int b = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SVFilterEncodeDoubleCache.SharedMemoryCache jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache;
  private SVFilterEncodeDoubleCache.SharedMemoryCache b;
  
  public SVFilterEncodeDoubleCache()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache = new SVFilterEncodeDoubleCache.SharedMemoryCache(0);
    this.b = new SVFilterEncodeDoubleCache.SharedMemoryCache(1);
  }
  
  public SVFilterEncodeDoubleCache.SharedMemoryCache a()
  {
    if (SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache).getAndSet(1) == 0) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache;
    }
    if (SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.b).getAndSet(1) == 0) {
      return this.b;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("SharedMemoryCacheProcessor");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache).getAndAdd(0) == 0)
    {
      bool1 = bool2;
      if (SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.b).getAndAdd(0) == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      PtvFilterUtils.a(this.jdField_a_of_type_AndroidOsHandlerThread);
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\SVFilterEncodeDoubleCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */