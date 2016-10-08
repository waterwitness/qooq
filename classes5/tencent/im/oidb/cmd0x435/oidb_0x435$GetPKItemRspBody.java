package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x435$GetPKItemRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_pk_item" }, new Object[] { null }, GetPKItemRspBody.class);
  public final PBRepeatMessageField rpt_msg_pk_item = PBField.initRepeatMessage(oidb_0x435.PKItem.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x435\oidb_0x435$GetPKItemRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */