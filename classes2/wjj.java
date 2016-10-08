import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.QLog;

public class wjj
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public wjj(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler, DisplayMetrics paramDisplayMetrics)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 2000;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e)
    {
      int k;
      int m;
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 2: 
        do
        {
          return true;
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.g.setVisibility(8);
          k = (int)paramMotionEvent.getRawX();
          this.e = k;
          this.g = k;
          k = (int)paramMotionEvent.getRawY();
          this.f = k;
          this.h = k;
          return true;
        } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.getVisibility() == 0);
        k = (int)paramMotionEvent.getRawX() - this.e;
        m = (int)paramMotionEvent.getRawY() - this.f;
        this.jdField_a_of_type_Int = (paramView.getLeft() + k);
        this.b = (paramView.getTop() + m);
        this.c = (k + paramView.getRight());
        this.d = (paramView.getBottom() + m);
        if (this.jdField_a_of_type_Int < 0)
        {
          this.jdField_a_of_type_Int = 0;
          this.c = (this.jdField_a_of_type_Int + paramView.getWidth());
          label195:
          if (this.b >= 0) {
            break label403;
          }
          this.b = 0;
          this.d = (this.b + paramView.getHeight());
        }
        for (;;)
        {
          paramView.layout(this.jdField_a_of_type_Int, this.b, this.c, this.d);
          this.e = ((int)paramMotionEvent.getRawX());
          this.f = ((int)paramMotionEvent.getRawY());
          if ((this.jdField_a_of_type_Boolean) || ((Math.abs(paramMotionEvent.getRawX() - this.g) <= 5.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density) && (Math.abs(paramMotionEvent.getRawY() - this.h) <= 5.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density))) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setBackgroundResource(2130839488);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c.setVisibility(8);
          this.jdField_a_of_type_Boolean = true;
          return true;
          if (this.c <= SwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler)) {
            break label195;
          }
          this.c = SwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler);
          this.jdField_a_of_type_Int = (this.c - paramView.getWidth());
          break label195;
          label403:
          if (this.d > SwiftBrowserUIStyleHandler.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler))
          {
            this.d = SwiftBrowserUIStyleHandler.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler);
            this.b = (SwiftBrowserUIStyleHandler.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler) - paramView.getHeight());
          }
        }
      }
      paramView.setBackgroundResource(2130839488);
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.getVisibility() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setBackgroundResource(2130839488);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c.setVisibility(8);
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setBackgroundResource(2130839489);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c.setVisibility(0);
        k = paramView.getTop();
        m = paramView.getWidth() / 2;
        if (this.jdField_a_of_type_Int + m < SwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler) / 2) {
          if (Build.VERSION.SDK_INT < 11) {}
        }
        for (;;)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setRotationY(180.0F);
            paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.getLayoutParams();
            paramView.gravity = 3;
            paramView.leftMargin = m;
            paramView.topMargin = k;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setLayoutParams(paramView);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setPadding((int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 35.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.getPaddingTop(), (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 20.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.getPaddingBottom());
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_show", 0, 1, 0, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.b + "", "", "", "");
            return true;
          }
          catch (Throwable paramView)
          {
            QLog.e(SwiftBrowserUIStyleHandler.jdField_a_of_type_JavaLangString, 1, "floatbtn.setrotationy error!", paramView);
            continue;
          }
          if (Build.VERSION.SDK_INT >= 11) {}
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setRotationY(0.0F);
            paramMotionEvent = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.getLayoutParams();
            paramMotionEvent.gravity = 5;
            paramMotionEvent.rightMargin = (m + (SwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler) - paramView.getRight()));
            paramMotionEvent.topMargin = k;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setLayoutParams(paramMotionEvent);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setPadding((int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 20.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.getPaddingTop(), (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 35.0F), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.getPaddingBottom());
          }
          catch (Throwable paramMotionEvent)
          {
            for (;;)
            {
              QLog.e(SwiftBrowserUIStyleHandler.jdField_a_of_type_JavaLangString, 1, "floatbtn.setrotationy error!", paramMotionEvent);
            }
          }
        }
      }
      this.i = Math.min(this.jdField_a_of_type_Int, SwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler) - this.c);
      if (this.i == this.jdField_a_of_type_Int)
      {
        paramMotionEvent = new TranslateAnimation(0.0F, -this.jdField_a_of_type_Int, 0.0F, 0.0F);
        this.jdField_a_of_type_Int = 0;
        this.c = (this.jdField_a_of_type_Int + paramView.getWidth());
      }
      for (;;)
      {
        paramMotionEvent.setDuration(500L);
        paramView.setVisibility(8);
        paramMotionEvent.setAnimationListener(new wjk(this, paramView));
        paramView.startAnimation(paramMotionEvent);
        return true;
        paramMotionEvent = new TranslateAnimation(0.0F, this.i, 0.0F, 0.0F);
        this.c = SwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler);
        this.jdField_a_of_type_Int = (this.c - paramView.getWidth());
      }
    }
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.g)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.g.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setBackgroundResource(2130839488);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c.setVisibility(8);
      return true;
    }
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.g.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setBackgroundResource(2130839488);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c.setVisibility(8);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */