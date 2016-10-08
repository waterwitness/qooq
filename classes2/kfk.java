import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kfk
  implements Runnable
{
  public kfk(LiteTransferWrapper paramLiteTransferWrapper, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.destryOperator(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_Boolean);
      LiteTransferWrapper.access$202(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, 0L);
      LiteTransferWrapper.access$002(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, null);
      LiteTransferWrapper.access$102(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */