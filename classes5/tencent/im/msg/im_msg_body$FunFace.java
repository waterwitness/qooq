package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg_body$FunFace
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_turntable", "msg_bomb" }, new Object[] { null, null }, FunFace.class);
  public im_msg_body.FunFace.Bomb msg_bomb = new im_msg_body.FunFace.Bomb();
  public im_msg_body.FunFace.Turntable msg_turntable = new im_msg_body.FunFace.Turntable();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg_body$FunFace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */