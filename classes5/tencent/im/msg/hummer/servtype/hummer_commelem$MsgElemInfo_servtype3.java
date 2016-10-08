package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

public final class hummer_commelem$MsgElemInfo_servtype3
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "flash_troop_pic", "flash_c2c_pic" }, new Object[] { null, null }, MsgElemInfo_servtype3.class);
  public im_msg_body.NotOnlineImage flash_c2c_pic = new im_msg_body.NotOnlineImage();
  public im_msg_body.CustomFace flash_troop_pic = new im_msg_body.CustomFace();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\hummer\servtype\hummer_commelem$MsgElemInfo_servtype3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */