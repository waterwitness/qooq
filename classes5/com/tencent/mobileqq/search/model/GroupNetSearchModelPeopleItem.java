package com.tencent.mobileqq.search.model;

import SummaryCard.SearchInfo;
import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class GroupNetSearchModelPeopleItem
  implements ISearchResultModel
{
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  
  public GroupNetSearchModelPeopleItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L) {
      return 1;
    }
    return 11;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L) {
      return String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
    }
    return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
  }
  
  public void a(View paramView)
  {
    SearchInfo localSearchInfo = new SearchInfo();
    localSearchInfo.lUIN = this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get();
    localSearchInfo.strNick = this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get();
    localSearchInfo.strMobile = this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
    localSearchInfo.bIsFriend = ((byte)(int)(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.relation.get() & 1L));
    localSearchInfo.bInContact = ((byte)(int)(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.relation.get() & 0x2));
    AddFriendActivity.a((Activity)paramView.getContext(), localSearchInfo, ((BaseActivity)paramView.getContext()).app.a(), null, true, 1);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, 0, paramView);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, paramView, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    StringBuilder localStringBuilder;
    if (this.b == null)
    {
      localStringBuilder = new StringBuilder().append("(");
      if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() == 0L) {
        break label78;
      }
    }
    label78:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());; str = this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get())
    {
      this.b = SearchUtils.a(str + ")", this.jdField_a_of_type_JavaLangString);
      return this.b;
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return "来自：网络查找";
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupNetSearchModelPeopleItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */