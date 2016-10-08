import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pwi
  implements Runnable
{
  public pwi(DataLineHandler paramDataLineHandler, Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler, this.jdField_a_of_type_ComTencentLitetransfersdkSession, this.jdField_a_of_type_ComTencentLitetransfersdkNFCInfo, this.jdField_a_of_type_ComTencentLitetransfersdkFTNInfo, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */