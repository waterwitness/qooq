package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$LiteMail
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_mail", "uint32_result" }, new Object[] { null, Integer.valueOf(0) }, LiteMail.class);
  public oidb_0x8f9.GroupFeedsRecord msg_mail = new oidb_0x8f9.GroupFeedsRecord();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f9\oidb_0x8f9$LiteMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */