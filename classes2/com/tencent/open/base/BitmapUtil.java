package com.tencent.open.base;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BitmapUtil
{
  public BitmapUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.getConfig() != null)) {
      return paramBitmap;
    }
    Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, false);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    if (paramInt1 == -1) {
      paramInt1 = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
    }
    for (;;)
    {
      if (paramInt2 == -1) {
        paramInt2 = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
      }
      for (;;)
      {
        int i = paramInt2;
        int j = paramInt1;
        if (paramInt1 != -1)
        {
          i = paramInt2;
          j = paramInt1;
          if (paramInt2 != -1)
          {
            if (paramOptions.outHeight <= paramOptions.outWidth) {
              break label123;
            }
            if (!paramBoolean) {
              break label104;
            }
            j = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
            i = paramInt2;
          }
        }
        for (;;)
        {
          return Bitmap.createScaledBitmap(paramBitmap, j, i, true);
          label104:
          i = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
          j = paramInt1;
          continue;
          label123:
          if (paramBoolean)
          {
            i = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
            j = paramInt1;
          }
          else
          {
            j = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
            i = paramInt2;
          }
        }
      }
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore 4
    //   10: aload_0
    //   11: ifnull +21 -> 32
    //   14: new 57	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 64	java/io/File:exists	()Z
    //   25: ifne +10 -> 35
    //   28: aload 5
    //   30: astore 4
    //   32: aload 4
    //   34: areturn
    //   35: invokestatic 67	com/tencent/open/base/BitmapUtil:a	()Landroid/graphics/BitmapFactory$Options;
    //   38: astore 7
    //   40: aload_0
    //   41: aload 7
    //   43: invokestatic 73	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   46: pop
    //   47: aload 5
    //   49: astore 4
    //   51: aload 7
    //   53: getfield 46	android/graphics/BitmapFactory$Options:outHeight	I
    //   56: ifle -24 -> 32
    //   59: aload 5
    //   61: astore 4
    //   63: aload 7
    //   65: getfield 43	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: ifle -36 -> 32
    //   71: aload 7
    //   73: iload_1
    //   74: iload_2
    //   75: iload_3
    //   76: invokestatic 76	com/tencent/open/base/BitmapUtil:a	(Landroid/graphics/BitmapFactory$Options;IIZ)Landroid/graphics/BitmapFactory$Options;
    //   79: pop
    //   80: aload_0
    //   81: aload 7
    //   83: invokestatic 73	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   86: astore 4
    //   88: aload 4
    //   90: astore_0
    //   91: aload 5
    //   93: astore 4
    //   95: aload_0
    //   96: ifnull -64 -> 32
    //   99: aload_0
    //   100: invokevirtual 79	android/graphics/Bitmap:hasAlpha	()Z
    //   103: ifeq +53 -> 156
    //   106: getstatic 29	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   109: astore 4
    //   111: aload 7
    //   113: aload 4
    //   115: putfield 82	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   118: aload_0
    //   119: iload_1
    //   120: iload_2
    //   121: aload 7
    //   123: iload_3
    //   124: invokestatic 84	com/tencent/open/base/BitmapUtil:a	(Landroid/graphics/Bitmap;IILandroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/Bitmap;
    //   127: astore 4
    //   129: aload 4
    //   131: areturn
    //   132: astore 4
    //   134: aload 7
    //   136: aload 7
    //   138: getfield 87	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   141: iconst_1
    //   142: isub
    //   143: putfield 87	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   146: aload_0
    //   147: aload 7
    //   149: invokestatic 73	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   152: astore_0
    //   153: goto -62 -> 91
    //   156: getstatic 90	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   159: astore 4
    //   161: goto -50 -> 111
    //   164: astore 5
    //   166: aload 6
    //   168: astore_0
    //   169: aload_0
    //   170: astore 4
    //   172: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq -143 -> 32
    //   178: ldc 97
    //   180: iconst_2
    //   181: aload 5
    //   183: invokestatic 101	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   186: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload_0
    //   190: areturn
    //   191: astore 5
    //   193: goto -24 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramString	String
    //   0	196	1	paramInt1	int
    //   0	196	2	paramInt2	int
    //   0	196	3	paramBoolean	boolean
    //   8	122	4	localObject1	Object
    //   132	1	4	localException	Exception
    //   159	12	4	localObject2	Object
    //   4	88	5	localObject3	Object
    //   164	18	5	localOutOfMemoryError1	OutOfMemoryError
    //   191	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   1	166	6	localObject4	Object
    //   38	110	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   80	88	132	java/lang/Exception
    //   35	47	164	java/lang/OutOfMemoryError
    //   51	59	164	java/lang/OutOfMemoryError
    //   63	80	164	java/lang/OutOfMemoryError
    //   80	88	164	java/lang/OutOfMemoryError
    //   134	153	164	java/lang/OutOfMemoryError
    //   99	111	191	java/lang/OutOfMemoryError
    //   111	129	191	java/lang/OutOfMemoryError
    //   156	161	191	java/lang/OutOfMemoryError
  }
  
  public static BitmapFactory.Options a()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    return localOptions;
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inSampleSize = 2;
    if (paramBoolean) {
      while ((paramOptions.outWidth / paramOptions.inSampleSize >= paramInt1) || (paramOptions.outHeight / paramOptions.inSampleSize >= paramInt2)) {
        paramOptions.inSampleSize += 1;
      }
    }
    while ((paramOptions.outWidth / paramOptions.inSampleSize >= paramInt1) && (paramOptions.outHeight / paramOptions.inSampleSize >= paramInt2)) {
      paramOptions.inSampleSize += 1;
    }
    paramOptions.inSampleSize -= 1;
    return paramOptions;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\BitmapUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */