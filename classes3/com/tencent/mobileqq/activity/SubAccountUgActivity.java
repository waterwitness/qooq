package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mnx;
import mnz;
import moa;
import mob;
import moc;
import mod;
import mqq.os.MqqHandler;

public class SubAccountUgActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener, Observer
{
  public static final int a = 1980;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public boolean b;
  
  public SubAccountUgActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = "";
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new mnx(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new moa(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new mob(this);
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
          paramSubAccountControll.a(this.app, this, localPair, new mnz(this, paramSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    View localView = findViewById(2131305062);
    TextView localTextView1 = (TextView)findViewById(2131305059);
    TextView localTextView2 = (TextView)findViewById(2131305060);
    ImageView localImageView = (ImageView)findViewById(2131305057);
    ((Button)findViewById(2131305061)).setText(2131370505);
    localView.setVisibility(8);
    localTextView1.setText(2131370494);
    localTextView2.setVisibility(8);
    localImageView.setImageResource(2130843360);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = getIntent().getStringExtra("subAccount");
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(60);
    this.jdField_a_of_type_Boolean = localSubAccountManager.a(this.b);
    boolean bool1 = false;
    paramBundle = SubAccountControll.a(this.app, this.b);
    boolean bool2;
    if (paramBundle != null)
    {
      bool2 = ((Boolean)paramBundle.first).booleanValue();
      bool1 = ((Boolean)paramBundle.second).booleanValue();
    }
    for (;;)
    {
      if (bool1)
      {
        SubAccountAssistantForward.a(this.app, this, this.b);
        finish();
        return false;
      }
      super.setContentView(2130905023);
      setTitle(2131370492);
      findViewById(2131296895).setOnClickListener(this);
      ImageView localImageView2 = (ImageView)findViewById(2131305058);
      ImageView localImageView1 = (ImageView)findViewById(2131305057);
      TextView localTextView1 = (TextView)findViewById(2131305059);
      TextView localTextView2 = (TextView)findViewById(2131305060);
      Button localButton = (Button)findViewById(2131305061);
      View localView = findViewById(2131305062);
      Object localObject = this.app.a(this.app.getAccount(), false);
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = ImageUtil.a();
      }
      localImageView2.setImageBitmap(paramBundle);
      localTextView1.setTextColor(getResources().getColor(2131428262));
      localTextView2.setVisibility(8);
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        if (!bool2) {
          break label629;
        }
        paramBundle = localSubAccountManager.a(this.b);
        if (paramBundle == null) {
          break label623;
        }
        i = ((Integer)paramBundle.first).intValue();
        if (i != 0) {
          switch (i)
          {
          default: 
            i = 0;
          }
        }
      }
      for (;;)
      {
        int j = i;
        if (i == 0) {
          j = 2131370496;
        }
        localTextView1.setTextColor(getResources().getColor(2131428262));
        paramBundle = this.app.a(this.b, false);
        if (paramBundle != null) {
          localImageView1.setImageBitmap(paramBundle);
        }
        localObject = ContactUtils.c(this.app, this.b, true);
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (((String)localObject).length() != 0) {}
        }
        else
        {
          paramBundle = this.b;
        }
        localTextView1.setText(getString(j, new Object[] { paramBundle }));
        if (j == 2131370496)
        {
          localTextView2.setVisibility(0);
          label458:
          localButton.setText(2131370506);
          localView.setVisibility(0);
          ((Button)localView.findViewById(2131305063)).setOnClickListener(this);
          ((Button)localView.findViewById(2131305065)).setOnClickListener(this);
        }
        for (;;)
        {
          localButton.setOnClickListener(this);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          e();
          this.app.a().addObserver(this);
          this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
          return true;
          i = 2131370543;
          break;
          i = 2131370541;
          break;
          i = 2131370542;
          break;
          i = 2131370543;
          break;
          i = 2131370543;
          break;
          i = 2131370496;
          break;
          localTextView2.setVisibility(8);
          break label458;
          localImageView1.setImageResource(2130843360);
        }
        label623:
        i = 0;
        break;
        label629:
        i = 0;
      }
      bool2 = false;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.a(getClass());
    this.app.a().deleteObserver(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void e()
  {
    if (this.leftView != null)
    {
      Object localObject = this.app.a();
      if (localObject == null) {
        break label102;
      }
      int i = ((QQMessageFacade)localObject).e();
      if (i > 0)
      {
        localObject = Integer.toString(i);
        if (i > 99) {
          localObject = "99+";
        }
        this.leftView.setText(getString(2131367566) + "(" + (String)localObject + ")");
      }
    }
    else
    {
      return;
    }
    this.leftView.setText(getString(2131367566));
    return;
    label102:
    this.leftView.setText(getString(2131367566));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131305062: 
    case 2131305064: 
    default: 
      return;
    case 2131305061: 
      Intent localIntent = new Intent();
      if (this.jdField_a_of_type_Boolean)
      {
        localIntent.putExtra("is_need_bind", false);
        localIntent.putExtra("subuin", this.b);
        localIntent.setClass(this, SubLoginActivity.class);
        localIntent.putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
        startActivity(localIntent);
        return;
      }
      localIntent.setClass(paramView.getContext(), SubAccountBindActivity.class);
      localIntent.putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
      startActivity(localIntent);
      return;
    case 2131305063: 
      paramView = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
      paramView.a(2131370523);
      paramView.a(getResources().getString(2131370516), 3);
      paramView.d(2131367262);
      paramView.a(new moc(this, paramView));
      paramView.show();
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.b);
    paramView.putExtra("reqType", 3);
    paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
    startActivity(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new mod(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SubAccountUgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */