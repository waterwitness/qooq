package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteDatabase
{
  static final String jdField_a_of_type_JavaLangString = "select sql from sqlite_master where type=? and name=?";
  public static boolean a = false;
  private static final String jdField_b_of_type_JavaLangString = "db";
  private static final boolean jdField_b_of_type_Boolean = false;
  private static final String c = "SQLiteDataBaseLog";
  final android.database.sqlite.SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private TableNameCache jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache;
  private final Map jdField_a_of_type_JavaUtilMap;
  private final Map jdField_b_of_type_JavaUtilMap;
  
  SQLiteDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, TableNameCache paramTableNameCache)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = paramSQLiteDatabase;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache = paramTableNameCache;
  }
  
  private static int a(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2)
  {
    int i = 0;
    int j = paramArrayOfStackTraceElement2.length;
    int k = paramArrayOfStackTraceElement1.length;
    for (;;)
    {
      k -= 1;
      if (k < 0) {
        break;
      }
      j -= 1;
      if ((j < 0) || (!paramArrayOfStackTraceElement2[j].equals(paramArrayOfStackTraceElement1[k]))) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  private ContentValues a(String paramString, ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return paramContentValues;
    }
    ContentValues localContentValues = new ContentValues(paramContentValues);
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (paramContentValues.containsKey(str))
        {
          Object localObject = paramContentValues.get(str);
          if ((localObject instanceof String))
          {
            localObject = (String)paramContentValues.get(str);
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              localContentValues.put(str, a(localObject));
            }
          }
          else if ((localObject instanceof byte[]))
          {
            localContentValues.put(str, a((byte[])localObject));
          }
        }
      }
    }
    return localContentValues;
  }
  
  /* Error */
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   3: lstore 14
    //   5: aload_0
    //   6: aload_2
    //   7: aload 4
    //   9: aload 5
    //   11: invokespecial 117	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 38	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   18: iconst_0
    //   19: aload_2
    //   20: aload_3
    //   21: aload 4
    //   23: aload 5
    //   25: aload 6
    //   27: aload 7
    //   29: aload 8
    //   31: aload 9
    //   33: invokevirtual 122	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 10
    //   38: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   41: lstore 16
    //   43: getstatic 124	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_Boolean	Z
    //   46: ifne +9 -> 55
    //   49: getstatic 129	com/tencent/mobileqq/activity/aio/AIOUtils:g	Z
    //   52: ifeq +136 -> 188
    //   55: new 131	java/lang/StringBuilder
    //   58: dup
    //   59: bipush 32
    //   61: invokespecial 134	java/lang/StringBuilder:<init>	(I)V
    //   64: astore 11
    //   66: aload 11
    //   68: aload_3
    //   69: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: ldc -116
    //   74: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 4
    //   79: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc -116
    //   84: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 5
    //   90: ifnull +38 -> 128
    //   93: aload 5
    //   95: arraylength
    //   96: istore 13
    //   98: iconst_0
    //   99: istore 12
    //   101: iload 12
    //   103: iload 13
    //   105: if_icmpge +23 -> 128
    //   108: aload 11
    //   110: aload 5
    //   112: iload 12
    //   114: aaload
    //   115: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: iload 12
    //   121: iconst_1
    //   122: iadd
    //   123: istore 12
    //   125: goto -24 -> 101
    //   128: aload 11
    //   130: ldc -116
    //   132: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 6
    //   137: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc -116
    //   142: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 7
    //   147: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc -116
    //   152: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 8
    //   157: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc -116
    //   162: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 9
    //   167: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc -112
    //   173: aload_2
    //   174: aload 11
    //   176: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: aconst_null
    //   180: lload 16
    //   182: lload 14
    //   184: lsub
    //   185: invokestatic 151	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   188: aload 10
    //   190: astore_2
    //   191: invokestatic 156	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   194: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   197: lload 14
    //   199: lsub
    //   200: invokevirtual 159	com/tencent/util/MsgAutoMonitorUtil:a	(J)V
    //   203: aload_2
    //   204: areturn
    //   205: astore_3
    //   206: aconst_null
    //   207: astore_2
    //   208: aload_0
    //   209: aload_3
    //   210: invokespecial 162	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/Throwable;)V
    //   213: goto -22 -> 191
    //   216: astore_2
    //   217: aload_2
    //   218: athrow
    //   219: astore_3
    //   220: aload 10
    //   222: astore_2
    //   223: goto -15 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	SQLiteDatabase
    //   0	226	1	paramBoolean	boolean
    //   0	226	2	paramString1	String
    //   0	226	3	paramArrayOfString1	String[]
    //   0	226	4	paramString2	String
    //   0	226	5	paramArrayOfString2	String[]
    //   0	226	6	paramString3	String
    //   0	226	7	paramString4	String
    //   0	226	8	paramString5	String
    //   0	226	9	paramString6	String
    //   36	185	10	localCursor	Cursor
    //   64	111	11	localStringBuilder	StringBuilder
    //   99	25	12	i	int
    //   96	10	13	j	int
    //   3	195	14	l1	long
    //   41	140	16	l2	long
    // Exception table:
    //   from	to	target	type
    //   14	38	205	java/lang/Throwable
    //   14	38	216	finally
    //   38	55	216	finally
    //   55	88	216	finally
    //   93	98	216	finally
    //   108	119	216	finally
    //   128	188	216	finally
    //   208	213	216	finally
    //   38	55	219	java/lang/Throwable
    //   55	88	219	java/lang/Throwable
    //   93	98	219	java/lang/Throwable
    //   108	119	219	java/lang/Throwable
    //   128	188	219	java/lang/Throwable
  }
  
  private String a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return (String)paramObject;
      str = paramObject.toString();
      paramObject = str;
    } while (str.length() <= 0);
    return SecurityUtile.b(str);
  }
  
  private ArrayList a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      Cursor localCursor = a("select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          ArrayList localArrayList = a(SecurityUtile.a(localCursor.getString(0)), new String[] { "TEXT", "BLOB" });
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localArrayList);
        }
        localCursor.close();
      }
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private ArrayList a(String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("db", 2, paramString);
    }
    try
    {
      String[] arrayOfString1 = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")")).split(",");
      ArrayList localArrayList = new ArrayList();
      int k = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= k) {
          break;
        }
        paramString = paramArrayOfString[i].toLowerCase();
        int m = arrayOfString1.length;
        int j = 0;
        while (j < m)
        {
          String[] arrayOfString2 = arrayOfString1[j].trim().split(" ");
          if ((arrayOfString2.length > 1) && (paramString.equals(arrayOfString2[1].toLowerCase()))) {
            localArrayList.add(arrayOfString2[0]);
          }
          j += 1;
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("db", 2, "analyseTableField exception: ", paramString);
      }
      paramString = new ArrayList();
    }
  }
  
  public static Map a()
  {
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0).getBoolean("isLogcatDBOperation", false);
  }
  
  private void a(String paramString1, String paramString2) {}
  
  private static void a(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, long paramLong)
  {
    int i = 0;
    if (QLog.isColorLevel())
    {
      Object localObject = Thread.currentThread();
      String str = ((Thread)localObject).getName();
      boolean bool;
      if (localObject == Looper.getMainLooper().getThread())
      {
        bool = true;
        localObject = new StringBuilder(512);
        ((StringBuilder)localObject).append("TableName:").append(paramString2).append('|');
        ((StringBuilder)localObject).append("ExecuteType:").append(paramString1).append("|");
        ((StringBuilder)localObject).append("CurrentThreadName:").append(str).append('|');
        ((StringBuilder)localObject).append("IsMainThread:").append(bool).append('|');
        ((StringBuilder)localObject).append("Cost:").append(paramLong).append('|');
        ((StringBuilder)localObject).append("CMD:").append(paramString3);
        if (paramArrayOfObject == null) {
          break label220;
        }
        int j = paramArrayOfObject.length;
        label162:
        if (i >= j) {
          break label220;
        }
        paramString1 = paramArrayOfObject[i];
        if (paramString1 != null) {
          break label202;
        }
        ((StringBuilder)localObject).append("null,");
      }
      for (;;)
      {
        i += 1;
        break label162;
        bool = false;
        break;
        label202:
        ((StringBuilder)localObject).append(paramString1.toString()).append(',');
      }
      label220:
      paramString1 = ((StringBuilder)localObject).toString();
      if (bool) {
        QLog.d("SQLiteDataBaseLog", 2, paramString1, new Throwable("WTF"));
      }
    }
    else
    {
      return;
    }
    QLog.d("SQLiteDataBaseLog", 2, paramString1);
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((paramString2 == null) || (paramArrayOfString == null)) {}
    for (;;)
    {
      return;
      paramString1 = a(paramString1);
      if (paramString1 != null)
      {
        paramString2 = b(paramString2);
        int i = 0;
        while (i < paramString2.size())
        {
          if ((paramString1.contains(paramString2.get(i))) && ((paramArrayOfString[i] instanceof String))) {
            paramArrayOfString[i] = a(paramArrayOfString[i]);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      QLog.e("SQLiteDatabase", 2, paramThrowable.getMessage());
      if ((paramThrowable.getMessage() != null) && (!paramThrowable.getMessage().contains("no such table"))) {
        localStringBuilder = new StringBuilder();
      }
    }
    try
    {
      a(paramThrowable, localStringBuilder, "", null);
      QLog.e("SQLiteDatabase", 2, new Object[] { localStringBuilder });
      return;
    }
    catch (Exception paramThrowable)
    {
      for (;;) {}
    }
  }
  
  private void a(Throwable paramThrowable, StringBuilder paramStringBuilder, String paramString, StackTraceElement[] paramArrayOfStackTraceElement)
  {
    int j = 0;
    StringBuilder localStringBuilder = paramStringBuilder;
    if (paramStringBuilder == null) {
      localStringBuilder = new StringBuilder();
    }
    localStringBuilder.append(paramThrowable.toString());
    localStringBuilder.append("\n");
    paramStringBuilder = paramThrowable.getStackTrace();
    if (paramStringBuilder != null)
    {
      int i;
      if (paramArrayOfStackTraceElement != null)
      {
        i = a(paramStringBuilder, paramArrayOfStackTraceElement);
        if (j >= paramStringBuilder.length - i) {
          break label182;
        }
        if (j >= 3) {
          break label129;
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append("\tat ");
        localStringBuilder.append(paramStringBuilder[j].toString());
        localStringBuilder.append("\n");
      }
      for (;;)
      {
        j += 1;
        break;
        i = 0;
        break;
        label129:
        if (j == paramStringBuilder.length - i - 1)
        {
          localStringBuilder.append(paramString);
          localStringBuilder.append("\t...at ");
          localStringBuilder.append(paramStringBuilder[j].toString());
          localStringBuilder.append("\n");
        }
      }
      label182:
      if (i > 0)
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append("\t... ");
        localStringBuilder.append(Integer.toString(i));
        localStringBuilder.append(" more\n");
      }
    }
    if (paramThrowable.getCause() != null)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("Caused by: ");
      a(paramThrowable, localStringBuilder, paramString, paramStringBuilder);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((jdField_a_of_type_Boolean ^ paramBoolean))
    {
      jdField_a_of_type_Boolean = paramBoolean;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0).edit();
      localEditor.putBoolean("isLogcatDBOperation", paramBoolean);
      localEditor.commit();
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    return SecurityUtile.a(paramArrayOfByte);
  }
  
  private ArrayList b(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (ArrayList)this.b.get(paramString);
    }
    Matcher localMatcher = Pattern.compile("\\s*\\w+\\s*(>|<|=|>=|<=|!=|=!|<>)\\s*\\?\\s*").matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (localMatcher.find())
    {
      Object localObject = localMatcher.group().trim();
      localObject = Pattern.compile("\\w+").matcher((CharSequence)localObject);
      ((Matcher)localObject).find();
      localArrayList.add(((Matcher)localObject).group());
    }
    this.b.put(paramString, localArrayList);
    return localArrayList;
  }
  
  public static void g() {}
  
  public static void h() {}
  
  private void i()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.jdField_a_of_type_Boolean) {}
    try
    {
      String[] arrayOfString = a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(arrayOfString);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("db", 2, "buildTableNameCache exception", localException);
    }
  }
  
  public int a(String paramString)
  {
    int i = 0;
    int j = 0;
    long l = System.currentTimeMillis();
    paramString = a("select count() from " + paramString, null);
    if (paramString != null) {
      i = j;
    }
    try
    {
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
        i = j;
      }
    }
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    a(paramString1, paramString2, paramArrayOfString);
    try
    {
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      l = System.currentTimeMillis() - l;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("update", paramString1, paramContentValues + ";" + paramString2, paramArrayOfString, l);
      }
      MsgAutoMonitorUtil.a().a(l);
      return i;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1;
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l1 = System.currentTimeMillis();
    a(paramString1, null);
    a(paramString1, paramString2, paramArrayOfString);
    try
    {
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      long l2 = System.currentTimeMillis() - l1;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("delete", paramString1, paramString2 + ";", paramArrayOfString, l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return i;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l1);
    }
    return -1;
  }
  
  public long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    try
    {
      long l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("insert", paramString1, paramString2 + ";" + paramContentValues, null, l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return l1;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1L;
  }
  
  /* Error */
  public Cursor a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokespecial 117	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 38	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_1
    //   18: aload 4
    //   20: invokevirtual 464	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore 5
    //   25: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   28: lstore 8
    //   30: getstatic 124	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_Boolean	Z
    //   33: ifne +9 -> 42
    //   36: getstatic 129	com/tencent/mobileqq/activity/aio/AIOUtils:g	Z
    //   39: ifeq +40 -> 79
    //   42: ldc_w 465
    //   45: aload_2
    //   46: new 131	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 344	java/lang/StringBuilder:<init>	()V
    //   53: aload_1
    //   54: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc -116
    //   59: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_3
    //   63: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: aload 4
    //   71: lload 8
    //   73: lload 6
    //   75: lsub
    //   76: invokestatic 151	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   79: aload 5
    //   81: astore_1
    //   82: invokestatic 156	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   85: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   88: lload 6
    //   90: lsub
    //   91: invokevirtual 159	com/tencent/util/MsgAutoMonitorUtil:a	(J)V
    //   94: aload_1
    //   95: areturn
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_0
    //   100: aload_2
    //   101: invokespecial 162	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/Throwable;)V
    //   104: goto -22 -> 82
    //   107: astore_1
    //   108: aload_1
    //   109: athrow
    //   110: astore_2
    //   111: aload 5
    //   113: astore_1
    //   114: goto -15 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	SQLiteDatabase
    //   0	117	1	paramString1	String
    //   0	117	2	paramString2	String
    //   0	117	3	paramString3	String
    //   0	117	4	paramArrayOfString	String[]
    //   23	89	5	localCursor	Cursor
    //   3	86	6	l1	long
    //   28	44	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   13	25	96	java/lang/Throwable
    //   13	25	107	finally
    //   25	42	107	finally
    //   42	79	107	finally
    //   99	104	107	finally
    //   25	42	110	java/lang/Throwable
    //   42	79	110	java/lang/Throwable
  }
  
  public Cursor a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return a(false, paramString1, null, paramString2, paramArrayOfString, null, null, null, null);
  }
  
  @Deprecated
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    try
    {
      paramString = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = paramString;
        a(paramString);
        paramString = (String)localObject;
      }
    }
    finally {}
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3, paramString4);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(paramString);
  }
  
  public boolean a(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      a(null, paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      l = System.currentTimeMillis() - l;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("execSQL", "", paramString, null, l);
      }
      MsgAutoMonitorUtil.a().a(l);
      return true;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, Object[] paramArrayOfObject)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    for (;;)
    {
      try
      {
        String str;
        if (i < paramArrayOfObject.length)
        {
          if ((paramArrayOfObject[i] instanceof String))
          {
            str = (String)paramArrayOfObject[i];
            if ((str.startsWith("mr_")) && (str.endsWith("_New")))
            {
              a(str, paramString);
              this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString, paramArrayOfObject);
              l = System.currentTimeMillis() - l;
              if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
                a("execSQL", "", paramString, paramArrayOfObject, l);
              }
              MsgAutoMonitorUtil.a().a(l);
              return true;
            }
          }
          i += 1;
        }
        else
        {
          str = null;
        }
      }
      catch (Throwable paramString)
      {
        a(paramString);
        return false;
      }
    }
  }
  
  public String[] a()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    long l = System.currentTimeMillis();
    Cursor localCursor;
    int i;
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      localCursor = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
      localObject1 = localObject2;
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = new String[localCursor.getCount()];
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject1[i] = SecurityUtile.a(localCursor.getString(0));
      if (!localCursor.moveToNext())
      {
        if (localCursor != null) {
          localCursor.close();
        }
        MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
        return (String[])localObject1;
      }
      i += 1;
    }
  }
  
  public int b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    String str2 = "select count(*) from " + paramString1;
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramArrayOfString != null)
      {
        a(paramString1, paramString2, paramArrayOfString);
        str1 = str2 + " where " + paramString2;
      }
    }
    paramString1 = a(str1, paramArrayOfString);
    int i;
    if (paramString1 != null)
    {
      paramString1.moveToFirst();
      i = paramString1.getInt(0);
      paramString1.close();
    }
    for (;;)
    {
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return i;
      i = 0;
    }
  }
  
  public long b(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    try
    {
      long l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if ((jdField_a_of_type_Boolean) || (AIOUtils.g)) {
        a("replace", paramString1, paramString2 + ";" + paramContentValues, null, l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return l1;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1L;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    try
    {
      g();
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      MsgAutoMonitorUtil.a().b(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setLockingEnabled(paramBoolean);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public boolean b(String paramString)
  {
    i();
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(paramString);
  }
  
  public String[] b()
  {
    i();
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a();
  }
  
  public void c()
  {
    long l = System.currentTimeMillis();
    try
    {
      g();
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransactionNonExclusive();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      MsgAutoMonitorUtil.a().b(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void d()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void e()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
      h();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void f()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\SQLiteDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */