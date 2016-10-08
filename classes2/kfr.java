import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kfr
  implements Runnable
{
  public kfr(LiteTransferWrapper paramLiteTransferWrapper, int paramInt, MsgSCBody paramMsgSCBody)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.DoPbMsgReplyToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentLitetransfersdkMsgSCBody);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */