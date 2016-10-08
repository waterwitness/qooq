package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ProfileParams$Builder
{
  private ProfileParams a;
  
  public ProfileParams$Builder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ProfileParams(null);
  }
  
  public Builder a(int paramInt)
  {
    this.a.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(ProfileParams.CurLoginUsr paramCurLoginUsr)
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr = paramCurLoginUsr;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a.b = paramString;
    return this;
  }
  
  public ProfileParams a()
  {
    return this.a;
  }
  
  public Builder b(String paramString)
  {
    this.a.c = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.a.d = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.a.e = paramString;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\ProfileParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */