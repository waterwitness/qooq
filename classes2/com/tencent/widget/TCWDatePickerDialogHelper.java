package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TCWDatePickerDialogHelper
{
  private static final String a = "yyyy-MM-dd";
  
  public TCWDatePickerDialogHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append('-').append(paramInt2).append('-').append(paramInt3);
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, TCWDatePickerDialog.OnDateSetListener paramOnDateSetListener)
  {
    Calendar localCalendar = Calendar.getInstance();
    a(a(paramInt1, paramInt2, paramInt3), localCalendar);
    a(paramContext, localCalendar, paramOnDateSetListener);
  }
  
  public static void a(Context paramContext, Calendar paramCalendar, TCWDatePickerDialog.OnDateSetListener paramOnDateSetListener)
  {
    int j = paramCalendar.get(1);
    int k = paramCalendar.get(2);
    int m = paramCalendar.get(5);
    paramCalendar = paramContext.getResources();
    int i = paramCalendar.getInteger(2131623945);
    int n = paramCalendar.getInteger(2131623946);
    if (j >= i)
    {
      i = j;
      if (j <= n) {}
    }
    else
    {
      i = Calendar.getInstance().get(1);
    }
    paramContext = new TCWDatePickerDialog(paramContext, paramOnDateSetListener, i, k, m);
    paramCalendar = Calendar.getInstance();
    paramContext.b(paramCalendar.getTimeInMillis());
    paramCalendar.roll(1, -121);
    paramCalendar.add(5, 1);
    paramContext.a(paramCalendar.getTimeInMillis());
    paramContext.show();
  }
  
  public static boolean a(String paramString, Calendar paramCalendar)
  {
    try
    {
      Date localDate = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      if (paramString != null) {
        paramCalendar.setTime(localDate);
      }
      return true;
    }
    catch (ParseException paramString) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\TCWDatePickerDialogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */