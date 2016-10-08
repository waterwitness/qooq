import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloadTask.ReportInfo;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderFactory.DownloadConfig;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public final class wfy
  implements INetInfoHandler, DownloaderInterface
{
  public static final String a;
  private DownloaderFactory.DownloadConfig jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  protected AppRuntime a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = wfy.class.getSimpleName();
  }
  
  public wfy(AppRuntime paramAppRuntime, DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    DownloaderFactory.DownloadConfig localDownloadConfig = paramDownloadConfig;
    if (paramDownloadConfig == null) {
      localDownloadConfig = new DownloaderFactory.DownloadConfig();
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = localDownloadConfig;
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private DownloadTask a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (!localDownloadTask.a())
          {
            localDownloadTask.a();
            return localDownloadTask;
          }
        }
      }
      return null;
    }
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "cancelTask stopAll=" + paramBoolean + ",key=" + paramString);
    }
    Object localObject;
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label116;
      }
      if (!paramBoolean) {
        break label120;
      }
      paramString = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (paramString.hasNext())
      {
        localObject = (DownloadTask)paramString.next();
        ((DownloadTask)localObject).a(true);
        ((DownloadTask)localObject).j();
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    for (;;)
    {
      label116:
      return 0;
      label120:
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      ArrayList localArrayList = new ArrayList();
      while (((Iterator)localObject).hasNext())
      {
        DownloadTask localDownloadTask = (DownloadTask)((Iterator)localObject).next();
        if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
        {
          if (!localDownloadTask.a())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localDownloadTask);
          }
          else
          {
            localDownloadTask.a(true);
            localDownloadTask.j();
          }
        }
        else if ((localDownloadTask.b()) && (!localDownloadTask.a()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localDownloadTask);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public DownloadTask a(String paramString)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramString != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | " + paramString + " task find =" + localDownloadTask);
            }
            return localDownloadTask;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | " + paramString + " task not find");
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    a(true, null);
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramDownloadTask != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramDownloadTask)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeTask | task=" + paramDownloadTask);
        }
        paramDownloadTask.j();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramDownloadTask);
      }
      return;
    }
    finally {}
  }
  
  public void a(DownloadTask paramDownloadTask, DownloadListener arg2, Bundle paramBundle)
  {
    if ((!DownloaderFactory.a(paramDownloadTask)) || (a(paramDownloadTask.jdField_a_of_type_JavaLangString) == paramDownloadTask)) {}
    DownloadTask localDownloadTask;
    do
    {
      return;
      localDownloadTask = a(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localDownloadTask == null) {
        break;
      }
    } while ((localDownloadTask == null) || (!localDownloadTask.o));
    paramDownloadTask.a(???);
    paramDownloadTask.a(paramBundle);
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a < 0L)) {
      paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a = Long.parseLong(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    }
    localDownloadTask.a(paramDownloadTask);
    return;
    paramDownloadTask.a(???);
    paramDownloadTask.a(paramBundle);
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a < 0L)) {
      paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a = Long.parseLong(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (a(paramDownloadTask.jdField_a_of_type_JavaLangString) == null)
      {
        paramDownloadTask.c = ((int)(System.currentTimeMillis() / 1000L));
        if (paramDownloadTask.b) {
          this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramDownloadTask);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownload | task=" + paramDownloadTask.jdField_a_of_type_JavaLangString);
        }
        c();
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramDownloadTask);
    }
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: getstatic 30	wfy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: ldc -14
    //   14: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 49	wfy:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   21: invokevirtual 73	java/util/LinkedList:isEmpty	()Z
    //   24: ifne +202 -> 226
    //   27: invokestatic 222	java/lang/System:currentTimeMillis	()J
    //   30: ldc2_w 223
    //   33: ldiv
    //   34: l2i
    //   35: istore 5
    //   37: aload_0
    //   38: getfield 49	wfy:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   41: iconst_0
    //   42: aload_0
    //   43: getfield 49	wfy:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   46: invokevirtual 246	java/util/LinkedList:size	()I
    //   49: invokevirtual 250	java/util/LinkedList:subList	(II)Ljava/util/List;
    //   52: invokeinterface 253 1 0
    //   57: astore_2
    //   58: new 100	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   65: astore_3
    //   66: aload_2
    //   67: invokeinterface 82 1 0
    //   72: ifeq +121 -> 193
    //   75: aload_2
    //   76: invokeinterface 86 1 0
    //   81: checkcast 88	com/tencent/mobileqq/vip/DownloadTask
    //   84: astore 4
    //   86: aload 4
    //   88: invokevirtual 90	com/tencent/mobileqq/vip/DownloadTask:a	()Z
    //   91: ifne -25 -> 66
    //   94: aload 4
    //   96: getfield 255	com/tencent/mobileqq/vip/DownloadTask:d	J
    //   99: lconst_0
    //   100: lcmp
    //   101: ifle -35 -> 66
    //   104: iload 5
    //   106: i2l
    //   107: aload 4
    //   109: getfield 227	com/tencent/mobileqq/vip/DownloadTask:c	J
    //   112: aload 4
    //   114: getfield 255	com/tencent/mobileqq/vip/DownloadTask:d	J
    //   117: ladd
    //   118: lcmp
    //   119: ifle -53 -> 66
    //   122: aload 4
    //   124: bipush -102
    //   126: putfield 259	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   129: aload 4
    //   131: iconst_m1
    //   132: invokevirtual 261	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   135: aload 4
    //   137: invokevirtual 264	com/tencent/mobileqq/vip/DownloadTask:f	()V
    //   140: aload 4
    //   142: invokevirtual 125	com/tencent/mobileqq/vip/DownloadTask:j	()V
    //   145: aload_0
    //   146: getfield 49	wfy:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   149: astore_1
    //   150: aload_1
    //   151: monitorenter
    //   152: aload_0
    //   153: getfield 49	wfy:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   156: aload 4
    //   158: invokevirtual 180	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   161: pop
    //   162: aload_1
    //   163: monitorexit
    //   164: aload_3
    //   165: aload 4
    //   167: getfield 137	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 266
    //   176: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: goto -114 -> 66
    //   183: astore_1
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    //   188: astore_2
    //   189: aload_1
    //   190: monitorexit
    //   191: aload_2
    //   192: athrow
    //   193: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +30 -> 226
    //   199: getstatic 30	wfy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: iconst_2
    //   203: new 100	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 268
    //   213: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_3
    //   217: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +13 -> 242
    //   232: getstatic 30	wfy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   235: iconst_2
    //   236: ldc_w 270
    //   239: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload_0
    //   243: monitorexit
    //   244: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	wfy
    //   183	7	1	localObject1	Object
    //   57	19	2	localIterator	Iterator
    //   188	4	2	localObject2	Object
    //   65	152	3	localStringBuilder	StringBuilder
    //   84	82	4	localDownloadTask	DownloadTask
    //   35	70	5	i	int
    // Exception table:
    //   from	to	target	type
    //   2	17	183	finally
    //   17	66	183	finally
    //   66	152	183	finally
    //   164	180	183	finally
    //   191	193	183	finally
    //   193	226	183	finally
    //   226	242	183	finally
    //   152	164	188	finally
    //   189	191	188	finally
  }
  
  void c()
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
          if (!localIterator.hasNext()) {
            break label176;
          }
          DownloadTask localDownloadTask2 = (DownloadTask)localIterator.next();
          if (localDownloadTask2.d <= 0L) {
            break label309;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localDownloadTask2.a()) && (l > localDownloadTask2.c + localDownloadTask2.d))
          {
            bool = true;
            if ((!localDownloadTask2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "remove task[" + localDownloadTask2.jdField_a_of_type_JavaLangString + "], isCancal=" + localDownloadTask2.b() + ", timeOut=" + bool);
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label176:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doTask | downloadLimitCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",maxDownloadCount=" + 5 + ",downloadQueue size=" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      for (;;)
      {
        DownloadTask localDownloadTask1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 5)
        {
          localDownloadTask1 = a();
          if (localDownloadTask1 != null) {
            break label282;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "doTask | run() null");
          }
        }
        return;
        label282:
        ThreadManager.b(new wfz(this, localDownloadTask1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label309:
      boolean bool = false;
    }
  }
  
  public void onNetMobile2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "queueDownload network-onNetMobile2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.a() == 2) {
            localDownloadTask.i();
          }
        }
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "queueDownload network-onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "queueDownload network-onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "queueDownload network-onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.a() == 2) {
            localDownloadTask.g();
          }
        }
      }
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "queueDownload network-onNetWifi2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.a() == 2) {
            localDownloadTask.h();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */