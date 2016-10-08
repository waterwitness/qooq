package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class appoint_define$ReplyInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_comment_id", "msg_stranger_info" }, new Object[] { "", null }, ReplyInfo.class);
  public appoint_define.StrangerInfo msg_stranger_info = new appoint_define.StrangerInfo();
  public final PBStringField str_comment_id = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$ReplyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */