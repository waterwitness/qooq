package com.tencent.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class BitmapUtils
{
  public static final int DEFAULT_COMPRESS_QUALITY = 90;
  private static final int DEFAULT_SIZE = 1000;
  private static final int DEFAULT_SIZE_SMALL = 500;
  private static final String[] IMAGE_PROJECTION = { "orientation" };
  private static final int INDEX_ORIENTATION = 0;
  private static final String[] PATH_PROJECTION = { "_data" };
  private static final String TAG = "BitmapUtils";
  private static final float[] mMatrixValues = new float[16];
  private static final float[] mTempMatrix = new float[32];
  private final Context context;
  
  public BitmapUtils(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  private static int computeInitialSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 < 0)
    {
      i = 1;
      if (paramInt1 >= 0) {
        break label58;
      }
      j = 128;
      label29:
      if (j >= i) {
        break label82;
      }
    }
    label58:
    label82:
    do
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label29;
      if ((paramInt2 < 0) && (paramInt1 < 0)) {
        return 1;
      }
    } while (paramInt1 < 0);
    return j;
  }
  
  public static int computeSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = computeInitialSampleSize(paramOptions, paramInt1, paramInt2);
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
  
  public static int computeSampleSizeLarger(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.max(paramInt1 / paramInt3, paramInt2 / paramInt3);
    if (paramInt1 <= 1) {
      return 1;
    }
    if (paramInt1 <= 8) {
      return prevPowerOf2(paramInt1);
    }
    return paramInt1 / 8 * 8;
  }
  
  public static int computeSampleSizeSmaller(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = 1000;
    if (paramBoolean) {
      k = 500;
    }
    int m = Math.max(paramInt1 / k, paramInt2 / k);
    if (m <= 8)
    {
      int i = 1;
      for (;;)
      {
        j = i;
        if (i >= m) {
          break;
        }
        i <<= 1;
      }
    }
    int j = (m + 7) / 8 * 8;
    while ((j > 0) && (Math.max(paramInt1 / j, paramInt2 / j) < k)) {
      j /= 2;
    }
    return j;
  }
  
  public static Bitmap createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, android.graphics.Matrix paramMatrix)
  {
    Canvas localCanvas = new Canvas();
    Object localObject2;
    Object localObject1;
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      localObject2 = Bitmap.createBitmap(paramInt3, paramInt4, paramBitmap.getConfig());
      localObject1 = null;
    }
    for (;;)
    {
      ((Bitmap)localObject2).setDensity(paramBitmap.getDensity());
      localCanvas.setBitmap((Bitmap)localObject2);
      localCanvas.drawBitmap(paramBitmap, new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), new RectF(0.0F, 0.0F, paramInt3, paramInt4), (Paint)localObject1);
      return (Bitmap)localObject2;
      localObject1 = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
      paramMatrix.mapRect((RectF)localObject1);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(Math.round(((RectF)localObject1).width()), Math.round(((RectF)localObject1).height()), paramBitmap.getConfig());
        localCanvas.translate(-((RectF)localObject1).left, -((RectF)localObject1).top);
        localCanvas.concat(paramMatrix);
        Paint localPaint = new Paint(2);
        localObject2 = localBitmap;
        localObject1 = localPaint;
        if (!paramMatrix.rectStaysRect())
        {
          localPaint.setAntiAlias(true);
          localObject2 = localBitmap;
          localObject1 = localPaint;
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    return null;
  }
  
  public static Bitmap createBitmapSmaller(Bitmap paramBitmap, float paramFloat, android.graphics.Matrix paramMatrix)
  {
    int i = Math.round(paramBitmap.getWidth() * paramFloat);
    int j = Math.round(paramBitmap.getHeight() * paramFloat);
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, j, getConfig(paramBitmap));
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(paramFloat, paramFloat);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramMatrix != null)
    {
      paramBitmap = createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramMatrix);
      localBitmap.recycle();
      return paramBitmap;
    }
    return localBitmap;
  }
  
  public static Bitmap createBitmapSmaller(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, android.graphics.Matrix paramMatrix)
  {
    Canvas localCanvas = new Canvas();
    if ((paramMatrix == null) || (paramMatrix.isIdentity())) {
      paramMatrix = Bitmap.createBitmap(Math.round(paramInt3 * paramFloat), Math.round(paramInt4 * paramFloat), paramBitmap.getConfig());
    }
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      localCanvas.setBitmap(paramMatrix);
      localCanvas.drawBitmap(paramBitmap, new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), new RectF(0.0F, 0.0F, Math.round(paramInt4 * paramFloat), Math.round(paramInt3 * paramFloat)), (Paint)localObject1);
      return paramMatrix;
      localObject2 = new RectF(0.0F, 0.0F, Math.round(paramInt4 * paramFloat), Math.round(paramInt3 * paramFloat));
      paramMatrix.mapRect((RectF)localObject2);
      localObject1 = Bitmap.createBitmap(Math.round(((RectF)localObject2).height()), Math.round(((RectF)localObject2).width()), paramBitmap.getConfig());
      localCanvas.scale(paramFloat, paramFloat);
      localCanvas.translate(-((RectF)localObject2).left, -((RectF)localObject2).top);
      localCanvas.concat(paramMatrix);
      localObject2 = new Paint(6);
      paramMatrix = (android.graphics.Matrix)localObject1;
    }
  }
  
  public static Bitmap cropCenter(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    localObject1 = null;
    i = 0;
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject1 = localObject2;
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject2;
      int j;
      for (;;) {}
    }
    j = i;
    localObject2 = localObject1;
    if (i == 0) {}
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      j = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        j = i;
        Object localObject3 = localObject1;
      }
    }
    if ((j == 0) || (localObject2 == null)) {
      return null;
    }
    localObject1 = new Canvas((Bitmap)localObject2);
    ((Canvas)localObject1).translate((paramInt1 - k) / 2, (paramInt2 - m) / 2);
    ((Canvas)localObject1).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(2));
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    LogUtil.d("BitmapUtils", "crop bitmap - " + (System.currentTimeMillis() - l));
    return (Bitmap)localObject2;
  }
  
  public static Bitmap cropFromTop(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int k = paramBitmap.getWidth();
    paramBitmap.getHeight();
    localObject1 = null;
    i = 0;
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject1 = localObject2;
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject2;
      int j;
      for (;;) {}
    }
    j = i;
    localObject2 = localObject1;
    if (i == 0) {}
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      j = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        j = i;
        Object localObject3 = localObject1;
      }
    }
    if (j == 0) {
      return null;
    }
    localObject1 = new Canvas((Bitmap)localObject2);
    ((Canvas)localObject1).translate((paramInt1 - k) / 2, 0.0F);
    ((Canvas)localObject1).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(2));
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    LogUtil.d("BitmapUtils", "crop bitmap - " + (System.currentTimeMillis() - l));
    return (Bitmap)localObject2;
  }
  
  public static Bitmap decodeBitmap(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    Paint localPaint = new Paint(6);
    localCanvas.drawBitmap(paramResources, new Rect(0, 0, paramResources.getWidth(), paramResources.getHeight()), new Rect(0, 0, paramInt2, paramInt3), localPaint);
    paramResources.recycle();
    return (Bitmap)localObject;
  }
  
  /* Error */
  private Bitmap decodeBitmapWithoutResize(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore 10
    //   5: iconst_m1
    //   6: istore 6
    //   8: aconst_null
    //   9: astore_2
    //   10: iload 6
    //   12: istore 7
    //   14: iload 6
    //   16: istore 8
    //   18: iload 6
    //   20: istore 9
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 281	com/tencent/util/BitmapUtils:getBitmapBounds	(Landroid/net/Uri;)Landroid/graphics/Rect;
    //   27: astore 4
    //   29: iload 6
    //   31: istore 7
    //   33: iload 6
    //   35: istore 8
    //   37: iload 6
    //   39: istore 9
    //   41: aload 4
    //   43: invokevirtual 283	android/graphics/Rect:width	()I
    //   46: istore 11
    //   48: iload 6
    //   50: istore 7
    //   52: iload 6
    //   54: istore 8
    //   56: iload 6
    //   58: istore 9
    //   60: aload 4
    //   62: invokevirtual 285	android/graphics/Rect:height	()I
    //   65: istore 12
    //   67: iload 6
    //   69: istore 7
    //   71: iload 6
    //   73: istore 8
    //   75: iload 6
    //   77: istore 9
    //   79: new 64	android/graphics/BitmapFactory$Options
    //   82: dup
    //   83: invokespecial 259	android/graphics/BitmapFactory$Options:<init>	()V
    //   86: astore 5
    //   88: iload 6
    //   90: iconst_m1
    //   91: if_icmpne +176 -> 267
    //   94: iload 6
    //   96: istore 7
    //   98: iload 6
    //   100: istore 8
    //   102: iload 6
    //   104: istore 9
    //   106: aload 5
    //   108: iload 11
    //   110: iload 12
    //   112: invokestatic 291	com/tencent/util/PhoneProperty:instance	()Lcom/tencent/util/PhoneProperty;
    //   115: invokevirtual 294	com/tencent/util/PhoneProperty:isUseSmallPicture	()Z
    //   118: invokestatic 296	com/tencent/util/BitmapUtils:computeSampleSizeSmaller	(IIZ)I
    //   121: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   124: iload 6
    //   126: istore 7
    //   128: iload 6
    //   130: istore 8
    //   132: iload 6
    //   134: istore 9
    //   136: aload 5
    //   138: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   141: putfield 262	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   144: iload 6
    //   146: istore 7
    //   148: iload 6
    //   150: istore 8
    //   152: iload 6
    //   154: istore 9
    //   156: aload_1
    //   157: invokevirtual 304	android/net/Uri:getScheme	()Ljava/lang/String;
    //   160: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   163: ldc_w 309
    //   166: invokevirtual 313	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   169: ifeq +143 -> 312
    //   172: iload 6
    //   174: istore 7
    //   176: iload 6
    //   178: istore 8
    //   180: iload 6
    //   182: istore 9
    //   184: new 315	java/io/FileInputStream
    //   187: dup
    //   188: aload_1
    //   189: invokevirtual 316	android/net/Uri:toString	()Ljava/lang/String;
    //   192: ldc_w 318
    //   195: invokevirtual 321	java/lang/String:length	()I
    //   198: invokevirtual 325	java/lang/String:substring	(I)Ljava/lang/String;
    //   201: invokespecial 328	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   204: astore 4
    //   206: aload 4
    //   208: astore_2
    //   209: aload_2
    //   210: aconst_null
    //   211: aload 5
    //   213: invokestatic 332	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   216: astore 4
    //   218: aload 4
    //   220: astore_3
    //   221: iconst_0
    //   222: istore 7
    //   224: aload_0
    //   225: aload_2
    //   226: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   229: iload 7
    //   231: ifne +175 -> 406
    //   234: aload_3
    //   235: astore_1
    //   236: aload_3
    //   237: ifnull +28 -> 265
    //   240: aload_3
    //   241: astore_1
    //   242: aload_3
    //   243: invokevirtual 120	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   246: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   249: if_acmpeq +16 -> 265
    //   252: aload_3
    //   253: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   256: iconst_1
    //   257: invokevirtual 338	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   260: astore_1
    //   261: aload_3
    //   262: invokevirtual 215	android/graphics/Bitmap:recycle	()V
    //   265: aload_1
    //   266: areturn
    //   267: iload 6
    //   269: iconst_2
    //   270: imul
    //   271: istore 6
    //   273: iload 6
    //   275: istore 7
    //   277: iload 6
    //   279: istore 8
    //   281: iload 6
    //   283: istore 9
    //   285: aload 5
    //   287: iload 6
    //   289: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   292: goto -168 -> 124
    //   295: astore 4
    //   297: iload 7
    //   299: istore 6
    //   301: iconst_0
    //   302: istore 7
    //   304: aload_0
    //   305: aload_2
    //   306: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   309: goto -80 -> 229
    //   312: iload 6
    //   314: istore 7
    //   316: iload 6
    //   318: istore 8
    //   320: iload 6
    //   322: istore 9
    //   324: aload_0
    //   325: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   328: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   331: aload_1
    //   332: invokevirtual 350	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   335: astore 4
    //   337: aload 4
    //   339: astore_2
    //   340: goto -131 -> 209
    //   343: astore 4
    //   345: iload 8
    //   347: istore 6
    //   349: aload_0
    //   350: aload_2
    //   351: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   354: iload 10
    //   356: istore 7
    //   358: goto -129 -> 229
    //   361: astore 4
    //   363: iload 9
    //   365: istore 6
    //   367: aload_0
    //   368: aload_2
    //   369: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   372: iload 10
    //   374: istore 7
    //   376: goto -147 -> 229
    //   379: astore_1
    //   380: aload_0
    //   381: aload_2
    //   382: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   385: aload_1
    //   386: athrow
    //   387: astore_1
    //   388: goto -8 -> 380
    //   391: astore 4
    //   393: goto -26 -> 367
    //   396: astore 4
    //   398: goto -49 -> 349
    //   401: astore 4
    //   403: goto -102 -> 301
    //   406: iload 7
    //   408: istore 10
    //   410: goto -400 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	BitmapUtils
    //   0	413	1	paramUri	Uri
    //   9	373	2	localObject1	Object
    //   1	261	3	localObject2	Object
    //   27	192	4	localObject3	Object
    //   295	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   335	3	4	localInputStream	java.io.InputStream
    //   343	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   361	1	4	localException1	Exception
    //   391	1	4	localException2	Exception
    //   396	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   401	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   86	200	5	localOptions	BitmapFactory.Options
    //   6	360	6	i	int
    //   12	395	7	j	int
    //   16	330	8	k	int
    //   20	344	9	m	int
    //   3	406	10	n	int
    //   46	63	11	i1	int
    //   65	46	12	i2	int
    // Exception table:
    //   from	to	target	type
    //   22	29	295	java/io/FileNotFoundException
    //   41	48	295	java/io/FileNotFoundException
    //   60	67	295	java/io/FileNotFoundException
    //   79	88	295	java/io/FileNotFoundException
    //   106	124	295	java/io/FileNotFoundException
    //   136	144	295	java/io/FileNotFoundException
    //   156	172	295	java/io/FileNotFoundException
    //   184	206	295	java/io/FileNotFoundException
    //   285	292	295	java/io/FileNotFoundException
    //   324	337	295	java/io/FileNotFoundException
    //   22	29	343	java/lang/OutOfMemoryError
    //   41	48	343	java/lang/OutOfMemoryError
    //   60	67	343	java/lang/OutOfMemoryError
    //   79	88	343	java/lang/OutOfMemoryError
    //   106	124	343	java/lang/OutOfMemoryError
    //   136	144	343	java/lang/OutOfMemoryError
    //   156	172	343	java/lang/OutOfMemoryError
    //   184	206	343	java/lang/OutOfMemoryError
    //   285	292	343	java/lang/OutOfMemoryError
    //   324	337	343	java/lang/OutOfMemoryError
    //   22	29	361	java/lang/Exception
    //   41	48	361	java/lang/Exception
    //   60	67	361	java/lang/Exception
    //   79	88	361	java/lang/Exception
    //   106	124	361	java/lang/Exception
    //   136	144	361	java/lang/Exception
    //   156	172	361	java/lang/Exception
    //   184	206	361	java/lang/Exception
    //   285	292	361	java/lang/Exception
    //   324	337	361	java/lang/Exception
    //   22	29	379	finally
    //   41	48	379	finally
    //   60	67	379	finally
    //   79	88	379	finally
    //   106	124	379	finally
    //   136	144	379	finally
    //   156	172	379	finally
    //   184	206	379	finally
    //   285	292	379	finally
    //   324	337	379	finally
    //   209	218	387	finally
    //   209	218	391	java/lang/Exception
    //   209	218	396	java/lang/OutOfMemoryError
    //   209	218	401	java/io/FileNotFoundException
  }
  
  public static void deletePicture(ContentResolver paramContentResolver, Uri paramUri)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = paramContentResolver.query(paramUri, PATH_PROJECTION, null, null, null);
      Object localObject3 = localObject4;
      if (localCursor != null)
      {
        localObject3 = localObject4;
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (localCursor.moveToNext())
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          localObject3 = localCursor.getString(0);
        }
      }
      if (localObject3 != null)
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        localObject3 = new File((String)localObject3);
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (((File)localObject3).isFile())
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (((File)localObject3).exists())
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            ((File)localObject3).delete();
          }
        }
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      paramContentResolver.delete(paramUri, null, null);
      if (localCursor != null) {
        localCursor.close();
      }
      return;
    }
    catch (Exception paramContentResolver)
    {
      localObject2 = localObject1;
      paramContentResolver.printStackTrace();
      return;
    }
    finally
    {
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
    }
  }
  
  /* Error */
  private Rect getBitmapBounds(Uri paramUri)
  {
    // Byte code:
    //   0: new 137	android/graphics/Rect
    //   3: dup
    //   4: invokespecial 382	android/graphics/Rect:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 5
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 304	android/net/Uri:getScheme	()Ljava/lang/String;
    //   25: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   28: ldc_w 309
    //   31: invokevirtual 313	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifeq +101 -> 135
    //   37: aload 4
    //   39: astore_3
    //   40: aload 5
    //   42: astore_2
    //   43: new 315	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 316	android/net/Uri:toString	()Ljava/lang/String;
    //   51: ldc_w 318
    //   54: invokevirtual 321	java/lang/String:length	()I
    //   57: invokevirtual 325	java/lang/String:substring	(I)Ljava/lang/String;
    //   60: invokespecial 328	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_1
    //   65: astore_3
    //   66: aload_1
    //   67: astore_2
    //   68: new 64	android/graphics/BitmapFactory$Options
    //   71: dup
    //   72: invokespecial 259	android/graphics/BitmapFactory$Options:<init>	()V
    //   75: astore 4
    //   77: aload_1
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: aload 4
    //   83: iconst_1
    //   84: putfield 386	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   87: aload_1
    //   88: astore_3
    //   89: aload_1
    //   90: astore_2
    //   91: aload_1
    //   92: aconst_null
    //   93: aload 4
    //   95: invokestatic 332	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   98: pop
    //   99: aload_1
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload 6
    //   105: aload 4
    //   107: getfield 67	android/graphics/BitmapFactory$Options:outWidth	I
    //   110: putfield 389	android/graphics/Rect:right	I
    //   113: aload_1
    //   114: astore_3
    //   115: aload_1
    //   116: astore_2
    //   117: aload 6
    //   119: aload 4
    //   121: getfield 70	android/graphics/BitmapFactory$Options:outHeight	I
    //   124: putfield 392	android/graphics/Rect:bottom	I
    //   127: aload_0
    //   128: aload_1
    //   129: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   132: aload 6
    //   134: areturn
    //   135: aload 4
    //   137: astore_3
    //   138: aload 5
    //   140: astore_2
    //   141: aload_0
    //   142: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   145: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   148: aload_1
    //   149: invokevirtual 350	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   152: astore_1
    //   153: goto -89 -> 64
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: aload_1
    //   160: invokevirtual 393	java/io/FileNotFoundException:printStackTrace	()V
    //   163: aload_0
    //   164: aload_3
    //   165: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   168: aload 6
    //   170: areturn
    //   171: astore_1
    //   172: aload_0
    //   173: aload_2
    //   174: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   177: aload_1
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	BitmapUtils
    //   0	179	1	paramUri	Uri
    //   20	154	2	localObject1	Object
    //   17	148	3	localObject2	Object
    //   13	123	4	localOptions	BitmapFactory.Options
    //   10	129	5	localObject3	Object
    //   7	162	6	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   21	37	156	java/io/FileNotFoundException
    //   43	64	156	java/io/FileNotFoundException
    //   68	77	156	java/io/FileNotFoundException
    //   81	87	156	java/io/FileNotFoundException
    //   91	99	156	java/io/FileNotFoundException
    //   103	113	156	java/io/FileNotFoundException
    //   117	127	156	java/io/FileNotFoundException
    //   141	153	156	java/io/FileNotFoundException
    //   21	37	171	finally
    //   43	64	171	finally
    //   68	77	171	finally
    //   81	87	171	finally
    //   91	99	171	finally
    //   103	113	171	finally
    //   117	127	171	finally
    //   141	153	171	finally
    //   159	163	171	finally
  }
  
  public static Bitmap getBitmapResource(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext) {}
    return null;
  }
  
  public static Bitmap getBitmapTailor(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (Math.abs(paramInt1 / paramInt2 - paramBitmap.getWidth() / paramBitmap.getHeight()) < 0.01F) {
      return resizeBitmapByScale(paramBitmap, paramInt1 / paramBitmap.getWidth(), false);
    }
    if ((paramInt1 >= paramBitmap.getWidth()) || (paramInt2 >= paramBitmap.getHeight())) {}
    for (Bitmap localBitmap = resizeBitmapByScale(paramBitmap, Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight()), false); localBitmap == null; localBitmap = resizeBitmapByScale(paramBitmap, Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight()), false)) {
      return null;
    }
    if (localBitmap != paramBitmap) {
      bool = true;
    }
    return cropCenter(localBitmap, paramInt1, paramInt2, bool);
  }
  
  private static Bitmap.Config getConfig(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    paramBitmap = localConfig;
    if (localConfig == null) {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  public static Bitmap makeBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
        if ((!((BitmapFactory.Options)localObject).mCancel) && (((BitmapFactory.Options)localObject).outWidth != -1) && (((BitmapFactory.Options)localObject).outHeight != -1))
        {
          ((BitmapFactory.Options)localObject).inSampleSize = computeSampleSize((BitmapFactory.Options)localObject, paramInt1, paramInt3);
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inDither = false;
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_4444;
          paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
          if (paramInt2 != 0)
          {
            localObject = new android.graphics.Matrix();
            ((android.graphics.Matrix)localObject).setRotate(paramInt2);
            localObject = createBitmap(paramArrayOfByte, 0, 0, paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight(), (android.graphics.Matrix)localObject);
            paramArrayOfByte.recycle();
            return (Bitmap)localObject;
          }
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        return null;
      }
    }
    return paramArrayOfByte;
  }
  
  public static Bitmap makeFitBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    int k = 1;
    int j = -1;
    int i = j;
    for (;;)
    {
      try
      {
        localObject2 = new BitmapFactory.Options();
        i = j;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        i = j;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
        i = j;
        if (((BitmapFactory.Options)localObject2).mCancel) {
          break label372;
        }
        i = j;
        if (((BitmapFactory.Options)localObject2).outWidth == -1) {
          break label372;
        }
        i = j;
        if (((BitmapFactory.Options)localObject2).outHeight == -1) {
          break label372;
        }
        if (j != -1) {
          continue;
        }
        i = j;
        ((BitmapFactory.Options)localObject2).inSampleSize = computeSampleSizeSmaller(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, paramBoolean);
        i = j;
        j = ((BitmapFactory.Options)localObject2).inSampleSize;
        i = j;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        i = j;
        ((BitmapFactory.Options)localObject2).inDither = false;
        i = j;
        ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
        i = j;
        localObject2 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
        m = 0;
        i = j;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject2;
        float f;
        Object localObject3 = localObject1;
        int m = k;
        continue;
        return (Bitmap)localObject3;
      }
      localObject1 = localObject2;
      k = m;
      j = i;
      if (m != 0) {
        break;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0)) {
        continue;
      }
      paramArrayOfByte = new android.graphics.Matrix();
      f = ((Bitmap)localObject2).getWidth();
      if (paramInt2 == 1) {
        paramArrayOfByte.setValues(new float[] { -1.0F, 0.0F, f, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      }
      if (paramInt1 != 0) {
        paramArrayOfByte.preRotate(paramInt1);
      }
      if (paramInt3 != 0) {
        paramArrayOfByte.postRotate(paramInt3);
      }
      paramArrayOfByte = createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), paramArrayOfByte);
      ((Bitmap)localObject2).recycle();
      return paramArrayOfByte;
      j *= 2;
      i = j;
      ((BitmapFactory.Options)localObject2).inSampleSize = j;
    }
    label372:
    return null;
  }
  
  public static Bitmap makeFitBitmap(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    int k = 1;
    int j = -1;
    label14:
    int i = j;
    for (;;)
    {
      try
      {
        localObject2 = new BitmapFactory.Options();
        i = j;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        i = j;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
        i = j;
        if (((BitmapFactory.Options)localObject2).mCancel) {
          break;
        }
        i = j;
        if (((BitmapFactory.Options)localObject2).outWidth == -1) {
          break;
        }
        i = j;
        if (((BitmapFactory.Options)localObject2).outHeight == -1) {
          break;
        }
        if (j != -1) {
          continue;
        }
        i = j;
        ((BitmapFactory.Options)localObject2).inSampleSize = computeSampleSizeSmaller(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, paramBoolean);
        i = j;
        j = ((BitmapFactory.Options)localObject2).inSampleSize;
        i = j;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        i = j;
        ((BitmapFactory.Options)localObject2).inDither = false;
        i = j;
        ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
        i = j;
        localObject2 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
        m = 0;
        i = j;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject2;
        localObject3 = localObject1;
        int m = k;
        continue;
        ((Bitmap)localObject3).recycle();
        return paramArrayOfByte;
      }
      localObject1 = localObject2;
      k = m;
      j = i;
      if (m != 0) {
        break label14;
      }
      if (paramInt == 0) {
        break label282;
      }
      paramArrayOfByte = new android.graphics.Matrix();
      paramArrayOfByte.setRotate(paramInt);
      paramArrayOfByte = createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), paramArrayOfByte);
      if (paramArrayOfByte != null) {
        continue;
      }
      return (Bitmap)localObject2;
      j *= 2;
      i = j;
      ((BitmapFactory.Options)localObject2).inSampleSize = j;
    }
    Object localObject3;
    label282:
    return (Bitmap)localObject3;
  }
  
  public static Bitmap makeLimitedBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1;
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      localObject1 = localObject2;
      if (!localOptions.mCancel)
      {
        localObject1 = localObject2;
        if (localOptions.outWidth != -1)
        {
          if (localOptions.outHeight == -1) {
            return null;
          }
          localOptions.inSampleSize = computeSampleSize(localOptions, -1, paramInt1);
          localOptions.inJustDecodeBounds = false;
          localOptions.inDither = false;
          localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
          localObject1 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
          if (paramInt2 != 0)
          {
            paramArrayOfByte = new android.graphics.Matrix();
            paramArrayOfByte.setRotate(paramInt2);
            paramArrayOfByte = createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramArrayOfByte);
            ((Bitmap)localObject1).recycle();
            return paramArrayOfByte;
          }
        }
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      return null;
    }
    return (Bitmap)localObject1;
  }
  
  public static int prevPowerOf2(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    return Integer.highestOneBit(paramInt);
  }
  
  public static boolean recycle(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      return true;
    }
    return false;
  }
  
  public static Bitmap resizeBitmapByScale(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    int i = Math.round(paramBitmap.getWidth() * paramFloat);
    int j = Math.round(paramBitmap.getHeight() * paramFloat);
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, getConfig(paramBitmap));
      localObject = new Canvas(localBitmap);
      ((Canvas)localObject).scale(paramFloat, paramFloat);
      Paint localPaint = new Paint(6);
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localObject = localBitmap;
      if (paramBoolean)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        localObject = null;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
    return (Bitmap)localObject;
  }
  
  public static Bitmap resizeBitmapByScale2(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    int i = Math.round(paramBitmap.getWidth() * paramFloat);
    int j = Math.round(paramBitmap.getHeight() * paramFloat);
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Object localObject = new android.graphics.Matrix();
    ((android.graphics.Matrix)localObject).postScale(paramFloat, paramFloat);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (android.graphics.Matrix)localObject, true);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    return (Bitmap)localObject;
  }
  
  public static Bitmap resizeDownAndCropCenter(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = Math.min(i, j);
    if ((i == j) && (k <= paramInt)) {
      return paramBitmap;
    }
    paramInt = Math.min(paramInt, k);
    float f = Math.max(paramInt / paramBitmap.getWidth(), paramInt / paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, getConfig(paramBitmap));
    i = Math.round(paramBitmap.getWidth() * f);
    j = Math.round(paramBitmap.getHeight() * f);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.translate((paramInt - i) / 2.0F, (paramInt - j) / 2.0F);
    localCanvas.scale(f, f);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    return localBitmap;
  }
  
  public static Bitmap resizeDownBySideLength(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = Math.min(paramInt / i, paramInt / j);
    if (f >= 1.0F) {
      return paramBitmap;
    }
    return resizeBitmapByScale(paramBitmap, f, paramBoolean);
  }
  
  public static Bitmap resizeFromTop(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (Math.abs(paramInt1 / paramInt2 - paramBitmap.getWidth() / paramBitmap.getHeight()) < 0.01F) {
      return resizeBitmapByScale(paramBitmap, paramInt1 / paramBitmap.getWidth(), false);
    }
    if ((paramInt1 >= paramBitmap.getWidth()) || (paramInt2 >= paramBitmap.getHeight())) {}
    for (Bitmap localBitmap = resizeBitmapByScale(paramBitmap, Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight()), false); localBitmap == null; localBitmap = resizeBitmapByScale(paramBitmap, Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight()), false)) {
      return null;
    }
    if (localBitmap != paramBitmap) {
      bool = true;
    }
    return cropCenter(localBitmap, paramInt1, paramInt2, bool);
  }
  
  private static void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 == 0.0F) {
      return;
    }
    float[] arrayOfFloat = mTempMatrix;
    android.opengl.Matrix.setRotateM(arrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    android.opengl.Matrix.multiplyMM(arrayOfFloat, 16, mMatrixValues, 0, arrayOfFloat, 0);
    System.arraycopy(arrayOfFloat, 16, mMatrixValues, 0, 16);
  }
  
  private static void rotate(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    rotate(paramInt, 0.0F, 0.0F, 1.0F);
  }
  
  private static Bitmap rotateAndFlipY(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new android.graphics.Matrix();
    float f = paramBitmap.getWidth();
    if (paramInt2 == 1) {
      ((android.graphics.Matrix)localObject).setValues(new float[] { -1.0F, 0.0F, f, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
    }
    if (paramInt1 != 0) {
      ((android.graphics.Matrix)localObject).preRotate(paramInt1);
    }
    if (paramInt3 != 0) {
      ((android.graphics.Matrix)localObject).postRotate(paramInt3);
    }
    localObject = createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (android.graphics.Matrix)localObject);
    if (localObject == null) {
      return paramBitmap;
    }
    paramBitmap.recycle();
    return (Bitmap)localObject;
  }
  
  public static Bitmap rotateAndFlipY(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Bitmap localBitmap;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localBitmap = paramBitmap;
      if (0 == 0) {}
    }
    else
    {
      if (paramInt2 != 0) {
        break label31;
      }
      localBitmap = rotateAndFlipY(paramBitmap, paramInt1, paramInt2, 0);
    }
    return localBitmap;
    label31:
    return rotateAndFlipY(paramBitmap, paramInt1, paramInt2, 0);
  }
  
  public static float[] rotateAndFlipYMatrix(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    android.opengl.Matrix.setIdentityM(mMatrixValues, 0);
    rotate(paramInt1);
    if (paramInt2 % 2 == 1)
    {
      if (paramInt1 % 180 != 0) {
        break label50;
      }
      android.opengl.Matrix.scaleM(mMatrixValues, 0, -1.0F, 1.0F, 1.0F);
    }
    for (;;)
    {
      if (0 != 0) {
        rotate(0);
      }
      return mMatrixValues;
      label50:
      android.opengl.Matrix.scaleM(mMatrixValues, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  /* Error */
  public Bitmap decodeBitmap(Uri paramUri, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_1
    //   4: istore 12
    //   6: iconst_m1
    //   7: istore 9
    //   9: aconst_null
    //   10: astore 5
    //   12: iload 9
    //   14: istore 10
    //   16: iload 9
    //   18: istore 11
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 281	com/tencent/util/BitmapUtils:getBitmapBounds	(Landroid/net/Uri;)Landroid/graphics/Rect;
    //   25: astore 7
    //   27: iload 9
    //   29: istore 10
    //   31: iload 9
    //   33: istore 11
    //   35: aload 7
    //   37: invokevirtual 283	android/graphics/Rect:width	()I
    //   40: istore 14
    //   42: iload 9
    //   44: istore 10
    //   46: iload 9
    //   48: istore 11
    //   50: aload 7
    //   52: invokevirtual 285	android/graphics/Rect:height	()I
    //   55: istore 15
    //   57: iload 9
    //   59: istore 10
    //   61: iload 9
    //   63: istore 11
    //   65: new 64	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 259	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 8
    //   74: iload 9
    //   76: iconst_m1
    //   77: if_icmpne +290 -> 367
    //   80: iload_2
    //   81: iload_3
    //   82: if_icmple +279 -> 361
    //   85: iload_2
    //   86: istore 13
    //   88: iload 9
    //   90: istore 10
    //   92: iload 9
    //   94: istore 11
    //   96: aload 8
    //   98: iload 14
    //   100: iload 15
    //   102: iload 13
    //   104: invokestatic 522	com/tencent/util/BitmapUtils:computeSampleSizeLarger	(III)I
    //   107: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   110: iload 9
    //   112: istore 10
    //   114: iload 9
    //   116: istore 11
    //   118: aload 8
    //   120: getfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   123: istore 9
    //   125: iload 9
    //   127: istore 10
    //   129: iload 9
    //   131: istore 11
    //   133: aload 8
    //   135: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   138: putfield 262	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   141: iload 9
    //   143: istore 10
    //   145: iload 9
    //   147: istore 11
    //   149: aload_1
    //   150: invokevirtual 304	android/net/Uri:getScheme	()Ljava/lang/String;
    //   153: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   156: ldc_w 309
    //   159: invokevirtual 313	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifeq +247 -> 409
    //   165: iload 9
    //   167: istore 10
    //   169: iload 9
    //   171: istore 11
    //   173: new 315	java/io/FileInputStream
    //   176: dup
    //   177: aload_1
    //   178: invokevirtual 316	android/net/Uri:toString	()Ljava/lang/String;
    //   181: ldc_w 318
    //   184: invokevirtual 321	java/lang/String:length	()I
    //   187: invokevirtual 325	java/lang/String:substring	(I)Ljava/lang/String;
    //   190: invokespecial 328	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   193: astore 7
    //   195: aload 7
    //   197: astore 5
    //   199: aload 5
    //   201: aconst_null
    //   202: aload 8
    //   204: invokestatic 332	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: astore 7
    //   209: aload 7
    //   211: astore 6
    //   213: iconst_0
    //   214: istore 10
    //   216: aload_0
    //   217: aload 5
    //   219: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   222: iload 10
    //   224: ifne +257 -> 481
    //   227: aload 6
    //   229: astore_1
    //   230: aload 6
    //   232: ifnull +32 -> 264
    //   235: aload 6
    //   237: astore_1
    //   238: aload 6
    //   240: invokevirtual 120	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   243: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   246: if_acmpeq +18 -> 264
    //   249: aload 6
    //   251: getstatic 230	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   254: iconst_1
    //   255: invokevirtual 338	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   258: astore_1
    //   259: aload 6
    //   261: invokevirtual 215	android/graphics/Bitmap:recycle	()V
    //   264: aload_1
    //   265: ifnull +200 -> 465
    //   268: iload_2
    //   269: i2f
    //   270: aload_1
    //   271: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   274: i2f
    //   275: fdiv
    //   276: iload_3
    //   277: i2f
    //   278: aload_1
    //   279: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   282: i2f
    //   283: fdiv
    //   284: invokestatic 484	java/lang/Math:min	(FF)F
    //   287: iload_3
    //   288: i2f
    //   289: aload_1
    //   290: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   293: i2f
    //   294: fdiv
    //   295: iload_2
    //   296: i2f
    //   297: aload_1
    //   298: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   301: i2f
    //   302: fdiv
    //   303: invokestatic 484	java/lang/Math:min	(FF)F
    //   306: invokestatic 416	java/lang/Math:max	(FF)F
    //   309: fstore 4
    //   311: fload 4
    //   313: fconst_1
    //   314: fcmpg
    //   315: ifge +150 -> 465
    //   318: new 110	android/graphics/Matrix
    //   321: dup
    //   322: invokespecial 436	android/graphics/Matrix:<init>	()V
    //   325: astore 5
    //   327: aload 5
    //   329: fload 4
    //   331: fload 4
    //   333: invokevirtual 525	android/graphics/Matrix:setScale	(FF)V
    //   336: aload_1
    //   337: iconst_0
    //   338: iconst_0
    //   339: aload_1
    //   340: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   343: aload_1
    //   344: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   347: aload 5
    //   349: invokestatic 212	com/tencent/util/BitmapUtils:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;)Landroid/graphics/Bitmap;
    //   352: astore 5
    //   354: aload_1
    //   355: invokevirtual 215	android/graphics/Bitmap:recycle	()V
    //   358: aload 5
    //   360: areturn
    //   361: iload_3
    //   362: istore 13
    //   364: goto -276 -> 88
    //   367: iload 9
    //   369: iconst_2
    //   370: imul
    //   371: istore 9
    //   373: iload 9
    //   375: istore 10
    //   377: iload 9
    //   379: istore 11
    //   381: aload 8
    //   383: iload 9
    //   385: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   388: goto -263 -> 125
    //   391: astore 7
    //   393: iload 10
    //   395: istore 9
    //   397: iconst_0
    //   398: istore 10
    //   400: aload_0
    //   401: aload 5
    //   403: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   406: goto -184 -> 222
    //   409: iload 9
    //   411: istore 10
    //   413: iload 9
    //   415: istore 11
    //   417: aload_0
    //   418: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   421: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   424: aload_1
    //   425: invokevirtual 350	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   428: astore 7
    //   430: aload 7
    //   432: astore 5
    //   434: goto -235 -> 199
    //   437: astore 7
    //   439: iload 11
    //   441: istore 9
    //   443: aload_0
    //   444: aload 5
    //   446: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   449: iload 12
    //   451: istore 10
    //   453: goto -231 -> 222
    //   456: astore_1
    //   457: aload_0
    //   458: aload 5
    //   460: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   463: aload_1
    //   464: athrow
    //   465: aload_1
    //   466: areturn
    //   467: astore_1
    //   468: goto -11 -> 457
    //   471: astore 7
    //   473: goto -30 -> 443
    //   476: astore 7
    //   478: goto -81 -> 397
    //   481: iload 10
    //   483: istore 12
    //   485: goto -473 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	BitmapUtils
    //   0	488	1	paramUri	Uri
    //   0	488	2	paramInt1	int
    //   0	488	3	paramInt2	int
    //   309	23	4	f	float
    //   10	449	5	localObject1	Object
    //   1	259	6	localObject2	Object
    //   25	185	7	localObject3	Object
    //   391	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   428	3	7	localInputStream	java.io.InputStream
    //   437	1	7	localOutOfMemoryError1	OutOfMemoryError
    //   471	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   476	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   72	310	8	localOptions	BitmapFactory.Options
    //   7	435	9	i	int
    //   14	468	10	j	int
    //   18	422	11	k	int
    //   4	480	12	m	int
    //   86	277	13	n	int
    //   40	59	14	i1	int
    //   55	46	15	i2	int
    // Exception table:
    //   from	to	target	type
    //   20	27	391	java/io/FileNotFoundException
    //   35	42	391	java/io/FileNotFoundException
    //   50	57	391	java/io/FileNotFoundException
    //   65	74	391	java/io/FileNotFoundException
    //   96	110	391	java/io/FileNotFoundException
    //   118	125	391	java/io/FileNotFoundException
    //   133	141	391	java/io/FileNotFoundException
    //   149	165	391	java/io/FileNotFoundException
    //   173	195	391	java/io/FileNotFoundException
    //   381	388	391	java/io/FileNotFoundException
    //   417	430	391	java/io/FileNotFoundException
    //   20	27	437	java/lang/OutOfMemoryError
    //   35	42	437	java/lang/OutOfMemoryError
    //   50	57	437	java/lang/OutOfMemoryError
    //   65	74	437	java/lang/OutOfMemoryError
    //   96	110	437	java/lang/OutOfMemoryError
    //   118	125	437	java/lang/OutOfMemoryError
    //   133	141	437	java/lang/OutOfMemoryError
    //   149	165	437	java/lang/OutOfMemoryError
    //   173	195	437	java/lang/OutOfMemoryError
    //   381	388	437	java/lang/OutOfMemoryError
    //   417	430	437	java/lang/OutOfMemoryError
    //   20	27	456	finally
    //   35	42	456	finally
    //   50	57	456	finally
    //   65	74	456	finally
    //   96	110	456	finally
    //   118	125	456	finally
    //   133	141	456	finally
    //   149	165	456	finally
    //   173	195	456	finally
    //   381	388	456	finally
    //   417	430	456	finally
    //   199	209	467	finally
    //   199	209	471	java/lang/OutOfMemoryError
    //   199	209	476	java/io/FileNotFoundException
  }
  
  public Bitmap getBitmap(Uri paramUri, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = decodeBitmap(paramUri, paramInt1, paramInt2);
    if (localBitmap != null)
    {
      paramInt1 = getOrientation(paramUri);
      if (paramInt1 != 0)
      {
        paramUri = new android.graphics.Matrix();
        paramUri.setRotate(paramInt1);
        paramUri = createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramUri);
        localBitmap.recycle();
        return paramUri;
      }
    }
    return localBitmap;
  }
  
  public Bitmap getBitmapWithoutResize(Uri paramUri)
  {
    Bitmap localBitmap = decodeBitmapWithoutResize(paramUri);
    if (localBitmap != null)
    {
      int i = getOrientation(paramUri);
      if (i != 0)
      {
        paramUri = new android.graphics.Matrix();
        paramUri.setRotate(i);
        paramUri = createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramUri);
        localBitmap.recycle();
        return paramUri;
      }
    }
    return localBitmap;
  }
  
  /* Error */
  public int getOrientation(Uri paramUri)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 10
    //   6: aload_1
    //   7: invokevirtual 304	android/net/Uri:getScheme	()Ljava/lang/String;
    //   10: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   13: ldc_w 309
    //   16: invokevirtual 539	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +206 -> 225
    //   22: aload_1
    //   23: invokevirtual 542	android/net/Uri:getPath	()Ljava/lang/String;
    //   26: astore_1
    //   27: iload 10
    //   29: istore 9
    //   31: aload_1
    //   32: ifnull +136 -> 168
    //   35: aload_1
    //   36: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   39: ldc_w 544
    //   42: invokevirtual 547	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   45: ifne +20 -> 65
    //   48: iload 10
    //   50: istore 9
    //   52: aload_1
    //   53: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   56: ldc_w 549
    //   59: invokevirtual 547	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   62: ifeq +106 -> 168
    //   65: new 366	java/io/File
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_2
    //   74: aconst_null
    //   75: astore 4
    //   77: aconst_null
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_3
    //   81: aconst_null
    //   82: astore 6
    //   84: aconst_null
    //   85: astore 8
    //   87: aconst_null
    //   88: astore 7
    //   90: aconst_null
    //   91: astore 5
    //   93: new 315	java/io/FileInputStream
    //   96: dup
    //   97: aload_2
    //   98: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   101: astore_2
    //   102: aload 8
    //   104: astore_1
    //   105: aload 7
    //   107: astore_3
    //   108: aload_2
    //   109: invokevirtual 557	java/io/InputStream:available	()I
    //   112: invokestatic 563	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   115: astore 4
    //   117: aload 4
    //   119: astore_1
    //   120: aload 4
    //   122: astore_3
    //   123: aload_2
    //   124: aload 4
    //   126: invokevirtual 567	java/nio/ByteBuffer:array	()[B
    //   129: invokevirtual 571	java/io/InputStream:read	([B)I
    //   132: pop
    //   133: aload_2
    //   134: invokestatic 577	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   137: aload 4
    //   139: astore_2
    //   140: iload 10
    //   142: istore 9
    //   144: aload_2
    //   145: ifnull +23 -> 168
    //   148: iload 10
    //   150: istore 9
    //   152: aload_2
    //   153: invokevirtual 567	java/nio/ByteBuffer:array	()[B
    //   156: ifnull +12 -> 168
    //   159: aload_2
    //   160: invokevirtual 567	java/nio/ByteBuffer:array	()[B
    //   163: invokestatic 581	com/tencent/util/ExifUtils:getOrientation	([B)I
    //   166: istore 9
    //   168: iload 9
    //   170: ireturn
    //   171: astore 4
    //   173: aload 5
    //   175: astore_2
    //   176: aload_3
    //   177: astore_1
    //   178: aload 4
    //   180: invokevirtual 393	java/io/FileNotFoundException:printStackTrace	()V
    //   183: aload_3
    //   184: invokestatic 577	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   187: goto -47 -> 140
    //   190: astore_1
    //   191: aload 4
    //   193: astore_3
    //   194: aload_1
    //   195: astore 4
    //   197: aload 6
    //   199: astore_2
    //   200: aload_3
    //   201: astore_1
    //   202: aload 4
    //   204: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   207: aload_3
    //   208: invokestatic 577	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   211: goto -71 -> 140
    //   214: astore_3
    //   215: aload_1
    //   216: astore_2
    //   217: aload_3
    //   218: astore_1
    //   219: aload_2
    //   220: invokestatic 577	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   223: aload_1
    //   224: athrow
    //   225: aconst_null
    //   226: astore_3
    //   227: aconst_null
    //   228: astore_2
    //   229: aload_0
    //   230: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   233: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   236: aload_1
    //   237: getstatic 33	com/tencent/util/BitmapUtils:IMAGE_PROJECTION	[Ljava/lang/String;
    //   240: aconst_null
    //   241: aconst_null
    //   242: aconst_null
    //   243: invokevirtual 356	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   246: astore_1
    //   247: iload 11
    //   249: istore 9
    //   251: aload_1
    //   252: ifnull +33 -> 285
    //   255: iload 11
    //   257: istore 9
    //   259: aload_1
    //   260: astore_2
    //   261: aload_1
    //   262: astore_3
    //   263: aload_1
    //   264: invokeinterface 361 1 0
    //   269: ifeq +16 -> 285
    //   272: aload_1
    //   273: astore_2
    //   274: aload_1
    //   275: astore_3
    //   276: aload_1
    //   277: iconst_0
    //   278: invokeinterface 584 2 0
    //   283: istore 9
    //   285: aload_1
    //   286: invokestatic 587	com/tencent/util/IOUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   289: iload 9
    //   291: ireturn
    //   292: astore_1
    //   293: aload_2
    //   294: astore_3
    //   295: aload_1
    //   296: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   299: aload_2
    //   300: invokestatic 587	com/tencent/util/IOUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   303: iconst_0
    //   304: ireturn
    //   305: astore_1
    //   306: aload_3
    //   307: invokestatic 587	com/tencent/util/IOUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   310: aload_1
    //   311: athrow
    //   312: astore_1
    //   313: goto -94 -> 219
    //   316: astore 4
    //   318: aload_2
    //   319: astore_3
    //   320: aload_1
    //   321: astore_2
    //   322: goto -122 -> 200
    //   325: astore 4
    //   327: aload_2
    //   328: astore_1
    //   329: aload_3
    //   330: astore_2
    //   331: aload_1
    //   332: astore_3
    //   333: goto -157 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	BitmapUtils
    //   0	336	1	paramUri	Uri
    //   73	258	2	localObject1	Object
    //   80	128	3	localObject2	Object
    //   214	4	3	localObject3	Object
    //   226	107	3	localObject4	Object
    //   75	63	4	localByteBuffer	java.nio.ByteBuffer
    //   171	21	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   195	8	4	localUri	Uri
    //   316	1	4	localIOException	IOException
    //   325	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   91	83	5	localObject5	Object
    //   82	116	6	localObject6	Object
    //   88	18	7	localObject7	Object
    //   85	18	8	localObject8	Object
    //   29	261	9	i	int
    //   4	145	10	j	int
    //   1	255	11	k	int
    // Exception table:
    //   from	to	target	type
    //   93	102	171	java/io/FileNotFoundException
    //   93	102	190	java/io/IOException
    //   93	102	214	finally
    //   178	183	214	finally
    //   202	207	214	finally
    //   229	247	292	java/lang/Exception
    //   263	272	292	java/lang/Exception
    //   276	285	292	java/lang/Exception
    //   229	247	305	finally
    //   263	272	305	finally
    //   276	285	305	finally
    //   295	299	305	finally
    //   108	117	312	finally
    //   123	133	312	finally
    //   108	117	316	java/io/IOException
    //   123	133	316	java/io/IOException
    //   108	117	325	java/io/FileNotFoundException
    //   123	133	325	java/io/FileNotFoundException
  }
  
  /* Error */
  public File saveBitmap(Bitmap paramBitmap, String paramString1, String paramString2, android.graphics.Bitmap.CompressFormat paramCompressFormat, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_2
    //   4: ifnonnull +139 -> 143
    //   7: aload_0
    //   8: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   11: invokevirtual 593	android/content/Context:getCacheDir	()Ljava/io/File;
    //   14: invokevirtual 596	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   17: astore 6
    //   19: aconst_null
    //   20: astore 9
    //   22: aconst_null
    //   23: astore 11
    //   25: aconst_null
    //   26: astore 10
    //   28: aconst_null
    //   29: astore 8
    //   31: iconst_0
    //   32: istore 13
    //   34: iconst_0
    //   35: istore 14
    //   37: aload 11
    //   39: astore_2
    //   40: aload 4
    //   42: getstatic 602	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   45: if_acmpne +132 -> 177
    //   48: aload 11
    //   50: astore_2
    //   51: new 235	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   58: aload_3
    //   59: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 604
    //   65: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore_3
    //   72: aload 11
    //   74: astore_2
    //   75: new 366	java/io/File
    //   78: dup
    //   79: aload 6
    //   81: aload_3
    //   82: invokespecial 607	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: astore_3
    //   86: new 609	java/io/FileOutputStream
    //   89: dup
    //   90: aload_3
    //   91: invokespecial 610	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: astore_2
    //   95: aload 4
    //   97: getstatic 613	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   100: if_acmpne +104 -> 204
    //   103: aload 5
    //   105: ifnull +99 -> 204
    //   108: aload 5
    //   110: invokevirtual 321	java/lang/String:length	()I
    //   113: istore 12
    //   115: iload 12
    //   117: ifle +87 -> 204
    //   120: iload 14
    //   122: istore 13
    //   124: aload_0
    //   125: aload_2
    //   126: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   129: aload_3
    //   130: astore_1
    //   131: aload 7
    //   133: astore_2
    //   134: iload 13
    //   136: ifeq +5 -> 141
    //   139: aload_1
    //   140: astore_2
    //   141: aload_2
    //   142: areturn
    //   143: new 366	java/io/File
    //   146: dup
    //   147: aload_2
    //   148: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 8
    //   153: aload_2
    //   154: astore 6
    //   156: aload 8
    //   158: invokevirtual 616	java/io/File:isDirectory	()Z
    //   161: ifne -142 -> 19
    //   164: aload_2
    //   165: astore 6
    //   167: aload 8
    //   169: invokevirtual 619	java/io/File:mkdirs	()Z
    //   172: ifne -153 -> 19
    //   175: aconst_null
    //   176: areturn
    //   177: aload 11
    //   179: astore_2
    //   180: new 235	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   187: aload_3
    //   188: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 621
    //   194: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore_3
    //   201: goto -129 -> 72
    //   204: aload_1
    //   205: aload 4
    //   207: bipush 90
    //   209: aload_2
    //   210: invokevirtual 625	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   213: istore 14
    //   215: iload 14
    //   217: istore 13
    //   219: goto -95 -> 124
    //   222: astore_3
    //   223: aload 8
    //   225: astore 4
    //   227: aload 9
    //   229: astore_1
    //   230: aload 4
    //   232: astore_2
    //   233: aload_3
    //   234: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   237: aload_0
    //   238: aload 4
    //   240: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   243: goto -112 -> 131
    //   246: astore_1
    //   247: aload_0
    //   248: aload_2
    //   249: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aload 10
    //   257: astore_2
    //   258: goto -11 -> 247
    //   261: astore_1
    //   262: goto -15 -> 247
    //   265: astore_2
    //   266: aload_3
    //   267: astore_1
    //   268: aload_2
    //   269: astore_3
    //   270: aload 8
    //   272: astore 4
    //   274: goto -44 -> 230
    //   277: astore 4
    //   279: aload_3
    //   280: astore_1
    //   281: aload 4
    //   283: astore_3
    //   284: aload_2
    //   285: astore 4
    //   287: goto -57 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	BitmapUtils
    //   0	290	1	paramBitmap	Bitmap
    //   0	290	2	paramString1	String
    //   0	290	3	paramString2	String
    //   0	290	4	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	290	5	paramString3	String
    //   17	149	6	str	String
    //   1	131	7	localObject1	Object
    //   29	242	8	localFile	File
    //   20	208	9	localObject2	Object
    //   26	230	10	localObject3	Object
    //   23	155	11	localObject4	Object
    //   113	3	12	i	int
    //   32	186	13	j	int
    //   35	181	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   40	48	222	java/lang/Exception
    //   51	72	222	java/lang/Exception
    //   75	86	222	java/lang/Exception
    //   180	201	222	java/lang/Exception
    //   40	48	246	finally
    //   51	72	246	finally
    //   75	86	246	finally
    //   180	201	246	finally
    //   233	237	246	finally
    //   86	95	254	finally
    //   95	103	261	finally
    //   108	115	261	finally
    //   204	215	261	finally
    //   86	95	265	java/lang/Exception
    //   95	103	277	java/lang/Exception
    //   108	115	277	java/lang/Exception
    //   204	215	277	java/lang/Exception
  }
  
  /* Error */
  public File saveJpegData(byte[] paramArrayOfByte, String paramString1, String paramString2, android.graphics.Bitmap.CompressFormat paramCompressFormat, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +119 -> 120
    //   4: aload_0
    //   5: getfield 48	com/tencent/util/BitmapUtils:context	Landroid/content/Context;
    //   8: invokevirtual 593	android/content/Context:getCacheDir	()Ljava/io/File;
    //   11: invokevirtual 596	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   14: astore 6
    //   16: aconst_null
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 10
    //   22: aconst_null
    //   23: astore 9
    //   25: aconst_null
    //   26: astore 7
    //   28: aload 10
    //   30: astore_2
    //   31: aload 4
    //   33: getstatic 602	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   36: if_acmpne +118 -> 154
    //   39: aload 10
    //   41: astore_2
    //   42: new 235	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   49: aload_3
    //   50: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 604
    //   56: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_3
    //   63: aload 10
    //   65: astore_2
    //   66: new 366	java/io/File
    //   69: dup
    //   70: aload 6
    //   72: aload_3
    //   73: invokespecial 607	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: astore_3
    //   77: new 609	java/io/FileOutputStream
    //   80: dup
    //   81: aload_3
    //   82: invokespecial 610	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: astore_2
    //   86: aload 4
    //   88: getstatic 613	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: if_acmpne +90 -> 181
    //   94: aload 5
    //   96: ifnull +85 -> 181
    //   99: aload 5
    //   101: invokevirtual 321	java/lang/String:length	()I
    //   104: istore 11
    //   106: iload 11
    //   108: ifle +73 -> 181
    //   111: aload_0
    //   112: aload_2
    //   113: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   116: aload_3
    //   117: astore_1
    //   118: aload_1
    //   119: areturn
    //   120: new 366	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 7
    //   130: aload_2
    //   131: astore 6
    //   133: aload 7
    //   135: invokevirtual 616	java/io/File:isDirectory	()Z
    //   138: ifne -122 -> 16
    //   141: aload_2
    //   142: astore 6
    //   144: aload 7
    //   146: invokevirtual 619	java/io/File:mkdirs	()Z
    //   149: ifne -133 -> 16
    //   152: aconst_null
    //   153: areturn
    //   154: aload 10
    //   156: astore_2
    //   157: new 235	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   164: aload_3
    //   165: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 621
    //   171: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_3
    //   178: goto -115 -> 63
    //   181: aload_2
    //   182: aload_1
    //   183: invokevirtual 633	java/io/OutputStream:write	([B)V
    //   186: goto -75 -> 111
    //   189: astore 5
    //   191: aload_3
    //   192: astore_1
    //   193: aload_2
    //   194: astore 4
    //   196: aload 5
    //   198: astore_3
    //   199: aload 4
    //   201: astore_2
    //   202: aload_3
    //   203: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   206: aload_0
    //   207: aload 4
    //   209: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   212: goto -94 -> 118
    //   215: astore_1
    //   216: aload_0
    //   217: aload_2
    //   218: invokespecial 334	com/tencent/util/BitmapUtils:closeStream	(Ljava/io/Closeable;)V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload 9
    //   226: astore_2
    //   227: goto -11 -> 216
    //   230: astore_1
    //   231: goto -15 -> 216
    //   234: astore_3
    //   235: aload 8
    //   237: astore_1
    //   238: aload 7
    //   240: astore 4
    //   242: goto -43 -> 199
    //   245: astore_2
    //   246: aload_3
    //   247: astore_1
    //   248: aload_2
    //   249: astore_3
    //   250: aload 7
    //   252: astore 4
    //   254: goto -55 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	BitmapUtils
    //   0	257	1	paramArrayOfByte	byte[]
    //   0	257	2	paramString1	String
    //   0	257	3	paramString2	String
    //   0	257	4	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	257	5	paramString3	String
    //   14	129	6	str	String
    //   26	225	7	localFile	File
    //   17	219	8	localObject1	Object
    //   23	202	9	localObject2	Object
    //   20	135	10	localObject3	Object
    //   104	3	11	i	int
    // Exception table:
    //   from	to	target	type
    //   86	94	189	java/lang/Exception
    //   99	106	189	java/lang/Exception
    //   181	186	189	java/lang/Exception
    //   31	39	215	finally
    //   42	63	215	finally
    //   66	77	215	finally
    //   157	178	215	finally
    //   202	206	215	finally
    //   77	86	223	finally
    //   86	94	230	finally
    //   99	106	230	finally
    //   181	186	230	finally
    //   31	39	234	java/lang/Exception
    //   42	63	234	java/lang/Exception
    //   66	77	234	java/lang/Exception
    //   157	178	234	java/lang/Exception
    //   77	86	245	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\util\BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */