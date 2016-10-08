package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg$C2C
  extends MessageMicro
{
  public static final int C2C_RELATION_FIELD_NUMBER = 3;
  public static final int RECEIVER_FIELD_NUMBER = 2;
  public static final int SENDER_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sender", "receiver", "c2c_relation" }, new Object[] { null, null, null }, C2C.class);
  public im_msg.C2CRelation c2c_relation = new im_msg.C2CRelation();
  public im_common.User receiver = new im_common.User();
  public im_common.User sender = new im_common.User();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg$C2C.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */