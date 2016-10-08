package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class FlowThumbDecoder
  implements BitmapDecoder
{
  public static float a = 0.0F;
  static final int jdField_a_of_type_Int = -1;
  private static final String jdField_a_of_type_JavaLangString = "FlowThumbDecoder";
  public static float b = 0.0F;
  static final int b = 0;
  public static float c = 0.0F;
  static final int c = 1;
  public static float d = 0.0F;
  static final int d = 2;
  public static float e;
  private Context jdField_a_of_type_AndroidContentContext;
  LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private float f;
  
  public FlowThumbDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = paramContext.getResources().getDisplayMetrics().density;
    if (jdField_a_of_type_Float == 0.0F) {
      throw new RuntimeException("Not init item size...");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = 1;
    while (paramInt1 > paramInt2)
    {
      i *= 2;
      paramInt1 /= 2;
    }
    return i;
  }
  
  public static int a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return -1;
    }
    if ((paramLocalMediaInfo.jdField_a_of_type_Int == 90) || (paramLocalMediaInfo.jdField_a_of_type_Int == 270)) {}
    for (float f1 = paramInt2 / paramInt1; (Float.compare(f1, e) != -1) && (Float.compare(f1, d) != 1); f1 = paramInt1 / paramInt2) {
      return 0;
    }
    if (Float.compare(f1, e) == -1) {
      return 1;
    }
    return 2;
  }
  
  /* Error */
  protected static Bitmap a(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 92	com/tencent/mobileqq/utils/AlbumUtil:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I
    //   6: istore 4
    //   8: iload 4
    //   10: ifne +17 -> 27
    //   13: aload_1
    //   14: getfield 94	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: aload_2
    //   18: invokestatic 100	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: astore_3
    //   22: aload_3
    //   23: areturn
    //   24: astore_0
    //   25: aload_0
    //   26: athrow
    //   27: iload 4
    //   29: iconst_1
    //   30: if_icmpne -8 -> 22
    //   33: aload_1
    //   34: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:b	Z
    //   37: ifeq +17 -> 54
    //   40: aload_0
    //   41: invokevirtual 106	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   44: aload_1
    //   45: getfield 109	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_Long	J
    //   48: iconst_1
    //   49: aload_2
    //   50: invokestatic 115	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   53: areturn
    //   54: aload_1
    //   55: getfield 94	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: iconst_1
    //   59: invokestatic 121	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   62: astore_0
    //   63: aload_0
    //   64: astore_3
    //   65: aload_2
    //   66: ifnull -44 -> 22
    //   69: aload_0
    //   70: astore_3
    //   71: aload_0
    //   72: ifnull -50 -> 22
    //   75: aload_2
    //   76: aload_0
    //   77: invokevirtual 127	android/graphics/Bitmap:getHeight	()I
    //   80: putfield 132	android/graphics/BitmapFactory$Options:outHeight	I
    //   83: aload_2
    //   84: aload_0
    //   85: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   88: putfield 138	android/graphics/BitmapFactory$Options:outWidth	I
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: aconst_null
    //   95: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramLocalMediaInfo	LocalMediaInfo
    //   0	96	2	paramOptions	BitmapFactory.Options
    //   1	70	3	localObject	Object
    //   6	25	4	i	int
    // Exception table:
    //   from	to	target	type
    //   13	22	24	finally
    //   13	22	93	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions, int paramInt)
  {
    Object localObject = null;
    if (paramInt == 1) {
      paramOptions.inSampleSize = a(paramOptions.outWidth, paramLocalMediaInfo.f);
    }
    int j;
    int k;
    int i;
    try
    {
      for (;;)
      {
        paramOptions = a(paramContext, paramLocalMediaInfo, paramOptions);
        if (paramOptions != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
        }
        paramLocalMediaInfo = paramOptions;
        return paramLocalMediaInfo;
        if (paramInt == 2) {
          paramOptions.inSampleSize = a(paramOptions.outHeight, paramLocalMediaInfo.g);
        } else {
          paramOptions.inSampleSize = a(paramOptions.outWidth, paramLocalMediaInfo.f);
        }
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramOptions = null;
      }
      j = paramOptions.getWidth();
      k = paramOptions.getHeight();
      i = paramLocalMediaInfo.jdField_a_of_type_Int;
      if ((paramInt == 0) && (i == 0) && (j == paramLocalMediaInfo.f) && (k == paramLocalMediaInfo.g) && (paramOptions.getConfig() == Bitmap.Config.RGB_565)) {
        return paramOptions;
      }
      if (paramInt != 1) {
        break label389;
      }
    }
    if ((i == 90) || (i == 270))
    {
      paramInt = paramLocalMediaInfo.f * k / paramLocalMediaInfo.g;
      j = (j - paramInt) / 2;
      paramContext = new Rect(j, 0, paramInt + j, k);
    }
    for (;;)
    {
      label218:
      Rect localRect = new Rect(0, 0, paramLocalMediaInfo.f, paramLocalMediaInfo.g);
      Bitmap localBitmap = Bitmap.createBitmap(paramLocalMediaInfo.f, paramLocalMediaInfo.g, Bitmap.Config.RGB_565);
      paramLocalMediaInfo = (LocalMediaInfo)localObject;
      if (localBitmap == null) {
        break;
      }
      new Canvas(localBitmap).drawBitmap(paramOptions, paramContext, localRect, new Paint(6));
      paramOptions.recycle();
      if (i != 0) {}
      for (paramOptions = a(localBitmap, i);; paramOptions = localBitmap)
      {
        paramLocalMediaInfo = paramOptions;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FlowThumbDecoder", 2, "FlowThumbDecoder src " + paramContext + ", dst " + localRect);
        return paramOptions;
        paramInt = paramLocalMediaInfo.g * j / paramLocalMediaInfo.f;
        k = (k - paramInt) / 2;
        paramContext = new Rect(0, k, j, paramInt + k);
        break label218;
        label389:
        if (paramInt != 2) {
          break label497;
        }
        if ((i == 90) || (i == 270))
        {
          paramInt = paramLocalMediaInfo.g * j / paramLocalMediaInfo.f;
          k = (k - paramInt) / 2;
          paramContext = new Rect(0, k, j, paramInt + k);
          break label218;
        }
        paramInt = paramLocalMediaInfo.f * k / paramLocalMediaInfo.g;
        j = (j - paramInt) / 2;
        paramContext = new Rect(j, 0, paramInt + j, k);
        break label218;
      }
      label497:
      paramContext = null;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramInt != 0)
    {
      localObject = paramBitmap;
      if (paramBitmap != null)
      {
        localObject = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localObject = new Matrix();
          ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
        }
      }
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
    catch (OutOfMemoryError paramBitmap)
    {
      throw paramBitmap;
    }
  }
  
  public static void a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    int i = a(paramLocalMediaInfo, paramInt1, paramInt2);
    if (i == 0) {
      if (paramLocalMediaInfo.f <= 0) {
        paramLocalMediaInfo.f = (paramLocalMediaInfo.g * paramInt1 / paramInt2);
      }
    }
    label30:
    do
    {
      do
      {
        do
        {
          break label30;
          do
          {
            return;
          } while (paramLocalMediaInfo.g > 0);
          paramLocalMediaInfo.g = (paramLocalMediaInfo.f * paramInt2 / paramInt1);
          return;
          if (i != 1) {
            break;
          }
          if (paramLocalMediaInfo.f <= 0)
          {
            paramLocalMediaInfo.f = ((int)c);
            return;
          }
        } while (paramLocalMediaInfo.g > 0);
        paramLocalMediaInfo.g = ((int)c);
        return;
      } while (i != 2);
      if (paramLocalMediaInfo.f <= 0)
      {
        paramLocalMediaInfo.f = ((int)b);
        return;
      }
    } while (paramLocalMediaInfo.g > 0);
    paramLocalMediaInfo.g = ((int)b);
  }
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.jdField_a_of_type_AndroidContentContext;
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
    int i = URLDrawableHelper.a(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
    if ((i == 90) || (i == 270)) {
      localLocalMediaInfo.f = ((int)jdField_a_of_type_Float);
    }
    BitmapFactory.Options localOptions;
    for (localLocalMediaInfo.g = 0;; localLocalMediaInfo.g = ((int)jdField_a_of_type_Float))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      a(paramURL, localLocalMediaInfo, localOptions);
      if ((localOptions.outWidth != 0) && (localOptions.outHeight != 0)) {
        break;
      }
      return null;
      localLocalMediaInfo.f = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FlowThumbDecoder", 2, "FlowThumbDecoder origin w " + localOptions.outWidth + " h " + localOptions.outHeight);
    }
    localOptions.inJustDecodeBounds = false;
    i = a(localLocalMediaInfo, localOptions.outWidth, localOptions.outHeight);
    if ((localLocalMediaInfo.f <= 0) || (localLocalMediaInfo.g <= 0)) {
      a(localLocalMediaInfo, localOptions.outWidth, localOptions.outHeight);
    }
    return a(paramURL, localLocalMediaInfo, localOptions, i);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\FlowThumbDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */