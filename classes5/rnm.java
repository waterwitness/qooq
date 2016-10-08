import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class rnm
  implements View.OnClickListener
{
  public rnm(FMLocalFileActivity paramFMLocalFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {
      if (QLog.isColorLevel()) {
        QLog.i(FMLocalFileActivity.e, 2, "click too fast , wait a minute.");
      }
    }
    do
    {
      return;
      this.a.e();
      paramView = (FileCategoryAdapter.ItemHolder)paramView.getTag();
    } while (paramView.a == 0);
    int i = paramView.a;
    paramView = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
    paramView.putBoolean("last_select_All", true);
    paramView.commit();
    FMLocalFileActivity.a(this.a, i);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rnm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */