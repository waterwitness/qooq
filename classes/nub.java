import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class nub
  implements DialogInterface.OnClickListener
{
  nub(nua paramnua)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    AIOImageListScene.j(this.a.a).setResult(8001);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */