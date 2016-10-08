package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import cooperation.qqhotspot.QQHotSpotHelper.ConversationShowApinfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.WifiConversationManager;

public class RecentItemWifiHotSpot
  extends RecentUserBaseData
{
  public RecentItemWifiHotSpot(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.jdField_b_of_type_Long = this.a.lastmsgtime;
    this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = paramContext.getResources().getString(2131366368);
    }
    this.J = paramContext.getResources().getColor(2131428302);
    paramQQAppInterface = WifiConversationManager.a().a();
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface.mStatus == 0) || (paramQQAppInterface.mStatus == 1))
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131366398);
        return;
      }
      if ((paramQQAppInterface.mStatus == 2) && (paramQQAppInterface.mApInfo != null) && (!TextUtils.isEmpty(paramQQAppInterface.mApInfo.mApInfo.StoreName)))
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131366399, new Object[] { paramQQAppInterface.mApInfo.mApInfo.StoreName });
        return;
      }
      if ((paramQQAppInterface.mStatus == 3) && (paramQQAppInterface.mApInfo != null) && (!TextUtils.isEmpty(paramQQAppInterface.mApInfo.mApInfo.StoreName)))
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131366400, new Object[] { paramQQAppInterface.mApInfo.mApInfo.StoreName });
        return;
      }
      this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131366398);
      return;
    }
    this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131366398);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemWifiHotSpot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */