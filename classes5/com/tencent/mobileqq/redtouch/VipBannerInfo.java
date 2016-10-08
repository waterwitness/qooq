package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;
import ufi;
import ufj;

public class VipBannerInfo
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public long a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  
  public VipBannerInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    ThreadManager.a().post(new ufi(paramContext));
  }
  
  public static void a(Conversation paramConversation)
  {
    if ((paramConversation == null) || (paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(18) != 0)) {}
    SharedPreferences localSharedPreferences;
    MqqHandler localMqqHandler;
    RedTouchManager localRedTouchManager;
    do
    {
      do
      {
        return;
        localSharedPreferences = paramConversation.a().getSharedPreferences("mobileQQ", 0);
        localMqqHandler = paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      } while (localMqqHandler == null);
      localRedTouchManager = (RedTouchManager)paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    } while (localRedTouchManager == null);
    ThreadManager.a().post(new ufj(localRedTouchManager, localSharedPreferences, paramConversation, localMqqHandler));
  }
  
  public static void b(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(18) != 0))
    {
      paramConversation = paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      if (paramConversation != null)
      {
        paramConversation.removeMessages(9);
        paramConversation.sendEmptyMessage(9);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\VipBannerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */