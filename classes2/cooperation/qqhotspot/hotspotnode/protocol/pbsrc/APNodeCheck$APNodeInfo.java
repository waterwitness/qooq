package cooperation.qqhotspot.hotspotnode.protocol.pbsrc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class APNodeCheck$APNodeInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 66, 74, 82, 88 }, new String[] { "bssid", "ssid", "spid", "wifiid", "storename", "authtype", "logourl", "bbadurl", "storeadurl", "publicuin", "publicdfs" }, new Object[] { "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "", Integer.valueOf(0) }, APNodeInfo.class);
  public final PBInt32Field authtype = PBField.initInt32(0);
  public final PBStringField bbadurl = PBField.initString("");
  public final PBStringField bssid = PBField.initString("");
  public final PBStringField logourl = PBField.initString("");
  public final PBInt32Field publicdfs = PBField.initInt32(0);
  public final PBStringField publicuin = PBField.initString("");
  public final PBInt32Field spid = PBField.initInt32(0);
  public final PBStringField ssid = PBField.initString("");
  public final PBStringField storeadurl = PBField.initString("");
  public final PBStringField storename = PBField.initString("");
  public final PBStringField wifiid = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\protocol\pbsrc\APNodeCheck$APNodeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */