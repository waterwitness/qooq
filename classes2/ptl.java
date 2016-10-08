import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanelAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ptl
  implements Runnable
{
  public ptl(ApolloPanel paramApolloPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "clear bindList");
      }
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ptl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */