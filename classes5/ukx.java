import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.adapter.BaseMvpMessageAdapter;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;

public class ukx
  extends BaseMvpMessageAdapter
{
  public ukx(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder, paramSearchResultItem, paramString, paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected IPresenter a(int paramInt)
  {
    return new SearchResultPresenter(MessageSearchDetailFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2130904953);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ukx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */