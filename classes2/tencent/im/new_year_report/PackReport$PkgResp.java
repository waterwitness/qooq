package tencent.im.new_year_report;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackReport$PkgResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "retmsg" }, new Object[] { Integer.valueOf(0), "" }, PkgResp.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBStringField retmsg = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\new_year_report\PackReport$PkgResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */