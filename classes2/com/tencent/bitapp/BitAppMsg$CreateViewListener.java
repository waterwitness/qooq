package com.tencent.bitapp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class BitAppMsg$CreateViewListener
{
  public BitAppMsg$CreateViewListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e(BitAppMsg.TAG, 4, "CreateViewListener onInvalidViewClick");
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(BitAppMsg.TAG, 4, "CreateViewListener onLoadSuccess key: " + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(BitAppMsg.TAG, 4, "CreateViewListener onLoadFail key: " + paramString + " | errorCode: " + paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMsg$CreateViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */