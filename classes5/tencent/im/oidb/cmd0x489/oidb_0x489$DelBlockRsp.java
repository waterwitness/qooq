package tencent.im.oidb.cmd0x489;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x489$DelBlockRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_one_block_data" }, new Object[] { null }, DelBlockRsp.class);
  public oidb_0x489.OneDelBlockData msg_one_block_data = new oidb_0x489.OneDelBlockData();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x489\oidb_0x489$DelBlockRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */