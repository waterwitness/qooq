import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.GenerateThumbTask;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.VideoProcessListener;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class pad
  implements NewFlowCameraActivity.VideoProcessListener
{
  public pad(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      NewFlowCameraActivity.c(this.a, paramString);
      NewFlowCameraActivity.b(this.a, paramArrayOfByte);
      NewFlowCameraActivity.a(this.a, paramInt1);
      NewFlowCameraActivity.b(this.a, paramInt2);
      this.a.D();
      this.a.c("上传视频中...");
      return;
    }
    this.a.i(true);
    QQToast.a(this.a, "对不起，缩略图处理异常...", 0).a();
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (paramBoolean)
    {
      NewFlowCameraActivity.a(this.a, paramString1);
      NewFlowCameraActivity.a(this.a, paramArrayOfByte);
      NewFlowCameraActivity.b(this.a, paramString2);
      new NewFlowCameraActivity.GenerateThumbTask(this.a, this, this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(), this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), this.a.jdField_a_of_type_Double, this.a.b).execute(new Void[] { (Void)null });
      this.a.c("缩略图生成中...");
      return;
    }
    this.a.i(true);
    QQToast.a(this.a, "对不起，视频处理异常...", 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */