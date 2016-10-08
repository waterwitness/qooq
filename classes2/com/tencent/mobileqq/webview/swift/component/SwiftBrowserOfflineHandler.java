package com.tencent.mobileqq.webview.swift.component;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bitapp.utils.LruCache;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import wif;
import wih;
import wii;

public class SwiftBrowserOfflineHandler
{
  public static final int a = 1;
  private static final LruCache jdField_a_of_type_ComTencentBitappUtilsLruCache;
  public static final String a;
  public static final int b = 2;
  public static final AtomicInteger b;
  public static final int c = 3;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public final AuthorizeConfig a;
  private final CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public final AtomicInteger a;
  private String b;
  private final AtomicInteger c = new AtomicInteger(1);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SwiftBrowserOfflineHandler.class.getSimpleName();
    jdField_a_of_type_ComTencentBitappUtilsLruCache = new LruCache(8);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  }
  
  private SwiftBrowserOfflineHandler(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
  }
  
  /* Error */
  public static SwiftBrowserOfflineHandler a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifeq +8 -> 19
    //   14: ldc 2
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: ldc 83
    //   22: invokevirtual 89	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: ifne +12 -> 37
    //   28: aload_0
    //   29: ldc 91
    //   31: invokevirtual 89	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifeq -20 -> 14
    //   37: ldc 93
    //   39: astore_1
    //   40: aload_0
    //   41: invokestatic 99	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: invokevirtual 103	android/net/Uri:isHierarchical	()Z
    //   51: ifeq +10 -> 61
    //   54: aload_2
    //   55: ldc 105
    //   57: invokevirtual 109	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_0
    //   61: aload_0
    //   62: invokestatic 111	com/tencent/mobileqq/webview/swift/component/SwiftBrowserOfflineHandler:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserOfflineHandler;
    //   65: astore_1
    //   66: goto -52 -> 14
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   74: aload_1
    //   75: astore_0
    //   76: goto -15 -> 61
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramString	String
    //   1	74	1	localObject	Object
    //   44	11	2	localUri	android.net.Uri
    //   9	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   40	45	69	java/lang/Exception
    //   47	61	69	java/lang/Exception
    //   5	10	79	finally
    //   19	28	79	finally
    //   28	37	79	finally
    //   40	45	79	finally
    //   47	61	79	finally
    //   61	66	79	finally
    //   70	74	79	finally
  }
  
  public static SwiftBrowserOfflineHandler b(String paramString)
  {
    Object localObject = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        SwiftBrowserOfflineHandler localSwiftBrowserOfflineHandler = (SwiftBrowserOfflineHandler)jdField_a_of_type_ComTencentBitappUtilsLruCache.get(paramString);
        localObject = localSwiftBrowserOfflineHandler;
        if (localSwiftBrowserOfflineHandler == null)
        {
          localObject = new SwiftBrowserOfflineHandler(paramString);
          jdField_a_of_type_ComTencentBitappUtilsLruCache.put(paramString, localObject);
        }
      }
      return (SwiftBrowserOfflineHandler)localObject;
    }
    finally {}
  }
  
  private void c()
  {
    this.c.compareAndSet(2, 3);
    new Handler(Looper.getMainLooper()).post(new wii(this));
  }
  
  public void a()
  {
    Object localObject1;
    Object localObject2;
    String str2;
    String str1;
    int i;
    int j;
    if (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("ex_offline", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        localObject2 = Build.BRAND;
        str2 = Build.MODEL;
        str1 = Build.VERSION.RELEASE;
        localObject2 = new StringBuffer((String)localObject2);
        ((StringBuffer)localObject2).append(" ").append(str2);
        str2 = ((StringBuffer)localObject2).toString().toLowerCase();
        str1 = (" " + str1).toLowerCase();
        i = 0;
        j = localObject1.length;
      }
    }
    else
    {
      while (i < j)
      {
        localObject2 = localObject1[i].toLowerCase();
        if ((((String)localObject2).contains(str2)) && (str1.startsWith((String)localObject2)))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "*****offline can not use!!! " + str1);
          jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 4);
          return;
        }
        i += 1;
      }
    }
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 3);
  }
  
  public void a(SwiftBrowserOfflineHandler.CheckOfflineCallback paramCheckOfflineCallback, String paramString)
  {
    if ((this.c.get() == 3) && (paramCheckOfflineCallback != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "now offline bid is ready, " + this.jdField_b_of_type_JavaLangString + ", mode is " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
      paramCheckOfflineCallback.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    do
    {
      return;
      if ((paramCheckOfflineCallback != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramCheckOfflineCallback))) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramCheckOfflineCallback);
      }
      paramCheckOfflineCallback = new wif(this, paramString);
    } while (!this.c.compareAndSet(1, 2));
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "post thread to check offline, bid = " + this.jdField_b_of_type_JavaLangString);
    }
    ThreadManager.a(paramCheckOfflineCallback, new wih(this), false);
  }
  
  public boolean a()
  {
    return this.c.get() == 3;
  }
  
  public void b()
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "now reset bid cache! " + this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.c.set(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserOfflineHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */