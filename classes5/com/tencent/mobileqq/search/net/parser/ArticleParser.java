package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticle;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticleItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class ArticleParser
  extends BaseParser
{
  String a;
  
  public ArticleParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  ISearchResultGroupModel a(SearchResult paramSearchResult, List paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem;
    if (paramList != null)
    {
      localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)paramList.get(0);
      if ((localGroupNetSearchModelArticleItem != null) && (localGroupNetSearchModelArticleItem.a() != null))
      {
        String str = localGroupNetSearchModelArticleItem.a().hotword.get();
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localGroupNetSearchModelArticleItem.b(), str, String.valueOf(localGroupNetSearchModelArticleItem.a().hotword_type.get()), "");
      }
      if ((localGroupNetSearchModelArticleItem == null) || (localGroupNetSearchModelArticleItem.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localGroupNetSearchModelArticleItem != null) && (localGroupNetSearchModelArticleItem.a() != null)) {
        ReportController.b(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localGroupNetSearchModelArticleItem.a().account_id.get()));
      }
      SearchStatisticsConstants.a(110);
      this.a = paramString2;
      return new GroupNetSearchModelArticle(paramSearchResult, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)paramList.get(1);
      } else {
        localGroupNetSearchModelArticleItem = null;
      }
    }
  }
  
  ISearchResultModel a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new GroupNetSearchModelArticleItem(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  ISearchResultModel a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new GroupNetSearchModelArticleItem(paramrecord, paramString, paramCharSequence);
  }
  
  String a()
  {
    return "相关文章";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\net\parser\ArticleParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */