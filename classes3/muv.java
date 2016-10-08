import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class muv
  implements Runnable
{
  public muv(TroopMemberListActivity paramTroopMemberListActivity, List paramList, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, this.b);
    TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, localList, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\muv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */