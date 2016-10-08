import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.HCTopicSeatsView;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class nyq
  extends HotChatObserver
{
  public nyq(HotChatPie paramHotChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null))
    {
      HCTopicSeatsView localHCTopicSeatsView = this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a();
      if (localHCTopicSeatsView != null) {
        localHCTopicSeatsView.a();
      }
    }
  }
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.aio.BaseTroopChatPie", new Object[] { "onPushExitHotChat", paramString, paramHotChatStateWrapper });
    }
    if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramString)) {}
    int i;
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null)
      {
        HCTopicSeatsView localHCTopicSeatsView = this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a();
        if (localHCTopicSeatsView != null) {
          localHCTopicSeatsView.a();
        }
      }
      i = paramHotChatStateWrapper.targetState;
    } while (i == 1);
    HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null))
    {
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a();
      if (paramString1 != null) {
        paramString1.a();
      }
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.BaseTroopChatPie", 2, "TroopChatPie.onExitHotChat  troopUin=" + paramString1);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString1))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.d();
      }
      this.a.a(0);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, String paramString3)
  {
    if (!Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a(paramBoolean, paramInt1, paramString1, paramString2, paramLong1, paramInt2, paramInt3, paramInt4, paramLong2, paramString3);
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.aio.BaseTroopChatPie", new Object[] { "onQuickJoinHotChat", Boolean.valueOf(paramBoolean), paramString, paramHotChatInfo });
    }
    if (!paramBoolean) {
      if ((Utils.a(this.a.ar, paramString)) || ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid, paramString))))
      {
        paramHotChatInfo = HotChatUtil.a(paramInt);
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramHotChatInfo, 1).a();
      }
    }
    do
    {
      do
      {
        return;
        if ((Utils.a(this.a.ar, paramString)) && (paramHotChatInfo != null) && (!Utils.a(paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
        {
          if (QLog.isColorLevel()) {
            NearbyUtils.a("Q.aio.BaseTroopChatPie", new Object[] { "onQuickJoinHotChat_not_same_aio", String.format("uuid:%s, new:%s, old:%s", new Object[] { paramString, paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a }) });
          }
          MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          paramWifiPOIInfo = new Intent(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class);
          paramWifiPOIInfo.putExtra("uin", paramHotChatInfo.troopUin);
          paramWifiPOIInfo.putExtra("uintype", 1);
          paramWifiPOIInfo.putExtra("troop_uin", paramHotChatInfo.troopCode);
          paramWifiPOIInfo.putExtra("uinname", paramHotChatInfo.name);
          paramWifiPOIInfo.addFlags(67108864);
          paramWifiPOIInfo.putExtra("hotnamecode", paramHotChatInfo.uuid);
          if (paramHotChatInfo.supportDemo) {}
          for (paramInt = 2;; paramInt = 0)
          {
            paramWifiPOIInfo.putExtra("HOTCHAT_EXTRA_FLAG", paramInt);
            paramHotChatInfo = AIOUtils.a(paramWifiPOIInfo, new int[] { 2 });
            paramHotChatInfo.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
            this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramHotChatInfo);
            if (!(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) {
              break;
            }
            this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
            return;
          }
        }
      } while ((paramHotChatInfo == null) || (!Utils.a(paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) || (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl == null));
      paramHotChatInfo = this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a();
      if (paramHotChatInfo != null) {
        paramHotChatInfo.a();
      }
    } while (!QLog.isDevelopLevel());
    NearbyUtils.a("PttShow", "onQuickJoinHotChat", new Object[] { paramHotChatInfo });
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onGetUserCreateHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", troopOwner=" + paramLong);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, null)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b(l1);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.BaseTroopChatPie", 2, "onKickHotChatMember.isSuccess=" + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",memberuin=" + paramString2 + ",strError=" + paramString3);
    }
    if ((this.a.h != null) && (this.a.h.isShowing())) {
      this.a.h.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.a(this.a.a(), "删除热聊成员成功", 0).b(this.a.a().getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.a(), "删除热聊成员失败", 0).b(this.a.a().getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, Common.WifiPOIInfo paramWifiPOIInfo, Boolean paramBoolean1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid))) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onUploadPttshowPraise=" + paramBoolean + ", mHCMng=null");
      return;
      if (paramBoolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.BaseTroopChatPie", 2, "onUploadPttshowPraise=false, uuid=" + paramString + ", needRequestNext=" + paramBoolean1);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onUploadPttshowPraise=true, uuid=" + paramString + ", wifipoiinfo=" + paramWifiPOIInfo.toString() + ", needRequestNext=" + paramBoolean1);
    }
    paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
    if (paramWifiPOIInfo.uint64_report_praise_gap_time.get() < 0L) {}
    for (long l = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d;; l = paramWifiPOIInfo.uint64_report_praise_gap_time.get())
    {
      paramString.d = l;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d < 10000L) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d = 10000L;
      }
      if ((!paramBoolean1.booleanValue()) || (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl == null) || (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a == null)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.removeMessages(4);
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.obtainMessage(4);
      this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.sendMessageDelayed(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramWifiPOIInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid))) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onUploadPttshowPraise=" + paramBoolean1 + ", mHCMng=null");
      return;
      if (paramBoolean1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.BaseTroopChatPie", 2, "onGetPttshowPraise=false, uuid=" + paramString);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onGetPttshowPraise=true, uuid=" + paramString + ", mOldPraiseCount=" + this.a.i + ", wifipoiinfo=" + paramWifiPOIInfo.toString());
    }
    paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
    long l2;
    if (paramWifiPOIInfo.uint64_get_praise_gap_time.get() > 0L)
    {
      l1 = paramWifiPOIInfo.uint64_get_praise_gap_time.get();
      paramString.f = l1;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.f < 10000L) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.f = 10000L;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null) && (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a != null))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.removeMessages(5);
        paramString = this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.obtainMessage(5);
        this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a.sendMessageDelayed(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.f);
      }
      l2 = paramWifiPOIInfo.uint64_praise_nums.get();
      if (this.a.i <= l2) {
        break label433;
      }
    }
    label433:
    for (long l1 = this.a.i;; l1 = l2)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.praiseCount = l2;
      l2 = this.a.i;
      this.a.i = l1;
      HotChatPie.a(this.a).post(new nyr(this, l1, paramBoolean2, l1 - l2));
      return;
      l1 = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.f;
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onGetHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", jumpurl=" + paramString3);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, paramString3)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b(l1);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin))) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl != null)
        {
          HCTopicSeatsView localHCTopicSeatsView = this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatPttStageControl.a();
          if (localHCTopicSeatsView != null) {
            localHCTopicSeatsView.a(paramBoolean1, paramBoolean2, paramInt1, paramString1, paramString2, paramInt2, paramString3, paramInt3, paramInt4);
          }
        }
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.getUserType(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) != 0) || (this.a.f() != 2));
      this.a.ah();
    } while (!QLog.isDevelopLevel());
    NearbyUtils.a("PttShow", "onUpdatePttHotChatSeatsInfo", new Object[] { "hide audio panel" });
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */