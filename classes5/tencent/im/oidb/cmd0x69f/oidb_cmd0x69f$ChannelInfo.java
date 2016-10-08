package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x69f$ChannelInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_channel_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_child_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f.ChildChannelInfo.class);
  public final PBUInt32Field uint32_bold_font = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fonts_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_frame_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_first_req = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_icon = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 66, 72, 80 }, new String[] { "uint32_channel_id", "bytes_channel_name", "uint32_channel_type", "uint32_is_first_req", "rpt_child_channel_list", "uint32_frame_color", "uint32_fonts_color", "bytes_channel_jump_url", "uint32_bold_font", "uint32_show_icon" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ChannelInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x69f\oidb_cmd0x69f$ChannelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */