package tencent.im.nearfield_group;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class nearfield_group$RespExit
  extends MessageMicro
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_head" }, new Object[] { null }, RespExit.class);
  public nearfield_group.BusiRespHead msg_head = new nearfield_group.BusiRespHead();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\nearfield_group\nearfield_group$RespExit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */