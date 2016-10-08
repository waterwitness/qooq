package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.ResultData;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import loq;
import lor;
import los;
import lot;
import lou;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class HongbaoShowerActivity
  extends BaseActivity
{
  public static final int a = 1000;
  public static final String a = "a_hb_type";
  public static final int b = 0;
  public static final String b = "a_hg_url";
  public static final int c = 1;
  public static final String c = "a_hb_task_id";
  public static final int d = 2;
  public static final String d = "a_hb_from";
  public static final String e = "a_hb_business_uin";
  private static final int f = 4;
  public static final String f = "money";
  public static final String g = "show_follow";
  private static final String h = "PortalManager.HongbaoShowerActivity";
  public long a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  View jdField_a_of_type_AndroidViewView;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  PortalManager.ResultData jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData;
  private SanHuaView jdField_a_of_type_ComTencentMobileqqPortalSanHuaView;
  boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView c;
  private TextView d;
  private int e;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  
  public HongbaoShowerActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private String a()
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.app.a());
    }
    return "";
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject3.put("amount", this.m);
        localJSONObject3.put("channel", 4);
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        str = this.n;
        localJSONObject3.put("mch_icon", str);
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        str = this.o;
        localJSONObject3.put("mch_top_img", str);
        localJSONObject3.put("wishing", this.p);
        localJSONObject3.put("send_name", this.k);
        localJSONObject2.put("detailinfo", localJSONObject3);
        localJSONObject1.put("extra_data", localJSONObject2);
        localJSONObject1.put("come_from", 2);
        localJSONObject1.put("viewTag", "graphb");
        localJSONObject1.put("userId", this.app.a());
        localJSONObject1.put("skey", a());
        localJSONObject1.put("key_type", 2);
      }
      catch (Exception localException)
      {
        String str;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HongbaoShowerActivity", 2, localJSONObject1.toString());
      }
      return localJSONObject1;
      str = "";
      continue;
      str = "";
    }
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301313));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new HongbaoShowerActivity.MyOvershotInterpolator(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new lot(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301312);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 0.7F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(350L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView = new SanHuaView(this, i1 / 2, i2 / 2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView.a(100);
  }
  
  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      paramImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("PortalManager.HongbaoShowerActivity", 2, "HongbaoLogo == null");
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HongbaoShowerActivity", 2, "showHongbaoResult mGiftUrl " + this.i);
    }
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, "当前网络不可用", 1).a();
    }
    while ((this.e != 0) && (this.i == null)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
      PublicAccountUtil.a(getAppInterface(), this, this.j, null, 113);
    }
    for (int i1 = 1;; i1 = 0)
    {
      switch (this.e)
      {
      default: 
        finish();
        return;
      case 0: 
        localObject2 = a();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("json", ((JSONObject)localObject2).toString());
        ((Bundle)localObject1).putString("callbackSn", "0");
        localObject2 = new Intent(this, PayBridgeActivity.class);
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ((Intent)localObject2).putExtra("pay_requestcode", 5);
        startActivity((Intent)localObject2);
        localObject2 = this.app;
        if (i1 != 0) {}
        for (localObject1 = "1";; localObject1 = "2")
        {
          ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X80060A3", "0X80060A3", 0, 0, "1", (String)localObject1, "", "");
          break;
        }
      }
      Object localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", this.i);
      ((Intent)localObject1).putExtra("hide_left_button", false);
      ((Intent)localObject1).putExtra("show_right_close_button", true);
      ((Intent)localObject1).putExtra("finish_animation_up_down", true);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).addFlags(67108864);
      startActivity((Intent)localObject1);
      setResult(-1);
      Object localObject2 = this.app;
      if (i1 != 0) {}
      for (localObject1 = "1";; localObject1 = "2")
      {
        ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X80060A3", "0X80060A3", 0, 0, "2", (String)localObject1, "", "");
        break;
      }
    }
  }
  
  private void c()
  {
    ThreadManager.c().postDelayed(new lou(this), 500L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    for (;;)
    {
      try
      {
        this.e = paramBundle.getIntExtra("a_hb_type", 0);
        this.i = getIntent().getStringExtra("a_hg_url");
        i1 = getIntent().getIntExtra("a_hb_task_id", -1);
        int i2;
        QLog.e("PortalManager.HongbaoShowerActivity", 2, "getExtra Exception", paramBundle);
      }
      catch (Exception paramBundle)
      {
        try
        {
          this.j = getIntent().getStringExtra("a_hb_business_uin");
          i2 = getIntent().getIntExtra("money", -1);
          if (i2 != -1) {
            this.m = String.valueOf(i2);
          }
          this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("show_follow", true);
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager.HongbaoShowerActivity", 1, 256 + i1 + ", " + this.e + ", " + this.i + ", " + this.m + ", " + getIntent().getIntExtra("a_hb_from", -1));
          }
          if ((i1 >= 0) && (this.e >= 0) && (this.e <= 2)) {
            break;
          }
          finish();
          return false;
        }
        catch (Exception paramBundle)
        {
          int i1;
          for (;;) {}
        }
        paramBundle = paramBundle;
        i1 = -1;
      }
      finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData = ((PortalManager)this.app.getManager(78)).a(this.e, i1);
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData == null)
    {
      finish();
      return false;
    }
    this.k = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.e;
    this.l = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.g;
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.jdField_a_of_type_AndroidGraphicsBitmap;
    this.n = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.c;
    this.o = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.d;
    this.p = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.jdField_f_of_type_JavaLangString;
    this.j = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.h;
    switch (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.jdField_f_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Boolean = true;
      i1 = 2130904086;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HongbaoShowerActivity", 1, "data.logoType = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.jdField_f_of_type_Int);
      }
      if (i1 != 0) {
        break;
      }
      return false;
      i1 = 2130904087;
      continue;
      i1 = 2130904086;
    }
    for (;;)
    {
      try
      {
        super.setContentView(i1);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301311));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new loq(this));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301317));
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.k);
        this.d = ((TextView)findViewById(2131301319));
        TextView localTextView = this.d;
        if (this.e == 0)
        {
          paramBundle = "立即领取";
          localTextView.setText(paramBundle);
          this.d.setOnClickListener(new lor(this));
          localTextView = (TextView)findViewById(2131301318);
          if (this.e != 0) {
            break label819;
          }
          paramBundle = "给你发了一个现金红包";
          localTextView.setText(paramBundle);
          if ((this.e == 0) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.jdField_f_of_type_Int == 1) && (!TextUtils.isEmpty(this.l)))
          {
            findViewById(2131301320).setVisibility(0);
            this.c = ((TextView)findViewById(2131301322));
            this.c.setText(this.l);
            this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131301321));
            if (!this.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
            }
          }
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301315));
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new los(this));
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.jdField_f_of_type_Int != 2) {
            break label826;
          }
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301324));
          if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
            this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
          }
          a();
          c();
          return true;
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        paramBundle.printStackTrace();
        finish();
        return false;
      }
      paramBundle = "立即查看";
      continue;
      label819:
      paramBundle = "给你发了一个礼包";
      continue;
      label826:
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData.jdField_f_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301316));
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
          a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\HongbaoShowerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */