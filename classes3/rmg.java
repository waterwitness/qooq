import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rmg
  implements DialogInterface.OnClickListener
{
  public rmg(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a = false;
    this.a.l = false;
    this.a.doOnBackPressed();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */