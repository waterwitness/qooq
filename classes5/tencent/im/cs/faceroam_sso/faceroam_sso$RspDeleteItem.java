package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class faceroam_sso$RspDeleteItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "filename", "ret" }, new Object[] { "", Long.valueOf(0L) }, RspDeleteItem.class);
  public final PBRepeatField filename = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField ret = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\faceroam_sso\faceroam_sso$RspDeleteItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */