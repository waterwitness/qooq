package com.tencent.mobileqq.nearby;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.GiftMessageUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.VersionUtils;

public class NearbyFlowerInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, URLDrawable.URLDrawableListener
{
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  TextView c;
  TextView d;
  TextView e;
  
  public NearbyFlowerInfoActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = true;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903418);
    Bundle localBundle = getIntent().getBundleExtra("data");
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("isSend", false);
    String str1;
    label75:
    String str8;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = localBundle.getString("rNick");
      if (!this.jdField_a_of_type_Boolean) {
        break label211;
      }
      paramBundle = localBundle.getString("rUin");
      this.jdField_a_of_type_JavaLangString = paramBundle;
      str8 = localBundle.getString("bgPic");
      if (!this.jdField_a_of_type_Boolean) {
        break label222;
      }
    }
    String str6;
    String str7;
    String str5;
    String str3;
    String str4;
    label211:
    label222:
    for (String str2 = localBundle.getString("rInfo");; str2 = localBundle.getString("sInfo"))
    {
      str6 = localBundle.getString("fPic");
      str7 = localBundle.getString("cover");
      str5 = localBundle.getString("fMean");
      str3 = localBundle.getString("cMean");
      str4 = localBundle.getString("cMeanPostfix");
      this.jdField_b_of_type_JavaLangString = localBundle.getString("groupCode");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4))) {
        break label233;
      }
      finish();
      return true;
      str1 = localBundle.getString("sNick");
      break;
      paramBundle = localBundle.getString("sUin");
      break label75;
    }
    label233:
    Object localObject;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = localBundle.getString("gScore");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      paramBundle = "共获得" + paramBundle + "礼物点";
      localStringBuilder = new StringBuilder();
      if (!this.jdField_a_of_type_Boolean) {
        break label893;
      }
      localObject = "对方";
      label308:
      localStringBuilder.append((String)localObject).append(paramBundle);
      if (!this.jdField_a_of_type_Boolean) {
        break label901;
      }
      paramBundle = "送花详情";
      label330:
      setTitle(paramBundle);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131297969);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131298518);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298519));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298520));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298521));
      this.c = ((TextView)findViewById(2131298522));
      this.d = ((TextView)findViewById(2131298523));
      this.e = ((TextView)findViewById(2131298524));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298525));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298526));
      localObject = (BounceScrollView)findViewById(2131298517);
      ((BounceScrollView)localObject).setVerticalScrollBarEnabled(false);
      if (VersionUtils.c()) {
        ((BounceScrollView)localObject).setOverScrollMode(1);
      }
      paramBundle = new ColorDrawable(-1);
      paramBundle = URLDrawable.getDrawable(String.format("http://sqimg.qq.com/qq_product_operations/flower/images/aio-bg/%s", new Object[] { str8 }), paramBundle, paramBundle);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramBundle);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setText("继续送花");
      }
      this.jdField_b_of_type_Boolean = localBundle.getBoolean("isFriend", false);
      int i = AIOUtils.a(3.0F, getResources());
      if (!this.jdField_b_of_type_Boolean) {
        break label908;
      }
      paramBundle = FaceDrawable.a(this.app, 3, this.jdField_a_of_type_JavaLangString);
      label593:
      paramBundle = GiftMessageUtils.a(paramBundle, i, -1, 1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramBundle);
      if (AppSetting.j)
      {
        paramBundle = new StringBuilder(str1);
        paramBundle.append(',').append(str2).append(',').append("按钮");
        this.jdField_b_of_type_AndroidViewView.setContentDescription(paramBundle.toString());
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      paramBundle = URLDrawable.getDrawable(String.format("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s", new Object[] { str7 }));
      paramBundle = URLDrawable.getDrawable(String.format("http://sqimg.qq.com/qq_product_operations/flower/images/f/%s", new Object[] { str6 }), paramBundle, paramBundle);
      paramBundle.setURLDrawableListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      this.c.setText(str5);
      paramBundle = new SpannableStringBuilder();
      if (TextUtils.isEmpty(str3)) {
        break label927;
      }
      paramBundle.append(str3);
      paramBundle.append(str4);
      paramBundle.setSpan(new ForegroundColorSpan(-104872), 0, str3.length(), 33);
    }
    for (;;)
    {
      this.d.setText(paramBundle);
      this.e.setText(localStringBuilder);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (AppSetting.j)
      {
        ((BounceScrollView)localObject).setContentDescription("收花详情");
        this.c.setFocusable(true);
        this.d.setFocusable(true);
        this.e.setFocusable(true);
      }
      return true;
      localObject = localBundle.getString("remark");
      paramBundle = (Bundle)localObject;
      if (localObject != null) {
        break;
      }
      paramBundle = "";
      break;
      label893:
      localObject = "你";
      break label308;
      label901:
      paramBundle = "收花详情";
      break label330;
      label908:
      paramBundle = FaceDrawable.a(this.app, 200, this.jdField_a_of_type_JavaLangString, 3);
      break label593;
      label927:
      paramBundle.append(str4);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidViewView) {
      if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        HotChatUtil.a(this, this.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Boolean) {
          break label131;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80060BD", "0X80060BD", 0, 0, "", "", "", "");
      }
    }
    Intent localIntent;
    label131:
    label360:
    do
    {
      for (;;)
      {
        return;
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 41);
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", paramView);
        localIntent.putExtra("param_mode", 3);
        startActivity(localIntent);
        break;
        ReportController.b(this.app, "CliOper", "", "", "0X80060BE", "0X80060BE", 0, 0, "", "", "", "");
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
          break label360;
        }
        localIntent = null;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/received_list.html?_wv=2147347&visit=owner&sourceType=%d&ADTAG=%s&totalFlower=%d&_bid=2050&isfresh=%d", new Object[] { Integer.valueOf(1), "aio.m.r", Integer.valueOf(5), Integer.valueOf(1) });
        }
        while (!TextUtils.isEmpty(paramView))
        {
          localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("portraitOnly", true);
          localIntent.putExtra("url", paramView);
          startActivity(localIntent);
          return;
          paramView = localIntent;
          if (!TextUtils.isEmpty(Utils.a(this.app.a().k(this.jdField_a_of_type_JavaLangString)))) {
            if (Friends.isValidUin(this.jdField_a_of_type_JavaLangString))
            {
              paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/received_list.html?_wv=2147347&visit=owner&sourceType=%d&ADTAG=%s&totalFlower=%d&_bid=2050&isfresh=%d", new Object[] { Integer.valueOf(1), "aio.m.r", Integer.valueOf(5), Integer.valueOf(1) });
            }
            else
            {
              QQToast.a(this, 2131369645, 0).b(getTitleBarHeight());
              paramView = localIntent;
            }
          }
        }
      }
    } while (paramView != this.jdField_b_of_type_AndroidWidgetButton);
    if (this.jdField_a_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { NearbyURLSafeUtil.a(this.jdField_a_of_type_JavaLangString), "", Integer.valueOf(3), "aio.hotchat.m.s", this.jdField_b_of_type_JavaLangString });
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("url", paramView);
        startActivity(localIntent);
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X80060AE", "0X80060AE", 0, 0, "", "", "", "");
        return;
        paramView = Utils.a(this.app.a().k(this.jdField_a_of_type_JavaLangString));
        if (!TextUtils.isEmpty(paramView)) {
          if (Friends.isValidUin(this.jdField_a_of_type_JavaLangString))
          {
            paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { NearbyURLSafeUtil.a(this.jdField_a_of_type_JavaLangString), paramView.toLowerCase(), Integer.valueOf(1), "aio.m.s", "" });
            localIntent = new Intent(this, QQBrowserActivity.class);
            localIntent.putExtra("url", paramView);
            startActivity(localIntent);
          }
          else
          {
            QQToast.a(this, 2131371565, 0).b(getTitleBarHeight());
          }
        }
      }
    }
    if (Friends.isValidUin(this.jdField_a_of_type_JavaLangString))
    {
      paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/gift_mall.html?ADTAG=%s&_bid=2050&sourceType=%d&_handle=1&_wv=2147347&platId=1&qqVersion=%s", new Object[] { "aio.m.mall", Integer.valueOf(1), "6.5.5" });
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "0X80060C0", "0X80060C0", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this, 2131369645, 0).b(getTitleBarHeight());
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyFlowerInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */