package tencent.im.oidb.cmd0x8ca;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x8ca$AppUinSpecial
  extends MessageMicro
{
  public static final int OPT_UINT32_ACCESS_TIME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "opt_uint32_access_time" }, new Object[] { Integer.valueOf(0) }, AppUinSpecial.class);
  public final PBUInt32Field opt_uint32_access_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8ca\cmd0x8ca$AppUinSpecial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */