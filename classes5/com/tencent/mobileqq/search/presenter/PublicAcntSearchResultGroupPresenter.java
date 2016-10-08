package com.tencent.mobileqq.search.presenter;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;

public class PublicAcntSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public PublicAcntSearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder)
  {
    return new PublicAcntSearchResultPresenter(paramFaceDecoder);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\PublicAcntSearchResultGroupPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */