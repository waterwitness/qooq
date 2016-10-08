import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class wal
  implements Runnable
{
  public wal(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a, 2131371320, 1).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */