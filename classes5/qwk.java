import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qwk
  implements View.OnClickListener
{
  public qwk(FlowCameraPhotoActivity paramFlowCameraPhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView.setVisibility(8);
    if (this.a.a != null) {
      this.a.a.a(2, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */