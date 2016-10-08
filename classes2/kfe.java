import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kfe
  implements Runnable
{
  public kfe(LiteTransferWrapper paramLiteTransferWrapper, MsgCSBody paramMsgCSBody)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.PbMsgReciveToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_ComTencentLitetransfersdkMsgCSBody);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */