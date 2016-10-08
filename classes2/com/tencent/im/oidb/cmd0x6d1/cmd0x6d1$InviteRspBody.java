package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x6d1$InviteRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_invited_uin_list", "rpt_uninvited_uin_list" }, new Object[] { null, null }, InviteRspBody.class);
  public final PBRepeatMessageField rpt_invited_uin_list = PBField.initRepeatMessage(cmd0x6d1.ItemInfo.class);
  public final PBRepeatMessageField rpt_uninvited_uin_list = PBField.initRepeatMessage(cmd0x6d1.ItemInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\im\oidb\cmd0x6d1\cmd0x6d1$InviteRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */