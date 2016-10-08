package com.dataline.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XListView;
import i;
import j;
import k;
import l;
import m;
import n;
import p;

public class DLRouterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static String a;
  private final View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new l(this);
  public ViewGroup a;
  private final AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new m(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public FrameLayout a;
  public GridView a;
  public ImageButton a;
  public ScrollerRunnable a;
  public XListView a;
  public n a;
  private boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  private String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "dataline.DLRouterActivity";
  }
  
  private void a(boolean paramBoolean)
  {
    new Handler().postDelayed(new k(this, paramBoolean), 0L);
  }
  
  void a(Intent paramIntent)
  {
    if (paramIntent != null) {
      if (55 == paramIntent.getIntExtra(AlbumConstants.i, -1))
      {
        paramIntent.removeExtra(AlbumConstants.i);
        DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.app.a(51)).a(Long.parseLong(this.b));
        if ((localDeviceInfo == null) || (localDeviceInfo.userStatus == 20)) {
          break label129;
        }
        new p(this, null).execute(new Intent[] { paramIntent });
      }
    }
    for (;;)
    {
      if (paramIntent.getExtras() != null) {
        this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isBack2Root", false);
      }
      if (this.leftView.getText().toString().equals(super.getString(2131367578))) {
        this.jdField_a_of_type_Boolean = false;
      }
      return;
      label129:
      FMToastUtil.a(2131362322);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("unbind_flag", false)));
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Intent localIntent = super.getIntent();
    this.b = localIntent.getStringExtra("uin");
    this.d = localIntent.getStringExtra("uinname");
    this.c = localIntent.getStringExtra("account");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "din:" + this.b);
    }
    super.getWindow().setBackgroundDrawableResource(2131427369);
    super.setContentView(2130903269);
    super.setTitle(this.d);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)super.findViewById(2131297940));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296449, "n/a");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131297942));
    paramBundle = super.getResources().getDrawable(2130843209);
    if ((paramBundle instanceof BitmapDrawable)) {
      paramBundle = ((BitmapDrawable)paramBundle).getBitmap();
    }
    for (;;)
    {
      paramBundle = new BitmapDrawable(paramBundle);
      if (paramBundle != null)
      {
        paramBundle.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBundle.setDither(true);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(paramBundle);
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)super.findViewById(2131297943));
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_N = new n(this, null);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_N);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297875));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131297941));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131297412));
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-5855578);
      this.jdField_a_of_type_AndroidWidgetEditText.setText("暂不支持文字消息");
      this.jdField_a_of_type_AndroidWidgetEditText.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      DeviceLib.a(this, this.jdField_a_of_type_AndroidWidgetEditText);
      a(true);
      this.rightViewImg.setImageResource(2130843168);
      this.rightViewImg.setContentDescription(getResources().getText(2131362135));
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(new i(this));
      paramBundle = (RouterHandler)this.app.a(48);
      paramBundle.a(this.b);
      paramBundle.a = new RouterSessionAdapter(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297878));
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramBundle.a);
      View localView = LayoutInflater.from(super.getActivity()).inflate(2130903206, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(super.getActivity().getResources().getDrawable(2130840536));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(localView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new j(this));
      a(localIntent);
      paramBundle.a.notifyDataSetChanged();
      return true;
      if ((paramBundle instanceof SkinnableBitmapDrawable)) {
        paramBundle = ((SkinnableBitmapDrawable)paramBundle).getBitmap();
      } else {
        paramBundle = null;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    RouterHandler localRouterHandler = (RouterHandler)this.app.a(48);
    localRouterHandler.a = null;
    localRouterHandler.b(this.b);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    ((SmartDeviceProxyMgr)this.app.a(51)).f();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.a);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297941) {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8) {
        break label30;
      }
    }
    label30:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\DLRouterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */