import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.readinjoy.content.ReadInJoyDataProvider;
import cooperation.readinjoy.storage.ReadInJoyFeedsMsgRecord;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class qnt
  implements Runnable
{
  public qnt(ReadInJoyManager paramReadInJoyManager, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = ReadInJoyDataProvider.c.buildUpon();
    ((Uri.Builder)localObject1).appendQueryParameter("uin", ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).getAccount());
    localObject1 = ((Uri.Builder)localObject1).build();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label478:
    while (localIterator.hasNext())
    {
      ReadInJoyFeedsMsgRecord localReadInJoyFeedsMsgRecord = (ReadInJoyFeedsMsgRecord)localIterator.next();
      Object localObject2 = new HashSet(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).keySet()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        int i = ((Integer)((Iterator)localObject2).next()).intValue();
        int j = (int)NetConnInfoCenter.getServerTime();
        if ((i < j) && (j - i > 300)) {
          ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).remove(Integer.valueOf(i));
        }
      }
      if (!ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).containsValue(Integer.valueOf(localReadInJoyFeedsMsgRecord.h)))
      {
        ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).put(Integer.valueOf(localReadInJoyFeedsMsgRecord.g), Integer.valueOf(localReadInJoyFeedsMsgRecord.h));
        long l = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager);
        if ((localReadInJoyFeedsMsgRecord.i == 10) || (localReadInJoyFeedsMsgRecord.i == 11) || (localReadInJoyFeedsMsgRecord.i == 12) || (localReadInJoyFeedsMsgRecord.i == 999999)) {
          if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager, (Uri)localObject1, localReadInJoyFeedsMsgRecord, l)) {
            ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager);
          }
        }
        for (;;)
        {
          if (localReadInJoyFeedsMsgRecord.i == 999999) {
            break label478;
          }
          break;
          ContentValues localContentValues;
          if (localReadInJoyFeedsMsgRecord.i == 14)
          {
            localObject2 = String.format("%s = '%s' and %s = %d", new Object[] { "commentID", localReadInJoyFeedsMsgRecord.jdField_b_of_type_JavaLangString, "notifyType", Integer.valueOf(11) });
            localContentValues = new ContentValues();
            localContentValues.put("isDelete", Integer.valueOf(1));
            ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).a().getContentResolver().update((Uri)localObject1, localContentValues, (String)localObject2, null);
            ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager, (Uri)localObject1, localReadInJoyFeedsMsgRecord, l);
          }
          else if (localReadInJoyFeedsMsgRecord.i == 13)
          {
            localObject2 = String.format("%s = %s and %s = %d", new Object[] { "feedsID", Long.toString(localReadInJoyFeedsMsgRecord.jdField_b_of_type_Long), "notifyType", Integer.valueOf(10) });
            localContentValues = new ContentValues();
            localContentValues.put("isDelete", Integer.valueOf(1));
            ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).a().getContentResolver().update((Uri)localObject1, localContentValues, (String)localObject2, null);
            ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager, (Uri)localObject1, localReadInJoyFeedsMsgRecord, l);
          }
        }
      }
    }
    ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).a().getContentResolver().notifyChange(ReadInJoyDataProvider.c, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */