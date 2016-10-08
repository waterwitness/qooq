package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.MonitorReport;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import ihn;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreloadDownloader
{
  public static final long a = 1000L;
  public static final Object a;
  public static final String a = "Q.qqstory.download.preload.PreloadDownloader";
  public static final String b = "PreloadDownloaderThread";
  public volatile int a;
  public volatile DownloadTask a;
  protected FileDownloader a;
  public PreloadDownloaderManager.IOnQueueStateChangeListener a;
  public volatile PreloadQueue a;
  protected ihn a;
  protected Thread a;
  public List a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangObject = PreloadDownloader.class;
  }
  
  public PreloadDownloader()
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader = new FileDownloader();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private ErrorMessage a(DownloadTask paramDownloadTask)
  {
    File localFile = PreloadUtils.a(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask.f);
    if (PreloadUtils.a(localFile))
    {
      paramDownloadTask.c = localFile.getAbsolutePath();
      return new ErrorMessage(12, "");
    }
    paramDownloadTask.jdField_a_of_type_Long = localFile.length();
    long l = System.currentTimeMillis();
    int j;
    if (paramDownloadTask.jdField_a_of_type_Long == 0L)
    {
      i = 1;
      j = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.a(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask.f, paramDownloadTask.b, localFile.getAbsolutePath(), paramDownloadTask.jdField_a_of_type_Long);
      if (j != 0) {
        break label266;
      }
      paramDownloadTask.c = PreloadUtils.a(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask.f).getAbsolutePath();
      if (i != 0) {
        StoryReportor.a("download_video", "video_download_time", 0, (int)(System.currentTimeMillis() - l), new String[] { String.valueOf(new File(paramDownloadTask.c).length()), String.valueOf(paramDownloadTask.f), StoryReportor.a(BaseApplication.getContext()) });
      }
      StoryReportor.a("download_video", "video_download_success", 0, 0, new String[] { String.valueOf(new File(paramDownloadTask.c).length()), String.valueOf(paramDownloadTask.f), StoryReportor.a(BaseApplication.getContext()) });
      if (paramDownloadTask.f != 0) {
        break label260;
      }
      i = 2444472;
      MonitorReport.a(i);
    }
    label260:
    label266:
    while ((j == 6) || (j == 14)) {
      for (;;)
      {
        return new ErrorMessage(j, "");
        i = 0;
        break;
        i = 2444470;
      }
    }
    StoryReportor.a("download_video", "video_download_success", 0, j, new String[] { "0", String.valueOf(paramDownloadTask.f), StoryReportor.a(BaseApplication.getContext()) });
    if (paramDownloadTask.f == 0) {}
    for (int i = 2444471;; i = 2444469)
    {
      MonitorReport.a(i);
      break;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public DownloadTask a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 159	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()Z
    //   6: ifeq +13 -> 19
    //   9: ldc 12
    //   11: ldc -95
    //   13: invokestatic 167	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: new 169	ihn
    //   23: dup
    //   24: aload_0
    //   25: aconst_null
    //   26: invokespecial 172	ihn:<init>	(Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;Lihm;)V
    //   29: putfield 174	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_Ihn	Lihn;
    //   32: aload_0
    //   33: getfield 174	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_Ihn	Lihn;
    //   36: iconst_1
    //   37: putfield 176	ihn:a	Z
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 174	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_Ihn	Lihn;
    //   45: ldc 15
    //   47: iconst_5
    //   48: invokestatic 181	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   51: putfield 183	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   54: aload_0
    //   55: getfield 183	com/tencent/biz/qqstory/base/preload/PreloadDownloader:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   58: invokevirtual 188	java/lang/Thread:start	()V
    //   61: ldc 12
    //   63: ldc -66
    //   65: invokestatic 167	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: goto -52 -> 16
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	PreloadDownloader
    //   71	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	71	finally
    //   19	68	71	finally
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask == paramDownloadTask) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.b != null) && (paramDownloadTask.b != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.b.equals(paramDownloadTask.b)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.a();
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "cancel task " + paramDownloadTask);
    }
  }
  
  public void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramOnPreloadListener = new WeakReference(paramOnPreloadListener);
      this.jdField_a_of_type_JavaUtilList.add(paramOnPreloadListener);
      return;
    }
  }
  
  public void a(PreloadDownloaderManager.IOnQueueStateChangeListener paramIOnQueueStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener = paramIOnQueueStateChangeListener;
  }
  
  public void a(PreloadQueue paramPreloadQueue)
  {
    SLog.d("Q.qqstory.download.preload.PreloadDownloader", "setDownloadQueue queueId = " + paramPreloadQueue);
    this.jdField_a_of_type_Int = paramPreloadQueue.a();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue = paramPreloadQueue;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Ihn != null) && (this.jdField_a_of_type_Ihn.a);
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Ihn != null)
      {
        this.jdField_a_of_type_Ihn.a = false;
        this.jdField_a_of_type_Ihn = null;
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.a();
      }
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "onStop");
      return;
    }
    finally {}
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaLangThread == null) || (!this.jdField_a_of_type_JavaLangThread.isAlive()))
    {
      SLog.e("Q.qqstory.download.preload.PreloadDownloader", "DownloadThread error , restart");
      b();
      a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\PreloadDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */