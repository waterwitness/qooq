package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class GroupNetSearchModelArticle
  implements ISearchResultGroupModel
{
  private SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private String b;
  
  public GroupNetSearchModelArticle(SearchResult paramSearchResult, List paramList, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = paramSearchResult;
    this.b = paramString2;
  }
  
  public int a()
  {
    return 2;
  }
  
  public String a()
  {
    return "相关文章";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localGroupNetSearchModelArticleItem != null) && (!TextUtils.isEmpty(this.b)))
    {
      Intent localIntent = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      localIntent.putExtra("url", this.b);
      paramView.getContext().startActivity(localIntent);
      if (localGroupNetSearchModelArticleItem.a() != null)
      {
        paramView = localGroupNetSearchModelArticleItem.a().hotword.get();
        int i = localGroupNetSearchModelArticleItem.a().hotword_type.get();
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localGroupNetSearchModelArticleItem.b(), paramView, String.valueOf(i), "2");
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.jdField_a_of_type_JavaLangString, "0");
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupNetSearchModelArticle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */