package com.google.zxing.qrcode.decoder;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Version$ECBlocks
{
  private final int jdField_a_of_type_Int;
  private final Version.ECB[] jdField_a_of_type_ArrayOfComGoogleZxingQrcodeDecoderVersion$ECB;
  
  Version$ECBlocks(int paramInt, Version.ECB... paramVarArgs)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfComGoogleZxingQrcodeDecoderVersion$ECB = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Version.ECB[] a()
  {
    return this.jdField_a_of_type_ArrayOfComGoogleZxingQrcodeDecoderVersion$ECB;
  }
  
  public int b()
  {
    int i = 0;
    Version.ECB[] arrayOfECB = this.jdField_a_of_type_ArrayOfComGoogleZxingQrcodeDecoderVersion$ECB;
    int k = arrayOfECB.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfECB[i].a();
      i += 1;
    }
    return j;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int * b();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\google\zxing\qrcode\decoder\Version$ECBlocks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */