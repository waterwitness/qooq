package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class GroupNetSearchModelArticleItem
  implements ISearchResultModel
{
  private static final String jdField_a_of_type_JavaLangString = "GroupNetSearchModelArticleItem";
  private AccountSearchPb.hotwordrecord jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public GroupNetSearchModelArticleItem(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = paramhotwordrecord;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence1;
    this.c = paramString2;
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence2;
  }
  
  public GroupNetSearchModelArticleItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int a()
  {
    return 0;
  }
  
  public AccountSearchPb.hotwordrecord a()
  {
    return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
  }
  
  public AccountSearchPb.record a()
  {
    return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_b_of_type_JavaLangString, 110, 0, paramView);
    Intent localIntent = new Intent(paramView.getContext(), PublicAccountBrowser.class);
    Object localObject = paramView.getContext();
    if ((localObject != null) && ((localObject instanceof GroupSearchActivity)))
    {
      localObject = (GroupSearchActivity)localObject;
      if (GroupSearchActivity.e == 1) {
        localIntent.putExtra("articalChannelId", 10);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord == null) {
        break label197;
      }
      localIntent.putExtra("url", this.c);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, b(), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "1");
    }
    for (;;)
    {
      paramView.getContext().startActivity(localIntent);
      if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) {
        ReportController.b(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "", this.jdField_b_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get()));
      }
      return;
      if (GroupSearchActivity.e != 2) {
        break;
      }
      localIntent.putExtra("articalChannelId", 11);
      break;
      label197:
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get());
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    return "来自：网络搜索";
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.has()) {
        localObject1 = this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
      }
    }
    return (CharSequence)localObject1;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
      return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
    }
    return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupNetSearchModelArticleItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */