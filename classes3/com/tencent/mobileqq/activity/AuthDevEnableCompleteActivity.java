package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import klf;

public class AuthDevEnableCompleteActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "from_login";
  public static final String b = "phone_num";
  public static final String c = "country_code";
  public static final String d = "auth_dev_open";
  public static final String e = "allow_set";
  public static final String f = "user_guide";
  public static final String g = "user_uin";
  public static final String h = "seq";
  public static final String i = "DevlockInfo";
  private static final String j = "devlock.AuthDevEnableCompleteActivity";
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private String k;
  
  public AuthDevEnableCompleteActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private View a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " parameter is Wrong!");
      }
      return null;
    }
    View localView = getLayoutInflater().inflate(2130904153, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " view initialization failed!");
      }
      return null;
    }
    localView.setOnClickListener(new klf(this));
    ImageView localImageView = (ImageView)localView.findViewById(2131296831);
    TextView localTextView1 = (TextView)localView.findViewById(2131296829);
    TextView localTextView2 = (TextView)localView.findViewById(2131301584);
    TextView localTextView3 = (TextView)localView.findViewById(2131297124);
    if ((localImageView == null) || (localTextView1 == null) || (localTextView2 == null) || (localTextView3 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "some controls are invalide!");
      }
      return null;
    }
    localImageView.setVisibility(0);
    localTextView1.setText(paramString1);
    localTextView2.setText(getString(2131370762));
    localTextView3.setText(paramString2);
    return localView;
  }
  
  private void a()
  {
    super.setContentView(2130904148);
    setTitle(2131370700);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301571));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301570));
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "one or more controls is null in AuthDevEnableCompleteActivity! ");
      }
      return;
    }
    Object localObject1 = (TextView)findViewById(2131297083);
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList = EquipmentLockImpl.a().a();
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int n = 0;
    int m = 0;
    Object localObject2;
    boolean bool1;
    label171:
    boolean bool2;
    for (;;)
    {
      if (n < i1)
      {
        localObject2 = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(n);
        if (localObject2 == null)
        {
          n += 1;
        }
        else if ((((DeviceLockItemInfo)localObject2).c == 1) || (((DeviceLockItemInfo)localObject2).c == 2))
        {
          bool1 = true;
          if (((((DeviceLockItemInfo)localObject2).jdField_a_of_type_ArrayOfByte == null) || (!((DeviceLockItemInfo)localObject2).jdField_a_of_type_ArrayOfByte.equals(NetConnInfoCenter.GUID))) && (((DeviceLockItemInfo)localObject2).c != 1)) {
            break label346;
          }
          ((DeviceLockItemInfo)localObject2).jdField_a_of_type_Boolean = true;
          bool2 = false;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      localObject1 = a(((DeviceLockItemInfo)localObject2).jdField_a_of_type_JavaLangString, ((DeviceLockItemInfo)localObject2).b, bool1, bool2, ((DeviceLockItemInfo)localObject2).jdField_a_of_type_Boolean);
      if (localObject1 != null)
      {
        ((DeviceLockItemInfo)localObject2).d = m;
        m += 1;
        localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131296824);
        if (i1 == 1) {
          ((RelativeLayout)localObject2).setBackgroundResource(2130838349);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          break;
          bool1 = false;
          break label171;
          if (m == 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130838357);
          } else if (n == i1 - 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130838352);
          } else {
            ((RelativeLayout)localObject2).setBackgroundResource(2130838355);
          }
        }
        try
        {
          EquipmentLockImpl.a().a(null, this.app.a(), 10);
          return;
        }
        catch (Exception localException)
        {
          return;
        }
      }
      break;
      label346:
      bool2 = true;
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301571: 
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "click confirm mobile phone button! ");
      }
      break;
    }
    try
    {
      EquipmentLockImpl.a().a(null, this.app.a(), 11);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
      {
        int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
        int m = 0;
        if (m < i1)
        {
          paramView = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          int n = paramView.d;
          View localView;
          if (n >= 0)
          {
            localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(n);
            if (localView != null) {
              break label138;
            }
          }
          for (;;)
          {
            m += 1;
            break;
            label138:
            if (((ImageView)localView.findViewById(2131296831)).getVisibility() == 0) {}
            for (n = 1;; n = 0)
            {
              if (n == 0) {
                break label182;
              }
              if (paramView.c != 0) {
                break;
              }
              paramView.c = 3;
              break;
            }
            label182:
            paramView.c = 0;
          }
        }
      }
      EquipmentLockImpl.a().a(this.app, this.jdField_a_of_type_JavaUtilArrayList);
      paramView = new Intent(this, AuthDevActivity.class);
      paramView.putExtra("auth_dev_open", true);
      if (this.k != null)
      {
        paramView.putExtra("country_code", this.jdField_a_of_type_Int);
        paramView.putExtra("phone_num", this.k);
      }
      startActivity(paramView);
      overridePendingTransition(0, 2130968593);
      EquipmentLockImpl.a().d();
      finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "onClick right cancel button! ");
      }
      finish();
      overridePendingTransition(0, 2130968593);
      return;
    }
    catch (Exception paramView)
    {
      for (;;) {}
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.k = ((Bundle)localObject).getString("phone_num");
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("country_code");
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "on Create AuthDevEnableCompleteActivity！");
    }
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AuthDevEnableCompleteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */