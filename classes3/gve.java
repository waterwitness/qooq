import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.ui.MultiMembersUI.Holder;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gve
  implements AdapterView.OnItemClickListener
{
  public gve(MultiMembersVideoUI paramMultiMembersVideoUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener == null) {}
    do
    {
      return;
      paramAdapterView = (MultiMembersUI.Holder)paramView.getTag();
      if (paramAdapterView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiMembersVideoUI", 2, "onItemClick-->holder is null");
    return;
    if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() > 18) && ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2)))
    {
      this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, paramInt, true);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, paramInt, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */