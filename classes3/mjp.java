import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mjp
  implements Runnable
{
  mjp(mjo parammjo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RegisterVerifyCodeActivity.b(this.a.a.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */