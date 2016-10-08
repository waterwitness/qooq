package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x59f$ContactBindInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "mobile", "nation_code" }, new Object[] { "", "" }, ContactBindInfo.class);
  public final PBStringField mobile = PBField.initString("");
  public final PBStringField nation_code = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x59f\oidb_0x59f$ContactBindInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */