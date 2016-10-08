package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class SystemMessageHelper
{
  public static final String a = "SystemMessageHelper";
  
  public SystemMessageHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Verify_msg", "Verify_msg_prof", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageHelper", 2, "openProfileCard | sourceId = " + paramInt2);
    }
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
    if (paramQQAppInterface != null) {}
    for (boolean bool = paramQQAppInterface.b(paramString);; bool = false)
    {
      if (bool) {
        ProfileActivity.b(paramContext, new ProfileActivity.AllInOne(paramString, 1));
      }
      for (;;)
      {
        return true;
        switch (paramInt1)
        {
        default: 
          if ((paramInt2 != 3007) && (paramInt2 != 3019) && (paramInt2 != 2007) && (paramInt2 != 4007) && (paramInt2 != 2019)) {
            break label667;
          }
          paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 25);
          if ((paramInt2 != 3007) && (paramInt2 != 2007) && (paramInt2 != 4007)) {
            break;
          }
        }
        for (paramQQAppInterface.g = 14;; paramQQAppInterface.g = 15) {
          do
          {
            paramString = new Bundle();
            paramString.putInt("param_mode", 3);
            paramString.putParcelable("sysInfoExtres", paramIntent);
            NearbyPeopleProfileActivity.a(paramContext, paramQQAppInterface, paramString);
            break;
            if ((paramInt2 == 3007) || (paramInt2 == 3019) || (paramInt2 == 2007) || (paramInt2 == 2019) || (paramInt2 == 4007))
            {
              paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 28);
              if ((paramInt2 == 3007) || (paramInt2 == 2007) || (paramInt2 == 4007)) {}
              for (paramQQAppInterface.g = 14;; paramQQAppInterface.g = 15) {
                do
                {
                  paramString = new Bundle();
                  paramString.putInt("param_mode", 3);
                  paramString.putParcelable("sysInfoExtres", paramIntent);
                  NearbyPeopleProfileActivity.a(paramContext, paramQQAppInterface, paramString);
                  break;
                } while ((paramInt2 != 3019) && (paramInt2 != 2019));
              }
            }
            paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 28);
            paramQQAppInterface.h = paramInt2;
            paramQQAppInterface.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
            paramString = new Bundle();
            paramString.putParcelable("sysInfoExtres", paramIntent);
            ProfileActivity.a(paramContext, paramQQAppInterface, paramString);
            break;
            if ((paramInt2 == 3007) || (paramInt2 == 3019) || (paramInt2 == 2007) || (paramInt2 == 4007) || (paramInt2 == 2019))
            {
              paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 25);
              if ((paramInt2 == 3007) || (paramInt2 == 2007) || (paramInt2 == 4007)) {}
              for (paramQQAppInterface.g = 14;; paramQQAppInterface.g = 15) {
                do
                {
                  paramString = new Bundle();
                  paramString.putInt("param_mode", 3);
                  paramString.putParcelable("sysInfoExtres", paramIntent);
                  NearbyPeopleProfileActivity.a(paramContext, paramQQAppInterface, paramString);
                  break;
                } while ((paramInt2 != 3019) && (paramInt2 != 2019));
              }
            }
            paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 25);
            paramQQAppInterface.h = paramInt2;
            paramQQAppInterface.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
            paramQQAppInterface.jdField_d_of_type_Int = 1;
            paramString = new Bundle();
            paramString.putParcelable("sysInfoExtres", paramIntent);
            ProfileActivity.a(paramContext, paramQQAppInterface, paramString);
            break;
          } while ((paramInt2 != 3019) && (paramInt2 != 2019));
        }
        label667:
        paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 25);
        paramQQAppInterface.jdField_d_of_type_Int = 1;
        if (paramInt1 == 6) {
          paramQQAppInterface.jdField_d_of_type_Int = 0;
        }
        paramString = new Bundle();
        paramString.putParcelable("sysInfoExtres", paramIntent);
        ProfileActivity.a(paramContext, paramQQAppInterface, paramString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\SystemMessageHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */