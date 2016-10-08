package com.tencent.biz.qqstory.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class BaseUIItem
  implements Serializable
{
  public long id;
  
  public BaseUIItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\BaseUIItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */