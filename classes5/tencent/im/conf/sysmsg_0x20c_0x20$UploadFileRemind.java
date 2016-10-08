package tencent.im.conf;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_0x20c_0x20$UploadFileRemind
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "u64_discuss_code" }, new Object[] { Long.valueOf(0L) }, UploadFileRemind.class);
  public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\conf\sysmsg_0x20c_0x20$UploadFileRemind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */