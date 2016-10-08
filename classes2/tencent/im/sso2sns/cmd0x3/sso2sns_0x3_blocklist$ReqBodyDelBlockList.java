package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sso2sns_0x3_blocklist$ReqBodyDelBlockList
  extends MessageMicro
{
  public static final int RPT_UINT64_DEL_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "rpt_uint64_del_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBodyDelBlockList.class);
  public final PBRepeatField rpt_uint64_del_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\sso2sns\cmd0x3\sso2sns_0x3_blocklist$ReqBodyDelBlockList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */