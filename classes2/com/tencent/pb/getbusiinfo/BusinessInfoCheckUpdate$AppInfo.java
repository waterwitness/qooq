package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BusinessInfoCheckUpdate$AppInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 32, 42, 50, 56, 66, 72, 80, 90, 96, 104, 112, 120, 130, 136 }, new String[] { "uiAppId", "iNewFlag", "type", "buffer", "path", "modify_ts", "missions", "appset", "num", "icon_url", "icon_flag", "icon_type", "push_red_ts", "mission_level", "red_display_info", "use_cache" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Boolean.valueOf(false) }, AppInfo.class);
  public final PBInt32Field appset = PBField.initInt32(0);
  public final PBStringField buffer = PBField.initString("");
  public final PBInt32Field iNewFlag = PBField.initInt32(0);
  public final PBInt32Field icon_flag = PBField.initInt32(0);
  public final PBInt32Field icon_type = PBField.initInt32(0);
  public final PBStringField icon_url = PBField.initString("");
  public final PBInt32Field mission_level = PBField.initInt32(0);
  public final PBRepeatField missions = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field modify_ts = PBField.initUInt32(0);
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBStringField path = PBField.initString("");
  public final PBUInt32Field push_red_ts = PBField.initUInt32(0);
  public BusinessInfoCheckUpdate.RedDisplayInfo red_display_info = new BusinessInfoCheckUpdate.RedDisplayInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field uiAppId = PBField.initUInt32(0);
  public final PBBoolField use_cache = PBField.initBool(false);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getbusiinfo\BusinessInfoCheckUpdate$AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */