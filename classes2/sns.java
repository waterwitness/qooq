import android.os.Message;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class sns
  extends MqqHandler
{
  public sns(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter == null) || (this.a.jdField_a_of_type_ComTencentWidgetListView == null));
      i = this.a.jdField_a_of_type_ComTencentWidgetListView.t();
    } while (i <= 0);
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.b(i);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */