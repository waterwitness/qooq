package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x46f$DislikeParam
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 88, 98 }, new String[] { "uint64_articleid", "uint32_reasonid", "rpt_uint64_tagid", "rpt_user_dislike_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null }, DislikeParam.class);
  public final PBRepeatField rpt_uint64_tagid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField rpt_user_dislike_list = PBField.initRepeatMessage(oidb_cmd0x46f.UserDisLike.class);
  public final PBUInt32Field uint32_reasonid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_articleid = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x46f\oidb_cmd0x46f$DislikeParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */