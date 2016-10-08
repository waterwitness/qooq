package com.tencent.biz.common.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageUtil
{
  protected static int a = 0;
  protected static long a = 0L;
  protected static Bitmap a;
  static MediaScannerConnection a;
  protected static String a;
  protected static List a;
  protected static int b = 0;
  protected static String b;
  protected static List b;
  protected static final int c = 410;
  protected static String c;
  protected static final int d = 140;
  protected static String d;
  public static final int e = 6;
  protected static String e;
  private static final int f = -1;
  private static int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 7;
    jdField_b_of_type_Int = 10;
    jdField_b_of_type_JavaLangString = "ImageUtil";
  }
  
  public static final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i + 7) / 8 * 8;
    return paramInt2;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    int i;
    if (((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) || ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) || ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))))
    {
      a(SubString.a(paramString2, jdField_a_of_type_Int), SubString.a(paramString3, jdField_b_of_type_Int));
      i = 1;
    }
    do
    {
      do
      {
        return i;
        if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
          return 2;
        }
        i = j;
      } while (!TextUtils.isEmpty(paramString1));
      if (!TextUtils.isEmpty(paramString2)) {
        break;
      }
      i = j;
    } while (TextUtils.isEmpty(paramString3));
    a(SubString.a(paramString2, jdField_a_of_type_Int + 3), SubString.a(paramString3, jdField_b_of_type_Int + 4));
    return 3;
  }
  
  protected static Bitmap a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(410, 140, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(g);
    localPaint.setTextSize(32.0F);
    Iterator localIterator;
    int i;
    if (jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "drawType3 listTitleSeq:" + jdField_a_of_type_JavaUtilList.toString());
      }
      localIterator = jdField_a_of_type_JavaUtilList.iterator();
      i = 28;
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localCanvas.drawText((String)localIterator.next(), 0, i, localPaint);
        i += 38;
      }
    }
    int j = 28;
    if (jdField_b_of_type_JavaUtilList != null)
    {
      localPaint.setColor(Color.rgb(138, 138, 138));
      localPaint.setTextSize(24.0F);
      localIterator = jdField_b_of_type_JavaUtilList.iterator();
      i = j - 4;
      while (localIterator.hasNext())
      {
        localCanvas.drawText((String)localIterator.next(), 0, i, localPaint);
        i += 30;
      }
    }
    localCanvas.save(31);
    return localBitmap;
  }
  
  protected static Bitmap a(Bitmap paramBitmap)
  {
    int j = 0;
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(410, 140, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    paramBitmap = a(paramBitmap, 140, 140, 2, 6);
    int i = paramBitmap.getWidth();
    if (i == 140)
    {
      i = 0;
      localCanvas.drawBitmap(paramBitmap, i, 0.0F, null);
      localPaint.setColor(g);
      localPaint.setTextSize(32.0F);
      if (jdField_a_of_type_JavaUtilList != null) {
        break label186;
      }
      label104:
      if (jdField_a_of_type_JavaUtilList == null) {
        break label209;
      }
      paramBitmap = jdField_a_of_type_JavaUtilList.iterator();
      i = 28;
      label123:
      k = i;
      if (!paramBitmap.hasNext()) {
        break label213;
      }
      localCanvas.drawText((String)paramBitmap.next(), '', i, localPaint);
      if (j != 3) {
        break label199;
      }
      i += 50;
    }
    for (;;)
    {
      break label123;
      i = (140 - i) / 2;
      break;
      label186:
      j = jdField_a_of_type_JavaUtilList.size();
      break label104;
      label199:
      i += 38;
    }
    label209:
    int k = 28;
    label213:
    if (jdField_b_of_type_JavaUtilList != null)
    {
      localPaint.setColor(Color.rgb(138, 138, 138));
      localPaint.setTextSize(24.0F);
      paramBitmap = jdField_b_of_type_JavaUtilList.iterator();
      i = k - 4;
      if (paramBitmap.hasNext())
      {
        localCanvas.drawText((String)paramBitmap.next(), '', i, localPaint);
        if (j < 2) {
          i += 35;
        }
        for (;;)
        {
          break;
          i += 30;
        }
      }
    }
    localCanvas.save(31);
    return localBitmap;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject1;
    if (paramBitmap == null)
    {
      localObject1 = null;
      return (Bitmap)localObject1;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int i;
    if (j > k) {
      i = j;
    }
    for (;;)
    {
      localObject1 = paramBitmap;
      if (i <= paramInt) {
        break;
      }
      float f1 = paramInt / i;
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(f1, f1);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, (Matrix)localObject1, true);
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          paramBitmap.recycle();
        }
        return (Bitmap)localObject1;
        i = k;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_b_of_type_JavaLangString, 2, "scaleBitmap, OutOfMemoryError");
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i1 = paramInt1 - paramInt3 * 2;
    int n = paramInt2 - paramInt3 * 2;
    paramInt2 = paramBitmap.getWidth();
    paramInt1 = paramBitmap.getHeight();
    int j;
    int i;
    int m;
    int k;
    if (((paramInt1 > n) || (paramInt2 > i1)) && (paramInt2 != paramInt1)) {
      if (paramInt2 > paramInt1)
      {
        j = paramInt2 / 2 - paramInt1 / 2;
        i = paramInt2 / 2 + paramInt1 / 2;
        m = 0;
        k = paramInt1;
      }
    }
    for (;;)
    {
      if (paramInt2 > i1)
      {
        paramInt2 = i1;
        label85:
        if (paramInt1 <= n) {
          break label382;
        }
        paramInt1 = n;
      }
      label382:
      for (;;)
      {
        Object localObject = new Rect(j, m, i, k);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "srcRect:" + ((Rect)localObject).toString());
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, paramInt2, paramInt1);
        RectF localRectF = new RectF(localRect);
        float f1 = paramInt4;
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(paramBitmap, (Rect)localObject, localRect, localPaint);
        paramBitmap = Bitmap.createBitmap(paramInt3 * 2 + paramInt2, paramInt3 * 2 + paramInt1, Bitmap.Config.ARGB_8888);
        localObject = new Canvas(paramBitmap);
        ((Canvas)localObject).drawBitmap(localBitmap, localRect, new Rect(paramInt3, paramInt3, paramInt2 + paramInt3, paramInt1 + paramInt3), null);
        ((Canvas)localObject).save(31);
        localBitmap.recycle();
        return paramBitmap;
        k = paramInt1 / 2;
        m = paramInt2 / 2;
        i = paramInt1 / 2;
        j = paramInt2 / 2;
        m = k - m;
        k = i + j;
        j = 0;
        i = paramInt2;
        break;
        break label85;
      }
      j = 0;
      m = 0;
      k = paramInt1;
      i = paramInt2;
    }
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (new File(paramString).exists()) {
        localObject1 = BitmapFactory.decodeFile(paramString);
      }
      return (Bitmap)localObject1;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_b_of_type_JavaLangString, 2, "readImg OOM, fileName=" + paramString, localThrowable);
    }
    return null;
  }
  
  public static final Bitmap a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return (Bitmap)localObject;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if ((((BitmapFactory.Options)localObject).mCancel) || (((BitmapFactory.Options)localObject).outWidth == -1) || (((BitmapFactory.Options)localObject).outHeight == -1)) {
      return null;
    }
    if (i > j)
    {
      label72:
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      if (i > paramInt) {
        ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, -1, paramInt * paramInt);
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    }
    for (;;)
    {
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        i = ((BitmapFactory.Options)localObject).outWidth;
        j = ((BitmapFactory.Options)localObject).outHeight;
        if (i <= j) {
          break label161;
        }
        localObject = paramString;
        if (i <= paramInt) {
          break;
        }
        return a(paramString, paramInt);
      }
      catch (OutOfMemoryError paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_b_of_type_JavaLangString, 2, "scaleBitmap, OutOfMemoryError");
        return null;
      }
      i = j;
      break label72;
      label161:
      i = j;
    }
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    paramDrawable.setColorFilter(new LightingColorFilter(0, paramInt));
    return paramDrawable;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: ldc_w 324
    //   8: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +21 -> 32
    //   14: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +13 -> 30
    //   20: getstatic 40	com/tencent/biz/common/util/ImageUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   23: iconst_2
    //   24: ldc_w 330
    //   27: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aconst_null
    //   31: areturn
    //   32: new 243	java/io/File
    //   35: dup
    //   36: getstatic 337	com/tencent/mobileqq/app/AppConstants:bx	Ljava/lang/String;
    //   39: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 340	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload_3
    //   49: invokevirtual 343	java/io/File:canWrite	()Z
    //   52: ifne +21 -> 73
    //   55: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq -28 -> 30
    //   61: getstatic 40	com/tencent/biz/common/util/ImageUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   64: iconst_2
    //   65: ldc_w 345
    //   68: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aconst_null
    //   72: areturn
    //   73: new 108	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   80: getstatic 337	com/tencent/mobileqq/app/AppConstants:bx	Ljava/lang/String;
    //   83: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokestatic 350	com/tencent/mobileqq/transfile/AbsDownloader:c	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_3
    //   97: new 243	java/io/File
    //   100: dup
    //   101: aload_3
    //   102: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore 4
    //   107: aload 4
    //   109: invokevirtual 249	java/io/File:exists	()Z
    //   112: ifeq +5 -> 117
    //   115: aload_3
    //   116: areturn
    //   117: aload_1
    //   118: ldc_w 352
    //   121: invokevirtual 356	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   124: ifeq +106 -> 230
    //   127: aload_1
    //   128: bipush 44
    //   130: invokevirtual 359	java/lang/String:indexOf	(I)I
    //   133: istore 5
    //   135: iload 5
    //   137: ifle +211 -> 348
    //   140: aload_1
    //   141: iconst_0
    //   142: iload 5
    //   144: invokevirtual 363	java/lang/String:substring	(II)Ljava/lang/String;
    //   147: ldc_w 365
    //   150: invokevirtual 368	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   153: ifeq +195 -> 348
    //   156: aload_1
    //   157: iload 5
    //   159: invokevirtual 371	java/lang/String:substring	(I)Ljava/lang/String;
    //   162: iconst_0
    //   163: invokestatic 377	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   166: astore_0
    //   167: aload_0
    //   168: astore_1
    //   169: aload_1
    //   170: ifnonnull +80 -> 250
    //   173: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq -146 -> 30
    //   179: getstatic 40	com/tencent/biz/common/util/ImageUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   182: iconst_2
    //   183: ldc_w 379
    //   186: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_0
    //   192: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -165 -> 30
    //   198: getstatic 40	com/tencent/biz/common/util/ImageUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   201: iconst_2
    //   202: new 108	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 381
    //   212: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_0
    //   216: invokevirtual 382	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   219: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aconst_null
    //   229: areturn
    //   230: aload_0
    //   231: aload_1
    //   232: ldc_w 384
    //   235: aconst_null
    //   236: aload_2
    //   237: invokestatic 389	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   240: astore_0
    //   241: goto -74 -> 167
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_1
    //   247: goto -78 -> 169
    //   250: new 391	java/io/FileOutputStream
    //   253: dup
    //   254: aload 4
    //   256: invokespecial 394	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   259: astore_2
    //   260: aload_2
    //   261: astore_0
    //   262: aload_2
    //   263: aload_1
    //   264: invokevirtual 398	java/io/FileOutputStream:write	([B)V
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 401	java/io/FileOutputStream:close	()V
    //   275: aload_3
    //   276: areturn
    //   277: astore_0
    //   278: aconst_null
    //   279: astore_1
    //   280: aload_1
    //   281: astore_0
    //   282: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +15 -> 300
    //   288: aload_1
    //   289: astore_0
    //   290: getstatic 40	com/tencent/biz/common/util/ImageUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   293: iconst_2
    //   294: ldc_w 403
    //   297: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_1
    //   301: ifnull -271 -> 30
    //   304: aload_1
    //   305: invokevirtual 401	java/io/FileOutputStream:close	()V
    //   308: aconst_null
    //   309: areturn
    //   310: astore_0
    //   311: aconst_null
    //   312: areturn
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_1
    //   316: aload_1
    //   317: ifnull +7 -> 324
    //   320: aload_1
    //   321: invokevirtual 401	java/io/FileOutputStream:close	()V
    //   324: aload_0
    //   325: athrow
    //   326: astore_0
    //   327: goto -52 -> 275
    //   330: astore_1
    //   331: goto -7 -> 324
    //   334: astore_2
    //   335: aload_0
    //   336: astore_1
    //   337: aload_2
    //   338: astore_0
    //   339: goto -23 -> 316
    //   342: astore_0
    //   343: aload_2
    //   344: astore_1
    //   345: goto -65 -> 280
    //   348: aconst_null
    //   349: astore_0
    //   350: goto -183 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramContext	android.content.Context
    //   0	353	1	paramString	String
    //   0	353	2	paramBundle	android.os.Bundle
    //   42	234	3	localObject	Object
    //   105	150	4	localFile	File
    //   133	25	5	i	int
    // Exception table:
    //   from	to	target	type
    //   117	135	191	java/lang/OutOfMemoryError
    //   140	167	191	java/lang/OutOfMemoryError
    //   173	189	191	java/lang/OutOfMemoryError
    //   230	241	191	java/lang/OutOfMemoryError
    //   271	275	191	java/lang/OutOfMemoryError
    //   304	308	191	java/lang/OutOfMemoryError
    //   320	324	191	java/lang/OutOfMemoryError
    //   324	326	191	java/lang/OutOfMemoryError
    //   117	135	244	java/lang/Exception
    //   140	167	244	java/lang/Exception
    //   230	241	244	java/lang/Exception
    //   250	260	277	java/io/IOException
    //   304	308	310	java/io/IOException
    //   250	260	313	finally
    //   271	275	326	java/io/IOException
    //   320	324	330	java/io/IOException
    //   262	267	334	finally
    //   282	288	334	finally
    //   290	300	334	finally
    //   262	267	342	java/io/IOException
  }
  
  public static String a(Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    try
    {
      jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString();
      String str = jdField_a_of_type_JavaLangString + "/tmp/";
      try
      {
        Object localObject = new File(str);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
        localObject = MD5.toMD5(a(paramBitmap));
        localObject = "share_qq_" + (String)localObject + ".png";
        str = str + (String)localObject;
        localObject = new File(str);
        if (((File)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "saveFile:file.exists");
          }
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "generated file length:" + ((File)localObject).length());
            return str;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "saveFile:new image");
          }
          BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject));
          paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localBufferedOutputStream);
          localBufferedOutputStream.flush();
          localBufferedOutputStream.close();
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "generated file length:" + ((File)localObject).length());
            return str;
          }
        }
      }
      catch (IOException paramBitmap)
      {
        paramBitmap.printStackTrace();
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
      return localException;
    }
  }
  
  protected static void a(List paramList1, List paramList2)
  {
    int i = 1;
    switch (paramList1.size())
    {
    default: 
      if (paramList1.size() <= 3) {
        break;
      }
    }
    for (;;)
    {
      int j = paramList1.size();
      while (j > 3)
      {
        paramList1.remove(j - 1);
        j -= 1;
      }
      paramList1 = new ArrayList();
      if (paramList2.size() > 4)
      {
        paramList1.add(paramList2.get(0));
        paramList1.add(paramList2.get(1));
        paramList1.add(paramList2.get(2));
        paramList2 = (String)paramList2.get(3);
        paramList1.add(paramList2.substring(0, paramList2.length() - 3) + "...");
      }
      for (;;)
      {
        jdField_b_of_type_JavaUtilList = paramList1;
        return;
        paramList1.addAll(paramList2);
      }
      ArrayList localArrayList = new ArrayList();
      if (paramList2.size() > 2)
      {
        localArrayList.add(paramList2.get(0));
        paramList2 = (String)paramList2.get(1);
        localArrayList.add(paramList2.substring(0, paramList2.length() - 3) + "...");
      }
      for (;;)
      {
        jdField_a_of_type_JavaUtilList = paramList1;
        jdField_b_of_type_JavaUtilList = localArrayList;
        return;
        localArrayList.addAll(paramList2);
      }
      localArrayList = new ArrayList();
      if (paramList2.size() > 3)
      {
        localArrayList.add(paramList2.get(0));
        localArrayList.add(paramList2.get(1));
        paramList2 = (String)paramList2.get(2);
        localArrayList.add(paramList2.substring(0, paramList2.length() - 3) + "...");
      }
      for (;;)
      {
        jdField_a_of_type_JavaUtilList = paramList1;
        jdField_b_of_type_JavaUtilList = localArrayList;
        return;
        localArrayList.addAll(paramList2);
      }
      i = 0;
    }
    if (i != 0)
    {
      paramList2 = (String)paramList1.remove(paramList1.size() - 1);
      paramList1.add(paramList2.substring(0, paramList2.length() - 3) + "...");
    }
    jdField_a_of_type_JavaUtilList = paramList1;
  }
  
  public static byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 == -1)
    {
      i = 1;
      if (paramInt1 != -1) {
        break label60;
      }
      j = 128;
      label31:
      if (j >= i) {
        break label84;
      }
    }
    label60:
    label84:
    do
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1)) {
        return 1;
      }
    } while (paramInt1 == -1);
    return j;
  }
  
  protected static Bitmap b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    new Paint().setAntiAlias(true);
    paramBitmap = a(paramBitmap, 400, 400, 2, 6);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    localCanvas.save(31);
    return localBitmap;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\util\ImageUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */