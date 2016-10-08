package tencent.im.oidb.cmd0x5ea;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UpdatePhotoList$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "rpt_msg_headinfo", "str_errorinfo", "uint32_import_state", "uint32_import_count", "uint32_import_rest_count", "uint32_rest_count_in_qzone" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_headinfo = PBField.initRepeatMessage(UpdatePhotoList.HeadInfo.class);
  public final PBStringField str_errorinfo = PBField.initString("");
  public final PBUInt32Field uint32_import_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_import_rest_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_import_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rest_count_in_qzone = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5ea\UpdatePhotoList$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */