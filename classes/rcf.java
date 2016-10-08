import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SecurityUtile;

class rcf
  extends SQLiteCursor
{
  rcf(rce paramrce, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    super(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public byte[] getBlob(int paramInt)
  {
    return SecurityUtile.a(super.getBlob(paramInt));
  }
  
  public String getString(int paramInt)
  {
    String str1 = super.getString(paramInt);
    try
    {
      String str2 = SecurityUtile.a(str1, false);
      return str2;
    }
    catch (Exception localException) {}
    return str1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */