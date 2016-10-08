import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pcd
  implements DialogInterface.OnClickListener
{
  public pcd(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NewFlowCameraActivity.a(this.a, "608", "7", "2", true);
    NewFlowCameraActivity.a(this.a, "an_yuanshipin");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */