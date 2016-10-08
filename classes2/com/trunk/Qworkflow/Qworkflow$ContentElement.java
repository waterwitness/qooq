package com.trunk.Qworkflow;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Qworkflow$ContentElement
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_file_list = PBField.initRepeatMessage(Qworkflow.OrdinaryFile.class);
  public final PBRepeatMessageField rpt_picture_list = PBField.initRepeatMessage(Qworkflow.Picture.class);
  public final PBRepeatMessageField rpt_text_list = PBField.initRepeatMessage(Qworkflow.Text.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rpt_text_list", "rpt_file_list", "rpt_picture_list", "bytes_userdef" }, new Object[] { null, null, null, localByteStringMicro }, ContentElement.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\Qworkflow\Qworkflow$ContentElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */