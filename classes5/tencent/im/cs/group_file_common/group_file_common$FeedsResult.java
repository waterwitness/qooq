package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class group_file_common$FeedsResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_detail", "str_file_id" }, new Object[] { Integer.valueOf(0), "", "" }, FeedsResult.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_detail = PBField.initString("");
  public final PBStringField str_file_id = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\group_file_common\group_file_common$FeedsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */