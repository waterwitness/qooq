import android.os.Handler;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

public class mkl
  implements INetEventHandler
{
  public mkl(SendMultiPictureHelper paramSendMultiPictureHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Toast.makeText(BaseApplicationImpl.a(), this.a.a.getString(2131370479), 1).show();
      mkm localmkm = new mkm(this);
      new Handler().postDelayed(localmkm, 3000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */