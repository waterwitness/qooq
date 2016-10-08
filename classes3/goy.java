import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class goy
  extends VideoObserver
{
  public goy(SmallScreenVideoController paramSmallScreenVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, String.format("onCrmIVRBeforeRequest, errorCode = %d, ivrRequestSeq = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.a(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, String.format("onCrmIVRRequestAck, ivrRequestSeq = %d, errorCode = %d, errorMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    super.a(paramInt1, paramInt2, paramString);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, String.format("onRecvCrmIVRPush, errorCode=%d seq=%d url=%s data=%s, roomId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, Long.valueOf(paramLong) }));
    }
    super.a(paramInt1, paramInt2, paramString1, paramString2, paramLong);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString)) {
      return;
    }
    super.a(paramInt, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011)
    {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(false);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_b_of_type_JavaLangString) != 5) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramString, 1, false, false, bool);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c(paramInt);
      return;
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(0, 0, true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramRecvMsg);
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
      if ((i == 1) || (i == 2))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h(false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(2);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h(true);
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(1);
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramString1, paramString2);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onDestroyUI isQuit = " + paramBoolean);
    }
    super.a(paramString, paramBoolean);
    if ((this.a.h == 1) || (this.a.h == 2))
    {
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (paramString != null) && (this.a.jdField_b_of_type_JavaLangString.equals(paramString)))
      {
        this.a.jdField_b_of_type_Boolean = paramBoolean;
        this.a.c();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        paramString = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qav_SP", 0).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c());
      }
    }
    String str;
    do
    {
      paramString.commit();
      do
      {
        return;
      } while ((this.a.h != 3) && (this.a.h != 4));
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().s;
    } while ((str == null) || (paramString == null) || (!str.equals(paramString)));
    this.a.jdField_b_of_type_Boolean = paramBoolean;
    this.a.c();
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b(paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.i, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_c_of_type_JavaLangString);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.a.j = this.a.jdField_a_of_type_ComTencentAvVideoController.a().A;
        this.a.d = this.a.jdField_a_of_type_ComTencentAvVideoController.a().q;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "setBindInfo: mBindType = " + this.a.j + ",mBindId = " + this.a.d);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.a.j, this.a.d);
    }
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    int i = VipFunCallManager.a();
    Object localObject = VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (localObject == null) {}
    do
    {
      return;
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j != 4) && (this.a.h == 1) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate finish id:" + paramInt);
  }
  
  protected void b(int paramInt1, int paramInt2) {}
  
  protected void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "peerUin = " + paramString + " # isQuit :" + paramBoolean);
    }
    if ((this.a.h == 1) || (this.a.h == 2))
    {
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) {
        break label163;
      }
      this.a.c();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().p = false;
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qav_SP", 0).edit();
        localEditor.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c());
        localEditor.commit();
      }
      super.b(paramString, paramBoolean);
      return;
      label163:
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (paramString != null) && (this.a.jdField_b_of_type_JavaLangString.equals(paramString)))
      {
        this.a.jdField_b_of_type_Boolean = paramBoolean;
        this.a.c();
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
  }
  
  protected void c()
  {
    super.c();
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "WL_DEBUG onDetectNoDevicePermission DeviceType = " + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
      long l = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
      paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(l, 1);
      if (paramInt != -1) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.remove(paramInt);
  }
  
  protected void c(String paramString)
  {
    super.c(paramString);
  }
  
  protected void c(String paramString, boolean paramBoolean) {}
  
  protected void d()
  {
    super.d();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
    }
    Object localObject;
    boolean bool2;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.a.jdField_c_of_type_Boolean) {
        break label275;
      }
      bool1 = true;
      ((SessionInfo)localObject).jdField_f_of_type_Boolean = bool1;
      if (this.a.jdField_c_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        bool2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().g;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_b_of_type_JavaLangString) != 5) {
          break label280;
        }
      }
    }
    label275:
    label280:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, bool2, false, bool1);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(0, 0, true);
      }
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.k();
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void d(String paramString, boolean paramBoolean)
  {
    super.d(paramString, paramBoolean);
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPauseVideo");
    }
    super.e();
    if (!VcSystemInfo.d()) {
      return;
    }
    String str;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_b_of_type_JavaLangString) != 5) {
        break label166;
      }
    }
    label166:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, false, false, bool);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().l != 1011) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().G != 3) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
      return;
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onRequestVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 2;
    this.a.a();
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onResumeVideo");
    }
    super.f();
    if (!VcSystemInfo.d()) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) || (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)) {
      return;
    }
    String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_b_of_type_JavaLangString) == 5) {}
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, true, false, bool);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 1, this.a.jdField_a_of_type_AndroidGraphicsBitmap, true, false);
      return;
    }
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 3;
    this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.s();
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
  }
  
  protected void h()
  {
    super.h();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.t();
    }
  }
  
  protected void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onCancelVideoMode fromUin = " + paramString);
    }
    super.h(paramString);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
  }
  
  protected void i()
  {
    super.i();
  }
  
  protected void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onNeedShowPeerVideo");
    }
    super.k();
    if (!VcSystemInfo.d()) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) || (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)) {
      return;
    }
    VideoLayerUI localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_b_of_type_JavaLangString) == 5) {}
    for (boolean bool = true;; bool = false)
    {
      localVideoLayerUI.a(str, 1, true, false, bool);
      return;
    }
  }
  
  protected void l()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
    }
  }
  
  protected void m()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\goy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */