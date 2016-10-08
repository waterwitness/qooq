import android.content.Intent;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.av.utils.SensorHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class gvw
  extends GAudioUIObserver
{
  public gvw(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong)
  {
    super.a(paramLong);
    super.a(paramLong);
    this.a.n();
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().aj = true;
    if ((this.a.jdField_d_of_type_Boolean) && (this.a.jdField_d_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 500L);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {
      MultiVideoCtrlLayerUI4NewGroupChat.d(this.a);
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.b);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramLong2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "onGroupSecurityLimit-->groupid=" + paramLong1 + " info=" + paramLong2 + " strMsg=" + paramString);
    }
    if (this.a.jdField_d_of_type_Int != 1) {}
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 33);
      localIntent.putExtra("relationId", paramLong1);
      localIntent.putExtra("uinType", this.a.c);
      localIntent.putExtra("info", paramLong2);
      localIntent.putExtra("strMsg", paramString);
      localIntent.putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat1");
      paramString = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null)
      {
        localIntent.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        paramString.sendBroadcast(localIntent);
        MultiVideoCtrlLayerUI4NewGroupChat.b(this.a, true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "onGroupSecurityLimit-->can not get the activity");
  }
  
  protected void b(long paramLong)
  {
    super.b(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    super.b(paramLong);
    this.a.n();
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gvx(this.a), 500L);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {
      MultiVideoCtrlLayerUI4NewGroupChat.e(this.a);
    }
    MultiVideoCtrlLayerUI4NewGroupChat.f(this.a);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    super.b(paramLong, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "onGroupVideoChatClosed-->relationId" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "onGroupVideoChatClosed--> relationId != mIntentGroupId");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 32);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("uinType", this.a.c);
      localIntent.putExtra("closeType", paramInt1);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat2");
      AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        localIntent.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        localAVActivity.sendBroadcast(localIntent);
        MultiVideoCtrlLayerUI4NewGroupChat.c(this.a, true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "onGroupVideoChatClosed-->can not get the activity");
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.b(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa = true;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.h(this.a);
    }
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.c(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa = false;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.g(this.a);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */