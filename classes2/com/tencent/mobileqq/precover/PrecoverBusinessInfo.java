package com.tencent.mobileqq.precover;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PrecoverBusinessInfo
{
  public String a;
  public String b;
  
  public PrecoverBusinessInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PrecoverBusinessInfo:");
    localStringBuilder.append("businessId=").append(this.a);
    localStringBuilder.append(", name=").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\PrecoverBusinessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */