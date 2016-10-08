package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TransferRequest$PicUpExtraInfo
{
  public int a;
  public TransferRequest.AppShare a;
  public boolean a;
  public boolean b;
  
  public TransferRequest$PicUpExtraInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUinType:" + this.jdField_a_of_type_Int);
    localStringBuilder.append(",mIsRaw:" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",mIsShareAppPic:" + this.b);
    localStringBuilder.append(",mShareAppInfo:{" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppShare + "}");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\TransferRequest$PicUpExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */