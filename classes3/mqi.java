import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;

public class mqi
  implements Runnable
{
  public mqi(TroopGagActivity paramTroopGagActivity, TroopGagMgr paramTroopGagMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity.b, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */