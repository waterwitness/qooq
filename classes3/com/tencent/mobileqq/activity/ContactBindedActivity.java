package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import lay;

public class ContactBindedActivity
  extends BaseActivity
  implements NewFriendManager.INewFriendListener
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindedAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private TextView b;
  
  public ContactBindedActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a();
  }
  
  public void a(int paramInt) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904111);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296895));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131301443));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367582);
    setTitle(getString(2131367582));
    this.b = ((TextView)findViewById(2131297083));
    this.b.setVisibility(0);
    this.b.setText(2131367975);
    this.b.setOnClickListener(new lay(this));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter = new ContactBindedAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.app.getManager(33));
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.a(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ContactBindedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */