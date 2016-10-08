package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg$Group
  extends MessageMicro
{
  public static final int GROUP_INFO_FIELD_NUMBER = 3;
  public static final int RECEIVER_FIELD_NUMBER = 2;
  public static final int SENDER_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sender", "receiver", "group_info" }, new Object[] { null, null, null }, Group.class);
  public im_common.GroupInfo group_info = new im_common.GroupInfo();
  public im_common.User receiver = new im_common.User();
  public im_common.User sender = new im_common.User();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg$Group.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */