import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.pgc.adapter.DiscoverAdapter;
import com.tencent.biz.qqstory.pgc.adapter.SearchResultAdapter;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.XListView;
import java.util.List;

public class ikn
  extends QQStoryObserver
{
  public ikn(QQStoryDiscoverActivity paramQQStoryDiscoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
    if (paramBoolean) {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter.a(paramList);
        this.a.c();
      }
    }
    for (;;)
    {
      if (this.a.jdField_b_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(paramBoolean);
      }
      this.a.jdField_b_of_type_Boolean = false;
      return;
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText("24小时内暂无频道更新日迹");
      continue;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter.getCount() == 0)
      {
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (NetworkUtil.h(this.a)) {
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText("加载失败\n请下拉刷新重试");
        } else {
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前网络不可用，请检查你的网络设置\n下拉刷新重试");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList1, boolean paramBoolean2, String paramString, List paramList2)
  {
    if (this.a.isFinishing()) {}
    while (paramInt != 2) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramList1.size() != 0)
      {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.b(paramList1);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a(this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a(paramList2);
        StoryReportor.a("search", "effect", 1, 0, new String[0]);
        return;
      }
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.a.jdField_a_of_type_JavaLangString.equals("")) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a();
        StoryReportor.a("search", "invalid", 1, 0, new String[0]);
        return;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("未搜索到相关结果");
      }
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText("搜索失败，请重试");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a(this.a.jdField_a_of_type_ComTencentWidgetXListView, paramBoolean2, paramInt, paramString);
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter.a(paramBoolean2, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */