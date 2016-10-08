package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class SaQian
{
  static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  double jdField_a_of_type_Double;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  float[] jdField_a_of_type_ArrayOfFloat;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  float e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  static Bitmap a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    Bitmap localBitmap2 = (Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, paramInt2, paramInt3, true);
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), localBitmap1);
    }
    return localBitmap1;
  }
  
  static SaQian a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt, Resources paramResources)
  {
    SaQian localSaQian = new SaQian();
    localSaQian.jdField_d_of_type_Int = paramInt;
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    if (paramInt == 0) {}
    for (localSaQian.jdField_a_of_type_Int = AIOUtils.a(30.0F, paramResources);; localSaQian.jdField_a_of_type_Int = AIOUtils.a(22.0F, paramResources))
    {
      localSaQian.jdField_b_of_type_Int = ((int)(f * localSaQian.jdField_a_of_type_Int));
      localSaQian.jdField_a_of_type_ArrayOfFloat = new float[2];
      localSaQian.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
      localSaQian.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
      localSaQian.jdField_a_of_type_Float = ((float)Math.random() * AIOUtils.a(18.0F, paramResources) - AIOUtils.a(18.0F, paramResources));
      localSaQian.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.3089969389957472D);
      localSaQian.jdField_b_of_type_Float = (AIOUtils.a(150.0F, paramResources) + (float)Math.random() * AIOUtils.a(50.0F, paramResources));
      localSaQian.jdField_c_of_type_Float = ((float)(localSaQian.jdField_b_of_type_Float * Math.cos(localSaQian.jdField_a_of_type_Double)));
      localSaQian.jdField_d_of_type_Float = ((float)(localSaQian.jdField_b_of_type_Float * Math.sin(localSaQian.jdField_a_of_type_Double)));
      localSaQian.jdField_c_of_type_Int = 256;
      localSaQian.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localSaQian.jdField_d_of_type_Int)));
      if (localSaQian.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localSaQian.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localSaQian.jdField_a_of_type_Int, localSaQian.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localSaQian.jdField_d_of_type_Int), localSaQian.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localSaQian;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\SaQian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */