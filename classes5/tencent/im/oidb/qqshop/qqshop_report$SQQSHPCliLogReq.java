package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqshop_report$SQQSHPCliLogReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "logs" }, new Object[] { null }, SQQSHPCliLogReq.class);
  public final PBRepeatMessageField logs = PBField.initRepeatMessage(qqshop_report.SQQSHPCliLogInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qqshop\qqshop_report$SQQSHPCliLogReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */