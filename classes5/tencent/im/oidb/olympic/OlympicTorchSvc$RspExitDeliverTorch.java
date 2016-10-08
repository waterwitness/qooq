package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class OlympicTorchSvc$RspExitDeliverTorch
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_rsp_head" }, new Object[] { null }, RspExitDeliverTorch.class);
  public OlympicTorchSvc.RspHead msg_rsp_head = new OlympicTorchSvc.RspHead();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\OlympicTorchSvc$RspExitDeliverTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */