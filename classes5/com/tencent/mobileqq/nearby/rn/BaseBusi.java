package com.tencent.mobileqq.nearby.rn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.react.bridge.ReadableMap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.theme.ThemeUtil;

public class BaseBusi
{
  public static final int a = 24;
  static final String jdField_a_of_type_JavaLangString = BaseBusi.class.getSimpleName();
  public static final int b = 0;
  public static final String b = "enterTime";
  public static final int c = -15550475;
  public static final String c = "forResult";
  public static final int d = -460552;
  public static final String d = "requestCode";
  public static final int e = 7829367;
  public static final String e = "busi_id";
  public static final int f = 1;
  public static final String f = "busi_version";
  public static final int g = 2;
  public static final String g = "busi_from";
  public static final int h = 4;
  public static final String h = "busi_title";
  public static final int i = 8;
  public static final String i = "busi_extra";
  public static final int j = 0;
  public static final String j = "busi_url";
  public static final int k = 1;
  public static final String k = "busi_load";
  public static final int l = 2;
  public static final String l = "busi_bgclr";
  public static final String m = "busi_tipclr";
  public static final String n = "busi_headerclr";
  public static final String o = "schoolName";
  public static final String p = "selfUin";
  public static final String q = "curThemeId";
  public static final String r = "from";
  public static final String s = "extra";
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  int m = -1;
  int n = 0;
  int o = -15550475;
  int p = -460552;
  int q = 7829367;
  public int r;
  int s;
  String t = "";
  String u = "";
  String v = null;
  public String w = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i1 = Color.parseColor(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static BaseBusi a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    int i1 = paramIntent.getIntExtra("busi_id", 0);
    if (i1 == 24) {}
    for (Object localObject = new NearbyAlumnus();; localObject = new BaseBusi())
    {
      ((BaseBusi)localObject).r = i1;
      ((BaseBusi)localObject).s = paramIntent.getIntExtra("busi_version", 1);
      ((BaseBusi)localObject).w = paramIntent.getStringExtra("busi_from");
      ((BaseBusi)localObject).t = paramIntent.getStringExtra("busi_title");
      ((BaseBusi)localObject).v = paramIntent.getStringExtra("busi_url");
      ((BaseBusi)localObject).n = paramIntent.getIntExtra("busi_load", 0);
      ((BaseBusi)localObject).p = paramIntent.getIntExtra("busi_bgclr", -460552);
      ((BaseBusi)localObject).q = paramIntent.getIntExtra("busi_tipclr", 7829367);
      ((BaseBusi)localObject).o = paramIntent.getIntExtra("busi_headerclr", -15550475);
      ((BaseBusi)localObject).u = paramIntent.getStringExtra("busi_extra");
      return (BaseBusi)localObject;
    }
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramBundle == null)) {
      return false;
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a("BaseBusi", new Object[] { "openNearbySchoolMate", Long.valueOf(SystemClock.elapsedRealtime()) });
    }
    Intent localIntent = new Intent(paramContext, NearbyReactBaseActivity.class);
    localIntent.putExtra("enterTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("forResult", paramBoolean);
    localIntent.putExtra("requestCode", paramInt);
    localIntent.putExtras(paramBundle);
    if ((paramBoolean) && ((paramContext instanceof Activity)))
    {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      return true;
    }
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public View a(Context paramContext)
  {
    int i2 = 0;
    View localView;
    TextView localTextView1;
    TextView localTextView2;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2130904253, null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.p);
      paramContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297123);
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302078);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302079);
      localTextView2 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297686);
      if (paramContext != null)
      {
        if ((this.n & 0x1) != 0) {
          break label194;
        }
        i1 = 1;
        if (i1 == 0) {
          break label200;
        }
        i1 = 0;
        label109:
        paramContext.setVisibility(i1);
        paramContext.setBackgroundColor(this.o);
      }
      if (localView != null)
      {
        if ((this.n & 0x3) != 0) {
          break label207;
        }
        i1 = 1;
        label139:
        if (i1 == 0) {
          break label213;
        }
      }
    }
    label194:
    label200:
    label207:
    label213:
    for (int i1 = i2;; i1 = 8)
    {
      localView.setVisibility(i1);
      if ((localTextView1 != null) && ((this.n & 0x1) == 0)) {
        localTextView1.setText(this.t);
      }
      if (localTextView2 != null) {
        localTextView2.setTextColor(this.q);
      }
      return this.jdField_a_of_type_AndroidWidgetLinearLayout;
      i1 = 0;
      break;
      i1 = 8;
      break label109;
      i1 = 0;
      break label139;
    }
  }
  
  public String a(Intent paramIntent, AppInterface paramAppInterface)
  {
    return this.v;
  }
  
  public void a(int paramInt)
  {
    this.o = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297123);
      if (localView != null) {
        localView.setBackgroundColor(this.o);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener, int paramInt, String paramString)
  {
    int i1 = 1;
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "updateLoadingState", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(this.m), this.jdField_a_of_type_AndroidWidgetLinearLayout });
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    TextView localTextView;
    label202:
    label244:
    label272:
    label326:
    label331:
    label345:
    label350:
    do
    {
      do
      {
        do
        {
          return;
          if (this.m != paramInt) {
            break;
          }
          paramOnClickListener = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297686);
        } while ((paramOnClickListener == null) || (NearbyUtils.a(paramString, paramOnClickListener.getText().toString())));
        paramOnClickListener.setText(paramString);
        return;
        this.m = paramInt;
        ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302080);
        localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297686);
        Button localButton = (Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302081);
        switch (this.m)
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (localImageView != null)
          {
            if ((this.n & 0x9) != 0) {
              break label326;
            }
            paramInt = 1;
            if ((paramInt == 0) || (localImageView.getVisibility() != 8)) {
              break label331;
            }
            localImageView.setVisibility(0);
            paramOnClickListener = localImageView.getDrawable();
            if ((paramOnClickListener instanceof Animatable)) {
              ((Animatable)paramOnClickListener).start();
            }
          }
          if (localTextView != null)
          {
            paramInt = i1;
            if (this.m != 1)
            {
              if ((this.n & 0x4) != 0) {
                break label345;
              }
              paramInt = i1;
            }
            if (paramInt == 0) {
              break label350;
            }
          }
          for (i1 = 0;; i1 = 8)
          {
            localTextView.setVisibility(i1);
            if ((paramInt != 0) && (!NearbyUtils.a(paramString, localTextView.getText().toString()))) {
              localTextView.setText(paramString);
            }
            if (localButton == null) {
              break;
            }
            localButton.setVisibility(8);
            return;
            paramInt = 0;
            break label202;
            if (paramInt != 0) {
              break label244;
            }
            localImageView.setVisibility(8);
            break label244;
            paramInt = 0;
            break label272;
          }
        }
        if (localButton != null)
        {
          localButton.setVisibility(0);
          localButton.setOnClickListener(paramOnClickListener);
        }
        if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
          localImageView.setVisibility(8);
        }
      } while (localTextView == null);
      localTextView.setVisibility(0);
    } while (NearbyUtils.a(paramString, localTextView.getText().toString()));
    localTextView.setText(paramString);
  }
  
  public void a(AppInterface paramAppInterface, Intent paramIntent, NearbyBaseRRV paramNearbyBaseRRV)
  {
    if ((paramAppInterface == null) || (paramIntent == null) || (paramNearbyBaseRRV == null)) {}
    do
    {
      return;
      paramNearbyBaseRRV.addLaunchOption("selfUin", paramAppInterface.a());
      String str = ThemeUtil.getUserCurrentThemeId(paramAppInterface);
      paramIntent = str;
      if (TextUtils.isEmpty(str)) {
        paramIntent = "1000";
      }
      paramNearbyBaseRRV.addLaunchOption("curThemeId", paramIntent);
      if (!TextUtils.isEmpty(this.u)) {
        paramNearbyBaseRRV.addLaunchOption("extra", this.u);
      }
    } while (!NearbyUtils.a());
    NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkLaunchOption", new Object[] { paramAppInterface.a(), paramIntent });
  }
  
  public void a(BaseActivity paramBaseActivity, AppInterface paramAppInterface, ReadableMap paramReadableMap) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[").append(this.r).append(",").append(this.s).append(",").append(this.w).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\BaseBusi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */