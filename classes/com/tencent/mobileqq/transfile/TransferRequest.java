package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.UpCallBack;
import java.io.OutputStream;

public class TransferRequest
{
  public int a;
  public long a;
  public URLDrawableHandler a;
  public MessageRecord a;
  public DownCallBack a;
  public UpCallBack a;
  public TransferResult a;
  public OutputStream a;
  public Object a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public byte[] b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k;
  public String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
  public int n;
  private String n;
  public boolean n;
  public boolean o;
  
  public TransferRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 5;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 1;
    this.jdField_f_of_type_Boolean = true;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    if (this.n == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      return localStringBuilder.toString();
    }
    return this.n;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TransferRequest\n");
    localStringBuilder.append("mUniseq=" + this.jdField_a_of_type_Long);
    localStringBuilder.append(",mMd5=" + this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(",mIsIp=" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",mUinType=" + this.jdField_a_of_type_Int);
    localStringBuilder.append(",mFileType=" + this.jdField_b_of_type_Int);
    localStringBuilder.append(",mSelfUin=" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",mPeerUin=" + this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",mSecondId=" + this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(",mServerPath=" + this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(",mLocalPath=" + this.i);
    localStringBuilder.append(",mBusiType=" + this.jdField_e_of_type_Int);
    localStringBuilder.append(",mGroupFileID=" + this.jdField_c_of_type_Long);
    localStringBuilder.append(",mExtraObj={" + this.jdField_a_of_type_JavaLangObject + "}");
    localStringBuilder.append(",mPrioty=" + this.jdField_f_of_type_Int);
    localStringBuilder.append(",mLogicCallBack=" + this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack);
    localStringBuilder.append(",bEnableEnc=" + this.m);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\TransferRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */