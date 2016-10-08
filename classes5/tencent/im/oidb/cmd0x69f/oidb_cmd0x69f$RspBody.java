package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x69f$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField bytes_search_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField rpt_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f.ChannelInfo.class);
  public final PBRepeatMessageField rpt_recomm_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f.ChannelInfo.class);
  public final PBRepeatField rpt_uint32_my_channel_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 96, 106, 114 }, new String[] { "uint64_uin", "rpt_channel_list", "rpt_uint32_my_channel_id_list", "rpt_recomm_channel_list", "bytes_search_word" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x69f\oidb_cmd0x69f$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */