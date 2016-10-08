package tencent.im.oidb.cmd0x683;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x683$RankListInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 48 }, new String[] { "uint32_listtype", "uint32_listtime", "rpt_msg_godinfo", "uint32_imgod_flag", "uint32_reach_end_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, RankListInfo.class);
  public final PBRepeatMessageField rpt_msg_godinfo = PBField.initRepeatMessage(cmd0x683.GodInfo.class);
  public final PBUInt32Field uint32_imgod_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_listtime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reach_end_flag = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x683\cmd0x683$RankListInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */