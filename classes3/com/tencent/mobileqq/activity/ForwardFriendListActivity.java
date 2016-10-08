package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoMagicStickUtils;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.ViewTag;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final String e = "extra_choose_friend";
  public static final String f = "extra_add_special_friend";
  public static final String g = "extra_choose_friend_uin";
  public static final String h = "extra_choose_friend_name";
  public static final String i = "key_is_from_friendsforward_activity";
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ForwardSelectionFriendListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private PinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
  private TextView b;
  private TextView c;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int e;
  
  public ForwardFriendListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    b();
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131298283));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setContentBackground(2130837958);
    View localView = LayoutInflater.from(getActivity()).inflate(2130904932, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
    localView.findViewById(2131300876).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131300895);
    localEditText.setFocusable(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.a(localView);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("extra_choose_friend", 0);
  }
  
  private void a(int paramInt)
  {
    int j = 561243;
    if (paramInt == 11) {
      j = 561245;
    }
    for (;;)
    {
      ContactSearchComponentActivity.a(this, null, paramInt, 1, j);
      return;
      if (paramInt == 6) {
        j = 561244;
      } else if (paramInt == 16) {
        j = 561251;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296895));
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mNeedStatusTrans))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296896));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("选择好友");
    this.c = ((TextView)findViewById(2131297083));
    if (this.e == 2) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.b = ((TextView)findViewById(2131297391));
      this.b.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131367262);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription("取消");
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297392));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
      IphoneTitleBarActivity.setLayerType(this.b);
      return;
      this.c.setVisibility(0);
      this.c.setOnClickListener(this);
      this.c.setText(2131367975);
    }
  }
  
  private void c()
  {
    a();
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e()) {
      return false;
    }
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d();
    ArrayList localArrayList2 = new ArrayList();
    QQAppInterface localQQAppInterface;
    if (this.jdField_d_of_type_Int == 1)
    {
      localObject = new Groups();
      if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      {
        ForwardSelectionFriendListAdapter.a(1003);
        ((Groups)localObject).group_id = ForwardSelectionFriendListAdapter.b();
        ((Groups)localObject).group_name = "最近联系人";
        localArrayList2.add(0, localObject);
        localArrayList2.addAll(localArrayList1);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null) {
        break label190;
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
      localQQAppInterface = this.app;
      if (this.jdField_d_of_type_Int != 1) {
        break label185;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter = new ForwardSelectionFriendListAdapter(this, (ExpandableListView)localObject, localQQAppInterface, localArrayList2, this);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter);
      return true;
      ForwardSelectionFriendListAdapter.a(0);
      ((Groups)localObject).group_id = ForwardSelectionFriendListAdapter.b();
      break;
      label185:
      localArrayList2 = localArrayList1;
    }
    label190:
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
    if (this.jdField_d_of_type_Int == 1) {}
    for (;;)
    {
      ((ForwardSelectionFriendListAdapter)localObject).a(localArrayList2, true);
      break;
      localArrayList2 = localArrayList1;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          SearchUtils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
          return;
        } while (paramIntent == null);
        paramIntent = paramIntent.getStringExtra("contactSearchResultUin");
        localObject = new Intent(this, QQSpecialFriendSettingActivity.class);
        ((Intent)localObject).putExtra("key_friend_uin", paramIntent);
        ((Intent)localObject).putExtra("key_is_from_friendsforward_activity", true);
        startActivity((Intent)localObject);
        return;
      } while (paramIntent == null);
      localObject = new Intent();
      ((Intent)localObject).putExtras(getIntent().getExtras());
      ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
      ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultName"));
      setResult(-1, (Intent)localObject);
      finish();
      return;
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().getString("EditImagePath");
    } while (paramIntent == null);
    Object localObject = this.app.getAccount();
    String str1 = this.app.b();
    String str2 = this.app.a(false, (String)localObject);
    if ((getIntent().getFlags() & 0x2000000) == 33554432) {
      QLog.e("qqBaseActivity", 2, "contain FLAG_ACTIVITY_FORWARD_RESULT Flag");
    }
    PhotoMagicStickUtils.a(paramIntent, this, true, 4, (String)localObject, str1, str2);
    overridePendingTransition(2130968620, 2130968621);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.e = getIntent().getIntExtra("extra_add_special_friend", 0);
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    super.setContentView(2130903363);
    a();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter.b();
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter((PinnedHeaderExpandableListView.ExpandableListAdapter)null);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.e == 2) {
      overridePendingTransition(2130968583, 2130968584);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      localObject = (ForwardSelectionFriendListAdapter.ViewTag)paramView.getTag();
      if (localObject != null)
      {
        localObject = ((ForwardSelectionFriendListAdapter.ViewTag)localObject).a;
        if ((localObject != null) && ((localObject instanceof Friends)))
        {
          localObject = (Friends)localObject;
          if (((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3)) || (localObject == null)) {
            break label298;
          }
          if (this.e != 2) {
            break label245;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject).uin) == null) {
            break;
          }
          QQToast.a(this, getString(2131371053), 0).b(getTitleBarHeight());
        }
      }
      return;
    case 2131300895: 
      if (this.jdField_d_of_type_Int == 1)
      {
        a(11);
        return;
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        a(16);
        return;
      }
      a(6);
      return;
    case 2131297083: 
      finish();
      return;
    case 2131297183: 
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(false);
        com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
      }
      setResult(1);
      finish();
      return;
    }
    paramView = new Intent(this, QQSpecialFriendSettingActivity.class);
    paramView.putExtra("key_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("key_is_from_friendsforward_activity", true);
    startActivity(paramView);
    return;
    label245:
    paramView = new Intent();
    paramView.putExtras(getIntent().getExtras());
    paramView.putExtra("extra_choose_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("extra_choose_friend_name", ((Friends)localObject).name);
    setResult(-1, paramView);
    finish();
    return;
    label298:
    paramView = (TextView)paramView.findViewById(2131297741);
    if (paramView != null) {
      if (paramView.getText() != null) {
        paramView = paramView.getText().toString();
      }
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", ((Friends)localObject).uin);
      localBundle.putInt("uintype", 0);
      localBundle.putString("uinname", paramView);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
      return;
      paramView = null;
      continue;
      paramView = "Ta";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ForwardFriendListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */