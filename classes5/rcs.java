import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rcs
  implements Handler.Callback
{
  public rcs(BaseMsgBoxActivity paramBaseMsgBoxActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label209:
    for (;;)
    {
      return false;
      if ((this.a.a()) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1) || (paramMessage.obj == null)) {
        break;
      }
      paramMessage = (List)paramMessage.obj;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(paramMessage);
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramMessage);
      if (BaseMsgBoxActivity.a(this.a)) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Boolean) {
          break label209;
        }
        this.a.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
        this.a.jdField_a_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg_box", 2, "init ui cost time : " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
        return false;
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    this.a.b = true;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */