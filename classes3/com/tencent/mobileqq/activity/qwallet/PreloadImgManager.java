package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import oth;
import oti;
import otk;
import otl;
import otm;
import otn;

public class PreloadImgManager
{
  private static final int jdField_a_of_type_Int = 20;
  private static PreloadImgManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager;
  private static final String jdField_a_of_type_JavaLangString = "PreloadImgManager";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static final String b = "/preload/";
  private static final String c = "urlList.cfg";
  private static final String d = "@xhdpi.png";
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new oth(this, (int)(Runtime.getRuntime().maxMemory() / 1024L / 1024L));
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new oti(this);
  DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  public DownloaderInterface a;
  private Map jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap(6));
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private Bitmap a(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString1, localOptions);
      paramContext = paramContext.getResources().getDisplayMetrics();
      int i = localOptions.outWidth / paramContext.widthPixels;
      int j = localOptions.outHeight / paramContext.heightPixels;
      if (i < j)
      {
        localOptions.inSampleSize = i;
        if (localOptions.inSampleSize <= 0) {
          localOptions.inSampleSize = 1;
        }
        localOptions.inJustDecodeBounds = false;
      }
      try
      {
        paramContext = BitmapFactory.decodeFile(paramString1, localOptions);
        paramString1 = paramContext;
        if (paramContext == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString2, paramContext);
        return paramContext;
        localOptions.inSampleSize = j;
      }
      catch (OutOfMemoryError paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = localBitmap;
        }
      }
    }
  }
  
  public static PreloadImgManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager = new PreloadImgManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager;
    }
  }
  
  private String a(AppInterface paramAppInterface)
  {
    String str = null;
    if (a()) {
      str = Environment.getExternalStorageDirectory().getPath() + "/tencent/QWallet/" + paramAppInterface.a() + "/preload/";
    }
    return str;
  }
  
  private boolean a()
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      if (localStatFs.getAvailableBlocks() * l / 1024L / 1024L >= 20L) {
        return true;
      }
    }
    return false;
  }
  
  private String b(AppInterface paramAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppInterface.a().getFilesDir().getPath());
    localStringBuilder.append("/QWallet/").append(paramAppInterface.a()).append("/preload/");
    return localStringBuilder.toString();
  }
  
  public Bitmap a(AppInterface paramAppInterface, String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    String str1;
    do
    {
      Bitmap localBitmap;
      do
      {
        return (Bitmap)localObject;
        str1 = paramString;
        if (!paramString.endsWith("@xhdpi.png")) {
          str1 = paramString + "@xhdpi.png";
        }
        localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str1);
        localObject = localBitmap;
      } while (localBitmap != null);
      String str2 = MD5.toMD5(str1);
      localObject = new File(a(paramAppInterface), str2);
      paramString = (String)localObject;
      if (!((File)localObject).exists()) {
        paramString = new File(b(paramAppInterface), str2);
      }
      localObject = localBitmap;
    } while (!paramString.exists());
    paramAppInterface.getApplication();
    return a(MobileQQ.getContext(), paramString.getPath(), str1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(true, null);
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadImgManager", 2, "delete url is empty return!!!");
      }
      return;
    }
    String str = a(paramAppInterface);
    paramAppInterface = b(paramAppInterface);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      str = paramString;
      if (!paramString.endsWith("@xhdpi.png")) {
        str = paramString + "@xhdpi.png";
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("删除没用的图片及缓存url=");
        paramString.append(str);
        paramString.append(" ,缓存路径: ").append(paramAppInterface);
        QLog.d("PreloadImgManager", 2, paramString.toString());
      }
      if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null) {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      }
      paramAppInterface = new File(paramAppInterface, MD5.toMD5(str));
      if (!paramAppInterface.exists()) {
        break;
      }
      paramAppInterface.delete();
      return;
      paramAppInterface = str;
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString, PreloadImgManager.OnSingleDownloadCallback paramOnSingleDownloadCallback)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadImgManager", 2, "download AppInterface is null or url is emprty ");
      }
    }
    String str;
    do
    {
      return;
      str = paramString;
      if (!paramString.endsWith("@xhdpi.png")) {
        str = paramString + "@xhdpi.png";
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
        break;
      }
      ((List)this.jdField_a_of_type_JavaUtilMap.get(str)).add(paramOnSingleDownloadCallback);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadImgManager", 2, "url is already in download set return! ");
    return;
    this.jdField_a_of_type_JavaUtilMap.put(str, new ArrayList(6));
    ((List)this.jdField_a_of_type_JavaUtilMap.get(str)).add(paramOnSingleDownloadCallback);
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(paramAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
    }
    paramString = a(paramAppInterface);
    paramOnSingleDownloadCallback = b(paramAppInterface);
    if (TextUtils.isEmpty(paramString)) {
      paramString = paramOnSingleDownloadCallback;
    }
    for (;;)
    {
      paramString = new File(paramString, MD5.toMD5(str));
      paramOnSingleDownloadCallback = new DownloadTask(str, paramString);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(paramOnSingleDownloadCallback, new otl(this, paramString, paramAppInterface), null);
      return;
    }
  }
  
  public void a(AppInterface paramAppInterface, Set paramSet)
  {
    ThreadManager.a().post(new otk(this, paramAppInterface, paramSet));
  }
  
  public void b()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
      if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null) {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
      }
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager = null;
      return;
    }
  }
  
  public void b(AppInterface paramAppInterface, Set paramSet)
  {
    HashMap localHashMap;
    ArrayList localArrayList;
    String str2;
    String str3;
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(paramAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
      }
      localHashMap = new HashMap();
      localArrayList = new ArrayList();
      str2 = a(paramAppInterface);
      str3 = b(paramAppInterface);
      if (!TextUtils.isEmpty(str2)) {
        break label138;
      }
    }
    label138:
    for (String str1 = str3;; str1 = str2)
    {
      Bundle localBundle = new Bundle();
      ThreadManager.a(new otm(this, paramSet, str2, str3, paramAppInterface, localArrayList, str1, localHashMap, localBundle), 8, new otn(this, localArrayList, localHashMap, localBundle), true);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\PreloadImgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */