package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RichProto$RichProtoReq$MultiMsgDownReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public byte[] a;
  
  public RichProto$RichProtoReq$MultiMsgDownReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" msgResId:");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\protohandler\RichProto$RichProtoReq$MultiMsgDownReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */