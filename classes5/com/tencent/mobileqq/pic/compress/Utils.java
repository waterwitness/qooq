package com.tencent.mobileqq.pic.compress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import ttk;
import ttl;

public class Utils
{
  public static final float a = 1.7777778F;
  public static final int a = 0;
  private static final String a = "compress.Utils";
  public static final int b = 1;
  public static final int c = 20971520;
  
  public Utils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString, int paramInt)
  {
    paramString = paramString.toLowerCase();
    if ((paramInt == 0) || (paramInt == 3000))
    {
      if ((paramString.contains("camera")) || (paramString.contains("dcim")) || (paramString.contains("100media")) || (paramString.contains("100andro")) || (paramString.contains("相机")) || (paramString.contains("照片")) || (paramString.contains("相片"))) {
        return PicType.j;
      }
      if ((paramString.contains("screenshot")) || (paramString.contains("截屏")) || (paramString.contains("截图")) || (paramString.contains("screen_cap")) || (paramString.contains("screencapture"))) {
        return PicType.l;
      }
      return PicType.n;
    }
    if (paramInt == -1) {
      return 960;
    }
    if ((paramString.contains("camera")) || (paramString.contains("dcim")) || (paramString.contains("100media")) || (paramString.contains("100andro")) || (paramString.contains("相机")) || (paramString.contains("照片")) || (paramString.contains("相片"))) {
      return PicType.k;
    }
    if ((paramString.contains("screenshot")) || (paramString.contains("截屏")) || (paramString.contains("截图")) || (paramString.contains("screen_cap")) || (paramString.contains("screencapture"))) {
      return PicType.m;
    }
    return PicType.o;
  }
  
  public static long a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.b(paramString)))
    {
      Logger.b("compress.Utils", "getFileSize()", "path is empty, or file does not exist. path:" + paramString);
      return 0L;
    }
    return new File(paramString).length();
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setXfermode(null);
      paramBitmap.recycle();
      paramBitmap = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    Logger.a("compress.Utils", "compositingWhiteBg()", "compositingWhiteBg is success");
    return paramBitmap;
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.a(paramString)))
    {
      String str2 = AppConstants.bj + "thumb/";
      if (paramString.startsWith(str2)) {
        return paramString;
      }
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      String str1;
      if (j <= 0) {
        str1 = paramString.substring(i + 1);
      }
      for (;;)
      {
        long l = new File(paramString).lastModified();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str2);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append(str1);
        localStringBuffer.append("_").append(l);
        localStringBuffer.append(".jpg");
        paramString = new File(str2);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        if (i < j + 1) {
          str1 = paramString.substring(i + 1, j);
        } else {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    Logger.a("compress.Utils", "getThumbnailPath()", "realpath is empty, or file does not exist, realpath:" + paramString);
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.a(paramString)) && (PicQuality.a(paramInt)))
    {
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      Object localObject;
      String str;
      StringBuffer localStringBuffer;
      if ((j <= 0) || (j <= i))
      {
        localObject = paramString.substring(i + 1);
        long l = new File(paramString).lastModified();
        str = AppConstants.bj + "photo/";
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append((String)localObject);
        localStringBuffer.append("_").append(l);
        localObject = localStringBuffer.append("_");
        if (!a()) {
          break label229;
        }
      }
      label229:
      for (paramString = "wifi";; paramString = "xg")
      {
        ((StringBuffer)localObject).append(paramString);
        localStringBuffer.append("_").append(paramInt);
        localStringBuffer.append(".jpg");
        paramString = new File(str);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        localObject = paramString.substring(i + 1, j);
        break;
      }
    }
    Logger.a("compress.Utils", "getSendPhotoPath()", "realpath is empty, or file does not exist, or picQuality Illegal realpath:" + paramString + " picQuality:" + paramInt);
    return "";
  }
  
  private static ttl a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 1;
    int m = 0;
    int j = URLDrawableHelper.a(false);
    int i = URLDrawableHelper.b(false);
    if (paramInt3 == 1)
    {
      j = FilePicURLDrawlableHelper.a;
      i = FilePicURLDrawlableHelper.b;
    }
    if (paramInt1 > j) {
      if (a(paramInt1, paramInt2, paramInt3))
      {
        paramInt2 = 1;
        paramInt1 = k;
      }
    }
    for (;;)
    {
      ttl localttl = new ttl(null);
      localttl.a = paramInt2;
      localttl.b = paramInt1;
      Logger.a("compress.Utils", "getType()", " type=" + localttl);
      return localttl;
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      if ((paramInt1 <= j) && (paramInt1 > i))
      {
        if (paramInt2 > j)
        {
          if (a(paramInt1, paramInt2, paramInt3))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= j) && (paramInt2 > i))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= i) && (paramInt1 > 0))
      {
        if (paramInt2 > j)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= j) && (paramInt2 > i))
        {
          if (a(paramInt1, paramInt2, paramInt3))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= i) && (paramInt2 > 0))
        {
          if (a(paramInt1, paramInt2, paramInt3))
          {
            paramInt1 = 9;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 10;
          paramInt2 = 3;
          continue;
        }
      }
      paramInt1 = 0;
      paramInt2 = m;
    }
  }
  
  public static void a(Context paramContext, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int n;
    int m;
    int j;
    Object localObject1;
    String str2;
    String str3;
    String str4;
    String str5;
    int i1;
    int i;
    String str1;
    String str6;
    String str7;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    int k;
    if (paramList.size() > 1)
    {
      n = 1;
      m = 0;
      j = 0;
      localObject1 = "";
      str2 = BaseApplication.getContext().getString(2131371074);
      str3 = BaseApplication.getContext().getString(2131371075);
      str4 = BaseApplication.getContext().getString(2131371076);
      str5 = BaseApplication.getContext().getString(2131371077);
      i1 = 0;
      i = 0;
      str1 = "";
      str6 = BaseApplication.getContext().getString(2131371078);
      str7 = BaseApplication.getContext().getString(2131371079);
      localObject3 = BaseApplication.getContext().getString(2131371080);
      localObject2 = BaseApplication.getContext().getString(2131371081);
      localObject4 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (CompressInfo)((Iterator)localObject4).next();
          if ((localObject5 != null) && (((CompressInfo)localObject5).c)) {
            if (n != 0)
            {
              k = 1;
              localObject3 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      label187:
      localObject4 = str1;
      localObject2 = localObject1;
      if (k == 0)
      {
        localObject5 = paramList.iterator();
        paramList = str1;
        label209:
        localObject4 = paramList;
        i1 = i;
        localObject2 = localObject1;
        m = j;
        if (((Iterator)localObject5).hasNext())
        {
          localObject2 = (CompressInfo)((Iterator)localObject5).next();
          if ((localObject2 == null) || (((CompressInfo)localObject2).e) || (!((CompressInfo)localObject2).jdField_b_of_type_Boolean)) {
            break label428;
          }
          i1 = 1;
          j = 1;
          if (!str4.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            break label376;
          }
          localObject4 = paramList;
          i1 = i;
          localObject2 = localObject1;
          m = j;
          if (!str4.equals(localObject1))
          {
            if (n == 0) {
              break label359;
            }
            localObject2 = str5;
            m = j;
            i1 = i;
            localObject4 = paramList;
          }
        }
      }
      for (;;)
      {
        if (k == 0) {
          break label490;
        }
        QQToast.a(paramContext, (CharSequence)localObject3, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        return;
        n = 0;
        break;
        k = 1;
        break label187;
        label359:
        localObject2 = str4;
        localObject4 = paramList;
        i1 = i;
        m = j;
      }
      label376:
      m = i1;
      if (str2.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString))
      {
        m = i1;
        if (!str2.equals(localObject1)) {
          if (n != 0)
          {
            j = 1;
            localObject1 = str3;
          }
        }
      }
      for (;;)
      {
        break label209;
        j = 1;
        localObject1 = str2;
        continue;
        label428:
        m = j;
        if (localObject2 != null)
        {
          m = j;
          if (((CompressInfo)localObject2).e)
          {
            m = j;
            if (((CompressInfo)localObject2).jdField_b_of_type_Boolean)
            {
              m = j;
              if (i == 0)
              {
                if (n != 0)
                {
                  i = 1;
                  paramList = str7;
                  continue;
                }
                i = 1;
                paramList = str6;
                continue;
                label490:
                if (m != 0)
                {
                  QQToast.a(paramContext, (CharSequence)localObject2, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
                  return;
                }
                if (i1 == 0) {
                  break;
                }
                QQToast.a(paramContext, (CharSequence)localObject4, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
                return;
              }
            }
          }
        }
        j = m;
      }
      localObject3 = "";
      k = 0;
    }
  }
  
  public static boolean a()
  {
    return NetworkUtil.b(BaseApplication.getContext()) == 1;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 1) {
      if (paramInt2 <= (int)(paramInt1 * 1.7777778F)) {}
    }
    while (paramInt2 > paramInt1 * 3)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean a(Bitmap paramBitmap, ttl paramttl, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    int m = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    int i = URLDrawableHelper.a(false);
    int i1 = URLDrawableHelper.b(false);
    if (paramInt == 1)
    {
      i = FilePicURLDrawlableHelper.a;
      i1 = FilePicURLDrawlableHelper.b;
    }
    for (;;)
    {
      int j;
      int n;
      int k;
      Object localObject;
      int i4;
      switch (paramttl.b)
      {
      case 2: 
      case 4: 
      case 5: 
      default: 
        j = i2;
        n = m;
        k = m;
        m = j;
        j = i2;
        localObject = new Matrix();
        i4 = URLDrawableHelper.a(paramString1);
        if ((!paramBoolean) || (i4 == 0) || (i4 % 90 != 0)) {
          break;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        Logger.a("compress.Utils", paramString3, paramString4 + " sample after W:" + k + " H:" + j + " isLongImg:" + a(0, 0, paramInt) + " type:" + paramttl + " needRotate:" + bool2);
        int i3;
        if (n > m) {
          i3 = n;
        }
        boolean bool1;
        for (i2 = m;; i2 = n) {
          switch (paramttl.a)
          {
          default: 
            bool1 = false;
            paramBoolean = false;
            Logger.a("compress.Utils", paramString3, paramString4 + " destWidth：" + n + " destHeight:" + m + " needCut:" + bool1 + " needScale:" + paramBoolean + " needRotate:" + bool2);
            paramBitmap = a(paramBitmap);
            paramBoolean = c(paramString2, paramBitmap, 70, paramString4, null);
            if (paramBitmap != null) {
              paramBitmap.recycle();
            }
            return paramBoolean;
            Logger.a("compress.Utils", paramString3, paramString4 + " type.type2:136");
            if (m > i2)
            {
              j = i2;
              label415:
              if (paramInt != 1) {
                break label522;
              }
              k = (int)(j * 1.7777778F);
              label430:
              if (m <= i2) {
                break label531;
              }
            }
            for (;;)
            {
              m = k;
              try
              {
                if (k > paramBitmap.getWidth()) {
                  m = paramBitmap.getWidth();
                }
                k = j;
                if (j > paramBitmap.getHeight()) {
                  k = paramBitmap.getHeight();
                }
                localObject = Bitmap.createBitmap(paramBitmap, 0, 0, m, k);
                k = ((Bitmap)localObject).getWidth();
                j = ((Bitmap)localObject).getHeight();
                m = j;
                n = k;
                paramBitmap = (Bitmap)localObject;
              }
              catch (OutOfMemoryError paramString1)
              {
                paramBitmap.recycle();
                paramString1.printStackTrace();
                Logger.b("compress.Utils", paramString3, paramString4 + " cut 3:1 createBitmap OutOfMemoryError, type:" + paramttl);
                return false;
              }
              j = m;
              break label415;
              label522:
              k = j * 3;
              break label430;
              label531:
              m = j;
              j = k;
              k = m;
            }
            i3 = m;
          }
        }
        float f = i1 / (i2 * 1.0F);
        paramInt = (int)(i3 * f);
        if (bool2) {
          ((Matrix)localObject).postRotate(i4, k >> 1, j >> 1);
        }
        ((Matrix)localObject).postScale(f, f);
        paramInt = k;
        for (;;)
        {
          try
          {
            if (k > paramBitmap.getWidth()) {
              paramInt = paramBitmap.getWidth();
            }
            k = j;
            if (j > paramBitmap.getHeight()) {
              k = paramBitmap.getHeight();
            }
            paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, k, (Matrix)localObject, true);
            if (n > m)
            {
              paramInt = i;
              i = i1;
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            try
            {
              if (i4 / 90 % 2 == 0) {
                break label1499;
              }
              n = i;
              if (i > paramString1.getWidth()) {
                n = paramString1.getWidth();
              }
              m = paramInt;
              if (paramInt > paramString1.getHeight()) {
                m = paramString1.getHeight();
              }
              paramBitmap = Bitmap.createBitmap(paramString1, 0, 0, n, m);
              bool1 = true;
              paramBoolean = true;
            }
            catch (OutOfMemoryError paramBitmap)
            {
              paramString1.recycle();
              paramBitmap.printStackTrace();
              Logger.b("compress.Utils", paramString3, paramString4 + " case 1: cut createBitmap OutOfMemoryError, type:" + paramttl);
              return false;
            }
            paramString1 = paramString1;
            paramBitmap.recycle();
            paramString1.printStackTrace();
            Logger.b("compress.Utils", paramString3, paramString4 + " case 1: scale or rotate createBitmap OutOfMemoryError, type:" + paramttl);
            return false;
          }
          paramInt = i1;
          continue;
          f = i / (i3 * 1.0F);
          paramInt = (int)(i2 * f);
          if (n > m)
          {
            n = i;
            m = paramInt;
          }
          for (;;)
          {
            if (bool2) {
              ((Matrix)localObject).postRotate(i4, k >> 1, j >> 1);
            }
            ((Matrix)localObject).postScale(f, f);
            paramInt = k;
            try
            {
              if (k > paramBitmap.getWidth()) {
                paramInt = paramBitmap.getWidth();
              }
              i = j;
              if (j > paramBitmap.getHeight()) {
                i = paramBitmap.getHeight();
              }
              paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, i, (Matrix)localObject, true);
              bool1 = false;
              paramBitmap = paramString1;
              paramBoolean = true;
            }
            catch (OutOfMemoryError paramString1)
            {
              paramBitmap.recycle();
              paramString1.printStackTrace();
              Logger.b("compress.Utils", paramString3, paramString4 + " case 2: scale or rotate createBitmap OutOfMemoryError, type:" + paramttl);
              return false;
            }
            m = i;
            n = paramInt;
          }
          if (!bool2) {
            break;
          }
          ((Matrix)localObject).postRotate(i4, k >> 1, j >> 1);
          paramInt = k;
          try
          {
            if (k > paramBitmap.getWidth()) {
              paramInt = paramBitmap.getWidth();
            }
            i = j;
            if (j > paramBitmap.getHeight()) {
              i = paramBitmap.getHeight();
            }
            paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, i, (Matrix)localObject, true);
            bool1 = false;
            paramBitmap = paramString1;
            paramBoolean = false;
          }
          catch (OutOfMemoryError paramString1)
          {
            paramBitmap.recycle();
            paramString1.printStackTrace();
            Logger.b("compress.Utils", paramString3, paramString4 + " case 3: rotate createBitmap OutOfMemoryError, type:" + paramttl);
            return false;
          }
          if (bool2)
          {
            ((Matrix)localObject).postRotate(i4, k >> 1, j >> 1);
            i = k;
          }
          for (;;)
          {
            try
            {
              if (k > paramBitmap.getWidth()) {
                i = paramBitmap.getWidth();
              }
              k = j;
              if (j > paramBitmap.getHeight()) {
                k = paramBitmap.getHeight();
              }
              paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, k, (Matrix)localObject, true);
              paramBitmap = paramString1;
              if (paramInt == 1)
              {
                paramInt = (int)(i2 * 1.7777778F);
                if (n <= m) {
                  break label1420;
                }
                i = i2;
              }
            }
            catch (OutOfMemoryError paramString1)
            {
              try
              {
                if (i4 / 90 % 2 == 0) {
                  break label1481;
                }
                n = i;
                if (i > paramBitmap.getWidth()) {
                  n = paramBitmap.getWidth();
                }
                m = paramInt;
                if (paramInt > paramBitmap.getHeight()) {
                  m = paramBitmap.getHeight();
                }
                paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, n, m);
                paramBitmap = paramString1;
                bool1 = true;
                paramBoolean = false;
              }
              catch (OutOfMemoryError paramString1)
              {
                if (paramBitmap.isRecycled()) {
                  break label1443;
                }
                paramBitmap.recycle();
                paramString1.printStackTrace();
                Logger.b("compress.Utils", paramString3, paramString4 + " case 4: cut createBitmap OutOfMemoryError, type:" + paramttl);
                return false;
              }
              paramString1 = paramString1;
              paramBitmap.recycle();
              paramString1.printStackTrace();
              Logger.b("compress.Utils", paramString3, paramString4 + " case 4: rotate createBitmap OutOfMemoryError, type:" + paramttl);
              return false;
            }
            paramInt = i2 * 3;
            continue;
            label1420:
            i = paramInt;
            paramInt = i2;
            continue;
            label1443:
            label1481:
            j = paramInt;
            paramInt = i;
            i = j;
          }
          label1499:
          j = paramInt;
          paramInt = i;
          i = j;
        }
      }
    }
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramOptions.outWidth;
    int n = paramOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramOptions.inSampleSize;; paramInt = 1)
    {
      paramOptions.inSampleSize = paramInt;
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(BitmapFactory.Options paramOptions, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramOptions == null) || (TextUtils.isEmpty(paramString)))
    {
      Logger.b("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
      return false;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 < paramInt2)) {
      throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
    }
    if (paramInt2 > paramInt1 / 2) {
      throw new IllegalArgumentException("min > max / 2");
    }
    paramOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramOptions);
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    if (j > i)
    {
      i = j;
      if (i > paramInt1)
      {
        j = 1;
        int k;
        int m;
        do
        {
          do
          {
            k = i >> 1;
            m = j * 2;
            i = k;
            j = m;
          } while (k < paramInt2);
          i = k;
          j = m;
        } while (k > paramInt1);
        paramOptions.inSampleSize = m;
      }
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label214;
      }
    }
    label214:
    for (paramInt1 = paramOptions.inSampleSize;; paramInt1 = 1)
    {
      paramOptions.inSampleSize = paramInt1;
      Logger.a("compress.Utils", "calculateInSampleSize()", "options.inSampleSize=" + paramOptions.inSampleSize);
      return true;
      break;
    }
  }
  
  private static boolean a(JpegOptions paramJpegOptions, int paramInt)
  {
    if (paramJpegOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramJpegOptions.outWidth;
    int n = paramJpegOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramJpegOptions.inSampleSize = i;
      paramJpegOptions.inJustDecodeBounds = false;
      if (paramJpegOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramJpegOptions.inSampleSize;; paramInt = 1)
    {
      paramJpegOptions.inSampleSize = paramInt;
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramJpegOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = GifDrawable.isGifFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "isGifFile result:" + bool);
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if (c()) {
      return b(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
    }
    return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return ImageUtil.b(paramString1, paramString2);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1)))
    {
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    Logger.a("compress.Utils", "compressAIOThumbnail", paramString3);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    ImageUtil.a(paramString1, localOptions);
    int j;
    if (localOptions.outWidth > localOptions.outHeight) {
      j = localOptions.outWidth;
    }
    ttl localttl;
    for (int i = localOptions.outHeight;; i = localOptions.outWidth)
    {
      localttl = a(i, j, paramInt);
      i = URLDrawableHelper.a(false);
      URLDrawableHelper.b(false);
      if (paramInt == 1)
      {
        i = FilePicURLDrawlableHelper.a;
        j = FilePicURLDrawlableHelper.b;
      }
      if (a(localOptions, i)) {
        break;
      }
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localOptions.outHeight;
    }
    try
    {
      Bitmap localBitmap3 = ImageUtil.a(paramString1, localOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError");
      localOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString1, localOptions);
        i = localBitmap2.getWidth();
        j = localBitmap2.getHeight();
        Logger.a("compress.Utils", "compressAIOThumbnail", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, localttl, paramBoolean, paramString1, paramString2, "compressAIOThumbnail", paramString3, paramInt);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localOptions.inSampleSize);
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 2) {
      return false;
    }
    return localObject[1].equals("1");
  }
  
  public static boolean b(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (FileUtils.b(paramString))
    {
      bool1 = bool3;
      if (!FileUtils.a(paramString).equals("jpg")) {}
    }
    try
    {
      float f = JpegCompressor.getJpegQuality(paramString);
      long l = FileUtils.a(paramString);
      bool1 = bool2;
      if (f <= 80.0F)
      {
        bool1 = bool2;
        if (l < 307200L) {
          bool1 = true;
        }
      }
      Logger.a("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality = " + f + ",picSize = " + l + "result = " + bool1);
      return bool1;
    }
    catch (RuntimeException paramString)
    {
      Logger.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality RuntimeException error = " + paramString + ",return false!");
      return false;
    }
    catch (OutOfMemoryError paramString)
    {
      Logger.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality OutOfMemoryError error = " + paramString + ",return false!");
    }
    return false;
  }
  
  private static boolean b(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBitmap == null) || (paramInt > 100) || (paramInt <= 0))
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
      return false;
    }
    Logger.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      ((File)localObject).createNewFile();
      localObject = new JpegCompressor(new ttk((File)localObject, paramCompressInfo));
      ((JpegCompressor)localObject).setParams(paramInt, true, true, false);
      try
      {
        LogTag.a();
        ((JpegCompressor)localObject).compress(paramBitmap);
        LogTag.a("peak_pgjpeg", "pgjpeg " + paramBitmap.getWidth() + "x" + paramBitmap.getHeight() + " compress");
        Logger.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
        return true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("peak_pgjpeg", 2, "JpegCompressor.compress() error", localException);
        }
        return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
      }
      return false;
    }
    catch (FileNotFoundException paramString1)
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " FileOutputStream FileNotFoundException");
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " createNewFile IOException");
      paramString1.printStackTrace();
    }
  }
  
  public static boolean b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1)))
    {
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3);
    JpegOptions localJpegOptions = new JpegOptions();
    localJpegOptions.inJustDecodeBounds = true;
    JpegDecompressor.decodeFile(paramString1, localJpegOptions);
    int j;
    if (localJpegOptions.outWidth > localJpegOptions.outHeight) {
      j = localJpegOptions.outWidth;
    }
    ttl localttl;
    for (int i = localJpegOptions.outHeight;; i = localJpegOptions.outWidth)
    {
      localttl = a(i, j, paramInt);
      i = URLDrawableHelper.a(false);
      URLDrawableHelper.b(false);
      if (paramInt == 1)
      {
        i = FilePicURLDrawlableHelper.a;
        j = FilePicURLDrawlableHelper.b;
      }
      if (a(localJpegOptions, i)) {
        break;
      }
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localJpegOptions.outHeight;
    }
    try
    {
      Bitmap localBitmap3 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError");
      localJpegOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
        i = localBitmap2.getWidth();
        j = localBitmap2.getHeight();
        Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, localttl, paramBoolean, paramString1, paramString2, "compressAIOThumbnailWithTrubo", paramString3, paramInt);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localJpegOptions.inSampleSize);
      }
    }
    return false;
  }
  
  public static boolean c()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 1) {
      return false;
    }
    return localObject[0].equals("1");
  }
  
  /* Error */
  private static boolean c(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: aload_0
    //   4: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +17 -> 24
    //   10: aload_1
    //   11: ifnull +13 -> 24
    //   14: iload_2
    //   15: bipush 100
    //   17: if_icmpgt +7 -> 24
    //   20: iload_2
    //   21: ifgt +37 -> 58
    //   24: ldc 12
    //   26: ldc_w 695
    //   29: new 97	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   36: aload_3
    //   37: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 633
    //   43: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 112	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: istore 7
    //   55: iload 7
    //   57: ireturn
    //   58: ldc 12
    //   60: ldc_w 695
    //   63: new 97	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   70: aload_3
    //   71: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 635
    //   77: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_2
    //   81: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 183	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   90: new 114	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 237	java/io/File:exists	()Z
    //   103: ifeq +8 -> 111
    //   106: aload_0
    //   107: invokevirtual 638	java/io/File:delete	()Z
    //   110: pop
    //   111: aload_0
    //   112: invokevirtual 641	java/io/File:createNewFile	()Z
    //   115: pop
    //   116: new 697	java/io/FileOutputStream
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 700	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: astore 6
    //   126: new 702	java/io/BufferedOutputStream
    //   129: dup
    //   130: aload 6
    //   132: invokespecial 705	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore 5
    //   137: aload 5
    //   139: astore_0
    //   140: aload_1
    //   141: getstatic 711	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   144: iload_2
    //   145: aload 5
    //   147: invokevirtual 714	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   150: pop
    //   151: aload 5
    //   153: astore_0
    //   154: aload 5
    //   156: invokevirtual 717	java/io/BufferedOutputStream:flush	()V
    //   159: aload 5
    //   161: astore_0
    //   162: aload 6
    //   164: invokevirtual 721	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +20 -> 189
    //   172: aload 5
    //   174: astore_0
    //   175: aload_1
    //   176: invokevirtual 726	java/io/FileDescriptor:valid	()Z
    //   179: ifeq +10 -> 189
    //   182: aload 5
    //   184: astore_0
    //   185: aload_1
    //   186: invokevirtual 729	java/io/FileDescriptor:sync	()V
    //   189: aload 5
    //   191: ifnull -136 -> 55
    //   194: aload 5
    //   196: invokevirtual 732	java/io/BufferedOutputStream:close	()V
    //   199: iconst_1
    //   200: ireturn
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 681	java/io/IOException:printStackTrace	()V
    //   206: iconst_1
    //   207: ireturn
    //   208: astore_0
    //   209: aload 4
    //   211: ifnull +12 -> 223
    //   214: aload 5
    //   216: astore_0
    //   217: aload 4
    //   219: iconst_1
    //   220: invokevirtual 735	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   223: aload 5
    //   225: astore_0
    //   226: ldc 12
    //   228: ldc_w 695
    //   231: ldc_w 737
    //   234: invokestatic 112	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -48 -> 189
    //   240: astore_1
    //   241: aload 5
    //   243: astore_0
    //   244: ldc 12
    //   246: ldc_w 695
    //   249: new 97	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   256: aload_3
    //   257: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 677
    //   263: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 112	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 5
    //   274: astore_0
    //   275: aload_1
    //   276: invokevirtual 678	java/io/FileNotFoundException:printStackTrace	()V
    //   279: aload 5
    //   281: ifnull +8 -> 289
    //   284: aload 5
    //   286: invokevirtual 732	java/io/BufferedOutputStream:close	()V
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_0
    //   292: aload 4
    //   294: ifnull +12 -> 306
    //   297: aload 5
    //   299: astore_0
    //   300: aload 4
    //   302: iconst_1
    //   303: invokevirtual 735	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   306: aload 5
    //   308: astore_0
    //   309: ldc 12
    //   311: ldc_w 695
    //   314: ldc_w 739
    //   317: invokestatic 112	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   320: goto -131 -> 189
    //   323: astore_1
    //   324: aload 5
    //   326: astore_0
    //   327: ldc 12
    //   329: ldc_w 695
    //   332: new 97	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   339: aload_3
    //   340: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: ldc_w 741
    //   346: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 112	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload 5
    //   357: astore_0
    //   358: aload_1
    //   359: invokevirtual 742	java/lang/Exception:printStackTrace	()V
    //   362: aload 5
    //   364: ifnull +8 -> 372
    //   367: aload 5
    //   369: invokevirtual 732	java/io/BufferedOutputStream:close	()V
    //   372: iconst_0
    //   373: ireturn
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 681	java/io/IOException:printStackTrace	()V
    //   379: goto -90 -> 289
    //   382: astore_0
    //   383: aload_0
    //   384: invokevirtual 681	java/io/IOException:printStackTrace	()V
    //   387: goto -15 -> 372
    //   390: astore_1
    //   391: aconst_null
    //   392: astore_0
    //   393: aload_0
    //   394: ifnull +7 -> 401
    //   397: aload_0
    //   398: invokevirtual 732	java/io/BufferedOutputStream:close	()V
    //   401: aload_1
    //   402: athrow
    //   403: astore_0
    //   404: aload_0
    //   405: invokevirtual 681	java/io/IOException:printStackTrace	()V
    //   408: goto -7 -> 401
    //   411: astore_1
    //   412: goto -19 -> 393
    //   415: astore_1
    //   416: aconst_null
    //   417: astore 5
    //   419: goto -95 -> 324
    //   422: astore_1
    //   423: aconst_null
    //   424: astore 5
    //   426: goto -185 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString1	String
    //   0	429	1	paramBitmap	Bitmap
    //   0	429	2	paramInt	int
    //   0	429	3	paramString2	String
    //   0	429	4	paramCompressInfo	CompressInfo
    //   135	290	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   124	39	6	localFileOutputStream	java.io.FileOutputStream
    //   1	55	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   194	199	201	java/io/IOException
    //   154	159	208	java/io/SyncFailedException
    //   162	168	208	java/io/SyncFailedException
    //   175	182	208	java/io/SyncFailedException
    //   185	189	208	java/io/SyncFailedException
    //   140	151	240	java/io/FileNotFoundException
    //   154	159	240	java/io/FileNotFoundException
    //   162	168	240	java/io/FileNotFoundException
    //   175	182	240	java/io/FileNotFoundException
    //   185	189	240	java/io/FileNotFoundException
    //   217	223	240	java/io/FileNotFoundException
    //   226	237	240	java/io/FileNotFoundException
    //   300	306	240	java/io/FileNotFoundException
    //   309	320	240	java/io/FileNotFoundException
    //   154	159	291	java/io/IOException
    //   162	168	291	java/io/IOException
    //   175	182	291	java/io/IOException
    //   185	189	291	java/io/IOException
    //   140	151	323	java/lang/Exception
    //   154	159	323	java/lang/Exception
    //   162	168	323	java/lang/Exception
    //   175	182	323	java/lang/Exception
    //   185	189	323	java/lang/Exception
    //   217	223	323	java/lang/Exception
    //   226	237	323	java/lang/Exception
    //   300	306	323	java/lang/Exception
    //   309	320	323	java/lang/Exception
    //   284	289	374	java/io/IOException
    //   367	372	382	java/io/IOException
    //   111	137	390	finally
    //   397	401	403	java/io/IOException
    //   140	151	411	finally
    //   154	159	411	finally
    //   162	168	411	finally
    //   175	182	411	finally
    //   185	189	411	finally
    //   217	223	411	finally
    //   226	237	411	finally
    //   244	272	411	finally
    //   275	279	411	finally
    //   300	306	411	finally
    //   309	320	411	finally
    //   327	355	411	finally
    //   358	362	411	finally
    //   111	137	415	java/lang/Exception
    //   111	137	422	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\compress\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */