import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchActivity.SearchAsociatedWordAdapter;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.lebasearch.SearchResultAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class hjb
  implements SearchProtocol.SearchObserver
{
  public hjb(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SearchProtocol.WordItem paramWordItem) {}
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt == 0) && (paramArrayList != null)) {}
    for (;;)
    {
      paramArrayList.add(0, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      if (this.a.jdField_a_of_type_ComTencentWidgetXListView.a() == null)
      {
        paramArrayList = new SearchActivity.SearchAsociatedWordAdapter(this.a, paramArrayList);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramArrayList);
      }
      for (;;)
      {
        this.a.c(3);
        return;
        if ((this.a.jdField_a_of_type_ComTencentWidgetXListView.a() instanceof HeaderViewListAdapter)) {
          ((SearchActivity.SearchAsociatedWordAdapter)((HeaderViewListAdapter)this.a.jdField_a_of_type_ComTencentWidgetXListView.a()).getWrappedAdapter()).a(paramArrayList);
        } else {
          ((SearchActivity.SearchAsociatedWordAdapter)this.a.jdField_a_of_type_ComTencentWidgetXListView.a()).a(paramArrayList);
        }
      }
      paramArrayList = localArrayList;
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSearch", 2, "hot words size: " + paramList.size());
      }
      this.a.jdField_a_of_type_JavaUtilList = paramList;
      SearchActivity.a(this.a, true);
    }
  }
  
  public void a(int paramInt, JSONArray paramJSONArray)
  {
    this.a.a(false);
    if ((paramInt == 0) && (paramJSONArray != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSearch", 2, "results: " + paramJSONArray.toString());
      }
      if (paramJSONArray.length() == 0) {
        break label237;
      }
      if (this.a.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter != null) {
        break label223;
      }
      this.a.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter = new SearchResultAdapter(this.a, this.a.app, this.a.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager, paramJSONArray, this.a);
      this.a.b.setAdapter(this.a.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter);
      this.a.b.post(new hjc(this));
      SearchActivity.a(this.a, paramJSONArray);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Long != 0L) {
        StatisticCollector.a(BaseApplicationImpl.a()).a(this.a.app.a(), "LebaSearchCostTime", true, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, 0L, null, "", false);
      }
      this.a.jdField_a_of_type_Long = 0L;
      this.a.c(2);
      this.a.a(paramInt);
      return;
      label223:
      this.a.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter.a(paramJSONArray);
      break;
      label237:
      this.a.a(-1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */