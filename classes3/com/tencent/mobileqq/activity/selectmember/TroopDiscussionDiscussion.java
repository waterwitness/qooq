package com.tencent.mobileqq.activity.selectmember;

import android.os.Bundle;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2.DiscussionListListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;

public class TroopDiscussionDiscussion
  extends TroopDiscussionBaseV
  implements DiscussionListAdapter2.DiscussionListListener
{
  private DiscussionListAdapter2 jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public TroopDiscussionDiscussion(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    a(2130904987);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299813));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131427379);
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 = new DiscussionListAdapter2(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2);
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    Bundle localBundle;
    if (paramDiscussionInfo != null)
    {
      localBundle = new Bundle();
      localBundle.putString("group_uin", paramDiscussionInfo.uin);
      localBundle.putString("group_name", paramDiscussionInfo.discussionName);
      if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a instanceof PhoneContactSelectActivity)) {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3, localBundle);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, localBundle);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a();
  }
  
  public void b(Bundle paramBundle) {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\TroopDiscussionDiscussion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */