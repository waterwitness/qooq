import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class nto
  implements DialogInterface.OnClickListener
{
  nto(ntn paramntn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    AIOGalleryScene.r(this.a.a).setResult(8001);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */