package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class VasKeyValue
  extends Entity
{
  public static final String COLUMN_KEY = "key";
  public static final String COLUMN_VALUE = "value";
  public String key;
  public String value;
  
  public VasKeyValue()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\vas\VasKeyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */