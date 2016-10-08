import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

class ltq
  implements Runnable
{
  ltq(ltp paramltp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a.a.a.getApplicationContext(), this.a.a.a.getString(2131370656), 0).b(this.a.a.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */