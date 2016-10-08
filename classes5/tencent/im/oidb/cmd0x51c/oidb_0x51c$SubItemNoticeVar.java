package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x51c$SubItemNoticeVar
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_subitem_id", "opt_msg_subitem_noticevar" }, new Object[] { Integer.valueOf(0), null }, SubItemNoticeVar.class);
  public oidb_0x51c.NoticeVar opt_msg_subitem_noticevar = new oidb_0x51c.NoticeVar();
  public final PBUInt32Field opt_uint32_subitem_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x51c\oidb_0x51c$SubItemNoticeVar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */