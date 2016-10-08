package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetClubContentUpdateStatus
  extends AsyncStep
{
  public GetClubContentUpdateStatus()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    ClubContentJsonTask.b(this.a.b);
    ClubContentJsonTask.a(this.a.b);
    Object localObject = this.a.b.a().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject).getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() < l))
    {
      ClubContentUpdateHandler localClubContentUpdateHandler = (ClubContentUpdateHandler)this.a.b.a(16);
      if (localClubContentUpdateHandler != null)
      {
        localClubContentUpdateHandler.a();
        ((SharedPreferences)localObject).edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      localObject = (ThemeHandler)this.a.b.a(14);
      ((ThemeHandler)localObject).a(((ThemeHandler)localObject).a, ((ThemeHandler)localObject).d, "206", 1);
      AioVipKeywordHelper.a().a(this.a.b.getApplication(), this.a.b.a());
      localObject = (IndividuationABTestManager)this.a.b.getManager(176);
      if (!((IndividuationABTestManager)localObject).b) {
        ((IndividuationABTestManager)localObject).a(this.a.b.a());
      }
      ApolloManager.b = this.a.b.a();
      ApolloEngine.a();
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (ApolloManager.a(this.a.b.a())) {
        ((ApolloManager)this.a.b.getManager(152)).a(false, "login check file");
      } else if (FileUtil.a(ApolloUtil.c)) {
        ApolloManager.a(this.a.b);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetClubContentUpdateStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */