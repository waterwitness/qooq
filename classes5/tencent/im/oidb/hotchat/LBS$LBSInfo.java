package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class LBS$LBSInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "gps", "rpt_wifi", "rpt_cell", "attribute" }, new Object[] { null, null, null, null }, LBSInfo.class);
  public LBS.Attribute attribute = new LBS.Attribute();
  public LBS.GPS gps = new LBS.GPS();
  public final PBRepeatMessageField rpt_cell = PBField.initRepeatMessage(LBS.Cell.class);
  public final PBRepeatMessageField rpt_wifi = PBField.initRepeatMessage(LBS.Wifi.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\hotchat\LBS$LBSInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */