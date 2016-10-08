import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.List;

public class qzr
  implements ConditionSearchManager.ISearchListener
{
  public qzr(SearchResultActivity paramSearchResultActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    int i = 1;
    if (paramInt == 3) {
      if (!paramBoolean1)
      {
        this.a.b = 3;
        this.a.jdField_a_of_type_Qzt.notifyDataSetChanged();
      }
    }
    while (paramInt != 2)
    {
      return;
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      paramList = this.a;
      if (paramBoolean2) {}
      for (paramInt = i;; paramInt = 0)
      {
        paramList.b = paramInt;
        break;
      }
    }
    if (paramBoolean1)
    {
      ThreadPriorityManager.a(true);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.jdField_a_of_type_JavaUtilList.clear();
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      this.a.jdField_a_of_type_Qzt.notifyDataSetChanged();
      ThreadPriorityManager.a(false);
      SearchResultActivity.a(this.a).a(0);
      paramList = Message.obtain();
      paramList.what = 5;
      SearchResultActivity.a(this.a).sendMessageDelayed(paramList, 1000L);
      return;
    }
    SearchResultActivity.a(this.a).a(1);
    paramList = Message.obtain();
    paramList.what = 4;
    SearchResultActivity.a(this.a).sendMessageDelayed(paramList, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */