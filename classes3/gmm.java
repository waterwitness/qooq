import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gmm
  extends GAudioUIObserver
{
  public gmm(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "finishActivity isQuit" + paramBoolean);
    }
    if (paramBoolean)
    {
      RandomMultiActivity.a(this.a);
      return;
    }
    this.a.finish();
  }
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null) {
      this.a.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvRandomRandomController != null) && (!this.a.jdField_a_of_type_ComTencentAvRandomRandomController.b()))
    {
      if (this.a.c == null) {
        this.a.c = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      }
      this.a.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.a.c);
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.a.jdField_a_of_type_ComTencentAvRandomRandomController.b())) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c);
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onCreateOrEnterRoomFail-->GroupID=" + paramLong + ", reason" + paramInt1);
    }
    this.a.jdField_a_of_type_ComTencentAvRandomRandomController.a();
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onMemberJoin,wrong group uin.GroupUin=" + paramLong1 + " mGroupId=" + this.a.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long);
      }
      return;
    }
    super.a(paramLong1, paramLong2, paramBoolean);
    this.a.c();
    this.a.a(paramLong2);
    this.a.d();
    this.a.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b(String.valueOf(paramLong2));
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onMemberJoin friendUin" + paramLong2 + " isRefresh=" + paramBoolean1);
    }
    if (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {
      if (QLog.isColorLevel()) {
        QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onMemberJoin mSessionId: " + this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d + ", session has been destroyed.");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if ((this.a.c != null) && (Long.parseLong(this.a.c) == paramLong2))
        {
          localObject = SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d);
          if ((this.a.b != null) && (this.a.b.isSelected()))
          {
            ((SessionInfo)localObject).c = true;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long, false);
          }
        }
        localObject = String.valueOf(paramLong2);
        VideoController.GAudioFriends localGAudioFriends = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject);
        if (localGAudioFriends != null)
        {
          localGAudioFriends.b = SystemClock.elapsedRealtime();
          if ((RandomMultiActivity.a(this.a, (String)localObject)) && (this.a.jdField_a_of_type_ComTencentAvRandomRandomController != null) && (!this.a.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)) {
            this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.f, false);
          }
        }
        if (this.a.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long == paramLong1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onMemberJoin, wrong group uin.GroupUin=" + paramLong1 + " mCurrGroupId=" + this.a.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long);
      return;
      RandomMultiActivity.a(this.a, true);
      this.a.c();
      this.a.d();
    } while (this.a.jdField_a_of_type_ComTencentAvRandomRandomController == null);
    if (RandomMultiActivity.a(this.a, (String)localObject))
    {
      this.a.jdField_a_of_type_ComTencentAvRandomRandomController.i();
      if (!TextUtils.isEmpty(SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.e))
      {
        this.a.d.setText(SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.e);
        this.a.d.setContentDescription(SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.e);
        this.a.d.setVisibility(0);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gmn(this), 1000L);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvRandomRandomController.a((String)localObject);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gmo(this), 1000L);
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onDestroyRandomChat");
    }
    super.c(paramLong);
    if ((this.a.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long == paramLong) || (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.b <= 1)) {
      b(paramBoolean);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2);
    if ((!RandomMultiActivity.a(this.a, String.valueOf(paramLong))) || (this.a.jdField_a_of_type_ComTencentAvVideoController.F != 3))
    {
      this.a.c();
      if (this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI == null) {
        break label66;
      }
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramBoolean1);
    }
    label66:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + paramLong + " , Speak = " + paramBoolean1);
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onGetStrangeFaceBitmap");
    }
    this.a.runOnUiThread(new gmp(this));
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onGroupVideoChatClosed" + paramInt1);
    }
    RandomMultiActivity.a(this.a);
  }
  
  protected void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "onDestroyUI");
    }
    super.c(paramLong);
    if (this.a.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long == paramLong) {
      b(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */