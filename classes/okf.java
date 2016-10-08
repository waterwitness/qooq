import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.util.MqqWeakReferenceHandler;

public class okf
  implements BaseTroopView.ITroopContext
{
  public okf(TroopActivity paramTroopActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Activity a()
  {
    return this.a;
  }
  
  public View a()
  {
    return this.a.findViewById(2131296895);
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public ForwardBaseOption a()
  {
    return TroopActivity.a(this.a);
  }
  
  public MqqWeakReferenceHandler a()
  {
    return this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.a.j != 2) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(paramBoolean);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(paramBoolean);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.runOnUiThread(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.a.isResume()) {
      QQToast.a(a(), paramString, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  public boolean a()
  {
    return TroopActivity.a(this.a);
  }
  
  public View b()
  {
    return this.a.findViewById(2131296896);
  }
  
  public View c()
  {
    return this.a.findViewById(2131299601);
  }
  
  public View d()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\okf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */