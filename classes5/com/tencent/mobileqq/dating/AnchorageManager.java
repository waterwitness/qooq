package com.tencent.mobileqq.dating;

import android.os.Parcelable;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import java.util.Map;

public class AnchorageManager
{
  public static final int a = 3;
  public static final long a = 180000L;
  private LruCache a;
  public String a;
  
  public AnchorageManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "AnchorageManager";
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(3);
  }
  
  /* Error */
  public AnchorageManager.Anchorage a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   6: aload_1
    //   7: invokevirtual 40	android/support/v4/util/LruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 42	java/lang/ref/SoftReference
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +57 -> 72
    //   18: aload_2
    //   19: invokevirtual 46	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   22: checkcast 48	com/tencent/mobileqq/dating/AnchorageManager$Anchorage
    //   25: astore_2
    //   26: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +39 -> 68
    //   32: aload_0
    //   33: getfield 26	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_2
    //   37: new 56	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   44: ldc 59
    //   46: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 65
    //   55: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: areturn
    //   72: aconst_null
    //   73: astore_2
    //   74: goto -48 -> 26
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	AnchorageManager
    //   0	82	1	paramString	String
    //   13	61	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	77	finally
    //   18	26	77	finally
    //   26	68	77	finally
  }
  
  public void a(String paramString, Parcelable paramParcelable, List paramList, Map paramMap)
  {
    a(paramString, paramParcelable, paramList, paramMap, 180000L);
  }
  
  /* Error */
  public void a(String paramString, Parcelable paramParcelable, List paramList, Map paramMap, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +30 -> 35
    //   8: aload_0
    //   9: getfield 26	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: iconst_2
    //   13: new 56	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   20: ldc 82
    //   22: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 33	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   39: aload_1
    //   40: invokevirtual 84	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 42	java/lang/ref/SoftReference
    //   46: astore 7
    //   48: aload 7
    //   50: ifnull +69 -> 119
    //   53: aload 7
    //   55: invokevirtual 46	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   58: checkcast 48	com/tencent/mobileqq/dating/AnchorageManager$Anchorage
    //   61: astore 7
    //   63: aload 7
    //   65: ifnonnull +60 -> 125
    //   68: new 48	com/tencent/mobileqq/dating/AnchorageManager$Anchorage
    //   71: dup
    //   72: aload_2
    //   73: aload_3
    //   74: aload 4
    //   76: invokespecial 87	com/tencent/mobileqq/dating/AnchorageManager$Anchorage:<init>	(Landroid/os/Parcelable;Ljava/util/List;Ljava/util/Map;)V
    //   79: astore 7
    //   81: aload_0
    //   82: getfield 33	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   85: aload_1
    //   86: new 42	java/lang/ref/SoftReference
    //   89: dup
    //   90: aload 7
    //   92: invokespecial 90	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   95: invokevirtual 94	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: invokestatic 99	com/tencent/mobileqq/app/ThreadManager:a	()Ljava/util/Timer;
    //   102: new 101	rcn
    //   105: dup
    //   106: aload_0
    //   107: aload_1
    //   108: invokespecial 104	rcn:<init>	(Lcom/tencent/mobileqq/dating/AnchorageManager;Ljava/lang/String;)V
    //   111: lload 5
    //   113: invokevirtual 110	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: aconst_null
    //   120: astore 7
    //   122: goto -59 -> 63
    //   125: aload 7
    //   127: aload_3
    //   128: putfield 113	com/tencent/mobileqq/dating/AnchorageManager$Anchorage:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   131: aload 7
    //   133: aload_2
    //   134: putfield 116	com/tencent/mobileqq/dating/AnchorageManager$Anchorage:jdField_a_of_type_AndroidOsParcelable	Landroid/os/Parcelable;
    //   137: aload 7
    //   139: aload 4
    //   141: putfield 119	com/tencent/mobileqq/dating/AnchorageManager$Anchorage:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   144: goto -63 -> 81
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	AnchorageManager
    //   0	152	1	paramString	String
    //   0	152	2	paramParcelable	Parcelable
    //   0	152	3	paramList	List
    //   0	152	4	paramMap	Map
    //   0	152	5	paramLong	long
    //   46	92	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	147	finally
    //   35	48	147	finally
    //   53	63	147	finally
    //   68	81	147	finally
    //   81	116	147	finally
    //   125	144	147	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\AnchorageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */