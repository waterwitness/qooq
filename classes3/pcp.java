import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pcp
  implements DialogInterface.OnClickListener
{
  public pcp(NewPreFlowCamera paramNewPreFlowCamera)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FontSettingManager.a();
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */