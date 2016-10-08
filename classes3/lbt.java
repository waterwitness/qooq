import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.UpgradeTipsDialog;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class lbt
  implements Handler.Callback
{
  public lbt(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 2;
    int j = 0;
    if (paramMessage.what == 11340004) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(9, 0);
    }
    if ((paramMessage.what != 1134022) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {
      return true;
    }
    long l;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1025: 
      Conversation.a(this.a);
      return true;
    case 1009: 
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent list, from_handle");
      }
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)) && (((String)paramMessage.obj).equals("Secmsg"))) {
        ((SecMsgManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).c();
      }
      this.a.a(0L);
      return true;
    case 10001: 
    case 10002: 
      this.a.a(paramMessage, true);
      return true;
    case 1010: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a())
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, 2);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, paramMessage);
        return true;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, null);
      return true;
    case 1023: 
      ThreadManager.b().post(new lbu(this));
      return true;
    case 11340003: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(9, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(9, paramMessage);
      return true;
    case 1134018: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(11, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(9, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(11, paramMessage);
      return true;
    case 1134019: 
      if (Conversation.a(this.a) != null) {}
      try
      {
        Conversation.a(this.a).dismiss();
        Conversation.a(this.a, null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException = localException;
          Conversation.a(this.a, null);
        }
      }
      finally
      {
        paramMessage = finally;
        Conversation.a(this.a, null);
        throw paramMessage;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(11, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(11, paramMessage);
      return true;
    case 1134020: 
      Conversation.a(this.a, paramMessage);
      return true;
    case 11340004: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(9, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(9, paramMessage);
      return true;
    case 1134010: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(20, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(20, paramMessage);
      return true;
    case 1134011: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(20, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(20, paramMessage);
      return true;
    case 1134027: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134028)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134028);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(21, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(21, paramMessage);
      return true;
    case 1134028: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(21, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(21, paramMessage);
      return true;
    case 1134039: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134040)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134040);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(22, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(22, paramMessage);
      return true;
    case 1134040: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(22, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(22, paramMessage);
      return true;
    case 1134041: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134042)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134042);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(23, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(23, paramMessage);
      return true;
    case 1134042: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(23, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(23, paramMessage);
      return true;
    case 1134021: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5, paramMessage);
      return true;
    case 1134022: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5, paramMessage);
      return true;
    case 1134024: 
      i = paramMessage.arg1;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(6, i);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(6, paramMessage);
      return true;
    case 1134015: 
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE_NOT_LOADING");
      }
      this.a.a(paramMessage, false);
      return true;
    case 1134012: 
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE");
      }
      this.a.a(paramMessage, true);
      return true;
    case 1134013: 
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_OPEN");
      }
      this.a.a(paramMessage, true);
      return true;
    case 1134014: 
      this.a.a(null, true);
      return true;
    case 11340006: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, paramMessage);
      return true;
    case 11340007: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(16, paramMessage);
      return true;
    case 1032: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(17, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(17, paramMessage);
      return true;
    case 1033: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(17, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(17, paramMessage);
      return true;
    case 1040: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(4, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(4, paramMessage);
      return true;
    case 1041: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(4, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(4, paramMessage);
      return true;
    case 1014: 
      this.a.a(0L);
      return true;
    case 1016: 
      this.a.f = false;
      if (Conversation.a(this.a) != null) {
        Conversation.a(this.a).H();
      }
      if (Conversation.a(this.a) > 0L) {
        StartupTracker.a("Conversation_PullToRefresh_finish", SystemClock.uptimeMillis() - Conversation.a(this.a));
      }
      Conversation.a(this.a, 0L);
      return true;
    case 1017: 
      this.a.a(0L);
      return true;
    case 1020: 
      if (paramMessage.arg1 == 0)
      {
        ThreadManager.b().post(new lbw(this));
        paramMessage = Message.obtain();
        paramMessage.what = 1020;
        paramMessage.arg1 = 1;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, 20000L);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "infalter time out, need do in UI thread ");
      }
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1020);
      this.a.n();
      return true;
    case 10000: 
      l = Math.abs(System.currentTimeMillis() - Conversation.b(this.a));
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "MSG_REFRESH_UI, [" + paramMessage.arg1 + "," + l + "]");
      }
      if (l < 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "distance < 0[" + l + "," + Conversation.b(this.a) + "]");
        }
        l = this.a.b + 1L;
      }
      break;
    }
    for (;;)
    {
      Object localObject = (List)paramMessage.obj;
      if ((paramMessage.arg2 != 1) && (l < this.a.b))
      {
        this.a.jdField_a_of_type_JavaUtilList = ((List)localObject);
        paramMessage = Message.obtain();
        paramMessage.what = 10000;
        paramMessage.obj = this.a.jdField_a_of_type_JavaUtilList;
        paramMessage.arg1 = 0;
        paramMessage.arg2 = 1;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, this.a.b - l + 50L);
        return true;
      }
      if (paramMessage.arg2 == 1) {
        if (localObject == this.a.jdField_a_of_type_JavaUtilList) {
          i = 1;
        }
      }
      while (i != 0)
      {
        this.a.a(0, this.a.jdField_a_of_type_JavaUtilList);
        Conversation.b(this.a, System.currentTimeMillis());
        return true;
        i = 0;
        continue;
        this.a.jdField_a_of_type_JavaUtilList = ((List)localObject);
        i = 1;
      }
      paramMessage = (List)paramMessage.obj;
      this.a.a(1, paramMessage);
      return true;
      if (Conversation.a(this.a) == null) {
        break;
      }
      Conversation.a(this.a).a(paramMessage);
      return true;
      if (Conversation.a(this.a) == null) {
        break;
      }
      Conversation.a(this.a).i();
      return true;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0);
      return true;
      Conversation.b(this.a);
      return true;
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      i = j;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != 0) {
        i = 2;
      }
      ((BannerManager)localObject).a(25, i);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(25, paramMessage);
      return true;
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      if (FileViewMusicService.a().a()) {}
      for (;;)
      {
        ((BannerManager)localObject).a(26, i);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(26, paramMessage);
        return true;
        i = 0;
      }
      this.a.t();
      return true;
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      l = paramMessage.getLong("sp_vip_info_request_time", 0L);
      i = paramMessage.getInt("sp_vip_info_update_freq", 10);
      if (NetConnInfoCenter.getServerTime() - l <= i * 60) {
        break;
      }
      ThreadManager.b().post(new lby(this));
      return true;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(19, 2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(19, paramMessage);
      return true;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(19, 0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(19, paramMessage);
      return true;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(3, paramMessage.arg1);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(3, paramMessage);
      return true;
      if (Conversation.a(this.a) == null) {
        break;
      }
      Conversation.a(this.a).a();
      return true;
      if (Conversation.a(this.a) == null) {
        break;
      }
      Conversation.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), this.a.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      if (Conversation.a(this.a) == null) {
        break;
      }
      if (paramMessage.arg1 == 1) {}
      for (i = 1; i != 0; i = 0)
      {
        paramMessage = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramMessage.red_type.set(0);
        Conversation.a(this.a).a(paramMessage);
        return true;
      }
      Conversation.a(this.a).a(new BusinessInfoCheckUpdate.AppInfo());
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */