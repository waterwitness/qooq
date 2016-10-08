package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class submsgtype0xb4$BodyType
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_torchbearer" }, new Object[] { null }, BodyType.class);
  public torch_transfer.TorchbearerInfo msg_torchbearer = new torch_transfer.TorchbearerInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\submsgtype0xb4$BodyType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */