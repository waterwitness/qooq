import android.app.Dialog;
import android.view.View;
import android.widget.Adapter;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class rdc
  implements AdapterView.OnItemClickListener
{
  public rdc(DatingDestinationActivity paramDatingDestinationActivity, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DatingDestinationActivity", 2, "setOnItemClickListener" + paramInt);
    }
    paramAdapterView = paramAdapterView.a().getItem(paramInt);
    if (paramAdapterView != null)
    {
      paramAdapterView = (appoint_define.LocaleInfo)paramAdapterView;
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.a(paramAdapterView);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */