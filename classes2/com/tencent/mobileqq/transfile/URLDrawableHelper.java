package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBaseInfo;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDrawableHelper
{
  public static final float a = 12.0F;
  public static int a = 0;
  public static Bitmap.Config a;
  public static Drawable a;
  public static File a;
  public static final String a = "URLDrawableHelper";
  private static boolean a = false;
  public static final float b = 18.0F;
  public static final int b = 99;
  public static Bitmap.Config b;
  public static Drawable b;
  private static boolean b = false;
  public static final float c = 8.0F;
  public static final int c = 99;
  public static Drawable c;
  public static int d = 0;
  public static Drawable d;
  public static int e = 0;
  public static final Drawable e;
  public static final int f = -921103;
  public static final Drawable f;
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private static int k;
  private static int l;
  private static int m;
  private static int n;
  private static int o;
  private static int p;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    jdField_b_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.RGB_565;
    jdField_a_of_type_Int = 921600;
    h = 45;
    i = 135;
    j = 45;
    k = 135;
    l = h;
    m = i;
    n = j;
    o = k;
    d = 45;
    jdField_e_of_type_Int = 135;
    p = -1;
    jdField_e_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    f = new ColorDrawable(1073741824);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    d = (int)DisplayUtils.a(localBaseApplication, 45.0F);
    jdField_e_of_type_Int = (int)DisplayUtils.a(localBaseApplication, 135.0F);
    try
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = localBaseApplication.getResources().getDrawable(2130837567);
      jdField_b_of_type_AndroidGraphicsDrawableDrawable = localBaseApplication.getResources().getDrawable(2130837569);
      c = localBaseApplication.getResources().getDrawable(2130837619);
      g = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawableHelper", 2, "", localThrowable);
        }
        if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
        }
        if (jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
        }
      }
    }
  }
  
  public static int a()
  {
    b();
    return p;
  }
  
  public static int a(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int i1 = 65537;
    if ("chatthumb".equals(paramString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatImageDownloader", 2, "getFileSizeType protocol:" + paramString + ",output_type:" + i1);
      }
      return i1;
      if ("chatimg".equals(paramString))
      {
        if (paramBoolean) {
          i1 = 1;
        } else {
          i1 = 131075;
        }
      }
      else if ("chatraw".equals(paramString)) {
        i1 = 131075;
      }
    }
  }
  
  public static int a(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return o;
    }
    return m;
  }
  
  public static Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://CommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130838320);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
        {
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://CommonProgress", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static URLDrawable a(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return a(paramPicUiInterface, paramInt, null, null);
  }
  
  public static URLDrawable a(PicUiInterface paramPicUiInterface, int paramInt, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    boolean bool2 = true;
    if (paramPicUiInterface == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(a(paramPicUiInterface, paramInt, paramString), paramURLDrawableOptions);
    paramString.setTag(paramPicUiInterface);
    if (paramPicUiInterface.isSendFromLocal()) {}
    for (;;)
    {
      return paramString;
      if (!PicContants.jdField_b_of_type_Boolean) {
        break;
      }
      paramString.setAutoDownload(true);
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131367826), "qqsetting_auto_receive_pic_key", true);
    boolean bool1 = bool2;
    if (NetworkUtil.b(BaseApplication.getContext()) != 1) {
      if (!bool3) {
        break label104;
      }
    }
    label104:
    for (bool1 = bool2;; bool1 = false)
    {
      paramString.setAutoDownload(bool1);
      break;
    }
  }
  
  public static URLDrawable a(String paramString)
  {
    return a(paramString, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramString, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    try
    {
      paramDrawable1 = a(new URL(paramString), paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, paramFloat);
      return paramDrawable1;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramString, paramInt1, paramInt2, null, null, paramBoolean, 0.0F);
  }
  
  public static URLDrawable a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramString, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return a(paramString, 0, 0, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable a(String paramString, boolean paramBoolean)
  {
    return a(paramString, 0, 0, null, null, paramBoolean, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL)
  {
    return a(paramURL, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2)
  {
    return a(paramURL, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return a(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    return URLDrawable.getDrawable(paramURL, localURLDrawableOptions);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramURL, paramInt1, paramInt2, null, null, paramBoolean, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramURL, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return a(paramURL, 0, 0, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, boolean paramBoolean)
  {
    return a(paramURL, 0, 0, null, null, paramBoolean, 0.0F);
  }
  
  private static String a(PicBaseInfo paramPicBaseInfo)
  {
    if (paramPicBaseInfo == null) {
      return null;
    }
    switch (paramPicBaseInfo.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1020: 
    case 1023: 
    case 1024: 
    case 7100: 
      return "C2C";
    case 1: 
      return "Troup";
    }
    return "Disscussion";
  }
  
  private static String a(PicBaseInfo paramPicBaseInfo, int paramInt)
  {
    int i1;
    String str;
    if (paramInt == 65537)
    {
      i1 = 1;
      str = null;
      if (paramInt != 65537) {
        break label55;
      }
      str = "chatthumb";
      label19:
      switch (paramPicBaseInfo.jdField_b_of_type_Int)
      {
      }
    }
    label55:
    do
    {
      return str;
      i1 = 0;
      break;
      if (paramInt == 1)
      {
        str = "chatimg";
        break label19;
      }
      if (paramInt != 131075) {
        break label19;
      }
      str = "chatraw";
      break label19;
      return "favimage";
    } while (paramPicBaseInfo.jdField_e_of_type_Int >= 3);
    if (i1 != 0) {
      return "lbsthumb";
    }
    return "lbsimg";
  }
  
  public static URL a(PicDownloadInfo paramPicDownloadInfo, int paramInt, String paramString)
  {
    if (paramPicDownloadInfo == null) {
      return null;
    }
    String str1 = paramPicDownloadInfo.f;
    label47:
    String str2;
    if ((str1 != null) && (!"null".equals(str1)) && (!"".equals(str1)))
    {
      if (paramPicDownloadInfo.jdField_b_of_type_Boolean) {
        paramInt = 1;
      }
      if (paramString == null) {
        break label182;
      }
      str2 = str1;
      if (str1 != null) {}
    }
    for (;;)
    {
      try
      {
        str1 = "holyshit_" + System.currentTimeMillis();
        str2 = str1;
        if (QLog.isColorLevel())
        {
          QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramPicDownloadInfo.toString());
          str2 = str1;
        }
        if (paramString == null) {
          break label198;
        }
        paramPicDownloadInfo = new URL(paramString, null, str2);
        return paramPicDownloadInfo;
      }
      catch (MalformedURLException paramPicDownloadInfo)
      {
        label182:
        paramPicDownloadInfo.printStackTrace();
        return null;
      }
      if ((paramPicDownloadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537))
      {
        if (GeneralConfigUtils.a())
        {
          str1 = paramPicDownloadInfo.k;
          break;
        }
        str1 = paramPicDownloadInfo.h;
        break;
      }
      str1 = paramPicDownloadInfo.g;
      break;
      paramString = a(paramPicDownloadInfo, paramInt);
      break label47;
      label198:
      paramPicDownloadInfo = null;
    }
  }
  
  public static URL a(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return a(paramPicUiInterface, paramInt, null);
  }
  
  public static URL a(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    if (paramPicUiInterface == null) {
      return null;
    }
    if (paramPicUiInterface.isSendFromLocal()) {
      return a(paramPicUiInterface.getPicUploadInfo(), paramInt, paramString);
    }
    return a(paramPicUiInterface.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public static URL a(PicUploadInfo paramPicUploadInfo, int paramInt, String paramString)
  {
    if (paramPicUploadInfo == null) {
      return null;
    }
    if (paramPicUploadInfo.jdField_e_of_type_Int < 4) {}
    for (String str2 = a(paramPicUploadInfo);; str2 = null)
    {
      String str3 = a(paramPicUploadInfo, paramInt);
      if ((paramPicUploadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537)) {}
      for (String str1 = paramPicUploadInfo.h;; str1 = "")
      {
        label48:
        if (str1 != null) {}
        try
        {
          if (("".equals(str1)) && (QLog.isColorLevel())) {
            QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramPicUploadInfo.toString());
          }
          if (paramString != null)
          {
            paramPicUploadInfo = new URL(paramString, str2, str1);
            return paramPicUploadInfo;
            if ((paramPicUploadInfo.f != null) && (!"".equals(paramPicUploadInfo.f)))
            {
              str1 = paramPicUploadInfo.f;
              break label48;
            }
            if ((paramPicUploadInfo.a != null) && (!"".equals(paramPicUploadInfo.a)))
            {
              str1 = paramPicUploadInfo.a;
              break label48;
            }
            if ((paramPicUploadInfo.g == null) || ("".equals(paramPicUploadInfo.g))) {
              continue;
            }
            str1 = paramPicUploadInfo.g;
            break label48;
          }
          if (str3 == null) {
            break;
          }
          paramPicUploadInfo = new URL(str3, str2, str1);
          return paramPicUploadInfo;
        }
        catch (MalformedURLException paramPicUploadInfo)
        {
          paramPicUploadInfo.printStackTrace();
          return null;
        }
      }
    }
  }
  
  public static URL a(String paramString, int paramInt)
  {
    String str = "chatimg";
    if (paramInt == 65537) {
      str = "chatthumb";
    }
    for (;;)
    {
      try
      {
        paramString = new URL(str, null, paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
      if (paramInt == 1) {
        str = "chatimg";
      } else if (paramInt == 131075) {
        str = "chatraw";
      }
    }
    return null;
  }
  
  public static void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        String[] arrayOfString = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_pic_thumb_size.name(), "135|135").split("\\|");
        if (arrayOfString.length == 2)
        {
          i1 = Integer.valueOf(arrayOfString[0]).intValue();
          if ((i1 >= 45) && (i1 <= 198)) {
            i = i1;
          }
          i1 = Integer.valueOf(arrayOfString[1]).intValue();
          if ((i1 >= 45) && (i1 <= 198)) {
            k = i1;
          }
        }
        float f1 = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
        m = (int)(i * f1);
        o = (int)(k * f1);
        l = (int)(h * f1);
        n = (int)(f1 * j);
        if (m == 0)
        {
          i1 = i;
          m = i1;
          if (o != 0) {
            break label266;
          }
          i1 = k;
          o = i1;
          if (l != 0) {
            break label273;
          }
          i1 = h;
          l = i1;
          if (n != 0) {
            break label280;
          }
          i1 = j;
          n = i1;
          jdField_a_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("URLDrawableHelper", 2, m + "|" + o);
          continue;
        }
        i1 = m;
      }
      finally {}
      continue;
      label266:
      int i1 = o;
      continue;
      label273:
      i1 = l;
      continue;
      label280:
      i1 = n;
    }
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString, boolean paramBoolean)
  {
    String str = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() != 1) && (AbsDownloader.a(str))) {}
    try
    {
      paramURLDrawable.downloadImediatly();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("URLDrawableHelper", 2, "downloadImediatly decode OOM,currentAccountUin=" + paramString + ",d.getURL=" + paramURLDrawable.getURL());
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = AppNetConnInfo.isMobileConn();
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131367826), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
  
  public static boolean a(Context paramContext, PicUiInterface paramPicUiInterface, int paramInt)
  {
    return AbsDownloader.a(a(paramPicUiInterface, paramInt).toString()) != null;
  }
  
  public static int b(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return n;
    }
    return l;
  }
  
  public static URLDrawable b(PicUiInterface paramPicUiInterface, int paramInt)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(a(paramPicUiInterface, 65537));
    localURLDrawable.setTargetDensity(g);
    int i1;
    URL localURL;
    if (localURLDrawable.getStatus() == 1)
    {
      i1 = 1;
      localURL = a(paramPicUiInterface, paramInt);
      if (i1 == 0) {
        break label69;
      }
    }
    label69:
    for (localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);; localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true))
    {
      localURLDrawable.setTargetDensity(g);
      localURLDrawable.setTag(paramPicUiInterface);
      return localURLDrawable;
      i1 = 0;
      break;
    }
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 523	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_b_of_type_Boolean	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 430	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   18: getstatic 526	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:aio_config	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   21: invokevirtual 439	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   24: ldc_w 528
    //   27: invokevirtual 444	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: ldc_w 446
    //   33: invokevirtual 450	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: arraylength
    //   39: istore_1
    //   40: iload_1
    //   41: ifle +15 -> 56
    //   44: aload_0
    //   45: iconst_0
    //   46: aaload
    //   47: invokestatic 456	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   50: invokevirtual 459	java/lang/Integer:intValue	()I
    //   53: putstatic 81	com/tencent/mobileqq/transfile/URLDrawableHelper:p	I
    //   56: iconst_1
    //   57: putstatic 523	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_b_of_type_Boolean	Z
    //   60: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq -52 -> 11
    //   66: ldc 15
    //   68: iconst_2
    //   69: new 175	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 530
    //   79: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: getstatic 81	com/tencent/mobileqq/transfile/URLDrawableHelper:p	I
    //   85: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 470	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: goto -83 -> 11
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    //   103: astore_0
    //   104: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +12 -> 119
    //   110: ldc 15
    //   112: iconst_2
    //   113: ldc_w 532
    //   116: invokestatic 470	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: iconst_m1
    //   120: putstatic 81	com/tencent/mobileqq/transfile/URLDrawableHelper:p	I
    //   123: goto -67 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	9	0	arrayOfString	String[]
    //   97	5	0	localObject	Object
    //   103	1	0	localException	Exception
    //   39	2	1	i1	int
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	97	finally
    //   15	40	97	finally
    //   44	56	97	finally
    //   56	94	97	finally
    //   104	119	97	finally
    //   119	123	97	finally
    //   44	56	103	java/lang/Exception
  }
  
  public static int c(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return k;
    }
    return i;
  }
  
  public static int d(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return j;
    }
    return h;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\URLDrawableHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */