import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rce
  implements SQLiteDatabase.CursorFactory
{
  private rce(QQEntityManagerFactory paramQQEntityManagerFactory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    return new rcf(this, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */