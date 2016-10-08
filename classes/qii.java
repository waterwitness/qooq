import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qii
  implements Runnable
{
  public qii(RecentUserCache paramRecentUserCache, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "filterErrorData | start");
    }
    try
    {
      int i = RecentUserCache.a(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).a().a("recent", "_id=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "filterErrorData | RecentUser delCount = " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "filterErrorData | delete recommend error~");
      }
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "filterErrorData | end");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */