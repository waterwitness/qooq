package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class GroupNetSearchModelPublicAcntItem
  implements ISearchResultModel
{
  private static final String jdField_a_of_type_JavaLangString = "GroupNetSearchModelPublicAcntItem";
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String b;
  
  public GroupNetSearchModelPublicAcntItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    this.b = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int a()
  {
    return 1;
  }
  
  public CharSequence a()
  {
    return SearchUtils.a(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get(), this.b);
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity)))
    {
      PublicView.a((QQAppInterface)((BaseActivity)localContext).getAppRuntime(), localContext, this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.class_index.get(), String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get()), String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get()), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_flag.get(), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get(), 4);
      SearchUtils.a(this.b, 70, 0, paramView);
      SearchUtils.a(this.b, 70, paramView, false);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return null;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("name = ").append(this.jdField_a_of_type_JavaLangCharSequence).append(", isCert = ");
      if ((!this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.has()) || (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.flag.get() != 1L)) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("GroupNetSearchModelPublicAcntItem", 2, bool);
      if ((!this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.flag.has()) || (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.flag.get() != 1L)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public CharSequence c()
  {
    return "网络搜索";
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupNetSearchModelPublicAcntItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */