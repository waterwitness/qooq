package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class RichProto$RichProtoResp$MultiMsgDownResp
  extends RichProto.RichProtoResp.RespCommon
{
  public String a;
  public ArrayList a;
  public byte[] a;
  public byte[] b;
  
  public RichProto$RichProtoResp$MultiMsgDownResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" urlParam:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" msgUkey:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ipList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append(" resId:");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\RichProto$RichProtoResp$MultiMsgDownResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */