import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.startup.step.MigrateSubscribeDB;

public class uty
  extends SQLiteOpenHelper
{
  public uty(MigrateSubscribeDB paramMigrateSubscribeDB, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */