import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class qij
  implements Runnable
{
  public qij(RecentUserCache paramRecentUserCache, SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | start");
    }
    Object localObject1 = null;
    label384:
    for (;;)
    {
      synchronized (RecentUserCache.a(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache))
      {
        Iterator localIterator = RecentUserCache.b(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).values().iterator();
        if (localIterator.hasNext())
        {
          Entity localEntity = (Entity)localIterator.next();
          if ((localEntity == null) || (!AppConstants.an.equals(((RecentUser)localEntity).uin))) {
            break label384;
          }
          localObject1 = (RecentUser)localEntity;
          break label384;
        }
      }
      try
      {
        ??? = RecentUserCache.b(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).a();
        if (localObject1 != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache.a((Entity)localObject1);
          if (RecentUserCache.c(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).containsKey(localObject1)) {
            RecentUserCache.d(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).remove(localObject1);
          }
        }
        int i = ((SQLiteDatabase)???).a("recent", "uin=?", new String[] { AppConstants.an });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | RecentUser delCount = " + i);
        }
        i = ((SQLiteDatabase)???).a(ConversationInfo.getConversationInfoTableName(), "uin=?", new String[] { AppConstants.an });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | conversationinfo delCount = " + i);
        }
        i = ((SQLiteDatabase)???).a(MessageRecord.getTableName(AppConstants.an, 4000), "frienduin=?", new String[] { AppConstants.an });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | MessageRecord.RecommendMsg delCount = " + i);
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localException.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | delete recommend error~");
        return;
      }
      finally
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("check_newfriend_when_upgrade", false).commit();
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */