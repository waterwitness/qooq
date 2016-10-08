import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.DialogVideoLayerUI;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class gls
  extends VideoObserver
{
  public boolean a;
  
  public gls(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, paramInt);
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_H_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsSparkDot != null)
    {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramInt != 0)) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_b_of_type_JavaLangRunnable, 3000L);
      }
    }
    if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {
      return;
    }
    if (((SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.b == 1) || (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.b == 2)) && (paramInt != 0)) {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.b();
    }
    super.a(paramInt);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onClose reason = " + paramInt);
    }
    if (paramInt == 2) {}
    for (;;)
    {
      super.a(paramInt, paramString);
      return;
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.i();
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.j(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_H_of_type_Boolean);
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    super.a(paramString, paramBitmap);
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onGetStrangeFace ");
    }
    if ((paramBitmap != null) && (!this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean) && (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null))
    {
      SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d).f()) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.runOnUiThread(new glu(this));
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "onDestroyUI peerUin = " + paramString + ", mRandom.mProPeerUin = " + this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onDestroyUI peerUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f != null) && (paramString != null) && (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f.equals(paramString)) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f);
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.c();
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.finish();
    if (!paramBoolean)
    {
      int j = 2130968685;
      int i = j;
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a();
        i = j;
        if (localSessionInfo != null) {
          i = SmallScreenUtils.a(localSessionInfo.J);
        }
      }
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.overridePendingTransition(0, i);
    }
    super.a(paramString, paramBoolean);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Int = 1;
      if (!paramBoolean) {
        break label87;
      }
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(26, true);
      }
    }
    for (;;)
    {
      super.a(paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Int = 2;
      break;
      label87:
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(26, false);
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(27, false);
        if ((this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b()) && (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
          this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(24, true);
        }
      }
      if ((SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null) && (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d).b != 1L)) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d();
      }
    }
  }
  
  protected void b()
  {
    super.b();
    if ((this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null))
    {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.p, this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f, "");
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_Int = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d).A;
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_JavaLangString = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d).q;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "setBindInfo: mBindType = " + this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_Int + ",mBindId = " + this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController != null) && (!this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.b())) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount());
      }
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(true);
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b();
  }
  
  protected void c(int paramInt)
  {
    if (paramInt == 3)
    {
      String str = this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.getResources().getString(2131363689);
      DialogUtil.a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.getResources().getString(2131363687), new glt(this)).show();
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onConnected");
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d();
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.k();
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d(false);
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.g();
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "getPeerSdkVersion = " + this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f));
    }
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f) < 45)
    {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d.setClickable(false);
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d.setEnabled(false);
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.e.setEnabled(true);
      if ((SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) || (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_c_of_type_Boolean)) {
        break label327;
      }
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.c(2131299015);
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_AndroidWidgetButton != null) {
        UITools.a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_AndroidWidgetButton, this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.getResources().getString(2131363362));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(true);
      return;
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d.setClickable(true);
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d.setEnabled(true);
      break;
      label327:
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d(2131299015);
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_AndroidWidgetButton != null) {
        UITools.a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_AndroidWidgetButton, this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.getResources().getString(2131363361));
      }
    }
  }
  
  protected void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onPauseVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      String str = this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, false, false, false);
    }
    if (!this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.b(1);
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.c();
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().G == 3)
    {
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, true);
      }
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onRequestVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().G = 2;
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(0);
  }
  
  protected void e(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onCloseSessionFinished peerUin = " + paramString + ", isQuit = " + paramBoolean);
    }
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.f)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.n();
    }
    for (;;)
    {
      super.e(paramString, paramBoolean);
      return;
      if ((!this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_f_of_type_Boolean)) {
        RandomDoubleActivity.b(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity);
      }
    }
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onResumeVideo");
    }
    super.f();
    if ((!VcSystemInfo.d()) || (Utils.a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1)) {
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.b(2);
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165195, null, 0, null);
          if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
            this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, false);
          }
        }
      } while (!VcSystemInfo.d());
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        String str = this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, true, false, false);
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_AndroidGraphicsBitmap, true, false);
      }
    } while (((this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().G != 1) && (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().G != 3)) || (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_H_of_type_Boolean) || (!"DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().r)));
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().G = 3;
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(false);
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.c(true);
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_JavaLangRunnable);
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onPauseAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      if ((this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Int != 1)) {
        break label64;
      }
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(27, true);
    }
    for (;;)
    {
      super.g();
      return;
      label64:
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
      }
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(false);
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_c_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(74, true);
    }
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onResumeAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, false);
    }
    super.h();
  }
  
  protected void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onCancelVideoMode fromUin = " + paramString);
    }
    super.h(paramString);
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(false);
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onFinishUI");
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController != null)
    {
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvRandomRandomController.c();
    }
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.finish();
    super.j();
  }
  
  protected void k()
  {
    super.k();
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onNeedShowPeerVideo");
    }
    if ((!VcSystemInfo.d()) || (Utils.a(this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (VcSystemInfo.d()) {
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d.setEnabled(true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.b(2);
      }
      if (this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
        break;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, false);
      }
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, false);
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity.d.setEnabled(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */