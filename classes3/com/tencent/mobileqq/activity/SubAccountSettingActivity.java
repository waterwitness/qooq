package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import mnp;
import mnq;
import mns;
import mnt;
import mnu;
import mnv;
import mnw;
import mqq.os.MqqHandler;

public class SubAccountSettingActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener
{
  public static final int a = 1985;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver;
  private SubAccountInfo jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public SubAccountSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "Q.subaccount.SubAccountSettingActivity";
    this.jdField_a_of_type_MqqOsMqqHandler = new mnp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new mnq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new mns(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mnw(this);
  }
  
  private void a(SubAccountControll paramSubAccountControll, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + paramString);
    }
    if ((paramSubAccountControll == null) || (paramString == null) || (paramString.length() <= 4)) {}
    for (;;)
    {
      return;
      if ((isResume()) && (SubAccountControll.a(this.app, paramString)))
      {
        a();
        paramString = paramSubAccountControll.a(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)paramString.get(i);
          paramSubAccountControll.a(this.app, this, localPair, new mnt(this, paramSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
  
  private void d()
  {
    setTitle(2131370512);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131305078));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305079));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305080));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131305081);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131305082));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131305083));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131305084));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)) {
        break label66;
      }
      localObject = new Intent(this, SubAccountUgActivity.class);
      ((Intent)localObject).putExtra("subAccount", this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
      ((Intent)localObject).putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
      startActivity((Intent)localObject);
      finish();
    }
    label66:
    do
    {
      return;
      localObject = ContactUtils.c(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, false);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)))) {
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname = ((String)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    } while ((this.app == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)));
    Object localObject = FaceDrawable.a(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130905028);
    paramBundle = getIntent().getStringExtra("subAccount");
    this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = ((SubAccountManager)this.app.getManager(60)).a(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "doOnCreate() mSubAccountInfo is null.");
      }
      a(this.app.a().getString(2131370534));
      return true;
    }
    d();
    e();
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.a(getClass());
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    switch (paramView.getId())
    {
    case 2131305083: 
    default: 
      return;
    case 2131305082: 
      localActionSheet.a(2131370517);
      localActionSheet.a(2131367263, 3);
      localActionSheet.d(2131367262);
      localActionSheet.a(new mnu(this, localActionSheet));
      localActionSheet.show();
      return;
    case 2131305084: 
      localActionSheet.a(2131370518);
      localActionSheet.a(2131370516, 3);
      localActionSheet.d(2131367262);
      localActionSheet.a(new mnv(this, localActionSheet));
      localActionSheet.show();
      return;
    }
    SubAccountAssistantForward.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    finish();
    SubAccountAssistantForward.f(this.app);
    FrameHelperActivity.n();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SubAccountSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */