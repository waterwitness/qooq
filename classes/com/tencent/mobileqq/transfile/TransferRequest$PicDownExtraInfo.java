package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TransferRequest$PicDownExtraInfo
{
  public int a;
  public URLDrawableHandler a;
  public String a;
  
  public TransferRequest$PicDownExtraInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUrlFromMsg:" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mStartDownOffset:" + this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\TransferRequest$PicDownExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */