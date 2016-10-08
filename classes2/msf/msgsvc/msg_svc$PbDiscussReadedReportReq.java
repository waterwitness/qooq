package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDiscussReadedReportReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "conf_uin", "last_read_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PbDiscussReadedReportReq.class);
  public final PBUInt64Field conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field last_read_seq = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbDiscussReadedReportReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */