package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg$RoutingHead
  extends MessageMicro
{
  public static final int C2C_FIELD_NUMBER = 1;
  public static final int GROUP_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c", "group" }, new Object[] { null, null }, RoutingHead.class);
  public im_msg.C2C c2c = new im_msg.C2C();
  public im_msg.Group group = new im_msg.Group();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg$RoutingHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */