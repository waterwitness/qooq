package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import luz;
import lva;
import lve;
import lvf;
import lvg;
import lvh;

public class ModifyFriendInfoActivity
  extends IphoneTitleBarActivity
{
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 2;
  private static final int d = 1000;
  public int a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public String a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private View jdField_b_of_type_AndroidViewView;
  public TextView b;
  public String b;
  private View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  public String d;
  
  public ModifyFriendInfoActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.d = "";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new luz(this);
    this.jdField_a_of_type_AndroidOsHandler = new lvf(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new lvg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new lvh(this);
  }
  
  private void b()
  {
    ThreadManager.a(new lve(this), null, true);
  }
  
  private void c()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = this.centerView;
    this.rightViewText.setText(2131368729);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298464));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297704));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298462);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298465);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131298468);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    ThreadManager.a(new lva(this), null, true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        if ((paramInt2 == -1) && (paramInt1 == 1000))
        {
          if (NetworkUtil.e(this))
          {
            paramIntent = paramIntent.getStringExtra("result");
            if ((paramIntent == null) || (paramIntent.length() == 0))
            {
              localQQAppInterface1 = this.app;
              localQQAppInterface2 = this.app;
              ((FriendListHandler)localQQAppInterface1.a(1)).b(this.jdField_a_of_type_JavaLangString);
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText(paramIntent);
            QQAppInterface localQQAppInterface1 = this.app;
            QQAppInterface localQQAppInterface2 = this.app;
            ((FriendListHandler)localQQAppInterface1.a(1)).a(this.jdField_a_of_type_JavaLangString, paramIntent, false);
            return;
          }
          Toast.makeText(this.app.a(), getString(2131368804), 1).show();
          return;
        }
      } while (paramInt1 != 0);
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((FriendsManager)this.app.getManager(50)).a(String.valueOf(paramInt1));
    } while (paramIntent == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent.group_name);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903407);
    setContentBackgroundResource(2130837958);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uinname");
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.trim().length() == 0)) {}
    for (paramBundle = this.jdField_a_of_type_JavaLangString;; paramBundle = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle;
      setTitle(2131369390);
      this.mDensity = getResources().getDisplayMetrics().density;
      b();
      a();
      c();
      return;
    }
  }
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131367527);
    this.rightViewText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.rightViewText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return this.rightViewText;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ModifyFriendInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */