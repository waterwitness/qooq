package tencent.im.oidb.cmd0x683;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x683$Location
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "strCountry", "strProvince", "strCity", "msg_lbs_info" }, new Object[] { "", "", "", null }, Location.class);
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  public final PBStringField strCity = PBField.initString("");
  public final PBStringField strCountry = PBField.initString("");
  public final PBStringField strProvince = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x683\cmd0x683$Location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */