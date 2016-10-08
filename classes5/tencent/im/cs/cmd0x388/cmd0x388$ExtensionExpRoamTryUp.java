package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x388$ExtensionExpRoamTryUp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_exproam_pic_info" }, new Object[] { null }, ExtensionExpRoamTryUp.class);
  public final PBRepeatMessageField rpt_msg_exproam_pic_info = PBField.initRepeatMessage(cmd0x388.ExpRoamPicInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x388\cmd0x388$ExtensionExpRoamTryUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */