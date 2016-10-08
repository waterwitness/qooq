import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;
import com.tencent.mobileqq.widget.SelectPicPopupWindow.ViewHolder;
import java.io.File;
import java.util.ArrayList;

public class mem
  implements View.OnClickListener
{
  public mem(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = QQMapActivity.b(this.a).getDimensionPixelSize(2131492908);
    int j = paramView.getId();
    if (j == 2131297387) {
      if (new File(QQMapConstants.i).exists())
      {
        this.a.t = true;
        UniformDownloadUtil.a(QQMapConstants.i);
      }
    }
    label473:
    do
    {
      boolean bool;
      do
      {
        return;
        if (this.a.C == 1)
        {
          QQMapActivity.a(this.a);
          ((SelectPicPopupWindow.ViewHolder)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0)).a.setText(this.a.getString(2131364916));
          this.a.C = 2;
          return;
        }
        if (!NetworkUtil.e(this.a.getApplicationContext()))
        {
          QQToast.a(this.a, 1, this.a.getString(2131364906), 1).b(i);
          return;
        }
        if (NetworkUtil.i(this.a.getApplicationContext()))
        {
          this.a.o();
          return;
        }
        this.a.p();
        return;
        if (j != 2131299850) {
          break;
        }
        if (this.a.a.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          QQToast.a(this.a, 1, this.a.getString(2131364908), 1).b(i);
          return;
        }
        paramView = (String)this.a.a.jdField_a_of_type_AndroidWidgetImageView.getTag();
        this.a.c(paramView);
        bool = QQMapActivity.a(this.a, paramView);
        this.a.a.dismiss();
      } while (bool);
      QQToast.a(this.a, 1, this.a.getString(2131364905), 1).b(i);
      return;
      if (j == 2131299851)
      {
        if (this.a.a.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          QQToast.a(this.a, 1, this.a.getString(2131364908), 1).b(i);
          return;
        }
        if (!this.a.a(this.a.a(), true))
        {
          QQMapActivity.a(this.a);
          this.a.C = 2;
          if (!new File(QQMapConstants.i).exists()) {
            break label473;
          }
        }
        for (paramView = this.a.getString(2131364914);; paramView = this.a.getString(2131364913))
        {
          this.a.a.a(paramView);
          paramView = (String)this.a.a.jdField_a_of_type_AndroidWidgetImageView.getTag();
          if (QQMapActivity.a(this.a, paramView)) {
            break;
          }
          QQToast.a(this.a, 1, this.a.getString(2131364905), 1).b(i);
          this.a.a.dismiss();
          return;
        }
      }
    } while ((!(paramView.getTag() instanceof Integer)) || (((Integer)paramView.getTag()).intValue() != 1));
    paramView = (ImageView)paramView.findViewById(2131299853);
    if (this.a.a.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.a.a.jdField_a_of_type_AndroidWidgetImageView = paramView;
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */