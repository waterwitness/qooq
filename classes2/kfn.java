import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class kfn
  implements Runnable
{
  public kfn(LiteTransferWrapper paramLiteTransferWrapper, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetProxyToJni();
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SendGroupToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), (Session[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new Session[this.jdField_a_of_type_JavaUtilArrayList.size()]), this.jdField_a_of_type_Boolean, this.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */