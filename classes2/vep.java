import android.app.Activity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.app.AppRuntime;

public class vep
  implements NearbyTroopsBaseView.INearbyTroopContext
{
  public vep(NearbyTroopsActivity paramNearbyTroopsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.a.r;
  }
  
  public Activity a()
  {
    return this.a;
  }
  
  public TextView a()
  {
    return this.a.rightViewText;
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public MqqWeakReferenceHandler a()
  {
    return this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  }
  
  public String a()
  {
    return this.a.g;
  }
  
  public AppRuntime a()
  {
    return this.a.jdField_a_of_type_ComTencentCommonAppAppInterface;
  }
  
  public void a(int paramInt)
  {
    this.a.rightViewImg.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.a.b(paramCharSequence);
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
    return this.a.b();
  }
  
  public int b()
  {
    return this.a.s;
  }
  
  public void b(int paramInt)
  {
    this.a.rightViewText.setVisibility(paramInt);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    if ((this.a.leftView != null) && ((this.a.leftView instanceof TextView)) && (!TextUtils.isEmpty(paramCharSequence))) {
      this.a.leftView.setText(paramCharSequence);
    }
  }
  
  public boolean b()
  {
    return this.a.startTitleProgress();
  }
  
  public void c(int paramInt)
  {
    this.a.s = paramInt;
  }
  
  public boolean c()
  {
    return this.a.stopTitleProgress();
  }
  
  public boolean d()
  {
    return (this.a == null) || (!this.a.isResume());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */