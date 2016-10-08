package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class feeds_inner_define$FaceRecordSet
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_face_records" }, new Object[] { null }, FaceRecordSet.class);
  public final PBRepeatMessageField rpt_face_records = PBField.initRepeatMessage(feeds_inner_define.FaceRecordSet.FaceRecord.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\feeds_inner_define\feeds_inner_define$FaceRecordSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */