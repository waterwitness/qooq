package tencent.im.oidb.cmd0xa8d;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa8d$Cmd0xa8dExitPublicGroupReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, Cmd0xa8dExitPublicGroupReqBody.class);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0xa8d\oidb_0xa8d$Cmd0xa8dExitPublicGroupReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */