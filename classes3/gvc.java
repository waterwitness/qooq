import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersUI.Holder;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gvc
  implements View.OnClickListener
{
  public gvc(MultiMembersAudioUI paramMultiMembersAudioUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener == null) {}
    do
    {
      return;
      paramView = (MultiMembersUI.Holder)paramView.getTag();
      if (paramView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiMembersAudioUI", 2, "onItemClick-->holder is null");
    return;
    if (paramView.c) {}
    for (int i = 17; (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 18) && ((this.a.b == 1) || (this.a.b == 2)); i = this.a.a(paramView.jdField_a_of_type_Long))
    {
      this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, i, true);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, i, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */