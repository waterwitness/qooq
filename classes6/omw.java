import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class omw
  implements Runnable
{
  public omw(AvatarPendantActivity paramAvatarPendantActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.a.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\omw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */