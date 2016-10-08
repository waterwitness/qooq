package com.tencent.mobileqq.activity.qwallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.widget.YellowTipsLayout;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import oua;
import oub;
import ouc;
import oud;
import oue;
import ouf;
import oug;
import ouh;
import oui;
import ouk;
import oul;

public class CommonHbFragment
  extends Fragment
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private static final double jdField_a_of_type_Double = 3.076923076923077D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CommonHbFragment.OnCommonHbListener jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener;
  private YellowTipsLayout jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetYellowTipsLayout;
  private IndividualRedPacketManager jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  
  public CommonHbFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-460294);
    this.jdField_a_of_type_AndroidTextTextWatcher = new oua(this);
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new oub(this);
  }
  
  private double a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt < 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString1))) {
      return 0.0D;
    }
    try
    {
      double d1 = new BigDecimal(paramString1).divide(new BigDecimal(paramString2), paramInt, 4).doubleValue();
      return d1;
    }
    catch (Exception paramString1) {}
    return 0.0D;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(a(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "0";
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject;
    if (("1".equals(this.g)) || ("7".equals(this.g)))
    {
      localObject = (LinearLayout)paramView.findViewById(2131300362);
      if (localObject != null) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      localObject = (TextView)paramView.findViewById(2131300383);
      if (localObject != null) {
        ((TextView)localObject).setText("金额");
      }
      localObject = (TextView)paramView.findViewById(2131298721);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = (EditText)paramView.findViewById(2131300268);
      ((EditText)localObject).addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      ((EditText)localObject).setOnFocusChangeListener(new oui(this));
      if (paramInt == 2) {
        ((EditText)localObject).setOnEditorActionListener(new ouk(this));
      }
      localObject = (EditText)paramView.findViewById(2131300271);
      if (paramInt != 2) {
        break label290;
      }
      ((EditText)localObject).addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        ((EditText)localObject).setHint("如  “" + this.jdField_c_of_type_JavaLangString + "”");
      }
    }
    for (;;)
    {
      ((Button)paramView.findViewById(2131297868)).setOnClickListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a()) {
        break label305;
      }
      a(1, paramView);
      return;
      localObject = (EditText)paramView.findViewById(2131297958);
      if (!TextUtils.isEmpty(this.f)) {
        ((EditText)localObject).setHint("本群共" + this.f + "人");
      }
      ((EditText)localObject).addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      break;
      label290:
      ((EditText)localObject).setOnEditorActionListener(new oul(this));
    }
    label305:
    a(0, paramView);
  }
  
  private void a(View paramView, ImageView paramImageView)
  {
    if ((paramView == null) || (paramImageView == null)) {}
    Object localObject1;
    int i1;
    int n;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject1 = new URL("protocol_vas_extension_image", "REDPACKET_SEND_PIC", this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.q + this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.r);
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          if (((URLDrawable)localObject1).getStatus() != 1) {
            ((URLDrawable)localObject1).restartDownload();
          }
          localObject2 = paramView.getViewTreeObserver();
          if (localObject2 != null)
          {
            i1 = paramView.getHeight();
            n = (int)(i1 * 3.076923076923077D + 0.5D);
            if ((n == 0) || (i1 == 0))
            {
              ((ViewTreeObserver)localObject2).addOnGlobalLayoutListener(new ouc(this, paramView, paramImageView, (URLDrawable)localObject1));
              return;
            }
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
      }
    } while ((n <= 0) || (i1 <= 0));
    int m = n;
    if (n > this.jdField_e_of_type_Int) {
      m = this.jdField_e_of_type_Int;
    }
    paramView = new FrameLayout.LayoutParams(m, i1);
    paramView.gravity = 5;
    paramImageView.setLayoutParams(paramView);
    paramImageView.setImageDrawable((Drawable)localObject1);
    paramImageView.postInvalidate();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener != null) && (!TextUtils.isEmpty(paramString1))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener.a(this.jdField_c_of_type_Int, paramString1, paramString2, 2);
    }
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_AndroidWidgetEditText == null) {}
    for (;;)
    {
      return true;
      String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      try
      {
        if (Integer.parseInt(str) < 1)
        {
          str = getString(2131365775);
          if ((str != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener != null)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener.c(str);
          }
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return false;
  }
  
  private void b() {}
  
  private boolean b()
  {
    int m = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((m == 0) || (str.startsWith(".")) || (str.endsWith("."))) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    for (;;)
    {
      return false;
      if (TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_JavaLangString = "";
        return false;
      }
      if (str.indexOf('.') == 0)
      {
        this.jdField_b_of_type_JavaLangString = "";
        return false;
      }
      if ((str.indexOf('.') > 0) && (str.indexOf('.') < str.length() - 3))
      {
        str = getString(2131365783);
        if ((str != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener.c(str);
        }
        this.jdField_b_of_type_JavaLangString = "";
        return false;
      }
      try
      {
        if (Double.valueOf(str).doubleValue() <= 0.0D)
        {
          this.jdField_b_of_type_JavaLangString = "";
          return false;
        }
        if ("2".equals(this.jdField_e_of_type_JavaLangString)) {
          str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        }
        while (Double.valueOf(str).doubleValue() >= 0.01D)
        {
          return true;
          if (this.jdField_b_of_type_AndroidWidgetEditText == null)
          {
            str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          }
          else
          {
            this.jdField_b_of_type_JavaLangString = a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
            str = this.jdField_b_of_type_JavaLangString;
          }
        }
        return false;
      }
      catch (Exception localException) {}
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_JavaLangString = localBundle.getString("channel");
    this.jdField_c_of_type_JavaLangString = localBundle.getString("placeholder");
    this.f = localBundle.getString("people_num");
    this.g = localBundle.getString("recv_type");
    this.jdField_e_of_type_JavaLangString = localBundle.getString("bus_type");
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = ((IndividualRedPacketManager)getActivity().getAppRuntime().getManager(130));
    this.jdField_a_of_type_Long = (DeviceInfoUtil.d() * 1024L * 1024L);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_AndroidTextTextWatcher == null)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (View)localIterator.next();
      if (localObject != null)
      {
        EditText localEditText = (EditText)((View)localObject).findViewById(2131300268);
        if (localEditText != null) {
          localEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        }
        localEditText = (EditText)((View)localObject).findViewById(2131300271);
        if (localEditText != null) {
          localEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        }
        localObject = (EditText)((View)localObject).findViewById(2131297958);
        if (localObject != null) {
          ((EditText)localObject).removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public int a()
  {
    int m = -1;
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      m = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
    }
    return m;
  }
  
  public String a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a();
    }
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 2) || ((("1".equals(this.g)) || ("7".equals(this.g))) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 1))))
    {
      if ("5".equals(this.jdField_a_of_type_JavaLangString)) {
        return "48";
      }
      return "6";
    }
    if (bool)
    {
      if ("5".equals(this.jdField_a_of_type_JavaLangString)) {
        return "5";
      }
      return "8";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.performClick();
    }
  }
  
  public void a(int paramInt)
  {
    double d1 = 0.01D;
    Object localObject;
    double d2;
    if ((!"1".equals(this.g)) && (!"7".equals(this.g)))
    {
      localObject = (View)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)((View)localObject).findViewById(2131297958));
      this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)((View)localObject).findViewById(2131299437));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((View)localObject).findViewById(2131300268));
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)((View)localObject).findViewById(2131300271));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131297868));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_b_of_type_JavaLangString = "";
      localObject = "1";
      if (!TextUtils.isEmpty(this.k)) {
        localObject = this.k;
      }
      if (TextUtils.isEmpty(this.i)) {
        break label373;
      }
      if (!"1".equals(this.jdField_e_of_type_JavaLangString)) {
        break label381;
      }
      d2 = a(this.i, (String)localObject, 2);
      if (d2 >= 0.01D) {
        break label548;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new DecimalFormat("#0.00").format(d1);
        this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
        if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
          this.jdField_b_of_type_AndroidWidgetEditText.setText(this.k);
        }
        if ((TextUtils.isEmpty(this.j)) || (paramInt == 2)) {
          break label390;
        }
        this.jdField_c_of_type_AndroidWidgetEditText.setText(this.j);
        if (paramInt != 0) {
          break label412;
        }
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-3064501);
        this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-5855578);
        this.d.setTextColor(-5855578);
        if ("6".equals(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_JavaLangString = "1";
        }
        this.jdField_e_of_type_JavaLangString = "2";
        if (this.jdField_b_of_type_AndroidWidgetEditText == null) {
          break label403;
        }
        this.jdField_b_of_type_AndroidWidgetEditText.requestFocus();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localObject = (View)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      break;
      label373:
      String str = "";
      continue;
      label381:
      str = this.i;
      continue;
      label390:
      this.jdField_c_of_type_AndroidWidgetEditText.setText("");
      continue;
      label403:
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      return;
      label412:
      if (paramInt == 1)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-5855578);
        this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-3064501);
        this.d.setTextColor(-5855578);
        if ("6".equals(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_JavaLangString = "1";
        }
        this.jdField_e_of_type_JavaLangString = "1";
        if (this.jdField_b_of_type_AndroidWidgetEditText != null)
        {
          this.jdField_b_of_type_AndroidWidgetEditText.requestFocus();
          return;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        return;
      }
      if (paramInt == 2)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-5855578);
        this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-5855578);
        this.d.setTextColor(-3064501);
        this.jdField_c_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_e_of_type_JavaLangString = "2";
        return;
        label548:
        d1 = d2;
      }
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramView == null) {}
    ViewGroup localViewGroup1;
    ViewGroup localViewGroup2;
    ViewGroup localViewGroup3;
    do
    {
      do
      {
        return;
        localViewGroup1 = (ViewGroup)paramView.findViewById(2131300267);
        localViewGroup2 = (ViewGroup)paramView.findViewById(2131300270);
        localViewGroup3 = (ViewGroup)paramView.findViewById(2131300266);
        paramView = (ImageView)paramView.findViewById(2131300269);
      } while ((localViewGroup1 == null) || (localViewGroup2 == null) || (localViewGroup3 == null) || (paramView == null));
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        localViewGroup1.setBackgroundColor(-1);
        localViewGroup2.setBackgroundColor(-460294);
        localViewGroup3.setBackgroundColor(-460294);
        return;
      }
    } while (this.jdField_a_of_type_Long < 10485760L);
    localViewGroup1.setBackgroundColor(-131844);
    localViewGroup2.setBackgroundColor(0);
    a(localViewGroup2, paramView);
    localViewGroup3.setBackgroundColor(-528142);
  }
  
  protected void a(View paramView)
  {
    if ((paramView == null) || (!isAdded())) {
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)paramView.findViewById(2131299437));
    Object localObject1 = localFragmentActivity.getCurrentAccountUin();
    Object localObject2 = YellowTipsLayout.getYellowTipsConfig(localFragmentActivity.getApplicationContext(), (String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetYellowTipsLayout = ((YellowTipsLayout)paramView.findViewById(2131298527));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetYellowTipsLayout.setYellowTipsJsonConfig((JSONObject)localObject2, "mk_hb_ad")) {
      this.jdField_a_of_type_AndroidWidgetScrollView.setPadding(0, 0, 0, 0);
    }
    localObject1 = (ViewGroup)paramView.findViewById(2131300257);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((ViewGroup)localObject1).setFitsSystemWindows(true);
      ((ViewGroup)localObject1).setPadding(0, ImmersiveUtils.a(localFragmentActivity), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    localObject1 = (ImageView)paramView.findViewById(2131297183);
    ((ImageView)localObject1).setOnClickListener(this);
    if (!"5".equals(this.jdField_a_of_type_JavaLangString))
    {
      if (localObject2 == null) {
        break label1325;
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("hb_vip");
      if (localObject2 == null) {
        break label1325;
      }
    }
    label1325:
    for (int m = ((JSONObject)localObject2).optInt("enable_shop_enter");; m = 1)
    {
      if (m == 1)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
        this.h = IndividualRedPacketManager.a(3, (QQAppInterface)getActivity().getAppRuntime());
        if (TextUtils.isEmpty(this.h)) {
          ((ImageView)localObject1).setVisibility(8);
        }
      }
      for (;;)
      {
        ((TextView)paramView.findViewById(2131297139)).setText(2131365683);
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300258));
        this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300259));
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.d = ((Button)paramView.findViewById(2131300261));
        this.d.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131300260));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300262));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (("1".equals(this.g)) || ("7".equals(this.g))) {
          this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        }
        if ("6".equals(this.g)) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297138));
        Object localObject3 = LayoutInflater.from(localFragmentActivity);
        localObject1 = ((LayoutInflater)localObject3).inflate(2130903849, null);
        localObject2 = ((LayoutInflater)localObject3).inflate(2130903844, null);
        localObject3 = ((LayoutInflater)localObject3).inflate(2130903841, null);
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        if ((!"1".equals(this.g)) && (!"7".equals(this.g)))
        {
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          a((View)localObject1, 0);
        }
        this.jdField_a_of_type_JavaUtilList.add(localObject2);
        a((View)localObject2, 1);
        if (!"6".equals(this.g))
        {
          this.jdField_a_of_type_JavaUtilList.add(localObject3);
          a((View)localObject3, 2);
        }
        localObject1 = (ImageView)paramView.findViewById(2131300264);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131300265));
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
        this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
        try
        {
          localObject2 = ViewPager.class.getDeclaredField("mScroller");
          ((Field)localObject2).setAccessible(true);
          localObject3 = new CommonHbFragment.FixedSpeedScroller(this, this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getContext(), new AccelerateDecelerateInterpolator());
          ((Field)localObject2).set(this.jdField_a_of_type_AndroidSupportV4ViewViewPager, localObject3);
          ((CommonHbFragment.FixedSpeedScroller)localObject3).a(200);
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300263));
          localObject2 = new DisplayMetrics();
          localFragmentActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
          float f1 = getResources().getDisplayMetrics().density;
          this.jdField_e_of_type_Int = (((DisplayMetrics)localObject2).widthPixels - (int)(30.0F * f1));
          this.jdField_b_of_type_Int = ((this.jdField_e_of_type_Int / this.jdField_a_of_type_JavaUtilList.size() - this.jdField_a_of_type_Int) / 2);
          ((ImageView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(this.jdField_b_of_type_Int * 2, (int)(f1 * 2.0F)));
          new Matrix().postTranslate(this.jdField_b_of_type_Int, 0.0F);
          this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)paramView.findViewById(2131299437));
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131300268));
          this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
          this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131300271));
          this.jdField_c_of_type_AndroidWidgetEditText.setOnEditorActionListener(new oud(this));
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131297868));
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
          this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131300272);
          if (("4".equals(this.g)) || ("5".equals(this.g)) || ("7".equals(this.g)))
          {
            this.jdField_e_of_type_JavaLangString = "1";
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new oue(this), 150L);
            return;
            ((ImageView)localObject1).setVisibility(0);
            continue;
            ((ImageView)localObject1).setVisibility(8);
            continue;
            ((ImageView)localObject1).setVisibility(8);
          }
          else
          {
            if (("1".equals(this.g)) || ("7".equals(this.g)))
            {
              a(1);
              this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
            }
            while ("6".equals(this.jdField_a_of_type_JavaLangString))
            {
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ouf(this), 150L);
              return;
              if ("6".equals(this.jdField_a_of_type_JavaLangString))
              {
                this.jdField_e_of_type_JavaLangString = "2";
                a(2);
                this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(2);
              }
              else if ("1".equals(this.jdField_e_of_type_JavaLangString))
              {
                a(1);
                this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1);
              }
              else if ("2".equals(this.jdField_e_of_type_JavaLangString))
              {
                a(0);
                this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
              }
              else
              {
                this.jdField_e_of_type_JavaLangString = "2";
                a(0);
                this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
              }
            }
            if (this.jdField_b_of_type_AndroidWidgetEditText != null)
            {
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new oug(this), 150L);
              return;
            }
            new Handler().postDelayed(new ouh(this), 150L);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener = ((CommonHbFragment.OnCommonHbListener)paramActivity);
      return;
    }
    catch (ClassCastException paramActivity)
    {
      throw new ClassCastException("must implement OnThemeHbClickListener");
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      this.k = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    }
    if (this.jdField_c_of_type_AndroidWidgetEditText != null) {
      this.j = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
    }
    this.i = this.l;
    int m = paramView.getId();
    paramView = getActivity();
    if (m == 2131297083) {
      if (this.jdField_a_of_type_Boolean)
      {
        a("hongbao.wrap.keyback", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener.b(-1, null);
        }
        if ((paramView != null) && (this.jdField_c_of_type_AndroidWidgetEditText != null))
        {
          ((InputMethodManager)paramView.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_c_of_type_AndroidWidgetEditText.getWindowToken(), 0);
          ((Activity)paramView).finish();
        }
      }
    }
    String str2;
    label288:
    label350:
    do
    {
      return;
      a("hongbao.wrap.back", "");
      break;
      if (m != 2131297868) {
        break label539;
      }
      str2 = a();
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("number#");
      if (this.jdField_b_of_type_AndroidWidgetEditText == null) {
        break label467;
      }
      paramView = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty(paramView)) {
        break label458;
      }
      paramView = "1";
      ((StringBuffer)localObject).append("1");
      ((StringBuffer)localObject).append(",type#");
      if ((!"1".equals(this.g)) && (!"7".equals(this.g)) && (!"4".equals(this.g)) && (!"5".equals(this.g))) {
        break label480;
      }
      ((StringBuffer)localObject).append("person");
      ((StringBuffer)localObject).append(",channel#");
      ((StringBuffer)localObject).append(str2);
      ((StringBuffer)localObject).append(",money#");
      if ((this.jdField_b_of_type_AndroidWidgetEditText != null) && (!"2".equals(this.jdField_e_of_type_JavaLangString))) {
        break label515;
      }
      ((StringBuffer)localObject).append(a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
      a("hongbao.wrap.go", ((StringBuffer)localObject).toString());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener == null);
    Object localObject = "";
    if (this.jdField_c_of_type_AndroidWidgetEditText != null) {
      localObject = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = getResources().getString(2131365694);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetEditText == null) || ("2".equals(this.jdField_e_of_type_JavaLangString))) {}
      for (String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();; str1 = this.jdField_b_of_type_JavaLangString)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment$OnCommonHbListener.a(str2, (String)localObject, this.jdField_e_of_type_JavaLangString, str1, paramView);
        return;
        label458:
        ((StringBuffer)localObject).append(paramView);
        break;
        label467:
        paramView = "1";
        ((StringBuffer)localObject).append("1");
        break;
        label480:
        if ("2".equals(this.g))
        {
          ((StringBuffer)localObject).append("crowd");
          break label288;
        }
        ((StringBuffer)localObject).append("group");
        break label288;
        label515:
        ((StringBuffer)localObject).append(a(this.jdField_b_of_type_JavaLangString));
        break label350;
      }
      label539:
      if (m == 2131300259)
      {
        if (("1".equals(this.g)) || ("7".equals(this.g)))
        {
          if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 0) {
            break;
          }
          a(1);
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0, true);
          return;
        }
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 1) {
          break;
        }
        a(1);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1, true);
        return;
      }
      if (m == 2131300258)
      {
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 0) {
          break;
        }
        a(0);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0, true);
        return;
      }
      if ((m == 2131300261) || (m == 2131300260))
      {
        if (paramView != null)
        {
          paramView = paramView.getSharedPreferences("qb_tenpay_hb_ling", 0);
          if (!paramView.getBoolean("is_clicked", false))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            paramView = paramView.edit();
            paramView.putBoolean("is_clicked", true);
            paramView.commit();
          }
        }
        if (("1".equals(this.g)) || ("7".equals(this.g)))
        {
          if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 1) {
            break;
          }
          a(2);
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1, true);
          return;
        }
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 2) {
          break;
        }
        a(2);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(2, true);
        return;
      }
      if ((m != 2131297183) || (getActivity() == null)) {
        break;
      }
      a("hongbao.wrap.vip", "");
      paramView = new Intent();
      paramView.setClass(getActivity(), QQBrowserActivity.class);
      paramView.putExtra("url", this.h);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      startActivity(paramView);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      paramLayoutInflater = paramLayoutInflater.inflate(2130903829, null);
      return paramLayoutInflater;
    }
    catch (Exception paramLayoutInflater) {}
    try
    {
      paramLayoutInflater = getActivity();
      if (paramLayoutInflater != null) {
        ((Activity)paramLayoutInflater).finish();
      }
    }
    catch (Exception paramLayoutInflater)
    {
      for (;;)
      {
        paramLayoutInflater.printStackTrace();
      }
    }
    return null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    d();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_c_of_type_AndroidWidgetEditText != null) {
      this.jdField_c_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidTextTextWatcher = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == 1) {
      a("hongbao.wrap.identical", "");
    }
    for (;;)
    {
      int m = this.jdField_b_of_type_Int * 2 + this.jdField_a_of_type_Int;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.jdField_c_of_type_Int * m, m * paramInt, 0.0F, 0.0F);
      this.jdField_c_of_type_Int = paramInt;
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
      if (("1".equals(this.g)) || ("7".equals(this.g))) {
        break;
      }
      a(paramInt);
      return;
      if (paramInt == 0) {
        a("hongbao.wrap.random", "");
      } else if (paramInt == 2) {
        a("hongbao.wrap.hopngbaokey", "");
      }
    }
    a(paramInt + 1);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a();; bool = false)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null))
      {
        int m = 0;
        if (m < this.jdField_a_of_type_JavaUtilList.size())
        {
          View localView1 = (View)this.jdField_a_of_type_JavaUtilList.get(m);
          View localView2 = localView1.findViewById(2131300272);
          localView1.findViewById(2131300270);
          if (localView2 != null)
          {
            if (bool) {
              localView2.setVisibility(0);
            }
          }
          else
          {
            label105:
            if (!bool) {
              break label132;
            }
            a(1, localView1);
          }
          for (;;)
          {
            m += 1;
            break;
            localView2.setVisibility(8);
            break label105;
            label132:
            a(0, localView1);
          }
        }
      }
      if (getView() != null)
      {
        if (!bool) {
          break label221;
        }
        a(1, getView());
      }
      for (;;)
      {
        if ((("4".equals(this.g)) || ("5".equals(this.g)) || ("7".equals(this.g))) && (this.jdField_a_of_type_AndroidViewView != null))
        {
          if (!bool) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        return;
        label221:
        a(0, getView());
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      c();
      a(paramView);
      b();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\fragment\CommonHbFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */