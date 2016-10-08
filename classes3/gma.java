import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class gma
  implements Runnable
{
  gma(glz paramglz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onRandomUpdate");
    }
    if ((this.a.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI == null)) {}
    do
    {
      do
      {
        return;
        localObject = SessionMgr.a().a(this.a.a.jdField_a_of_type_ComTencentAvRandomRandomController.d);
      } while (localObject == null);
      this.a.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(((SessionInfo)localObject).e, 7, false);
      this.a.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setRandomMultiIsMask(this.a.a.jdField_a_of_type_ComTencentAvRandomRandomController.a);
      RandomMultiActivity.a(this.a.a, true);
      this.a.a.c();
    } while (this.a.a.jdField_a_of_type_ComTencentAvRandomRandomController.l != -3);
    Object localObject = (SparkDot)this.a.a.findViewById(2131299114);
    ((SparkDot)localObject).b();
    ((SparkDot)localObject).setVisibility(8);
    this.a.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, false);
    this.a.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(32, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */