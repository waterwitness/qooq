import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.t9search.T9SearchResultAdapter;
import com.tencent.mobileqq.t9search.T9SearchableData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oyb
  extends AsyncTask
{
  long jdField_a_of_type_Long;
  long b;
  
  private oyb(RecentT9SearchActivity paramRecentT9SearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected List a(String... paramVarArgs)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramVarArgs[0])) {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentT9SearchActivity.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentT9SearchActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          T9SearchableData localT9SearchableData = (T9SearchableData)localIterator.next();
          localT9SearchableData.a(paramVarArgs[0], paramVarArgs[1]);
          if (localT9SearchableData.k != 0) {
            localArrayList.add(localT9SearchableData);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected void a(List paramList)
  {
    super.onPostExecute(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentT9SearchActivity.jdField_a_of_type_ComTencentMobileqqT9searchT9SearchResultAdapter.a(paramList, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentT9SearchActivity.c);
    this.b = System.currentTimeMillis();
    long l1 = this.b;
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("T9_TIME_TAG", 2, "SearchTask|搜索过程耗时 search duration:" + (l1 - l2));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */