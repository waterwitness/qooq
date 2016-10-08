package tencent.sso.roam;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Roam$RoamRspHead
  extends MessageMicro
{
  public static final int MSG_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "msg" }, new Object[] { Integer.valueOf(0), "" }, RoamRspHead.class);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\sso\roam\Roam$RoamRspHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */