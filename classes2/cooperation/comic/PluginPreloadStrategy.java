package cooperation.comic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.NumRedPointManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public abstract class PluginPreloadStrategy
{
  public static final String a = "ppp_profile";
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public int a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public PluginPreloadStrategy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 256;
  }
  
  private void a(PluginPreloader.ExtraResult paramExtraResult, String paramString)
  {
    if (paramExtraResult != null)
    {
      paramExtraResult.jdField_a_of_type_Int = 2;
      paramExtraResult.jdField_a_of_type_JavaLangString = paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloadStrategy", 2, "pluginType:" + this.jdField_b_of_type_Int + "  " + paramString);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (TroopRedTouchManager)paramQQAppInterface.getManager(69);
    int m;
    int k;
    if (localObject != null)
    {
      m = ((TroopRedTouchManager)localObject).a();
      k = ((TroopRedTouchManager)localObject).b();
    }
    for (;;)
    {
      localObject = (NumRedPointManager)paramQQAppInterface.getManager(63);
      if (localObject != null) {}
      for (int n = ((NumRedPointManager)localObject).a(0);; n = 0)
      {
        localObject = ((RedTouchManager)paramQQAppInterface.getManager(35)).a();
        if ((localObject != null) && (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 5)) {}
        for (int i1 = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get());; i1 = 0)
        {
          QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)paramQQAppInterface.getManager(9);
          int i3;
          int i2;
          if (localQZoneManagerImp != null)
          {
            i3 = localQZoneManagerImp.a(1);
            i2 = localQZoneManagerImp.a(2);
          }
          for (;;)
          {
            paramQQAppInterface = (ReadInJoyManager)paramQQAppInterface.getManager(95);
            int i;
            int j;
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface = paramQQAppInterface.a();
              if (paramQQAppInterface != null)
              {
                i = paramQQAppInterface.a();
                if ((paramQQAppInterface == null) || (!paramQQAppInterface.a())) {
                  break label183;
                }
                j = 1;
              }
            }
            for (;;)
            {
              label158:
              if (k + (i1 + i3) + n + i > 0) {}
              label183:
              while ((localObject != null) || (m > 0) || (i2 > 0) || (j != 0))
              {
                return true;
                i = 0;
                break;
                j = 0;
                break label158;
              }
              return false;
              j = 0;
              i = 0;
            }
            i2 = 0;
            i3 = 0;
          }
        }
      }
      k = 0;
      m = 0;
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return 3;
    }
    Object localObject1 = (TroopRedTouchManager)paramQQAppInterface.getManager(69);
    int m;
    if (localObject1 != null) {
      m = ((TroopRedTouchManager)localObject1).a();
    }
    for (int k = ((TroopRedTouchManager)localObject1).b();; k = 0)
    {
      localObject1 = (NumRedPointManager)paramQQAppInterface.getManager(63);
      if (localObject1 != null) {}
      for (int n = ((NumRedPointManager)localObject1).a(0);; n = 0)
      {
        Object localObject2 = (RedTouchManager)paramQQAppInterface.getManager(35);
        int i = 0;
        boolean bool1 = false;
        boolean bool2 = bool1;
        int j = i;
        int i1;
        BusinessInfoCheckUpdate.AppInfo localAppInfo;
        if (localObject2 != null)
        {
          localObject1 = ((RedTouchManager)localObject2).a(0);
          localObject2 = ((RedTouchManager)localObject2).b();
          bool2 = bool1;
          j = i;
          if (localObject1 != null)
          {
            bool2 = bool1;
            j = i;
            if (!((List)localObject1).isEmpty())
            {
              bool1 = false;
              i = 0;
              i1 = 0;
              if (i1 < ((List)localObject1).size())
              {
                localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i1);
                j = i;
                if (localAppInfo.mission_level.get() != 0) {
                  break label676;
                }
                j = i;
                if (localAppInfo.path.get().contains(".")) {
                  break label676;
                }
                if (localAppInfo.iNewFlag.get() == 1) {}
              }
            }
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          j = 0;
          for (;;)
          {
            if ((j >= ((List)localObject2).size()) || (localAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(j)).appid.get()))
            {
              if ((j >= ((List)localObject2).size()) || (((BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(j)).setting.get())) {
                break label308;
              }
              break;
            }
            j += 1;
          }
          label308:
          i += 1;
          j = i;
          if (paramString.equals(localAppInfo.path.get()))
          {
            bool1 = true;
            continue;
            j = i;
            bool2 = bool1;
            paramString = (QZoneManagerImp)paramQQAppInterface.getManager(9);
            int i2 = 0;
            i1 = 0;
            if (paramString != null)
            {
              i2 = paramString.a(1);
              i1 = paramString.a(2);
            }
            i = 0;
            bool1 = false;
            paramQQAppInterface = (ReadInJoyManager)paramQQAppInterface.getManager(95);
            label430:
            int i6;
            int i3;
            label451:
            int i4;
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface = paramQQAppInterface.a();
              if (paramQQAppInterface != null)
              {
                i = paramQQAppInterface.a();
                if ((paramQQAppInterface == null) || (!paramQQAppInterface.a())) {
                  break label636;
                }
                bool1 = true;
              }
            }
            else
            {
              i6 = i2 + k + n + i;
              if (m <= 0) {
                break label642;
              }
              i3 = 1;
              if (i1 <= 0) {
                break label648;
              }
              i4 = 1;
              label459:
              if (!bool1) {
                break label654;
              }
            }
            label636:
            label642:
            label648:
            label654:
            for (int i5 = 1;; i5 = 0)
            {
              i3 = i5 + (j + i3 + i4);
              if (QLog.isColorLevel()) {
                QLog.d("PluginPreloadStrategy", 2, "Troop redTouch: " + m + "; Troop num: " + k + "; Message num: " + n + "; Leba redTouch: " + j + "; Business has redTouch: " + bool2 + "; QZone msg count: " + i2 + "; QZone new count: " + i1 + "; ReadInJoy notify count: " + i + "; ReadInJoy need show notify: " + bool1 + "; Total redTouch: " + i3 + "; Total num: " + i6);
              }
              if (!bool2) {
                break label662;
              }
              if ((i6 != 0) || (i3 != 1)) {
                break label660;
              }
              return 4;
              i = 0;
              break;
              bool1 = false;
              break label430;
              i3 = 0;
              break label451;
              i4 = 0;
              break label459;
            }
            label660:
            return 1;
            label662:
            if ((i6 > 0) || (i3 > 0)) {
              return 2;
            }
            return 3;
          }
          else
          {
            label676:
            i = j;
          }
        }
      }
      m = 0;
    }
  }
  
  public abstract void a();
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((1 << Calendar.getInstance().get(7) - 1 & paramInt1) == 0) {}
    while ((1 << Calendar.getInstance().get(11) & paramInt2) == 0) {
      return false;
    }
    return true;
  }
  
  public boolean a(PluginPreloadStrategy.PreloadPublicParam paramPreloadPublicParam, String paramString1, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, int[] paramArrayOfInt, PluginPreloader.ExtraResult paramExtraResult)
  {
    if (paramPreloadPublicParam == null) {
      return false;
    }
    if ((paramPreloadPublicParam.jdField_h_of_type_Boolean) && (!a(paramString2)))
    {
      a(paramExtraResult, "preload:fail:notinleba");
      return false;
    }
    if (paramPreloadPublicParam.jdField_b_of_type_Boolean)
    {
      int i = a(paramQQAppInterface, paramString1);
      if ((paramPreloadPublicParam.jdField_c_of_type_Boolean) && (i == 4))
      {
        a(paramExtraResult, "preload:ok:reddotonly");
        return true;
      }
      if ((paramPreloadPublicParam.jdField_d_of_type_Boolean) && ((i == 1) || (i == 4)))
      {
        a(paramExtraResult, "preload:ok:reddot");
        return true;
      }
      if ((paramPreloadPublicParam.jdField_e_of_type_Boolean) && (i == 2))
      {
        a(paramExtraResult, "preload:fail:lebareddot");
        return false;
      }
    }
    if ((paramPreloadPublicParam.a) && (!a(paramPreloadPublicParam.jdField_b_of_type_Int, paramPreloadPublicParam.jdField_c_of_type_Int)))
    {
      a(paramExtraResult, "preload:fail:timecontrol");
      return false;
    }
    if ((paramPreloadPublicParam.j) && (paramInt < paramPreloadPublicParam.jdField_f_of_type_Int))
    {
      a(paramExtraResult, "preload:fail:usedtimeslimit");
      return false;
    }
    if (paramPreloadPublicParam.jdField_i_of_type_Boolean)
    {
      long l = paramPreloadPublicParam.jdField_e_of_type_Int * 60 * 60 * 1000;
      if (System.currentTimeMillis() - paramLong > l)
      {
        a(paramExtraResult, "preload:fail:notactive");
        return false;
      }
    }
    if (paramPreloadPublicParam.jdField_f_of_type_Boolean)
    {
      if ((System.currentTimeMillis() - paramLong) / 1000L <= paramPreloadPublicParam.jdField_d_of_type_Int) {
        paramInt = 1;
      }
      while (paramInt != 0) {
        if (paramPreloadPublicParam.jdField_g_of_type_Boolean)
        {
          a(paramExtraResult, "preload:ok:cdperiod");
          return true;
          paramInt = 0;
        }
        else
        {
          a(paramExtraResult, "preload:fail:cdperiod");
          return false;
        }
      }
    }
    if ((paramPreloadPublicParam.k) && (paramPreloadPublicParam.jdField_g_of_type_Int > 0) && (!a(paramString1, paramQQAppInterface.a(), paramPreloadPublicParam.jdField_g_of_type_Int, paramArrayOfInt, paramPreloadPublicParam.jdField_h_of_type_Int, paramPreloadPublicParam.jdField_i_of_type_Int)))
    {
      a(paramExtraResult, "preload:fail:notinuserlearn");
      return false;
    }
    a(paramExtraResult, "preload:ok:normal");
    return true;
  }
  
  public abstract boolean a(PluginPreloader.ExtraResult paramExtraResult);
  
  public boolean a(String paramString)
  {
    Object localObject = LebaShowListManager.a().b();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
      if ((localLebaViewItem != null) && (localLebaViewItem.a != null) && (localLebaViewItem.a.strPkgName != null) && (localLebaViewItem.a.strPkgName.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramInt1 <= 0) || (paramArrayOfInt == null)) {
      return false;
    }
    String str1 = paramString1 + "_userlearn_lasttime:" + paramString2;
    String str2 = paramString1 + "_userlearn_timearea:" + paramString2;
    String str3 = paramString1 + "_userlearn_timearea_inhour:" + paramString2 + ":";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("ppp_profile", SecMsgUtil.a());
    long l = localSharedPreferences.getLong(str1, 0L);
    int i = localSharedPreferences.getInt(str2, 3);
    if ((System.currentTimeMillis() - l > 86400000L) || (paramInt1 != i))
    {
      paramString2 = a(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
      paramString1 = paramString2;
      if (paramString2 == null) {
        break label381;
      }
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        localSharedPreferences.edit().putInt(str3 + paramInt2, paramString2[paramInt2]).commit();
        paramInt2 += 1;
      }
      localSharedPreferences.edit().putInt(str2, paramInt1).commit();
      localSharedPreferences.edit().putLong(str1, System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      if (paramString2 != null)
      {
        paramInt2 = Calendar.getInstance().get(11);
        paramInt3 = paramString2.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt3)
        {
          if (paramInt2 == paramString2[paramInt1])
          {
            return true;
            paramString2 = new int[i];
            paramInt1 = 0;
            for (;;)
            {
              paramString1 = paramString2;
              if (paramInt1 >= i) {
                break;
              }
              paramString2[paramInt1] = localSharedPreferences.getInt(str3 + paramInt1, paramInt1 + 20);
              paramInt1 += 1;
            }
          }
          paramInt1 += 1;
        }
      }
      return false;
      label381:
      paramString2 = paramString1;
    }
  }
  
  public int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfInt == null) || (paramInt1 <= 0) || (paramInt1 > paramArrayOfInt.length)) {}
    do
    {
      return null;
      localObject = new PluginPreloadStrategy.KMeans(this, paramInt3);
      switch (paramInt2)
      {
      default: 
        return null;
      case 1: 
        paramInt2 = ((PluginPreloadStrategy.KMeans)localObject).a(paramArrayOfInt, paramInt1);
      }
    } while (paramInt2 == -1);
    paramInt3 = paramInt2 - paramInt1 / 2;
    paramInt2 = paramInt3;
    if (paramInt3 < 0) {
      paramInt2 = paramInt3 + paramArrayOfInt.length;
    }
    Object localObject = new int[paramInt1];
    paramInt3 = 0;
    if (paramInt3 < paramInt1)
    {
      localObject[paramInt3] = paramInt2;
      int i = paramInt2 + 1;
      if (i >= paramArrayOfInt.length) {}
      for (paramInt2 = -paramArrayOfInt.length;; paramInt2 = 0)
      {
        paramInt3 += 1;
        paramInt2 = i + paramInt2;
        break;
      }
    }
    return (int[])localObject;
    return ((PluginPreloadStrategy.KMeans)localObject).a(paramArrayOfInt, paramInt1);
  }
  
  public boolean b(PluginPreloader.ExtraResult paramExtraResult)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\PluginPreloadStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */