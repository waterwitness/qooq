package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x435$AddTopicReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_topic_info" }, new Object[] { null }, AddTopicReqBody.class);
  public oidb_0x435.TopicInfo msg_topic_info = new oidb_0x435.TopicInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x435\oidb_0x435$AddTopicReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */