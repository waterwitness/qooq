import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import java.lang.ref.WeakReference;

public class vom
  extends AsyncTask
{
  private WeakReference a;
  
  public vom(RollangleImageView paramRollangleImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramRollangleImageView);
  }
  
  protected Bitmap a(Boolean... paramVarArgs)
  {
    RollangleImageView localRollangleImageView = (RollangleImageView)this.a.get();
    if (localRollangleImageView != null) {
      return RollangleImageView.a(localRollangleImageView, paramVarArgs[0].booleanValue());
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    RollangleImageView localRollangleImageView = (RollangleImageView)this.a.get();
    if ((localRollangleImageView != null) && (paramBitmap != null)) {
      localRollangleImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */