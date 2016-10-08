package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RichProto$RichProtoReq$PicUpReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  
  public RichProto$RichProtoReq$PicUpReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" width:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" height:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" size:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isRaw:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" isContant:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(" picType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" busiType:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\RichProto$RichProtoReq$PicUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */