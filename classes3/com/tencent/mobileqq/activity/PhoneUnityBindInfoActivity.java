package com.tencent.mobileqq.activity;

import MyCarrier.Carrier;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.mybusiness.MyBusinessServlet;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URLEncoder;
import lzi;
import lzj;
import lzp;
import lzq;
import lzr;
import lzs;
import lzt;
import lzu;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;

public class PhoneUnityBindInfoActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public static final int a = 4001;
  public static final String a = "phone_unity_info";
  public static final int b = 4002;
  public static final int c = 4003;
  public static final int d = 4004;
  public static final int e = 1001;
  public static final int f = 1002;
  public static final int g = 1003;
  public static final int h = 1004;
  public static final int i = 1005;
  public static final int j = 1006;
  public static final int k = 1007;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public BroadcastReceiver a;
  public Bundle a;
  public RelativeLayout a;
  public TextView a;
  public PhoneUnityManager a;
  public SecSvcObserver a;
  public ContactBindObserver a;
  public QQCustomDialog a;
  public ActionSheet a;
  public boolean a;
  public RelativeLayout b;
  public QQCustomDialog b;
  public boolean b;
  public RelativeLayout c;
  public boolean c;
  public RelativeLayout d;
  public boolean d;
  public boolean e;
  public int o;
  
  public PhoneUnityBindInfoActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.o = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lzi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new lzj(this);
  }
  
  public static SpannableStringBuilder a(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramString.length(), 18);
    return localSpannableStringBuilder;
  }
  
  private void a()
  {
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 2, 1);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 2, 1);
    a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 2, 1);
    a(this.jdField_d_of_type_AndroidWidgetRelativeLayout, 2, 1);
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.e) {
      return;
    }
    String str2 = paramBundle.getString("country_code");
    String str1 = paramBundle.getString("phone");
    Object localObject3 = "";
    Object localObject2 = "";
    Object localObject4 = paramBundle.getParcelableArray("phone_info");
    int i1;
    Object localObject1;
    if (localObject4 != null)
    {
      i1 = 0;
      localObject1 = str1;
      paramBundle = (Bundle)localObject3;
      if (i1 < localObject4.length)
      {
        localObject3 = (Bundle)localObject4[i1];
        if (localObject3 == null)
        {
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramBundle;
          paramBundle = (Bundle)localObject3;
        }
        for (;;)
        {
          i1 += 1;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = paramBundle;
          paramBundle = (Bundle)localObject3;
          break;
          switch (((Bundle)localObject3).getInt("phone_type", 0))
          {
          default: 
            localObject3 = paramBundle;
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            break;
          case 1: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            localObject1 = localObject2;
            localObject2 = paramBundle;
            paramBundle = (Bundle)localObject3;
            break;
          case 8: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            localObject2 = paramBundle;
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject3;
            break;
          case 4: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
        }
      }
      localObject3 = localObject2;
      localObject2 = paramBundle;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject3 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      if (localObject3 != null) {
        ((ActionSheet)localObject3).dismiss();
      }
      localObject3 = (ActionSheet)ActionSheetHelper.a(this, null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject3);
      localObject4 = LayoutInflater.from(this).inflate(2130903445, null);
      if (localObject4 != null)
      {
        ((View)localObject4).setOnClickListener(new lzr(this));
        Object localObject5 = Bitmap.Config.ARGB_8888;
        Object localObject6 = (LinearLayout)((View)localObject4).findViewById(2131298630);
        Object localObject7;
        Object localObject8;
        if (localObject6 != null)
        {
          localObject7 = (TextView)((LinearLayout)localObject6).findViewById(2131298632);
          if ((localObject7 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, paramBundle)))
          {
            ((LinearLayout)localObject6).setVisibility(0);
            i1 = (int)((TextView)localObject7).getTextSize();
            localObject8 = Bitmap.createBitmap(i1 * 2, i1 * 2, (Bitmap.Config)localObject5);
            localObject8 = new ImageSpan(getApplicationContext(), (Bitmap)localObject8);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("登 录");
            localSpannableStringBuilder.setSpan(localObject8, 1, 2, 33);
            ((TextView)((LinearLayout)localObject6).findViewById(2131298631)).setText(localSpannableStringBuilder);
            ((TextView)localObject7).setText((CharSequence)localObject2);
          }
        }
        localObject2 = (LinearLayout)((View)localObject4).findViewById(2131298633);
        if (localObject2 != null)
        {
          localObject6 = (TextView)((LinearLayout)localObject2).findViewById(2131298635);
          if ((localObject6 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals((CharSequence)localObject1, paramBundle)))
          {
            ((LinearLayout)localObject2).setVisibility(0);
            i1 = (int)((TextView)localObject6).getTextSize();
            localObject7 = Bitmap.createBitmap(i1 / 2, i1 / 2, (Bitmap.Config)localObject5);
            localObject5 = new ImageSpan(getApplicationContext(), (Bitmap)localObject7);
            localObject7 = new ImageSpan(getApplicationContext(), (Bitmap)localObject7);
            localObject8 = new SpannableStringBuilder("设 备 锁");
            ((SpannableStringBuilder)localObject8).setSpan(localObject5, 1, 2, 33);
            ((SpannableStringBuilder)localObject8).setSpan(localObject7, 3, 4, 33);
            ((TextView)((LinearLayout)localObject2).findViewById(2131298634)).setText((CharSequence)localObject8);
            ((TextView)localObject6).setText((CharSequence)localObject1);
          }
        }
        localObject1 = (LinearLayout)((View)localObject4).findViewById(2131298636);
        if (localObject1 != null)
        {
          localObject2 = (TextView)((View)localObject4).findViewById(2131298638);
          if ((localObject2 != null) && (!TextUtils.isEmpty(paramBundle)))
          {
            ((LinearLayout)localObject1).setVisibility(0);
            ((TextView)localObject2).setText(paramBundle);
          }
        }
        ((View)localObject4).setBackgroundResource(2130837532);
        ((ActionSheet)localObject3).b((View)localObject4);
      }
      ((ActionSheet)localObject3).c(a(String.format(super.getString(2131370998), new Object[] { paramBundle })));
      ((ActionSheet)localObject3).c(super.getString(2131370999));
      ((ActionSheet)localObject3).c(super.getString(2131367262));
      ((ActionSheet)localObject3).setOnCancelListener(new lzs(this));
      ((ActionSheet)localObject3).a(new lzt(this));
      ((ActionSheet)localObject3).a(new lzu(this, str2, str1, (ActionSheet)localObject3));
      localObject2 = ((ActionSheet)localObject3).a();
      localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = new RelativeLayout.LayoutParams(-2, -2);
      }
      paramBundle.addRule(12, 0);
      paramBundle.addRule(13, -1);
      paramBundle.setMargins(80, 0, 80, 0);
      ((RelativeLayout)localObject2).setLayoutParams(paramBundle);
      ((ActionSheet)localObject3).show();
      return;
      localObject1 = "";
      localObject2 = "";
      paramBundle = str1;
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    if (paramRelativeLayout == null) {}
    Object localObject;
    int i1;
    label47:
    label72:
    label97:
    label153:
    do
    {
      return;
      if (paramInt1 != 1) {
        break;
      }
      localObject = this;
      paramRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)paramRelativeLayout.findViewById(2131302359);
      if (localObject != null)
      {
        if (paramInt1 != 1) {
          break label200;
        }
        i1 = 0;
        ((TextView)localObject).setVisibility(i1);
        if (paramInt1 == 1)
        {
          if (paramInt2 != 2) {
            break label207;
          }
          ((TextView)localObject).setText(2131370981);
        }
      }
      localObject = (ProgressBar)paramRelativeLayout.findViewById(2131302360);
      if (localObject != null)
      {
        if (paramInt1 != 2) {
          break label260;
        }
        i1 = 0;
        ((ProgressBar)localObject).setVisibility(i1);
        if (AppSetting.j) {
          ((ProgressBar)localObject).setContentDescription(super.getString(2131370990));
        }
      }
      localObject = (Button)paramRelativeLayout.findViewById(2131302361);
      if (localObject != null)
      {
        ((Button)localObject).setOnClickListener(this);
        if (paramInt1 != 3) {
          break label267;
        }
        i1 = 0;
        ((Button)localObject).setVisibility(i1);
      }
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(2131302362);
    } while (paramRelativeLayout == null);
    if ((paramInt1 != 3) && (paramInt2 != 4)) {}
    for (paramInt1 = i2;; paramInt1 = 8)
    {
      paramRelativeLayout.setVisibility(paramInt1);
      return;
      localObject = null;
      break;
      label200:
      i1 = 8;
      break label47;
      label207:
      if (paramInt2 == 4)
      {
        ((TextView)localObject).setText(2131370982);
        paramRelativeLayout.setOnClickListener(null);
        break label72;
      }
      if (paramInt2 == 3)
      {
        ((TextView)localObject).setText(2131370983);
        break label72;
      }
      if (paramInt2 != 1) {
        break label72;
      }
      ((TextView)localObject).setText(2131370980);
      break label72;
      label260:
      i1 = 8;
      break label97;
      label267:
      i1 = 8;
      break label153;
    }
  }
  
  private void a(boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    }
    if (paramBundle == null) {
      return;
    }
    Object localObject;
    Bundle[] arrayOfBundle;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = paramBundle.getString("phone");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    else
    {
      arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
      if (arrayOfBundle == null) {
        break label194;
      }
      i1 = 0;
      label68:
      if (i1 >= arrayOfBundle.length) {
        break label194;
      }
      localObject = arrayOfBundle[i1];
      if (localObject != null) {
        break label153;
      }
    }
    label153:
    while (((Bundle)localObject).getInt("phone_type", 0) != 16)
    {
      i1 += 1;
      break label68;
      if (paramBundle.containsKey("skip_url")) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, false);
      paramBundle = new Intent(this, PhoneUnityIntroductionActivity.class);
      paramBundle.putExtra("kSrouce", this.o);
      super.startActivityForResult(paramBundle, 1003);
      super.finish();
      return;
    }
    if (((Bundle)localObject).getInt("status", 0) != 5) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean1;
      break;
    }
    label194:
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = ((MyBusinessManager)this.app.getManager(48)).a();
      if ((localObject == null) || (TextUtils.isEmpty(((Carrier)localObject).carrierExtraInfo))) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (this.jdField_a_of_type_Boolean)
      {
        i1 = 0;
        ((RelativeLayout)localObject).setVisibility(i1);
      }
    }
    else
    {
      if (paramBundle.getInt("need_unify", 0) != 1) {
        break label331;
      }
      i1 = 1;
      label284:
      localObject = paramBundle.getString("skip_url");
      if ((!paramBoolean2) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label337;
      }
    }
    label331:
    label337:
    for (int i5 = 1;; i5 = 0)
    {
      if ((i5 != 0) || (i1 == 0)) {
        break label343;
      }
      a(paramBundle);
      return;
      i1 = 8;
      break;
      i1 = 0;
      break label284;
    }
    label343:
    int i10 = 1;
    int i1 = 1;
    int i8 = 1;
    int i2 = 1;
    int i7 = 1;
    int i3 = 1;
    int i4 = 2;
    int i6 = i4;
    if (arrayOfBundle != null)
    {
      int i9 = 0;
      i6 = i4;
      i7 = i3;
      i8 = i2;
      i10 = i1;
      if (i9 < arrayOfBundle.length)
      {
        paramBundle = arrayOfBundle[i9];
        if (paramBundle == null) {}
        for (;;)
        {
          i9 += 1;
          break;
          switch (paramBundle.getInt("phone_type", 0))
          {
          default: 
            break;
          case 2: 
            i1 = paramBundle.getInt("status", 0);
            break;
          case 4: 
            i2 = paramBundle.getInt("status", 0);
            break;
          case 8: 
            i3 = paramBundle.getInt("status", 0);
            break;
          case 16: 
            i4 = paramBundle.getInt("status", 0);
          }
        }
      }
    }
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (i10 == 2)
    {
      i1 = 1;
      label537:
      a(paramBundle, i1, i10);
      paramBundle = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (i8 != 2) {
        break label837;
      }
      i1 = 1;
      label560:
      a(paramBundle, i1, i8);
      paramBundle = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (i7 != 1) {
        break label843;
      }
      i1 = 3;
      label583:
      a(paramBundle, i1, i7);
      if (this.jdField_a_of_type_Boolean)
      {
        paramBundle = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
        if (i6 != 2) {
          break label849;
        }
      }
    }
    label837:
    label843:
    label849:
    for (i1 = 1;; i1 = 3)
    {
      a(paramBundle, i1, i6);
      if (i5 == 0) {
        break;
      }
      paramBundle = new StringBuilder((String)localObject);
      paramBundle.append("?");
      paramBundle.append("type=" + EquipLockWebEntrance.d);
      paramBundle.append("&plat=1");
      paramBundle.append("&app=1");
      paramBundle.append("&version=6.5.5.2880");
      paramBundle.append("&device=" + URLEncoder.encode(Build.DEVICE));
      paramBundle.append("&system=" + Build.VERSION.RELEASE);
      paramBundle.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      paramBundle = paramBundle.toString();
      localObject = new Intent(this, PhoneUnityVerifyActivity.class);
      ((Intent)localObject).putExtra("url", paramBundle);
      super.startActivityForResult((Intent)localObject, 1006);
      BaseActivity.sTopActivity.overridePendingTransition(2130968592, 0);
      return;
      i1 = 3;
      break label537;
      i1 = 3;
      break label560;
      i1 = 1;
      break label583;
    }
  }
  
  private void b()
  {
    ProgressBar localProgressBar;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302360);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131302360);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      localProgressBar = (ProgressBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131302360);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
    if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_Boolean))
    {
      localProgressBar = (ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131302360);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = new NewIntent(this.app.getApplication(), MyBusinessServlet.class);
    ((NewIntent)localObject1).putExtra("cmd_id", 2);
    this.app.startServlet((NewIntent)localObject1);
    localObject1 = ((MyBusinessManager)this.app.getManager(48)).a();
    Object localObject2;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Carrier)localObject1).carrierExtraInfo)))
    {
      if ((((Carrier)localObject1).carrierExtraInfo.indexOf("&") <= -1) && (((Carrier)localObject1).carrierExtraInfo.indexOf("?") <= -1)) {
        break label234;
      }
      localObject2 = (TicketManager)this.app.getManager(2);
    }
    for (localObject1 = ((Carrier)localObject1).carrierExtraInfo + "&skey=" + ((TicketManager)localObject2).getSkey(this.app.a());; localObject1 = ((Carrier)localObject1).carrierExtraInfo + "?skey=" + ((TicketManager)localObject2).getSkey(this.app.a()))
    {
      localObject2 = new Intent(this, MyBusinessActivity.class);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("uin", this.app.a());
      ((Intent)localObject2).putExtra("title", super.getString(2131371273));
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("hideRightButton", true);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      startActivityForResult((Intent)localObject2, 1001);
      return;
      label234:
      localObject2 = (TicketManager)this.app.getManager(2);
    }
  }
  
  public void a(int paramInt)
  {
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.a(34);
    if (localSecSvcHandler != null) {
      localSecSvcHandler.a(paramInt, 31, null, null);
    }
    a();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneUnityBindInfoActivity", 2, "doOnActivityResult requestCode = " + paramInt1 + " resultCode = " + paramInt2);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramInt2 == -1) || (paramInt2 == 4002))
          {
            a(4);
            return;
            a(this.jdField_d_of_type_AndroidWidgetRelativeLayout, 2, 1);
            a(4);
            return;
            super.setResult(paramInt2);
            super.finish();
            return;
            super.setResult(paramInt2);
            if (paramInt2 == -1)
            {
              a(1);
              return;
            }
            if (paramInt2 == 0)
            {
              super.finish();
              return;
              if (paramInt2 == -1) {
                a(2);
              }
              while ((paramInt2 == -1) && (paramIntent != null) && (!paramIntent.getBooleanExtra("phone_num_login_result", true)))
              {
                a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 3, 1);
                return;
                super.setResult(paramInt2);
                super.finish();
              }
            }
          }
        }
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          switch (paramIntent.getIntExtra("resultState", 5))
          {
          default: 
            super.setResult(paramInt2);
            super.finish();
            return;
          }
          a(4);
          return;
        }
      } while (paramInt2 != 0);
      paramIntent = this.jdField_a_of_type_AndroidOsBundle;
    } while ((paramIntent == null) || ((paramIntent.getInt("need_unify", 0) == 1) && (TextUtils.isEmpty(paramIntent.getString("skip_url")))));
    a(paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.o = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("kIsWeb", false);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("kBindNew", false);
    super.setContentView(2130904274);
    super.setTitle(getString(2131370946));
    super.setContentBackgroundResource(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityManager = ((PhoneUnityManager)this.app.getManager(101));
    if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e())
    {
      if (this.jdField_c_of_type_Boolean)
      {
        paramBundle = new Intent(this, BindNumberActivity.class);
        paramBundle.putExtra("cmd_param_is_from_uni", true);
        paramBundle.putExtra("cmd_param_is_from_change_bind", false);
        paramBundle.putExtra("kUnityWebBind", true);
        paramBundle.putExtra("kSrouce", this.o);
        startActivityForResult(paramBundle, 1007);
        return true;
      }
      paramBundle = new Intent(this, PhoneUnityIntroductionActivity.class);
      paramBundle.putExtra("kSrouce", this.o);
      startActivityForResult(paramBundle, 1003);
      finish();
      return true;
    }
    paramBundle = (Button)super.findViewById(2131302140);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131302141));
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838357);
      paramBundle = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302358);
      if (paramBundle != null) {
        paramBundle.setText(2131370977);
      }
      paramBundle = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302359);
      if (paramBundle != null) {
        paramBundle.setText(2131370981);
      }
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131302142));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838355);
      paramBundle = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131302358);
      if (paramBundle != null) {
        paramBundle.setText(2131370978);
      }
      paramBundle = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131302359);
      if (paramBundle != null) {
        paramBundle.setText(2131370981);
      }
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131302143));
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838355);
      paramBundle = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131302358);
      if (paramBundle != null) {
        paramBundle.setText(2131370700);
      }
      paramBundle = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131302359);
      if (paramBundle != null) {
        paramBundle.setText(2131370981);
      }
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131302144));
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838352);
      paramBundle = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131302358);
      if (paramBundle != null) {
        paramBundle.setText(2131370979);
      }
      paramBundle = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131302359);
      if (paramBundle != null) {
        paramBundle.setText(2131370981);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302139));
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityManager.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      a(1);
      return true;
    }
    a(4);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    int i1;
    do
    {
      Object localObject;
      do
      {
        return;
        super.startActivityForResult(new Intent(this, PhoneUnityChangeActivity.class), 1004);
        ReportController.b(this.app, "CliOper", "", "", "0X8005B7F", "0X8005B7F", 0, 0, "", "", "", "");
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8005B85", "0X8005B85", 0, 0, "", "", "", "");
        paramView = new Intent(this, SettingActivity2.class);
        paramView.putExtra("kSrouce", 2);
        super.startActivityForResult(paramView, 1002);
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8005B86", "0X8005B86", 0, 0, "", "", "", "");
        paramView = null;
        localObject = this.jdField_a_of_type_AndroidOsBundle;
        if (localObject != null) {
          paramView = ((Bundle)localObject).getByteArray("vaskey");
        }
        localObject = new Intent(this, PhoneUnityPhoneLoginActivity.class);
        ((Intent)localObject).putExtra("phone_num_login_sig", paramView);
        super.startActivityForResult((Intent)localObject, 1005);
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8005B87", "0X8005B87", 0, 0, "", "", "", "");
        paramView = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
        super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
        paramView = new Intent();
        paramView.setFlags(268435456);
        paramView.setAction("android.intent.action.VIEW");
        paramView.putExtra("devlock_open_source", "PhoneUnity");
        paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
        super.startActivity(paramView);
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8005B88", "0X8005B88", 0, 0, "", "", "", "");
        c();
        return;
        paramView = paramView.getParent();
      } while ((paramView == null) || (!(paramView instanceof RelativeLayout)));
      switch (((RelativeLayout)paramView).getId())
      {
      default: 
        return;
      case 2131302141: 
        if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())
        {
          super.startActivity(new Intent(this, GuideBindPhoneActivity.class));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null) {
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new lzp(this);
        }
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
        this.app.a(new lzq(this));
        a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 2, 1);
        QQToast.a(BaseApplicationImpl.a, "特征码匹配中。", 0).a();
        ReportController.b(this.app, "CliOper", "", "", "0X8005B82", "0X8005B82", 0, 0, "", "", "", "");
        return;
      case 2131302142: 
        ReportController.b(this.app, "CliOper", "", "", "0X8005B83", "0X8005B83", 0, 0, "", "", "", "");
        if (!NetworkUtil.e(this))
        {
          QQToast.a(this, getString(2131367256), 0).b(getTitleBarHeight());
          return;
        }
        a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 2, 1);
        int i2 = 1;
        paramView = (SecSvcHandler)this.app.a(34);
        i1 = i2;
        if (paramView != null)
        {
          localObject = this.jdField_a_of_type_AndroidOsBundle;
          i1 = i2;
          if (localObject != null)
          {
            localObject = ((Bundle)localObject).getByteArray("vaskey");
            i1 = i2;
            if (localObject != null)
            {
              i1 = 0;
              paramView.a((byte[])localObject);
            }
          }
        }
        break;
      }
    } while (i1 == 0);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 3, 1);
    return;
    ReportController.b(this.app, "CliOper", "", "", "0X8005B84", "0X8005B84", 0, 0, "", "", "", "");
    paramView = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
    paramView = new Intent();
    paramView.setFlags(268435456);
    paramView.setAction("android.intent.action.VIEW");
    paramView.putExtra("devlock_open_source", "PhoneUnity");
    paramView.putExtra("enable_open_allowset_dev", true);
    paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
    super.startActivity(paramView);
    return;
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PhoneUnityBindInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */