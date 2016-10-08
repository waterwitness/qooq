package com.tencent.mobileqq.nearby;

import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import thy;

public class NearbyProcessMonitor
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString;
  static PreloadProcHitSession[] jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession[3];
  static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static final int b = 1;
  public static final String b = "com.tencent.mobileqq:tool";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 3;
  static final int g = 10;
  public static int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyProcessMonitor.class.getSimpleName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "nearby_leba", "nearby_msgbox", "nearby_guide" };
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("preloadNearbyProcess", new Object[0]);
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), NearbyReceiver.class);
    localIntent.putExtra("nearby_preload_from", 1);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {
      try
      {
        if (jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt] == null) {
          jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt] = new PreloadProcHitSession(jdField_a_of_type_ArrayOfJavaLangString[paramInt], "com.tencent.mobileqq:tool");
        }
        for (;;)
        {
          jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt].a();
          return;
          jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt].d();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a(jdField_a_of_type_JavaLangString, "preloadHitSession", new Object[] { localThrowable.toString() });
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject5 = null;
    if (QLog.isColorLevel()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "dataUpgrade" });
    }
    if (((Boolean)NearbySPUtil.a(paramString, "nearby_sp_upgrade_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (;;)
    {
      return;
      try
      {
        localObject1 = BaseApplicationImpl.a().getAppRuntime(paramString);
      }
      catch (AccountNotMatchException localException1)
      {
        try
        {
          Object localObject1;
          if ((localObject1 instanceof QQAppInterface))
          {
            Object localObject2 = (QQAppInterface)localObject1;
            Object localObject4 = localObject1;
            localObject1 = localObject2;
            while (localObject1 != null)
            {
              if (!NearbySPUtil.a(paramString, "self_gender"))
              {
                localObject2 = ((FriendsManager)((QQAppInterface)localObject4).getManager(50)).a(paramString);
                if (localObject2 != null)
                {
                  localObject4 = (NearbyCardManager)((QQAppInterface)localObject1).getManager(105);
                  if (QLog.isColorLevel()) {
                    NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "gender", Short.valueOf(((Card)localObject2).shGender) });
                  }
                  if (localObject4 != null) {
                    ((NearbyCardManager)localObject4).b(((Card)localObject2).shGender);
                  }
                }
              }
              if (!NearbySPUtil.a(paramString, "hotchat_tab_switch")) {}
              try
              {
                i = ((QQAppInterface)localObject1).getPreferences().getInt("hotchat_tab_switch", 0);
                if (QLog.isColorLevel())
                {
                  localObject2 = jdField_a_of_type_JavaLangString;
                  if (i == 0)
                  {
                    bool = true;
                    NearbyUtils.a((String)localObject2, new Object[] { "hotchat_tab_swtich", Boolean.valueOf(bool) });
                  }
                }
                else
                {
                  if (i != 0) {
                    break label656;
                  }
                  bool = true;
                  NearbySPUtil.a(paramString, "hotchat_tab_switch", Boolean.valueOf(bool));
                  if (NearbySPUtil.a(paramString, "supportHotChatDemo")) {}
                }
              }
              catch (Exception localException1)
              {
                try
                {
                  for (;;)
                  {
                    i = ((QQAppInterface)localObject1).getPreferences().getInt("supportHotChatDemo", 0);
                    if (QLog.isColorLevel())
                    {
                      localObject2 = jdField_a_of_type_JavaLangString;
                      if (i != 1) {
                        break label673;
                      }
                      bool = true;
                      NearbyUtils.a((String)localObject2, new Object[] { "hotchat_demo_switch", Boolean.valueOf(bool) });
                    }
                    if (i != 1) {
                      break label679;
                    }
                    bool = true;
                    NearbySPUtil.a(paramString, "supportHotChatDemo", Boolean.valueOf(bool));
                    if (!NearbySPUtil.a(paramString, "ShowFreshNews"))
                    {
                      bool = BaseApplicationImpl.a().getSharedPreferences("FRESHNEWS_SP", 0).getBoolean(paramString + "ShowFreshNews", true);
                      if (QLog.isColorLevel()) {
                        NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "freshnews_tab_switch", Boolean.valueOf(bool) });
                      }
                      NearbySPUtil.a(paramString, "ShowFreshNews", Boolean.valueOf(bool));
                    }
                    if (!NearbySPUtil.a(paramString, "nearby_enter_time"))
                    {
                      long l = BaseApplicationImpl.a().getSharedPreferences("sp_nearbyrecommender", 0).getLong(paramString + "_" + "key_enter_nearby_time", 0L);
                      if (QLog.isColorLevel()) {
                        NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "entry_time", Long.valueOf(l) });
                      }
                      NearbySPUtil.a(paramString, "nearby_enter_time", Long.valueOf(l));
                    }
                    if (!NearbySPUtil.a(paramString, "self_god_flag"))
                    {
                      bool = ((QQAppInterface)localObject1).a().getSharedPreferences("dating_pref" + paramString, 0).getBoolean("toplist_self_is_god", false);
                      if (QLog.isColorLevel()) {
                        NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "god", Boolean.valueOf(bool) });
                      }
                      NearbySPUtil.a(paramString, "self_god_flag", Boolean.valueOf(bool));
                    }
                    if (!NearbySPUtil.a(paramString, "nearby_people_disclaimer_ok_5.8.0")) {
                      NearbySPUtil.a(paramString, "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(((QQAppInterface)localObject1).getPreferences().getBoolean("nearby_people_disclaimer_ok_5.8.0", false)));
                    }
                    NearbySPUtil.a(paramString, "nearby_sp_upgrade_flag", Boolean.valueOf(true));
                    return;
                    localAccountNotMatchException1 = localAccountNotMatchException1;
                    localObject1 = null;
                    localAccountNotMatchException1.printStackTrace();
                    localObject4 = localObject1;
                    localObject1 = localObject5;
                    break;
                    localException1 = localException1;
                    i = 0;
                    continue;
                    bool = false;
                  }
                  label656:
                  bool = false;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    localException2.printStackTrace();
                    int i = 0;
                    continue;
                    label673:
                    boolean bool = false;
                    continue;
                    label679:
                    bool = false;
                  }
                }
              }
            }
          }
        }
        catch (AccountNotMatchException localAccountNotMatchException2)
        {
          for (;;)
          {
            continue;
            Object localObject3 = null;
          }
        }
      }
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("startNearbyProcess", new Object[] { Integer.valueOf(paramInt) });
    }
    a(paramInt);
    if (PreloadProcHitSession.a("com.tencent.mobileqq:tool")) {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyProcess is exist", new Object[0]);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt < 0) || (paramInt >= 3)) {
            break label143;
          }
          if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.disable_preload_nearby_process.name(), "0"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        NearbyUtils.a("dpc disable preload nearby process", new Object[0]);
        return;
      } while (!NearbySPUtil.e(paramString));
      if (h <= 10) {
        break;
      }
    } while (!QLog.isColorLevel());
    NearbyUtils.a("cation: preload  to much times, ", new Object[] { Integer.valueOf(h) });
    return;
    label143:
    ThreadManager.a(new thy(paramString), 10, null, false);
  }
  
  public static void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {}
    try
    {
      if (jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt] != null) {
        jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt].b();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "reportSessionHit", new Object[] { localThrowable.toString() });
    }
  }
  
  public static void b(String paramString)
  {
    if (!NearbySPUtil.a(paramString, "self_school_name")) {
      for (;;)
      {
        try
        {
          Object localObject1 = BaseApplicationImpl.a().getAppRuntime(paramString);
          if (!(localObject1 instanceof QQAppInterface)) {
            break label145;
          }
          localObject1 = ((QQAppInterface)localObject1).a().createEntityManager();
          localObject2 = (Card)((EntityManager)localObject1).a(Card.class, paramString);
          if (localObject2 != null)
          {
            localObject1 = ((Card)localObject2).strSchool;
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              NearbySPUtil.a(paramString, "self_school_name", localObject1);
              localObject2 = localObject1;
            }
            if (!NearbyUtils.b()) {
              break;
            }
            NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "checkSchoolName", localObject2 });
            return;
          }
          localObject1 = (NearbyPeopleCard)((EntityManager)localObject1).a(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
          if (localObject1 != null)
          {
            localObject1 = ((NearbyPeopleCard)localObject1).college;
            continue;
          }
          localObject1 = null;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          return;
        }
        continue;
        label145:
        Object localObject2 = null;
      }
    }
  }
  
  public static void b(String paramString, int paramInt)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(paramString, "actCheckHasUnreadMsg", bool, paramInt, 0L, null, "");
      return;
    }
  }
  
  public static void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {}
    try
    {
      if (jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt] != null) {
        jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt].d();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "reportSessionEnd", new Object[] { localThrowable.toString() });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyProcessMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */