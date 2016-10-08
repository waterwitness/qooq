import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.PgcSearchActivity;
import com.tencent.biz.qqstory.pgc.adapter.SearchResultAdapter;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.util.List;

public class ikc
  extends QQStoryObserver
{
  public ikc(PgcSearchActivity paramPgcSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList1, boolean paramBoolean2, String paramString, List paramList2)
  {
    if (paramBoolean1)
    {
      if (paramList1.size() != 0)
      {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.b(paramList1);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a(paramList2);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a(this.a.jdField_a_of_type_JavaLangString);
        if (!paramBoolean2) {
          this.a.a(paramString);
        }
        StoryReportor.a("search", "effect", this.a.jdField_a_of_type_Int + 2, 0, new String[0]);
        return;
      }
      if (this.a.jdField_a_of_type_JavaLangString.equals(""))
      {
        PgcSearchActivity.a(this.a).setVisibility(0);
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        return;
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a();
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("未搜索到相关结果");
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      StoryReportor.a("search", "invalid", this.a.jdField_a_of_type_Int + 2, 0, new String[0]);
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText("搜索失败，请重试");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a(this.a.jdField_a_of_type_ComTencentWidgetXListView, paramBoolean2, paramInt, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */