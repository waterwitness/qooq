import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hlw
  implements Runnable
{
  public hlw(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.a.a.a(1, this.a.p, (byte)1, true, 0);
    if (localObject != null)
    {
      localObject = this.a.a((Bitmap)localObject);
      if (localObject != null) {
        AccountDetailActivity.c(this.a, new hlx(this, (Drawable)localObject));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */