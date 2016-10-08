import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.random.ui.DialogVideoLayerUI;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class glj
  implements Runnable
{
  public glj(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().G == 1)
    {
      this.a.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(false);
      this.a.a(1);
      if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(73, true);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */