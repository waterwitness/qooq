package com.tencent.mobileqq.activity.richmedia.trimvideo.video.mediadevice;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.cache.SDCardMountMonitorReceiver.SDCardMountStateListener;
import java.io.File;

public class StorageManager
  implements SDCardMountMonitorReceiver.SDCardMountStateListener
{
  public static final long a = 209715200L;
  private static StorageManager jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "StorageManager";
  public static final long b = 104857600L;
  public static final long c = 31457280L;
  public static final long d = 10485760L;
  private StorageManager.OnSdCardChangedListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener;
  private String b = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private StorageManager()
  {
    b();
    SDCardMountMonitorReceiver.a().a(this);
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
    catch (Exception paramString)
    {
      QLog.w("StorageManager", 2, "getFreeSpace error", paramString);
    }
    return 0L;
  }
  
  public static StorageManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager = new StorageManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager;
    }
  }
  
  public static String b()
  {
    File localFile1 = null;
    String str2 = null;
    Object localObject = localFile1;
    try
    {
      File localFile2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
      String str1 = str2;
      if (localFile2 != null)
      {
        str1 = str2;
        localObject = localFile1;
        if (localFile2.exists())
        {
          localObject = localFile1;
          str2 = localFile2.getAbsolutePath() + "/Camera";
          localObject = str2;
          localFile1 = new File(str2);
          str1 = str2;
          localObject = str2;
          if (!localFile1.exists())
          {
            localObject = str2;
            localFile1.mkdir();
            str1 = str2;
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      QLog.w("StorageManager", 2, "getCameraDirectoryPath error", localException);
    }
    return (String)localObject;
  }
  
  private void b()
  {
    this.b = CacheManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "updateStorePath, storeVideoPath=" + this.b);
    }
    try
    {
      File localFile = new File(this.b);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StorageManager", 2, "create root path directory error", localException);
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a()
  {
    SDCardMountMonitorReceiver.a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener = null;
    this.b = "";
    jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager = null;
  }
  
  public void a(StorageManager.OnSdCardChangedListener paramOnSdCardChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener = paramOnSdCardChangedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "sdcard mount receiver, isMount=" + paramBoolean);
    }
    String str = CacheManager.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener != null) && (!str.equals(this.b)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener.a(1, this.b);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener.a(0, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\trimvideo\video\mediadevice\StorageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */