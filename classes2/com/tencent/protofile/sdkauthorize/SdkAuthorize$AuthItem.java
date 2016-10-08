package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SdkAuthorize$AuthItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50 }, new String[] { "default_flag", "id", "title", "api_list", "is_new", "logo_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, AuthItem.class);
  public final PBStringField api_list = PBField.initString("");
  public final PBSInt32Field default_flag = PBField.initSInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBSInt32Field is_new = PBField.initSInt32(0);
  public final PBStringField logo_url = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\protofile\sdkauthorize\SdkAuthorize$AuthItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */