package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d9$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42 }, new String[] { "trans_file_rsp", "feeds_info_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0x6d9.FeedsRspBody feeds_info_rsp = new oidb_0x6d9.FeedsRspBody();
  public oidb_0x6d9.TransFileRspBody trans_file_rsp = new oidb_0x6d9.TransFileRspBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6d9\oidb_0x6d9$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */