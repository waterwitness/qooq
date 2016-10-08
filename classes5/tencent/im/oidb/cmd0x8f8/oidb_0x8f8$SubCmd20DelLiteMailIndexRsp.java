package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x8f8$SubCmd20DelLiteMailIndexRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_succ_lite_mail_index", "rpt_msg_fail_lite_mail_index" }, new Object[] { null, null }, SubCmd20DelLiteMailIndexRsp.class);
  public final PBRepeatMessageField rpt_msg_fail_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8.LiteMailIndexInfo.class);
  public final PBRepeatMessageField rpt_msg_succ_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8.LiteMailIndexInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f8\oidb_0x8f8$SubCmd20DelLiteMailIndexRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */