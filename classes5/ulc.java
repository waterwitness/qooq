import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsentity.BaseMvpFTSEntityAdapter;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment;
import com.tencent.mobileqq.search.presenter.FTSMessageSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;
import java.util.List;

public class ulc
  extends BaseMvpFTSEntityAdapter
{
  public ulc(FTSEntitySearchDetailFragment paramFTSEntitySearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, List paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramFaceDecoder, paramList, paramString, paramFTSEntitySearchDetailActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected IPresenter a(int paramInt)
  {
    return new FTSMessageSearchResultPresenter(FTSEntitySearchDetailFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FTSMessageSearchResultView(paramViewGroup, 2130904949);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */