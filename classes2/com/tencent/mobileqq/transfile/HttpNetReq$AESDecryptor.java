package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HttpNetReq$AESDecryptor
{
  static final int a = 16;
  static final int b = 128;
  public byte[] a;
  
  HttpNetReq$AESDecryptor(byte[] paramArrayOfByte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new byte[16];
    this.a = paramArrayOfByte;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\HttpNetReq$AESDecryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */