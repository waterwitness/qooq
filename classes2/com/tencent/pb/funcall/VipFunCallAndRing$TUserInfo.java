package com.tencent.pb.funcall;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFunCallAndRing$TUserInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "i32_common_id", "i32_ring_id", "rpt_user_groups", "st_src_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, TUserInfo.class);
  public final PBInt32Field i32_common_id = PBField.initInt32(0);
  public final PBInt32Field i32_ring_id = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_user_groups = PBField.initRepeatMessage(VipFunCallAndRing.TGroupInfo.class);
  public VipFunCallAndRing.TSourceInfo st_src_info = new VipFunCallAndRing.TSourceInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\funcall\VipFunCallAndRing$TUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */