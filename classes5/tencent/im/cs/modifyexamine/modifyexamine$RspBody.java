package tencent.im.cs.modifyexamine;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class modifyexamine$RspBody
  extends MessageMicro
{
  public static final int STR_ERRMSG_FIELD_NUMBER = 4;
  public static final int UINT32_LIMIT_TIMES_FIELD_NUMBER = 2;
  public static final int UINT32_MODIFY_TIMES_FIELD_NUMBER = 3;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_result", "uint32_limit_times", "uint32_modify_times", "str_errmsg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt32Field uint32_limit_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\modifyexamine\modifyexamine$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */