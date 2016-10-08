package tencent.im.mobiletips;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class MobileTips$MobileTipsPkg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "req", "rsp" }, new Object[] { null, null }, MobileTipsPkg.class);
  public MobileTips.ReqBody req = new MobileTips.ReqBody();
  public MobileTips.RspBody rsp = new MobileTips.RspBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\mobiletips\MobileTips$MobileTipsPkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */