package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfileLabelTypeInfo
  implements Serializable, Cloneable
{
  public List labels;
  public String typeId;
  public String typeInfo;
  public String typeName;
  
  public ProfileLabelTypeInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.labels = new ArrayList();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\ProfileLabelTypeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */