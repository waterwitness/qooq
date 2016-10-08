package tencent.im.oidb.cmd0x5ea;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UpdatePhotoList$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "rpt_uint32_headids", "str_upload_url", "uint32_copy_count_from_qzone", "msg_lbs_info", "rpt_msg_rich_headids" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, null }, ReqBody.class);
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  public final PBRepeatMessageField rpt_msg_rich_headids = PBField.initRepeatMessage(UpdatePhotoList.RichHead.class);
  public final PBRepeatField rpt_uint32_headids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField str_upload_url = PBField.initString("");
  public final PBUInt32Field uint32_copy_count_from_qzone = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5ea\UpdatePhotoList$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */