package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x51c$AppNoticeVar
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "opt_uint64_appdid", "opt_msg_app_noticevar", "rpt_msg_subitem_noticevar" }, new Object[] { Long.valueOf(0L), null, null }, AppNoticeVar.class);
  public oidb_0x51c.NoticeVar opt_msg_app_noticevar = new oidb_0x51c.NoticeVar();
  public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0L);
  public final PBRepeatMessageField rpt_msg_subitem_noticevar = PBField.initRepeatMessage(oidb_0x51c.SubItemNoticeVar.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x51c\oidb_0x51c$AppNoticeVar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */