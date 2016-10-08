package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MatrixUtil
{
  public MatrixUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[12] * paramArrayOfFloat[9] * paramArrayOfFloat[6] * paramArrayOfFloat[3] - paramArrayOfFloat[8] * paramArrayOfFloat[13] * paramArrayOfFloat[6] * paramArrayOfFloat[3] - paramArrayOfFloat[12] * paramArrayOfFloat[5] * paramArrayOfFloat[10] * paramArrayOfFloat[3] + paramArrayOfFloat[4] * paramArrayOfFloat[13] * paramArrayOfFloat[10] * paramArrayOfFloat[3] + paramArrayOfFloat[8] * paramArrayOfFloat[5] * paramArrayOfFloat[14] * paramArrayOfFloat[3] - paramArrayOfFloat[4] * paramArrayOfFloat[9] * paramArrayOfFloat[14] * paramArrayOfFloat[3] - paramArrayOfFloat[12] * paramArrayOfFloat[9] * paramArrayOfFloat[2] * paramArrayOfFloat[7] + paramArrayOfFloat[8] * paramArrayOfFloat[13] * paramArrayOfFloat[2] * paramArrayOfFloat[7] + paramArrayOfFloat[12] * paramArrayOfFloat[1] * paramArrayOfFloat[10] * paramArrayOfFloat[7] - paramArrayOfFloat[0] * paramArrayOfFloat[13] * paramArrayOfFloat[10] * paramArrayOfFloat[7] - paramArrayOfFloat[8] * paramArrayOfFloat[1] * paramArrayOfFloat[14] * paramArrayOfFloat[7] + paramArrayOfFloat[0] * paramArrayOfFloat[9] * paramArrayOfFloat[14] * paramArrayOfFloat[7] + paramArrayOfFloat[12] * paramArrayOfFloat[5] * paramArrayOfFloat[2] * paramArrayOfFloat[11] - paramArrayOfFloat[4] * paramArrayOfFloat[13] * paramArrayOfFloat[2] * paramArrayOfFloat[11] - paramArrayOfFloat[12] * paramArrayOfFloat[1] * paramArrayOfFloat[6] * paramArrayOfFloat[11] + paramArrayOfFloat[0] * paramArrayOfFloat[13] * paramArrayOfFloat[6] * paramArrayOfFloat[11] + paramArrayOfFloat[4] * paramArrayOfFloat[1] * paramArrayOfFloat[14] * paramArrayOfFloat[11] - paramArrayOfFloat[0] * paramArrayOfFloat[5] * paramArrayOfFloat[14] * paramArrayOfFloat[11] - paramArrayOfFloat[8] * paramArrayOfFloat[5] * paramArrayOfFloat[2] * paramArrayOfFloat[15] + paramArrayOfFloat[4] * paramArrayOfFloat[9] * paramArrayOfFloat[2] * paramArrayOfFloat[15] + paramArrayOfFloat[8] * paramArrayOfFloat[1] * paramArrayOfFloat[6] * paramArrayOfFloat[15] - paramArrayOfFloat[0] * paramArrayOfFloat[9] * paramArrayOfFloat[6] * paramArrayOfFloat[15] - paramArrayOfFloat[4] * paramArrayOfFloat[1] * paramArrayOfFloat[10] * paramArrayOfFloat[15] + paramArrayOfFloat[0] * paramArrayOfFloat[5] * paramArrayOfFloat[10] * paramArrayOfFloat[15];
  }
  
  public static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = 0;
    while (i < 16)
    {
      paramArrayOfFloat2[i] = paramArrayOfFloat1[i];
      i += 1;
    }
  }
  
  public static float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = 0;
    float f = 1.0F / a(paramArrayOfFloat1);
    paramArrayOfFloat2[0] = (paramArrayOfFloat1[6] * paramArrayOfFloat1[11] * paramArrayOfFloat1[13] - paramArrayOfFloat1[7] * paramArrayOfFloat1[10] * paramArrayOfFloat1[13] + paramArrayOfFloat1[7] * paramArrayOfFloat1[9] * paramArrayOfFloat1[14] - paramArrayOfFloat1[5] * paramArrayOfFloat1[11] * paramArrayOfFloat1[14] - paramArrayOfFloat1[6] * paramArrayOfFloat1[9] * paramArrayOfFloat1[15] + paramArrayOfFloat1[5] * paramArrayOfFloat1[10] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[4] = (paramArrayOfFloat1[3] * paramArrayOfFloat1[10] * paramArrayOfFloat1[13] - paramArrayOfFloat1[2] * paramArrayOfFloat1[11] * paramArrayOfFloat1[13] - paramArrayOfFloat1[3] * paramArrayOfFloat1[9] * paramArrayOfFloat1[14] + paramArrayOfFloat1[1] * paramArrayOfFloat1[11] * paramArrayOfFloat1[14] + paramArrayOfFloat1[2] * paramArrayOfFloat1[9] * paramArrayOfFloat1[15] - paramArrayOfFloat1[1] * paramArrayOfFloat1[10] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[8] = (paramArrayOfFloat1[2] * paramArrayOfFloat1[7] * paramArrayOfFloat1[13] - paramArrayOfFloat1[3] * paramArrayOfFloat1[6] * paramArrayOfFloat1[13] + paramArrayOfFloat1[3] * paramArrayOfFloat1[5] * paramArrayOfFloat1[14] - paramArrayOfFloat1[1] * paramArrayOfFloat1[7] * paramArrayOfFloat1[14] - paramArrayOfFloat1[2] * paramArrayOfFloat1[5] * paramArrayOfFloat1[15] + paramArrayOfFloat1[1] * paramArrayOfFloat1[6] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[12] = (paramArrayOfFloat1[3] * paramArrayOfFloat1[6] * paramArrayOfFloat1[9] - paramArrayOfFloat1[2] * paramArrayOfFloat1[7] * paramArrayOfFloat1[9] - paramArrayOfFloat1[3] * paramArrayOfFloat1[5] * paramArrayOfFloat1[10] + paramArrayOfFloat1[1] * paramArrayOfFloat1[7] * paramArrayOfFloat1[10] + paramArrayOfFloat1[2] * paramArrayOfFloat1[5] * paramArrayOfFloat1[11] - paramArrayOfFloat1[1] * paramArrayOfFloat1[6] * paramArrayOfFloat1[11]);
    paramArrayOfFloat2[1] = (paramArrayOfFloat1[7] * paramArrayOfFloat1[10] * paramArrayOfFloat1[12] - paramArrayOfFloat1[6] * paramArrayOfFloat1[11] * paramArrayOfFloat1[12] - paramArrayOfFloat1[7] * paramArrayOfFloat1[8] * paramArrayOfFloat1[14] + paramArrayOfFloat1[4] * paramArrayOfFloat1[11] * paramArrayOfFloat1[14] + paramArrayOfFloat1[6] * paramArrayOfFloat1[8] * paramArrayOfFloat1[15] - paramArrayOfFloat1[4] * paramArrayOfFloat1[10] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[5] = (paramArrayOfFloat1[2] * paramArrayOfFloat1[11] * paramArrayOfFloat1[12] - paramArrayOfFloat1[3] * paramArrayOfFloat1[10] * paramArrayOfFloat1[12] + paramArrayOfFloat1[3] * paramArrayOfFloat1[8] * paramArrayOfFloat1[14] - paramArrayOfFloat1[0] * paramArrayOfFloat1[11] * paramArrayOfFloat1[14] - paramArrayOfFloat1[2] * paramArrayOfFloat1[8] * paramArrayOfFloat1[15] + paramArrayOfFloat1[0] * paramArrayOfFloat1[10] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[9] = (paramArrayOfFloat1[3] * paramArrayOfFloat1[6] * paramArrayOfFloat1[12] - paramArrayOfFloat1[2] * paramArrayOfFloat1[7] * paramArrayOfFloat1[12] - paramArrayOfFloat1[3] * paramArrayOfFloat1[4] * paramArrayOfFloat1[14] + paramArrayOfFloat1[0] * paramArrayOfFloat1[7] * paramArrayOfFloat1[14] + paramArrayOfFloat1[2] * paramArrayOfFloat1[4] * paramArrayOfFloat1[15] - paramArrayOfFloat1[0] * paramArrayOfFloat1[6] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[13] = (paramArrayOfFloat1[2] * paramArrayOfFloat1[7] * paramArrayOfFloat1[8] - paramArrayOfFloat1[3] * paramArrayOfFloat1[6] * paramArrayOfFloat1[8] + paramArrayOfFloat1[3] * paramArrayOfFloat1[4] * paramArrayOfFloat1[10] - paramArrayOfFloat1[0] * paramArrayOfFloat1[7] * paramArrayOfFloat1[10] - paramArrayOfFloat1[2] * paramArrayOfFloat1[4] * paramArrayOfFloat1[11] + paramArrayOfFloat1[0] * paramArrayOfFloat1[6] * paramArrayOfFloat1[11]);
    paramArrayOfFloat2[2] = (paramArrayOfFloat1[5] * paramArrayOfFloat1[11] * paramArrayOfFloat1[12] - paramArrayOfFloat1[7] * paramArrayOfFloat1[9] * paramArrayOfFloat1[12] + paramArrayOfFloat1[7] * paramArrayOfFloat1[8] * paramArrayOfFloat1[13] - paramArrayOfFloat1[4] * paramArrayOfFloat1[11] * paramArrayOfFloat1[13] - paramArrayOfFloat1[5] * paramArrayOfFloat1[8] * paramArrayOfFloat1[15] + paramArrayOfFloat1[4] * paramArrayOfFloat1[9] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[6] = (paramArrayOfFloat1[3] * paramArrayOfFloat1[9] * paramArrayOfFloat1[12] - paramArrayOfFloat1[1] * paramArrayOfFloat1[11] * paramArrayOfFloat1[12] - paramArrayOfFloat1[3] * paramArrayOfFloat1[8] * paramArrayOfFloat1[13] + paramArrayOfFloat1[0] * paramArrayOfFloat1[11] * paramArrayOfFloat1[13] + paramArrayOfFloat1[1] * paramArrayOfFloat1[8] * paramArrayOfFloat1[15] - paramArrayOfFloat1[0] * paramArrayOfFloat1[9] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[10] = (paramArrayOfFloat1[1] * paramArrayOfFloat1[7] * paramArrayOfFloat1[12] - paramArrayOfFloat1[3] * paramArrayOfFloat1[5] * paramArrayOfFloat1[12] + paramArrayOfFloat1[3] * paramArrayOfFloat1[4] * paramArrayOfFloat1[13] - paramArrayOfFloat1[0] * paramArrayOfFloat1[7] * paramArrayOfFloat1[13] - paramArrayOfFloat1[1] * paramArrayOfFloat1[4] * paramArrayOfFloat1[15] + paramArrayOfFloat1[0] * paramArrayOfFloat1[5] * paramArrayOfFloat1[15]);
    paramArrayOfFloat2[14] = (paramArrayOfFloat1[3] * paramArrayOfFloat1[5] * paramArrayOfFloat1[8] - paramArrayOfFloat1[1] * paramArrayOfFloat1[7] * paramArrayOfFloat1[8] - paramArrayOfFloat1[3] * paramArrayOfFloat1[4] * paramArrayOfFloat1[9] + paramArrayOfFloat1[0] * paramArrayOfFloat1[7] * paramArrayOfFloat1[9] + paramArrayOfFloat1[1] * paramArrayOfFloat1[4] * paramArrayOfFloat1[11] - paramArrayOfFloat1[0] * paramArrayOfFloat1[5] * paramArrayOfFloat1[11]);
    paramArrayOfFloat2[3] = (paramArrayOfFloat1[6] * paramArrayOfFloat1[9] * paramArrayOfFloat1[12] - paramArrayOfFloat1[5] * paramArrayOfFloat1[10] * paramArrayOfFloat1[12] - paramArrayOfFloat1[6] * paramArrayOfFloat1[8] * paramArrayOfFloat1[13] + paramArrayOfFloat1[4] * paramArrayOfFloat1[10] * paramArrayOfFloat1[13] + paramArrayOfFloat1[5] * paramArrayOfFloat1[8] * paramArrayOfFloat1[14] - paramArrayOfFloat1[4] * paramArrayOfFloat1[9] * paramArrayOfFloat1[14]);
    paramArrayOfFloat2[7] = (paramArrayOfFloat1[1] * paramArrayOfFloat1[10] * paramArrayOfFloat1[12] - paramArrayOfFloat1[2] * paramArrayOfFloat1[9] * paramArrayOfFloat1[12] + paramArrayOfFloat1[2] * paramArrayOfFloat1[8] * paramArrayOfFloat1[13] - paramArrayOfFloat1[0] * paramArrayOfFloat1[10] * paramArrayOfFloat1[13] - paramArrayOfFloat1[1] * paramArrayOfFloat1[8] * paramArrayOfFloat1[14] + paramArrayOfFloat1[0] * paramArrayOfFloat1[9] * paramArrayOfFloat1[14]);
    paramArrayOfFloat2[11] = (paramArrayOfFloat1[2] * paramArrayOfFloat1[5] * paramArrayOfFloat1[12] - paramArrayOfFloat1[1] * paramArrayOfFloat1[6] * paramArrayOfFloat1[12] - paramArrayOfFloat1[2] * paramArrayOfFloat1[4] * paramArrayOfFloat1[13] + paramArrayOfFloat1[0] * paramArrayOfFloat1[6] * paramArrayOfFloat1[13] + paramArrayOfFloat1[1] * paramArrayOfFloat1[4] * paramArrayOfFloat1[14] - paramArrayOfFloat1[0] * paramArrayOfFloat1[5] * paramArrayOfFloat1[14]);
    paramArrayOfFloat2[15] = (paramArrayOfFloat1[1] * paramArrayOfFloat1[6] * paramArrayOfFloat1[8] - paramArrayOfFloat1[2] * paramArrayOfFloat1[5] * paramArrayOfFloat1[8] + paramArrayOfFloat1[2] * paramArrayOfFloat1[4] * paramArrayOfFloat1[9] - paramArrayOfFloat1[0] * paramArrayOfFloat1[6] * paramArrayOfFloat1[9] - paramArrayOfFloat1[1] * paramArrayOfFloat1[4] * paramArrayOfFloat1[10] + paramArrayOfFloat1[0] * paramArrayOfFloat1[5] * paramArrayOfFloat1[10]);
    while (i < 16)
    {
      paramArrayOfFloat2[i] *= f;
      i += 1;
    }
    return paramArrayOfFloat2;
  }
  
  public static float[] b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      while (j < 4)
      {
        paramArrayOfFloat2[(i * 4 + j)] = paramArrayOfFloat1[(j * 4 + i)];
        j += 1;
      }
      i += 1;
    }
    return paramArrayOfFloat2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\MatrixUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */