package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.LinkedBlockingDeque;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.TimeUnit;

public class PreloadQueue
  implements Comparable
{
  public static final int a = 0;
  public static final String a = "Q.qqstory.download.preload.PreloadQueue";
  public static final int b = 1;
  public LinkedBlockingDeque a;
  public int c;
  public int d;
  public int e;
  
  public PreloadQueue()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new LinkedBlockingDeque();
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int a(PreloadQueue paramPreloadQueue)
  {
    if (this.d > paramPreloadQueue.d) {
      return 1;
    }
    if (this.d < paramPreloadQueue.d) {
      return -1;
    }
    return 0;
  }
  
  public DownloadTask a()
  {
    try
    {
      DownloadTask localDownloadTask = (DownloadTask)this.a.pollFirst(1000L, TimeUnit.MILLISECONDS);
      return localDownloadTask;
    }
    catch (InterruptedException localInterruptedException)
    {
      SLog.d("Q.qqstory.download.preload.PreloadQueue", "getFirst error , current queue id = " + this.c);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.addFirst(paramDownloadTask);
      return;
    }
    this.a.add(paramDownloadTask);
  }
  
  public boolean a()
  {
    return this.a.size() > 0;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\PreloadQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */