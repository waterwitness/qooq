package cooperation.readinjoy.content;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.TableBuilder;

public class ReadInJoyDataProvider$ReadInJoyDBHelper
  extends SQLiteOpenHelper
{
  private static final int jdField_a_of_type_Int = 84;
  public static final String a = "ReadInJoyDBHelper";
  public static final String b = "subscribe_msg_records";
  public static final String c = "notify_msg_records";
  public static final String d = "feeds_msg_records";
  public static final String e = "common_records";
  private static final String g = "readinjoy_main_";
  public String f;
  
  public ReadInJoyDataProvider$ReadInJoyDBHelper(ReadInJoyDataProvider paramReadInJoyDataProvider, Context paramContext, String paramString)
  {
    super(paramContext, "readinjoy_main_" + paramString, null, 84);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = "";
    this.f = paramString;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if ((paramString.equals("subscribe_msg_records")) || (paramString.equals("notify_msg_records"))) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "msgID" + " INTEGER UNIQUE NOT NULL, " + "subscribeID" + " TEXT NOT NULL, " + "msgURL" + " TEXT NOT NULL, " + "msgContent" + " TEXT NOT NULL, " + "msgTime" + " INTEGER NOT NULL, " + "bindUin" + " INTEGER NOT NULL);");
    }
    while (!paramString.equals("feeds_msg_records")) {
      return;
    }
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "pushTime" + " INTEGER NOT NULL, " + "notifyType" + " INTEGER NOT NULL, " + "feedsOwner" + " INTEGER NOT NULL, " + "feedsID" + " INTEGER NOT NULL, " + "feedsSubject" + " TEXT DEFAULT '', " + "deleteUin" + " INTEGER NOT NULL, " + "publishFail" + " INTEGER NOT NULL, " + "likeUin" + " INTEGER NOT NULL, " + "commentUin" + " INTEGER NOT NULL, " + "commentID" + " VARCHAR(32) DEFAULT '', " + "replyUin" + " INTEGER NOT NULL, " + "replyID" + " VARCHAR(32) DEFAULT '', " + "commentInfo" + " TEXT DEFAULT '', " + "isDelete" + " INTEGER DEFAULT 0, " + "processSeq" + " INTEGER DEFAULT 0, " + "receiveTime" + " INTEGER NOT NULL);");
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if ("common_records".equalsIgnoreCase(paramString)) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "common_version" + " INTEGER NOT NULL, " + "common_key" + " TEXT DEFAULT '', " + "common_content" + " TEXT DEFAULT '');");
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase, "subscribe_msg_records");
    a(paramSQLiteDatabase, "notify_msg_records");
    a(paramSQLiteDatabase, "feeds_msg_records");
    b(paramSQLiteDatabase, "common_records");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 80)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a("subscribe_msg_records"));
      paramSQLiteDatabase.execSQL(TableBuilder.a("notify_msg_records"));
      a(paramSQLiteDatabase, "subscribe_msg_records");
      a(paramSQLiteDatabase, "notify_msg_records");
    }
    if (paramInt1 < 81) {
      a(paramSQLiteDatabase, "feeds_msg_records");
    }
    for (;;)
    {
      if (paramInt1 < 84) {
        b(paramSQLiteDatabase, "common_records");
      }
      return;
      if (paramInt1 < 82) {
        paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s %s;", new Object[] { "feeds_msg_records", "isDelete", "INTEGER DEFAULT 0" }));
      }
      if (paramInt1 < 83) {
        paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s %s;", new Object[] { "feeds_msg_records", "processSeq", "INTEGER DEFAULT 0" }));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\readinjoy\content\ReadInJoyDataProvider$ReadInJoyDBHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */