import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.pgc.PgcSearchActivity;
import com.tencent.biz.qqstory.pgc.adapter.SearchResultAdapter;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class ilg
  implements View.OnClickListener
{
  public ilg(SearchResultAdapter paramSearchResultAdapter, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity, PgcSearchActivity.class);
    paramView.putExtra("showTitleBar", false);
    paramView.putExtra("type", ((ili)this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b);
    paramView.putExtra("keyword", this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.startActivityForResult(paramView, 2);
    StoryReportor.a("search", "more", 0, ((ili)this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b, new String[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */