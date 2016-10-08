package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8ab$RspBody
  extends MessageMicro
{
  public static final int JOIN_POI_STATUS_FIELD_NUMBER = 2;
  public static final int POI_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "poi_info", "join_poi_status" }, new Object[] { null, Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field join_poi_status = PBField.initUInt32(0);
  public Common.WifiPOIInfo poi_info = new Common.WifiPOIInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\hotchat\oidb_0x8ab$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */