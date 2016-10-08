package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqshop_richmsg$SQQSHPRichMsgReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rich_msgs" }, new Object[] { null }, SQQSHPRichMsgReq.class);
  public final PBRepeatMessageField rich_msgs = PBField.initRepeatMessage(qqshop_richmsg.SQQSHPRichMsg.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qqshop\qqshop_richmsg$SQQSHPRichMsgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */