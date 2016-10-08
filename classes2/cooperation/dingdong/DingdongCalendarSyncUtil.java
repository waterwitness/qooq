package cooperation.dingdong;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ConcernUinData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;
import yam;

public class DingdongCalendarSyncUtil
{
  private static final String a = "DingdongCalendarSyncUtil";
  private static String b = "content://com.android.calendar/calendars";
  private static String c = "content://com.android.calendar/events";
  private static String d = "content://com.android.calendar/reminders";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static String a()
  {
    Object localObject2 = null;
    localCursor = BaseApplication.getContext().getContentResolver().query(Uri.parse(b), null, "(calendar_access_level = ?) ", new String[] { "700" }, null);
    if (localCursor != null) {}
    label82:
    do
    {
      try
      {
        if (localCursor.getCount() <= 0) {
          break label82;
        }
        localCursor.moveToLast();
        String str = localCursor.getString(localCursor.getColumnIndex("_id"));
        localObject2 = str;
        if (localCursor != null)
        {
          localCursor.close();
          localObject2 = str;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("DingdongCalendarSyncUtil", 2, "getAccount: " + localException.getMessage());
        return null;
      }
      finally
      {
        if (localCursor == null) {
          break;
        }
        localCursor.close();
      }
      return (String)localObject2;
      if (QLog.isColorLevel()) {
        QLog.d("DingdongCalendarSyncUtil", 2, "getSystemAccount no account in system");
      }
    } while (localCursor == null);
    localCursor.close();
    return null;
  }
  
  private static String a(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    Object localObject = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = BaseApplication.getContext().getString(2131362706);
    localStringBuilder.append(str + "\n");
    str = a((DingdongPluginDataFactory.ScheduleSummaryData)localObject);
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str + "\n");
    }
    if (!TextUtils.isEmpty(((DingdongPluginDataFactory.ScheduleSummaryData)localObject).mark))
    {
      str = BaseApplication.getContext().getString(2131362595);
      localStringBuilder.append(str + ":");
      str = ((DingdongPluginDataFactory.ScheduleSummaryData)localObject).mark;
      localStringBuilder.append(str + "\n");
    }
    str = BaseApplication.getContext().getString(2131362629);
    localStringBuilder.append(str + ":");
    if (TextUtils.isEmpty(((DingdongPluginDataFactory.ScheduleSummaryData)localObject).authorUin)) {}
    for (localObject = "";; localObject = DingdongPluginHelper.a(0, "", ((DingdongPluginDataFactory.ScheduleSummaryData)localObject).authorUin))
    {
      localStringBuilder.append((String)localObject + "\n");
      if ((paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList != null) && (paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = BaseApplication.getContext().getString(2131362596);
        localStringBuilder.append((String)localObject + ":");
        localStringBuilder.append(a(paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList) + "\n");
      }
      return localStringBuilder.toString();
    }
  }
  
  private static String a(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    StringBuilder localStringBuilder = new StringBuilder("http://sqimg.qq.com/qq_product_operations/eim/calendar/forward.html?");
    localStringBuilder.append("uin=");
    localStringBuilder.append("0");
    localStringBuilder.append("&schedule_id=");
    localStringBuilder.append(paramScheduleSummaryData.id);
    localStringBuilder.append("&from=qq");
    paramScheduleSummaryData = new HashMap();
    paramScheduleSummaryData.put("url", localStringBuilder.toString());
    String str = (String)HttpUtil.a(paramScheduleSummaryData).get("url");
    paramScheduleSummaryData = str;
    if (str.equals(localStringBuilder.toString()))
    {
      str = "";
      paramScheduleSummaryData = str;
      if (QLog.isColorLevel())
      {
        QLog.d("DingdongCalendarSyncUtil", 2, "getShortURL error");
        paramScheduleSummaryData = str;
      }
    }
    return paramScheduleSummaryData;
  }
  
  private static String a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject = (DingdongPluginBizObserver.ConcernUinData)paramArrayList.get(i);
      localObject = DingdongPluginHelper.a(((DingdongPluginBizObserver.ConcernUinData)localObject).jdField_a_of_type_Int, ((DingdongPluginBizObserver.ConcernUinData)localObject).b, ((DingdongPluginBizObserver.ConcernUinData)localObject).jdField_a_of_type_JavaLangString);
      if (i == paramArrayList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((String)localObject + "、");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    new yam(paramInt).execute(new DingdongPluginBizObserver.ScheduleMoreSummaryData[] { paramScheduleMoreSummaryData });
  }
  
  private static void a(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    if ((NetConnInfoCenter.getServerTimeMillis() > localScheduleSummaryData.endTime) || (!a(localScheduleSummaryData.authorUin, paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList)) || (localScheduleSummaryData.specialFlag == 2)) {
      if (QLog.isColorLevel()) {
        QLog.d("DingdongCalendarSyncUtil", 2, "createEvent:not need pass data schedule");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        str = a();
        if (!TextUtils.isEmpty(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DingdongCalendarSyncUtil", 2, "accountId not create");
      return;
      if (!a(localScheduleSummaryData.id))
      {
        a(str, paramScheduleMoreSummaryData);
        return;
      }
      b(paramScheduleMoreSummaryData);
    } while (!QLog.isColorLevel());
    QLog.d("DingdongCalendarSyncUtil", 2, "createEvent has event in system");
  }
  
  private static void a(String paramString, DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("customAppUri", localScheduleSummaryData.id);
    localContentValues.put("calendar_id", paramString);
    if (localScheduleSummaryData.title != null) {
      localContentValues.put("title", localScheduleSummaryData.title);
    }
    localContentValues.put("description", a(paramScheduleMoreSummaryData));
    if (localScheduleSummaryData.location != null) {
      localContentValues.put("eventLocation", localScheduleSummaryData.location);
    }
    localContentValues.put("dtstart", Long.valueOf(localScheduleSummaryData.beginTime));
    localContentValues.put("dtend", Long.valueOf(localScheduleSummaryData.endTime));
    paramScheduleMoreSummaryData = TimeZone.getDefault();
    paramString = "";
    if (paramScheduleMoreSummaryData.getID() != null) {
      paramString = paramScheduleMoreSummaryData.getID();
    }
    localContentValues.put("eventTimezone", paramString);
    BaseApplication.getContext().getContentResolver().insert(Uri.parse(c), localContentValues);
  }
  
  private static boolean a(String paramString)
  {
    paramString = BaseApplication.getContext().getContentResolver().query(Uri.parse(c), null, "(customAppUri = ?) ", new String[] { paramString }, null);
    if (paramString == null) {
      if (paramString != null) {
        paramString.close();
      }
    }
    for (;;)
    {
      return false;
      try
      {
        int i = paramString.getCount();
        if (i > 0) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("DingdongCalendarSyncUtil", 2, "isExistInCalendar: " + localException.getMessage());
        return false;
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
      }
    }
  }
  
  private static boolean a(String paramString, ArrayList paramArrayList)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.a().a();
    if (localObject == null) {}
    for (;;)
    {
      return false;
      localObject = ((QQAppInterface)localObject).f();
      if (paramString.equals(localObject)) {
        return true;
      }
      if (paramArrayList != null)
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          if (((String)localObject).equals(((DingdongPluginBizObserver.ConcernUinData)paramArrayList.get(i)).jdField_a_of_type_JavaLangString)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static void b(int paramInt, DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    if (QLog.isColorLevel()) {
      QLog.d("DingdongCalendarSyncUtil", 2, "syncToSystemCalendar type = " + paramInt + " summaryData =" + localScheduleSummaryData);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      a(paramScheduleMoreSummaryData);
      return;
    case 6: 
      b(paramScheduleMoreSummaryData);
      return;
    case 4: 
      c(paramScheduleMoreSummaryData);
      return;
    }
    c(paramScheduleMoreSummaryData);
  }
  
  private static void b(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    if ((NetConnInfoCenter.getServerTimeMillis() > localScheduleSummaryData.endTime) || (!a(localScheduleSummaryData.authorUin, paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList)) || (localScheduleSummaryData.specialFlag == 2))
    {
      c(paramScheduleMoreSummaryData);
      if (QLog.isColorLevel()) {
        QLog.d("DingdongCalendarSyncUtil", 2, "updateEvent:del pass data schedule");
      }
    }
    for (;;)
    {
      return;
      Object localObject = localScheduleSummaryData.id;
      if (!a((String)localObject))
      {
        a(paramScheduleMoreSummaryData);
        return;
      }
      localObject = BaseApplication.getContext().getContentResolver().query(Uri.parse(c), null, "(customAppUri = ?) ", new String[] { localObject }, null);
      try
      {
        if (((Cursor)localObject).getCount() > 0)
        {
          ((Cursor)localObject).moveToFirst();
          long l = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("_id"));
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("title", localScheduleSummaryData.title);
          localContentValues.put("description", a(paramScheduleMoreSummaryData));
          localContentValues.put("eventLocation", localScheduleSummaryData.location);
          localContentValues.put("dtstart", Long.valueOf(localScheduleSummaryData.beginTime));
          localContentValues.put("dtend", Long.valueOf(localScheduleSummaryData.endTime));
          paramScheduleMoreSummaryData = ContentUris.withAppendedId(Uri.parse(c), l);
          BaseApplication.getContext().getContentResolver().update(paramScheduleMoreSummaryData, localContentValues, null, null);
        }
        return;
      }
      catch (Exception paramScheduleMoreSummaryData)
      {
        paramScheduleMoreSummaryData.printStackTrace();
        QLog.e("DingdongCalendarSyncUtil", 2, "updateEvent: " + paramScheduleMoreSummaryData.getMessage());
        return;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
  }
  
  private static void c(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    paramScheduleMoreSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData.id;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramScheduleMoreSummaryData;
    BaseApplication.getContext().getContentResolver().delete(Uri.parse(c), "(customAppUri = ?) ", arrayOfString);
    BaseApplication.getContext().getContentResolver().delete(Uri.parse(c), "(organizer = ?) ", arrayOfString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\DingdongCalendarSyncUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */