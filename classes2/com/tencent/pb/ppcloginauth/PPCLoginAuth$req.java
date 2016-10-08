package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class PPCLoginAuth$req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqcmd_0x01", "reqcmd_0x02" }, new Object[] { null, null, null }, req.class);
  public PPCLoginAuth.plat_info comm = new PPCLoginAuth.plat_info();
  public PPCLoginAuth.comering_req reqcmd_0x01 = new PPCLoginAuth.comering_req();
  public PPCLoginAuth.backgound_req reqcmd_0x02 = new PPCLoginAuth.backgound_req();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\ppcloginauth\PPCLoginAuth$req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */