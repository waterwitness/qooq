import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.PopupMenuPA;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jfj
  implements View.OnClickListener
{
  public jfj(CustomMenuBar paramCustomMenuBar, PopupMenuPA paramPopupMenuPA, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      Context localContext;
      int i;
      int j;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PA_anim", 4, "Animation Begin: " + System.currentTimeMillis());
        }
        localContext = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getContext();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        j = localDisplayMetrics.heightPixels - CustomMenuBar.a(localContext);
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows == null)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentBizUiPopupMenuPA.a();
            return;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizUiPopupMenuPA.a(paramView, 0, CustomMenuBar.a(localContext), i, j, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getHeight(), this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getPaddingTop(), this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getPaddingBottom());
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows = this.jdField_a_of_type_ComTencentBizUiPopupMenuPA;
          return;
        }
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows == this.jdField_a_of_type_ComTencentBizUiPopupMenuPA)
      {
        if (!this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentBizUiPopupMenuPA.a();
            return;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizUiPopupMenuPA.a(paramView, 0, CustomMenuBar.a(localContext), i, j, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getHeight(), this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getPaddingTop(), this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getPaddingBottom());
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizUiPopupMenuPA.a();
          return;
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizUiPopupMenuPA.a(paramView, 0, CustomMenuBar.a(localContext), i, j, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getHeight(), this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getPaddingTop(), this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getPaddingBottom());
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows = this.jdField_a_of_type_ComTencentBizUiPopupMenuPA;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */