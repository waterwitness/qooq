import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import java.util.List;
import mqq.os.MqqHandler;

public class wnl
  implements Runnable
{
  public wnl(ProfileCardMoreInfoView paramProfileCardMoreInfoView, Card paramCard, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.getPrivilegeOpenInfo();
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqDataCard.getPrivilegeCloseInfo();
    new MqqHandler(Looper.getMainLooper()).post(new wnm(this, localList1, localList2));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */