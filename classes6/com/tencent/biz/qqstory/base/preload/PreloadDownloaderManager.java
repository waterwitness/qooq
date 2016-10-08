package com.tencent.biz.qqstory.base.preload;

import android.content.Context;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iho;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class PreloadDownloaderManager
  implements IManager
{
  public static final int a = 0;
  public static final String a = "Q.qqstory.download.preload.PreloadDownloaderManager";
  public static final int b = 1;
  public static final int c = 2;
  public DumpDialog a;
  public PreloadDownloader a;
  public PreloadDownloaderManager.IOnQueueStateChangeListener a;
  public Runnable a;
  public HashMap a;
  public List a;
  public Map a;
  public int d;
  
  public PreloadDownloaderManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener = new PreloadDownloaderManager.OnQueueStateChangeListener(this);
    this.d = 0;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a()
  {
    Object localObject = new PreloadQueue.Builder();
    ((PreloadQueue.Builder)localObject).a(0).c(Integer.MAX_VALUE).b(1);
    PreloadQueue localPreloadQueue = ((PreloadQueue.Builder)localObject).a();
    PreloadQueue.Builder localBuilder = new PreloadQueue.Builder();
    ((PreloadQueue.Builder)localObject).a(1).c(Integer.MAX_VALUE).b(0);
    localObject = localBuilder.a();
    this.jdField_a_of_type_JavaUtilList.add(localPreloadQueue);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localPreloadQueue.a()), localPreloadQueue);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((PreloadQueue)localObject).a()), localObject);
    Collections.sort(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader = new PreloadDownloader();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a((PreloadQueue)this.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: iload_1
    //   7: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 87	com/tencent/biz/qqstory/base/preload/PreloadQueue
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +30 -> 48
    //   21: ldc 12
    //   23: new 124	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   30: ldc 127
    //   32: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_1
    //   36: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 143	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: getfield 111	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   52: invokevirtual 144	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()I
    //   55: istore 4
    //   57: aload_0
    //   58: getfield 111	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   61: invokevirtual 147	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()Lcom/tencent/biz/qqstory/base/preload/DownloadTask;
    //   64: astore_3
    //   65: aload_2
    //   66: invokevirtual 149	com/tencent/biz/qqstory/base/preload/PreloadQueue:b	()V
    //   69: ldc 12
    //   71: new 124	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   78: ldc -105
    //   80: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: iload_1
    //   84: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: ldc -103
    //   89: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 4
    //   94: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 155	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: iload 4
    //   105: iload_1
    //   106: if_icmpne -61 -> 45
    //   109: aload_0
    //   110: getfield 111	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   113: aload_3
    //   114: invokevirtual 158	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	(Lcom/tencent/biz/qqstory/base/preload/DownloadTask;)V
    //   117: goto -72 -> 45
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	PreloadDownloaderManager
    //   0	125	1	paramInt	int
    //   16	50	2	localPreloadQueue	PreloadQueue
    //   120	4	2	localObject	Object
    //   64	50	3	localDownloadTask	DownloadTask
    //   55	52	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	17	120	finally
    //   21	45	120	finally
    //   48	103	120	finally
    //   109	117	120	finally
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaLangRunnable = new iho(this);
    ThreadManager.c().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void a(Context paramContext, int paramInt) {}
  
  public void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(paramOnPreloadListener);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: iload_3
    //   7: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 87	com/tencent/biz/qqstory/base/preload/PreloadQueue
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +30 -> 50
    //   23: ldc 12
    //   25: new 124	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   32: ldc 127
    //   34: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload_3
    //   38: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 143	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 111	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   54: invokevirtual 147	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()Lcom/tencent/biz/qqstory/base/preload/DownloadTask;
    //   57: astore 7
    //   59: aload 6
    //   61: aload_1
    //   62: aload_2
    //   63: iload 4
    //   65: invokestatic 186	com/tencent/biz/qqstory/base/preload/DownloadTask:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/biz/qqstory/base/preload/DownloadTask;
    //   68: iload 5
    //   70: invokevirtual 189	com/tencent/biz/qqstory/base/preload/PreloadQueue:a	(Lcom/tencent/biz/qqstory/base/preload/DownloadTask;Z)V
    //   73: aload_0
    //   74: getfield 111	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   77: invokevirtual 144	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()I
    //   80: istore 4
    //   82: iload 5
    //   84: istore 8
    //   86: aload 6
    //   88: invokevirtual 191	com/tencent/biz/qqstory/base/preload/PreloadQueue:b	()I
    //   91: ifne +25 -> 116
    //   94: iload 5
    //   96: istore 8
    //   98: iload 4
    //   100: iload_3
    //   101: if_icmpeq +15 -> 116
    //   104: aload_0
    //   105: getfield 111	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   108: aload 6
    //   110: invokevirtual 120	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	(Lcom/tencent/biz/qqstory/base/preload/PreloadQueue;)V
    //   113: iconst_1
    //   114: istore 8
    //   116: iload 8
    //   118: ifeq -71 -> 47
    //   121: aload_0
    //   122: getfield 111	com/tencent/biz/qqstory/base/preload/PreloadDownloaderManager:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   125: aload 7
    //   127: invokevirtual 158	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	(Lcom/tencent/biz/qqstory/base/preload/DownloadTask;)V
    //   130: goto -83 -> 47
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	PreloadDownloaderManager
    //   0	138	1	paramString1	String
    //   0	138	2	paramString2	String
    //   0	138	3	paramInt1	int
    //   0	138	4	paramInt2	int
    //   0	138	5	paramBoolean	boolean
    //   16	93	6	localPreloadQueue	PreloadQueue
    //   57	69	7	localDownloadTask	DownloadTask
    //   84	33	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	133	finally
    //   23	47	133	finally
    //   50	82	133	finally
    //   86	94	133	finally
    //   104	113	133	finally
    //   121	130	133	finally
  }
  
  public void a(List paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      PreloadQueue localPreloadQueue;
      try
      {
        localPreloadQueue = (PreloadQueue)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localPreloadQueue == null)
        {
          SLog.d("Q.qqstory.download.preload.PreloadDownloaderManager", "cannot find queue , id = " + paramInt);
          continue;
        }
      }
      finally {}
      DownloadTask localDownloadTask = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
      localPreloadQueue.b();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localPreloadQueue.a((DownloadTask)paramList.next(), false);
      }
      int i = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
      boolean bool = paramBoolean;
      if (localPreloadQueue.b() == 0)
      {
        bool = paramBoolean;
        if (i != paramInt)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localPreloadQueue);
          bool = true;
        }
      }
      if (bool) {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localDownloadTask);
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangRunnable == null) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a());
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((PreloadQueue)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    a(0L);
  }
  
  public void b(int paramInt) {}
  
  public void b(Context paramContext, int paramInt) {}
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.c().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.c();
  }
  
  public void e() {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\PreloadDownloaderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */