import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ozp
  implements DialogInterface.OnClickListener
{
  ozp(ozo paramozo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.a.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.a.setResult(1001, paramDialogInterface);
    paramDialogInterface = null;
    if (this.a.a.g) {
      paramDialogInterface = this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    }
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.a.a.d, this.a.a.e, this.a.a.n, this.a.a.g, paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */