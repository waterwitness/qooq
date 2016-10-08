package com.tencent.mobileqq.nearby;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class NearbySPUtil
{
  public static final String A = "self_age";
  public static final String B = "self_nick";
  public static final String C = "self_school_name";
  public static final String D = "temp_school_name";
  public static final String E = "temp_validate";
  public static final String F = "sp_key_user_skip_guide";
  public static final String G = "nearby_people_disclaimer_ok_5.8.0";
  public static final String H = "nearby_people_avatar_upload_ok";
  public static final String I = "NEW_FRESH_SP";
  public static final String J = "last_exit_newfreshtab_time";
  public static final String K = "sp_nearby_mytab";
  public static final String L = "key_nearby_mytab_zan_check";
  public static final String M = "key_nearby_push_signin_redtouch";
  public static final String N = "sp_nearby_total_visitor";
  public static final String O = "sp_nearby_new_visitor";
  public static final String P = "sp_nearby_his_visitor";
  public static final String Q = "key_rn_ask_loadso_lasttime";
  public static final String R = "key_rn_ask_loadso_lastcount";
  public static final String S = "key_rn_ask_loadso_totalcount";
  public static final String T = "key_rn_soready_reported";
  public static final String U = "nearby_event_file";
  public static final String V = "nearby_visitor_file";
  public static final String W = "config_show_rank";
  public static final String X = "config_show_date";
  public static final String Y = "unread_count_freshnews";
  public static final String Z = "unread_count_rank";
  public static final int a = 2;
  static final String a = NearbySPUtil.class.getSimpleName();
  public static final String aa = "unread_count_date";
  public static final String ab = "dating_last_event_id";
  public static final String ac = "dating_read_event_id";
  public static final String ad = "rank_last_event_seq";
  public static final String ae = "rank_read_event_seq";
  public static final String af = "freshfeed_last_event_seq";
  public static final String ag = "freshfeed_red_event_seq";
  public static final String ah = "nearby_process_preload_file";
  public static final String ai = "key_preload_fail_count";
  public static final String aj = "key_preload_unhit_count";
  public static final int b = 2;
  static final String b = "NEARBY_FLAG_SP";
  public static final String c = "nearby_sp_upgrade_flag";
  public static final String d = "ShowFreshNews";
  public static final String e = "hotchat_tab_switch";
  public static final String f = "supportHotChatDemo";
  public static final String g = "nearby_troop_title";
  public static final String h = "nearby_enter_time";
  public static final String i = "nearby_need_show_guide";
  public static final String j = "is_nearby_novice";
  public static final String k = "history_valid";
  public static final String l = "toplist_hide_boygod_seq";
  public static final String m = "key_last_config_time";
  public static final String n = "key_config_ver";
  public static final String o = "key_expired_banner";
  public static final String p = "qq_avatar_type";
  public static final String q = "vote_count";
  public static final String r = "vote_increment";
  public static final String s = "key_notify_switch_state";
  public static final String t = "current_city";
  public static final String u = "hometown_code";
  public static final String v = "current_city_code";
  public static final String w = "current_hometown_code";
  public static final String x = "self_tinnyid";
  public static final String y = "self_god_flag";
  public static final String z = "self_gender";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    return ((Integer)a(paramString1, "nearby_event_file", 4, paramString2, Integer.valueOf(0))).intValue();
  }
  
  public static SharedPreferences a(String paramString1, String paramString2, int paramInt)
  {
    return BaseApplicationImpl.a().getSharedPreferences(paramString1 + paramString2, paramInt);
  }
  
  public static Object a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    Object localObject3;
    if ((paramSharedPreferences == null) || (TextUtils.isEmpty(paramString)) || (paramObject == null))
    {
      localObject3 = paramObject;
      return localObject3;
    }
    for (;;)
    {
      try
      {
        if (paramObject.getClass() != Boolean.class) {
          continue;
        }
        boolean bool = paramSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue());
        localObject1 = Boolean.valueOf(bool);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        NearbyUtils.a("getValue", new Object[] { localThrowable });
        Object localObject2 = paramObject;
        continue;
      }
      localObject3 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      NearbyUtils.a("getValue", new Object[] { paramSharedPreferences, paramString, paramObject, localObject1, paramObject.getClass() });
      return localObject1;
      if (paramObject.getClass() == Integer.class) {
        localObject1 = Integer.valueOf(paramSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
      } else if (paramObject.getClass() == Long.class) {
        localObject1 = Long.valueOf(paramSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
      } else if (paramObject.getClass() == Float.class) {
        localObject1 = Float.valueOf(paramSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue()));
      } else if (paramObject.getClass() == String.class) {
        localObject1 = paramSharedPreferences.getString(paramString, (String)paramObject);
      } else {
        localObject1 = paramObject;
      }
    }
  }
  
  public static Object a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.isEmpty(paramString3)) || (paramObject == null) || (!a(paramInt))) {
      paramString2 = (String)paramObject;
    }
    for (;;)
    {
      return paramString2;
      String str1 = paramString1;
      if (paramString1 == null) {
        str1 = "";
      }
      String str2 = paramString2;
      if (paramString2 == null) {
        str2 = "";
      }
      try
      {
        paramString1 = a(a(str2, str1, paramInt), paramString3, paramObject);
        paramString2 = paramString1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        NearbyUtils.a("getValue", new Object[] { str1, str2, paramString3, paramObject, paramString1, paramObject.getClass() });
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            NearbyUtils.a("getValue", new Object[] { paramString1 });
          }
          paramString1 = (String)paramObject;
        }
      }
    }
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramObject;
    }
    return a(paramString1, "NEARBY_FLAG_SP", 4, paramString2, paramObject);
  }
  
  public static void a(String paramString)
  {
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i1 = paramString.getInt("key_preload_fail_count", 0) + 1;
      paramString.edit().putInt("key_preload_fail_count", i1).commit();
      if (QLog.isColorLevel()) {
        NearbyUtils.a("preloadNearbyprocessStart", new Object[] { "key_preload_fail_count", Integer.valueOf(i1) });
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a(paramString, "key_notify_switch_state", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    boolean bool2;
    if ((paramSharedPreferences == null) || (TextUtils.isEmpty(paramString)) || (paramObject == null)) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      try
      {
        SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
        if (paramObject.getClass() == Boolean.class) {
          localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        }
        for (;;)
        {
          bool1 = localEditor.commit();
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          NearbyUtils.a("setValue", new Object[] { paramSharedPreferences, paramString, paramObject, Boolean.valueOf(bool1), paramObject.getClass() });
          return bool1;
          if (paramObject.getClass() != Integer.class) {
            break label165;
          }
          localEditor.putInt(paramString, ((Integer)paramObject).intValue());
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            NearbyUtils.a("setValue", new Object[] { localThrowable });
          }
          boolean bool1 = false;
          continue;
          label165:
          if (paramObject.getClass() == Long.class) {
            localThrowable.putLong(paramString, ((Long)paramObject).longValue());
          } else if (paramObject.getClass() == Float.class) {
            localThrowable.putFloat(paramString, ((Float)paramObject).floatValue());
          } else if (paramObject.getClass() == String.class) {
            localThrowable.putString(paramString, (String)paramObject);
          }
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return ((Boolean)a(paramString, BaseApplicationImpl.a().getResources().getString(2131367837), Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      bool = a("NEARBY_FLAG_SP", paramString, 4).edit().putLong("vote_count", paramLong).putInt("vote_increment", paramInt).commit();
      if (QLog.isColorLevel()) {
        NearbyUtils.a("setVoteInfo", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("setVoteInfo", new Object[] { localThrowable });
        }
        boolean bool = false;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return a(paramString1, "NEARBY_FLAG_SP", 4, paramString2);
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool2;
    if (((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.isEmpty(paramString3)) || (!a(paramInt))) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      try
      {
        bool1 = a(paramString1, str, paramInt).contains(paramString3);
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        NearbyUtils.a("contains", new Object[] { str, paramString1, paramString3 });
        return bool1;
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            NearbyUtils.a("contains", new Object[] { paramString2 });
          }
          boolean bool1 = false;
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    boolean bool2;
    if (((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.isEmpty(paramString3)) || (paramObject == null) || (!a(paramInt))) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      try
      {
        bool1 = a(a(paramString1, str, paramInt), paramString3, paramObject);
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        NearbyUtils.a("setValue", new Object[] { str, paramString3, paramObject, Boolean.valueOf(bool1), paramObject.getClass() });
        return bool1;
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            NearbyUtils.a("setValue", new Object[] { paramString1 });
          }
          boolean bool1 = false;
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return a(paramString1, "NEARBY_FLAG_SP", 4, paramString2, paramObject);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a(paramString, BaseApplicationImpl.a().getResources().getString(2131367837), Boolean.valueOf(paramBoolean));
  }
  
  public static Object[] a(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      SharedPreferences localSharedPreferences = a("NEARBY_FLAG_SP", paramString, 4);
      l1 = l2;
      l2 = localSharedPreferences.getLong("vote_count", Long.valueOf(0L).longValue());
      l1 = l2;
      i1 = localSharedPreferences.getInt("vote_increment", Integer.valueOf(0).intValue());
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("getVoteInfo", new Object[] { localThrowable });
        }
        int i1 = 0;
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("getVoteInfo", new Object[] { paramString, Long.valueOf(l1), Integer.valueOf(i1) });
    }
    return new Object[] { Long.valueOf(l1), Integer.valueOf(i1) };
  }
  
  public static void b(String paramString)
  {
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i1 = paramString.getInt("key_preload_unhit_count", 0) + 1;
      paramString.edit().putInt("key_preload_fail_count", 0).putInt("key_preload_unhit_count", i1).commit();
      if (QLog.isColorLevel()) {
        NearbyUtils.a("preloadNearbyProcessSuc", new Object[] { "key_preload_unhit_count", Integer.valueOf(i1) });
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      bool = ((Boolean)a(paramString, BaseApplicationImpl.a().getResources().getString(2131367838), Boolean.valueOf(false))).booleanValue();
      if (QLog.isColorLevel()) {
        NearbyUtils.a("getLocVisiblityForPeople", new Object[] { paramString, Boolean.valueOf(bool) });
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("getLocVisiblityForPeople", new Object[] { localThrowable });
        }
        boolean bool = false;
      }
    }
  }
  
  public static boolean b(String paramString, boolean paramBoolean)
  {
    try
    {
      String str = BaseApplicationImpl.a().getResources().getString(2131367838);
      SharedPreferences.Editor localEditor = a("NEARBY_FLAG_SP", paramString, 4).edit();
      localEditor.putBoolean(str, paramBoolean);
      if (!paramBoolean) {
        localEditor.putLong("nearby_enter_time", 0L).commit();
      }
      bool = localEditor.commit();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("setVisibilityForPeople", new Object[] { localThrowable });
        }
        boolean bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("setVisibilityForPeople", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static void c(String paramString)
  {
    try
    {
      a("nearby_process_preload_file", paramString, 4).edit().putInt("key_preload_fail_count", 0).putInt("key_preload_unhit_count", 0).commit();
      if (QLog.isColorLevel()) {
        NearbyUtils.a("enterNearbyProcess", new Object[0]);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean c(String paramString)
  {
    return ((Boolean)a(paramString, "key_notify_switch_state", Boolean.valueOf(true))).booleanValue();
  }
  
  public static boolean d(String paramString)
  {
    return ((Boolean)a(paramString, "dating_recv_msg", Boolean.valueOf(true))).booleanValue();
  }
  
  public static boolean e(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i1 = paramString.getInt("key_preload_fail_count", 0);
      int i2 = paramString.getInt("key_preload_unhit_count", 0);
      bool1 = bool2;
      if (i1 < 2)
      {
        bool1 = bool2;
        if (i2 < 2) {
          bool1 = true;
        }
      }
      paramString.printStackTrace();
    }
    catch (Throwable paramString)
    {
      try
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("checkPreload", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
        }
        return bool1;
      }
      catch (Throwable paramString)
      {
        boolean bool1;
        for (;;) {}
      }
      paramString = paramString;
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = ((Boolean)a(paramString, "nearby_need_show_guide", Boolean.valueOf(false))).booleanValue();
    boolean bool3 = ((Boolean)a(paramString, "sp_key_user_skip_guide", Boolean.valueOf(false))).booleanValue();
    if ((true == bool2) && (!bool3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("isNeedNearbyShowGuide", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      }
      return bool1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbySPUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */