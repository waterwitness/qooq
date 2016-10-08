package tencent.qht_exinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qht_post_exinfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "groupCode", "msgSeq", "pVersion", "bid", "pid" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, qht_post_exinfo.class);
  public final PBUInt64Field bid = PBField.initUInt64(0L);
  public final PBStringField groupCode = PBField.initString("");
  public final PBUInt64Field msgSeq = PBField.initUInt64(0L);
  public final PBUInt64Field pVersion = PBField.initUInt64(0L);
  public final PBStringField pid = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\qht_exinfo\qht_post_exinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */