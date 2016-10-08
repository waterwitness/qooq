package com.tencent.ttpic.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.util.BitmapUtils;

public class VideoBitmapUtil
{
  private static final String TAG = BitmapUtils.class.getSimpleName();
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int i = 1;
    int j;
    if ((paramInt2 <= 0) || (k <= paramInt2))
    {
      j = i;
      if (paramInt1 > 0)
      {
        j = i;
        if (m <= paramInt1) {}
      }
    }
    else
    {
      i = Math.round(k / paramInt2);
      j = Math.round(m / paramInt1);
      if (i < j) {}
      for (;;)
      {
        float f1 = m * k;
        float f2 = paramInt1 * paramInt2 * 2;
        for (;;)
        {
          j = i;
          if (f1 / (i * i) <= f2) {
            break;
          }
          i += 1;
        }
        i = j;
      }
    }
    return j;
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith("assets://")) {
      return decodeSampleBitmapFromAssets(paramContext, VideoUtil.getRealPath(paramString), paramInt1, paramInt2);
    }
    return decodeSampledBitmapFromFile(paramString, paramInt1, paramInt2);
  }
  
  /* Error */
  public static Bitmap decodeSampleBitmapFromAssets(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 4
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 78	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   19: astore_0
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 84	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore 4
    //   27: new 26	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 85	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: iconst_1
    //   39: putfield 89	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload 4
    //   44: aconst_null
    //   45: aload 6
    //   47: invokestatic 95	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: pop
    //   51: aload 6
    //   53: iconst_0
    //   54: putfield 89	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   57: aload 6
    //   59: aload 6
    //   61: iload_2
    //   62: iload_3
    //   63: invokestatic 97	com/tencent/ttpic/util/VideoBitmapUtil:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   66: putfield 100	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   69: aload 6
    //   71: iconst_1
    //   72: putfield 103	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   75: aconst_null
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload 4
    //   81: invokevirtual 108	java/io/InputStream:reset	()V
    //   84: aload 4
    //   86: aconst_null
    //   87: aload 6
    //   89: invokestatic 95	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   92: astore 5
    //   94: aload 5
    //   96: astore_1
    //   97: aload_1
    //   98: astore_0
    //   99: aload 4
    //   101: ifnull -88 -> 13
    //   104: aload 4
    //   106: invokevirtual 111	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: areturn
    //   111: astore_0
    //   112: aload_1
    //   113: areturn
    //   114: astore 4
    //   116: aload_0
    //   117: new 113	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: iconst_0
    //   126: aload_1
    //   127: bipush 46
    //   129: invokevirtual 118	java/lang/String:lastIndexOf	(I)I
    //   132: iconst_1
    //   133: iadd
    //   134: invokevirtual 122	java/lang/String:substring	(II)Ljava/lang/String;
    //   137: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc -128
    //   142: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 84	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   151: astore 4
    //   153: goto -126 -> 27
    //   156: astore_0
    //   157: getstatic 18	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   160: aload_0
    //   161: invokevirtual 132	java/io/IOException:toString	()Ljava/lang/String;
    //   164: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: aconst_null
    //   169: areturn
    //   170: astore_1
    //   171: getstatic 18	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   174: aload_1
    //   175: invokevirtual 132	java/io/IOException:toString	()Ljava/lang/String;
    //   178: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   181: pop
    //   182: aload 4
    //   184: ifnull -171 -> 13
    //   187: aload 4
    //   189: invokevirtual 111	java/io/InputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aconst_null
    //   196: areturn
    //   197: astore_0
    //   198: aload 6
    //   200: aload 6
    //   202: getfield 100	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   205: iconst_1
    //   206: ishl
    //   207: putfield 100	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   210: aload 4
    //   212: invokevirtual 108	java/io/InputStream:reset	()V
    //   215: aload 4
    //   217: aconst_null
    //   218: aload 6
    //   220: invokestatic 95	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   223: astore_0
    //   224: aload_0
    //   225: astore_1
    //   226: aload_1
    //   227: astore_0
    //   228: aload 4
    //   230: ifnull -217 -> 13
    //   233: aload 4
    //   235: invokevirtual 111	java/io/InputStream:close	()V
    //   238: aload_1
    //   239: areturn
    //   240: astore_0
    //   241: aload_1
    //   242: areturn
    //   243: astore_0
    //   244: getstatic 18	com/tencent/ttpic/util/VideoBitmapUtil:TAG	Ljava/lang/String;
    //   247: aload_0
    //   248: invokevirtual 141	java/lang/Throwable:toString	()Ljava/lang/String;
    //   251: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   254: pop
    //   255: goto -29 -> 226
    //   258: astore_0
    //   259: aload 4
    //   261: ifnull +8 -> 269
    //   264: aload 4
    //   266: invokevirtual 111	java/io/InputStream:close	()V
    //   269: aload_0
    //   270: athrow
    //   271: astore_1
    //   272: goto -3 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramContext	Context
    //   0	275	1	paramString	String
    //   0	275	2	paramInt1	int
    //   0	275	3	paramInt2	int
    //   1	104	4	localInputStream1	java.io.InputStream
    //   114	1	4	localIOException	java.io.IOException
    //   151	114	4	localInputStream2	java.io.InputStream
    //   92	3	5	localBitmap	Bitmap
    //   34	185	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   104	109	111	java/io/IOException
    //   20	27	114	java/io/IOException
    //   116	153	156	java/io/IOException
    //   79	94	170	java/io/IOException
    //   187	192	194	java/io/IOException
    //   79	94	197	java/lang/OutOfMemoryError
    //   233	238	240	java/io/IOException
    //   210	224	243	java/io/IOException
    //   210	224	243	java/lang/OutOfMemoryError
    //   79	94	258	finally
    //   171	182	258	finally
    //   198	210	258	finally
    //   210	224	258	finally
    //   244	255	258	finally
    //   264	269	271	java/io/IOException
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    localOptions.inPreferQualityOverSpeed = true;
    paramInt1 = getDegree(paramString) % 360;
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      localObject = localBitmap;
      if (paramInt1 != 0)
      {
        localObject = localBitmap;
        localBitmap = rotate(localBitmap, paramInt1);
        localObject = localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOptions.inSampleSize <<= 1;
        try
        {
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
          localObject = paramString;
          if (paramInt1 == 0) {
            continue;
          }
          localObject = paramString;
          paramString = rotate(paramString, paramInt1);
          return paramString;
        }
        catch (OutOfMemoryError paramString)
        {
          Log.e(TAG, paramString.toString());
        }
      }
    }
    return (Bitmap)localObject;
    return (Bitmap)localObject;
  }
  
  public static int getDegree(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
      try
      {
        paramString = new ExifInterface(paramString);
        if (paramString != null)
        {
          int i = getDegreeFromOrientation(paramString.getAttributeInt("Orientation", 0));
          return i;
        }
      }
      catch (Exception paramString) {}
    }
    return 0;
  }
  
  public static int getDegreeFromOrientation(int paramInt)
  {
    switch (paramInt)
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
  
  public static boolean isLegal(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return (Bitmap)localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e(TAG, "OutOfMemoryError. " + localOutOfMemoryError);
    }
    return paramBitmap;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoBitmapUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */