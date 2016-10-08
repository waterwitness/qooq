package cooperation.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SecSnapChatPicUploader$PicUploadInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public SecSnapChatPicUploader$PicUploadInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mLocalPath->");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mPicType->");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" mMsgId->");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mSecGroupId->");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" mState->");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mProgress->");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" mOriginalUrl->");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mCompressUrl->");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mSmallUrl->");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" mPeerUin->");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\SecSnapChatPicUploader$PicUploadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */