package cooperation.qqfav.globalsearch;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import cooperation.qqfav.QfavHelper;
import java.util.List;
import mqq.app.AppRuntime;

public class GroupSearchModelFavorite
  implements ISearchResultGroupModel
{
  public static final int c = 3;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  
  public GroupSearchModelFavorite(List paramList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 2;
  }
  
  public String a()
  {
    return "收藏";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
    FavoriteSearchActivity.a(localBaseActivity, this.jdField_a_of_type_JavaLangString);
    QfavHelper.b(localBaseActivity, localBaseActivity.getAppRuntime().getAccount(), 0L);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 60, 0, paramView);
  }
  
  public int b()
  {
    return 3;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqfav\globalsearch\GroupSearchModelFavorite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */