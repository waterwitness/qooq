package com.tencent.biz.anonymous;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class AnonymousChatHelper$AnonymousExtInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  public AnonymousChatHelper$AnonymousExtInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public byte[] a()
  {
    if (TextUtils.isEmpty(this.a)) {}
    do
    {
      return null;
      try
      {
        byte[] arrayOfByte = this.a.getBytes("ISO-8859-1");
        return arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AnonymousChatHelper", 2, "getByteAnId UnsupportedEncodingException");
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\anonymous\AnonymousChatHelper$AnonymousExtInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */