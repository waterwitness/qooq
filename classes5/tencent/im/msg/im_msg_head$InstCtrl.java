package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class im_msg_head$InstCtrl
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst" }, new Object[] { null, null, null }, InstCtrl.class);
  public im_msg_head.InstInfo msg_from_inst = new im_msg_head.InstInfo();
  public final PBRepeatMessageField rpt_msg_exclude_inst = PBField.initRepeatMessage(im_msg_head.InstInfo.class);
  public final PBRepeatMessageField rpt_msg_send_to_inst = PBField.initRepeatMessage(im_msg_head.InstInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg_head$InstCtrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */