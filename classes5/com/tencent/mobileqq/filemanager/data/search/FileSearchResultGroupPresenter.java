package com.tencent.mobileqq.filemanager.data.search;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.presenter.IFacePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter;
import com.tencent.mobileqq.util.FaceDecoder;

public class FileSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  SearchResultGroupPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  
  public FileSearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder)
  {
    return new FileSearchResultPresenter(paramFaceDecoder);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\search\FileSearchResultGroupPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */