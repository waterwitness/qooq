package tencent.im.cs.ptt_apply;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ptt_apply$QQApplyAuthkeyRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "uint32_ver", "uint32_seq", "int32_retcode", "str_uin", "uint32_userip", "address" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null }, QQApplyAuthkeyRsp.class);
  public final PBRepeatMessageField address = PBField.initRepeatMessage(ptt_apply.Addr.class);
  public final PBInt32Field int32_retcode = PBField.initInt32(0);
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_userip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ver = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\ptt_apply\ptt_apply$QQApplyAuthkeyRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */