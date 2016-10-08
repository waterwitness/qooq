import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class rcg
  implements DatabaseErrorHandler
{
  private DefaultDatabaseErrorHandler jdField_a_of_type_AndroidDatabaseDefaultDatabaseErrorHandler;
  
  public rcg(QQEntityManagerFactory paramQQEntityManagerFactory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidDatabaseDefaultDatabaseErrorHandler = new DefaultDatabaseErrorHandler();
  }
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory.TAG, 2, "[SQLiteDatabaseCorruptException]Corruption reported by sqlite on database: " + paramSQLiteDatabase.getPath());
    }
    MessageCache.i();
    Object localObject1 = BaseApplicationImpl.a().a();
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject2 = (QQAppInterface)localObject1;
      ((QQAppInterface)localObject2).a().getSharedPreferences("acc_info" + ((QQAppInterface)localObject2).getAccount(), 0).edit().putBoolean("isFriendlistok", false).commit();
      QLog.e(this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory.TAG, 1, "cleared friendlist flag");
    }
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = ((QQAppInterface)localObject1).a().getDatabasePath(((QQAppInterface)localObject1).getAccount() + ".db");
      if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L) && (SystemUtil.a()) && (SystemUtil.a() > ((File)localObject2).length()))
      {
        localObject1 = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
        if (((File)localObject1).exists()) {}
      }
    }
    for (;;)
    {
      try
      {
        long l1 = FileUtils.a((File)localObject2, (File)localObject1, 0, (int)((File)localObject2).length());
        long l2 = ((File)localObject2).length();
        if (l2 == l1)
        {
          bool = true;
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_ROM", DeviceInfoUtil.j());
          ((HashMap)localObject1).put("isCopySucc", String.valueOf(bool));
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actSqliteDatabaseCorrupt", true, -1L, 0L, (HashMap)localObject1, null, false);
          this.jdField_a_of_type_AndroidDatabaseDefaultDatabaseErrorHandler.onCorruption(paramSQLiteDatabase);
          return;
        }
        boolean bool = false;
        continue;
        bool = false;
      }
      catch (IOException localIOException)
      {
        ((File)localObject1).delete();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */