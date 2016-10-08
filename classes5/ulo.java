import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class ulo
  implements View.OnLongClickListener
{
  public ulo(ContactSearchResultPresenter paramContactSearchResultPresenter, ISearchResultModel paramISearchResultModel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = new AlertDialog.Builder(paramView.getContext());
    paramView.setTitle("匹配详情");
    long l = ((IContactSearchModel)this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel).b();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = SearchConfigManager.contactSearchPinyinBaseBit;
    int j = SearchConfigManager.contactSearchPinyinBaseBit;
    localStringBuilder.append("拼音匹配：");
    localStringBuilder.append((Long.MAX_VALUE << i & l) >> j);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchRecentBaseBit;
    j = SearchConfigManager.contactSearchRecentBaseBit;
    int k = SearchConfigManager.contactSearchRecentBaseBit;
    localStringBuilder.append("最近联系人排序：");
    localStringBuilder.append((Long.MAX_VALUE >> 63 - (i + 10) & l & Long.MAX_VALUE << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchIndexBaseBit;
    j = SearchConfigManager.contactSearchIndexBaseBit;
    k = SearchConfigManager.contactSearchIndexBaseBit;
    localStringBuilder.append("字符串匹配度：");
    localStringBuilder.append((Long.MAX_VALUE >> 63 - (i + 8) & l & Long.MAX_VALUE << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchTypeBaseBit;
    j = SearchConfigManager.contactSearchTypeBaseBit;
    k = SearchConfigManager.contactSearchTypeBaseBit;
    localStringBuilder.append("数据类型：");
    localStringBuilder.append((Long.MAX_VALUE >> 63 - (i + 8) & l & Long.MAX_VALUE << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchFieldBaseBit;
    j = SearchConfigManager.contactSearchFieldBaseBit;
    k = SearchConfigManager.contactSearchFieldBaseBit;
    localStringBuilder.append("字段类型：");
    localStringBuilder.append((l & Long.MAX_VALUE >> 63 - (i + 8) & Long.MAX_VALUE << j) >> k);
    localStringBuilder.append('\n');
    paramView.setMessage(localStringBuilder.toString());
    paramView.create().show();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */