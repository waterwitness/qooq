import android.os.Handler;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import java.util.ArrayList;

public class vqq
  implements Runnable
{
  public vqq(TroopGagMgr paramTroopGagMgr, String paramString, Handler paramHandler, BizTroopHandler paramBizTroopHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr.a(this.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_AndroidOsHandler.post(new vqr(this, localArrayList));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */