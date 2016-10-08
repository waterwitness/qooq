package com.tencent.mobileqq.profile.view;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ProfileTemplateException
  extends Exception
{
  private static final long serialVersionUID = -100L;
  
  public ProfileTemplateException(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\ProfileTemplateException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */