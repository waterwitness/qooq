package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class Flake
{
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  float d;
  float e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Flake a(float paramFloat, Bitmap paramBitmap, int paramInt, Resources paramResources)
  {
    Flake localFlake = new Flake();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localFlake.jdField_c_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      localFlake.jdField_c_of_type_Float = ((float)Math.random() * 30.0F - 15.0F);
      localFlake.jdField_a_of_type_Int = ((int)(AIOUtils.a(25.0F, paramResources) + (float)Math.random() * AIOUtils.a(15.0F, paramResources)));
      localFlake.jdField_b_of_type_Int = ((int)(f * localFlake.jdField_a_of_type_Int));
      localFlake.d = (AIOUtils.a(240.0F, paramResources) + (float)Math.random() * AIOUtils.a(100.0F, paramResources));
    }
    for (localFlake.jdField_b_of_type_Float = (-4.0F * (float)Math.random() * localFlake.jdField_b_of_type_Int);; localFlake.jdField_b_of_type_Float = (-6.0F * (float)Math.random() * localFlake.jdField_b_of_type_Int))
    {
      localFlake.jdField_a_of_type_Float = ((float)Math.random() * (paramFloat - localFlake.jdField_a_of_type_Int));
      localFlake.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localFlake.jdField_a_of_type_Int)));
      if (localFlake.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localFlake.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localFlake.jdField_a_of_type_Int, localFlake.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localFlake.jdField_a_of_type_Int), localFlake.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localFlake;
      localFlake.jdField_c_of_type_Float = ((float)Math.random() * 90.0F - 45.0F);
      localFlake.d = (AIOUtils.a(85.0F, paramResources) + (float)Math.random() * AIOUtils.a(55.0F, paramResources));
      localFlake.jdField_a_of_type_Int = ((int)(AIOUtils.a(8.0F, paramResources) + (float)Math.random() * AIOUtils.a(6.0F, paramResources)));
      localFlake.jdField_b_of_type_Int = ((int)(f * localFlake.jdField_a_of_type_Int));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\Flake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */