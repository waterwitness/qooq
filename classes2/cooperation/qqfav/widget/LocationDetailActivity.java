package cooperation.qqfav.widget;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import ygv;
import ygw;
import ygx;
import ygy;

public class LocationDetailActivity
  extends PoiMapActivity
{
  public static final int D = 13321;
  public static final int E = 13322;
  public static final String v = "forNewFavorite";
  public long a;
  private FadeIconImageView a;
  public ImageView g;
  public TextView g;
  public String w;
  public String x;
  private boolean x;
  public String y;
  public String z;
  
  public LocationDetailActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = -1L;
  }
  
  private void y()
  {
    if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968738);
      localAnimation.setAnimationListener(new ygv(this));
      this.jdField_g_of_type_AndroidWidgetTextView.startAnimation(localAnimation);
      return;
    }
    if (TextUtils.isEmpty(this.z))
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    if (VersionUtils.e()) {
      this.jdField_g_of_type_AndroidWidgetTextView.setAlpha(0.9F);
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setText(new QQText(this.z, 3, 22));
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = b(this);
    Intent localIntent = new Intent(c(this));
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("modify", paramBoolean);
    localIntent.putExtra("favId", this.jdField_a_of_type_Long);
    localIntent.putExtra("note", this.z);
    localIntent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = localIntent.getStringExtra("pluginsdk_selfuin");
    if (paramBoolean) {}
    for (int i = 13322;; i = 13321)
    {
      QfavHelper.a(this, (String)localObject, localIntent, i);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if ((paramInt1 != 103) || (paramIntent == null)) {
        break label51;
      }
    }
    for (;;)
    {
      if ((this.jdField_g_of_type_AndroidWidgetImageView != null) && (13322 != paramInt1) && (103 != paramInt1)) {
        this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      return;
      label51:
      if (13321 == paramInt1)
      {
        super.finish();
      }
      else if ((13322 == paramInt1) && (paramIntent != null))
      {
        this.z = paramIntent.getStringExtra("note");
        y();
      }
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(0, new Intent());
    if (this.jdField_g_of_type_AndroidWidgetImageView != null) {
      this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(null);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    y();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f = super.getResources().getDisplayMetrics().density;
      this.jdField_g_of_type_AndroidWidgetTextView = new TextView(paramBundle.getContext());
      this.jdField_g_of_type_AndroidWidgetTextView.setId(2131296539);
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundResource(2130838312);
      this.jdField_g_of_type_AndroidWidgetTextView.setMaxLines(3);
      int i = (int)(15.0F * f);
      this.jdField_g_of_type_AndroidWidgetTextView.setPadding(i, i, i, i);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131428262));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_g_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = ((int)(f * 50.0F) + ImmersiveUtils.a(this));
      localLayoutParams.gravity = 48;
      paramBundle.addView(this.jdField_g_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    this.z = super.getIntent().getStringExtra("note");
    this.p = true;
    if (this.l != null) {
      this.l.setVisibility(8);
    }
    y();
  }
  
  public void onStart()
  {
    super.overridePendingTransition(0, 0);
    super.onStart();
  }
  
  protected void s()
  {
    Bundle localBundle = super.getIntent().getExtras();
    this.y = localBundle.getString("loc");
    this.w = localBundle.getString("lat");
    this.jdField_x_of_type_JavaLangString = localBundle.getString("lon");
    this.jdField_a_of_type_Long = localBundle.getLong("favId");
    TextView localTextView1 = (TextView)findViewById(2131297083);
    localTextView1.setText(2131365889);
    localTextView1.setOnClickListener(new ygw(this));
    ((TextView)super.findViewById(2131297139)).setText(2131365940);
    TextView localTextView2 = (TextView)super.findViewById(2131297183);
    if (!localBundle.getBoolean("forNewFavorite", false))
    {
      ygx localygx = new ygx(this, this, new LocationDetailActivity.LocationActions(this), 33, 7, null);
      localTextView1.setText(localBundle.getString("leftViewText"));
      localTextView2.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297392));
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130838587);
      this.jdField_g_of_type_AndroidWidgetImageView.setContentDescription(super.getString(2131368205));
      this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(localygx);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131297834));
      if (!QfavUtil.a()) {
        if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
          this.jdField_x_of_type_Boolean = true;
        }
      }
    }
    for (;;)
    {
      localTextView2.setTag(localTextView2.getText());
      return;
      if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
        continue;
        localTextView1.setText(2131366637);
        localTextView2.setText(2131368949);
        localTextView2.setOnClickListener(new ygy(this));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqfav\widget\LocationDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */