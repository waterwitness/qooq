import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Collection;

public class nar
  extends Handler
{
  public nar(VisitorsActivity paramVisitorsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.H();
      return;
    case 4: 
      this.a.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.H();
      return;
    case 2: 
      this.a.stopTitleProgress();
      this.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.H();
      this.a.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.H();
      this.a.a(1, this.a.getString(2131369008));
      return;
    case 3: 
      if (this.a.h == 0) {
        this.a.jdField_a_of_type_Nbh.notifyDataSetChanged();
      }
      for (;;)
      {
        this.a.f = SystemClock.uptimeMillis();
        return;
        this.a.jdField_b_of_type_Nbh.notifyDataSetChanged();
      }
    case 5: 
      paramMessage = paramMessage.obj;
      if ((paramMessage instanceof Object[]))
      {
        Object localObject = (Object[])paramMessage;
        paramMessage = (ArrayList)localObject[0];
        localObject = (ArrayList)localObject[1];
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramMessage);
        this.a.jdField_b_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet visitor UI_ONINIT");
        }
        this.a.jdField_a_of_type_Nbh.a(this.a.jdField_a_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet favor UI_ONINIT");
        }
        this.a.jdField_b_of_type_Nbh.a(this.a.jdField_b_of_type_JavaUtilArrayList);
      }
      if (this.a.h == 0) {
        this.a.jdField_a_of_type_Nbh.notifyDataSetChanged();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "expandGroup-votor UI_ONINIT");
        }
        this.a.b(0);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "expandGroup-favor UI_ONINIT");
        }
        this.a.b(1);
        this.a.c = true;
        if (NetworkUtil.e(this.a)) {
          break;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        return;
        this.a.jdField_b_of_type_Nbh.notifyDataSetChanged();
      }
      this.a.a(true);
      return;
    case 6: 
      this.a.f();
      return;
    case 7: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.a.jdField_b_of_type_Nbh.a(this.a.jdField_b_of_type_JavaUtilArrayList);
      this.a.jdField_b_of_type_Nbh.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "expandGroup fresh fav data");
      }
      this.a.b(1);
      return;
    }
    paramMessage = (CardProfile)paramMessage.obj;
    VisitorsActivity.a(this.a, paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */