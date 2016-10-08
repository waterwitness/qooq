package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x8bb$WriteRsp
  extends MessageMicro
{
  public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_group_concerned" }, new Object[] { null }, WriteRsp.class);
  public final PBRepeatMessageField rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb.GroupConcernedInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8bb\oidb_0x8bb$WriteRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */