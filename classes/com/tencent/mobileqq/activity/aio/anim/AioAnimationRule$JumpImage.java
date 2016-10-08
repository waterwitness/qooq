package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AioAnimationRule$JumpImage
{
  public static final int a = 0;
  public static final String a = "Emoji";
  public static final int b = 1;
  public static final String b = "Face";
  public static final int c = 2;
  public static final String c = "Image";
  public static final int d;
  String d;
  int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_d_of_type_Int = (int)(32.0F * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int a(String paramString)
  {
    if (paramString.equalsIgnoreCase("Emoji")) {
      return 0;
    }
    if (paramString.equalsIgnoreCase("Face")) {
      return 1;
    }
    if (paramString.equalsIgnoreCase("Image")) {
      return 2;
    }
    return -1;
  }
  
  public static Drawable a(Context paramContext, JumpImage paramJumpImage)
  {
    Object localObject = null;
    switch (paramJumpImage.e)
    {
    default: 
      paramContext = (Context)localObject;
    case 0: 
    case 1: 
      do
      {
        do
        {
          int i;
          do
          {
            return paramContext;
            i = Integer.valueOf(paramJumpImage.jdField_d_of_type_JavaLangString).intValue();
            paramContext = (Context)localObject;
          } while (i < 0);
          paramJumpImage = TextUtils.a(i);
          paramContext = paramJumpImage;
        } while (paramJumpImage == null);
        paramJumpImage.setBounds(new Rect(0, 0, jdField_d_of_type_Int, jdField_d_of_type_Int));
        return paramJumpImage;
        paramJumpImage = a(paramJumpImage.jdField_d_of_type_JavaLangString);
        paramContext = paramJumpImage;
      } while (paramJumpImage == null);
      paramJumpImage.setBounds(new Rect(0, 0, jdField_d_of_type_Int, jdField_d_of_type_Int));
      return paramJumpImage;
    }
    String str2 = AioAnimationConfigHelper.o + paramJumpImage.jdField_d_of_type_JavaLangString;
    String str1 = "JumpImage:" + str2;
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.a.get(str1);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      localBitmap = BitmapManager.a(str2);
      if (localBitmap == null) {
        break label244;
      }
      BaseApplicationImpl.a.put(str1, localBitmap);
      localObject = localBitmap;
    }
    for (;;)
    {
      paramContext = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject);
      paramContext.setBounds(new Rect(0, 0, jdField_d_of_type_Int, jdField_d_of_type_Int));
      return paramContext;
      label244:
      localObject = localBitmap;
      if (QLog.isColorLevel())
      {
        QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + paramJumpImage.jdField_d_of_type_JavaLangString);
        localObject = localBitmap;
      }
    }
  }
  
  public static Drawable a(String paramString)
  {
    int j = EmotcationConstants.a.length;
    int i = 0;
    if (i < j) {
      if (paramString.equals(EmotcationConstants.a[i]))
      {
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationRule", 2, "find str = " + paramString + ", index = " + i);
        }
      }
    }
    for (j = i;; j = -1)
    {
      if (j < 0)
      {
        return null;
        i += 1;
        break;
      }
      return TextUtils.a(j, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\AioAnimationRule$JumpImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */