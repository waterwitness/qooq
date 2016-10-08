import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nuc
  implements DialogInterface.OnDismissListener
{
  public nuc(AIOImageListScene paramAIOImageListScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AIOImageListScene.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */