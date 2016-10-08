import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kfo
  implements Runnable
{
  public kfo(LiteTransferWrapper paramLiteTransferWrapper, Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetProxyToJni();
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.RecvGroupToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkSession, this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkNFCInfo, this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkFTNInfo, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */