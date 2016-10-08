package tencent.im.oidb.cmd0x5d1;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5d1$ClearFriendIdReq
  extends MessageMicro
{
  public static final int RPT_UINT64_FRIENDS_FIELD_NUMBER = 3;
  public static final int UINT32_IF_CHECK_SEQ_FIELD_NUMBER = 1;
  public static final int UINT64_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_if_check_seq", "uint64_seq", "rpt_uint64_friends" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ClearFriendIdReq.class);
  public final PBRepeatField rpt_uint64_friends = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_if_check_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5d1\Oidb_0x5d1$ClearFriendIdReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */