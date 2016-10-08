import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileEntitySearchResultModel;
import com.tencent.mobileqq.filemanager.data.search.FileSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.FileSearchResultPresenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sbg
  extends BaseMvpFaceAdapter
{
  public sbg(FileSearchFragment paramFileSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder, List paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramList.size() == 1)
    {
      paramFileSearchFragment = (FileEntitySearchResultModel)paramList.get(0);
      if (paramFileSearchFragment.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramListView = new ArrayList();
        paramFaceDecoder = paramFileSearchFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFaceDecoder.hasNext())
        {
          paramList = (FileManagerEntity)paramFaceDecoder.next();
          paramString = new FileEntitySearchResultModel();
          paramString.jdField_a_of_type_JavaLangString = paramFileSearchFragment.jdField_a_of_type_JavaLangString;
          paramString.jdField_a_of_type_JavaUtilList.add(paramList);
          paramListView.add(paramString);
        }
        a(paramListView);
        return;
      }
    }
    a(paramList);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new FileSearchResultPresenter(FileSearchFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2130904952);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */