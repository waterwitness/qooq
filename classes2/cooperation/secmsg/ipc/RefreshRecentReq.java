package cooperation.secmsg.ipc;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class RefreshRecentReq
  extends BaseReq
{
  public static final String a = "RefreshRecentReq_command";
  public static final String b = "RefreshRecentReq_showSecMsg";
  public static final String c = "RefreshRecentReq_msgTime";
  public static final int d = 1;
  public static final String d = "RefreshRecentReq_msgType";
  public static final int e = 2;
  private static final String e = RefreshRecentReq.class.getName();
  public long a;
  public boolean a;
  public long b;
  public int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RefreshRecentReq()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(e, 2, "refresh recent");
      }
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    } while (paramQQAppInterface == null);
    if (paramBoolean)
    {
      Message localMessage = paramQQAppInterface.obtainMessage(1009);
      localMessage.obj = "Secmsg";
      paramQQAppInterface.sendMessage(localMessage);
      return;
    }
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(e, 2, "add secmsg to ru show=" + this.jdField_a_of_type_Boolean + ", msgTime=" + this.jdField_a_of_type_Long);
      }
      localRecentUserProxy = paramQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.a(AppConstants.aF, 9001);
    } while (localRecentUser == null);
    if (this.jdField_a_of_type_Boolean)
    {
      localRecentUser.uin = AppConstants.aF;
      localRecentUser.type = 9001;
      if (localRecentUser.lastmsgtime < this.jdField_a_of_type_Long) {
        localRecentUser.lastmsgtime = this.jdField_a_of_type_Long;
      }
      localRecentUserProxy.a(localRecentUser);
    }
    for (;;)
    {
      a(paramQQAppInterface, false);
      return true;
      localRecentUserProxy.b(localRecentUser);
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("RefreshRecentReq_command", this.f);
    paramBundle.putBoolean("RefreshRecentReq_showSecMsg", this.jdField_a_of_type_Boolean);
    paramBundle.putLong("RefreshRecentReq_msgTime", this.jdField_a_of_type_Long);
    paramBundle.putLong("RefreshRecentReq_msgType", this.b);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    switch (this.f)
    {
    default: 
      return;
    case 2: 
      a(paramQQAppInterface);
      return;
    }
    a(paramQQAppInterface, true);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.f = paramBundle.getInt("RefreshRecentReq_command");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("RefreshRecentReq_showSecMsg", true);
    this.jdField_a_of_type_Long = paramBundle.getLong("RefreshRecentReq_msgTime");
    this.b = paramBundle.getLong("RefreshRecentReq_msgType");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\ipc\RefreshRecentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */