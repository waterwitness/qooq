package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ThemeBackground
{
  public static final String DIY_DEFAULT_BG_ID = "5000";
  public static final String DIY_UPLOAD_BG_ID = "4999";
  static final String TAG = "ThemeBackground";
  public Drawable img;
  public boolean isNeedImg;
  public String path;
  
  public ThemeBackground()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.isNeedImg = true;
  }
  
  public static void clear(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0).edit();
    paramContext.putString(paramString1, "null");
    paramContext.commit();
  }
  
  public static boolean getThemeBackground(Context paramContext, String paramString1, String paramString2, ThemeBackground paramThemeBackground)
  {
    boolean bool;
    if (paramString1 == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      String str1;
      Object localObject1;
      label254:
      Object localObject2;
      Object localObject3;
      StatisticCollector localStatisticCollector;
      String str2;
      label435:
      label453:
      label465:
      label585:
      label603:
      label657:
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeBackground", 2, "getThemeBackground, bgType=" + paramString1);
        }
        str1 = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0).getString(paramString1, "null");
        if (QLog.isColorLevel()) {
          QLog.i("ThemeBackground", 2, "path1=" + str1);
        }
        if ((paramThemeBackground.path == null) || (!paramThemeBackground.path.equals(str1)) || (paramThemeBackground.img == null))
        {
          if ((str1 == null) || ("".equals(str1)) || ("null".equals(str1)) || ("none".equals(str1)))
          {
            paramThemeBackground.path = "null";
            if (!QLog.isColorLevel()) {
              break label1027;
            }
            QLog.i("ThemeBackground", 2, "getThemeBackground, bgType=" + paramString1 + ", path=default");
            break label1027;
          }
          bool = paramThemeBackground.isNeedImg;
          if (!bool) {}
        }
      }
      finally {}
      for (;;)
      {
        try
        {
          if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str1) != null)
          {
            localObject1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str1);
            paramString2 = (String)localObject1;
            if (localObject1 == null)
            {
              localObject2 = new BitmapFactory.Options();
              ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
              localObject1 = BitmapManager.a(str1, (BitmapFactory.Options)localObject2);
              paramString2 = ((BitmapManager.BitmapDecodeResult)localObject1).a;
              if (QLog.isColorLevel()) {
                QLog.d("ThemeBackground", 2, "getThemeBackground, bgType=" + paramString1 + ", path3=" + str1 + ", result:" + ((BitmapManager.BitmapDecodeResult)localObject1).e);
              }
            }
          }
        }
        catch (OutOfMemoryError paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ThemeBackGround getThemeBackground 1", 2, paramString2.getMessage());
          }
          paramThemeBackground.img = null;
          try
          {
            paramString2 = new HashMap();
            paramString2.put("param_FailCode", "OOM");
            paramString2.put("param_bgType", paramString1);
            paramString2.put("param_themeid", ThemeUtil.getCurrentThemeId());
            StatisticCollector.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a()).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, paramString2, "", false);
          }
          catch (Exception paramContext) {}
          break label657;
          paramThemeBackground.path = "null";
          break label657;
        }
        catch (Exception paramString2)
        {
          label721:
          label730:
          if (QLog.isColorLevel()) {
            QLog.e("ThemeBackGround getThemeBackground 2", 2, paramString2.getMessage());
          }
          paramThemeBackground.img = null;
          try
          {
            paramString2 = new HashMap();
            paramString2.put("param_FailCode", "EE");
            paramString2.put("param_bgType", paramString1);
            paramString2.put("param_themeid", ThemeUtil.getCurrentThemeId());
            StatisticCollector.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a()).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, paramString2, "", false);
          }
          catch (Exception paramContext) {}
          break label657;
        }
        try
        {
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", "d_" + ((BitmapManager.BitmapDecodeResult)localObject1).e);
          ((HashMap)localObject3).put("param_bgType", paramString1);
          ((HashMap)localObject3).put("param_themeid", ThemeUtil.getCurrentThemeId());
          localStatisticCollector = StatisticCollector.a(paramContext);
          str2 = ((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a()).getAccount();
          if (paramString2 == null) {
            continue;
          }
          bool = true;
          localStatisticCollector.a(str2, "ThemeBackgroundDecoder", bool, 1L, 0L, (HashMap)localObject3, "", false);
        }
        catch (Exception localException2)
        {
          break label453;
          break label603;
        }
      }
      if (((BitmapManager.BitmapDecodeResult)localObject1).e == 1)
      {
        int i = 2;
        if (i <= 32)
        {
          ((BitmapFactory.Options)localObject2).inSampleSize = i;
          localObject1 = BitmapManager.a(str1, (BitmapFactory.Options)localObject2);
          paramString2 = ((BitmapManager.BitmapDecodeResult)localObject1).a;
          int j = ((BitmapManager.BitmapDecodeResult)localObject1).e;
          if (j == 1) {
            break label721;
          }
        }
        try
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_FailCode", "dd_" + ((BitmapManager.BitmapDecodeResult)localObject1).e);
          ((HashMap)localObject2).put("param_themeid", ThemeUtil.getCurrentThemeId());
          localObject1 = StatisticCollector.a(paramContext);
          localObject3 = ((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a()).getAccount();
          if (paramString2 == null) {
            break label730;
          }
          bool = true;
          ((StatisticCollector)localObject1).a((String)localObject3, "ThemeBackgroundDecoder", bool, 1L, 0L, (HashMap)localObject2, "", false);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            continue;
            paramString2 = new ChatBackgroundDrawable(paramContext.getResources(), paramString2);
            paramString2.setGravity(48);
            paramThemeBackground.img = paramString2;
          }
        }
        if (paramString2 != null)
        {
          if ("theme_bg_message_path_png".equals(paramString1)) {
            BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(str1, paramString2);
          }
          paramThemeBackground.path = str1;
          if ("theme_bg_setting_path_png".equals(paramString1)) {
            paramThemeBackground.img = new BitmapDrawable(paramContext.getResources(), paramString2);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("ThemeBackground", 2, "getThemeBackground, bgType=" + paramString1 + ", path2=" + paramThemeBackground.path);
            break label1027;
            localObject1 = null;
            break label254;
            bool = false;
            break label435;
            i *= 2;
            break label465;
            bool = false;
            break label585;
            paramThemeBackground.path = str1;
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("ThemeBackground", 2, "getThemeBackground, bgType=" + paramString1 + ", path3=" + paramThemeBackground.path);
            }
            bool = false;
            break;
          }
        }
      }
      label1027:
      bool = true;
    }
  }
  
  public static boolean getThemeBackgroundEnable()
  {
    return ThemeUtil.getIsDIYTheme(null);
  }
  
  public static void setThemeBackgroundPic(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */