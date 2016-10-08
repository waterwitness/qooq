package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceroam_sso$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "ret", "errmsg", "sub_cmd", "rspcmd_0x01", "rspcmd_0x02" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), null, null }, RspBody.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBInt64Field ret = PBField.initInt64(0L);
  public faceroam_sso.RspUserInfo rspcmd_0x01 = new faceroam_sso.RspUserInfo();
  public faceroam_sso.RspDeleteItem rspcmd_0x02 = new faceroam_sso.RspDeleteItem();
  public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\faceroam_sso\faceroam_sso$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */