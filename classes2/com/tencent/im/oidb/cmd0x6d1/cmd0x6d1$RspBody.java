package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x6d1$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "invite_rsp_body", "uninvite_rsp_body", "deal_invite_rsp_body" }, new Object[] { null, null, null }, RspBody.class);
  public cmd0x6d1.DealInviteRspBody deal_invite_rsp_body = new cmd0x6d1.DealInviteRspBody();
  public cmd0x6d1.InviteRspBody invite_rsp_body = new cmd0x6d1.InviteRspBody();
  public cmd0x6d1.UniviteRspBody uninvite_rsp_body = new cmd0x6d1.UniviteRspBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\im\oidb\cmd0x6d1\cmd0x6d1$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */