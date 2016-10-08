import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mhy
  implements Runnable
{
  mhy(mhw parammhw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RegisterActivity.d(this.a.a);
    RegisterActivity.a(this.a.a, "请重新发送短信");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */