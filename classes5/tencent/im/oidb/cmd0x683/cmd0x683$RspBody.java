package tencent.im.oidb.cmd0x683;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x683$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_msg_ranklist_info", "str_errinfo", "uint32_refuse_rank" }, new Object[] { null, "", Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_ranklist_info = PBField.initRepeatMessage(cmd0x683.RankListInfo.class);
  public final PBStringField str_errinfo = PBField.initString("");
  public final PBUInt32Field uint32_refuse_rank = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x683\cmd0x683$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */