package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RichProto$RichProtoResp$RespCommon
{
  public RichProto.RichProtoReq a;
  public int c;
  public int d;
  public int e;
  public boolean e;
  public int f;
  public String g;
  public String h;
  
  public RichProto$RichProtoResp$RespCommon()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = -1;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" errStr:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" reason:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" succCnt:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(" failCnt");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" isSendByQuickHttp");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\RichProto$RichProtoResp$RespCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */