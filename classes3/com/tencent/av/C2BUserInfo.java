package com.tencent.av;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.Cryptor;
import org.json.JSONObject;

public class C2BUserInfo
{
  public final String a;
  public final String b;
  public final String c;
  public String d;
  public String e;
  
  public C2BUserInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "uid";
    this.b = "ukey";
    this.c = "^%QAI$I+j{2HuP0L";
  }
  
  public static C2BUserInfo a(String paramString)
  {
    C2BUserInfo localC2BUserInfo = new C2BUserInfo();
    if (localC2BUserInfo.a(paramString)) {
      return localC2BUserInfo;
    }
    return null;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      paramString = Base64Util.decode(paramString, 0);
      paramString = new JSONObject(new String(new Cryptor().decrypt(paramString, "^%QAI$I+j{2HuP0L".getBytes())));
      if (paramString.has("uid")) {
        this.d = paramString.getString("uid");
      }
      for (int i = 1; (i != 0) && (paramString.has("ukey")); i = 0)
      {
        this.e = paramString.getString("ukey");
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\C2BUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */