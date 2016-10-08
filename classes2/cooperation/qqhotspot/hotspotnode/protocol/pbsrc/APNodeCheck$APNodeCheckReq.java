package cooperation.qqhotspot.hotspotnode.protocol.pbsrc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class APNodeCheck$APNodeCheckReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "filter", "bssidlist", "wifiid" }, new Object[] { Integer.valueOf(0), "", "" }, APNodeCheckReq.class);
  public final PBRepeatField bssidlist = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field filter = PBField.initInt32(0);
  public final PBStringField wifiid = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\protocol\pbsrc\APNodeCheck$APNodeCheckReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */