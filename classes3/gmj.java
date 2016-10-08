import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class gmj
  extends VideoObserver
{
  public gmj(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, paramInt);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUtilsSparkDot != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(0);
      if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramInt != 0)) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 3000L);
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentAvRandomRandomController != null) && (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null) && ((SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.b == 1) || (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.b == 2)) && (paramInt != 0)) {
      this.a.jdField_a_of_type_ComTencentAvRandomRandomController.b();
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onGetStrangeFace");
    }
    this.a.runOnUiThread(new gml(this));
  }
  
  protected void b()
  {
    super.b();
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(true);
  }
  
  protected void c(int paramInt)
  {
    if (paramInt == 3)
    {
      String str = this.a.getResources().getString(2131363689);
      DialogUtil.a(this.a, 230).setMessage(str).setPositiveButton(this.a.getResources().getString(2131363687), new gmk(this)).show();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */