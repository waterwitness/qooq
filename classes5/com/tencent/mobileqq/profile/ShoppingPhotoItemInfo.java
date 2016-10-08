package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ShoppingPhotoItemInfo
{
  public String a;
  public String b;
  
  public ShoppingPhotoItemInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(" ");
    if ((paramString != null) && (paramString.length == 2))
    {
      this.b = paramString[0];
      this.a = paramString[1];
      return;
    }
    this.b = "";
    this.a = "";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\ShoppingPhotoItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */