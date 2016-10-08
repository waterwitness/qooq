package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.GroupNetSearchModelTroop;
import com.tencent.mobileqq.search.model.GroupNetSearchModelTroopItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class TroopParser
  extends BaseParser
{
  public TroopParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  ISearchResultGroupModel a(SearchResult paramSearchResult, List paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    SearchStatisticsConstants.a(80);
    return new GroupNetSearchModelTroop(paramSearchResult, paramList, paramString1, paramBoolean);
  }
  
  ISearchResultModel a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return null;
  }
  
  ISearchResultModel a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new GroupNetSearchModelTroopItem(paramrecord, paramString, paramCharSequence);
  }
  
  String a()
  {
    return "群";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\net\parser\TroopParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */