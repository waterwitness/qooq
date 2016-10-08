package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class subcmd0x111$SubCmd0x111RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_contentItem" }, new Object[] { null }, SubCmd0x111RspBody.class);
  public final PBRepeatMessageField rpt_msg_contentItem = PBField.initRepeatMessage(subcmd0x111.ContentItem.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x6ff\subcmd0x111$SubCmd0x111RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */