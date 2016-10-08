package com.tencent.mobileqq.remind;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.remind.widget.IosTimepicker.FormatDataListener;
import com.tencent.mobileqq.remind.widget.IosTimepicker.OnTimePickerSelectListener;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import ufl;
import ufm;

public class RemindHelper
{
  private static IosTimepicker.FormatDataListener a;
  public static String a;
  public static boolean a = false;
  public static String b;
  public static final String c = "url";
  public static final String d = "uin";
  public static final String e = "uin_name";
  public static final String f = "uin_type";
  private static String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    g = "remind";
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener = new ufl();
  }
  
  public static Long a(String paramString)
  {
    long l2 = new Date().getTime() / 1000L;
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      return Long.valueOf(l1);
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d(g, 2, "getLong error: " + paramString.getMessage());
          paramString.printStackTrace();
          l1 = l2;
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      return paramString1;
    }
    catch (JSONException paramString2)
    {
      do
      {
        paramString1 = str;
      } while (!QLog.isColorLevel());
      QLog.d(g, 2, "getString from json error:" + paramString2.getMessage());
    }
    return "";
  }
  
  public static void a(Context paramContext, long paramLong, IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    ActionSheet localActionSheet;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localActionSheet = ActionSheet.c(paramContext);
      ((DispatchActionMoveScrollView)localActionSheet.findViewById(2131296881)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2130905112, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      DayAdapter localDayAdapter = new DayAdapter(paramContext, 25);
      NumberAdapter localNumberAdapter1 = new NumberAdapter(paramContext, TimeHelper.a, 25);
      NumberAdapter localNumberAdapter2 = new NumberAdapter(paramContext, TimeHelper.b, 25);
      int i = (int)TimeHelper.a(paramLong);
      int j = TimeHelper.a(paramLong);
      int k = TimeHelper.b(paramLong);
      IosTimepicker.FormatDataListener localFormatDataListener = jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener;
      ((IosTimepicker)localObject).a(paramContext, localActionSheet, paramOnTimePickerSelectListener, null, new BaseAdapter[] { localDayAdapter, localNumberAdapter1, localNumberAdapter2 }, new int[] { i, j, k }, localFormatDataListener);
      if (Build.VERSION.SDK_INT >= 11) {
        localActionSheet.getWindow().setFlags(16777216, 16777216);
      }
      localActionSheet.b((View)localObject, null);
      localActionSheet.setOnDismissListener(new ufm((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(g, 2, paramContext.getMessage());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a().a();
      if (paramQQAppInterface != null)
      {
        paramString = paramQQAppInterface.a(paramString, paramInt);
        if (paramString != null)
        {
          paramString.lastmsgtime = paramLong;
          paramString.showUpTime = 0L;
          paramQQAppInterface.a(paramString);
        }
      }
      QQMessageFacade.Message localMessage;
      do
      {
        return;
        localMessage = paramQQAppInterface.a().a(paramString, paramInt);
      } while (localMessage == null);
      paramLong = localMessage.time;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    return new CalendarHelper(paramContext).a(paramString, paramLong1, paramLong2);
  }
  
  public static boolean a(String paramString)
  {
    return paramString.equalsIgnoreCase(jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\remind\RemindHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */