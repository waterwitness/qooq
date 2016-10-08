package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.ImageTestUtil;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import wan;

public class ImageUtil
{
  public static final float a = 2.0F;
  public static final int a = 50;
  public static final String a = "thumb";
  private static String[] a;
  public static final int b = 3;
  public static final String b = "thumb2";
  public static final int c = 1;
  public static final String c = "photo";
  public static final int d = 2;
  public static final String d = "thumb/";
  public static final int e = 3;
  public static final String e = "thumb2/";
  public static final int f = 4;
  public static final String f = "photo/";
  public static final int g = 5;
  public static final String g = "image_upload";
  @Deprecated
  public static final int h = 6;
  public static final String h = "image_upload_exception_stack";
  public static final int i = 7;
  public static final String i = "actGrpImageuploadInvalid";
  public static final int j = 8;
  public static final String j = "actC2CImageuploadInvalid";
  public static final int k = 1;
  public static final String k = "actPubImageuploadInvalid";
  public static final int l = 2;
  public static final String l = "actAppShareImageuploadInvalid";
  public static final int m = 3;
  public static final String m = "report_sendphoto_iswifi";
  public static final int n = 4;
  public static final String n = "report_sendphoto_not_long_photo";
  public static final int o = 5;
  public static final String o = "report_sendphoto_not_larger_960";
  public static final int p = 6;
  private static final String p = ImageUtil.class.getSimpleName();
  public static final int q = 7;
  public static final int r = 8;
  public static final int s = 9;
  public static final int t = 0;
  private static final int u = 70;
  private static final int v = 80;
  private static final int w = 2;
  private static int x = 1280;
  private static final int y = 960;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    double d3 = 1.0D;
    if ((i1 <= paramInt1) && (i2 <= paramInt2)) {
      return d3;
    }
    double d1;
    if (i1 > i2) {
      d1 = i1 / paramInt1;
    }
    for (double d2 = i2 / paramInt2;; d2 = i1 / paramInt2)
    {
      d3 = d1;
      if (d1 > d2) {
        break;
      }
      return d2;
      d1 = i2 / paramInt1;
    }
  }
  
  public static int a(int paramInt)
  {
    float f1 = 1.0F;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    }
    if (BaseChatItemLayout.d <= 1.5D) {
      return (int)(f1 * 9.0F);
    }
    if (BaseChatItemLayout.d <= 2.0D) {
      return (int)(f1 * 9.0F);
    }
    return (int)(f1 * 4.0F);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = c(paramOptions, paramInt1, paramInt2);
    if (i1 <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i1) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i1 + 7) / 8 * 8;
    return paramInt2;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      return 1;
    }
    int i3 = paramOptions.outHeight;
    int i4 = paramOptions.outWidth;
    int i2 = 1;
    if ((i3 > paramInt2) || (i4 > paramInt1))
    {
      int i6 = Math.round(i3 / paramInt2);
      int i5 = Math.round(i4 / paramInt1);
      int i1;
      if (paramBoolean) {
        if (i6 > i5) {
          i1 = i6;
        }
      }
      for (;;)
      {
        if (i1 < 2) {
          break label136;
        }
        i4 /= 2;
        i3 /= 2;
        i2 *= 2;
        break;
        i1 = i5;
        continue;
        i1 = i6;
        if (i6 >= i5) {
          i1 = i5;
        }
      }
    }
    label136:
    return i2;
  }
  
  public static int a(ExifInterface paramExifInterface)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramExifInterface != null)
    {
      int i3 = paramExifInterface.getAttributeInt("Orientation", -1);
      a("getExifOrientation  orientation  =====" + i3 + "=====");
      i1 = i2;
      if (i3 != -1)
      {
        i1 = i2;
        switch (i3)
        {
        default: 
          i1 = i2;
        }
      }
    }
    for (;;)
    {
      a("getExifOrientation degree =======" + i1 + "==========");
      return i1;
      i1 = 90;
      continue;
      i1 = 180;
      continue;
      i1 = 270;
    }
  }
  
  public static int a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    paramInt1 = Math.min(i1 / paramInt1, i2 / paramInt2);
    if (paramInt1 < 1) {
      return 1;
    }
    return paramInt1;
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = Class.forName("android.media.ExifInterface").getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      if (paramString == null) {}
    }
    catch (Exception paramString)
    {
      try
      {
        i1 = ((Integer)paramString.getClass().getMethod("getAttributeInt", new Class[] { String.class, Integer.TYPE }).invoke(paramString, new Object[] { "Orientation", Integer.valueOf(-1) })).intValue();
        if (i1 != -1) {}
        switch (i1)
        {
        case 4: 
        case 5: 
        case 7: 
        default: 
          return 0;
          paramString = paramString;
          if (QLog.isColorLevel()) {
            QLog.e("reflection", 2, "e = " + paramString.toString());
          }
          paramString = null;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("reflection", 2, "e = " + paramString.toString());
          }
          int i1 = 0;
        }
        return 90;
      }
    }
    return 180;
    return 270;
  }
  
  public static long a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {}
    for (;;)
    {
      return -1L;
      try
      {
        int i1 = paramInputStream.read();
        if (i1 == 255)
        {
          if (paramInputStream.read() == 216) {
            return b(paramInputStream);
          }
        }
        else
        {
          int i2;
          int i3;
          if (i1 == 71)
          {
            if ((paramInputStream.read() == 73) && (paramInputStream.read() == 70))
            {
              paramInputStream.skip(3L);
              i1 = paramInputStream.read();
              i2 = paramInputStream.read();
              i3 = paramInputStream.read();
              return (paramInputStream.read() << 8 | i3) * (i1 | i2 << 8);
            }
          }
          else
          {
            long l1;
            if (i1 == 66)
            {
              if (paramInputStream.read() == 77)
              {
                paramInputStream.skip(16L);
                l1 = paramInputStream.read() | paramInputStream.read() << 8 | paramInputStream.read() << 16 | paramInputStream.read() << 24;
                i1 = paramInputStream.read();
                i2 = paramInputStream.read();
                i3 = paramInputStream.read();
                return (paramInputStream.read() << 24 | i1 | i2 << 8 | i3 << 16) * l1;
              }
            }
            else if ((i1 == 137) && (paramInputStream.read() == 80) && (paramInputStream.read() == 78))
            {
              paramInputStream.skip(13L);
              l1 = paramInputStream.read() << 24 | paramInputStream.read() << 16 | paramInputStream.read() << 8 | paramInputStream.read();
              i1 = paramInputStream.read();
              i2 = paramInputStream.read();
              i3 = paramInputStream.read();
              int i4 = paramInputStream.read();
              return (i4 | i1 << 24 | i2 << 16 | i3 << 8) * l1;
            }
          }
        }
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130838582);
      if ((localBitmap1 != null) && (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)) {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultFace", localBitmap1);
      }
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        QLog.d(p, 2, "getDefaultFaceBitmap, bitmap=" + localBitmap1);
        localBitmap2 = localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap a(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramInt == 0) || (paramInt == 2))
    {
      localObject2 = localObject1;
      if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
        localObject2 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultQQStoryRoundFace");
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = c(BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130841385), 10.0F, 70, 70);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
          {
            BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultQQStoryRoundFace", localObject2);
            localObject1 = localObject2;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return (Bitmap)localObject1;
            localObject1 = localObject3;
          } while (paramInt != 1);
          if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
            localObject2 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultQQStoryFace");
          }
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject2 = b(BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130841385), 70, 70);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache == null);
    BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultQQStoryFace", localObject2);
    return (Bitmap)localObject2;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, ArrayList paramArrayList)
  {
    int i2 = paramInt1 * paramInt2;
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfInt[i1] = -2631723;
      i1 += 1;
    }
    i1 = (int)(3.0F * paramFloat);
    i2 = (int)(2.0F * paramFloat);
    int i3 = (int)(32.0F * paramFloat);
    return a(paramInt1, paramInt2, paramFloat, arrayOfInt, -2631723, i1, i2, i3, i3, paramInt3, paramInt4, paramArrayList);
  }
  
  private static Bitmap a(int paramInt1, int paramInt2, float paramFloat, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, ArrayList paramArrayList)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    if (paramArrayList != null)
    {
      localBitmap1 = localBitmap2;
      if (paramArrayList.size() > 0)
      {
        localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localBitmap2.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
        paramArrayOfInt = new Canvas(localBitmap2);
        paramArrayList = paramArrayList.iterator();
        paramInt1 = 0;
        localBitmap1 = localBitmap2;
        if (paramArrayList.hasNext())
        {
          localBitmap1 = (Bitmap)paramArrayList.next();
          if (paramInt1 < 2)
          {
            paramInt2 = paramInt4;
            label99:
            if (paramInt1 % 2 != 0) {
              break label148;
            }
          }
          label148:
          for (paramInt9 = paramInt4;; paramInt9 = paramInt6 + paramInt4 + paramInt5)
          {
            a(localBitmap1, paramArrayOfInt, paramInt9, paramInt2, localBitmap1.getWidth() / paramInt8, paramInt3);
            paramInt1 += 1;
            break;
            paramInt2 = paramInt7 + paramInt4 + paramInt5;
            break label99;
          }
        }
      }
    }
    return localBitmap1;
  }
  
  private static Bitmap a(int paramInt1, Context paramContext, File paramFile, int paramInt2, ImageInfo paramImageInfo)
  {
    Object localObject2 = null;
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    BitmapFactory.Options localOptions2 = a(localOptions1, paramFile.getPath(), paramInt2);
    if ((localOptions1.outWidth > 960) || (localOptions1.outHeight > 960)) {
      a("report_sendphoto_not_larger_960", paramContext, true);
    }
    for (;;)
    {
      paramInt2 = 1;
      paramInt1 = 0;
      Bitmap localBitmap = null;
      for (;;)
      {
        if (((localBitmap != null) || (localOptions2.inSampleSize <= 0) || (localOptions2.inSampleSize > 4)) && (paramInt2 == 0)) {
          break label295;
        }
        if (paramInt2 == 0) {
          localOptions2.inSampleSize *= 2;
        }
        try
        {
          localBitmap = SafeBitmapFactory.decodeFile(paramFile.getPath(), localOptions2);
          paramInt2 = 0;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          a("compress : compressNoLargePhoto  getBitmap  OOM " + localOptions2.inSampleSize);
          paramInt1 = localOptions1.outWidth * localOptions1.outHeight;
          if ((paramInt1 > URLDrawableHelper.a) || (paramInt1 <= 0)) {
            break label196;
          }
          ImageTestUtil.a(((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).a());
          if (!NetworkUtil.i(paramContext)) {
            break label285;
          }
        }
      }
      a("report_sendphoto_not_larger_960", paramContext, false);
    }
    label196:
    paramImageInfo.jdField_k_of_type_Int = 1;
    paramImageInfo.g = true;
    if (paramImageInfo.d == 0)
    {
      paramImageInfo.jdField_j_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d(p, 2, "WIFI oom ,c2c send srcfile by raw");
      }
      label245:
      paramInt1 = 1;
    }
    label285:
    Object localObject1;
    label295:
    for (paramContext = (Context)localObject2;; paramContext = (Context)localObject1)
    {
      if ((paramContext == null) && (paramInt1 != 0)) {
        paramImageInfo.g = true;
      }
      return paramContext;
      if (!QLog.isColorLevel()) {
        break label245;
      }
      QLog.d(p, 2, "WIFI oom ,not c2c send srcfile by nor");
      break label245;
      paramInt2 = 0;
      paramInt1 = 1;
      localObject1 = null;
      break;
    }
  }
  
  /* Error */
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 435	android/util/TypedValue
    //   5: dup
    //   6: invokespecial 436	android/util/TypedValue:<init>	()V
    //   9: astore 4
    //   11: new 438	java/io/BufferedInputStream
    //   14: dup
    //   15: aload_0
    //   16: iload_1
    //   17: aload 4
    //   19: invokevirtual 444	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   22: invokespecial 447	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_2
    //   26: aload_0
    //   27: aload 4
    //   29: aload_2
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokestatic 453	android/graphics/BitmapFactory:decodeResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   35: astore_0
    //   36: aload_0
    //   37: astore_3
    //   38: aload_3
    //   39: astore_0
    //   40: aload_2
    //   41: ifnull +9 -> 50
    //   44: aload_2
    //   45: invokevirtual 456	java/io/InputStream:close	()V
    //   48: aload_3
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_3
    //   56: astore_0
    //   57: aload_2
    //   58: ifnull -8 -> 50
    //   61: aload_2
    //   62: invokevirtual 456	java/io/InputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: areturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_3
    //   74: astore_0
    //   75: aload_2
    //   76: ifnull -26 -> 50
    //   79: aload_2
    //   80: invokevirtual 456	java/io/InputStream:close	()V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 456	java/io/InputStream:close	()V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: aload_3
    //   103: areturn
    //   104: astore_2
    //   105: goto -6 -> 99
    //   108: astore_0
    //   109: goto -18 -> 91
    //   112: astore_0
    //   113: goto -40 -> 73
    //   116: astore_0
    //   117: goto -62 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramResources	Resources
    //   0	120	1	paramInt	int
    //   25	71	2	localBufferedInputStream	java.io.BufferedInputStream
    //   104	1	2	localIOException	IOException
    //   1	102	3	localResources	Resources
    //   9	19	4	localTypedValue	android.util.TypedValue
    // Exception table:
    //   from	to	target	type
    //   2	26	52	java/lang/OutOfMemoryError
    //   61	65	67	java/io/IOException
    //   2	26	70	java/lang/Throwable
    //   79	83	85	java/io/IOException
    //   2	26	88	finally
    //   44	48	101	java/io/IOException
    //   95	99	104	java/io/IOException
    //   26	36	108	finally
    //   26	36	112	java/lang/Throwable
    //   26	36	116	java/lang/OutOfMemoryError
  }
  
  public static final Bitmap a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_4444);
      localObject = paramBitmap;
      if (localBitmap != null)
      {
        localObject = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        ColorMatrix localColorMatrix = new ColorMatrix();
        localColorMatrix.setSaturation(0.0F);
        localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
        ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
        localObject = localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        Object localObject = paramBitmap;
      } while (!QLog.isColorLevel());
      QLog.d(p, 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(localOutOfMemoryError));
    }
    return (Bitmap)localObject;
    return paramBitmap;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {}
    do
    {
      return (Bitmap)localObject2;
      try
      {
        localObject2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Paint localPaint;
          Rect localRect;
          RectF localRectF;
          a("OOM occurred in ImageUtil.round" + localOutOfMemoryError.getMessage());
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    localObject2 = new Canvas((Bitmap)localObject1);
    localPaint = new Paint();
    localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    ((Canvas)localObject2).drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject2).drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return (Bitmap)localObject1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        a("cutOurImg() img:[" + f1 + ", " + f2 + "], default: [" + paramFloat1 + ", " + paramFloat2 + "]");
        float f3 = paramFloat1 / f1;
        float f4 = paramFloat2 / f2;
        if (f3 > f4)
        {
          i2 = (int)paramFloat1;
          i1 = (int)(f3 * f2);
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(i2 / f1, i1 / f2);
          localMatrix.postTranslate((paramFloat1 - i2) / 2.0F, (paramFloat2 - i1) / 2.0F);
          Bitmap localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.RGB_565);
          new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, null);
          paramBitmap = localBitmap;
          return paramBitmap;
        }
        int i2 = (int)(f1 * f4);
        int i1 = (int)paramFloat2;
        continue;
        paramBitmap = null;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        return null;
      }
      catch (Exception paramBitmap)
      {
        return null;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        int i2 = paramBitmap.getWidth();
        int i1 = paramBitmap.getHeight();
        if (i2 > i1)
        {
          i4 = (i2 - i1) / 2;
          i3 = 0;
          paramInt1 = paramInt2;
          i2 = i1;
          paramFloat = paramInt1;
          Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(i4, i3, i2 + i4, i1 + i3);
          Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
          return localBitmap;
        }
        if (i1 > i2)
        {
          i3 = (i1 - i2) / 2;
          int i5 = 0;
          paramInt2 = paramInt1;
          i4 = i2;
          i1 = i2;
          i2 = i4;
          i4 = i5;
          continue;
        }
        int i3 = 0;
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        return null;
      }
      int i4 = 0;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, ImageUtil.ScalingLogic paramScalingLogic)
  {
    if (paramBitmap == null) {
      return null;
    }
    return a(paramBitmap, (int)(paramBitmap.getWidth() * paramFloat), (int)(paramBitmap.getHeight() * paramFloat), paramScalingLogic);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap;
    if ((paramBitmap == null) || (paramInt <= 0)) {
      localBitmap = null;
    }
    int i3;
    int i4;
    do
    {
      do
      {
        return localBitmap;
        i3 = paramBitmap.getWidth();
        i4 = paramBitmap.getHeight();
        localBitmap = paramBitmap;
      } while (i3 <= paramInt);
      localBitmap = paramBitmap;
    } while (i4 <= paramInt);
    int i1 = Math.max(i3, i4) * paramInt / Math.min(i3, i4);
    int i2;
    if (i3 > i4) {
      i2 = i1;
    }
    for (;;)
    {
      if (i3 > i4) {
        i1 = paramInt;
      }
      try
      {
        paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i2, i1, true);
        i2 = (i2 - paramInt) / 2;
        i1 = (i1 - paramInt) / 2;
        try
        {
          localBitmap = Bitmap.createBitmap(paramBitmap, i2, i1, paramInt, paramInt);
          paramBitmap.recycle();
          return localBitmap;
        }
        catch (Exception paramBitmap)
        {
          return null;
        }
        i2 = paramInt;
      }
      catch (Exception paramBitmap) {}
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = BaseApplicationImpl.a().getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, ImageUtil.ScalingLogic paramScalingLogic)
  {
    if (paramBitmap == null) {
      return null;
    }
    Rect localRect = a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2, paramScalingLogic);
    paramScalingLogic = b(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2, paramScalingLogic);
    Bitmap localBitmap = Bitmap.createBitmap(paramScalingLogic.width(), paramScalingLogic.height(), Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap).drawBitmap(paramBitmap, localRect, paramScalingLogic, new Paint(3));
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, File paramFile)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    do
    {
      return (Bitmap)localObject;
      localObject = new Matrix();
      int i1 = paramBitmap.getWidth();
      int i2 = paramBitmap.getHeight();
      int i3 = Math.max(i1, i2);
      float f1 = x / (i3 * 1.0F);
      i3 = b(paramFile.getPath());
      if (f1 < 1.0F) {}
      try
      {
        ((Matrix)localObject).postScale(f1, f1);
        if ((i3 != 0) && (i3 % 90 == 0)) {
          ((Matrix)localObject).postRotate(i3, i1 / 2.0F, i2 / 2.0F);
        }
        paramFile = Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, (Matrix)localObject, true);
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          a("compress : " + paramFile.getMessage());
          paramFile = null;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        for (;;)
        {
          a("compress :  scaleBitmap OOM");
          paramFile = null;
        }
      }
      localObject = paramBitmap;
    } while (paramFile == null);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!paramBitmap.equals(paramFile))) {
      paramBitmap.recycle();
    }
    return paramFile;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap = null;
    Object localObject;
    if (paramDrawable == null) {
      localObject = localBitmap;
    }
    for (;;)
    {
      return (Bitmap)localObject;
      int i1 = paramDrawable.getIntrinsicWidth();
      int i2 = paramDrawable.getIntrinsicWidth();
      localObject = localBitmap;
      if (i1 <= 0) {
        continue;
      }
      localObject = localBitmap;
      if (i2 <= 0) {
        continue;
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
        {
          localBitmap = Bitmap.createBitmap(i1, i2, (Bitmap.Config)localObject);
          localObject = localBitmap;
          if (localBitmap == null) {
            break;
          }
          localObject = new Canvas(localBitmap);
          paramDrawable.setBounds(0, 0, i1, i2);
          paramDrawable.draw((Canvas)localObject);
          return localBitmap;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  /* Error */
  public static Bitmap a(File paramFile, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 663	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: aconst_null
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: aconst_null
    //   16: astore 6
    //   18: aload_0
    //   19: iload_1
    //   20: iload_1
    //   21: invokestatic 666	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   24: astore 7
    //   26: new 668	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 671	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_0
    //   35: aload 7
    //   37: getstatic 338	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   40: putfield 674	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   43: aload_0
    //   44: aconst_null
    //   45: aload 7
    //   47: invokestatic 114	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: astore 6
    //   52: new 550	android/graphics/Matrix
    //   55: dup
    //   56: invokespecial 551	android/graphics/Matrix:<init>	()V
    //   59: astore 7
    //   61: aload 6
    //   63: invokevirtual 367	android/graphics/Bitmap:getWidth	()I
    //   66: istore 10
    //   68: aload 6
    //   70: invokevirtual 460	android/graphics/Bitmap:getHeight	()I
    //   73: istore 11
    //   75: fconst_1
    //   76: fstore 4
    //   78: iload 11
    //   80: iload 10
    //   82: if_icmple +144 -> 226
    //   85: iload_1
    //   86: i2f
    //   87: iload 10
    //   89: i2f
    //   90: fconst_1
    //   91: fmul
    //   92: fdiv
    //   93: fstore 5
    //   95: fload 5
    //   97: fstore 4
    //   99: iload 11
    //   101: i2f
    //   102: fload 5
    //   104: fmul
    //   105: iload_2
    //   106: i2f
    //   107: fcmpl
    //   108: ifle +302 -> 410
    //   111: iconst_0
    //   112: iload 11
    //   114: i2f
    //   115: fload 5
    //   117: fmul
    //   118: iload_2
    //   119: i2f
    //   120: fsub
    //   121: fconst_2
    //   122: fdiv
    //   123: f2i
    //   124: invokestatic 587	java/lang/Math:max	(II)I
    //   127: istore 8
    //   129: iconst_0
    //   130: istore 9
    //   132: fload 5
    //   134: fstore 4
    //   136: aload 7
    //   138: fload 4
    //   140: fload 4
    //   142: invokevirtual 555	android/graphics/Matrix:postScale	(FF)Z
    //   145: pop
    //   146: aload 6
    //   148: iconst_0
    //   149: iconst_0
    //   150: iload 10
    //   152: iload 11
    //   154: aload 7
    //   156: iconst_1
    //   157: invokestatic 631	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   160: iload 9
    //   162: iload 8
    //   164: iload_1
    //   165: iload_2
    //   166: invokestatic 594	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   169: astore 7
    //   171: aload 7
    //   173: astore 6
    //   175: iload_3
    //   176: ifeq +23 -> 199
    //   179: aload 7
    //   181: ldc_w 675
    //   184: aload 7
    //   186: invokevirtual 367	android/graphics/Bitmap:getWidth	()I
    //   189: aload 7
    //   191: invokevirtual 460	android/graphics/Bitmap:getHeight	()I
    //   194: invokestatic 608	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   197: astore 6
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 456	java/io/InputStream:close	()V
    //   207: aload 6
    //   209: astore_0
    //   210: iconst_0
    //   211: ifeq -198 -> 13
    //   214: new 677	java/lang/NullPointerException
    //   217: dup
    //   218: invokespecial 678	java/lang/NullPointerException:<init>	()V
    //   221: athrow
    //   222: astore_0
    //   223: aload 6
    //   225: areturn
    //   226: iload 11
    //   228: iload 10
    //   230: if_icmpge +180 -> 410
    //   233: iload_2
    //   234: i2f
    //   235: iload 11
    //   237: i2f
    //   238: fconst_1
    //   239: fmul
    //   240: fdiv
    //   241: fstore 5
    //   243: fload 5
    //   245: fstore 4
    //   247: iload 10
    //   249: i2f
    //   250: fload 5
    //   252: fmul
    //   253: iload_1
    //   254: i2f
    //   255: fcmpl
    //   256: ifle +154 -> 410
    //   259: iload 10
    //   261: i2f
    //   262: fload 5
    //   264: fmul
    //   265: iload_1
    //   266: i2f
    //   267: fsub
    //   268: fconst_2
    //   269: fdiv
    //   270: f2i
    //   271: istore 8
    //   273: iconst_0
    //   274: iload 8
    //   276: invokestatic 587	java/lang/Math:max	(II)I
    //   279: istore 9
    //   281: iconst_0
    //   282: istore 8
    //   284: fload 5
    //   286: fstore 4
    //   288: goto -152 -> 136
    //   291: astore_0
    //   292: aload 6
    //   294: astore_0
    //   295: aload_0
    //   296: ifnull +7 -> 303
    //   299: aload_0
    //   300: invokevirtual 456	java/io/InputStream:close	()V
    //   303: iconst_0
    //   304: ifeq +11 -> 315
    //   307: new 677	java/lang/NullPointerException
    //   310: dup
    //   311: invokespecial 678	java/lang/NullPointerException:<init>	()V
    //   314: athrow
    //   315: aconst_null
    //   316: areturn
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_0
    //   320: aload_0
    //   321: ifnull +7 -> 328
    //   324: aload_0
    //   325: invokevirtual 456	java/io/InputStream:close	()V
    //   328: iconst_0
    //   329: ifeq -14 -> 315
    //   332: new 677	java/lang/NullPointerException
    //   335: dup
    //   336: invokespecial 678	java/lang/NullPointerException:<init>	()V
    //   339: athrow
    //   340: astore_0
    //   341: goto -26 -> 315
    //   344: astore 6
    //   346: aconst_null
    //   347: astore_0
    //   348: aload_0
    //   349: ifnull +7 -> 356
    //   352: aload_0
    //   353: invokevirtual 456	java/io/InputStream:close	()V
    //   356: iconst_0
    //   357: ifeq +11 -> 368
    //   360: new 677	java/lang/NullPointerException
    //   363: dup
    //   364: invokespecial 678	java/lang/NullPointerException:<init>	()V
    //   367: athrow
    //   368: aload 6
    //   370: athrow
    //   371: astore_0
    //   372: goto -165 -> 207
    //   375: astore_0
    //   376: goto -73 -> 303
    //   379: astore_0
    //   380: goto -65 -> 315
    //   383: astore_0
    //   384: goto -56 -> 328
    //   387: astore_0
    //   388: goto -32 -> 356
    //   391: astore_0
    //   392: goto -24 -> 368
    //   395: astore 6
    //   397: goto -49 -> 348
    //   400: astore 6
    //   402: goto -82 -> 320
    //   405: astore 6
    //   407: goto -112 -> 295
    //   410: iconst_0
    //   411: istore 8
    //   413: iconst_0
    //   414: istore 9
    //   416: goto -280 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	paramFile	File
    //   0	419	1	paramInt1	int
    //   0	419	2	paramInt2	int
    //   0	419	3	paramBoolean	boolean
    //   76	211	4	f1	float
    //   93	192	5	f2	float
    //   16	277	6	localObject1	Object
    //   344	25	6	localObject2	Object
    //   395	1	6	localObject3	Object
    //   400	1	6	localOutOfMemoryError	OutOfMemoryError
    //   405	1	6	localException	Exception
    //   24	166	7	localObject4	Object
    //   127	285	8	i1	int
    //   130	285	9	i2	int
    //   66	194	10	i3	int
    //   73	163	11	i4	int
    // Exception table:
    //   from	to	target	type
    //   214	222	222	java/io/IOException
    //   18	35	291	java/lang/Exception
    //   18	35	317	java/lang/OutOfMemoryError
    //   332	340	340	java/io/IOException
    //   18	35	344	finally
    //   203	207	371	java/io/IOException
    //   299	303	375	java/io/IOException
    //   307	315	379	java/io/IOException
    //   324	328	383	java/io/IOException
    //   352	356	387	java/io/IOException
    //   360	368	391	java/io/IOException
    //   35	75	395	finally
    //   85	95	395	finally
    //   111	129	395	finally
    //   136	171	395	finally
    //   179	199	395	finally
    //   273	281	395	finally
    //   35	75	400	java/lang/OutOfMemoryError
    //   85	95	400	java/lang/OutOfMemoryError
    //   111	129	400	java/lang/OutOfMemoryError
    //   136	171	400	java/lang/OutOfMemoryError
    //   179	199	400	java/lang/OutOfMemoryError
    //   273	281	400	java/lang/OutOfMemoryError
    //   35	75	405	java/lang/Exception
    //   85	95	405	java/lang/Exception
    //   111	129	405	java/lang/Exception
    //   136	171	405	java/lang/Exception
    //   179	199	405	java/lang/Exception
    //   273	281	405	java/lang/Exception
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    if (paramString != null) {}
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localObject = new FileInputStream(paramString);
      SafeBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
      int i1 = localOptions.outWidth;
      int i2 = localOptions.outHeight;
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = Math.max(i1 / paramInt1, i2 / paramInt2);
      localOptions.inJustDecodeBounds = false;
      localOptions.inPurgeable = true;
      ((InputStream)localObject).close();
      localObject = SafeBitmapFactory.decodeStream(new FileInputStream(paramString), null, localOptions);
      return (Bitmap)localObject;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 438	java/io/BufferedInputStream
    //   6: dup
    //   7: new 668	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 681	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 447	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_0
    //   21: aload_2
    //   22: aconst_null
    //   23: aload_1
    //   24: invokestatic 685	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_0
    //   31: astore_3
    //   32: aload_2
    //   33: ifnull +9 -> 42
    //   36: aload_2
    //   37: invokevirtual 456	java/io/InputStream:close	()V
    //   40: aload_0
    //   41: astore_3
    //   42: aload_3
    //   43: areturn
    //   44: astore_3
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_1
    //   48: astore_0
    //   49: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +16 -> 68
    //   55: aload_1
    //   56: astore_0
    //   57: getstatic 95	com/tencent/mobileqq/utils/ImageUtil:p	Ljava/lang/String;
    //   60: iconst_2
    //   61: ldc_w 687
    //   64: aload_3
    //   65: invokestatic 690	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: ifnull -30 -> 42
    //   75: aload_1
    //   76: invokevirtual 456	java/io/InputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aconst_null
    //   83: areturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 456	java/io/InputStream:close	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: aload_0
    //   99: areturn
    //   100: astore_0
    //   101: goto -6 -> 95
    //   104: astore_1
    //   105: goto -18 -> 87
    //   108: astore_3
    //   109: aload_2
    //   110: astore_1
    //   111: goto -64 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramString	String
    //   0	114	1	paramOptions	BitmapFactory.Options
    //   18	92	2	localBufferedInputStream	java.io.BufferedInputStream
    //   31	12	3	str	String
    //   44	21	3	localException1	Exception
    //   70	1	3	localObject1	Object
    //   108	1	3	localException2	Exception
    //   1	68	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	44	java/lang/Exception
    //   75	79	81	java/io/IOException
    //   3	19	84	finally
    //   36	40	97	java/io/IOException
    //   91	95	100	java/io/IOException
    //   21	28	104	finally
    //   49	55	104	finally
    //   57	68	104	finally
    //   21	28	108	java/lang/Exception
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    int i4 = 1;
    paramOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, paramOptions);
    int i1 = paramOptions.outHeight;
    int i3 = paramOptions.outWidth;
    int i2 = 1;
    if ((i1 > paramInt) || (i3 > paramInt))
    {
      if (Math.round(Math.max(i1, i3) / (paramInt * 1.0F)) < 2) {
        break label144;
      }
      i3 /= 2;
      i1 /= 2;
      if ((i3 >= paramInt) || (i1 >= paramInt)) {
        break label113;
      }
      paramOptions.inSampleSize = i2;
    }
    for (;;)
    {
      paramOptions.inJustDecodeBounds = false;
      paramInt = i4;
      if (paramOptions.inSampleSize >= 1) {
        paramInt = paramOptions.inSampleSize;
      }
      paramOptions.inSampleSize = paramInt;
      return paramOptions;
      label113:
      if ((i3 == paramInt) || (i1 == paramInt))
      {
        paramOptions.inSampleSize = (i2 * 2);
      }
      else
      {
        i2 *= 2;
        break;
        label144:
        paramOptions.inSampleSize = i2;
      }
    }
  }
  
  private static BitmapFactory.Options a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramFile.getPath(), localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options a(File paramFile, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    double d1 = a(localFileInputStream, paramInt1, paramInt2);
    localFileInputStream.close();
    localOptions.inSampleSize = ((int)d1);
    localOptions.inJustDecodeBounds = true;
    localFileInputStream = new FileInputStream(paramFile);
    SafeBitmapFactory.decodeStream(localFileInputStream, null, localOptions);
    localFileInputStream.close();
    paramInt2 = 0;
    for (;;)
    {
      if (localOptions.outWidth > paramInt1)
      {
        localOptions.inSampleSize += 1;
        localFileInputStream = new FileInputStream(paramFile);
        SafeBitmapFactory.decodeStream(localFileInputStream, null, localOptions);
        localFileInputStream.close();
        if (paramInt2 <= 3) {}
      }
      else
      {
        localOptions.inJustDecodeBounds = false;
        return localOptions;
      }
      paramInt2 += 1;
    }
  }
  
  public static BitmapFactory.Options a(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeStream(paramInputStream, null, localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options a(String paramString, int paramInt)
  {
    int i4 = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int i1 = localOptions.outHeight;
    int i3 = localOptions.outWidth;
    a("compressAIOThumbImg  org width:" + i3 + ",height:" + i1);
    int i2 = 1;
    if ((i1 > paramInt) && (i3 > paramInt))
    {
      if (Math.min(Math.round(i1 / paramInt), Math.round(i3 / paramInt)) < 2) {
        break label191;
      }
      i3 /= 2;
      i1 /= 2;
      if ((i3 >= paramInt) && (i1 >= paramInt)) {
        break label160;
      }
      localOptions.inSampleSize = i2;
    }
    for (;;)
    {
      localOptions.inJustDecodeBounds = false;
      paramInt = i4;
      if (localOptions.inSampleSize >= 1) {
        paramInt = localOptions.inSampleSize;
      }
      localOptions.inSampleSize = paramInt;
      return localOptions;
      label160:
      if ((i3 == paramInt) || (i1 == paramInt))
      {
        localOptions.inSampleSize = (i2 * 2);
      }
      else
      {
        i2 *= 2;
        break;
        label191:
        localOptions.inSampleSize = i2;
      }
    }
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageUtil.ScalingLogic paramScalingLogic)
  {
    if (paramScalingLogic == ImageUtil.ScalingLogic.CROP)
    {
      float f1 = paramInt1 / paramInt2;
      float f2 = paramInt3 / paramInt4;
      if (f1 > f2)
      {
        paramInt3 = (int)(paramInt2 * f2);
        paramInt1 = (paramInt1 - paramInt3) / 2;
        return new Rect(paramInt1, 0, paramInt3 + paramInt1, paramInt2);
      }
      paramInt3 = (int)(paramInt1 / f2);
      paramInt2 = (paramInt2 - paramInt3) / 2;
      return new Rect(0, paramInt2, paramInt1, paramInt3 + paramInt2);
    }
    return new Rect(0, 0, paramInt1, paramInt2);
  }
  
  public static Rect a(Rect paramRect, int paramInt, float paramFloat)
  {
    if ((paramRect != null) && (paramInt > 0) && (paramFloat > 0.0F))
    {
      int i3 = (int)(paramInt * paramFloat);
      int i1 = paramRect.width();
      int i2 = paramRect.width();
      if (i1 > i2) {}
      for (paramInt = i1; paramInt < i3; paramInt = i2)
      {
        paramRect = new Rect();
        a(paramRect, i1, i2, i3);
        return paramRect;
      }
    }
    return null;
  }
  
  public static Rect a(Drawable paramDrawable, int paramInt, float paramFloat)
  {
    int i3;
    int i1;
    int i2;
    if ((paramDrawable != null) && (paramInt > 0) && (paramFloat > 0.0F))
    {
      i3 = (int)(paramInt * paramFloat);
      i1 = paramDrawable.getIntrinsicWidth();
      i2 = paramDrawable.getIntrinsicHeight();
      if ((i1 != -1) && (i2 != -1)) {
        break label45;
      }
    }
    for (;;)
    {
      return null;
      label45:
      if (i1 > i2) {}
      for (paramInt = i1; paramInt < i3; paramInt = i2)
      {
        paramDrawable = new Rect();
        a(paramDrawable, i1, i2, i3);
        return paramDrawable;
      }
    }
  }
  
  public static Rect a(Drawable paramDrawable, int paramInt1, int paramInt2, float paramFloat)
  {
    Rect localRect = new Rect();
    int i2;
    int i3;
    if ((paramDrawable != null) && (paramInt2 > 0) && (paramInt1 > 0) && (paramInt2 > paramInt1) && (paramFloat > 0.0F))
    {
      i2 = paramDrawable.getIntrinsicWidth();
      i3 = paramDrawable.getIntrinsicHeight();
      if (i2 <= i3) {
        break label78;
      }
    }
    label78:
    for (int i1 = i2; i1 < paramInt1; i1 = i3)
    {
      a(localRect, i2, i3, (int)(paramInt1 * paramFloat));
      return localRect;
    }
    if ((i1 >= paramInt1) && (i1 < paramInt2))
    {
      localRect.set(0, 0, (int)(i2 * paramFloat), (int)(i3 * paramFloat));
      return localRect;
    }
    a(localRect, i2, i3, (int)(paramInt2 * paramFloat));
    return localRect;
  }
  
  public static Drawable a()
  {
    return new BitmapDrawable(c());
  }
  
  public static Drawable a(int paramInt)
  {
    return new BitmapDrawable(a(paramInt));
  }
  
  public static Drawable a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, ArrayList paramArrayList)
  {
    int i2 = paramInt1 * paramInt2;
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfInt[i1] = -2631723;
      i1 += 1;
    }
    i1 = (int)(3.0F * paramFloat);
    i2 = (int)(2.0F * paramFloat);
    int i3 = (int)(32.0F * paramFloat);
    return a(paramInt1, paramInt2, paramFloat, arrayOfInt, -2631723, i1, i2, i3, i3, paramInt3, paramInt4, paramArrayList);
  }
  
  public static Drawable a(int paramInt1, int paramInt2, float paramFloat, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, ArrayList paramArrayList)
  {
    Bitmap localBitmap = null;
    Object localObject = localBitmap;
    if (paramArrayList != null)
    {
      localObject = localBitmap;
      if (paramArrayList.size() > 0)
      {
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject).setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
        paramArrayOfInt = new Canvas((Bitmap)localObject);
        paramArrayList = paramArrayList.iterator();
        paramInt1 = 0;
        if (paramArrayList.hasNext())
        {
          localBitmap = (Bitmap)paramArrayList.next();
          if (paramInt1 < 2)
          {
            paramInt2 = paramInt4;
            label95:
            if (paramInt1 % 2 != 0) {
              break label144;
            }
          }
          label144:
          for (int i1 = paramInt4;; i1 = paramInt6 + paramInt4 + paramInt5)
          {
            a(localBitmap, paramArrayOfInt, i1, paramInt2, localBitmap.getWidth() / paramInt8, paramInt3);
            paramInt1 += 1;
            break;
            paramInt2 = paramInt7 + paramInt4 + paramInt5;
            break label95;
          }
        }
        localObject = new BitmapDrawable(a((Bitmap)localObject, ((Bitmap)localObject).getWidth() / paramInt9));
      }
    }
    return (Drawable)localObject;
  }
  
  public static File a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    File localFile = new File(paramString);
    try
    {
      if (!localFile.exists())
      {
        int i1 = paramString.lastIndexOf('/');
        if ((i1 > 0) && (i1 < paramString.length() - 1))
        {
          paramString = new File(paramString.substring(0, i1));
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
        }
      }
      for (;;)
      {
        localFile.createNewFile();
        return localFile;
        localFile.delete();
      }
      return null;
    }
    catch (IOException paramString) {}
  }
  
  public static String a(double paramDouble)
  {
    int i4 = (int)paramDouble;
    paramDouble = paramDouble % 1.0D * 60.0D;
    int i2 = (int)paramDouble;
    int i1 = i2;
    if (i2 < 0) {
      i1 = i2 * -1;
    }
    int i3 = (int)(paramDouble % 1.0D * 60.0D);
    i2 = i3;
    if (i3 < 0) {
      i2 = i3 * -1;
    }
    return String.valueOf(i4) + "/1," + String.valueOf(i1) + "/1," + String.valueOf(i2) + "/1";
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    Object localObject = AppConstants.bj + "thumb/";
    if (paramUri == null) {
      paramContext = "";
    }
    do
    {
      do
      {
        return paramContext;
        paramUri = c(paramContext, paramUri);
        paramContext = paramUri;
      } while (paramUri.startsWith((String)localObject));
      paramContext = paramUri.substring(paramUri.lastIndexOf("/") + 1);
      paramUri = (String)localObject + paramUri.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramContext = paramUri;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramUri;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      paramContext = "";
    }
    Object localObject;
    do
    {
      do
      {
        return paramContext;
        localObject = AppConstants.bj + "thumb/";
        paramContext = paramString;
      } while (paramString.startsWith((String)localObject));
      paramContext = paramString.substring(paramString.lastIndexOf("/") + 1);
      paramString = (String)localObject + paramString.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramContext = paramString;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramString;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext, paramString, paramInt, 0);
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    if (paramString == null) {
      return "";
    }
    Object localObject = new File(paramString);
    long l1 = 0L;
    if (((File)localObject).exists()) {
      l1 = ((File)localObject).lastModified();
    }
    localObject = paramString.substring(paramString.lastIndexOf("/") + 1);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.bj).append("photo/");
    if (NetworkUtil.b(paramContext)) {
      localStringBuffer.append("WIFI");
    }
    if ((paramInt1 == 1) || (paramInt1 == 1001) || (paramInt1 == 3000))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label185;
      }
    }
    label185:
    for (paramInt1 = i1;; paramInt1 = 0)
    {
      localStringBuffer.append(paramInt1);
      localStringBuffer.append("s").append(paramInt2);
      localStringBuffer.append((paramString + l1).hashCode()).append((String)localObject);
      return localStringBuffer.toString();
      paramInt1 = 0;
      break;
    }
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 375	java/io/File
    //   3: dup
    //   4: new 153	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 770	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   14: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 21
    //   19: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 663	java/io/File:exists	()Z
    //   33: ifne +8 -> 41
    //   36: aload_0
    //   37: invokevirtual 818	java/io/File:mkdir	()Z
    //   40: pop
    //   41: new 375	java/io/File
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 8
    //   51: new 375	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 9
    //   61: aload 9
    //   63: invokevirtual 663	java/io/File:exists	()Z
    //   66: ifne +5 -> 71
    //   69: aconst_null
    //   70: areturn
    //   71: aload 8
    //   73: invokevirtual 663	java/io/File:exists	()Z
    //   76: ifne +9 -> 85
    //   79: aload 8
    //   81: invokevirtual 751	java/io/File:createNewFile	()Z
    //   84: pop
    //   85: new 668	java/io/FileInputStream
    //   88: dup
    //   89: aload 9
    //   91: invokespecial 671	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: invokestatic 820	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   97: astore_0
    //   98: aload_0
    //   99: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   102: istore 10
    //   104: aload_0
    //   105: getfield 117	android/graphics/BitmapFactory$Options:outWidth	I
    //   108: istore 11
    //   110: iload_3
    //   111: i2f
    //   112: iload 10
    //   114: iload 11
    //   116: invokestatic 587	java/lang/Math:max	(II)I
    //   119: i2f
    //   120: fdiv
    //   121: fstore 5
    //   123: iload 10
    //   125: iload 11
    //   127: invokestatic 587	java/lang/Math:max	(II)I
    //   130: iload_3
    //   131: if_icmpgt +334 -> 465
    //   134: fconst_1
    //   135: fstore 5
    //   137: new 104	android/graphics/BitmapFactory$Options
    //   140: dup
    //   141: invokespecial 105	android/graphics/BitmapFactory$Options:<init>	()V
    //   144: astore_0
    //   145: aload_0
    //   146: iload 10
    //   148: iload 11
    //   150: invokestatic 587	java/lang/Math:max	(II)I
    //   153: iload_3
    //   154: idiv
    //   155: putfield 387	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   158: aload_1
    //   159: aload_0
    //   160: invokestatic 391	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull +303 -> 468
    //   168: iload 11
    //   170: i2f
    //   171: fload 5
    //   173: fmul
    //   174: f2i
    //   175: istore_3
    //   176: fload 5
    //   178: iload 10
    //   180: i2f
    //   181: fmul
    //   182: f2i
    //   183: istore 10
    //   185: aload_0
    //   186: iload_3
    //   187: iload 10
    //   189: iconst_0
    //   190: invokestatic 591	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   193: astore_0
    //   194: aload_1
    //   195: invokestatic 822	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)I
    //   198: istore_3
    //   199: aload_0
    //   200: astore 7
    //   202: iload_3
    //   203: ifeq +68 -> 271
    //   206: aload_0
    //   207: astore 7
    //   209: iload_3
    //   210: bipush 90
    //   212: irem
    //   213: ifne +58 -> 271
    //   216: aload_0
    //   217: invokevirtual 367	android/graphics/Bitmap:getWidth	()I
    //   220: i2f
    //   221: fstore 5
    //   223: aload_0
    //   224: invokevirtual 460	android/graphics/Bitmap:getHeight	()I
    //   227: i2f
    //   228: fstore 6
    //   230: new 550	android/graphics/Matrix
    //   233: dup
    //   234: invokespecial 551	android/graphics/Matrix:<init>	()V
    //   237: astore 7
    //   239: aload 7
    //   241: iload_3
    //   242: i2f
    //   243: fload 5
    //   245: fconst_2
    //   246: fdiv
    //   247: fload 6
    //   249: fconst_2
    //   250: fdiv
    //   251: invokevirtual 826	android/graphics/Matrix:setRotate	(FFF)V
    //   254: aload_0
    //   255: iconst_0
    //   256: iconst_0
    //   257: fload 5
    //   259: f2i
    //   260: fload 6
    //   262: f2i
    //   263: aload 7
    //   265: iconst_1
    //   266: invokestatic 631	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   269: astore 7
    //   271: new 828	java/io/FileOutputStream
    //   274: dup
    //   275: aload 8
    //   277: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   280: astore_0
    //   281: aload 7
    //   283: getstatic 835	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   286: iload 4
    //   288: aload_0
    //   289: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   292: pop
    //   293: aload_0
    //   294: ifnull +7 -> 301
    //   297: aload_0
    //   298: invokevirtual 842	java/io/OutputStream:close	()V
    //   301: aload_1
    //   302: astore_0
    //   303: aload 8
    //   305: invokevirtual 663	java/io/File:exists	()Z
    //   308: ifeq +162 -> 470
    //   311: aload 8
    //   313: invokevirtual 844	java/io/File:length	()J
    //   316: aload 9
    //   318: invokevirtual 844	java/io/File:length	()J
    //   321: lcmp
    //   322: ifge +123 -> 445
    //   325: aload_2
    //   326: astore_0
    //   327: goto +143 -> 470
    //   330: astore_0
    //   331: aload_0
    //   332: invokevirtual 845	java/io/IOException:toString	()Ljava/lang/String;
    //   335: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   338: goto -37 -> 301
    //   341: astore_0
    //   342: aload_0
    //   343: invokevirtual 846	java/io/FileNotFoundException:printStackTrace	()V
    //   346: aconst_null
    //   347: astore_0
    //   348: goto +122 -> 470
    //   351: astore_0
    //   352: aconst_null
    //   353: astore_0
    //   354: aload_0
    //   355: ifnull -54 -> 301
    //   358: aload_0
    //   359: invokevirtual 842	java/io/OutputStream:close	()V
    //   362: goto -61 -> 301
    //   365: astore_0
    //   366: aload_0
    //   367: invokevirtual 845	java/io/IOException:toString	()Ljava/lang/String;
    //   370: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   373: goto -72 -> 301
    //   376: astore_0
    //   377: aload_0
    //   378: invokevirtual 847	java/io/IOException:printStackTrace	()V
    //   381: aconst_null
    //   382: astore_0
    //   383: goto +87 -> 470
    //   386: astore_1
    //   387: aconst_null
    //   388: astore_0
    //   389: aload_0
    //   390: ifnull +7 -> 397
    //   393: aload_0
    //   394: invokevirtual 842	java/io/OutputStream:close	()V
    //   397: aload_1
    //   398: athrow
    //   399: astore_0
    //   400: invokestatic 852	java/lang/System:gc	()V
    //   403: new 153	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 854
    //   413: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_0
    //   417: invokevirtual 855	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   420: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   429: aconst_null
    //   430: astore_0
    //   431: goto +39 -> 470
    //   434: astore_0
    //   435: aload_0
    //   436: invokevirtual 845	java/io/IOException:toString	()Ljava/lang/String;
    //   439: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   442: goto -45 -> 397
    //   445: aload 8
    //   447: invokevirtual 754	java/io/File:delete	()Z
    //   450: pop
    //   451: aload_1
    //   452: astore_0
    //   453: goto +17 -> 470
    //   456: astore_1
    //   457: goto -68 -> 389
    //   460: astore 7
    //   462: goto -108 -> 354
    //   465: goto -328 -> 137
    //   468: aconst_null
    //   469: areturn
    //   470: aload_0
    //   471: areturn
    //   472: astore_0
    //   473: aconst_null
    //   474: astore_0
    //   475: goto -311 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	paramContext	Context
    //   0	478	1	paramString1	String
    //   0	478	2	paramString2	String
    //   0	478	3	paramInt1	int
    //   0	478	4	paramInt2	int
    //   121	137	5	f1	float
    //   228	33	6	f2	float
    //   200	82	7	localObject	Object
    //   460	1	7	localException	Exception
    //   49	397	8	localFile1	File
    //   59	258	9	localFile2	File
    //   102	86	10	i1	int
    //   108	61	11	i2	int
    // Exception table:
    //   from	to	target	type
    //   297	301	330	java/io/IOException
    //   0	41	341	java/io/FileNotFoundException
    //   41	69	341	java/io/FileNotFoundException
    //   71	85	341	java/io/FileNotFoundException
    //   85	134	341	java/io/FileNotFoundException
    //   137	158	341	java/io/FileNotFoundException
    //   158	164	341	java/io/FileNotFoundException
    //   185	199	341	java/io/FileNotFoundException
    //   216	271	341	java/io/FileNotFoundException
    //   297	301	341	java/io/FileNotFoundException
    //   303	325	341	java/io/FileNotFoundException
    //   331	338	341	java/io/FileNotFoundException
    //   358	362	341	java/io/FileNotFoundException
    //   366	373	341	java/io/FileNotFoundException
    //   393	397	341	java/io/FileNotFoundException
    //   397	399	341	java/io/FileNotFoundException
    //   435	442	341	java/io/FileNotFoundException
    //   445	451	341	java/io/FileNotFoundException
    //   271	281	351	java/lang/Exception
    //   358	362	365	java/io/IOException
    //   0	41	376	java/io/IOException
    //   41	69	376	java/io/IOException
    //   71	85	376	java/io/IOException
    //   85	134	376	java/io/IOException
    //   137	158	376	java/io/IOException
    //   158	164	376	java/io/IOException
    //   185	199	376	java/io/IOException
    //   216	271	376	java/io/IOException
    //   303	325	376	java/io/IOException
    //   331	338	376	java/io/IOException
    //   366	373	376	java/io/IOException
    //   397	399	376	java/io/IOException
    //   435	442	376	java/io/IOException
    //   445	451	376	java/io/IOException
    //   271	281	386	finally
    //   0	41	399	java/lang/OutOfMemoryError
    //   41	69	399	java/lang/OutOfMemoryError
    //   71	85	399	java/lang/OutOfMemoryError
    //   85	134	399	java/lang/OutOfMemoryError
    //   137	158	399	java/lang/OutOfMemoryError
    //   185	199	399	java/lang/OutOfMemoryError
    //   216	271	399	java/lang/OutOfMemoryError
    //   297	301	399	java/lang/OutOfMemoryError
    //   303	325	399	java/lang/OutOfMemoryError
    //   331	338	399	java/lang/OutOfMemoryError
    //   358	362	399	java/lang/OutOfMemoryError
    //   366	373	399	java/lang/OutOfMemoryError
    //   393	397	399	java/lang/OutOfMemoryError
    //   397	399	399	java/lang/OutOfMemoryError
    //   435	442	399	java/lang/OutOfMemoryError
    //   445	451	399	java/lang/OutOfMemoryError
    //   393	397	434	java/io/IOException
    //   281	293	456	finally
    //   281	293	460	java/lang/Exception
    //   158	164	472	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 375	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload_3
    //   14: iload 4
    //   16: invokestatic 666	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   19: astore 7
    //   21: new 668	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 671	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: aload 7
    //   35: aload_2
    //   36: bipush 100
    //   38: iload 5
    //   40: invokestatic 180	java/lang/Math:min	(II)I
    //   43: invokestatic 859	com/tencent/mobileqq/utils/ImageUtil:b	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_1
    //   54: invokevirtual 456	java/io/InputStream:close	()V
    //   57: aload_2
    //   58: astore_0
    //   59: aload_0
    //   60: areturn
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 847	java/io/IOException:printStackTrace	()V
    //   66: aload_2
    //   67: astore_0
    //   68: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -12 -> 59
    //   74: ldc_w 861
    //   77: iconst_2
    //   78: aload_1
    //   79: invokevirtual 845	java/io/IOException:toString	()Ljava/lang/String;
    //   82: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_2
    //   86: areturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +16 -> 111
    //   98: aload_1
    //   99: astore_0
    //   100: ldc_w 861
    //   103: iconst_2
    //   104: ldc_w 863
    //   107: aload_2
    //   108: invokestatic 865	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload 6
    //   113: astore_0
    //   114: aload_1
    //   115: ifnull -56 -> 59
    //   118: aload_1
    //   119: invokevirtual 456	java/io/InputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 847	java/io/IOException:printStackTrace	()V
    //   129: aload 6
    //   131: astore_0
    //   132: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq -76 -> 59
    //   138: ldc_w 861
    //   141: iconst_2
    //   142: aload_1
    //   143: invokevirtual 845	java/io/IOException:toString	()Ljava/lang/String;
    //   146: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 456	java/io/InputStream:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 847	java/io/IOException:printStackTrace	()V
    //   169: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq -10 -> 162
    //   175: ldc_w 861
    //   178: iconst_2
    //   179: aload_0
    //   180: invokevirtual 845	java/io/IOException:toString	()Ljava/lang/String;
    //   183: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: goto -24 -> 162
    //   189: astore_1
    //   190: goto -36 -> 154
    //   193: astore_2
    //   194: goto -104 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramString1	String
    //   0	197	2	paramString2	String
    //   0	197	3	paramInt1	int
    //   0	197	4	paramInt2	int
    //   0	197	5	paramInt3	int
    //   1	129	6	localObject	Object
    //   19	15	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   53	57	61	java/io/IOException
    //   3	30	87	java/lang/Exception
    //   118	122	124	java/io/IOException
    //   3	30	151	finally
    //   158	162	164	java/io/IOException
    //   32	47	189	finally
    //   92	98	189	finally
    //   100	111	189	finally
    //   32	47	193	java/lang/Exception
  }
  
  public static String a(FileInputStream paramFileInputStream)
  {
    Object localObject = new byte[8];
    try
    {
      paramFileInputStream.read((byte[])localObject, 0, localObject.length);
      localObject = HexUtil.a((byte[])localObject).toUpperCase();
      if (((String)localObject).contains("FFD8FF"))
      {
        paramFileInputStream = "jpg";
        return paramFileInputStream;
      }
    }
    catch (IOException paramFileInputStream)
    {
      do
      {
        for (;;)
        {
          paramFileInputStream.printStackTrace();
        }
        if (((String)localObject).contains("89504E470D0A1A0A")) {
          return "png";
        }
        if (((String)localObject).contains("47494638")) {
          return "gif";
        }
        if (((String)localObject).contains("49492A00")) {
          return "tif";
        }
        if (((String)localObject).contains("424D")) {
          return "bmp";
        }
        if (((String)localObject).contains("0A")) {
          return "pcx";
        }
        if ((((String)localObject).contains("4D4D")) || (((String)localObject).contains("4949"))) {
          return "tiff";
        }
        if (((String)localObject).contains("464F524D")) {
          return "iff";
        }
        if (((String)localObject).contains("52494646")) {
          return "ani";
        }
        if (((String)localObject).contains("0000020000")) {
          return "tga";
        }
        if (((String)localObject).contains("0000100000")) {
          return "rle";
        }
        if (((String)localObject).contains("0000010001002020")) {
          return "ico";
        }
        paramFileInputStream = (FileInputStream)localObject;
      } while (!((String)localObject).contains("0000020001002020"));
    }
    return "cur";
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 338	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   4: putfield 674	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   7: aload_0
    //   8: aconst_null
    //   9: aload_1
    //   10: invokestatic 114	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_2
    //   23: invokestatic 938	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_3
    //   27: new 828	java/io/FileOutputStream
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_0
    //   36: aload 4
    //   38: getstatic 941	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   41: bipush 100
    //   43: aload_0
    //   44: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   47: pop
    //   48: aload_0
    //   49: ifnull +7 -> 56
    //   52: aload_0
    //   53: invokevirtual 842	java/io/OutputStream:close	()V
    //   56: aload 4
    //   58: ifnull +16 -> 74
    //   61: aload 4
    //   63: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   66: ifne +8 -> 74
    //   69: aload 4
    //   71: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   74: aload_2
    //   75: astore_0
    //   76: aload_2
    //   77: ifnonnull +25 -> 102
    //   80: aload_2
    //   81: astore_0
    //   82: aload_3
    //   83: ifnull +19 -> 102
    //   86: aload_2
    //   87: astore_0
    //   88: aload_3
    //   89: invokevirtual 663	java/io/File:exists	()Z
    //   92: ifeq +10 -> 102
    //   95: aload_3
    //   96: invokevirtual 754	java/io/File:delete	()Z
    //   99: pop
    //   100: aload_2
    //   101: astore_0
    //   102: aload_0
    //   103: areturn
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 842	java/io/OutputStream:close	()V
    //   115: aload 4
    //   117: ifnull +16 -> 133
    //   120: aload 4
    //   122: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   125: ifne +8 -> 133
    //   128: aload 4
    //   130: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   133: iconst_0
    //   134: ifne +157 -> 291
    //   137: aload_3
    //   138: ifnull +153 -> 291
    //   141: aload_3
    //   142: invokevirtual 663	java/io/File:exists	()Z
    //   145: ifeq +146 -> 291
    //   148: aload_3
    //   149: invokevirtual 754	java/io/File:delete	()Z
    //   152: pop
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -53 -> 102
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 842	java/io/OutputStream:close	()V
    //   169: aload 4
    //   171: ifnull +16 -> 187
    //   174: aload 4
    //   176: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   179: ifne +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   187: iconst_0
    //   188: ifne +103 -> 291
    //   191: aload_3
    //   192: ifnull +99 -> 291
    //   195: aload_3
    //   196: invokevirtual 663	java/io/File:exists	()Z
    //   199: ifeq +92 -> 291
    //   202: aload_3
    //   203: invokevirtual 754	java/io/File:delete	()Z
    //   206: pop
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -107 -> 102
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_0
    //   216: ifnull +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 842	java/io/OutputStream:close	()V
    //   223: aload 4
    //   225: ifnull +16 -> 241
    //   228: aload 4
    //   230: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   233: ifne +8 -> 241
    //   236: aload 4
    //   238: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   241: aload_2
    //   242: ifnonnull +19 -> 261
    //   245: aload_3
    //   246: ifnull +15 -> 261
    //   249: aload_3
    //   250: invokevirtual 663	java/io/File:exists	()Z
    //   253: ifeq +8 -> 261
    //   256: aload_3
    //   257: invokevirtual 754	java/io/File:delete	()Z
    //   260: pop
    //   261: aload_1
    //   262: athrow
    //   263: astore_0
    //   264: goto -208 -> 56
    //   267: astore_0
    //   268: goto -153 -> 115
    //   271: astore_0
    //   272: goto -103 -> 169
    //   275: astore_0
    //   276: goto -53 -> 223
    //   279: astore_1
    //   280: goto -65 -> 215
    //   283: astore_1
    //   284: goto -123 -> 161
    //   287: astore_1
    //   288: goto -181 -> 107
    //   291: aconst_null
    //   292: astore_0
    //   293: goto -191 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramInputStream	InputStream
    //   0	296	1	paramOptions	BitmapFactory.Options
    //   0	296	2	paramString	String
    //   26	231	3	localFile	File
    //   13	224	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   27	36	104	java/lang/Exception
    //   27	36	158	java/lang/OutOfMemoryError
    //   27	36	212	finally
    //   52	56	263	java/io/IOException
    //   111	115	267	java/io/IOException
    //   165	169	271	java/io/IOException
    //   219	223	275	java/io/IOException
    //   36	48	279	finally
    //   36	48	283	java/lang/OutOfMemoryError
    //   36	48	287	java/lang/Exception
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: getstatic 338	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   7: putfield 674	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   10: aload_0
    //   11: aconst_null
    //   12: aload_1
    //   13: invokestatic 114	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: aload_2
    //   24: invokestatic 938	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 367	android/graphics/Bitmap:getWidth	()I
    //   32: i2f
    //   33: fstore 4
    //   35: aload_1
    //   36: invokevirtual 460	android/graphics/Bitmap:getHeight	()I
    //   39: i2f
    //   40: fstore 5
    //   42: new 550	android/graphics/Matrix
    //   45: dup
    //   46: invokespecial 551	android/graphics/Matrix:<init>	()V
    //   49: astore 7
    //   51: aload 7
    //   53: iload_3
    //   54: i2f
    //   55: fload 4
    //   57: fconst_2
    //   58: fdiv
    //   59: fload 5
    //   61: fconst_2
    //   62: fdiv
    //   63: invokevirtual 826	android/graphics/Matrix:setRotate	(FFF)V
    //   66: aload_1
    //   67: iconst_0
    //   68: iconst_0
    //   69: fload 4
    //   71: f2i
    //   72: fload 5
    //   74: f2i
    //   75: aload 7
    //   77: iconst_1
    //   78: invokestatic 631	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   81: astore 7
    //   83: new 828	java/io/FileOutputStream
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: astore_1
    //   92: aload 7
    //   94: getstatic 941	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: bipush 100
    //   99: aload_1
    //   100: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   103: pop
    //   104: aload_2
    //   105: astore_0
    //   106: aload_1
    //   107: ifnull +9 -> 116
    //   110: aload_1
    //   111: invokevirtual 842	java/io/OutputStream:close	()V
    //   114: aload_2
    //   115: astore_0
    //   116: aload_0
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +50 -> 172
    //   125: aload_1
    //   126: invokevirtual 842	java/io/OutputStream:close	()V
    //   129: aconst_null
    //   130: astore_0
    //   131: goto -15 -> 116
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_0
    //   137: goto -21 -> 116
    //   140: astore_0
    //   141: aload 6
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 842	java/io/OutputStream:close	()V
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: aload_2
    //   156: astore_0
    //   157: goto -41 -> 116
    //   160: astore_1
    //   161: goto -9 -> 152
    //   164: astore_0
    //   165: goto -21 -> 144
    //   168: astore_0
    //   169: goto -48 -> 121
    //   172: aconst_null
    //   173: astore_0
    //   174: goto -58 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramInputStream	InputStream
    //   0	177	1	paramOptions	BitmapFactory.Options
    //   0	177	2	paramString	String
    //   0	177	3	paramInt	int
    //   33	37	4	f1	float
    //   40	33	5	f2	float
    //   1	141	6	localObject1	Object
    //   49	44	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   83	92	118	java/lang/Exception
    //   125	129	134	java/io/IOException
    //   83	92	140	finally
    //   110	114	154	java/io/IOException
    //   148	152	160	java/io/IOException
    //   92	104	164	finally
    //   92	104	168	java/lang/Exception
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString.substring(paramString.lastIndexOf("/") + 1);
    return AppConstants.bj + "photo/" + paramString.hashCode() + paramInt + str;
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 375	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload_2
    //   14: iload_3
    //   15: invokestatic 666	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   18: astore 6
    //   20: new 668	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 671	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: aload 6
    //   32: aload_1
    //   33: bipush 100
    //   35: iload 4
    //   37: invokestatic 180	java/lang/Math:min	(II)I
    //   40: invokestatic 859	com/tencent/mobileqq/utils/ImageUtil:b	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: astore 5
    //   47: aload 5
    //   49: astore_1
    //   50: aload_0
    //   51: ifnull +10 -> 61
    //   54: aload_0
    //   55: invokevirtual 456	java/io/InputStream:close	()V
    //   58: aload 5
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: aload 5
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull -9 -> 61
    //   73: aload_0
    //   74: invokevirtual 456	java/io/InputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_0
    //   85: aload 5
    //   87: astore_1
    //   88: aload_0
    //   89: ifnull -28 -> 61
    //   92: aload_0
    //   93: invokevirtual 456	java/io/InputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 456	java/io/InputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: astore_0
    //   115: aload 5
    //   117: areturn
    //   118: astore_0
    //   119: goto -7 -> 112
    //   122: astore_1
    //   123: goto -19 -> 104
    //   126: astore_1
    //   127: goto -42 -> 85
    //   130: astore_1
    //   131: goto -65 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString1	String
    //   0	134	1	paramString2	String
    //   0	134	2	paramInt1	int
    //   0	134	3	paramInt2	int
    //   0	134	4	paramInt3	int
    //   1	115	5	str	String
    //   18	13	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   3	29	63	java/lang/Exception
    //   73	77	79	java/io/IOException
    //   3	29	82	java/lang/Error
    //   92	96	98	java/io/IOException
    //   3	29	101	finally
    //   54	58	114	java/io/IOException
    //   108	112	118	java/io/IOException
    //   29	44	122	finally
    //   29	44	126	java/lang/Error
    //   29	44	130	java/lang/Exception
  }
  
  private static void a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean, String paramString)
  {
    a(paramInt1, paramInt2, paramContext, paramBoolean, null, paramString);
  }
  
  private static void a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 7) || (paramInt2 < 0) || (paramInt2 > 9)) {
      return;
    }
    String str2 = null;
    String str1 = str2;
    if (paramContext != null) {
      str1 = str2;
    }
    try
    {
      if ((paramContext instanceof BaseActivity)) {
        str1 = ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).a();
      }
      localHashMap = new HashMap();
      if (paramBoolean) {
        break label231;
      }
      String str3 = String.valueOf(paramInt2 * 10 + paramInt1 + 88100);
      localHashMap.put("param_FailCode", str3);
      str2 = paramString2;
      if (paramString2 == null) {
        str2 = AbstractImageDownloader.a(new RuntimeException(str3));
      }
      if (!(paramContext instanceof Activity)) {
        break label213;
      }
      paramContext = ((Activity)paramContext).getCallingActivity();
      if (paramContext == null) {
        break label213;
      }
      localHashMap.put("param_callingActivity", paramContext.getClassName());
    }
    catch (Exception paramContext)
    {
      HashMap localHashMap;
      return;
    }
    localHashMap.put("param_sdCardSize", Long.toString(Utils.b()));
    label170:
    localHashMap.put("param_failMsg", str2);
    for (;;)
    {
      label184:
      StatisticCollector.a(BaseApplication.getContext()).a(str1, paramContext, paramBoolean, 0L, 0L, localHashMap, "");
      return;
      label213:
      label231:
      do
      {
        paramContext = paramString1;
        break label184;
        if ((paramInt2 == 9) || (paramInt2 == 0)) {
          break;
        }
        if (paramInt2 != 5) {
          break label170;
        }
        break;
      } while (paramString1 != null);
      paramContext = "report_sendphoto_file_error";
    }
  }
  
  /* Error */
  private static void a(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc_w 1008
    //   5: new 153	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 1010
    //   15: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload 7
    //   20: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 1012
    //   26: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   40: iload 8
    //   42: ifeq +103 -> 145
    //   45: aload_1
    //   46: invokestatic 802	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)Z
    //   49: ifeq +89 -> 138
    //   52: bipush 80
    //   54: istore 6
    //   56: iconst_0
    //   57: istore 7
    //   59: aload 4
    //   61: getfield 425	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   64: ifne +8 -> 72
    //   67: sipush 960
    //   70: istore 7
    //   72: aconst_null
    //   73: astore 11
    //   75: aconst_null
    //   76: astore 10
    //   78: iload_0
    //   79: aload_1
    //   80: aload_2
    //   81: iload 7
    //   83: aload 4
    //   85: invokestatic 1017	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;ILcom/tencent/mobileqq/activity/photo/ImageInfo;)Landroid/graphics/Bitmap;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnonnull +62 -> 152
    //   93: aload 4
    //   95: iconst_0
    //   96: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   99: aload_3
    //   100: invokevirtual 754	java/io/File:delete	()Z
    //   103: pop
    //   104: ldc_w 1021
    //   107: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   110: iconst_0
    //   111: ifeq +11 -> 122
    //   114: new 677	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 678	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: aload_1
    //   123: ifnull +14 -> 137
    //   126: aload_1
    //   127: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   130: ifne +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   137: return
    //   138: bipush 70
    //   140: istore 6
    //   142: goto -86 -> 56
    //   145: bipush 80
    //   147: istore 6
    //   149: goto -93 -> 56
    //   152: aload 4
    //   154: iconst_1
    //   155: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   158: iload 9
    //   160: ifne +102 -> 262
    //   163: aload_1
    //   164: invokevirtual 367	android/graphics/Bitmap:getWidth	()I
    //   167: istore_0
    //   168: aload_1
    //   169: invokevirtual 460	android/graphics/Bitmap:getHeight	()I
    //   172: istore 19
    //   174: iload_0
    //   175: iload 7
    //   177: if_icmpgt +13 -> 190
    //   180: aload_1
    //   181: astore 10
    //   183: iload 19
    //   185: iload 7
    //   187: if_icmple +11 -> 198
    //   190: aload_1
    //   191: iload 7
    //   193: invokestatic 1023	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   196: astore 10
    //   198: aload 10
    //   200: astore_1
    //   201: aload_1
    //   202: ifnonnull +73 -> 275
    //   205: aload_1
    //   206: astore 10
    //   208: aload_1
    //   209: astore 11
    //   211: aload 4
    //   213: ldc_w 1008
    //   216: ldc_w 1025
    //   219: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: astore 10
    //   225: aload_1
    //   226: astore 11
    //   228: aload 4
    //   230: iconst_1
    //   231: putfield 1027	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   234: iconst_0
    //   235: ifeq +11 -> 246
    //   238: new 677	java/lang/NullPointerException
    //   241: dup
    //   242: invokespecial 678	java/lang/NullPointerException:<init>	()V
    //   245: athrow
    //   246: aload_1
    //   247: ifnull -110 -> 137
    //   250: aload_1
    //   251: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   254: ifne -117 -> 137
    //   257: aload_1
    //   258: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   261: return
    //   262: aload_1
    //   263: aload_2
    //   264: invokestatic 1029	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Landroid/graphics/Bitmap;
    //   267: astore 10
    //   269: aload 10
    //   271: astore_1
    //   272: goto -71 -> 201
    //   275: new 828	java/io/FileOutputStream
    //   278: dup
    //   279: aload_3
    //   280: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   283: astore 13
    //   285: aload 13
    //   287: astore 10
    //   289: aload 4
    //   291: aload_1
    //   292: getstatic 835	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   295: iload 6
    //   297: aload 13
    //   299: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   302: putfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   305: aload 13
    //   307: astore 10
    //   309: aload 4
    //   311: iconst_1
    //   312: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   315: aload 13
    //   317: astore 10
    //   319: aload 4
    //   321: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   324: ifeq +12 -> 336
    //   327: aload 13
    //   329: astore 10
    //   331: aload 13
    //   333: invokestatic 1036	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   336: aload 13
    //   338: astore 10
    //   340: new 153	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 1038
    //   350: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 4
    //   355: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   358: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   361: ldc_w 1043
    //   364: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_3
    //   368: invokevirtual 844	java/io/File:length	()J
    //   371: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   380: aload 13
    //   382: astore 10
    //   384: aload 13
    //   386: ifnull +26 -> 412
    //   389: aload 13
    //   391: astore 12
    //   393: aload_1
    //   394: astore 18
    //   396: aload 13
    //   398: astore 11
    //   400: aload_1
    //   401: astore 15
    //   403: aload 13
    //   405: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   408: aload 13
    //   410: astore 10
    //   412: iload 5
    //   414: iconst_1
    //   415: if_icmpeq +26 -> 441
    //   418: iload 5
    //   420: sipush 1001
    //   423: if_icmpeq +18 -> 441
    //   426: aload 10
    //   428: astore 16
    //   430: aload_1
    //   431: astore 17
    //   433: iload 5
    //   435: sipush 3000
    //   438: if_icmpne +821 -> 1259
    //   441: iload 5
    //   443: sipush 1001
    //   446: if_icmpne +574 -> 1020
    //   449: aload 10
    //   451: astore 12
    //   453: aload_1
    //   454: astore 18
    //   456: aload 10
    //   458: astore 11
    //   460: aload_1
    //   461: astore 15
    //   463: getstatic 1047	com/tencent/common/config/AppSetting:d	I
    //   466: i2l
    //   467: lstore 20
    //   469: lload 20
    //   471: l2i
    //   472: istore 19
    //   474: aload 10
    //   476: astore 12
    //   478: aload_1
    //   479: astore 18
    //   481: aload 10
    //   483: astore 11
    //   485: aload_1
    //   486: astore 15
    //   488: new 153	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 1049
    //   498: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: iload 19
    //   503: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   512: aload 10
    //   514: astore 12
    //   516: aload_1
    //   517: astore 18
    //   519: aload 10
    //   521: astore 11
    //   523: aload_1
    //   524: astore 15
    //   526: new 153	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 1051
    //   536: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload_3
    //   540: invokevirtual 844	java/io/File:length	()J
    //   543: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   546: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   552: aload 10
    //   554: astore 14
    //   556: aload_1
    //   557: astore 13
    //   559: aload_3
    //   560: invokevirtual 844	java/io/File:length	()J
    //   563: iload 19
    //   565: i2l
    //   566: lcmp
    //   567: ifle +592 -> 1159
    //   570: aload 10
    //   572: astore 14
    //   574: aload_1
    //   575: astore 13
    //   577: aload_2
    //   578: invokestatic 1057	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   581: ifne +578 -> 1159
    //   584: aload 4
    //   586: ldc_w 1008
    //   589: ldc_w 1059
    //   592: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload 10
    //   597: astore 14
    //   599: aload_1
    //   600: astore 13
    //   602: aload_3
    //   603: invokevirtual 754	java/io/File:delete	()Z
    //   606: ifeq +553 -> 1159
    //   609: aload_3
    //   610: invokevirtual 751	java/io/File:createNewFile	()Z
    //   613: istore 8
    //   615: aload 10
    //   617: astore 14
    //   619: aload_1
    //   620: astore 13
    //   622: iload 8
    //   624: ifeq +535 -> 1159
    //   627: iconst_1
    //   628: istore 5
    //   630: iload 7
    //   632: istore_0
    //   633: iload 5
    //   635: iconst_1
    //   636: iadd
    //   637: istore 7
    //   639: iload 5
    //   641: iconst_4
    //   642: if_icmpge +487 -> 1129
    //   645: aload_1
    //   646: astore 11
    //   648: aload_1
    //   649: astore 12
    //   651: aload_3
    //   652: invokevirtual 844	java/io/File:length	()J
    //   655: iload 19
    //   657: i2l
    //   658: lcmp
    //   659: ifle +470 -> 1129
    //   662: aload_1
    //   663: astore 11
    //   665: aload_1
    //   666: astore 12
    //   668: new 153	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 1061
    //   678: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: iload 7
    //   683: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   686: ldc_w 1063
    //   689: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_3
    //   693: invokevirtual 844	java/io/File:length	()J
    //   696: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   699: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   705: iload_0
    //   706: iconst_1
    //   707: ishr
    //   708: istore_0
    //   709: iload_0
    //   710: ifne +1040 -> 1750
    //   713: iconst_1
    //   714: istore_0
    //   715: aload_1
    //   716: astore 11
    //   718: aload_1
    //   719: astore 12
    //   721: aload_1
    //   722: iload_0
    //   723: invokestatic 1023	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   726: astore_1
    //   727: aload_1
    //   728: ifnonnull +349 -> 1077
    //   731: aload_1
    //   732: astore 11
    //   734: aload_1
    //   735: astore 12
    //   737: aload 4
    //   739: iconst_1
    //   740: putfield 1027	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   743: aload 10
    //   745: ifnull +21 -> 766
    //   748: aload_1
    //   749: astore_3
    //   750: aload 10
    //   752: astore 12
    //   754: aload_1
    //   755: astore 13
    //   757: aload 10
    //   759: astore 11
    //   761: aload 10
    //   763: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   766: aload_1
    //   767: ifnull +40 -> 807
    //   770: aload_1
    //   771: astore_3
    //   772: aload 10
    //   774: astore 12
    //   776: aload_1
    //   777: astore 13
    //   779: aload 10
    //   781: astore 11
    //   783: aload_1
    //   784: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   787: ifne +20 -> 807
    //   790: aload_1
    //   791: astore_3
    //   792: aload 10
    //   794: astore 12
    //   796: aload_1
    //   797: astore 13
    //   799: aload 10
    //   801: astore 11
    //   803: aload_1
    //   804: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   807: aload 10
    //   809: ifnull +8 -> 817
    //   812: aload 10
    //   814: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   817: aload_1
    //   818: ifnull -681 -> 137
    //   821: aload_1
    //   822: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   825: ifne -688 -> 137
    //   828: aload_1
    //   829: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   832: return
    //   833: astore 10
    //   835: aconst_null
    //   836: astore 13
    //   838: aload 13
    //   840: astore 10
    //   842: aload 4
    //   844: iconst_0
    //   845: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   848: aload 13
    //   850: astore 10
    //   852: aload 4
    //   854: invokestatic 1065	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   857: putfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   860: aload 13
    //   862: astore 10
    //   864: ldc_w 1069
    //   867: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   870: aload 13
    //   872: astore 10
    //   874: aload 13
    //   876: ifnull -464 -> 412
    //   879: aload 13
    //   881: astore 12
    //   883: aload_1
    //   884: astore 18
    //   886: aload 13
    //   888: astore 11
    //   890: aload_1
    //   891: astore 15
    //   893: aload 13
    //   895: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   898: aload 13
    //   900: astore 10
    //   902: goto -490 -> 412
    //   905: astore 10
    //   907: aload 13
    //   909: astore 10
    //   911: goto -499 -> 412
    //   914: astore_3
    //   915: aconst_null
    //   916: astore_2
    //   917: aload_2
    //   918: ifnull +19 -> 937
    //   921: aload_2
    //   922: astore 12
    //   924: aload_1
    //   925: astore 18
    //   927: aload_2
    //   928: astore 11
    //   930: aload_1
    //   931: astore 15
    //   933: aload_2
    //   934: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   937: aload_2
    //   938: astore 12
    //   940: aload_1
    //   941: astore 18
    //   943: aload_2
    //   944: astore 11
    //   946: aload_1
    //   947: astore 15
    //   949: aload_3
    //   950: athrow
    //   951: astore_1
    //   952: aload 18
    //   954: astore_1
    //   955: aload 12
    //   957: astore 11
    //   959: aload_1
    //   960: astore 15
    //   962: aload 4
    //   964: iconst_0
    //   965: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   968: aload 12
    //   970: astore 11
    //   972: aload_1
    //   973: astore 15
    //   975: aload 4
    //   977: iconst_1
    //   978: putfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   981: aload 12
    //   983: astore 11
    //   985: aload_1
    //   986: astore 15
    //   988: ldc_w 1071
    //   991: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   994: aload 12
    //   996: ifnull +8 -> 1004
    //   999: aload 12
    //   1001: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   1004: aload_1
    //   1005: ifnull -868 -> 137
    //   1008: aload_1
    //   1009: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   1012: ifne -875 -> 137
    //   1015: aload_1
    //   1016: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   1019: return
    //   1020: ldc2_w 1072
    //   1023: lstore 20
    //   1025: goto -556 -> 469
    //   1028: astore_2
    //   1029: aload_1
    //   1030: astore_3
    //   1031: aload 10
    //   1033: astore 12
    //   1035: aload_1
    //   1036: astore 13
    //   1038: aload 10
    //   1040: astore 11
    //   1042: new 153	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1049: ldc_w 1075
    //   1052: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload_2
    //   1056: invokevirtual 1076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1059: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1065: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1068: goto -302 -> 766
    //   1071: astore_1
    //   1072: aload_3
    //   1073: astore_1
    //   1074: goto -119 -> 955
    //   1077: aload_1
    //   1078: astore 11
    //   1080: aload_1
    //   1081: astore 12
    //   1083: new 828	java/io/FileOutputStream
    //   1086: dup
    //   1087: aload_3
    //   1088: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1091: astore_2
    //   1092: aload 4
    //   1094: aload_1
    //   1095: getstatic 835	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1098: iload 6
    //   1100: aload_2
    //   1101: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1104: putfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1107: aload 4
    //   1109: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1112: ifeq +628 -> 1740
    //   1115: aload_2
    //   1116: invokestatic 1036	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   1119: iload 7
    //   1121: istore 5
    //   1123: aload_2
    //   1124: astore 10
    //   1126: goto -493 -> 633
    //   1129: iload 7
    //   1131: iconst_4
    //   1132: if_icmplt +20 -> 1152
    //   1135: aload_1
    //   1136: astore 11
    //   1138: aload_1
    //   1139: astore 12
    //   1141: aload 4
    //   1143: ldc_w 1008
    //   1146: ldc_w 1078
    //   1149: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1152: aload_1
    //   1153: astore 13
    //   1155: aload 10
    //   1157: astore 14
    //   1159: aload 14
    //   1161: ifnull +24 -> 1185
    //   1164: aload 14
    //   1166: astore 12
    //   1168: aload 13
    //   1170: astore 18
    //   1172: aload 14
    //   1174: astore 11
    //   1176: aload 13
    //   1178: astore 15
    //   1180: aload 14
    //   1182: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   1185: aload 14
    //   1187: astore 16
    //   1189: aload 13
    //   1191: astore 17
    //   1193: aload 13
    //   1195: ifnull +64 -> 1259
    //   1198: aload 14
    //   1200: astore 12
    //   1202: aload 13
    //   1204: astore 18
    //   1206: aload 14
    //   1208: astore 16
    //   1210: aload 13
    //   1212: astore 17
    //   1214: aload 14
    //   1216: astore 11
    //   1218: aload 13
    //   1220: astore 15
    //   1222: aload 13
    //   1224: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   1227: ifne +32 -> 1259
    //   1230: aload 14
    //   1232: astore 12
    //   1234: aload 13
    //   1236: astore 18
    //   1238: aload 14
    //   1240: astore 11
    //   1242: aload 13
    //   1244: astore 15
    //   1246: aload 13
    //   1248: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   1251: aload 13
    //   1253: astore 17
    //   1255: aload 14
    //   1257: astore 16
    //   1259: aload 16
    //   1261: ifnull +8 -> 1269
    //   1264: aload 16
    //   1266: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   1269: aload 17
    //   1271: ifnull -1134 -> 137
    //   1274: aload 17
    //   1276: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   1279: ifne -1142 -> 137
    //   1282: aload 17
    //   1284: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   1287: return
    //   1288: astore_1
    //   1289: aload 14
    //   1291: astore 12
    //   1293: aload 13
    //   1295: astore 18
    //   1297: aload 14
    //   1299: astore 11
    //   1301: aload 13
    //   1303: astore 15
    //   1305: new 153	java/lang/StringBuilder
    //   1308: dup
    //   1309: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1312: ldc_w 1075
    //   1315: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: aload_1
    //   1319: invokevirtual 1076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1322: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1328: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1331: goto -146 -> 1185
    //   1334: astore_1
    //   1335: aload 15
    //   1337: astore_2
    //   1338: aload 11
    //   1340: ifnull +8 -> 1348
    //   1343: aload 11
    //   1345: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   1348: aload_2
    //   1349: ifnull +14 -> 1363
    //   1352: aload_2
    //   1353: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   1356: ifne +7 -> 1363
    //   1359: aload_2
    //   1360: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   1363: aload_1
    //   1364: athrow
    //   1365: astore_2
    //   1366: aload_1
    //   1367: astore_2
    //   1368: aload 10
    //   1370: astore_1
    //   1371: aload 4
    //   1373: iconst_0
    //   1374: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1377: aload 4
    //   1379: invokestatic 1065	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   1382: putfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1385: ldc_w 1080
    //   1388: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1391: aload_1
    //   1392: ifnull +7 -> 1399
    //   1395: aload_1
    //   1396: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   1399: aload_2
    //   1400: ifnull +331 -> 1731
    //   1403: aload_2
    //   1404: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   1407: ifne +324 -> 1731
    //   1410: aload_2
    //   1411: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   1414: aload_1
    //   1415: astore 16
    //   1417: aload_2
    //   1418: astore 17
    //   1420: goto -161 -> 1259
    //   1423: astore_3
    //   1424: new 153	java/lang/StringBuilder
    //   1427: dup
    //   1428: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1431: ldc_w 1075
    //   1434: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload_3
    //   1438: invokevirtual 1076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1441: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1450: goto -51 -> 1399
    //   1453: astore_3
    //   1454: aload_1
    //   1455: astore 12
    //   1457: aload_2
    //   1458: astore_1
    //   1459: goto -504 -> 955
    //   1462: astore_2
    //   1463: aload 10
    //   1465: ifnull +21 -> 1486
    //   1468: aload_1
    //   1469: astore_3
    //   1470: aload 10
    //   1472: astore 12
    //   1474: aload_1
    //   1475: astore 13
    //   1477: aload 10
    //   1479: astore 11
    //   1481: aload 10
    //   1483: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   1486: aload_1
    //   1487: ifnull +40 -> 1527
    //   1490: aload_1
    //   1491: astore_3
    //   1492: aload 10
    //   1494: astore 12
    //   1496: aload_1
    //   1497: astore 13
    //   1499: aload 10
    //   1501: astore 11
    //   1503: aload_1
    //   1504: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   1507: ifne +20 -> 1527
    //   1510: aload_1
    //   1511: astore_3
    //   1512: aload 10
    //   1514: astore 12
    //   1516: aload_1
    //   1517: astore 13
    //   1519: aload 10
    //   1521: astore 11
    //   1523: aload_1
    //   1524: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   1527: aload_1
    //   1528: astore_3
    //   1529: aload 10
    //   1531: astore 12
    //   1533: aload_1
    //   1534: astore 13
    //   1536: aload 10
    //   1538: astore 11
    //   1540: aload_2
    //   1541: athrow
    //   1542: astore 14
    //   1544: aload_1
    //   1545: astore_3
    //   1546: aload 10
    //   1548: astore 12
    //   1550: aload_1
    //   1551: astore 13
    //   1553: aload 10
    //   1555: astore 11
    //   1557: new 153	java/lang/StringBuilder
    //   1560: dup
    //   1561: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1564: ldc_w 1075
    //   1567: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: aload 14
    //   1572: invokevirtual 1076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1575: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1581: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1584: goto -98 -> 1486
    //   1587: astore_2
    //   1588: goto -1466 -> 122
    //   1591: astore_2
    //   1592: goto -1346 -> 246
    //   1595: astore 10
    //   1597: aload 13
    //   1599: astore 10
    //   1601: goto -1189 -> 412
    //   1604: astore 10
    //   1606: goto -669 -> 937
    //   1609: astore_2
    //   1610: goto -793 -> 817
    //   1613: astore_1
    //   1614: goto -345 -> 1269
    //   1617: astore_2
    //   1618: goto -614 -> 1004
    //   1621: astore_3
    //   1622: goto -274 -> 1348
    //   1625: astore_1
    //   1626: aconst_null
    //   1627: astore 11
    //   1629: aload 10
    //   1631: astore_2
    //   1632: goto -294 -> 1338
    //   1635: astore_3
    //   1636: aload_1
    //   1637: astore_2
    //   1638: aconst_null
    //   1639: astore 11
    //   1641: aload_3
    //   1642: astore_1
    //   1643: goto -305 -> 1338
    //   1646: astore_3
    //   1647: aload_1
    //   1648: astore 11
    //   1650: aload_3
    //   1651: astore_1
    //   1652: goto -314 -> 1338
    //   1655: astore_1
    //   1656: aconst_null
    //   1657: astore 12
    //   1659: aload 11
    //   1661: astore_1
    //   1662: goto -707 -> 955
    //   1665: astore_2
    //   1666: aconst_null
    //   1667: astore 12
    //   1669: goto -714 -> 955
    //   1672: astore_2
    //   1673: aload 11
    //   1675: astore_1
    //   1676: goto -213 -> 1463
    //   1679: astore_3
    //   1680: aload_2
    //   1681: astore 10
    //   1683: aload_3
    //   1684: astore_2
    //   1685: goto -222 -> 1463
    //   1688: astore_3
    //   1689: aload_1
    //   1690: astore 10
    //   1692: aload_2
    //   1693: astore_1
    //   1694: aload_3
    //   1695: astore_2
    //   1696: goto -233 -> 1463
    //   1699: astore_1
    //   1700: aload 12
    //   1702: astore_2
    //   1703: aload 10
    //   1705: astore_1
    //   1706: goto -335 -> 1371
    //   1709: astore_3
    //   1710: aload_2
    //   1711: astore_3
    //   1712: aload_1
    //   1713: astore_2
    //   1714: aload_3
    //   1715: astore_1
    //   1716: goto -345 -> 1371
    //   1719: astore_3
    //   1720: aload 10
    //   1722: astore_2
    //   1723: goto -806 -> 917
    //   1726: astore 10
    //   1728: goto -890 -> 838
    //   1731: aload_1
    //   1732: astore 16
    //   1734: aload_2
    //   1735: astore 17
    //   1737: goto -478 -> 1259
    //   1740: iload 7
    //   1742: istore 5
    //   1744: aload_2
    //   1745: astore 10
    //   1747: goto -1114 -> 633
    //   1750: goto -1035 -> 715
    //   1753: astore_1
    //   1754: aload 13
    //   1756: astore_2
    //   1757: goto -419 -> 1338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1760	0	paramInt1	int
    //   0	1760	1	paramContext	Context
    //   0	1760	2	paramFile1	File
    //   0	1760	3	paramFile2	File
    //   0	1760	4	paramImageInfo	ImageInfo
    //   0	1760	5	paramInt2	int
    //   0	1760	6	paramInt3	int
    //   0	1760	7	paramInt4	int
    //   0	1760	8	paramBoolean1	boolean
    //   0	1760	9	paramBoolean2	boolean
    //   76	737	10	localObject1	Object
    //   833	1	10	localIOException1	IOException
    //   840	61	10	localObject2	Object
    //   905	1	10	localIOException2	IOException
    //   909	645	10	localObject3	Object
    //   1595	1	10	localIOException3	IOException
    //   1599	1	10	localObject4	Object
    //   1604	26	10	localIOException4	IOException
    //   1681	40	10	localObject5	Object
    //   1726	1	10	localIOException5	IOException
    //   1745	1	10	localFile	File
    //   73	1601	11	localObject6	Object
    //   391	1310	12	localObject7	Object
    //   283	1472	13	localObject8	Object
    //   554	744	14	localObject9	Object
    //   1542	29	14	localIOException6	IOException
    //   401	935	15	localObject10	Object
    //   428	1305	16	localObject11	Object
    //   431	1305	17	localObject12	Object
    //   394	902	18	localObject13	Object
    //   172	484	19	i1	int
    //   467	557	20	l1	long
    // Exception table:
    //   from	to	target	type
    //   275	285	833	java/io/IOException
    //   893	898	905	java/io/IOException
    //   275	285	914	finally
    //   403	408	951	java/lang/OutOfMemoryError
    //   463	469	951	java/lang/OutOfMemoryError
    //   488	512	951	java/lang/OutOfMemoryError
    //   526	552	951	java/lang/OutOfMemoryError
    //   893	898	951	java/lang/OutOfMemoryError
    //   933	937	951	java/lang/OutOfMemoryError
    //   949	951	951	java/lang/OutOfMemoryError
    //   1180	1185	951	java/lang/OutOfMemoryError
    //   1222	1230	951	java/lang/OutOfMemoryError
    //   1246	1251	951	java/lang/OutOfMemoryError
    //   1305	1331	951	java/lang/OutOfMemoryError
    //   761	766	1028	java/io/IOException
    //   761	766	1071	java/lang/OutOfMemoryError
    //   783	790	1071	java/lang/OutOfMemoryError
    //   803	807	1071	java/lang/OutOfMemoryError
    //   1042	1068	1071	java/lang/OutOfMemoryError
    //   1481	1486	1071	java/lang/OutOfMemoryError
    //   1503	1510	1071	java/lang/OutOfMemoryError
    //   1523	1527	1071	java/lang/OutOfMemoryError
    //   1540	1542	1071	java/lang/OutOfMemoryError
    //   1557	1584	1071	java/lang/OutOfMemoryError
    //   1180	1185	1288	java/io/IOException
    //   403	408	1334	finally
    //   463	469	1334	finally
    //   488	512	1334	finally
    //   526	552	1334	finally
    //   893	898	1334	finally
    //   933	937	1334	finally
    //   949	951	1334	finally
    //   962	968	1334	finally
    //   975	981	1334	finally
    //   988	994	1334	finally
    //   1180	1185	1334	finally
    //   1222	1230	1334	finally
    //   1246	1251	1334	finally
    //   1305	1331	1334	finally
    //   559	570	1365	java/io/IOException
    //   577	595	1365	java/io/IOException
    //   602	615	1365	java/io/IOException
    //   1395	1399	1423	java/io/IOException
    //   1395	1399	1453	java/lang/OutOfMemoryError
    //   1403	1414	1453	java/lang/OutOfMemoryError
    //   1424	1450	1453	java/lang/OutOfMemoryError
    //   559	570	1462	finally
    //   577	595	1462	finally
    //   602	615	1462	finally
    //   1481	1486	1542	java/io/IOException
    //   114	122	1587	java/io/IOException
    //   238	246	1591	java/io/IOException
    //   403	408	1595	java/io/IOException
    //   933	937	1604	java/io/IOException
    //   812	817	1609	java/io/IOException
    //   1264	1269	1613	java/io/IOException
    //   999	1004	1617	java/io/IOException
    //   1343	1348	1621	java/io/IOException
    //   78	89	1625	finally
    //   211	222	1625	finally
    //   228	234	1625	finally
    //   93	110	1635	finally
    //   152	158	1635	finally
    //   163	174	1635	finally
    //   190	198	1635	finally
    //   262	269	1635	finally
    //   1395	1399	1646	finally
    //   1403	1414	1646	finally
    //   1424	1450	1646	finally
    //   78	89	1655	java/lang/OutOfMemoryError
    //   211	222	1655	java/lang/OutOfMemoryError
    //   228	234	1655	java/lang/OutOfMemoryError
    //   93	110	1665	java/lang/OutOfMemoryError
    //   152	158	1665	java/lang/OutOfMemoryError
    //   163	174	1665	java/lang/OutOfMemoryError
    //   190	198	1665	java/lang/OutOfMemoryError
    //   262	269	1665	java/lang/OutOfMemoryError
    //   651	662	1672	finally
    //   668	705	1672	finally
    //   721	727	1672	finally
    //   737	743	1672	finally
    //   1083	1092	1672	finally
    //   1141	1152	1672	finally
    //   1092	1119	1679	finally
    //   1371	1391	1688	finally
    //   651	662	1699	java/io/IOException
    //   668	705	1699	java/io/IOException
    //   721	727	1699	java/io/IOException
    //   737	743	1699	java/io/IOException
    //   1083	1092	1699	java/io/IOException
    //   1141	1152	1699	java/io/IOException
    //   1092	1119	1709	java/io/IOException
    //   289	305	1719	finally
    //   309	315	1719	finally
    //   319	327	1719	finally
    //   331	336	1719	finally
    //   340	380	1719	finally
    //   842	848	1719	finally
    //   852	860	1719	finally
    //   864	870	1719	finally
    //   289	305	1726	java/io/IOException
    //   309	315	1726	java/io/IOException
    //   319	327	1726	java/io/IOException
    //   331	336	1726	java/io/IOException
    //   340	380	1726	java/io/IOException
    //   761	766	1753	finally
    //   783	790	1753	finally
    //   803	807	1753	finally
    //   1042	1068	1753	finally
    //   1481	1486	1753	finally
    //   1503	1510	1753	finally
    //   1523	1527	1753	finally
    //   1540	1542	1753	finally
    //   1557	1584	1753	finally
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    RichMediaUtil.b(paramInt1, paramBoolean, paramInt2, String.valueOf(paramLong), paramString1, paramString2);
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramLong, paramInt, 1, paramBoolean, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.fromFile(new File(paramString)));
    paramContext.sendBroadcast(localIntent);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 375	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iload_3
    //   11: iload 4
    //   13: invokestatic 666	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   16: astore 5
    //   18: new 668	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 671	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_1
    //   30: aload 5
    //   32: aload_2
    //   33: invokestatic 1116	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;)Ljava/lang/String;
    //   36: pop
    //   37: aload_1
    //   38: ifnull +7 -> 45
    //   41: aload_1
    //   42: invokevirtual 456	java/io/InputStream:close	()V
    //   45: return
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: astore_0
    //   51: new 153	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 1118
    //   61: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 641	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   77: aload_1
    //   78: ifnull -33 -> 45
    //   81: aload_1
    //   82: invokevirtual 456	java/io/InputStream:close	()V
    //   85: return
    //   86: astore_0
    //   87: return
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 456	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: return
    //   103: astore_0
    //   104: goto -5 -> 99
    //   107: astore_1
    //   108: goto -17 -> 91
    //   111: astore_2
    //   112: goto -63 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   0	115	3	paramInt1	int
    //   0	115	4	paramInt2	int
    //   16	15	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   0	27	46	java/lang/Exception
    //   81	85	86	java/io/IOException
    //   0	27	88	finally
    //   41	45	101	java/io/IOException
    //   95	99	103	java/io/IOException
    //   29	37	107	finally
    //   51	77	107	finally
    //   29	37	111	java/lang/Exception
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 375	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload 4
    //   15: iload 5
    //   17: invokestatic 666	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   20: astore_1
    //   21: new 668	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 671	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: iload_3
    //   34: invokestatic 1121	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   37: pop
    //   38: aload_0
    //   39: ifnull +7 -> 46
    //   42: aload_0
    //   43: invokevirtual 456	java/io/InputStream:close	()V
    //   46: return
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull -5 -> 46
    //   54: aload_0
    //   55: invokevirtual 456	java/io/InputStream:close	()V
    //   58: return
    //   59: astore_0
    //   60: return
    //   61: astore_0
    //   62: aload 6
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 456	java/io/InputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: astore_0
    //   76: return
    //   77: astore_1
    //   78: goto -5 -> 73
    //   81: astore_2
    //   82: aload_0
    //   83: astore_1
    //   84: aload_2
    //   85: astore_0
    //   86: goto -21 -> 65
    //   89: astore_1
    //   90: goto -40 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramContext	Context
    //   0	93	1	paramString1	String
    //   0	93	2	paramString2	String
    //   0	93	3	paramInt1	int
    //   0	93	4	paramInt2	int
    //   0	93	5	paramInt3	int
    //   1	62	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	30	47	java/lang/Exception
    //   54	58	59	java/io/IOException
    //   3	30	61	finally
    //   42	46	75	java/io/IOException
    //   69	73	77	java/io/IOException
    //   30	38	81	finally
    //   30	38	89	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ImageInfo paramImageInfo, int paramInt)
  {
    a(-1, paramContext, paramString1, paramString2, paramBoolean, paramImageInfo, paramInt);
  }
  
  public static void a(Context paramContext, List paramList, int paramInt)
  {
    if ((paramContext == null) || (paramList == null)) {}
    int i1;
    label19:
    ImageInfo localImageInfo;
    do
    {
      return;
      paramList = paramList.iterator();
      i1 = 0;
      if (!paramList.hasNext()) {
        break;
      }
      localImageInfo = (ImageInfo)paramList.next();
    } while ((localImageInfo == null) || (localImageInfo.b == null));
    File localFile = new File(localImageInfo.b);
    long l1;
    switch (paramInt)
    {
    default: 
      l1 = 19922944L;
      label109:
      if ((localFile.length() > l1) && (!localImageInfo.q)) {
        i1 = 1;
      }
      break;
    }
    for (;;)
    {
      break label19;
      l1 = 19922944L;
      break label109;
      l1 = 19922944L;
      break label109;
      if ((paramContext != null) && ((paramContext instanceof BaseActivity)))
      {
        if (((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).b(localImageInfo.c)) {}
        l1 = 19922944L;
        break label109;
      }
      l1 = AppSetting.d;
      break label109;
      if ((localImageInfo.g) && (!NetworkUtil.i(paramContext)))
      {
        i1 = 1;
        continue;
        if (i1 == 0) {
          break;
        }
        QQToast.a(paramContext, "系统可用内存不足，图片已压缩发送", 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        return;
      }
    }
  }
  
  public static final void a(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    if ((paramBitmap == null) || (paramCanvas == null)) {
      return;
    }
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    Rect localRect1 = new Rect(paramInt1, paramInt2, i1 + paramInt1, i2 + paramInt2);
    Rect localRect2 = new Rect(0, 0, i1, i2);
    RectF localRectF = new RectF(localRect2);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt3);
    Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect2, localRect2, localPaint);
    paramCanvas.drawBitmap(localBitmap, localRect2, localRect1, null);
  }
  
  /* Error */
  public static void a(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: new 375	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 1156	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 663	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_2
    //   20: invokevirtual 1159	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 748	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 663	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_1
    //   39: invokevirtual 1162	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_1
    //   46: invokevirtual 751	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_2
    //   52: new 1164	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 828	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 1167	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_1
    //   68: aload_0
    //   69: getstatic 941	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: bipush 100
    //   74: aload_1
    //   75: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   78: pop
    //   79: aload_1
    //   80: invokevirtual 1170	java/io/BufferedOutputStream:flush	()V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 1171	java/io/BufferedOutputStream:close	()V
    //   91: return
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull -5 -> 91
    //   99: aload_1
    //   100: invokevirtual 1171	java/io/BufferedOutputStream:close	()V
    //   103: return
    //   104: astore_0
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 1171	java/io/BufferedOutputStream:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: goto -11 -> 107
    //   121: astore_0
    //   122: goto -27 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramBitmap	Bitmap
    //   0	125	1	paramFile	File
    //   11	95	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   52	68	92	java/io/IOException
    //   52	68	104	finally
    //   68	83	117	finally
    //   68	83	121	java/io/IOException
  }
  
  private static void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt2)
    {
      paramRect.set(0, 0, paramInt3, (int)(paramInt3 / paramInt1 * paramInt2));
      return;
    }
    paramRect.set(0, 0, (int)(paramInt3 / paramInt2 * paramInt1), paramInt3);
  }
  
  public static void a(ImageInfo paramImageInfo, String paramString1, String paramString2)
  {
    if (paramImageInfo == null)
    {
      a(-1L, -1, true, paramString1, "@ImageUtil.log ImageInfo is null@ " + paramString2);
      return;
    }
    boolean bool = MsgUtils.b(paramImageInfo.jdField_e_of_type_Int);
    if (paramImageInfo.jdField_j_of_type_Int == 2)
    {
      a(paramImageInfo.jdField_e_of_type_Long, paramImageInfo.d, 131075, bool, paramString1, paramString2);
      return;
    }
    a(paramImageInfo.jdField_e_of_type_Long, paramImageInfo.d, bool, paramString1, paramString2);
  }
  
  private static final void a(FileOutputStream paramFileOutputStream)
  {
    paramFileOutputStream.flush();
    paramFileOutputStream = paramFileOutputStream.getFD();
    if ((paramFileOutputStream != null) && (paramFileOutputStream.valid())) {
      paramFileOutputStream.sync();
    }
  }
  
  private static void a(String paramString)
  {
    if ((QLog.isColorLevel()) || (RichMediaUtil.a())) {
      QLog.e(p, 2, paramString);
    }
  }
  
  private static void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramContext != null) && ((paramContext instanceof BaseActivity))) {
      ThreadManager.a(new wan((QQAppInterface)((BaseActivity)paramContext).getAppRuntime(), paramString, paramBoolean), 2, null, false);
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 375	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: aload_1
    //   14: invokestatic 938	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   17: astore_1
    //   18: new 668	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 671	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: new 828	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_2
    //   36: sipush 2048
    //   39: newarray <illegal type>
    //   41: astore_1
    //   42: lconst_0
    //   43: lstore 5
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 1214	java/io/InputStream:read	([B)I
    //   50: istore 4
    //   52: iload 4
    //   54: iflt +44 -> 98
    //   57: lload 5
    //   59: iload 4
    //   61: i2l
    //   62: ladd
    //   63: lstore 5
    //   65: aload_2
    //   66: aload_1
    //   67: iconst_0
    //   68: iload 4
    //   70: invokevirtual 1218	java/io/OutputStream:write	([BII)V
    //   73: goto -28 -> 45
    //   76: astore_1
    //   77: aload_0
    //   78: astore_1
    //   79: aload_2
    //   80: astore_0
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 456	java/io/InputStream:close	()V
    //   89: aload_0
    //   90: ifnull +7 -> 97
    //   93: aload_0
    //   94: invokevirtual 842	java/io/OutputStream:close	()V
    //   97: return
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 456	java/io/InputStream:close	()V
    //   106: aload_2
    //   107: ifnull -10 -> 97
    //   110: aload_2
    //   111: invokevirtual 842	java/io/OutputStream:close	()V
    //   114: return
    //   115: astore_0
    //   116: return
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_3
    //   121: astore_2
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 456	java/io/InputStream:close	()V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 842	java/io/OutputStream:close	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_0
    //   141: goto -35 -> 106
    //   144: astore_1
    //   145: goto -56 -> 89
    //   148: astore_0
    //   149: return
    //   150: astore_0
    //   151: goto -21 -> 130
    //   154: astore_0
    //   155: goto -17 -> 138
    //   158: astore_1
    //   159: aload_3
    //   160: astore_2
    //   161: goto -39 -> 122
    //   164: astore_1
    //   165: goto -43 -> 122
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_2
    //   172: astore_1
    //   173: goto -92 -> 81
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_0
    //   180: astore_1
    //   181: aload_2
    //   182: astore_0
    //   183: goto -102 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramString1	String
    //   0	186	1	paramString2	String
    //   3	179	2	localObject1	Object
    //   1	159	3	localObject2	Object
    //   50	19	4	i1	int
    //   43	21	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   36	42	76	java/lang/Exception
    //   45	52	76	java/lang/Exception
    //   65	73	76	java/lang/Exception
    //   110	114	115	java/io/IOException
    //   4	27	117	finally
    //   102	106	140	java/io/IOException
    //   85	89	144	java/io/IOException
    //   93	97	148	java/io/IOException
    //   126	130	150	java/io/IOException
    //   134	138	154	java/io/IOException
    //   27	36	158	finally
    //   36	42	164	finally
    //   45	52	164	finally
    //   65	73	164	finally
    //   4	27	168	java/lang/Exception
    //   27	36	176	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString1, localOptions);
      if ((localOptions.outWidth < paramInt1) && (localOptions.outHeight < paramInt2))
      {
        a(paramString1, paramString2, paramInt1, paramInt2, 100);
        return;
      }
      paramString2 = SafeBitmapFactory.decodeFile(paramString1);
      if (paramString2.getWidth() >= paramInt1) {
        break label99;
      }
      paramString2.getWidth();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a(paramString1.toString());
        return;
        if (paramString2.getHeight() < paramInt2) {
          paramString2.getHeight();
        }
      }
    }
    catch (Error paramString1)
    {
      label99:
      a(paramString1.toString());
    }
    a(a(paramString2, paramInt1, paramInt2), new File(paramString1));
    return;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: invokestatic 1233	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull +16 -> 25
    //   12: iconst_0
    //   13: ifeq +11 -> 24
    //   16: new 677	java/lang/NullPointerException
    //   19: dup
    //   20: invokespecial 678	java/lang/NullPointerException:<init>	()V
    //   23: athrow
    //   24: return
    //   25: aload_0
    //   26: invokevirtual 367	android/graphics/Bitmap:getWidth	()I
    //   29: istore 10
    //   31: aload_0
    //   32: invokevirtual 460	android/graphics/Bitmap:getHeight	()I
    //   35: istore 9
    //   37: iload_2
    //   38: i2f
    //   39: iload 10
    //   41: i2f
    //   42: fdiv
    //   43: fstore 6
    //   45: iload_3
    //   46: i2f
    //   47: iload 9
    //   49: i2f
    //   50: fdiv
    //   51: fstore 5
    //   53: new 550	android/graphics/Matrix
    //   56: dup
    //   57: invokespecial 551	android/graphics/Matrix:<init>	()V
    //   60: astore 8
    //   62: aload 8
    //   64: fload 6
    //   66: fload 5
    //   68: invokevirtual 555	android/graphics/Matrix:postScale	(FF)Z
    //   71: pop
    //   72: aload_0
    //   73: iconst_0
    //   74: iconst_0
    //   75: iload 10
    //   77: iload 9
    //   79: aload 8
    //   81: iconst_0
    //   82: invokestatic 631	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   85: astore 8
    //   87: new 828	java/io/FileOutputStream
    //   90: dup
    //   91: new 375	java/io/File
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore_1
    //   103: aload_1
    //   104: astore_0
    //   105: aload 8
    //   107: getstatic 941	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   110: iload 4
    //   112: aload_1
    //   113: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   116: ifeq +15 -> 131
    //   119: aload_1
    //   120: astore_0
    //   121: aload_1
    //   122: invokevirtual 1187	java/io/FileOutputStream:flush	()V
    //   125: aload_1
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   131: aload_1
    //   132: ifnull -108 -> 24
    //   135: aload_1
    //   136: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   139: return
    //   140: astore_0
    //   141: return
    //   142: astore 7
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: astore_0
    //   148: aload 7
    //   150: invokevirtual 267	java/lang/Exception:printStackTrace	()V
    //   153: aload_1
    //   154: ifnull -130 -> 24
    //   157: aload_1
    //   158: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   161: return
    //   162: astore_0
    //   163: return
    //   164: astore_0
    //   165: aload 7
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   176: aload_0
    //   177: athrow
    //   178: astore_0
    //   179: return
    //   180: astore_1
    //   181: goto -5 -> 176
    //   184: astore 7
    //   186: aload_0
    //   187: astore_1
    //   188: aload 7
    //   190: astore_0
    //   191: goto -23 -> 168
    //   194: astore 7
    //   196: goto -50 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramString1	String
    //   0	199	1	paramString2	String
    //   0	199	2	paramInt1	int
    //   0	199	3	paramInt2	int
    //   0	199	4	paramInt3	int
    //   51	16	5	f1	float
    //   43	22	6	f2	float
    //   1	1	7	localObject1	Object
    //   142	24	7	localException1	Exception
    //   184	5	7	localObject2	Object
    //   194	1	7	localException2	Exception
    //   60	46	8	localObject3	Object
    //   35	43	9	i1	int
    //   29	47	10	i2	int
    // Exception table:
    //   from	to	target	type
    //   135	139	140	java/io/IOException
    //   3	8	142	java/lang/Exception
    //   25	103	142	java/lang/Exception
    //   157	161	162	java/io/IOException
    //   3	8	164	finally
    //   25	103	164	finally
    //   16	24	178	java/io/IOException
    //   172	176	180	java/io/IOException
    //   105	119	184	finally
    //   121	125	184	finally
    //   127	131	184	finally
    //   148	153	184	finally
    //   105	119	194	java/lang/Exception
    //   121	125	194	java/lang/Exception
    //   127	131	194	java/lang/Exception
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if ((QLog.isColorLevel()) || (RichMediaUtil.a())) {
      QLog.e(p, 2, paramString, paramThrowable);
    }
  }
  
  private static void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      if (!paramBoolean)
      {
        localHashMap.put("param_FailCode", paramString3);
        localHashMap.put("param_FailMsg", paramString2);
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramString1, paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception paramString1) {}
  }
  
  private static boolean a()
  {
    return Utils.b() >> 20 < 2L;
  }
  
  public static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ImageInfo paramImageInfo, int paramInt2)
  {
    RichMediaUtil.a("compressPic", AppSetting.a, a(), 10000, 600000L);
    File localFile;
    if (FileUtils.a(paramString2))
    {
      localFile = new File(paramString2);
      if (!a(paramString2)) {
        localFile.delete();
      }
    }
    else
    {
      boolean bool = false;
      if (paramInt1 == 8) {
        bool = true;
      }
      paramBoolean = a(paramInt1, paramContext, paramString1, paramString2, paramBoolean, paramImageInfo, paramInt2, bool);
      if ((paramBoolean) && (!bool)) {
        b(paramString1, paramString2);
      }
      return paramBoolean;
    }
    paramImageInfo.b = localFile.getPath();
    paramImageInfo.a = localFile.length();
    paramImageInfo.o = true;
    paramImageInfo.h = true;
    if (paramImageInfo.jdField_l_of_type_Int > 0)
    {
      a("compress succ with retry : " + paramImageInfo.jdField_l_of_type_Int);
      a(paramInt1, 8, paramContext, false, null);
      if (paramImageInfo.jdField_l_of_type_Int <= 0) {
        break label207;
      }
    }
    label207:
    for (paramBoolean = true;; paramBoolean = false)
    {
      RichMediaUtil.a("compressPic", paramBoolean, "compressPic");
      return true;
      a(paramInt1, 0, paramContext, true, null);
      break;
    }
  }
  
  /* Error */
  private static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, ImageInfo paramImageInfo, int paramInt2, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 1274
    //   3: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   6: aload_3
    //   7: ifnull +16 -> 23
    //   10: aload_2
    //   11: ifnull +12 -> 23
    //   14: aload 5
    //   16: ifnull +7 -> 23
    //   19: aload_1
    //   20: ifnonnull +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: new 375	java/io/File
    //   28: dup
    //   29: new 153	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 770	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   39: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 21
    //   44: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: aload 8
    //   57: invokevirtual 663	java/io/File:exists	()Z
    //   60: ifne +23 -> 83
    //   63: ldc_w 1276
    //   66: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   69: aload 8
    //   71: invokevirtual 748	java/io/File:mkdirs	()Z
    //   74: ifne +9 -> 83
    //   77: ldc_w 1278
    //   80: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   83: new 375	java/io/File
    //   86: dup
    //   87: aload_3
    //   88: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore 9
    //   93: new 375	java/io/File
    //   96: dup
    //   97: aload_2
    //   98: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore 10
    //   103: aload 5
    //   105: ldc_w 1280
    //   108: new 153	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 1282
    //   118: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 5
    //   123: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   126: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc_w 1284
    //   132: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 5
    //   137: getfield 425	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   140: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_2
    //   150: invokestatic 1254	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   153: ifne +13 -> 166
    //   156: iload_0
    //   157: iconst_1
    //   158: aload_1
    //   159: iconst_0
    //   160: aconst_null
    //   161: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_2
    //   167: invokestatic 1285	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   170: ifne +13 -> 183
    //   173: iload_0
    //   174: iconst_2
    //   175: aload_1
    //   176: iconst_0
    //   177: aconst_null
    //   178: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   181: iconst_0
    //   182: ireturn
    //   183: aload_2
    //   184: invokestatic 1255	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Z
    //   187: ifne +13 -> 200
    //   190: iload_0
    //   191: iconst_4
    //   192: aload_1
    //   193: iconst_0
    //   194: aconst_null
    //   195: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   198: iconst_0
    //   199: ireturn
    //   200: aload 5
    //   202: aload 10
    //   204: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   207: putfield 1131	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   210: aload 5
    //   212: aload 10
    //   214: invokevirtual 844	java/io/File:length	()J
    //   217: putfield 1263	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   220: aload 10
    //   222: invokestatic 1287	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   225: astore 8
    //   227: new 153	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 1289
    //   237: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 10
    //   242: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: ldc_w 1291
    //   248: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 10
    //   253: invokevirtual 844	java/io/File:length	()J
    //   256: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   259: ldc_w 1293
    //   262: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 8
    //   267: getfield 117	android/graphics/BitmapFactory$Options:outWidth	I
    //   270: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: ldc_w 1295
    //   276: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 8
    //   281: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   284: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   293: aload_3
    //   294: invokestatic 1254	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   297: ifeq +16 -> 313
    //   300: aload_3
    //   301: invokestatic 1255	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Z
    //   304: ifne +460 -> 764
    //   307: aload 9
    //   309: invokevirtual 754	java/io/File:delete	()Z
    //   312: pop
    //   313: aload 10
    //   315: invokestatic 1057	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   318: istore 14
    //   320: aload 5
    //   322: iload 14
    //   324: putfield 1133	com/tencent/mobileqq/activity/photo/ImageInfo:q	Z
    //   327: iload 14
    //   329: ifne +125 -> 454
    //   332: aload 9
    //   334: invokevirtual 751	java/io/File:createNewFile	()Z
    //   337: ifeq +117 -> 454
    //   340: ldc_w 1297
    //   343: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   346: new 104	android/graphics/BitmapFactory$Options
    //   349: dup
    //   350: invokespecial 105	android/graphics/BitmapFactory$Options:<init>	()V
    //   353: astore 8
    //   355: aload 8
    //   357: iconst_1
    //   358: putfield 108	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   361: aload 10
    //   363: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   366: aload 8
    //   368: invokestatic 1298	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   371: pop
    //   372: aload 8
    //   374: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   377: istore 11
    //   379: aload 8
    //   381: getfield 117	android/graphics/BitmapFactory$Options:outWidth	I
    //   384: istore 12
    //   386: iload 11
    //   388: iconst_m1
    //   389: if_icmpeq +65 -> 454
    //   392: iload 12
    //   394: iconst_m1
    //   395: if_icmpeq +59 -> 454
    //   398: iload 7
    //   400: ifne +1240 -> 1640
    //   403: iload 4
    //   405: ifeq +1235 -> 1640
    //   408: iload 11
    //   410: iload 12
    //   412: iconst_3
    //   413: imul
    //   414: if_icmpgt +12 -> 426
    //   417: iload 12
    //   419: iload 11
    //   421: iconst_3
    //   422: imul
    //   423: if_icmple +1217 -> 1640
    //   426: iload_0
    //   427: aload_1
    //   428: aload 10
    //   430: aload 9
    //   432: aload 5
    //   434: iload 6
    //   436: iload 11
    //   438: iload 12
    //   440: iload 4
    //   442: iload 7
    //   444: invokestatic 1300	com/tencent/mobileqq/utils/ImageUtil:b	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   447: ldc 61
    //   449: aload_1
    //   450: iconst_1
    //   451: invokestatic 384	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   454: aload 5
    //   456: getfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   459: iconst_1
    //   460: if_icmpeq +12 -> 472
    //   463: aload 5
    //   465: getfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   468: iconst_1
    //   469: if_icmpne +1499 -> 1968
    //   472: iconst_1
    //   473: istore 13
    //   475: aload_3
    //   476: invokestatic 1285	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   479: istore 15
    //   481: aload 5
    //   483: ldc_w 1302
    //   486: new 153	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 1304
    //   496: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 5
    //   501: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   504: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   507: ldc_w 1306
    //   510: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload 5
    //   515: getfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   518: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   521: ldc_w 1308
    //   524: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: iload 15
    //   529: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   532: ldc_w 1310
    //   535: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: iload 13
    //   540: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   543: ldc_w 1312
    //   546: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload 5
    //   551: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   554: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   557: ldc_w 1314
    //   560: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 5
    //   565: getfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   568: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   571: ldc_w 1316
    //   574: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokestatic 983	com/tencent/mobileqq/util/Utils:b	()J
    //   580: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   589: aload 5
    //   591: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   594: ifne +1391 -> 1985
    //   597: aload 5
    //   599: getfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   602: ifeq +1372 -> 1974
    //   605: iload_0
    //   606: iconst_3
    //   607: aload_1
    //   608: iconst_0
    //   609: aconst_null
    //   610: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   613: iload 15
    //   615: ifeq +27 -> 642
    //   618: aload 9
    //   620: invokevirtual 844	java/io/File:length	()J
    //   623: aload 10
    //   625: invokevirtual 844	java/io/File:length	()J
    //   628: lcmp
    //   629: ifgt +13 -> 642
    //   632: iload 13
    //   634: ifne +8 -> 642
    //   637: iload 14
    //   639: ifeq +1670 -> 2309
    //   642: aload 5
    //   644: aload 10
    //   646: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   649: putfield 1131	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   652: aload 5
    //   654: aload 10
    //   656: invokevirtual 844	java/io/File:length	()J
    //   659: putfield 1263	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   662: aload 5
    //   664: iconst_0
    //   665: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   668: aload 5
    //   670: iconst_0
    //   671: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   674: aload 9
    //   676: ifnull +17 -> 693
    //   679: aload 9
    //   681: invokevirtual 663	java/io/File:exists	()Z
    //   684: ifeq +9 -> 693
    //   687: aload 9
    //   689: invokevirtual 754	java/io/File:delete	()Z
    //   692: pop
    //   693: iload 13
    //   695: ifne +8 -> 703
    //   698: iload 14
    //   700: ifeq +1448 -> 2148
    //   703: new 153	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   710: ldc_w 1318
    //   713: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 10
    //   718: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   721: ldc_w 1291
    //   724: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload 10
    //   729: invokevirtual 844	java/io/File:length	()J
    //   732: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   735: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   741: ldc_w 1241
    //   744: iconst_0
    //   745: ldc_w 1241
    //   748: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   751: aload 5
    //   753: ldc_w 1320
    //   756: ldc_w 1322
    //   759: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   762: iconst_0
    //   763: ireturn
    //   764: aload 5
    //   766: ldc_w 1008
    //   769: ldc_w 1324
    //   772: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   775: aload 5
    //   777: getfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   780: iconst_1
    //   781: if_icmpeq +12 -> 793
    //   784: aload 5
    //   786: getfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   789: iconst_1
    //   790: if_icmpne +380 -> 1170
    //   793: iconst_1
    //   794: istore 13
    //   796: aload_3
    //   797: invokestatic 1285	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   800: istore 14
    //   802: aload 5
    //   804: ldc_w 1302
    //   807: new 153	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 1304
    //   817: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload 5
    //   822: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   825: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   828: ldc_w 1306
    //   831: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload 5
    //   836: getfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   839: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   842: ldc_w 1308
    //   845: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: iload 14
    //   850: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   853: ldc_w 1310
    //   856: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: iload 13
    //   861: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   864: ldc_w 1312
    //   867: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload 5
    //   872: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   875: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   878: ldc_w 1314
    //   881: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: aload 5
    //   886: getfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   889: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   892: ldc_w 1316
    //   895: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: invokestatic 983	com/tencent/mobileqq/util/Utils:b	()J
    //   901: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   904: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   910: aload 5
    //   912: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   915: ifne +272 -> 1187
    //   918: aload 5
    //   920: getfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   923: ifeq +253 -> 1176
    //   926: iload_0
    //   927: iconst_3
    //   928: aload_1
    //   929: iconst_0
    //   930: aconst_null
    //   931: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   934: iload 14
    //   936: ifeq +409 -> 1345
    //   939: aload 9
    //   941: invokevirtual 844	java/io/File:length	()J
    //   944: aload 10
    //   946: invokevirtual 844	java/io/File:length	()J
    //   949: lcmp
    //   950: ifgt +395 -> 1345
    //   953: iload 13
    //   955: ifne +390 -> 1345
    //   958: aload 5
    //   960: aload 9
    //   962: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   965: putfield 1131	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   968: aload 5
    //   970: aload 9
    //   972: invokevirtual 844	java/io/File:length	()J
    //   975: putfield 1263	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   978: aload 5
    //   980: iconst_1
    //   981: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   984: aload 5
    //   986: iconst_1
    //   987: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   990: aload 9
    //   992: invokestatic 1287	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   995: astore_2
    //   996: new 153	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1003: ldc_w 1326
    //   1006: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload 10
    //   1011: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1014: ldc_w 1328
    //   1017: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload_3
    //   1021: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: ldc_w 1291
    //   1027: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload 9
    //   1032: invokevirtual 844	java/io/File:length	()J
    //   1035: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1038: ldc_w 1293
    //   1041: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload_2
    //   1045: getfield 117	android/graphics/BitmapFactory$Options:outWidth	I
    //   1048: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1051: ldc_w 1295
    //   1054: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload_2
    //   1058: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   1061: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1070: aload 5
    //   1072: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1075: ifle +548 -> 1623
    //   1078: new 153	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 1267
    //   1088: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload 5
    //   1093: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1096: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1105: iload_0
    //   1106: bipush 8
    //   1108: aload_1
    //   1109: iconst_0
    //   1110: aconst_null
    //   1111: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1114: aload 5
    //   1116: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1119: ifle +515 -> 1634
    //   1122: iconst_1
    //   1123: istore 4
    //   1125: ldc_w 1241
    //   1128: iload 4
    //   1130: ldc_w 1241
    //   1133: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1136: aload 5
    //   1138: ldc_w 1320
    //   1141: new 153	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1148: ldc_w 1330
    //   1151: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 5
    //   1156: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1159: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1168: iconst_1
    //   1169: ireturn
    //   1170: iconst_0
    //   1171: istore 13
    //   1173: goto -377 -> 796
    //   1176: iload_0
    //   1177: iconst_4
    //   1178: aload_1
    //   1179: iconst_0
    //   1180: aconst_null
    //   1181: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1184: goto -250 -> 934
    //   1187: iload 14
    //   1189: ifne -255 -> 934
    //   1192: iload 13
    //   1194: ifne -260 -> 934
    //   1197: aload 5
    //   1199: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1202: istore 11
    //   1204: aload 5
    //   1206: iload 11
    //   1208: iconst_1
    //   1209: iadd
    //   1210: putfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1213: iload 11
    //   1215: iconst_2
    //   1216: if_icmpge +33 -> 1249
    //   1219: aload 5
    //   1221: iconst_1
    //   1222: putfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1225: ldc_w 1332
    //   1228: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1231: iload_0
    //   1232: aload_1
    //   1233: aload_2
    //   1234: aload_3
    //   1235: iload 4
    //   1237: aload 5
    //   1239: iload 6
    //   1241: iload 7
    //   1243: invokestatic 1258	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   1246: pop
    //   1247: iconst_0
    //   1248: ireturn
    //   1249: aload 5
    //   1251: getfield 1027	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   1254: ifeq +15 -> 1269
    //   1257: iload_0
    //   1258: bipush 6
    //   1260: aload_1
    //   1261: iconst_0
    //   1262: aconst_null
    //   1263: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1266: goto -332 -> 934
    //   1269: aload 5
    //   1271: getfield 1334	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   1274: ifeq +15 -> 1289
    //   1277: iload_0
    //   1278: bipush 7
    //   1280: aload_1
    //   1281: iconst_0
    //   1282: aconst_null
    //   1283: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1286: goto -352 -> 934
    //   1289: aload 5
    //   1291: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1294: ifne +15 -> 1309
    //   1297: iload_0
    //   1298: bipush 9
    //   1300: aload_1
    //   1301: iconst_0
    //   1302: aconst_null
    //   1303: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1306: goto -372 -> 934
    //   1309: aload 5
    //   1311: getfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1314: ifeq +14 -> 1328
    //   1317: iload_0
    //   1318: iconst_0
    //   1319: aload_1
    //   1320: iconst_0
    //   1321: aconst_null
    //   1322: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1325: goto -391 -> 934
    //   1328: ldc_w 1336
    //   1331: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1334: iload_0
    //   1335: iconst_5
    //   1336: aload_1
    //   1337: iconst_0
    //   1338: aconst_null
    //   1339: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1342: goto -408 -> 934
    //   1345: aload 5
    //   1347: aload 10
    //   1349: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   1352: putfield 1131	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1355: aload 5
    //   1357: aload 10
    //   1359: invokevirtual 844	java/io/File:length	()J
    //   1362: putfield 1263	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1365: aload 5
    //   1367: iconst_0
    //   1368: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1371: aload 5
    //   1373: iconst_0
    //   1374: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   1377: aload 9
    //   1379: ifnull +17 -> 1396
    //   1382: aload 9
    //   1384: invokevirtual 663	java/io/File:exists	()Z
    //   1387: ifeq +9 -> 1396
    //   1390: aload 9
    //   1392: invokevirtual 754	java/io/File:delete	()Z
    //   1395: pop
    //   1396: iload 13
    //   1398: ifne +155 -> 1553
    //   1401: new 153	java/lang/StringBuilder
    //   1404: dup
    //   1405: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1408: ldc_w 1338
    //   1411: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: aload_3
    //   1415: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: ldc_w 1291
    //   1421: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: aload 9
    //   1426: invokevirtual 844	java/io/File:length	()J
    //   1429: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1432: ldc_w 1340
    //   1435: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: aload 10
    //   1440: invokevirtual 844	java/io/File:length	()J
    //   1443: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1446: ldc_w 1342
    //   1449: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: iload 13
    //   1454: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1457: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1463: new 153	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1470: ldc_w 1344
    //   1473: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: iconst_0
    //   1477: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1480: ldc_w 1346
    //   1483: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: aload_3
    //   1487: invokestatic 1254	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   1490: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1493: ldc_w 1348
    //   1496: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: astore_1
    //   1500: aload 9
    //   1502: invokevirtual 844	java/io/File:length	()J
    //   1505: lconst_0
    //   1506: lcmp
    //   1507: ifgt +97 -> 1604
    //   1510: iconst_1
    //   1511: istore 4
    //   1513: aload_1
    //   1514: iload 4
    //   1516: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1519: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1522: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1525: iload 14
    //   1527: ifne +83 -> 1610
    //   1530: ldc_w 1241
    //   1533: iconst_1
    //   1534: ldc_w 1241
    //   1537: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1540: aload 5
    //   1542: ldc_w 1320
    //   1545: ldc_w 1322
    //   1548: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1551: iconst_1
    //   1552: ireturn
    //   1553: new 153	java/lang/StringBuilder
    //   1556: dup
    //   1557: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1560: ldc_w 1318
    //   1563: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload 10
    //   1568: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1571: ldc_w 1291
    //   1574: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: aload 10
    //   1579: invokevirtual 844	java/io/File:length	()J
    //   1582: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1585: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1591: ldc_w 1241
    //   1594: iconst_0
    //   1595: ldc_w 1241
    //   1598: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1601: goto -61 -> 1540
    //   1604: iconst_0
    //   1605: istore 4
    //   1607: goto -94 -> 1513
    //   1610: ldc_w 1241
    //   1613: iconst_0
    //   1614: ldc_w 1241
    //   1617: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1620: goto -80 -> 1540
    //   1623: iload_0
    //   1624: iconst_0
    //   1625: aload_1
    //   1626: iconst_1
    //   1627: aconst_null
    //   1628: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1631: goto -517 -> 1114
    //   1634: iconst_0
    //   1635: istore 4
    //   1637: goto -512 -> 1125
    //   1640: iload_0
    //   1641: aload_1
    //   1642: aload 10
    //   1644: aload 9
    //   1646: aload 5
    //   1648: iload 6
    //   1650: iload 11
    //   1652: iload 12
    //   1654: iload 4
    //   1656: iload 7
    //   1658: invokestatic 1350	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   1661: ldc 61
    //   1663: aload_1
    //   1664: iconst_0
    //   1665: invokestatic 384	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   1668: goto -1214 -> 454
    //   1671: astore 8
    //   1673: iload 14
    //   1675: istore 13
    //   1677: iconst_1
    //   1678: istore 15
    //   1680: ldc_w 1352
    //   1683: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1686: aload 5
    //   1688: getfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   1691: iconst_1
    //   1692: if_icmpeq +12 -> 1704
    //   1695: aload 5
    //   1697: getfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   1700: iconst_1
    //   1701: if_icmpne +837 -> 2538
    //   1704: iconst_1
    //   1705: istore 14
    //   1707: aload_3
    //   1708: invokestatic 1285	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   1711: istore 15
    //   1713: aload 5
    //   1715: ldc_w 1302
    //   1718: new 153	java/lang/StringBuilder
    //   1721: dup
    //   1722: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1725: ldc_w 1304
    //   1728: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: aload 5
    //   1733: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   1736: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1739: ldc_w 1306
    //   1742: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: aload 5
    //   1747: getfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   1750: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1753: ldc_w 1308
    //   1756: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: iload 15
    //   1761: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1764: ldc_w 1310
    //   1767: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: iload 14
    //   1772: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1775: ldc_w 1312
    //   1778: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: aload 5
    //   1783: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1786: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1789: ldc_w 1314
    //   1792: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: aload 5
    //   1797: getfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1800: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1803: ldc_w 1316
    //   1806: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: invokestatic 983	com/tencent/mobileqq/util/Utils:b	()J
    //   1812: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1815: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1818: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1821: aload 5
    //   1823: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   1826: ifne +729 -> 2555
    //   1829: aload 5
    //   1831: getfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   1834: ifeq +710 -> 2544
    //   1837: iload_0
    //   1838: iconst_3
    //   1839: aload_1
    //   1840: iconst_0
    //   1841: aconst_null
    //   1842: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1845: aload 5
    //   1847: aload 10
    //   1849: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   1852: putfield 1131	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1855: aload 5
    //   1857: aload 10
    //   1859: invokevirtual 844	java/io/File:length	()J
    //   1862: putfield 1263	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1865: aload 5
    //   1867: iconst_0
    //   1868: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1871: aload 5
    //   1873: iconst_0
    //   1874: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   1877: aload 9
    //   1879: ifnull +17 -> 1896
    //   1882: aload 9
    //   1884: invokevirtual 663	java/io/File:exists	()Z
    //   1887: ifeq +9 -> 1896
    //   1890: aload 9
    //   1892: invokevirtual 754	java/io/File:delete	()Z
    //   1895: pop
    //   1896: iload 14
    //   1898: ifne +8 -> 1906
    //   1901: iload 13
    //   1903: ifeq +815 -> 2718
    //   1906: new 153	java/lang/StringBuilder
    //   1909: dup
    //   1910: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1913: ldc_w 1318
    //   1916: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: aload 10
    //   1921: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1924: ldc_w 1291
    //   1927: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: aload 10
    //   1932: invokevirtual 844	java/io/File:length	()J
    //   1935: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1938: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1941: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1944: ldc_w 1241
    //   1947: iconst_0
    //   1948: ldc_w 1241
    //   1951: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1954: aload 5
    //   1956: ldc_w 1320
    //   1959: ldc_w 1322
    //   1962: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1965: goto -1203 -> 762
    //   1968: iconst_0
    //   1969: istore 13
    //   1971: goto -1496 -> 475
    //   1974: iload_0
    //   1975: iconst_4
    //   1976: aload_1
    //   1977: iconst_0
    //   1978: aconst_null
    //   1979: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1982: goto -1369 -> 613
    //   1985: iload 15
    //   1987: ifne -1374 -> 613
    //   1990: iload 13
    //   1992: ifne -1379 -> 613
    //   1995: iload 14
    //   1997: ifne -1384 -> 613
    //   2000: aload 5
    //   2002: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2005: istore 11
    //   2007: aload 5
    //   2009: iload 11
    //   2011: iconst_1
    //   2012: iadd
    //   2013: putfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2016: iload 11
    //   2018: iconst_2
    //   2019: if_icmpge +33 -> 2052
    //   2022: aload 5
    //   2024: iconst_1
    //   2025: putfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2028: ldc_w 1332
    //   2031: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2034: iload_0
    //   2035: aload_1
    //   2036: aload_2
    //   2037: aload_3
    //   2038: iload 4
    //   2040: aload 5
    //   2042: iload 6
    //   2044: iload 7
    //   2046: invokestatic 1258	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2049: pop
    //   2050: iconst_0
    //   2051: ireturn
    //   2052: aload 5
    //   2054: getfield 1027	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   2057: ifeq +15 -> 2072
    //   2060: iload_0
    //   2061: bipush 6
    //   2063: aload_1
    //   2064: iconst_0
    //   2065: aconst_null
    //   2066: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2069: goto -1456 -> 613
    //   2072: aload 5
    //   2074: getfield 1334	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   2077: ifeq +15 -> 2092
    //   2080: iload_0
    //   2081: bipush 7
    //   2083: aload_1
    //   2084: iconst_0
    //   2085: aconst_null
    //   2086: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2089: goto -1476 -> 613
    //   2092: aload 5
    //   2094: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2097: ifne +15 -> 2112
    //   2100: iload_0
    //   2101: bipush 9
    //   2103: aload_1
    //   2104: iconst_0
    //   2105: aconst_null
    //   2106: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2109: goto -1496 -> 613
    //   2112: aload 5
    //   2114: getfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2117: ifeq +14 -> 2131
    //   2120: iload_0
    //   2121: iconst_0
    //   2122: aload_1
    //   2123: iconst_0
    //   2124: aconst_null
    //   2125: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2128: goto -1515 -> 613
    //   2131: ldc_w 1336
    //   2134: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2137: iload_0
    //   2138: iconst_5
    //   2139: aload_1
    //   2140: iconst_0
    //   2141: aconst_null
    //   2142: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2145: goto -1532 -> 613
    //   2148: new 153	java/lang/StringBuilder
    //   2151: dup
    //   2152: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2155: ldc_w 1338
    //   2158: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: aload_3
    //   2162: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: ldc_w 1291
    //   2168: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: aload 9
    //   2173: invokevirtual 844	java/io/File:length	()J
    //   2176: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2179: ldc_w 1340
    //   2182: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: aload 10
    //   2187: invokevirtual 844	java/io/File:length	()J
    //   2190: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2193: ldc_w 1342
    //   2196: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: iload 13
    //   2201: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2204: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2207: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2210: new 153	java/lang/StringBuilder
    //   2213: dup
    //   2214: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2217: ldc_w 1344
    //   2220: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: iconst_0
    //   2224: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2227: ldc_w 1346
    //   2230: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: aload_3
    //   2234: invokestatic 1254	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   2237: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2240: ldc_w 1348
    //   2243: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: astore_1
    //   2247: aload 9
    //   2249: invokevirtual 844	java/io/File:length	()J
    //   2252: lconst_0
    //   2253: lcmp
    //   2254: ifgt +36 -> 2290
    //   2257: iconst_1
    //   2258: istore 4
    //   2260: aload_1
    //   2261: iload 4
    //   2263: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2266: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2269: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2272: iload 15
    //   2274: ifne +22 -> 2296
    //   2277: ldc_w 1241
    //   2280: iconst_1
    //   2281: ldc_w 1241
    //   2284: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2287: goto -1536 -> 751
    //   2290: iconst_0
    //   2291: istore 4
    //   2293: goto -33 -> 2260
    //   2296: ldc_w 1241
    //   2299: iconst_0
    //   2300: ldc_w 1241
    //   2303: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2306: goto -1555 -> 751
    //   2309: aload 5
    //   2311: aload 9
    //   2313: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   2316: putfield 1131	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   2319: aload 5
    //   2321: aload 9
    //   2323: invokevirtual 844	java/io/File:length	()J
    //   2326: putfield 1263	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   2329: aload 5
    //   2331: iconst_1
    //   2332: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2335: aload 5
    //   2337: iconst_1
    //   2338: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   2341: aload 9
    //   2343: invokestatic 1287	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   2346: astore_2
    //   2347: new 153	java/lang/StringBuilder
    //   2350: dup
    //   2351: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2354: ldc_w 1326
    //   2357: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: aload 10
    //   2362: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2365: ldc_w 1328
    //   2368: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: aload_3
    //   2372: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: ldc_w 1291
    //   2378: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2381: aload 9
    //   2383: invokevirtual 844	java/io/File:length	()J
    //   2386: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2389: ldc_w 1293
    //   2392: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: aload_2
    //   2396: getfield 117	android/graphics/BitmapFactory$Options:outWidth	I
    //   2399: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2402: ldc_w 1295
    //   2405: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2408: aload_2
    //   2409: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   2412: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2415: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2418: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2421: aload 5
    //   2423: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2426: ifle +95 -> 2521
    //   2429: new 153	java/lang/StringBuilder
    //   2432: dup
    //   2433: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2436: ldc_w 1267
    //   2439: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: aload 5
    //   2444: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2447: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2450: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2453: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2456: iload_0
    //   2457: bipush 8
    //   2459: aload_1
    //   2460: iconst_0
    //   2461: aconst_null
    //   2462: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2465: aload 5
    //   2467: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2470: ifle +62 -> 2532
    //   2473: iconst_1
    //   2474: istore 4
    //   2476: ldc_w 1241
    //   2479: iload 4
    //   2481: ldc_w 1241
    //   2484: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2487: aload 5
    //   2489: ldc_w 1320
    //   2492: new 153	java/lang/StringBuilder
    //   2495: dup
    //   2496: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2499: ldc_w 1330
    //   2502: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2505: aload 5
    //   2507: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2510: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2513: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2516: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2519: iconst_1
    //   2520: ireturn
    //   2521: iload_0
    //   2522: iconst_0
    //   2523: aload_1
    //   2524: iconst_1
    //   2525: aconst_null
    //   2526: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2529: goto -64 -> 2465
    //   2532: iconst_0
    //   2533: istore 4
    //   2535: goto -59 -> 2476
    //   2538: iconst_0
    //   2539: istore 14
    //   2541: goto -834 -> 1707
    //   2544: iload_0
    //   2545: iconst_4
    //   2546: aload_1
    //   2547: iconst_0
    //   2548: aconst_null
    //   2549: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2552: goto -707 -> 1845
    //   2555: iload 15
    //   2557: ifne -712 -> 1845
    //   2560: iload 14
    //   2562: ifne -717 -> 1845
    //   2565: iload 13
    //   2567: ifne -722 -> 1845
    //   2570: aload 5
    //   2572: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2575: istore 11
    //   2577: aload 5
    //   2579: iload 11
    //   2581: iconst_1
    //   2582: iadd
    //   2583: putfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2586: iload 11
    //   2588: iconst_2
    //   2589: if_icmpge +33 -> 2622
    //   2592: aload 5
    //   2594: iconst_1
    //   2595: putfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2598: ldc_w 1332
    //   2601: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2604: iload_0
    //   2605: aload_1
    //   2606: aload_2
    //   2607: aload_3
    //   2608: iload 4
    //   2610: aload 5
    //   2612: iload 6
    //   2614: iload 7
    //   2616: invokestatic 1258	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2619: pop
    //   2620: iconst_0
    //   2621: ireturn
    //   2622: aload 5
    //   2624: getfield 1027	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   2627: ifeq +15 -> 2642
    //   2630: iload_0
    //   2631: bipush 6
    //   2633: aload_1
    //   2634: iconst_0
    //   2635: aconst_null
    //   2636: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2639: goto -794 -> 1845
    //   2642: aload 5
    //   2644: getfield 1334	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   2647: ifeq +15 -> 2662
    //   2650: iload_0
    //   2651: bipush 7
    //   2653: aload_1
    //   2654: iconst_0
    //   2655: aconst_null
    //   2656: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2659: goto -814 -> 1845
    //   2662: aload 5
    //   2664: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2667: ifne +15 -> 2682
    //   2670: iload_0
    //   2671: bipush 9
    //   2673: aload_1
    //   2674: iconst_0
    //   2675: aconst_null
    //   2676: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2679: goto -834 -> 1845
    //   2682: aload 5
    //   2684: getfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2687: ifeq +14 -> 2701
    //   2690: iload_0
    //   2691: iconst_0
    //   2692: aload_1
    //   2693: iconst_0
    //   2694: aconst_null
    //   2695: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2698: goto -853 -> 1845
    //   2701: ldc_w 1336
    //   2704: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2707: iload_0
    //   2708: iconst_5
    //   2709: aload_1
    //   2710: iconst_0
    //   2711: aconst_null
    //   2712: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2715: goto -870 -> 1845
    //   2718: new 153	java/lang/StringBuilder
    //   2721: dup
    //   2722: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2725: ldc_w 1338
    //   2728: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2731: aload_3
    //   2732: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2735: ldc_w 1291
    //   2738: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2741: aload 9
    //   2743: invokevirtual 844	java/io/File:length	()J
    //   2746: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2749: ldc_w 1340
    //   2752: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2755: aload 10
    //   2757: invokevirtual 844	java/io/File:length	()J
    //   2760: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2763: ldc_w 1342
    //   2766: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2769: iload 14
    //   2771: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2774: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2777: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2780: new 153	java/lang/StringBuilder
    //   2783: dup
    //   2784: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2787: ldc_w 1344
    //   2790: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2793: iconst_1
    //   2794: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2797: ldc_w 1346
    //   2800: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: aload_3
    //   2804: invokestatic 1254	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   2807: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2810: ldc_w 1348
    //   2813: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: astore_1
    //   2817: aload 9
    //   2819: invokevirtual 844	java/io/File:length	()J
    //   2822: lconst_0
    //   2823: lcmp
    //   2824: ifgt +31 -> 2855
    //   2827: iconst_1
    //   2828: istore 4
    //   2830: aload_1
    //   2831: iload 4
    //   2833: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2836: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2839: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2842: ldc_w 1241
    //   2845: iconst_1
    //   2846: ldc_w 1241
    //   2849: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2852: goto -898 -> 1954
    //   2855: iconst_0
    //   2856: istore 4
    //   2858: goto -28 -> 2830
    //   2861: astore 8
    //   2863: iconst_0
    //   2864: istore 14
    //   2866: iconst_0
    //   2867: istore 13
    //   2869: aload 5
    //   2871: getfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   2874: iconst_1
    //   2875: if_icmpeq +12 -> 2887
    //   2878: aload 5
    //   2880: getfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   2883: iconst_1
    //   2884: if_icmpne +301 -> 3185
    //   2887: iconst_1
    //   2888: istore 15
    //   2890: aload_3
    //   2891: invokestatic 1285	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   2894: istore 16
    //   2896: aload 5
    //   2898: ldc_w 1302
    //   2901: new 153	java/lang/StringBuilder
    //   2904: dup
    //   2905: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   2908: ldc_w 1304
    //   2911: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: aload 5
    //   2916: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   2919: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2922: ldc_w 1306
    //   2925: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2928: aload 5
    //   2930: getfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2933: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2936: ldc_w 1308
    //   2939: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: iload 16
    //   2944: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2947: ldc_w 1310
    //   2950: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2953: iload 15
    //   2955: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2958: ldc_w 1312
    //   2961: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2964: aload 5
    //   2966: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2969: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2972: ldc_w 1314
    //   2975: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2978: aload 5
    //   2980: getfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2983: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2986: ldc_w 1316
    //   2989: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2992: invokestatic 983	com/tencent/mobileqq/util/Utils:b	()J
    //   2995: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2998: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3001: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3004: aload 5
    //   3006: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   3009: ifne +193 -> 3202
    //   3012: aload 5
    //   3014: getfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   3017: ifeq +174 -> 3191
    //   3020: iload_0
    //   3021: iconst_3
    //   3022: aload_1
    //   3023: iconst_0
    //   3024: aconst_null
    //   3025: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3028: iload 13
    //   3030: ifne +32 -> 3062
    //   3033: iload 16
    //   3035: ifeq +27 -> 3062
    //   3038: aload 9
    //   3040: invokevirtual 844	java/io/File:length	()J
    //   3043: aload 10
    //   3045: invokevirtual 844	java/io/File:length	()J
    //   3048: lcmp
    //   3049: ifgt +13 -> 3062
    //   3052: iload 15
    //   3054: ifne +8 -> 3062
    //   3057: iload 14
    //   3059: ifeq +473 -> 3532
    //   3062: aload 5
    //   3064: aload 10
    //   3066: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   3069: putfield 1131	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   3072: aload 5
    //   3074: aload 10
    //   3076: invokevirtual 844	java/io/File:length	()J
    //   3079: putfield 1263	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   3082: aload 5
    //   3084: iconst_0
    //   3085: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   3088: aload 5
    //   3090: iconst_0
    //   3091: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   3094: aload 9
    //   3096: ifnull +17 -> 3113
    //   3099: aload 9
    //   3101: invokevirtual 663	java/io/File:exists	()Z
    //   3104: ifeq +9 -> 3113
    //   3107: aload 9
    //   3109: invokevirtual 754	java/io/File:delete	()Z
    //   3112: pop
    //   3113: iload 15
    //   3115: ifne +8 -> 3123
    //   3118: iload 14
    //   3120: ifeq +245 -> 3365
    //   3123: new 153	java/lang/StringBuilder
    //   3126: dup
    //   3127: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3130: ldc_w 1318
    //   3133: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3136: aload 10
    //   3138: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3141: ldc_w 1291
    //   3144: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3147: aload 10
    //   3149: invokevirtual 844	java/io/File:length	()J
    //   3152: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3155: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3158: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3161: ldc_w 1241
    //   3164: iconst_0
    //   3165: ldc_w 1241
    //   3168: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3171: aload 5
    //   3173: ldc_w 1320
    //   3176: ldc_w 1322
    //   3179: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3182: aload 8
    //   3184: athrow
    //   3185: iconst_0
    //   3186: istore 15
    //   3188: goto -298 -> 2890
    //   3191: iload_0
    //   3192: iconst_4
    //   3193: aload_1
    //   3194: iconst_0
    //   3195: aconst_null
    //   3196: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3199: goto -171 -> 3028
    //   3202: iload 16
    //   3204: ifne -176 -> 3028
    //   3207: iload 15
    //   3209: ifne -181 -> 3028
    //   3212: iload 14
    //   3214: ifne -186 -> 3028
    //   3217: aload 5
    //   3219: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3222: istore 11
    //   3224: aload 5
    //   3226: iload 11
    //   3228: iconst_1
    //   3229: iadd
    //   3230: putfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3233: iload 11
    //   3235: iconst_2
    //   3236: if_icmpge +33 -> 3269
    //   3239: aload 5
    //   3241: iconst_1
    //   3242: putfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   3245: ldc_w 1332
    //   3248: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3251: iload_0
    //   3252: aload_1
    //   3253: aload_2
    //   3254: aload_3
    //   3255: iload 4
    //   3257: aload 5
    //   3259: iload 6
    //   3261: iload 7
    //   3263: invokestatic 1258	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   3266: pop
    //   3267: iconst_0
    //   3268: ireturn
    //   3269: aload 5
    //   3271: getfield 1027	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   3274: ifeq +15 -> 3289
    //   3277: iload_0
    //   3278: bipush 6
    //   3280: aload_1
    //   3281: iconst_0
    //   3282: aconst_null
    //   3283: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3286: goto -258 -> 3028
    //   3289: aload 5
    //   3291: getfield 1334	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   3294: ifeq +15 -> 3309
    //   3297: iload_0
    //   3298: bipush 7
    //   3300: aload_1
    //   3301: iconst_0
    //   3302: aconst_null
    //   3303: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3306: goto -278 -> 3028
    //   3309: aload 5
    //   3311: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   3314: ifne +15 -> 3329
    //   3317: iload_0
    //   3318: bipush 9
    //   3320: aload_1
    //   3321: iconst_0
    //   3322: aconst_null
    //   3323: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3326: goto -298 -> 3028
    //   3329: aload 5
    //   3331: getfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   3334: ifeq +14 -> 3348
    //   3337: iload_0
    //   3338: iconst_0
    //   3339: aload_1
    //   3340: iconst_0
    //   3341: aconst_null
    //   3342: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3345: goto -317 -> 3028
    //   3348: ldc_w 1336
    //   3351: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3354: iload_0
    //   3355: iconst_5
    //   3356: aload_1
    //   3357: iconst_0
    //   3358: aconst_null
    //   3359: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3362: goto -334 -> 3028
    //   3365: new 153	java/lang/StringBuilder
    //   3368: dup
    //   3369: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3372: ldc_w 1338
    //   3375: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3378: aload_3
    //   3379: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3382: ldc_w 1291
    //   3385: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3388: aload 9
    //   3390: invokevirtual 844	java/io/File:length	()J
    //   3393: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3396: ldc_w 1340
    //   3399: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3402: aload 10
    //   3404: invokevirtual 844	java/io/File:length	()J
    //   3407: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3410: ldc_w 1342
    //   3413: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3416: iload 15
    //   3418: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3421: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3424: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3427: new 153	java/lang/StringBuilder
    //   3430: dup
    //   3431: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3434: ldc_w 1344
    //   3437: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: iload 13
    //   3442: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3445: ldc_w 1346
    //   3448: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3451: aload_3
    //   3452: invokestatic 1254	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   3455: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3458: ldc_w 1348
    //   3461: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3464: astore_1
    //   3465: aload 9
    //   3467: invokevirtual 844	java/io/File:length	()J
    //   3470: lconst_0
    //   3471: lcmp
    //   3472: ifgt +41 -> 3513
    //   3475: iconst_1
    //   3476: istore 4
    //   3478: aload_1
    //   3479: iload 4
    //   3481: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3484: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3487: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3490: iload 13
    //   3492: ifne +8 -> 3500
    //   3495: iload 16
    //   3497: ifne +22 -> 3519
    //   3500: ldc_w 1241
    //   3503: iconst_1
    //   3504: ldc_w 1241
    //   3507: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3510: goto -339 -> 3171
    //   3513: iconst_0
    //   3514: istore 4
    //   3516: goto -38 -> 3478
    //   3519: ldc_w 1241
    //   3522: iconst_0
    //   3523: ldc_w 1241
    //   3526: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3529: goto -358 -> 3171
    //   3532: aload 5
    //   3534: aload 9
    //   3536: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   3539: putfield 1131	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   3542: aload 5
    //   3544: aload 9
    //   3546: invokevirtual 844	java/io/File:length	()J
    //   3549: putfield 1263	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   3552: aload 5
    //   3554: iconst_1
    //   3555: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   3558: aload 5
    //   3560: iconst_1
    //   3561: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   3564: aload 9
    //   3566: invokestatic 1287	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   3569: astore_2
    //   3570: new 153	java/lang/StringBuilder
    //   3573: dup
    //   3574: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3577: ldc_w 1326
    //   3580: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3583: aload 10
    //   3585: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3588: ldc_w 1328
    //   3591: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3594: aload_3
    //   3595: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: ldc_w 1291
    //   3601: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3604: aload 9
    //   3606: invokevirtual 844	java/io/File:length	()J
    //   3609: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3612: ldc_w 1293
    //   3615: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3618: aload_2
    //   3619: getfield 117	android/graphics/BitmapFactory$Options:outWidth	I
    //   3622: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3625: ldc_w 1295
    //   3628: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: aload_2
    //   3632: getfield 120	android/graphics/BitmapFactory$Options:outHeight	I
    //   3635: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3638: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3641: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3644: aload 5
    //   3646: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3649: ifle +95 -> 3744
    //   3652: new 153	java/lang/StringBuilder
    //   3655: dup
    //   3656: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3659: ldc_w 1267
    //   3662: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3665: aload 5
    //   3667: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3670: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3673: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3676: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3679: iload_0
    //   3680: bipush 8
    //   3682: aload_1
    //   3683: iconst_0
    //   3684: aconst_null
    //   3685: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3688: aload 5
    //   3690: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3693: ifle +62 -> 3755
    //   3696: iconst_1
    //   3697: istore 4
    //   3699: ldc_w 1241
    //   3702: iload 4
    //   3704: ldc_w 1241
    //   3707: invokestatic 1272	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3710: aload 5
    //   3712: ldc_w 1320
    //   3715: new 153	java/lang/StringBuilder
    //   3718: dup
    //   3719: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   3722: ldc_w 1330
    //   3725: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3728: aload 5
    //   3730: getfield 1265	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3733: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3736: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3739: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3742: iconst_1
    //   3743: ireturn
    //   3744: iload_0
    //   3745: iconst_0
    //   3746: aload_1
    //   3747: iconst_1
    //   3748: aconst_null
    //   3749: invokestatic 1269	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3752: goto -64 -> 3688
    //   3755: iconst_0
    //   3756: istore 4
    //   3758: goto -59 -> 3699
    //   3761: astore 8
    //   3763: iconst_0
    //   3764: istore 13
    //   3766: goto -897 -> 2869
    //   3769: astore 8
    //   3771: iload 13
    //   3773: istore 14
    //   3775: iload 15
    //   3777: istore 13
    //   3779: goto -910 -> 2869
    //   3782: astore 8
    //   3784: iconst_0
    //   3785: istore 13
    //   3787: goto -2110 -> 1677
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3790	0	paramInt1	int
    //   0	3790	1	paramContext	Context
    //   0	3790	2	paramString1	String
    //   0	3790	3	paramString2	String
    //   0	3790	4	paramBoolean1	boolean
    //   0	3790	5	paramImageInfo	ImageInfo
    //   0	3790	6	paramInt2	int
    //   0	3790	7	paramBoolean2	boolean
    //   53	327	8	localObject1	Object
    //   1671	1	8	localIOException1	IOException
    //   2861	322	8	localObject2	Object
    //   3761	1	8	localObject3	Object
    //   3769	1	8	localObject4	Object
    //   3782	1	8	localIOException2	IOException
    //   91	3514	9	localFile1	File
    //   101	3483	10	localFile2	File
    //   377	2860	11	i1	int
    //   384	1269	12	i2	int
    //   473	3313	13	bool1	boolean
    //   318	3456	14	bool2	boolean
    //   479	3297	15	bool3	boolean
    //   2894	602	16	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   320	327	1671	java/io/IOException
    //   332	386	1671	java/io/IOException
    //   426	454	1671	java/io/IOException
    //   1640	1668	1671	java/io/IOException
    //   200	313	2861	finally
    //   313	320	2861	finally
    //   764	775	2861	finally
    //   320	327	3761	finally
    //   332	386	3761	finally
    //   426	454	3761	finally
    //   1640	1668	3761	finally
    //   1680	1686	3769	finally
    //   200	313	3782	java/io/IOException
    //   313	320	3782	java/io/IOException
    //   764	775	3782	java/io/IOException
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "image_upload";
    }
    if (!FileUtils.b(paramString1)) {
      try
      {
        if (!FileUtils.a(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.e(str, 2, paramString3 + ",filePath not exist,filePath=" + paramString1);
          }
          throw new RuntimeException(paramString3 + " file not exists,path=" + paramString1);
        }
      }
      catch (Exception paramString2)
      {
        paramString2 = AbstractImageDownloader.a(paramString2);
        if (!FileUtils.a(paramString1))
        {
          a(paramInt, 1, paramContext, false, "report_sendphoto_file_error", paramString2);
          return false;
          if (QLog.isColorLevel()) {
            QLog.e(str, 2, paramString3 + ",filePath size is 0,filePath=" + paramString1);
          }
          throw new RuntimeException(paramString3 + " file size==0,path=" + paramString1);
        }
        a(paramInt, 2, paramContext, false, "report_sendphoto_file_error", paramString2);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(str, 2, paramString3 + ",filePath not exist,filePath=" + paramString1);
    }
    a(paramInt, 0, paramContext, true, "report_sendphoto_file_error");
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, ImageInfo paramImageInfo, int paramInt)
  {
    paramContext = new File(paramString2);
    FileUtils.a(new File(paramString1), paramContext);
    return true;
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 375	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 1156	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 735	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 663	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_3
    //   20: invokevirtual 1159	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_3
    //   27: invokevirtual 748	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 663	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_2
    //   39: invokevirtual 1162	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 751	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: new 828	java/io/FileOutputStream
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getstatic 835	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   65: iload_1
    //   66: aload_3
    //   67: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   70: pop
    //   71: aload_3
    //   72: astore_2
    //   73: aload_3
    //   74: invokevirtual 1187	java/io/FileOutputStream:flush	()V
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_2
    //   106: goto -13 -> 93
    //   109: astore_0
    //   110: aload_3
    //   111: astore_2
    //   112: goto -22 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramBitmap	Bitmap
    //   0	115	1	paramInt	int
    //   0	115	2	paramFile	File
    //   11	100	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   50	59	87	java/io/IOException
    //   61	71	92	finally
    //   73	77	92	finally
    //   90	92	92	finally
    //   50	59	103	finally
    //   61	71	109	java/io/IOException
    //   73	77	109	java/io/IOException
  }
  
  public static boolean a(Bitmap paramBitmap, File paramFile)
  {
    return a(paramBitmap, 100, paramFile);
  }
  
  public static boolean a(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2)
  {
    return a(paramExifInterface1, paramExifInterface2, true);
  }
  
  public static boolean a(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2, boolean paramBoolean)
  {
    if ((paramExifInterface1 == null) || (paramExifInterface2 == null)) {
      return false;
    }
    String str1 = paramExifInterface1.getAttribute("DateTime");
    String str2 = paramExifInterface1.getAttribute("Flash");
    String str3 = paramExifInterface1.getAttribute("FocalLength");
    String str4 = paramExifInterface1.getAttribute("GPSAltitude");
    String str5 = paramExifInterface1.getAttribute("GPSAltitudeRef");
    String str6 = paramExifInterface1.getAttribute("GPSDateStamp");
    String str7 = paramExifInterface1.getAttribute("GPSLatitude");
    String str8 = paramExifInterface1.getAttribute("GPSLatitudeRef");
    String str9 = paramExifInterface1.getAttribute("GPSLongitude");
    String str10 = paramExifInterface1.getAttribute("GPSLongitudeRef");
    String str11 = paramExifInterface1.getAttribute("GPSProcessingMethod");
    String str12 = paramExifInterface1.getAttribute("GPSTimeStamp");
    String str13 = paramExifInterface1.getAttribute("ImageLength");
    String str14 = paramExifInterface1.getAttribute("ImageWidth");
    String str15 = paramExifInterface1.getAttribute("ISOSpeedRatings");
    String str16 = paramExifInterface1.getAttribute("Make");
    String str17 = paramExifInterface1.getAttribute("Model");
    String str18 = paramExifInterface1.getAttribute("WhiteBalance");
    paramExifInterface1 = paramExifInterface1.getAttribute("UserComment");
    if (str1 != null) {
      paramExifInterface2.setAttribute("DateTime", str1);
    }
    if (str2 != null) {
      paramExifInterface2.setAttribute("Flash", str2);
    }
    if (str3 != null) {
      paramExifInterface2.setAttribute("FocalLength", str3);
    }
    if (str4 != null) {
      paramExifInterface2.setAttribute("GPSAltitude", str4);
    }
    if (str5 != null) {
      paramExifInterface2.setAttribute("GPSAltitudeRef", str5);
    }
    if (str6 != null) {
      paramExifInterface2.setAttribute("GPSDateStamp", str6);
    }
    if (str7 != null) {
      paramExifInterface2.setAttribute("GPSLatitude", str7);
    }
    if (str8 != null) {
      paramExifInterface2.setAttribute("GPSLatitudeRef", str8);
    }
    if (str9 != null) {
      paramExifInterface2.setAttribute("GPSLongitude", str9);
    }
    if (str10 != null) {
      paramExifInterface2.setAttribute("GPSLongitudeRef", str10);
    }
    if (str11 != null) {
      paramExifInterface2.setAttribute("GPSProcessingMethod", str11);
    }
    if (str12 != null) {
      paramExifInterface2.setAttribute("GPSTimeStamp", str12);
    }
    if (str13 != null) {
      paramExifInterface2.setAttribute("ImageLength", str13);
    }
    if (str14 != null) {
      paramExifInterface2.setAttribute("ImageWidth", str14);
    }
    if (str15 != null) {
      paramExifInterface2.setAttribute("ISOSpeedRatings", str15);
    }
    if (str16 != null) {
      paramExifInterface2.setAttribute("Make", str16);
    }
    if (str17 != null) {
      paramExifInterface2.setAttribute("Model", str17);
    }
    if (str18 != null) {
      paramExifInterface2.setAttribute("WhiteBalance", str18);
    }
    if (paramExifInterface1 != null) {
      paramExifInterface2.setAttribute("UserComment", paramExifInterface1);
    }
    try
    {
      paramExifInterface2.saveAttributes();
      return true;
    }
    catch (Exception paramExifInterface1)
    {
      a("Failed to save EXIF. " + paramExifInterface1.getMessage());
    }
    return false;
  }
  
  public static boolean a(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[10];
    paramFile.read(arrayOfByte);
    if ((arrayOfByte[0] != 71) || (arrayOfByte[1] != 73) || (arrayOfByte[2] != 70))
    {
      paramFile.close();
      return false;
    }
    paramFile.close();
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (!FileUtils.b(paramString)) {}
    for (;;)
    {
      return false;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (OutOfMemoryError paramString) {}
    }
    return false;
  }
  
  public static boolean a(String paramString, double paramDouble1, double paramDouble2)
  {
    if ((paramString != null) && (!JpegExifReader.isCrashJpeg(paramString))) {}
    for (;;)
    {
      try
      {
        ExifInterface localExifInterface = new ExifInterface(paramString);
        localExifInterface.setAttribute("GPSLatitude", a(paramDouble1));
        if (paramDouble1 > 0.0D)
        {
          paramString = "N";
          localExifInterface.setAttribute("GPSLatitudeRef", paramString);
          localExifInterface.setAttribute("GPSLongitude", a(paramDouble2));
          if (paramDouble2 > 0.0D)
          {
            paramString = "E";
            localExifInterface.setAttribute("GPSLongitudeRef", paramString);
            localExifInterface.saveAttributes();
            if (QLog.isDevelopLevel()) {
              QLog.d(p, 4, "[updateLBSExif]GPSLatitude = " + localExifInterface.getAttribute("GPSLatitude") + ", GPSLongitude = " + localExifInterface.getAttribute("GPSLongitude"));
            }
          }
          else
          {
            paramString = "W";
            continue;
          }
          return true;
        }
      }
      catch (NullPointerException paramString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(p, 4, "[updateLBSExif] failed");
        }
        return false;
      }
      catch (IOException paramString)
      {
        continue;
      }
      paramString = "S";
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      if (FileUtils.b(paramString2)) {
        break label98;
      }
      bool = FileUtils.a(paramString2);
      if (bool) {
        break label66;
      }
      i1 = 9042;
      try
      {
        throw new RuntimeException("file not exists,path=" + paramString2);
      }
      catch (Exception paramString2) {}
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        boolean bool;
        label66:
        label98:
        String str;
        int i1 = 0;
      }
    }
    a(paramString1, false, AbstractImageDownloader.a(paramString2), String.valueOf(i1));
    return false;
    i1 = 9071;
    throw new RuntimeException("file size==0,path=" + paramString2);
    str = FileUtils.a(paramString2);
    if ((str != null) && (str.length() > 0))
    {
      bool = str.contains(FileUtils.i);
      if (bool)
      {
        i1 = 9072;
        throw new RuntimeException("file unKnownFileTypeMark" + paramString2);
      }
    }
    a(paramString1, true, null, null);
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (JpegExifReader.isCrashJpeg(paramString1))) {
      return false;
    }
    try
    {
      paramString1 = new ExifInterface(paramString1);
      paramString1.setAttribute("Orientation", paramString3);
      paramString1.saveAttributes();
      if (QLog.isDevelopLevel()) {
        QLog.d(p, 4, "[updateExif]tag=" + paramString2 + ", value=" + paramString3);
      }
      return true;
    }
    catch (NullPointerException paramString1)
    {
      return false;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  private static String[] a()
  {
    if (a != null) {
      return a;
    }
    String[] arrayOfString = RichMediaUtil.d();
    a = new String[arrayOfString.length + 1];
    int i1 = 0;
    while (i1 < arrayOfString.length)
    {
      a[i1] = arrayOfString[i1];
      i1 += 1;
    }
    a[(a.length - 1)] = p;
    return a;
  }
  
  public static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i3 = 1;
    int i2 = 1;
    int i1 = i2;
    if (paramInt1 != 0)
    {
      i1 = i2;
      if (paramInt2 != 0)
      {
        i1 = i2;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i1 = i2;
        }
      }
    }
    return i1;
    label43:
    float f1 = paramOptions.outWidth * paramOptions.outHeight / (paramInt1 * paramInt2);
    paramInt1 = i3;
    for (;;)
    {
      i1 = paramInt1;
      if (f1 <= 1.0F) {
        break;
      }
      paramInt1 *= 2;
      f1 /= 4.0F;
    }
  }
  
  public static int b(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    paramInt1 = Math.min((int)Math.round(i1 / paramInt1), (int)Math.round(i2 / paramInt2));
    if (paramInt1 < 1) {
      return 1;
    }
    return paramInt1;
  }
  
  public static int b(String paramString)
  {
    return JpegExifReader.getRotationDegree(paramString);
  }
  
  private static long b(InputStream paramInputStream)
  {
    try
    {
      int i1;
      do
      {
        for (;;)
        {
          i1 = paramInputStream.read();
          if (i1 == -1) {
            break label132;
          }
          if (i1 == 255)
          {
            i1 = paramInputStream.read();
            if ((i1 >= 192) && (i1 <= 195))
            {
              paramInputStream.skip(3L);
              i1 = paramInputStream.read();
              int i2 = paramInputStream.read();
              int i3 = paramInputStream.read();
              return (paramInputStream.read() | i3 << 8) * (i1 << 8 | i2);
            }
            if ((i1 == 0) || (i1 == 217) || (i1 == 216)) {
              break;
            }
            paramInputStream.skip((paramInputStream.read() << 8 | paramInputStream.read()) - 2);
          }
        }
      } while (i1 != -1);
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      return -1L;
    }
    label132:
    return -1L;
  }
  
  public static Bitmap b()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultPhoneContactFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130838593);
      if ((localBitmap1 != null) && (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)) {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultPhoneContactFace", localBitmap1);
      }
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        QLog.d(p, 2, "getDefaultPhoneContactBitmap, bitmap=" + localBitmap1);
        localBitmap2 = localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap b(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt == 102)
    {
      localObject2 = localObject1;
      if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
        localObject2 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultDataLineFace");
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130840319);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
          {
            BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultDataLineFace", localObject2, (byte)0);
            localObject1 = localObject2;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return (Bitmap)localObject1;
            localObject1 = localObject3;
          } while (paramInt != 107);
          if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
            localObject2 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultDataLineFaceIpad");
          }
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject2 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130840317);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache == null);
    BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultDataLineFaceIpad", localObject2, (byte)0);
    return (Bitmap)localObject2;
  }
  
  public static Bitmap b(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, ArrayList paramArrayList)
  {
    int i2 = paramInt1 * paramInt2;
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfInt[i1] = -2631723;
      i1 += 1;
    }
    i1 = (int)(3.0F * paramFloat);
    i2 = (int)(2.0F * paramFloat);
    int i3 = (int)(20.0F * paramFloat);
    return b(paramInt1, paramInt2, paramFloat, arrayOfInt, -2631723, i1, i2, i3, i3, paramInt3, paramInt4, paramArrayList);
  }
  
  private static Bitmap b(int paramInt1, int paramInt2, float paramFloat, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, ArrayList paramArrayList)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    if (paramArrayList != null)
    {
      localBitmap1 = localBitmap2;
      if (paramArrayList.size() > 0)
      {
        localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localBitmap2.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
        paramArrayOfInt = new Canvas(localBitmap2);
        paramArrayList = paramArrayList.iterator();
        paramInt1 = 0;
        for (;;)
        {
          localBitmap1 = localBitmap2;
          if (!paramArrayList.hasNext()) {
            break;
          }
          localBitmap1 = (Bitmap)paramArrayList.next();
          a(localBitmap1, paramArrayOfInt, paramInt1 % 3 * (paramInt6 + paramInt5) + paramInt4, paramInt1 / 3 * (paramInt7 + paramInt5) + paramInt4, localBitmap1.getWidth() / paramInt8, paramInt3);
          paramInt1 += 1;
        }
      }
    }
    return localBitmap1;
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int i4;
    int i1;
    int i2;
    if (paramBitmap != null)
    {
      i3 = paramBitmap.getWidth();
      i4 = paramBitmap.getHeight();
      if (i3 <= i4) {
        break label67;
      }
      i1 = i4;
      if (i3 <= i4) {
        break label73;
      }
      i2 = (i3 - i4) / 2;
      label43:
      if (i3 <= i4) {
        break label78;
      }
    }
    label67:
    label73:
    label78:
    for (int i3 = 0;; i3 = (i4 - i3) / 2)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, i2, i3, i1, i1, null, false);
      return localBitmap;
      i1 = i3;
      break;
      i2 = 0;
      break label43;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    double d2 = Math.toRadians(paramFloat);
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    double d1 = Math.abs(Math.cos(d2));
    d2 = Math.abs(Math.sin(d2));
    int i3 = (int)(i2 * d2 + i1 * d1);
    int i4 = (int)(d2 * i1 + d1 * i2);
    float f1 = (i3 - i1) / 2.0F;
    float f2 = (i4 - i2) / 2.0F;
    Bitmap localBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.rotate(paramFloat, i3 / 2.0F, i4 / 2.0F);
    localCanvas.drawBitmap(paramBitmap, f1, f2, null);
    return localBitmap;
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(BaseApplicationImpl.a().getResources().getDisplayMetrics().densityDpi);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {
      return (Bitmap)localObject2;
    }
    localObject2 = new Matrix();
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    float f1 = paramInt / (Math.max(i1, i2) * 1.0F);
    if ((f1 != 1.0F) && (f1 > 0.0F)) {}
    for (;;)
    {
      try
      {
        ((Matrix)localObject2).postScale(f1, f1);
        localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, (Matrix)localObject2, true);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        a("compress :" + localException.getMessage());
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        a("compress :  scaleBitmap OOM");
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (paramBitmap == null) {
          break;
        }
        localObject2 = localObject1;
        if (paramBitmap.isRecycled()) {
          break;
        }
        localObject2 = localObject1;
        if (paramBitmap.equals(localObject1)) {
          break;
        }
        paramBitmap.recycle();
        return (Bitmap)localObject1;
      }
      return paramBitmap;
      localObject1 = null;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f2 = BaseApplicationImpl.a().getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    i1 = (paramInt1 + paramInt2) / 2;
    if (i1 < 35) {
      i1 = (int)(2.0F * f1);
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f1);
      paramInt2 = (int)(f1 * paramInt2);
      return a(paramBitmap, i1, paramInt1, paramInt2);
      if (i1 < 50) {
        i1 = (int)(3.0F * f1);
      } else if (i1 < 64) {
        i1 = (int)(5.0F * f1);
      } else {
        i1 = (int)(6.0F * f1);
      }
    }
  }
  
  /* Error */
  public static Bitmap b(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore 4
    //   10: aload_0
    //   11: ifnull +14 -> 25
    //   14: aload_0
    //   15: invokevirtual 741	java/lang/String:length	()I
    //   18: ifne +10 -> 28
    //   21: aload 5
    //   23: astore 4
    //   25: aload 4
    //   27: areturn
    //   28: new 668	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 681	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 1526	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   41: astore 4
    //   43: new 104	android/graphics/BitmapFactory$Options
    //   46: dup
    //   47: invokespecial 105	android/graphics/BitmapFactory$Options:<init>	()V
    //   50: astore 7
    //   52: aload 7
    //   54: iconst_1
    //   55: putfield 108	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   58: aload 4
    //   60: aconst_null
    //   61: aload 7
    //   63: invokestatic 1530	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: pop
    //   67: aload 7
    //   69: aload 7
    //   71: iload_1
    //   72: iload_2
    //   73: invokestatic 1532	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   76: putfield 387	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   79: aload 7
    //   81: iconst_0
    //   82: putfield 108	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   85: aload 7
    //   87: getstatic 561	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   90: putfield 674	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   93: aload_0
    //   94: aload 7
    //   96: invokestatic 391	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   99: astore_0
    //   100: aload_0
    //   101: ifnonnull +26 -> 127
    //   104: aload 6
    //   106: astore_0
    //   107: aload_0
    //   108: astore 4
    //   110: aload_3
    //   111: ifnull -86 -> 25
    //   114: aload_3
    //   115: invokevirtual 1533	java/io/FileInputStream:close	()V
    //   118: aload_0
    //   119: areturn
    //   120: astore_3
    //   121: aload_3
    //   122: invokevirtual 847	java/io/IOException:printStackTrace	()V
    //   125: aload_0
    //   126: areturn
    //   127: goto -20 -> 107
    //   130: astore_0
    //   131: aload 5
    //   133: astore 4
    //   135: aload_3
    //   136: ifnull -111 -> 25
    //   139: aload_3
    //   140: invokevirtual 1533	java/io/FileInputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 847	java/io/IOException:printStackTrace	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_0
    //   155: aload 5
    //   157: astore 4
    //   159: aload_0
    //   160: ifnull -135 -> 25
    //   163: aload_0
    //   164: invokevirtual 1533	java/io/FileInputStream:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 847	java/io/IOException:printStackTrace	()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 1533	java/io/FileInputStream:close	()V
    //   187: aload_0
    //   188: athrow
    //   189: astore_3
    //   190: aload_3
    //   191: invokevirtual 847	java/io/IOException:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: astore_0
    //   198: goto -19 -> 179
    //   201: astore_0
    //   202: aload_3
    //   203: astore_0
    //   204: goto -49 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramString	String
    //   0	207	1	paramInt1	int
    //   0	207	2	paramInt2	int
    //   36	79	3	localFileInputStream	FileInputStream
    //   120	20	3	localIOException1	IOException
    //   178	6	3	localObject1	Object
    //   189	14	3	localIOException2	IOException
    //   8	150	4	localObject2	Object
    //   4	152	5	localObject3	Object
    //   1	104	6	localObject4	Object
    //   50	45	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   114	118	120	java/io/IOException
    //   79	100	130	java/lang/OutOfMemoryError
    //   139	143	145	java/io/IOException
    //   28	37	152	java/lang/Exception
    //   163	167	169	java/io/IOException
    //   28	37	176	finally
    //   183	187	189	java/io/IOException
    //   37	79	197	finally
    //   79	100	197	finally
    //   37	79	201	java/lang/Exception
    //   79	100	201	java/lang/Exception
  }
  
  public static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageUtil.ScalingLogic paramScalingLogic)
  {
    if (paramScalingLogic == ImageUtil.ScalingLogic.FIT)
    {
      float f1 = paramInt1 / paramInt2;
      if (f1 > paramInt3 / paramInt4) {
        return new Rect(0, 0, paramInt3, (int)(paramInt3 / f1));
      }
      return new Rect(0, 0, (int)(f1 * paramInt4), paramInt4);
    }
    return new Rect(0, 0, paramInt3, paramInt4);
  }
  
  public static Drawable b()
  {
    return new BitmapDrawable(a());
  }
  
  public static Drawable b(int paramInt)
  {
    return new BitmapDrawable(b(paramInt));
  }
  
  public static String b(Context paramContext, Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    paramContext = c(paramContext, paramUri);
    paramUri = paramContext.substring(paramContext.lastIndexOf("/") + 1);
    return AppConstants.bj + "photo/" + paramContext.hashCode() + paramUri;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    Object localObject = AppConstants.bj + "thumb2/";
    if (paramString.startsWith((String)localObject)) {}
    do
    {
      return paramString;
      paramContext = paramString.substring(paramString.lastIndexOf("/") + 1);
      paramContext = (String)localObject + paramString.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramString = paramContext;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramContext;
  }
  
  public static String b(Context paramContext, String paramString, int paramInt)
  {
    String str = AppConstants.bj + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    int i2 = 600;
    int i1 = 800;
    try
    {
      a(paramContext, paramString, str, 600, 800);
      int i3 = 0;
      for (;;)
      {
        localObject1 = new File(str);
        if ((localObject1 == null) || (((File)localObject1).length() <= paramInt) || (i3 >= 3)) {
          break;
        }
        i3 += 1;
        i2 -= 100;
        i1 -= 100;
        a(paramContext, paramString, str, Math.max(100, i2), Math.max(100, i1));
      }
      localObject2 = a(paramContext, Uri.parse(paramString));
    }
    catch (Exception paramContext)
    {
      a("compressImageForGroup exception", paramContext);
      return paramString;
    }
    Object localObject1 = a(paramContext, Uri.parse(str));
    Object localObject2 = new File((String)localObject2);
    if (((File)localObject2).exists()) {
      ((File)localObject2).renameTo(new File((String)localObject1));
    } else {
      a(paramContext, str, (String)localObject1, 160, 160);
    }
    return str;
  }
  
  /* Error */
  private static String b(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: aload_1
    //   3: invokestatic 114	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_2
    //   14: invokestatic 938	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   17: astore_1
    //   18: new 828	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_0
    //   28: getstatic 835	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   31: bipush 100
    //   33: iload_3
    //   34: invokestatic 180	java/lang/Math:min	(II)I
    //   37: aload_1
    //   38: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: pop
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: ifnull +9 -> 54
    //   48: aload_1
    //   49: invokevirtual 842	java/io/OutputStream:close	()V
    //   52: aload_2
    //   53: astore_0
    //   54: aload_0
    //   55: areturn
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +49 -> 109
    //   63: aload_1
    //   64: invokevirtual 842	java/io/OutputStream:close	()V
    //   67: aconst_null
    //   68: astore_0
    //   69: goto -15 -> 54
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: goto -21 -> 54
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 842	java/io/OutputStream:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: aload_2
    //   93: astore_0
    //   94: goto -40 -> 54
    //   97: astore_1
    //   98: goto -9 -> 89
    //   101: astore_0
    //   102: goto -21 -> 81
    //   105: astore_0
    //   106: goto -47 -> 59
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -57 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInputStream	InputStream
    //   0	114	1	paramOptions	BitmapFactory.Options
    //   0	114	2	paramString	String
    //   0	114	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   18	27	56	java/lang/Exception
    //   63	67	72	java/io/IOException
    //   18	27	78	finally
    //   48	52	91	java/io/IOException
    //   85	89	97	java/io/IOException
    //   27	42	101	finally
    //   27	42	105	java/lang/Exception
  }
  
  /* Error */
  private static void b(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc_w 1008
    //   5: new 153	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 1562
    //   15: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload 7
    //   20: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 1012
    //   26: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 4
    //   42: iconst_1
    //   43: putfield 1564	com/tencent/mobileqq/activity/photo/ImageInfo:i	Z
    //   46: aload_2
    //   47: invokevirtual 378	java/io/File:getPath	()Ljava/lang/String;
    //   50: invokestatic 1224	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   53: astore 12
    //   55: getstatic 1047	com/tencent/common/config/AppSetting:d	I
    //   58: i2l
    //   59: lstore 14
    //   61: aload 4
    //   63: getfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   66: ifeq +8 -> 74
    //   69: aload 12
    //   71: ifnonnull +379 -> 450
    //   74: aload 4
    //   76: ldc_w 1008
    //   79: ldc_w 1566
    //   82: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   85: lload 14
    //   87: lstore 16
    //   89: iload 5
    //   91: sipush 1001
    //   94: if_icmpne +52 -> 146
    //   97: lload 14
    //   99: lstore 16
    //   101: aload_1
    //   102: ifnull +44 -> 146
    //   105: lload 14
    //   107: lstore 16
    //   109: aload_1
    //   110: instanceof 399
    //   113: ifeq +33 -> 146
    //   116: lload 14
    //   118: lstore 16
    //   120: aload_1
    //   121: checkcast 399	com/tencent/mobileqq/app/BaseActivity
    //   124: invokevirtual 403	com/tencent/mobileqq/app/BaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   127: checkcast 405	com/tencent/mobileqq/app/QQAppInterface
    //   130: aload 4
    //   132: getfield 1135	com/tencent/mobileqq/activity/photo/ImageInfo:c	Ljava/lang/String;
    //   135: invokevirtual 1137	com/tencent/mobileqq/app/QQAppInterface:b	(Ljava/lang/String;)Z
    //   138: ifeq +8 -> 146
    //   141: ldc2_w 1072
    //   144: lstore 16
    //   146: iload 5
    //   148: ifne +232 -> 380
    //   151: aload_2
    //   152: invokevirtual 844	java/io/File:length	()J
    //   155: ldc2_w 1072
    //   158: lcmp
    //   159: ifle +221 -> 380
    //   162: iconst_1
    //   163: istore 18
    //   165: iload 5
    //   167: sipush 1001
    //   170: if_icmpne +216 -> 386
    //   173: aload_2
    //   174: invokevirtual 844	java/io/File:length	()J
    //   177: lload 16
    //   179: lcmp
    //   180: ifle +206 -> 386
    //   183: iconst_1
    //   184: istore 19
    //   186: iload 5
    //   188: iconst_1
    //   189: if_icmpeq +11 -> 200
    //   192: iload 5
    //   194: sipush 3000
    //   197: if_icmpne +195 -> 392
    //   200: aload_2
    //   201: invokevirtual 844	java/io/File:length	()J
    //   204: ldc2_w 1072
    //   207: lcmp
    //   208: ifle +184 -> 392
    //   211: iconst_1
    //   212: istore 20
    //   214: iload 18
    //   216: ifne +13 -> 229
    //   219: iload 19
    //   221: ifne +8 -> 229
    //   224: iload 20
    //   226: ifeq +172 -> 398
    //   229: aload 4
    //   231: ldc_w 1008
    //   234: new 153	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 1568
    //   244: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_2
    //   248: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: ldc_w 1570
    //   254: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: iload 18
    //   259: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   262: ldc_w 1572
    //   265: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: iload 19
    //   270: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   273: ldc_w 1574
    //   276: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: iload 20
    //   281: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   284: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   290: iload_0
    //   291: aload_1
    //   292: aload_2
    //   293: aload_3
    //   294: aload 4
    //   296: iload 5
    //   298: iload 6
    //   300: iload 7
    //   302: iload 8
    //   304: iload 9
    //   306: invokestatic 1350	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   309: return
    //   310: astore 10
    //   312: new 153	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 1576
    //   322: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_2
    //   326: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   335: aconst_null
    //   336: astore 12
    //   338: aload_1
    //   339: invokestatic 802	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)Z
    //   342: ifeq +18 -> 360
    //   345: aload 4
    //   347: iconst_1
    //   348: putfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   351: aload 4
    //   353: iconst_0
    //   354: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   357: goto -302 -> 55
    //   360: iload_0
    //   361: aload_1
    //   362: aload_2
    //   363: aload_3
    //   364: aload 4
    //   366: iload 5
    //   368: iload 6
    //   370: iload 7
    //   372: iload 8
    //   374: iload 9
    //   376: invokestatic 1350	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   379: return
    //   380: iconst_0
    //   381: istore 18
    //   383: goto -218 -> 165
    //   386: iconst_0
    //   387: istore 19
    //   389: goto -203 -> 186
    //   392: iconst_0
    //   393: istore 20
    //   395: goto -181 -> 214
    //   398: aload 4
    //   400: iconst_1
    //   401: putfield 419	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   404: aload 4
    //   406: iconst_0
    //   407: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   410: iload 5
    //   412: ifne +9 -> 421
    //   415: aload 4
    //   417: iconst_2
    //   418: putfield 425	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   421: aload 4
    //   423: ldc_w 1008
    //   426: new 153	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   433: ldc_w 1578
    //   436: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload_2
    //   440: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   449: return
    //   450: aload_1
    //   451: invokestatic 802	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)Z
    //   454: ifeq +279 -> 733
    //   457: bipush 80
    //   459: istore 13
    //   461: aconst_null
    //   462: astore 11
    //   464: new 828	java/io/FileOutputStream
    //   467: dup
    //   468: aload_3
    //   469: invokespecial 829	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   472: astore 10
    //   474: aload 10
    //   476: astore 11
    //   478: aload 4
    //   480: aload 12
    //   482: getstatic 835	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   485: iload 13
    //   487: aload 10
    //   489: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   492: putfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   495: aload 10
    //   497: astore 11
    //   499: aload 4
    //   501: iconst_1
    //   502: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   505: aload 10
    //   507: astore 11
    //   509: aload 4
    //   511: getfield 1031	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   514: ifeq +603 -> 1117
    //   517: aload 10
    //   519: astore 11
    //   521: aload 10
    //   523: invokestatic 1036	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   526: goto +591 -> 1117
    //   529: lload 14
    //   531: l2i
    //   532: istore 13
    //   534: aload 10
    //   536: astore 11
    //   538: ldc_w 1580
    //   541: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   544: aload 10
    //   546: astore 11
    //   548: aload_3
    //   549: invokevirtual 844	java/io/File:length	()J
    //   552: iload 13
    //   554: i2l
    //   555: lcmp
    //   556: ifle +555 -> 1111
    //   559: aload 10
    //   561: astore 11
    //   563: aload_2
    //   564: invokestatic 1057	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   567: istore 18
    //   569: iload 18
    //   571: ifne +540 -> 1111
    //   574: iconst_1
    //   575: istore 13
    //   577: aload 10
    //   579: ifnull +8 -> 587
    //   582: aload 10
    //   584: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   587: aload 12
    //   589: ifnull +519 -> 1108
    //   592: aload 12
    //   594: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   597: ifne +511 -> 1108
    //   600: aload 12
    //   602: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   605: iload 13
    //   607: ifeq -298 -> 309
    //   610: aload_3
    //   611: invokevirtual 663	java/io/File:exists	()Z
    //   614: ifeq +445 -> 1059
    //   617: aload_3
    //   618: invokevirtual 754	java/io/File:delete	()Z
    //   621: ifeq +438 -> 1059
    //   624: aload_3
    //   625: invokevirtual 751	java/io/File:createNewFile	()Z
    //   628: ifeq +431 -> 1059
    //   631: iconst_1
    //   632: istore 18
    //   634: aload 4
    //   636: ldc_w 1008
    //   639: new 153	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 1582
    //   649: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload_3
    //   653: invokevirtual 844	java/io/File:length	()J
    //   656: invokevirtual 811	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   659: ldc_w 1584
    //   662: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: iload 18
    //   667: invokevirtual 1041	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   670: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 1015	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   676: iload 18
    //   678: ifeq -369 -> 309
    //   681: aload 4
    //   683: iconst_0
    //   684: putfield 1019	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   687: aload 4
    //   689: iconst_0
    //   690: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   693: aload 4
    //   695: iconst_0
    //   696: putfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   699: iload_0
    //   700: aload_1
    //   701: aload_2
    //   702: aload_3
    //   703: aload 4
    //   705: iload 5
    //   707: iload 6
    //   709: iload 7
    //   711: iload 8
    //   713: iload 9
    //   715: invokestatic 1350	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   718: return
    //   719: astore_1
    //   720: ldc_w 1586
    //   723: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   726: aload 4
    //   728: iconst_0
    //   729: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   732: return
    //   733: bipush 70
    //   735: istore 13
    //   737: goto -276 -> 461
    //   740: ldc2_w 1072
    //   743: lstore 14
    //   745: goto -216 -> 529
    //   748: astore 10
    //   750: new 153	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   757: ldc_w 1588
    //   760: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload 10
    //   765: invokevirtual 1076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   768: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   777: goto -190 -> 587
    //   780: astore 10
    //   782: aconst_null
    //   783: astore 10
    //   785: ldc_w 1590
    //   788: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   791: aload 4
    //   793: iconst_0
    //   794: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   797: aload 4
    //   799: invokestatic 1065	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   802: putfield 1067	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   805: aload 10
    //   807: ifnull +8 -> 815
    //   810: aload 10
    //   812: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   815: aload_3
    //   816: ifnull +8 -> 824
    //   819: aload_3
    //   820: invokevirtual 754	java/io/File:delete	()Z
    //   823: pop
    //   824: aload 12
    //   826: ifnull +276 -> 1102
    //   829: aload 12
    //   831: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   834: ifne +268 -> 1102
    //   837: aload 12
    //   839: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   842: iconst_0
    //   843: istore 13
    //   845: goto -240 -> 605
    //   848: astore 10
    //   850: new 153	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   857: ldc_w 1588
    //   860: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 10
    //   865: invokevirtual 1076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   868: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   877: goto -62 -> 815
    //   880: astore 10
    //   882: aconst_null
    //   883: astore 10
    //   885: aload 10
    //   887: astore 11
    //   889: ldc_w 1592
    //   892: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   895: aload 4
    //   897: iconst_1
    //   898: putfield 421	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   901: aload 4
    //   903: iconst_0
    //   904: putfield 1033	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   907: aload 10
    //   909: ifnull +8 -> 917
    //   912: aload 10
    //   914: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   917: aload_3
    //   918: ifnull +8 -> 926
    //   921: aload_3
    //   922: invokevirtual 754	java/io/File:delete	()Z
    //   925: pop
    //   926: aload 12
    //   928: ifnull +174 -> 1102
    //   931: aload 12
    //   933: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   936: ifne +166 -> 1102
    //   939: aload 12
    //   941: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   944: iconst_0
    //   945: istore 13
    //   947: goto -342 -> 605
    //   950: astore 10
    //   952: new 153	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   959: ldc_w 1588
    //   962: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: aload 10
    //   967: invokevirtual 1076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   970: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   979: goto -62 -> 917
    //   982: astore_1
    //   983: iconst_0
    //   984: istore_0
    //   985: aload 11
    //   987: astore_2
    //   988: aload_2
    //   989: ifnull +7 -> 996
    //   992: aload_2
    //   993: invokevirtual 1044	java/io/FileOutputStream:close	()V
    //   996: iload_0
    //   997: ifeq +12 -> 1009
    //   1000: aload_3
    //   1001: ifnull +8 -> 1009
    //   1004: aload_3
    //   1005: invokevirtual 754	java/io/File:delete	()Z
    //   1008: pop
    //   1009: aload 12
    //   1011: ifnull +16 -> 1027
    //   1014: aload 12
    //   1016: invokevirtual 634	android/graphics/Bitmap:isRecycled	()Z
    //   1019: ifne +8 -> 1027
    //   1022: aload 12
    //   1024: invokevirtual 597	android/graphics/Bitmap:recycle	()V
    //   1027: aload_1
    //   1028: athrow
    //   1029: astore_2
    //   1030: new 153	java/lang/StringBuilder
    //   1033: dup
    //   1034: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1037: ldc_w 1588
    //   1040: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: aload_2
    //   1044: invokevirtual 1076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1047: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1056: goto -60 -> 996
    //   1059: iconst_0
    //   1060: istore 18
    //   1062: goto -428 -> 634
    //   1065: astore_1
    //   1066: aload 11
    //   1068: astore_2
    //   1069: iconst_0
    //   1070: istore_0
    //   1071: goto -83 -> 988
    //   1074: astore_1
    //   1075: aload 10
    //   1077: astore_2
    //   1078: iconst_0
    //   1079: istore_0
    //   1080: goto -92 -> 988
    //   1083: astore_1
    //   1084: aload 10
    //   1086: astore_2
    //   1087: iconst_1
    //   1088: istore_0
    //   1089: goto -101 -> 988
    //   1092: astore 11
    //   1094: goto -209 -> 885
    //   1097: astore 11
    //   1099: goto -314 -> 785
    //   1102: iconst_0
    //   1103: istore 13
    //   1105: goto -500 -> 605
    //   1108: goto -503 -> 605
    //   1111: iconst_0
    //   1112: istore 13
    //   1114: goto -537 -> 577
    //   1117: iload 5
    //   1119: iconst_1
    //   1120: if_icmpeq +19 -> 1139
    //   1123: iload 5
    //   1125: sipush 1001
    //   1128: if_icmpeq +11 -> 1139
    //   1131: iload 5
    //   1133: sipush 3000
    //   1136: if_icmpne -25 -> 1111
    //   1139: iload 5
    //   1141: sipush 1001
    //   1144: if_icmpne -404 -> 740
    //   1147: goto -618 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1150	0	paramInt1	int
    //   0	1150	1	paramContext	Context
    //   0	1150	2	paramFile1	File
    //   0	1150	3	paramFile2	File
    //   0	1150	4	paramImageInfo	ImageInfo
    //   0	1150	5	paramInt2	int
    //   0	1150	6	paramInt3	int
    //   0	1150	7	paramInt4	int
    //   0	1150	8	paramBoolean1	boolean
    //   0	1150	9	paramBoolean2	boolean
    //   310	1	10	localOutOfMemoryError1	OutOfMemoryError
    //   472	111	10	localFileOutputStream	FileOutputStream
    //   748	16	10	localIOException1	IOException
    //   780	1	10	localException1	Exception
    //   783	28	10	localObject1	Object
    //   848	16	10	localIOException2	IOException
    //   880	1	10	localOutOfMemoryError2	OutOfMemoryError
    //   883	30	10	localObject2	Object
    //   950	135	10	localIOException3	IOException
    //   462	605	11	localObject3	Object
    //   1092	1	11	localOutOfMemoryError3	OutOfMemoryError
    //   1097	1	11	localException2	Exception
    //   53	970	12	localBitmap	Bitmap
    //   459	654	13	i1	int
    //   59	685	14	l1	long
    //   87	91	16	l2	long
    //   163	898	18	bool1	boolean
    //   184	204	19	bool2	boolean
    //   212	182	20	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   46	55	310	java/lang/OutOfMemoryError
    //   610	631	719	java/io/IOException
    //   634	676	719	java/io/IOException
    //   681	718	719	java/io/IOException
    //   582	587	748	java/io/IOException
    //   464	474	780	java/lang/Exception
    //   810	815	848	java/io/IOException
    //   464	474	880	java/lang/OutOfMemoryError
    //   912	917	950	java/io/IOException
    //   464	474	982	finally
    //   992	996	1029	java/io/IOException
    //   478	495	1065	finally
    //   499	505	1065	finally
    //   509	517	1065	finally
    //   521	526	1065	finally
    //   538	544	1065	finally
    //   548	559	1065	finally
    //   563	569	1065	finally
    //   889	895	1065	finally
    //   785	805	1074	finally
    //   895	907	1083	finally
    //   478	495	1092	java/lang/OutOfMemoryError
    //   499	505	1092	java/lang/OutOfMemoryError
    //   509	517	1092	java/lang/OutOfMemoryError
    //   521	526	1092	java/lang/OutOfMemoryError
    //   538	544	1092	java/lang/OutOfMemoryError
    //   548	559	1092	java/lang/OutOfMemoryError
    //   563	569	1092	java/lang/OutOfMemoryError
    //   478	495	1097	java/lang/Exception
    //   499	505	1097	java/lang/Exception
    //   509	517	1097	java/lang/Exception
    //   521	526	1097	java/lang/Exception
    //   538	544	1097	java/lang/Exception
    //   548	559	1097	java/lang/Exception
    //   563	569	1097	java/lang/Exception
  }
  
  public static boolean b(File paramFile)
  {
    paramFile = a(new FileInputStream(paramFile));
    int i1 = paramFile.outHeight;
    int i2 = paramFile.outWidth;
    return (i1 > i2 * 3) || (i2 > i1 * 3);
  }
  
  public static boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new FileInputStream(paramString);
        boolean bool = "jpg".equals(a(paramString));
        if (bool) {
          bool = true;
        }
        bool = false;
      }
      catch (Exception paramString)
      {
        try
        {
          paramString.close();
          return bool;
        }
        catch (Exception paramString)
        {
          continue;
        }
        paramString = paramString;
        bool = false;
        a(paramString.toString());
        return bool;
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!paramString1.equals(paramString2))
      {
        bool1 = bool2;
        if (JpegExifReader.isCrashJpeg(paramString1)) {}
      }
    }
    try
    {
      paramString1 = new ExifInterface(paramString1);
      paramString2 = new ExifInterface(paramString2);
      int i1 = paramString1.getAttributeInt("Orientation", 0);
      paramString2.setAttribute("Orientation", i1 + "");
      paramString2.saveAttributes();
      bool1 = true;
    }
    catch (IOException paramString1)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(p, 2, "copyExif ", paramString1);
    }
    return bool1;
    return false;
  }
  
  private static int c(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i1;
    int i2;
    if (paramInt2 == -1)
    {
      i1 = 1;
      if (paramInt1 != -1) {
        break label60;
      }
      i2 = 128;
      label31:
      if (i2 >= i1) {
        break label84;
      }
    }
    label60:
    label84:
    do
    {
      return i1;
      i1 = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      i2 = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1)) {
        return 1;
      }
    } while (paramInt1 == -1);
    return i2;
  }
  
  public static int c(String paramString)
  {
    int i1 = 3;
    int i2 = JpegExifReader.readOrientation(paramString);
    if (i2 == 6) {
      i1 = 1;
    }
    do
    {
      return i1;
      if (i2 == 3) {
        return 2;
      }
    } while (i2 == 8);
    return 0;
  }
  
  public static Bitmap c()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultFace140_140");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130838583);
      if ((localBitmap1 != null) && (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)) {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultFace140_140", localBitmap1);
      }
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        QLog.d(p, 2, "getDefaultFaceBitmap140_140, bitmap=" + localBitmap1);
        localBitmap2 = localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap c(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    if (paramBitmap == null) {}
    for (;;)
    {
      return null;
      try
      {
        float f1 = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
        int i4 = (int)Math.ceil(paramBitmap.getWidth() / f1);
        int i5 = (int)Math.ceil(paramBitmap.getHeight() / f1);
        Bitmap localBitmap;
        int i1;
        int i3;
        if (i4 == paramInt1)
        {
          localBitmap = paramBitmap;
          if (i5 == paramInt2) {}
        }
        else
        {
          paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i4, i5, true);
          i1 = (i4 - paramInt1) / 2;
          if (i1 >= 0) {
            break label383;
          }
          i1 = 0;
          i3 = (i5 - paramInt2) / 2;
          if (i3 >= 0) {
            break label386;
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(p, 2, "ROUND_CORNER_DECODER scale = " + f1 + ", scaledWidth = " + i4 + ", scaledHeight = " + i5 + ", xTopLeft = " + i1 + ", yTopLeft = " + i2 + ", width = " + paramInt1 + ", height = " + paramInt2);
          }
          localBitmap = Bitmap.createBitmap(paramBitmap, i1, i2, paramInt1, paramInt2);
          paramBitmap.recycle();
          paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
          Canvas localCanvas = new Canvas(paramBitmap);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
          Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-16777216);
          localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
          localBitmap.recycle();
          return paramBitmap;
          label383:
          break;
          label386:
          i2 = i3;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    QLog.w(p, 2, "ROUND_CORNER_DECODER bitmap == null, ", paramBitmap);
    return null;
  }
  
  public static Drawable c()
  {
    return new BitmapDrawable(f());
  }
  
  /* Error */
  public static String c(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 687
    //   3: astore_3
    //   4: aload_3
    //   5: astore_2
    //   6: aload_1
    //   7: ifnull +38 -> 45
    //   10: aload_3
    //   11: astore_2
    //   12: ldc_w 687
    //   15: aload_1
    //   16: invokevirtual 1642	android/net/Uri:toString	()Ljava/lang/String;
    //   19: invokevirtual 1595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifne +23 -> 45
    //   25: aload_1
    //   26: invokevirtual 1645	android/net/Uri:getScheme	()Ljava/lang/String;
    //   29: astore_2
    //   30: ldc_w 1647
    //   33: aload_2
    //   34: invokevirtual 1595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +10 -> 47
    //   40: aload_1
    //   41: invokevirtual 1648	android/net/Uri:getPath	()Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: areturn
    //   47: ldc_w 1650
    //   50: aload_2
    //   51: invokevirtual 1595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifeq +119 -> 173
    //   57: aload_0
    //   58: invokevirtual 1654	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   61: aload_1
    //   62: iconst_1
    //   63: anewarray 191	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: ldc_w 1656
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: invokevirtual 1662	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore_0
    //   79: aload_0
    //   80: ldc_w 1656
    //   83: invokeinterface 1667 2 0
    //   88: istore 4
    //   90: aload_0
    //   91: invokeinterface 1670 1 0
    //   96: ifle +35 -> 131
    //   99: aload_0
    //   100: invokeinterface 1673 1 0
    //   105: pop
    //   106: aload_0
    //   107: iload 4
    //   109: invokeinterface 1676 2 0
    //   114: astore_1
    //   115: aload_1
    //   116: astore_2
    //   117: aload_0
    //   118: ifnull +11 -> 129
    //   121: aload_0
    //   122: invokeinterface 1677 1 0
    //   127: aload_1
    //   128: astore_2
    //   129: aload_2
    //   130: areturn
    //   131: ldc_w 687
    //   134: astore_1
    //   135: goto -20 -> 115
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull +44 -> 186
    //   145: aload_0
    //   146: invokeinterface 1677 1 0
    //   151: ldc_w 687
    //   154: astore_2
    //   155: goto -26 -> 129
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +9 -> 171
    //   165: aload_0
    //   166: invokeinterface 1677 1 0
    //   171: aload_1
    //   172: athrow
    //   173: aload_1
    //   174: invokevirtual 1642	android/net/Uri:toString	()Ljava/lang/String;
    //   177: areturn
    //   178: astore_1
    //   179: goto -18 -> 161
    //   182: astore_1
    //   183: goto -42 -> 141
    //   186: ldc_w 687
    //   189: astore_2
    //   190: goto -61 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   0	193	1	paramUri	Uri
    //   5	185	2	localObject	Object
    //   3	8	3	str	String
    //   88	20	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   57	79	138	java/lang/Exception
    //   57	79	158	finally
    //   79	115	178	finally
    //   79	115	182	java/lang/Exception
  }
  
  public static Bitmap d()
  {
    Object localObject = PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a(), BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 2);
    if ((localObject != null) && (((PublicAccountConfigUtil.PublicAccountConfigFolder)localObject).a() != null))
    {
      localObject = ((PublicAccountConfigUtil.PublicAccountConfigFolder)localObject).a();
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localObject).getBitmap();
      }
      return ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = PublicAccountConfigUtil.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 2);
    if ((localObject instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)localObject).getBitmap();
    }
    return ((BitmapDrawable)localObject).getBitmap();
  }
  
  public static Bitmap d(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      Rect localRect3 = new Rect(0, (int)(paramInt2 - paramFloat), paramInt1, (int)(paramInt2 + paramFloat));
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localCanvas.drawRect(localRect3, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Drawable d()
  {
    return new BitmapDrawable(g());
  }
  
  public static Bitmap e()
  {
    Object localObject = PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a(), BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 3);
    if ((localObject != null) && (((PublicAccountConfigUtil.PublicAccountConfigFolder)localObject).a() != null))
    {
      localObject = ((PublicAccountConfigUtil.PublicAccountConfigFolder)localObject).a();
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localObject).getBitmap();
      }
      return ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = PublicAccountConfigUtil.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 3);
    if ((localObject instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)localObject).getBitmap();
    }
    return ((BitmapDrawable)localObject).getBitmap();
  }
  
  public static Bitmap e(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i1 = paramBitmap.getWidth();
      int i2 = paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(i1 - paramInt1, i2 - paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, paramInt2, i1 - paramInt1, i2);
      Rect localRect2 = new Rect(0, 0, i1 - paramInt1, i2 - paramInt2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Drawable e()
  {
    return new BitmapDrawable(i());
  }
  
  public static Bitmap f()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultTroopFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = b(BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130838658), 50, 50);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
        {
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultTroopFace", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap g()
  {
    Object localObject1 = null;
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localObject1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultDiscusionFace");
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838260);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
      {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultDiscusionFace", localObject1);
        localObject2 = localObject1;
      }
    }
    return (Bitmap)localObject2;
  }
  
  public static Bitmap h()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultSystemIcon");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130843373);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
        {
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultSystemIcon", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap i()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://DefaultSubAccountFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplicationImpl.a().getResources(), 2130838605);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
        {
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://DefaultSubAccountFace", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\ImageUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */