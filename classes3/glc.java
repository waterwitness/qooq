import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class glc
  implements Runnable
{
  glc(glb paramglb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SessionMgr.a().a(this.a.a.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {}
    do
    {
      return;
      if (SessionMgr.a().a(this.a.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).f()) {
        this.a.a.g();
      }
    } while (this.a.a.jdField_a_of_type_ComTencentAvRandomRandomController.l != -3);
    this.a.a.jdField_a_of_type_ComTencentAvUtilsSparkDot.b();
    this.a.a.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(8);
    this.a.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */