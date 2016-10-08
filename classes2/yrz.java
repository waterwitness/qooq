import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.famous.QzoneFamousShareJsPlugin;
import java.io.PrintStream;

public class yrz
  implements AdapterView.OnItemClickListener
{
  public yrz(QzoneFamousShareJsPlugin paramQzoneFamousShareJsPlugin, Activity paramActivity, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QzoneFamousShareJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginFamousQzoneFamousShareJsPlugin).dismiss();
    if (QLog.isColorLevel()) {
      QLog.i(QzoneFamousShareJsPlugin.a, 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
    }
    paramView = "";
    paramAdapterView = paramView;
    switch ((int)paramLong)
    {
    default: 
      paramAdapterView = paramView;
    }
    while (paramLong == 1L)
    {
      QzoneFamousShareJsPlugin.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent);
      return;
      paramAdapterView = QZoneJsConstants.S;
      continue;
      paramAdapterView = QZoneJsConstants.T;
      continue;
      paramAdapterView = QZoneJsConstants.U;
      continue;
      paramAdapterView = QZoneJsConstants.V;
      continue;
      paramAdapterView = QZoneJsConstants.W;
    }
    paramView = new Bundle();
    paramView.putString("cmd", paramAdapterView);
    if ((paramLong == 2L) || (paramLong == 3L))
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("bNeedCallBack", true);
      System.out.println("-----js bNEEDCALLBACK:" + this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("bNeedCallBack", false));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtras(paramView);
      QLog.d(QzoneFamousShareJsPlugin.a, 2, "handle famous share cmd: " + paramAdapterView);
      this.jdField_a_of_type_AndroidContentIntent.setClassName(this.jdField_a_of_type_AndroidAppActivity, "com.qzone.web.QZoneTranslucentActivity");
      this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      return;
      this.jdField_a_of_type_AndroidContentIntent.putExtra("bNeedCallBack", false);
      System.out.println("-----js bNEEDCALLBACK:" + this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("bNeedCallBack", false));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */