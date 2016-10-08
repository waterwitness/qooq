import android.database.sqlite.SQLiteDatabase;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class hxx
  implements Runnable
{
  public hxx(ReadInJoyLogicEngine paramReadInJoyLogicEngine, int paramInt, long paramLong1, long paramLong2, EntityManager paramEntityManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject5 = null;
    Object localObject1 = String.format(Locale.CHINA, "delete from %s where mRecommendSeq not in ( select mRecommendSeq from %s where mChannelID = %d order by mRecommendSeq desc limit %d ) and mRecommendTime < %d  and mChannelID = %d ", new Object[] { ArticleInfo.TABLE_NAME, ArticleInfo.TABLE_NAME, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(10), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_Int) });
    QLog.d(ArticleInfoModule.a, 2, "delete sql is : " + (String)localObject1 + ", nowTime : " + this.b);
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((String)localObject1)) {
      QLog.d(ArticleInfoModule.a, 2, "delete main outdate article fail !");
    }
    for (;;)
    {
      return;
      Object localObject4 = localObject6;
      Object localObject3 = localObject7;
      try
      {
        localObject1 = ReadInJoyUtils.a();
        localObject4 = localObject6;
        localObject3 = localObject7;
        File localFile = BaseApplicationImpl.a().getDatabasePath("readinjoy_" + (String)localObject1 + ".db");
        localObject1 = localObject5;
        if (localFile != null)
        {
          localObject4 = localObject6;
          localObject3 = localObject7;
          if (localFile.exists()) {
            break label231;
          }
        }
        for (localObject1 = localObject5; localObject1 == null; localObject1 = SQLiteDatabase.openDatabase(localFile.getAbsolutePath(), null, 0))
        {
          localObject4 = localObject1;
          localObject3 = localObject1;
          QLog.d(ArticleInfoModule.a, 2, "delete plugin outdate article fial ! error : no db file ");
          return;
          label231:
          localObject4 = localObject6;
          localObject3 = localObject7;
        }
        localObject4 = localObject1;
        localObject3 = localObject1;
        int i = ((SQLiteDatabase)localObject1).delete(ArticleInfo.TABLE_NAME, String.format(Locale.CHINA, "mRecommendSeq not in ( select mRecommendSeq from %s where mChannelID = %d order by mRecommendSeq desc limit %d ) and mRecommendTime < %d  and mChannelID = %d ", new Object[] { ArticleInfo.TABLE_NAME, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(10), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_Int) }), null);
        localObject4 = localObject1;
        localObject3 = localObject1;
        QLog.d(ArticleInfoModule.a, 2, "delete plugin outdate article successful ! count : " + i);
        return;
      }
      catch (Exception localException)
      {
        localObject3 = localObject4;
        localException.printStackTrace();
        localObject3 = localObject4;
        QLog.d(ArticleInfoModule.a, 2, "delete plugin outdate article fial, error : " + localException.toString());
        return;
      }
      finally
      {
        if (localObject3 != null) {
          ((SQLiteDatabase)localObject3).close();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */