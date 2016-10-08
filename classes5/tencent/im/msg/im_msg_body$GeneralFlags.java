package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$GeneralFlags
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rp_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field long_text_flag = PBField.initUInt32(0);
  public final PBBytesField long_text_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bubble_diy_text_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_glamour_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag_new = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_olympic_torch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_prp_fold = PBField.initUInt32(0);
  public final PBUInt32Field uint32_to_uin_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_rank_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 64, 72, 80, 88, 96, 104 }, new String[] { "uint32_bubble_diy_text_id", "uint32_group_flag_new", "uint64_uin", "bytes_rp_id", "uint32_prp_fold", "long_text_flag", "long_text_resid", "uint32_group_type", "uint32_to_uin_flag", "uint32_glamour_level", "uint32_member_level", "uint64_group_rank_seq", "uint32_olympic_torch" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GeneralFlags.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg_body$GeneralFlags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */