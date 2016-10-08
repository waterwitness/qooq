package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x51d$GetOfficeNoticeRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "opt_msg_office_notice" }, new Object[] { null }, GetOfficeNoticeRsp.class);
  public oidb_0x51d.NoticeInfo opt_msg_office_notice = new oidb_0x51d.NoticeInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x51d\oidb_0x51d$GetOfficeNoticeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */