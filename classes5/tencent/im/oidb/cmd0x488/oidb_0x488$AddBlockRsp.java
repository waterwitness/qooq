package tencent.im.oidb.cmd0x488;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x488$AddBlockRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_one_block_data" }, new Object[] { null }, AddBlockRsp.class);
  public oidb_0x488.OneAddBlockData msg_one_block_data = new oidb_0x488.OneAddBlockData();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x488\oidb_0x488$AddBlockRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */