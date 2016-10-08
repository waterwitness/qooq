import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kfh
  implements Runnable
{
  public kfh(LiteTransferWrapper paramLiteTransferWrapper, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetServicePathToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */