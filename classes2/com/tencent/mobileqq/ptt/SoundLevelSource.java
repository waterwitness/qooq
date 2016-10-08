package com.tencent.mobileqq.ptt;

import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SoundLevelSource
{
  private static final String jdField_a_of_type_JavaLangString = "SoundLevelSource";
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int;
  
  public SoundLevelSource()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 75.0F;
  }
  
  private int a(float paramFloat)
  {
    int j = (int)(100.0F * (Math.min(Math.max(paramFloat, -2.0F), 10.0F) + 2.0F) / 12.0F);
    int i = 0;
    if (j >= 30) {
      i = j / 10 * 10;
    }
    Log.v("SoundLevelSource", "RmsDb:" + paramFloat + "-->Volume:" + i);
    return i;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    a(-1);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Float < paramFloat) {}
    for (this.jdField_a_of_type_Float = (0.999F * this.jdField_a_of_type_Float + 0.001F * paramFloat);; this.jdField_a_of_type_Float = (0.95F * this.jdField_a_of_type_Float + 0.05F * paramFloat))
    {
      float f2 = -120.0F;
      float f1 = f2;
      if (this.jdField_a_of_type_Float > 0.0D)
      {
        f1 = f2;
        if (paramFloat / this.jdField_a_of_type_Float > 1.0E-6D) {
          f1 = 10.0F * (float)Math.log10(paramFloat / this.jdField_a_of_type_Float);
        }
      }
      a(a(f1));
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (((paramInt >= 0) && (paramInt <= 100)) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\SoundLevelSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */