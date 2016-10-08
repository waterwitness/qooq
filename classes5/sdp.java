import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.util.ArrayList;

public final class sdp
  implements View.OnClickListener
{
  public sdp(boolean paramBoolean, String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_AndroidAppActivity, (ArrayList)localObject, 6, 6, false, null);
    }
    for (;;)
    {
      if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
      {
        paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
        if (paramView.a.isShowing()) {
          paramView.a.dismiss();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.d();
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (!((QlAndQQInterface.WorkState)localObject).mWorking)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("_FILE_PATH_", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidAppActivity.setResult(10, (Intent)localObject);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_AndroidAppActivity, new sdq(this, (QlAndQQInterface.WorkState)localObject), new sdr(this), new sds(this), null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sdp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */