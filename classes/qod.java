import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class qod
  implements Runnable
{
  public qod(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      QQToast.a(BaseApplicationImpl.getContext(), this.a, 1).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */