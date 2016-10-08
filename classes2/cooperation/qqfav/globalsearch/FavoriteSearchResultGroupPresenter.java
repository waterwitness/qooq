package cooperation.qqfav.globalsearch;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.presenter.IFacePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter;
import com.tencent.mobileqq.util.FaceDecoder;

public class FavoriteSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public FavoriteSearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder)
  {
    return new FavoriteSearchResultPresenter(paramFaceDecoder);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqfav\globalsearch\FavoriteSearchResultGroupPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */