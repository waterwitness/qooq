package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class Pcm2AmrWrapper
{
  private static final String jdField_a_of_type_JavaLangString = "Pcm2AmrWrapper";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int jdField_b_of_type_Int = 320;
  private static final int jdField_c_of_type_Int = 10240;
  private int jdField_a_of_type_Int;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public Pcm2AmrWrapper(Context paramContext, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 14;
    this.f = 1;
    this.jdField_a_of_type_ArrayOfByte = new byte['ŀ'];
    this.c = new byte['ŀ'];
    this.jdField_d_of_type_ArrayOfByte = new byte['⠀'];
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
    this.f = paramInt;
    this.jdField_a_of_type_Int = Amr2PcmWrapper.a(paramInt);
    this.b = new byte[this.jdField_a_of_type_Int];
    this.jdField_d_of_type_Int = AmrInputStreamWrapper.CreateEncoder();
    this.e = AmrInputStreamWrapper.GsmAmrEncoderNew(this.jdField_d_of_type_Int);
    AmrInputStreamWrapper.GsmAmrEncoderInitialize(this.e);
  }
  
  public static void a(Context paramContext)
  {
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((this.jdField_d_of_type_Int == 0) || (this.e == 0)) {
      throw new IllegalStateException("not open");
    }
    if (AmrInputStreamWrapper.GsmAmrEncoderEncode(this.jdField_d_of_type_Int, this.e, this.f, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
      b();
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   4: ifeq +14 -> 18
    //   7: aload_0
    //   8: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   11: aload_0
    //   12: getfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   15: invokestatic 96	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(II)V
    //   18: aload_0
    //   19: getfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   22: ifeq +14 -> 36
    //   25: aload_0
    //   26: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   29: aload_0
    //   30: getfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   33: invokestatic 99	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   41: aload_0
    //   42: invokevirtual 91	com/tencent/mobileqq/utils/Pcm2AmrWrapper:b	()V
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   59: ifeq +14 -> 73
    //   62: aload_0
    //   63: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   66: aload_0
    //   67: getfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   70: invokestatic 99	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 71	com/tencent/mobileqq/utils/Pcm2AmrWrapper:e	I
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	Pcm2AmrWrapper
    //   46	7	1	localObject1	Object
    //   54	25	1	localObject2	Object
    //   80	7	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	36	46	finally
    //   0	18	54	finally
    //   55	73	80	finally
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.g + paramInt > 10240) {
      this.jdField_d_of_type_ArrayOfByte = new byte[this.g + paramInt];
    }
    if (this.g + paramInt < 320)
    {
      System.arraycopy(paramArrayOfByte, 0, this.c, this.g, paramInt);
      return null;
    }
    System.arraycopy(this.c, 0, this.jdField_d_of_type_ArrayOfByte, 0, this.g);
    System.arraycopy(paramArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, this.g, paramInt);
    this.h = (this.g + paramInt);
    paramInt = this.h % 320;
    this.g = paramInt;
    if (paramInt != 0) {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, this.h - paramInt, this.c, 0, paramInt);
    }
    paramArrayOfByte = new byte[this.h / 320 * this.jdField_a_of_type_Int];
    int i = 0;
    paramInt = 0;
    while (this.h >= 320)
    {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, paramInt, this.jdField_a_of_type_ArrayOfByte, 0, 320);
      try
      {
        a(this.jdField_a_of_type_ArrayOfByte, this.b);
        System.arraycopy(this.b, 0, paramArrayOfByte, i, this.b.length);
        i += this.b.length;
        paramInt += 320;
        this.h -= 320;
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Pcm2AmrWrapper", 2, "========mPcm2Amr.pcm2amrParser==IOException=====", paramArrayOfByte);
        }
        b();
        return null;
      }
    }
    if (i == paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public void b()
  {
    this.g = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\Pcm2AmrWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */