package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BusinessInfoCheckUpdate$LbsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "location", "cells", "wlan", "detail_info" }, new Object[] { null, null, null, null }, LbsInfo.class);
  public final PBRepeatMessageField cells = PBField.initRepeatMessage(BusinessInfoCheckUpdate.LbsCellInfo.class);
  public BusinessInfoCheckUpdate.LbsDetailInfo detail_info = new BusinessInfoCheckUpdate.LbsDetailInfo();
  public BusinessInfoCheckUpdate.LbsLocationInfo location = new BusinessInfoCheckUpdate.LbsLocationInfo();
  public final PBRepeatMessageField wlan = PBField.initRepeatMessage(BusinessInfoCheckUpdate.LbsWlanInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\getbusiinfo\BusinessInfoCheckUpdate$LbsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */