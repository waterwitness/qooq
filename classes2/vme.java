import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.widget.QQToast;

class vme
  implements Runnable
{
  vme(vmd paramvmd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.a.a;
    if (localBaseActivity != null) {
      QQToast.a(localBaseActivity, localBaseActivity.getString(2131364289), 0).b(localBaseActivity.getTitleBarHeight());
    }
    this.a.cancel();
    this.a.a.a();
    this.a.a.a(localBaseActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */