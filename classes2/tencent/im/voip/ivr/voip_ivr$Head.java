package tencent.im.voip.ivr;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class voip_ivr$Head
  extends MessageMicro
{
  public static final int COMMAND_FIELD_NUMBER = 1;
  public static final int RET_CODE_FIELD_NUMBER = 2;
  public static final int RET_MSG_FIELD_NUMBER = 3;
  public static final int ROOM_ID_FIELD_NUMBER = 4;
  public static final int USER_UIN_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "command", "ret_code", "ret_msg", "room_id", "user_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L) }, Head.class);
  public static final int kDialDemoCmd = 1;
  public static final int kFailRet = 1;
  public static final int kIvrAckCmd = 3;
  public static final int kIvrSubmitCmd = 2;
  public static final int kSeqNotMatch = 2;
  public static final int kSuccRet = 0;
  public final PBUInt32Field command = PBField.initUInt32(0);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt64Field user_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\voip\ivr\voip_ivr$Head.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */