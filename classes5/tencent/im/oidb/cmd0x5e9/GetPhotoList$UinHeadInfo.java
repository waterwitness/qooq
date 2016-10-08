package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetPhotoList$UinHeadInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_uin", "uint32_timestamp", "uint32_headcount", "rpt_msg_headinfo", "str_headurl" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, "" }, UinHeadInfo.class);
  public final PBRepeatMessageField rpt_msg_headinfo = PBField.initRepeatMessage(GetPhotoList.HeadInfo.class);
  public final PBStringField str_headurl = PBField.initString("");
  public final PBUInt32Field uint32_headcount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5e9\GetPhotoList$UinHeadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */