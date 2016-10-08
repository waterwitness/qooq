package com.tencent.mobileqq.remind;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.format.Time;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CalendarHelper
{
  public static final int a = -1;
  public static final long a = 3600000L;
  private static String jdField_a_of_type_JavaLangString;
  public static final String[] a;
  private static String b = "content://calendar/calendars";
  private static String c = "content://calendar/events";
  private static String d = "content://calendar/reminders";
  private Context jdField_a_of_type_AndroidContentContext;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "remind";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "com.android.calendar", "com.google.android.calendar" };
    b = "";
    c = "";
    d = "";
    if (Build.VERSION.SDK_INT >= 8)
    {
      b = "content://com.android.calendar/calendars";
      c = "content://com.android.calendar/events";
      d = "content://com.android.calendar/reminders";
      return;
    }
  }
  
  public CalendarHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  /* Error */
  public long a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/tencent/mobileqq/remind/CalendarHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4: invokevirtual 77	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: getstatic 40	com/tencent/mobileqq/remind/CalendarHelper:b	Ljava/lang/String;
    //   10: invokestatic 83	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +115 -> 137
    //   25: aload_1
    //   26: invokeinterface 95 1 0
    //   31: ifle +106 -> 137
    //   34: aload_1
    //   35: invokeinterface 99 1 0
    //   40: pop
    //   41: aload_1
    //   42: aload_1
    //   43: ldc 101
    //   45: invokeinterface 105 2 0
    //   50: invokeinterface 109 2 0
    //   55: istore_3
    //   56: iload_3
    //   57: i2l
    //   58: lstore 4
    //   60: aload_1
    //   61: ifnull +9 -> 70
    //   64: aload_1
    //   65: invokeinterface 112 1 0
    //   70: lload 4
    //   72: lreturn
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_1
    //   76: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +13 -> 92
    //   82: getstatic 28	com/tencent/mobileqq/remind/CalendarHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: iconst_2
    //   86: ldc 119
    //   88: aload_2
    //   89: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_1
    //   93: ifnull +40 -> 133
    //   96: aload_1
    //   97: invokeinterface 112 1 0
    //   102: ldc2_w 124
    //   105: lreturn
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull +9 -> 119
    //   113: aload_1
    //   114: invokeinterface 112 1 0
    //   119: aload_2
    //   120: athrow
    //   121: astore_2
    //   122: goto -13 -> 109
    //   125: astore_2
    //   126: goto -17 -> 109
    //   129: astore_2
    //   130: goto -54 -> 76
    //   133: ldc2_w 124
    //   136: lreturn
    //   137: ldc2_w 124
    //   140: lstore 4
    //   142: goto -82 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	CalendarHelper
    //   20	94	1	localCursor	android.database.Cursor
    //   73	16	2	localException1	Exception
    //   106	14	2	localObject1	Object
    //   121	1	2	localObject2	Object
    //   125	1	2	localObject3	Object
    //   129	1	2	localException2	Exception
    //   55	2	3	i	int
    //   58	83	4	l	long
    // Exception table:
    //   from	to	target	type
    //   0	21	73	java/lang/Exception
    //   0	21	106	finally
    //   25	56	121	finally
    //   76	92	125	finally
    //   25	56	129	java/lang/Exception
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = true;
    try
    {
      Object localObject = new ContentValues();
      ((ContentValues)localObject).put("event_id", Long.valueOf(paramLong));
      ((ContentValues)localObject).put("method", Integer.valueOf(1));
      ((ContentValues)localObject).put("minutes", Integer.valueOf(0));
      localObject = this.jdField_a_of_type_AndroidContentContext.getContentResolver().insert(Uri.parse(d), (ContentValues)localObject);
      if (localObject == null) {
        bool = false;
      }
      if (!QLog.isColorLevel()) {
        break label103;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Remind success");
        }
        return bool;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
      bool = false;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Remind failed");
    label103:
    localException1.printStackTrace();
    return bool;
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramString == null) || (paramString.equals("")) || (paramLong1 <= 0L) || (paramLong2 <= 0L)) {}
    long l;
    do
    {
      return false;
      l = a();
      if ((l == -1L) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "insert2Calendar step3 ,try insert Acount");
      }
    } while (l == -1L);
    return a(paramString, l, paramLong1, paramLong2);
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("title", paramString);
      localContentValues.put("calendar_id", Long.valueOf(paramLong1));
      localContentValues.put("dtstart", Long.valueOf(paramLong2));
      localContentValues.put("dtend", Long.valueOf(paramLong3));
      localContentValues.put("hasAlarm", Integer.valueOf(1));
      localContentValues.put("eventTimezone", Time.getCurrentTimezone());
      localContentValues.put("eventStatus", Integer.valueOf(1));
      localContentValues.put("hasAttendeeData", Integer.valueOf(1));
      paramLong1 = Long.parseLong(this.jdField_a_of_type_AndroidContentContext.getContentResolver().insert(Uri.parse(c), localContentValues).getLastPathSegment());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Event success");
      }
      boolean bool = a(paramLong1);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Event failed");
      }
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\remind\CalendarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */