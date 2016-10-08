import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;

public class ulb
  extends BaseMvpFaceAdapter
{
  public ulb(SelectMemberContactSearchFragment paramSelectMemberContactSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected IPresenter a(int paramInt)
  {
    return new ContactSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    if (SearchUtils.a(SelectMemberContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSelectMemberContactSearchFragment))) {
      return new ContactSearchResultView(paramViewGroup, 2130904946);
    }
    return new ContactSearchResultView(paramViewGroup, 2130904947);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */