package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceroam_sso$RspUserInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "filename", "delete_file", "bid", "max_roam_size" }, new Object[] { "", "", "", Integer.valueOf(0) }, RspUserInfo.class);
  public final PBStringField bid = PBField.initString("");
  public final PBRepeatField delete_file = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField filename = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field max_roam_size = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\faceroam_sso\faceroam_sso$RspUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */