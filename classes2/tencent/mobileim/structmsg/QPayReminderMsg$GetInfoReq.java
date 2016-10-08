package tencent.mobileim.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QPayReminderMsg$GetInfoReq
  extends MessageMicro
{
  public static final int INFO_DATE_FIELD_NUMBER = 3;
  public static final int SCENE_FIELD_NUMBER = 1;
  public static final int SUB_CMD_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "scene", "sub_cmd", "info_date" }, new Object[] { "", "", "" }, GetInfoReq.class);
  public final PBStringField info_date = PBField.initString("");
  public final PBStringField scene = PBField.initString("");
  public final PBStringField sub_cmd = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\mobileim\structmsg\QPayReminderMsg$GetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */