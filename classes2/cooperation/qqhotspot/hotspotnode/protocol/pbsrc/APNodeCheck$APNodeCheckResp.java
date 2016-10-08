package cooperation.qqhotspot.hotspotnode.protocol.pbsrc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class APNodeCheck$APNodeCheckResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "nodeinfo" }, new Object[] { Integer.valueOf(0), null }, APNodeCheckResp.class);
  public final PBRepeatMessageField nodeinfo = PBField.initRepeatMessage(APNodeCheck.APNodeInfo.class);
  public final PBInt32Field retcode = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\protocol\pbsrc\APNodeCheck$APNodeCheckResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */