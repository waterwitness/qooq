package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class EqqConfig
  extends Entity
{
  @unique
  public String data;
  
  public EqqConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EqqConfig(String paramString)
  {
    this.data = paramString;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\EqqConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */