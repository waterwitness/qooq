import android.os.Handler;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rof
  implements Runnable
{
  rof(roe paramroe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.e)
    {
      this.a.a.d();
      return;
    }
    this.a.a.e();
    this.a.a.d();
    new Handler().postDelayed(new rog(this), 1500L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */