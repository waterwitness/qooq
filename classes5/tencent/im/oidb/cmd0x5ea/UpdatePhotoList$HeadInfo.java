package tencent.im.oidb.cmd0x5ea;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UpdatePhotoList$HeadInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 58 }, new String[] { "uint32_headid", "str_headurl", "uint32_is_curhead", "str_video_url", "uint32_video_time", "uint32_video_size", "str_video_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, HeadInfo.class);
  public final PBStringField str_headurl = PBField.initString("");
  public final PBStringField str_video_id = PBField.initString("");
  public final PBStringField str_video_url = PBField.initString("");
  public final PBUInt32Field uint32_headid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_curhead = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5ea\UpdatePhotoList$HeadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */