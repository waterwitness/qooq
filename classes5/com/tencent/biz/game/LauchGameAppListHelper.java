package com.tencent.biz.game;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class LauchGameAppListHelper
{
  public static final int a = -1;
  public static final String a = "http://youxi.vip.qq.com/imoj/applist.html";
  public static final int b = 100548090;
  public static final String b = "sessionInfo";
  public static final int c = 100548087;
  public static final String c = "indexOfFunnyFaceClickedInWebview";
  
  public LauchGameAppListHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
    String str = paramSessionInfo.b;
    Object localObject2 = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    int i;
    int n;
    label91:
    int j;
    label100:
    int k;
    int m;
    if (localObject2 != null)
    {
      if (((GameCenterManagerImp)localObject2).a("999999.100004") != -1)
      {
        i = 1;
        n = i;
        switch (paramSessionInfo.jdField_a_of_type_Int)
        {
        default: 
          i = 1;
          if (i == 3) {
            j = 2;
          }
          break;
        }
      }
      for (;;)
      {
        if (paramSessionInfo.jdField_a_of_type_Int == 1) {}
        try
        {
          localObject2 = paramQQAppInterface.a();
          if (localObject2 == null) {
            break label589;
          }
          localObject2 = ((EntityManagerFactory)localObject2).createEntityManager().a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { localObject1 }, null, null, null, null);
          if (localObject2 == null) {
            break label290;
          }
          localObject2 = ((List)localObject2).iterator();
          k = 0;
          for (;;)
          {
            m = k;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            boolean bool = ChatActivityUtils.a((TroopMemberInfo)((Iterator)localObject2).next());
            if (!bool) {
              break label586;
            }
            k += 1;
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("LauchGameAppListHelper", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
            }
          }
        }
        catch (IllegalStateException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("LauchGameAppListHelper", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
              continue;
              k = 0;
              continue;
              continue;
              k = 0;
            }
          }
          j = 0;
        }
        i = 0;
        break;
        i = 1;
        break label91;
        i = 2;
        break label91;
        i = 3;
        break label91;
        if (i == 1)
        {
          localObject2 = ((TroopManager)paramQQAppInterface.getManager(51)).a((String)localObject1);
          if (localObject2 == null) {
            break label601;
          }
          j = ((TroopInfo)localObject2).wMemberNum;
        }
        else
        {
          label263:
          if (i != 2) {
            break label595;
          }
          j = ((DiscussionManager)paramQQAppInterface.getManager(52)).a((String)localObject1);
          continue;
          label290:
          m = 0;
          if ((j <= 1) || (m >= 6) || (m >= j)) {
            break label613;
          }
          paramQQAppInterface = (TroopHandler)paramQQAppInterface.a(20);
          if (paramQQAppInterface == null) {
            break label613;
          }
          paramQQAppInterface.a(Long.parseLong((String)localObject1));
          break label613;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LauchGameAppListHelper", 2, "localNum=" + k);
      }
      if (n != 0)
      {
        k = 1;
        paramQQAppInterface = "http://youxi.vip.qq.com/imoj/applist.html?sessionType=" + i + "&sessionId=" + (String)localObject1 + "&adtag=" + "client_entry" + "&personNum=" + j + "&gcode=" + str + "&isNew=" + k;
        localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramQQAppInterface);
        ((Intent)localObject1).putExtra("sessionInfo", paramSessionInfo);
        ((Intent)localObject1).putExtra("needSkey", "true");
        ((Intent)localObject1).putExtra("hide_more_button", true);
        ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject1).putExtra("hide_left_button", true);
        ((Intent)localObject1).putExtra("show_right_close_button", true);
        ((Intent)localObject1).putExtra("finish_animation_up_down", true);
        paramActivity.startActivity((Intent)localObject1);
        paramActivity.overridePendingTransition(2130968585, 0);
        return;
      }
      label586:
      label589:
      label595:
      break label100;
      label601:
      j = 0;
      break label263;
      n = 0;
      break;
      label613:
      k = m;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\game\LauchGameAppListHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */