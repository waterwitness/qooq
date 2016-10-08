package com.tencent.mobileqq.activity.qwallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView.OnRollListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import out;
import ouu;

public class ThemeHbFragment
  extends Fragment
  implements View.OnClickListener, Animation.AnimationListener, RollNumberView.OnRollListener
{
  private static final String jdField_b_of_type_JavaLangString = "@xhdpi.png";
  private static final int jdField_c_of_type_Int = 100;
  private static final String jdField_c_of_type_JavaLangString = "64";
  private static final int jdField_d_of_type_Int = -11001;
  private static final String jdField_d_of_type_JavaLangString;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ThemeHbFragment.OnThemeHbClickListener jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$OnThemeHbClickListener;
  private RollNumberView jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView;
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private ouu jdField_a_of_type_Ouu = new ouu(this);
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int = 2;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private JSONArray jdField_b_of_type_OrgJsonJSONArray;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g = "";
  private String h;
  private String i = "1";
  private String j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d = null;
  }
  
  private int a(double paramDouble, String paramString)
  {
    int m = -1;
    int k = m;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView != null)
    {
      k = m;
      if (paramDouble >= 0.0D)
      {
        try
        {
          if (("64".equals(this.g)) && (!TextUtils.isEmpty(this.j)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.reset(paramDouble);
            String str = a(this.h, this.j);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
            paramString = new StringBuffer("发送给");
            paramString.append(this.j);
            paramString.append("人(共");
            paramString.append(str);
            paramString.append("元)");
            this.jdField_a_of_type_AndroidWidgetButton.setText(paramString.toString());
            this.h = str;
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.reset(paramDouble);
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return -1;
        }
        k = 0;
      }
    }
    return k;
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
  
  private void a(View paramView)
  {
    if ((paramView == null) || (!isAdded())) {
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView = ((RollNumberView)paramView.findViewById(2131300331));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(localFragmentActivity, 2130968723);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300333));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131300329));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300325));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300337));
    this.c = ((LinearLayout)paramView.findViewById(2131300324));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131300334);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300330));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300332));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131300323);
  }
  
  private void b()
  {
    try
    {
      Bundle localBundle = getArguments();
      this.jdField_a_of_type_JavaLangString = localBundle.getString("config");
      this.j = localBundle.getString("group_count");
      this.g = localBundle.getString("channel");
      a(this.jdField_a_of_type_JavaLangString);
      this.jdField_e_of_type_Int = Integer.valueOf(this.g).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(String paramString)
  {
    c(paramString);
    if (("64".equals(this.g)) || ((this.jdField_e_of_type_Int & 0x40) > 0))
    {
      paramString = a(54535, "", "");
      getActivity().setResult(-1, paramString);
    }
    if (isAdded())
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.setLisener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if ("64".equals(this.g)) {
      this.i = "1";
    }
    if (isAdded()) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
    }
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$OnThemeHbClickListener != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$OnThemeHbClickListener.a(paramString, 2);
    }
  }
  
  private void d()
  {
    int k;
    if ((this.jdField_b_of_type_OrgJsonJSONArray != null) && (this.jdField_a_of_type_OrgJsonJSONArray != null))
    {
      k = this.jdField_b_of_type_OrgJsonJSONArray.length();
      if (k > 0)
      {
        int m = this.jdField_a_of_type_OrgJsonJSONArray.length();
        if ((m > 0) && (m == k)) {
          k = a(new Random().nextInt(m));
        }
      }
    }
    try
    {
      this.h = this.jdField_a_of_type_OrgJsonJSONArray.getString(k);
      if (a(new BigDecimal(this.h).doubleValue(), this.jdField_b_of_type_OrgJsonJSONArray.getString(k)) == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.roll();
      }
      if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > k)) {
        this.jdField_a_of_type_ArrayOfInt[k] = 1;
      }
      this.jdField_a_of_type_Int = k;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length <= paramInt) || (paramInt < 0))
    {
      k = 0;
      return k;
    }
    int n = this.jdField_a_of_type_ArrayOfInt.length;
    int k = 0;
    label33:
    int m;
    if (k < n)
    {
      m = (paramInt + k) % n;
      if (this.jdField_a_of_type_ArrayOfInt[m] != 0) {}
    }
    for (;;)
    {
      if (k == n)
      {
        m = 0;
        for (;;)
        {
          k = paramInt;
          if (m >= n) {
            break;
          }
          this.jdField_a_of_type_ArrayOfInt[m] = 0;
          m += 1;
        }
        k += 1;
        break label33;
      }
      return m;
      m = 0;
    }
  }
  
  public Intent a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("result", paramInt);
      return localIntent;
      localIntent.putExtra("retmsg", paramString1);
    }
  }
  
  public void a()
  {
    b("theme.pack.keyback");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_b_of_type_Int = paramString.optInt("hb_theme_id");
      this.jdField_b_of_type_OrgJsonJSONArray = paramString.optJSONArray("hb_theme_wish_array");
      if (this.jdField_b_of_type_OrgJsonJSONArray == null) {
        this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray();
      }
      this.jdField_a_of_type_OrgJsonJSONArray = paramString.optJSONArray("hb_theme_money_array");
      this.jdField_e_of_type_JavaLangString = (paramString.optString("hb_theme_img") + "@xhdpi.png");
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (isAdded()) && (getActivity().getAppRuntime() != null))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = PreloadImgManager.a().a((QQAppInterface)getActivity().getAppRuntime(), this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        }
      }
      int m = this.jdField_a_of_type_OrgJsonJSONArray.length();
      int k = this.jdField_b_of_type_OrgJsonJSONArray.length();
      paramString = getString(2131365853);
      if (m > k) {
        while (k < m)
        {
          this.jdField_b_of_type_OrgJsonJSONArray.put(paramString);
          k += 1;
        }
      }
      if (m < k)
      {
        paramString = new JSONArray();
        k = 0;
        while (k < m)
        {
          paramString.put(this.jdField_b_of_type_OrgJsonJSONArray.get(k));
          k += 1;
        }
        this.jdField_b_of_type_OrgJsonJSONArray = paramString;
      }
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        k = this.jdField_a_of_type_OrgJsonJSONArray.length();
        if (k > 0) {
          this.jdField_a_of_type_ArrayOfInt = new int[k];
        }
      }
      this.jdField_a_of_type_Ouu.postDelayed(new out(this), 10L);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void complete()
  {
    if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_b_of_type_OrgJsonJSONArray != null) && (this.jdField_a_of_type_Int < this.jdField_b_of_type_OrgJsonJSONArray.length())) {}
    try
    {
      String str = this.jdField_b_of_type_OrgJsonJSONArray.getString(this.jdField_a_of_type_Int);
      if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_Ouu != null))
      {
        Message localMessage = this.jdField_a_of_type_Ouu.obtainMessage();
        localMessage.what = 100;
        Bundle localBundle = new Bundle();
        localBundle.putString("wish", str);
        localMessage.setData(localBundle);
        this.jdField_a_of_type_Ouu.sendMessage(localMessage);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    d();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$OnThemeHbClickListener = ((ThemeHbFragment.OnThemeHbClickListener)paramActivity);
      return;
    }
    catch (ClassCastException paramActivity)
    {
      throw new ClassCastException("must implement OnThemeHbClickListener");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131300334: 
    case 2131300337: 
      do
      {
        return;
        c("theme.pack.change");
        d();
        return;
        c("theme.pack.go");
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$OnThemeHbClickListener == null);
      Object localObject = "";
      paramView = (View)localObject;
      try
      {
        if (this.jdField_b_of_type_OrgJsonJSONArray != null)
        {
          paramView = (View)localObject;
          if (this.jdField_a_of_type_Int < this.jdField_b_of_type_OrgJsonJSONArray.length())
          {
            paramView = (View)localObject;
            if (this.jdField_a_of_type_Int >= 0) {
              paramView = this.jdField_b_of_type_OrgJsonJSONArray.getString(this.jdField_a_of_type_Int);
            }
          }
        }
        localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = getResources().getString(2131365694);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$OnThemeHbClickListener.a(this.jdField_b_of_type_Int, this.i, (String)localObject, this.h, "1");
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    case 2131300323: 
      b("theme.pack.back");
      return;
    }
    b("theme.pack.back");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2130903836, null);
    a(paramLayoutInflater);
    b();
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setCallback(null);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    super.onDestroyView();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\fragment\ThemeHbFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */