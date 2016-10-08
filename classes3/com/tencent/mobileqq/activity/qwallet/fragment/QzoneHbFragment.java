package com.tencent.mobileqq.activity.qwallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import java.io.File;
import java.net.URLEncoder;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import oum;
import oun;
import ouo;
import oup;
import ouq;
import our;
import ous;

public class QzoneHbFragment
  extends Fragment
  implements View.OnClickListener
{
  public static final int a = 100;
  private static final int jdField_b_of_type_Int = 300;
  private static final int jdField_c_of_type_Int = 2;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  PreloadImgManager.OnSingleDownloadCallback jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager$OnSingleDownloadCallback;
  private QzoneHbFragment.OnQzoneHbClickListener jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener;
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private ous jdField_a_of_type_Ous;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public QzoneHbFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    this.jdField_a_of_type_Ous = new ous(this);
    this.jdField_a_of_type_AndroidTextTextWatcher = new oum(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager$OnSingleDownloadCallback = new ouo(this);
  }
  
  private String a()
  {
    String str2 = "";
    String str1 = str2;
    int i;
    if (this.jdField_a_of_type_OrgJsonJSONArray != null)
    {
      i = this.jdField_a_of_type_OrgJsonJSONArray.length();
      str1 = str2;
      if (i > 0) {
        i = new Random().nextInt(i);
      }
    }
    try
    {
      str1 = this.jdField_a_of_type_OrgJsonJSONArray.get(i).toString();
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131300316);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300314));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300322));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300317));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131300319));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300321));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300320));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131299437);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getActivity(), 2130968723);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131300313);
  }
  
  private boolean a()
  {
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((i == 0) || (str.startsWith(".")) || (str.endsWith("."))) {}
    for (;;)
    {
      return false;
      if ((!TextUtils.isEmpty(str)) && (str.indexOf('.') != 0)) {
        if ((str.indexOf('.') > 0) && (str.indexOf('.') < str.length() - 3))
        {
          str = getString(2131365783);
          if ((str != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener.b(str);
            return false;
          }
        }
        else
        {
          try
          {
            double d1 = Double.valueOf(str).doubleValue();
            if (d1 > 0.0D) {
              return true;
            }
          }
          catch (Exception localException) {}
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  private void d()
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray.put("1.00");
      Bundle localBundle = getArguments();
      if (localBundle != null)
      {
        localBundle.getString("send_name");
        this.f = localBundle.getString("recv_name");
        this.g = localBundle.getString("feedsid");
        this.d = localBundle.getString("recv_uin");
        this.e = localBundle.getString("send_uin");
        this.h = localBundle.getString("channel");
        if (!TextUtils.isEmpty(this.f))
        {
          if (this.f.length() > 20) {
            this.f = this.f.substring(0, 20);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.f);
        }
        this.jdField_c_of_type_JavaLangString = a();
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a((QQAppInterface)getActivity().getAppRuntime(), 1, this.d));
      this.jdField_a_of_type_Ous.postDelayed(new oun(this), 10L);
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
  
  private void e()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((isAdded()) && (localFragmentActivity != null)) {
      this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new oup(this, localFragmentActivity));
    }
  }
  
  private void f()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((isAdded()) && (localFragmentActivity != null) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      new Handler().postDelayed(new ouq(this, localFragmentActivity), 150L);
    }
  }
  
  public void a()
  {
    if (isAdded()) {
      getActivity().finish();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optJSONObject("mk_qzone_hb");
    try
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("bg_img_url");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("comment");
      this.jdField_a_of_type_OrgJsonJSONArray = paramJSONObject.optJSONArray("money_array");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (isAdded()) && (getActivity().getAppRuntime() != null))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = PreloadImgManager.a().a((QQAppInterface)getActivity().getAppRuntime(), this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          PreloadImgManager.a().a((QQAppInterface)getActivity().getAppRuntime(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager$OnSingleDownloadCallback);
        }
      }
      this.jdField_c_of_type_JavaLangString = a();
      paramJSONObject = this.jdField_a_of_type_Ous.obtainMessage();
      paramJSONObject.what = 100;
      this.jdField_a_of_type_Ous.sendMessage(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void b()
  {
    if (!isAdded()) {
      return;
    }
    Object localObject = getActivity();
    localObject = ((Context)localObject).getFilesDir().getPath() + "/QWallet/" + this.e + "/hbThemeConfig.cfg";
    ThreadManager.a().post(new our(this, (String)localObject));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener = ((QzoneHbFragment.OnQzoneHbClickListener)paramActivity);
      return;
    }
    catch (ClassCastException paramActivity)
    {
      throw new ClassCastException("must implement OnQzoneHbClickListener");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      long l;
      do
      {
        for (;;)
        {
          return;
          if (isAdded()) {
            try
            {
              ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_AndroidViewView.getWindowToken(), 0);
              getActivity().finish();
              getActivity().overridePendingTransition(0, 0);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener.a(300, "rewardhongbao.wrap.close", 2);
                return;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramView.printStackTrace();
              }
            }
          }
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetButton.setText("取消");
          this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener.a(300, "rewardhongbao.wrap.custom", 2);
          }
          f();
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText("修改金额");
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
        return;
        l = System.currentTimeMillis();
      } while ((this.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L));
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener == null);
    paramView = URLEncoder.encode(this.f);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener.a(this.h, "", this.jdField_c_of_type_JavaLangString, "1", paramView, this.g);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener.a(300, "rewardhongbao.wrap.send", 2);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2130903835, null);
    a(paramLayoutInflater);
    d();
    c();
    b();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$OnQzoneHbClickListener.a(300, "rewardhongbao.wrap.show", 2);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidTextTextWatcher != null))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    super.onDestroyView();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\fragment\QzoneHbFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */