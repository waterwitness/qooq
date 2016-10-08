import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kfd
  implements Runnable
{
  public kfd(LiteTransferWrapper paramLiteTransferWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((LiteTransferWrapper.access$000(this.a) == null) || (LiteTransferWrapper.access$100(this.a) == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTTransferWrapper", 2, "litetransfer callback is null, do nothing");
      }
    }
    while (LiteTransferWrapper.access$200(this.a) != 0L) {
      return;
    }
    try
    {
      LiteTransferWrapper.access$202(this.a, this.a.createOperator(LiteTransferWrapper.access$000(this.a), LiteTransferWrapper.access$100(this.a)));
      this.a.checkPathExist();
      this.a.SetProxyToJni();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */