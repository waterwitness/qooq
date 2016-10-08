package cooperation.readinjoy.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReadInJoyDataProvider
  extends AppContentProvider
{
  public static final String A = "commentUin";
  public static final String B = "commentID";
  public static final String C = "replyUin";
  public static final String D = "replyID";
  public static final String E = "commentInfo";
  public static final String F = "receiveTime";
  public static final String G = "isDelete";
  public static final String H = "processSeq";
  public static final String I = "common_key";
  public static final String J = "common_version";
  public static final String K = "common_content";
  private static final String L = "ReadInJoyDataProvider";
  private static final int jdField_a_of_type_Int = 2000;
  public static final Uri a;
  public static final String a = "LocalChannelCity";
  private static final int b = 2001;
  public static final Uri b;
  public static final String b = "qq.readinjoy";
  private static final int jdField_c_of_type_Int = 2002;
  public static final Uri c;
  static String jdField_c_of_type_JavaLangString;
  private static final int d = 2003;
  public static final Uri d = Uri.parse(jdField_c_of_type_JavaLangString + "recent_data");
  public static final String d = "subscribe_msg_records";
  private static final int e = 2004;
  public static final Uri e = Uri.parse(jdField_c_of_type_JavaLangString + "common_records");
  public static final String e = "notify_msg_records";
  public static final String f = "feeds_msg_records";
  public static final String g = "recent_data";
  public static final String h = "common_records";
  public static final String i = "limit";
  public static final String j = "uin";
  public static final String k = "_id";
  public static final String l = "msgID";
  public static final String m = "subscribeID";
  public static final String n = "msgURL";
  public static final String o = "msgContent";
  public static final String p = "msgTime";
  public static final String q = "bindUin";
  public static final String r = "_id";
  public static final String s = "pushTime";
  public static final String t = "notifyType";
  public static final String u = "feedsOwner";
  public static final String v = "feedsID";
  public static final String w = "feedsSubject";
  public static final String x = "deleteUin";
  public static final String y = "publishFail";
  public static final String z = "likeUin";
  private UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  private ReadInJoyDataProvider.ReadInJoyDBHelper jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProvider$ReadInJoyDBHelper;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = "content://qq.readinjoy/";
    jdField_a_of_type_AndroidNetUri = Uri.parse(jdField_c_of_type_JavaLangString + "subscribe_msg_records");
    b = Uri.parse(jdField_c_of_type_JavaLangString + "notify_msg_records");
    jdField_c_of_type_AndroidNetUri = Uri.parse(jdField_c_of_type_JavaLangString + "feeds_msg_records");
  }
  
  private SQLiteDatabase a(Uri paramUri, boolean paramBoolean)
  {
    String str1 = paramUri.getQueryParameter("uin");
    if (str1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, uin = null, uri=" + paramUri.getPath());
      }
    }
    AppRuntime localAppRuntime;
    String str2;
    do
    {
      do
      {
        return null;
        localAppRuntime = getRuntime(str1);
        if (localAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, ar is null, uri=" + paramUri.getPath());
      return null;
      str2 = localAppRuntime.getAccount();
      if (str2.equals(str1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, uin not equal, uri=" + paramUri.getPath() + ", current account=" + localAppRuntime.getAccount());
    return null;
    if ((this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProvider$ReadInJoyDBHelper == null) || (!this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProvider$ReadInJoyDBHelper.f.equals(str2)))
    {
      this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProvider$ReadInJoyDBHelper = new ReadInJoyDataProvider.ReadInJoyDBHelper(this, localAppRuntime.getApplication().getApplicationContext(), str1);
      this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProvider$ReadInJoyDBHelper.f = str2;
    }
    if (paramBoolean) {
      return this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProvider$ReadInJoyDBHelper.getReadableDatabase();
    }
    return this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProvider$ReadInJoyDBHelper.getWritableDatabase();
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return -1;
    }
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 2002: 
    default: 
      return 0;
    case 2000: 
      return localSQLiteDatabase.delete("subscribe_msg_records", paramString, paramArrayOfString);
    case 2001: 
      localSQLiteDatabase.execSQL("DELETE from notify_msg_records;");
      return 0;
    case 2003: 
      return localSQLiteDatabase.delete("feeds_msg_records", paramString, paramArrayOfString);
    }
    return localSQLiteDatabase.delete("common_records", paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null)
    {
      paramUri = null;
      return paramUri;
    }
    long l1;
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 2002: 
    default: 
      l1 = -1L;
    }
    while (l1 == -1L)
    {
      return null;
      l1 = localSQLiteDatabase.insert("subscribe_msg_records", null, paramContentValues);
      continue;
      l1 = localSQLiteDatabase.insert("notify_msg_records", null, paramContentValues);
      continue;
      l1 = localSQLiteDatabase.insert("feeds_msg_records", null, paramContentValues);
      continue;
      l1 = localSQLiteDatabase.insert("common_records", null, paramContentValues);
    }
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentUriMatcher = new UriMatcher(-1);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "subscribe_msg_records", 2000);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "notify_msg_records", 2001);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "recent_data", 2002);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "feeds_msg_records", 2003);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "common_records", 2004);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, true);
    if (localSQLiteDatabase == null) {
      return null;
    }
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 2002: 
    default: 
      return null;
    case 2000: 
      return localSQLiteDatabase.query("subscribe_msg_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, paramUri.getQueryParameter("limit"));
    case 2001: 
      return localSQLiteDatabase.query("notify_msg_records", null, null, null, null, null, "msgID DESC", null);
    case 2003: 
      return localSQLiteDatabase.query("feeds_msg_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
    }
    return localSQLiteDatabase.query("common_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return -1;
    }
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    default: 
      return 0;
    case 2003: 
      return localSQLiteDatabase.update("feeds_msg_records", paramContentValues, paramString, paramArrayOfString);
    }
    return localSQLiteDatabase.update("common_records", paramContentValues, paramString, paramArrayOfString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\readinjoy\content\ReadInJoyDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */