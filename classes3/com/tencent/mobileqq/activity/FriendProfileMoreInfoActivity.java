package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.widget.immersive.ImmersiveUtils;
import lnh;

public class FriendProfileMoreInfoActivity
  extends ProfileActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 1001;
  public static final String a = "param_switches_changed";
  public static final int b = -1;
  private static final String jdField_b_of_type_JavaLangString = "http://ti.qq.com/photowall/index.html?_wv=1027";
  protected View a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  private ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private boolean jdField_a_of_type_Boolean;
  protected Button b;
  protected TextView b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  protected Button c;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h;
  private int i;
  private int j;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private boolean n;
  private boolean o;
  
  public FriendProfileMoreInfoActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new lnh(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  private boolean a()
  {
    return (this.jdField_k_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_l_of_type_Boolean) || (this.jdField_m_of_type_Boolean) || (this.n);
  }
  
  private void b()
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, 2131369008, 0).b(getTitleBarHeight());
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = new Bundle();
      if (this.jdField_a_of_type_Boolean) {
        localBundle.putShort("key_interest_switch", (short)this.jdField_c_of_type_Int);
      }
      if (this.jdField_e_of_type_Boolean) {
        localBundle.putShort("key_joined_group_switch", (short)this.jdField_g_of_type_Int);
      }
      if (this.jdField_g_of_type_Boolean) {
        localBundle.putShort("key_ktv_switch", (short)this.i);
      }
      if (this.jdField_b_of_type_Boolean) {
        localBundle.putShort("key_music_switch", (short)this.jdField_d_of_type_Int);
      }
      if (this.jdField_c_of_type_Boolean) {
        localBundle.putShort("key_recent_activity_switch", (short)this.jdField_e_of_type_Int);
      }
      if (this.jdField_d_of_type_Boolean) {
        localBundle.putShort("key_star_switch", (short)this.jdField_f_of_type_Int);
      }
      if (this.jdField_k_of_type_Boolean) {
        localBundle.putShort("key_eat_switch", (short)this.j);
      }
      if (this.jdField_l_of_type_Boolean) {
        localBundle.putShort("key_reader_switch", (short)this.jdField_k_of_type_Int);
      }
      if (this.jdField_m_of_type_Boolean) {
        localBundle.putShort("key_radio_switch", (short)this.jdField_l_of_type_Int);
      }
      if (this.jdField_f_of_type_Boolean) {
        localBundle.putShort("key_now_switch", (short)this.h);
      }
      if (this.n) {
        localBundle.putShort("key_comic_switch", (short)this.jdField_m_of_type_Int);
      }
    } while (localBundle.size() <= 0);
    ((CardHandler)this.app.a(2)).b(localBundle);
    a(getString(2131371670));
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      if (paramIntent.hasExtra("param_interest_switch")) {
        this.jdField_c_of_type_Int = paramIntent.getIntExtra("param_interest_switch", 0);
      }
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("param_interest_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_music_switch")) {
        this.jdField_d_of_type_Int = paramIntent.getIntExtra("param_music_switch", 0);
      }
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("param_music_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_recent_activity_switch")) {
        this.jdField_e_of_type_Int = paramIntent.getIntExtra("param_recent_activity_switch", 0);
      }
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("param_recent_activity_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_star_switch")) {
        this.jdField_f_of_type_Int = paramIntent.getIntExtra("param_star_switch", 0);
      }
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("param_star_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_joined_group_switch")) {
        this.jdField_g_of_type_Int = paramIntent.getIntExtra("param_joined_group_switch", 0);
      }
      if (!this.jdField_e_of_type_Boolean) {
        this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("param_joined_group_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_now_switch")) {
        this.h = paramIntent.getIntExtra("param_now_switch", 0);
      }
      if (!this.jdField_f_of_type_Boolean) {
        this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("param_now_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_ktv_switch")) {
        this.i = paramIntent.getIntExtra("param_ktv_switch", 0);
      }
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("param_ktv_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_eat_switch")) {
        this.j = paramIntent.getIntExtra("param_eat_switch", 0);
      }
      if (!this.jdField_k_of_type_Boolean) {
        this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("param_eat_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_reader_switch")) {
        this.jdField_k_of_type_Int = paramIntent.getIntExtra("param_reader_switch", 0);
      }
      if (!this.jdField_l_of_type_Boolean) {
        this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("param_reader_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_radio_switch")) {
        this.jdField_l_of_type_Int = paramIntent.getIntExtra("param_radio_switch", 0);
      }
      if (!this.jdField_m_of_type_Boolean) {
        this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("param_radio_switch_changed", false);
      }
      if (paramIntent.hasExtra("param_comic_switch")) {
        this.jdField_m_of_type_Int = paramIntent.getIntExtra("param_comic_switch", 0);
      }
      if (!this.n) {
        this.n = paramIntent.getBooleanExtra("param_comic_switch_changed", false);
      }
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean) || (this.jdField_m_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.n)) {
        b();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904295);
    setContentBackgroundResource(2130837958);
    paramBundle = (LinearLayout)super.findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131302229);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302231));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131302232));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131302233));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131302204));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.o = getIntent().getBooleanExtra("DynamicAvatarTips", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramBundle = FaceDrawable.a(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368747);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131367975);
    return true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131302229: 
    case 2131302232: 
    case 2131302233: 
    case 2131297083: 
      do
      {
        return;
        paramView = new Intent(this, AvatarPendantActivity.class);
        paramView.putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        paramView.putExtra("DynamicAvatarTips", this.o);
        paramView.putExtra("showActionSheet", true);
        startActivity(paramView);
        return;
        paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
        paramView.putExtra("hide_more_button", true);
        paramView.putExtra("hide_operation_bar", true);
        paramView.putExtra("url", "http://ti.qq.com/photowall/index.html?_wv=1027");
        paramView.putExtra("leftViewText", getString(2131366637));
        startActivity(paramView);
        return;
        ProfileCardUtil.a(this.app.a(), this.app, this);
        return;
      } while (isFinishing());
      finish();
      return;
    }
    paramView = new Intent(this, InterestSwitchEditActivity.class);
    if (-1 != this.j) {
      paramView.putExtra("param_eat_switch", this.j);
    }
    if (-1 != this.jdField_c_of_type_Int) {
      paramView.putExtra("param_interest_switch", this.jdField_c_of_type_Int);
    }
    if (-1 != this.jdField_g_of_type_Int) {
      paramView.putExtra("param_joined_group_switch", this.jdField_g_of_type_Int);
    }
    if (-1 != this.h) {
      paramView.putExtra("param_now_switch", this.h);
    }
    if (-1 != this.i) {
      paramView.putExtra("param_ktv_switch", this.i);
    }
    if (-1 != this.jdField_d_of_type_Int) {
      paramView.putExtra("param_music_switch", this.jdField_d_of_type_Int);
    }
    if (-1 != this.jdField_e_of_type_Int) {
      paramView.putExtra("param_recent_activity_switch", this.jdField_e_of_type_Int);
    }
    if (-1 != this.jdField_f_of_type_Int) {
      paramView.putExtra("param_star_switch", this.jdField_f_of_type_Int);
    }
    if (-1 != this.jdField_k_of_type_Int) {
      paramView.putExtra("param_reader_switch", this.jdField_k_of_type_Int);
    }
    if (-1 != this.jdField_l_of_type_Int) {
      paramView.putExtra("param_radio_switch", this.jdField_l_of_type_Int);
    }
    if (-1 != this.jdField_m_of_type_Int) {
      paramView.putExtra("param_comic_switch", this.jdField_m_of_type_Int);
    }
    startActivityForResult(paramView, 1001);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\FriendProfileMoreInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */