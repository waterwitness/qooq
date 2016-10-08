package com.tencent.mobileqq.shortvideo.util.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import usx;

public class StorageManager
{
  public static final long a = 57671680L;
  static StorageManager jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager;
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "StorageManager";
  public static final long b = 314572800L;
  static final String b = "/Android/data/com.tencent.mobileqq/qq/video";
  public static long c = 0L;
  public static final long d = 31457280L;
  public static final long e = 10485760L;
  final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new usx(this);
  public StorageManager.OnSdCardChangedListener a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean;
  public String c;
  public String d = "";
  long f = 0L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_Long = 57671680L;
  }
  
  StorageManager()
  {
    this.jdField_c_of_type_JavaLangString = "";
    c();
    b();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addDataScheme("file");
    VideoEnvironment.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static long a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getAvailableBlocks();
      int i = paramString.getBlockSize();
      return l * i;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static StorageManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager = new StorageManager();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager;
    }
  }
  
  /* Error */
  static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 133	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: invokevirtual 137	java/lang/Thread:getId	()J
    //   9: lstore_2
    //   10: new 139	java/io/File
    //   13: dup
    //   14: new 141	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   21: aload_0
    //   22: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc -108
    //   27: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload_2
    //   31: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   34: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 160	java/io/File:exists	()Z
    //   45: ifeq +24 -> 69
    //   48: aload_0
    //   49: invokevirtual 163	java/io/File:delete	()Z
    //   52: ifeq +9 -> 61
    //   55: aload_0
    //   56: invokevirtual 166	java/io/File:createNewFile	()Z
    //   59: istore 4
    //   61: aload_0
    //   62: invokevirtual 163	java/io/File:delete	()Z
    //   65: pop
    //   66: iload 4
    //   68: ireturn
    //   69: aload_0
    //   70: invokevirtual 166	java/io/File:createNewFile	()Z
    //   73: istore 4
    //   75: goto -14 -> 61
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 169	java/lang/Throwable:printStackTrace	()V
    //   83: aload_0
    //   84: invokevirtual 163	java/io/File:delete	()Z
    //   87: pop
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_1
    //   91: aload_0
    //   92: invokevirtual 163	java/io/File:delete	()Z
    //   95: pop
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   78	2	1	localThrowable	Throwable
    //   90	7	1	localObject	Object
    //   9	22	2	l	long
    //   1	73	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   41	48	78	java/lang/Throwable
    //   48	61	78	java/lang/Throwable
    //   69	75	78	java/lang/Throwable
    //   41	48	90	finally
    //   48	61	90	finally
    //   69	75	90	finally
    //   79	83	90	finally
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      VideoEnvironment.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(StorageManager.OnSdCardChangedListener paramOnSdCardChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager$OnSdCardChangedListener = paramOnSdCardChangedListener;
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      this.d = (this.jdField_c_of_type_JavaLangString + "/Android/data/com.tencent.mobileqq/qq/video");
      if (QLog.isColorLevel())
      {
        QLog.e("TAG", 2, "updateStorePath:storeVideoPath=" + this.d);
        QLog.e("TAG", 2, "updateStorePath:maxAvailableSizePath=" + this.jdField_c_of_type_JavaLangString);
      }
      try
      {
        File localFile = new File(this.d);
        if (!localFile.exists())
        {
          localFile.mkdirs();
          return;
        }
      }
      catch (Exception localException)
      {
        this.jdField_c_of_type_JavaLangString = null;
      }
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_c_of_type_JavaLangString = "";
      this.f = 0L;
      Object localObject1 = Environment.getExternalStorageDirectory().getAbsolutePath();
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(localObject1)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("external_card", localObject1);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          try
          {
            Object localObject3 = new File(str);
            if ((((File)localObject3).exists()) && (((File)localObject3).canWrite()) && (a(str)))
            {
              localObject3 = new StatFs(str);
              long l = ((StatFs)localObject3).getAvailableBlocks() * ((StatFs)localObject3).getBlockSize();
              if ((l > 0L) && (this.f < l))
              {
                this.f = l;
                this.jdField_c_of_type_JavaLangString = str;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\storage\StorageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */