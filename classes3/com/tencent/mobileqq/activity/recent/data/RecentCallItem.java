package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.UITools;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.C2BUtils;

public class RecentCallItem
  extends RecentBaseData
{
  public static final int P = 0;
  public static final int Q = 1;
  public static final int R = 2;
  public static final int S = 3;
  public static final int T = 4;
  public static final int U = 5;
  public static final int V = 6;
  public static final int W = 7;
  private static final String a;
  public long a;
  protected QCallRecent a;
  public boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = RecentCallItem.class.getSimpleName();
  }
  
  public RecentCallItem(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent == null) {
      throw new NullPointerException("call is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = paramQCallRecent;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallTime;
  }
  
  public QCallRecent a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      label20:
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
    Object localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(52);
    if (localObject1 == null) {
      localObject1 = null;
    }
    label57:
    int i;
    label284:
    label309:
    label469:
    label678:
    label718:
    int j;
    switch (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type)
    {
    default: 
      this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str, true);
    case 1008: 
    case 1006: 
    case 9502: 
    case 1021: 
      for (;;)
      {
        this.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallMsg;
        if (localObject1 == null) {
          break label2040;
        }
        i = ((Friends)localObject1).getNetWorkType();
        this.F = i;
        if (localObject1 == null) {
          break label2046;
        }
        this.N = ContactUtils.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType);
        if (QLog.isColorLevel()) {
          QLog.d("RecentCallItemBuilder", 2, "call.type = " + this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type + ", call.getState(app) = " + this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface) + ", displayName:" + this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.displayName);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type != 3000) {
          break label2112;
        }
        switch (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface))
        {
        case 5: 
        case 6: 
        case 7: 
        default: 
          if ((this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.time <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())) {
            break label2106;
          }
          i = 1;
          this.I = i;
          this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallTime;
          if ((this.jdField_b_of_type_Long == 0L) && (QLog.isColorLevel())) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "zsw RecentCallItem| mDisplayTime = " + this.jdField_b_of_type_Long);
          }
          if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_b_of_type_Long != 9223372036854775806L)) {
            this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type != 3000) {
            this.H = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.missedCallCount;
          }
          if (QLog.isDevelopLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 4, "update mAuthenIconId=" + this.I + ";mUnreadNum=" + this.H + ";mStatus=" + this.F);
          }
          i = this.K & 0xFFFF0FFF;
          if (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo()) {
            break label2304;
          }
          i |= 0x3000;
          this.K = i;
          localObject1 = (PstnManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(142);
          if ((localObject1 == null) || (((PstnManager)localObject1).a() != 1)) {
            break label2434;
          }
          i = 1;
          if ((this.I == 3) || (this.jdField_a_of_type_Long > 0L) || (this.I == 4) || (this.I == 5) || (this.I == 7))
          {
            j = paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin);
            if (j != 2) {
              break label2323;
            }
            if (i == 0) {
              break label2315;
            }
            i = 2131371104;
            this.f = paramContext.getString(i);
            this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo = 1;
            if (QLog.isDevelopLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 4, "update isVideo = " + this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo + "; state = " + this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.state + ", sessionType = " + j);
            }
          }
          if (!AppSetting.j) {
            break label20;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
          if ((!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isMissedCall()) || (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())) {
            break label2358;
          }
          paramQQAppInterface.append("未接");
          switch (this.F)
          {
          default: 
            paramQQAppInterface.append(".").append(this.jdField_c_of_type_JavaLangString);
            this.d = paramQQAppInterface.toString();
            return;
            localObject1 = ((FriendsManager)localObject1).c(str);
            break label57;
            localObject5 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
            localObject2 = localObject4;
            if (localObject5 != null) {
              localObject2 = ((PublicAccountDataManager)localObject5).b(str);
            }
            if (localObject2 != null)
            {
              this.jdField_b_of_type_JavaLangString = ((PublicAccountInfo)localObject2).name;
            }
            else
            {
              this.jdField_b_of_type_JavaLangString = C2BUtils.a(str);
              if (this.jdField_b_of_type_JavaLangString == null)
              {
                this.jdField_b_of_type_JavaLangString = str;
                continue;
                localObject4 = ContactUtils.f(paramQQAppInterface, str);
                localObject5 = (PhoneContactManager)paramQQAppInterface.getManager(10);
                if (localObject5 != null) {
                  localObject2 = ((PhoneContactManager)localObject5).c(str);
                }
                if (localObject2 != null)
                {
                  this.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject2).name;
                }
                else if (localObject4 != null)
                {
                  this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, (String)localObject4, true);
                }
                else
                {
                  this.jdField_b_of_type_JavaLangString = str;
                  continue;
                  if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.businessName != null)
                  {
                    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.businessName;
                  }
                  else
                  {
                    this.jdField_b_of_type_JavaLangString = str;
                    continue;
                    localObject2 = (CircleManager)paramQQAppInterface.getManager(34);
                    localObject4 = ((CircleManager)localObject2).a(str);
                    if ((localObject2 != null) && (localObject4 != null)) {
                      this.jdField_b_of_type_JavaLangString = ((CircleManager)localObject2).a((CircleBuddy)localObject4);
                    } else {
                      this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str, true);
                    }
                  }
                }
              }
            }
            break;
          }
          break;
        }
      }
    case 0: 
    case 8: 
    case 1000: 
    case 1001: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1009: 
    case 1020: 
    case 1022: 
    case 1023: 
    case 1024: 
    case 1025: 
      label791:
      label809:
      label925:
      label960:
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type == 8)
      {
        this.L = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.extraType;
        this.e = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.bindId;
        this.M = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.bindType;
        this.g = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.phoneNumber;
        if (this.L == 25)
        {
          localObject2 = (PhoneContactManager)paramQQAppInterface.getManager(10);
          if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.phoneNumber == null)) {
            break label2440;
          }
        }
      }
      break;
    }
    label1482:
    label1665:
    Object localObject3;
    label2040:
    label2046:
    label2106:
    label2112:
    label2304:
    label2315:
    label2323:
    label2358:
    label2434:
    label2440:
    for (localObject2 = ((PhoneContactManager)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.phoneNumber);; localObject3 = null)
    {
      if (localObject2 != null)
      {
        this.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject2).name;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "UNBINDQQ update contact = " + this.jdField_b_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (!AppConstants.aq.equals(str)) {
          break label1482;
        }
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131369140);
        break;
        localObject2 = ((QCallCardManager)paramQQAppInterface.getManager(139)).a(str);
        if (localObject2 == null) {
          ((QCallCardHandler)paramQQAppInterface.a(79)).a(str);
        } else if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
          this.jdField_b_of_type_JavaLangString = ((QCallCardInfo)localObject2).nickname;
        }
      }
      if (AppConstants.as.equals(str))
      {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131369138);
        break;
      }
      if (AppConstants.ar.equals(str))
      {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131368291);
        break;
      }
      if (AppConstants.ag.equals(str))
      {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131368299);
        break;
      }
      if (AppConstants.ao.equals(str))
      {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131369180);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type == 1000)
      {
        localObject2 = (TroopManager)paramQQAppInterface.getManager(51);
        if (localObject2 == null) {
          break;
        }
        this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, str, ((TroopManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.troopUin), this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.troopUin, true, null);
        break;
      }
      if (localObject1 != null) {
        if (!TextUtils.isEmpty(((Friends)localObject1).remark)) {
          localObject2 = ((Friends)localObject1).remark;
        }
      }
      for (this.jdField_b_of_type_JavaLangString = ((String)localObject2); (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_JavaLangString.equals(str)); this.jdField_b_of_type_JavaLangString = "")
      {
        this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str, true);
        break;
        localObject2 = ((Friends)localObject1).name;
        break label1665;
      }
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131364617);
      break;
      this.jdField_b_of_type_JavaLangString = ContactUtils.c(paramQQAppInterface, str);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localObject2 = localObject6;
        if (localDiscussionManager != null) {
          localObject2 = localDiscussionManager.a(str);
        }
        if (localObject2 != null) {}
      }
      try
      {
        ((DiscussionHandler)paramQQAppInterface.a(6)).a(Long.valueOf(str).longValue());
        this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramContext, (DiscussionInfo)localObject2);
        localObject4 = "";
        localObject2 = localObject4;
        if (localDiscussionManager != null)
        {
          i = localDiscussionManager.a(str);
          localObject2 = localObject4;
          if (i > 0) {
            localObject2 = "(" + i + ")";
          }
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
        try
        {
          this.jdField_a_of_type_Long = paramQQAppInterface.a().a(UITools.a(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type), Long.parseLong(str));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "discussionHandler exception:" + localException.getMessage());
          }
        }
      }
      PhoneContactManager localPhoneContactManager = (PhoneContactManager)paramQQAppInterface.getManager(10);
      localObject3 = localObject5;
      if (localPhoneContactManager != null) {
        localObject3 = localPhoneContactManager.b(str);
      }
      if (localObject3 != null)
      {
        this.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject3).name;
        break;
      }
      this.jdField_b_of_type_JavaLangString = str;
      break;
      this.jdField_b_of_type_JavaLangString = str;
      break;
      this.jdField_b_of_type_JavaLangString = OpenSDKUtils.a(paramQQAppInterface, str);
      break;
      i = 0;
      break label284;
      this.N = -1;
      break label309;
      i = 3;
      break label469;
      i = 0;
      break label469;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.time > 0L) && (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend()))
      {
        i = 1;
        break label469;
      }
      i = 2;
      break label469;
      i = 2;
      break label469;
      i = 2;
      break label469;
      i = paramQQAppInterface.a().a().jdField_b_of_type_Int;
      localObject1 = paramQQAppInterface.a().a().jdField_b_of_type_JavaLangString;
      if (((i == 1) || (i == 2)) && (((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin))) {
        i = 7;
      }
      while (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type == 1024)
      {
        i = CrmUtils.a(paramQQAppInterface, str);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface) == 5) {
          i = 4;
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface) == 6) {
          i = 5;
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface) == 7) {
          i = 6;
        } else if (((this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isMissedCall()) || (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isLastCallRealMissed)) && (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())) {
          i = 0;
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend()) {
          i = 2;
        } else {
          i = 1;
        }
      }
      i |= 0x4000;
      break label678;
      i = 2131371105;
      break label791;
      this.f = "";
      if (j == 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo = 1;
        break label809;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo = 0;
      break label809;
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())
      {
        paramQQAppInterface.append("已拨");
        break label925;
      }
      paramQQAppInterface.append("已接");
      break label925;
      paramQQAppInterface.append("WIFI网络");
      break label960;
      paramQQAppInterface.append("2G网络");
      break label960;
      paramQQAppInterface.append("3G网络");
      break label960;
      paramQQAppInterface.append("4G网络");
      break label960;
      i = 0;
      break label718;
    }
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if ((paramQCallRecent != null) && (paramQCallRecent.uin.equals(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin))) {
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = paramQCallRecent;
    }
  }
  
  public long b()
  {
    return 0L;
  }
  
  public boolean b()
  {
    return (this.jdField_c_of_type_Boolean) && (a() == 3000);
  }
  
  public int c()
  {
    return this.F;
  }
  
  public int d()
  {
    return this.F;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentCallItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */