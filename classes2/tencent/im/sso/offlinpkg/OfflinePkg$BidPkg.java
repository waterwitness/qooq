package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OfflinePkg$BidPkg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_bid", "uint32_pkg_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BidPkg.class);
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  public final PBRepeatField uint32_pkg_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\sso\offlinpkg\OfflinePkg$BidPkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */