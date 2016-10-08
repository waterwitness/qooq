package tencent.im.oidb.cmd0x89b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89b$ExitPublicGroupReqBody
  extends MessageMicro
{
  public static final int UINT64_VISITOR_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, ExitPublicGroupReqBody.class);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x89b\oidb_0x89b$ExitPublicGroupReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */