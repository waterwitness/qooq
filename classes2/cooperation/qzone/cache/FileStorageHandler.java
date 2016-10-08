package cooperation.qzone.cache;

import android.os.StatFs;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import ylv;
import ylw;
import ylx;
import yly;
import ylz;

public class FileStorageHandler
  implements FileCacheService.StorageHandler
{
  private static final float jdField_a_of_type_Float = 0.1F;
  private static final int jdField_a_of_type_Int = 2;
  private static final long jdField_a_of_type_Long = 1048576L;
  private static FilenameFilter jdField_a_of_type_JavaIoFilenameFilter;
  private static Comparator jdField_a_of_type_JavaUtilComparator = new yly();
  private static final float jdField_b_of_type_Float = 0.05F;
  private static final int jdField_b_of_type_Int = 60000;
  private static final long jdField_b_of_type_Long = 20971520L;
  private static FilenameFilter jdField_b_of_type_JavaIoFilenameFilter;
  private static final float jdField_c_of_type_Float = 0.02F;
  private static final int jdField_c_of_type_Int = 1800000;
  private static final float jdField_d_of_type_Float = 0.1F;
  private static final int jdField_d_of_type_Int = 6;
  private static final float jdField_e_of_type_Float = 0.8F;
  private Future jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture;
  private final FileStorageHandler.Collector jdField_a_of_type_CooperationQzoneCacheFileStorageHandler$Collector;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private long jdField_c_of_type_Long;
  private int jdField_e_of_type_Int;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaIoFilenameFilter = new ylw();
    b = new ylx();
  }
  
  public FileStorageHandler(FileStorageHandler.Collector paramCollector)
  {
    this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler$Collector = paramCollector;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt1;
    }
    if (paramInt2 / paramInt1 < 0.120000005F) {}
    for (float f = 0.05F;; f = 0.1F) {
      return (int)(f * paramInt1);
    }
  }
  
  private int a(String paramString)
  {
    int k = 0;
    int j = 0;
    paramString = new File(paramString);
    int i = k;
    if (paramString.exists())
    {
      i = k;
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles(jdField_a_of_type_JavaIoFilenameFilter);
        i = k;
        if (paramString != null)
        {
          i = k;
          if (paramString.length > 0) {
            for (i = 0; j < paramString.length; i = k)
            {
              k = i;
              if (paramString[j] != null)
              {
                k = i;
                if (paramString[j].getName() != null) {
                  k = (int)(i + paramString[j].length());
                }
              }
              j += 1;
            }
          }
        }
      }
    }
    return i;
  }
  
  private boolean a()
  {
    long l1 = ((1.0F - 1.0F / (this.e / 6.0F + 1.0F)) * 1800000.0F);
    long l2 = System.currentTimeMillis();
    if (l2 - this.c >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (this.e < Integer.MAX_VALUE) {
          this.e += 1;
        }
        this.c = l2;
      }
      return bool;
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < 20971520L) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w(CacheManager.a, 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l + ", external=" + paramString);
        }
        return bool;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QLog.e(CacheManager.a, 1, "", paramString);
    }
  }
  
  private void b()
  {
    if (!a()) {
      return;
    }
    QQToast.a(BaseApplication.getContext(), 2131371320, 1).a();
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture != null) && (!this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture.isDone())) {
        return;
      }
      boolean bool = CacheManager.a();
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture = PriorityThreadPool.getDefault().submit(new ylz(this, bool));
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        paramString = new File(paramString);
        Object localObject;
        int j;
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localObject = paramString.listFiles(b);
          if ((localObject != null) && (localObject.length > 0))
          {
            paramString = new ArrayList(localObject.length);
            if (i < localObject.length)
            {
              paramString.add(localObject[i]);
              i += 1;
              continue;
            }
            Collections.sort(paramString, jdField_a_of_type_JavaUtilComparator);
            j = ".lru".length();
          }
        }
        try
        {
          i = paramString.size() - 1;
          if (i > 0)
          {
            localObject = (File)paramString.get(i);
            ((File)localObject).delete();
            localObject = ((File)localObject).getAbsolutePath();
            localObject = new File(((String)localObject).substring(0, ((String)localObject).length() - j));
            if (!((File)localObject).exists()) {
              break label252;
            }
            l2 = ((File)localObject).length();
            paramInt1 = (int)(paramInt1 - l2);
            ((File)localObject).delete();
            if (paramInt1 >= paramInt2) {
              break label255;
            }
          }
        }
        catch (Exception paramString)
        {
          long l2;
          paramString.printStackTrace();
          continue;
        }
        l2 = System.currentTimeMillis();
        QLog.w(CacheManager.a, 1, "onLowStorage time:" + (l2 - l1));
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e(CacheManager.a, 1, "", paramString);
        return;
      }
      label252:
      continue;
      label255:
      i -= 1;
    }
  }
  
  public void a(FileCacheService paramFileCacheService, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    try
    {
      if ((this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture != null) && (!this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture.isDone())) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture = PriorityThreadPool.getDefault().submit(new ylv(this, paramBoolean));
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 79	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 86	java/io/File:exists	()Z
    //   13: ifeq +230 -> 243
    //   16: aload_1
    //   17: invokevirtual 89	java/io/File:isDirectory	()Z
    //   20: ifeq +223 -> 243
    //   23: aload_1
    //   24: getstatic 46	cooperation/qzone/cache/FileStorageHandler:jdField_a_of_type_JavaIoFilenameFilter	Ljava/io/FilenameFilter;
    //   27: invokevirtual 93	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +211 -> 243
    //   35: aload_3
    //   36: arraylength
    //   37: ifle +206 -> 243
    //   40: lconst_0
    //   41: lstore 5
    //   43: iconst_0
    //   44: istore 4
    //   46: iload 4
    //   48: aload_3
    //   49: arraylength
    //   50: if_icmpge +24 -> 74
    //   53: lload 5
    //   55: aload_3
    //   56: iload 4
    //   58: aaload
    //   59: invokevirtual 101	java/io/File:length	()J
    //   62: ladd
    //   63: lstore 5
    //   65: iload 4
    //   67: iconst_1
    //   68: iadd
    //   69: istore 4
    //   71: goto -25 -> 46
    //   74: lload 5
    //   76: iload_2
    //   77: i2l
    //   78: lcmp
    //   79: ifle +164 -> 243
    //   82: getstatic 135	cooperation/qzone/cache/CacheManager:a	Ljava/lang/String;
    //   85: iconst_1
    //   86: ldc_w 265
    //   89: invokestatic 163	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: iload_2
    //   93: i2f
    //   94: ldc 28
    //   96: fmul
    //   97: f2l
    //   98: lstore 7
    //   100: aload_1
    //   101: getstatic 51	cooperation/qzone/cache/FileStorageHandler:b	Ljava/io/FilenameFilter;
    //   104: invokevirtual 93	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   107: astore_3
    //   108: aload_3
    //   109: ifnull +134 -> 243
    //   112: aload_3
    //   113: arraylength
    //   114: ifle +129 -> 243
    //   117: new 213	java/util/ArrayList
    //   120: dup
    //   121: aload_3
    //   122: arraylength
    //   123: invokespecial 214	java/util/ArrayList:<init>	(I)V
    //   126: astore_1
    //   127: iconst_0
    //   128: istore_2
    //   129: iload_2
    //   130: aload_3
    //   131: arraylength
    //   132: if_icmpge +18 -> 150
    //   135: aload_1
    //   136: aload_3
    //   137: iload_2
    //   138: aaload
    //   139: invokevirtual 218	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   142: pop
    //   143: iload_2
    //   144: iconst_1
    //   145: iadd
    //   146: istore_2
    //   147: goto -18 -> 129
    //   150: aload_1
    //   151: getstatic 56	cooperation/qzone/cache/FileStorageHandler:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   154: invokestatic 224	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   157: ldc -30
    //   159: invokevirtual 230	java/lang/String:length	()I
    //   162: istore 4
    //   164: aload_1
    //   165: invokevirtual 233	java/util/ArrayList:size	()I
    //   168: iconst_1
    //   169: isub
    //   170: istore_2
    //   171: iload_2
    //   172: ifle +71 -> 243
    //   175: aload_1
    //   176: iload_2
    //   177: invokevirtual 237	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   180: checkcast 79	java/io/File
    //   183: astore_3
    //   184: aload_3
    //   185: invokevirtual 240	java/io/File:delete	()Z
    //   188: pop
    //   189: aload_3
    //   190: invokevirtual 243	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   193: astore_3
    //   194: new 79	java/io/File
    //   197: dup
    //   198: aload_3
    //   199: iconst_0
    //   200: aload_3
    //   201: invokevirtual 230	java/lang/String:length	()I
    //   204: iload 4
    //   206: isub
    //   207: invokevirtual 247	java/lang/String:substring	(II)Ljava/lang/String;
    //   210: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   213: astore_3
    //   214: aload_3
    //   215: invokevirtual 86	java/io/File:exists	()Z
    //   218: ifeq +51 -> 269
    //   221: lload 5
    //   223: aload_3
    //   224: invokevirtual 101	java/io/File:length	()J
    //   227: lsub
    //   228: lstore 5
    //   230: aload_3
    //   231: invokevirtual 240	java/io/File:delete	()Z
    //   234: pop
    //   235: lload 5
    //   237: lload 7
    //   239: lcmp
    //   240: ifge +4 -> 244
    //   243: return
    //   244: iload_2
    //   245: iconst_1
    //   246: isub
    //   247: istore_2
    //   248: goto -77 -> 171
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   256: return
    //   257: astore_1
    //   258: getstatic 135	cooperation/qzone/cache/CacheManager:a	Ljava/lang/String;
    //   261: iconst_1
    //   262: ldc -91
    //   264: aload_1
    //   265: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: return
    //   269: goto -34 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	FileStorageHandler
    //   0	272	1	paramString	String
    //   0	272	2	paramInt	int
    //   30	201	3	localObject	Object
    //   44	163	4	i	int
    //   41	195	5	l1	long
    //   98	140	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   164	171	251	java/lang/Exception
    //   175	235	251	java/lang/Exception
    //   0	31	257	java/lang/Throwable
    //   35	40	257	java/lang/Throwable
    //   46	65	257	java/lang/Throwable
    //   82	92	257	java/lang/Throwable
    //   100	108	257	java/lang/Throwable
    //   112	127	257	java/lang/Throwable
    //   129	143	257	java/lang/Throwable
    //   150	164	257	java/lang/Throwable
    //   164	171	257	java/lang/Throwable
    //   175	235	257	java/lang/Throwable
    //   252	256	257	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\cache\FileStorageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */