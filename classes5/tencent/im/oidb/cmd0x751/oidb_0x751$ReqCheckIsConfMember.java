package tencent.im.oidb.cmd0x751;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x751$ReqCheckIsConfMember
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_conf_uin" }, new Object[] { Long.valueOf(0L) }, ReqCheckIsConfMember.class);
  public final PBRepeatField rpt_uint64_conf_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x751\oidb_0x751$ReqCheckIsConfMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */