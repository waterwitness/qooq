package com.tencent.mobileqq.nearby.interestTag;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV.IOnSizeChangeCallback;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;
import tjh;
import tji;
import tjj;
import tjk;
import tjl;
import tjm;
import tjo;
import tjp;
import tjq;
import tjs;
import tjt;
import tju;
import tjv;
import tjw;

public class ChooseInterestTagActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 4097;
  public static final long a = 3600000L;
  public static final String a = "choose_interest_tag";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "#77C6F4", "#FFA366", "#333333", "#5DC2A2" };
  public static final int b = 4098;
  public static final String b = "list_last_update_time_";
  public static final int c = 4099;
  public static final String c = "list_fetch_pos_";
  public static final int d = 4100;
  public static final String d = "interest_tag_type";
  private static final int jdField_e_of_type_Int = 1;
  public static final String e = "from_where";
  private static final int f = -1;
  public static final String f = "is_from_judge";
  private static final int g = 30;
  public static final String g = "choosed_interest_tags";
  private float jdField_a_of_type_Float;
  private Handler jdField_a_of_type_AndroidOsHandler = new tjs(this);
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new tjl(this);
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new tji(this);
  private View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new tjv(this);
  private View jdField_a_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new tju(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NearbyCardHandler jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler;
  private NearbyCardObserver jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new tjt(this);
  private InterestTagAdapter jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagAdapter;
  private InterestTagItemView.IInterestTagItemViewCallback jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$IInterestTagItemViewCallback = new tjm(this);
  private ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback jdField_a_of_type_ComTencentMobileqqNearbyInterestTagShowTagNamePopupWindow$IShowTagNamePopupWindowCallback = new tjk(this);
  private MonitorSizeChangeHSV.IOnSizeChangeCallback jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV$IOnSizeChangeCallback = new tjw(this);
  private MonitorSizeChangeHSV jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV;
  private QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new tjj(this);
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString = "";
  private int i;
  private int j = -1;
  private int k;
  private int l;
  private int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private View a(InterestTagInfo paramInterestTagInfo, boolean paramBoolean)
  {
    View localView = null;
    Object localObject3;
    int n;
    if ((this.j == 3) || (this.j == 2) || (this.j == 1) || (this.j == 4))
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904254, null);
      localObject3 = (URLImageView)localView.findViewById(2131297535);
      if (localObject3 != null) {}
      try
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(getResources().getColor(2131427623));
        ((GradientDrawable)localObject1).setShape(1);
        n = getResources().getDimensionPixelSize(2131493509);
        ((GradientDrawable)localObject1).setSize(n, n);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
        if (!TextUtils.isEmpty(paramInterestTagInfo.tagIconUrl))
        {
          localObject1 = URLDrawable.getDrawable(NearbyImgDownloader.a(paramInterestTagInfo.tagIconUrl), (URLDrawable.URLDrawableOptions)localObject4);
          ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(n, n));
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
        }
      }
      catch (Exception localException2)
      {
        try
        {
          n = Color.parseColor(paramInterestTagInfo.tagTextColor);
          ((TextView)localObject4).setTextColor(n);
          i1 = Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[(this.j - 1)]);
        }
        catch (Exception localException2)
        {
          try
          {
            for (;;)
            {
              n = Color.parseColor(paramInterestTagInfo.tagBgColor);
              Object localObject1 = new GradientDrawable();
              ((GradientDrawable)localObject1).setColor(n);
              ((GradientDrawable)localObject1).setCornerRadius(getResources().getDimensionPixelSize(2131493510));
              localView.setBackgroundDrawable((Drawable)localObject1);
              localView.setTag(paramInterestTagInfo);
              paramInterestTagInfo = new LinearLayout.LayoutParams(-2, this.m);
              if (!paramBoolean) {
                break;
              }
              n = 10;
              paramInterestTagInfo.leftMargin = ((int)(n * this.jdField_a_of_type_Float + 0.5D));
              localView.setLayoutParams(paramInterestTagInfo);
              localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
              return localView;
              localException1 = localException1;
              if (QLog.isDevelopLevel()) {
                localException1.printStackTrace();
              }
              String str = null;
              continue;
              str = paramInterestTagInfo.tagName;
            }
            localException2 = localException2;
            if (!QLog.isDevelopLevel()) {
              break label442;
            }
            localException2.printStackTrace();
            n = -1;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              n = i1;
              if (QLog.isDevelopLevel())
              {
                QLog.d("choose_interest_tag", 4, "parse tagBgClor: " + localException3.getMessage());
                n = i1;
                continue;
                n = 5;
              }
            }
          }
        }
      }
      ((URLImageView)localObject3).setImageDrawable((Drawable)localObject1);
      localObject4 = (TextView)localView.findViewById(2131301921);
      if (localObject4 != null)
      {
        if (paramInterestTagInfo.tagName != null) {
          break label423;
        }
        localObject1 = "";
        localObject3 = localObject1;
        if (((String)localObject1).length() > 6) {
          localObject3 = ((String)localObject1).substring(0, 6) + "...";
        }
        ((TextView)localObject4).setSingleLine(true);
        ((TextView)localObject4).setText((CharSequence)localObject3);
      }
    }
    int i1;
    label423:
    label442:
    Object localObject4 = new URLImageView(this);
    Object localObject2 = new LinearLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 40.0F + 0.5D), this.m);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5D));
    ((ImageView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject4).setTag(paramInterestTagInfo);
    ((ImageView)localObject4).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (this.j == 7)
    {
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setColor(getResources().getColor(2131427623));
      ((GradientDrawable)localObject2).setCornerRadius(this.jdField_a_of_type_Float * 10.0F);
      ((GradientDrawable)localObject2).setShape(0);
      n = getResources().getDimensionPixelSize(2131493433);
      ((GradientDrawable)localObject2).setSize(n, n);
      if (!TextUtils.isEmpty(paramInterestTagInfo.tagIconUrl)) {
        localObject3 = localView;
      }
    }
    else
    {
      try
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = localView;
        if (this.j != 5) {
          break label862;
        }
        localObject3 = localView;
        n = getResources().getDimensionPixelSize(2131493434);
        localObject3 = localView;
        localURLDrawableOptions.mRequestHeight = n;
        label709:
        localObject3 = localView;
        i1 = getResources().getDimensionPixelSize(2131493432);
        localObject3 = localView;
        localURLDrawableOptions.mRequestWidth = i1;
        localObject3 = localView;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
        localObject3 = localView;
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
        localObject3 = localView;
        paramInterestTagInfo = URLDrawable.getDrawable(NearbyImgDownloader.a(paramInterestTagInfo.tagIconUrl), localURLDrawableOptions);
        localObject3 = paramInterestTagInfo;
        if (this.j != 7) {
          break label915;
        }
        localObject3 = paramInterestTagInfo;
        paramInterestTagInfo.setTag(URLDrawableDecodeHandler.a(i1, n, (int)(this.jdField_a_of_type_Float * 10.0F)));
        localObject3 = paramInterestTagInfo;
        paramInterestTagInfo.setDecodeHandler(URLDrawableDecodeHandler.b);
      }
      catch (Exception paramInterestTagInfo)
      {
        for (;;)
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (QLog.isColorLevel()) {
            QLog.i("choose_interest_tag", 2, paramInterestTagInfo.toString());
          }
          paramInterestTagInfo = (InterestTagInfo)localObject3;
          continue;
          localObject3 = paramInterestTagInfo;
          paramInterestTagInfo.setTag(URLDrawableDecodeHandler.a(i1, n));
          localObject3 = paramInterestTagInfo;
          paramInterestTagInfo.setDecodeHandler(URLDrawableDecodeHandler.a);
          continue;
          localObject2 = paramInterestTagInfo;
        }
      }
      localObject3 = paramInterestTagInfo;
      localURLDrawableOptions.mFailedDrawable = null;
      localObject3 = paramInterestTagInfo;
      localURLDrawableOptions.mLoadingDrawable = null;
    }
    for (;;)
    {
      if (paramInterestTagInfo == null)
      {
        ((ImageView)localObject4).setImageDrawable((Drawable)localObject2);
        return (View)localObject4;
        localObject2 = getResources().getDrawable(2131427623);
        break;
        label862:
        localObject3 = localView;
        n = getResources().getDimensionPixelSize(2131493433);
        localObject3 = localView;
        localURLDrawableOptions.mRequestHeight = n;
        break label709;
      }
      label915:
      paramInterestTagInfo = null;
    }
  }
  
  private void a()
  {
    String str2 = "";
    String str1 = "";
    String str3 = "搜索";
    if (this.j == 3)
    {
      str2 = "喜欢的品牌";
      str1 = "选择常用的品牌";
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(str3);
      if (!this.jdField_b_of_type_Boolean) {
        break label348;
      }
    }
    for (;;)
    {
      setTitle(str1);
      if (!this.jdField_b_of_type_Boolean) {
        break label353;
      }
      setLeftViewName(2131367262);
      this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText("完成");
      this.rightViewText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      if (this.j == 5)
      {
        str2 = "喜欢的电影";
        str1 = "选择喜欢的电影";
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.j == 6)
      {
        str2 = "喜欢的歌手";
        str1 = "选择喜欢的歌手";
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.j == 2)
      {
        str2 = "喜欢的美食";
        str1 = "选择喜欢的美食";
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      if (this.j == 7)
      {
        str2 = "喜欢的游戏";
        str1 = "选择喜欢的游戏";
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.j == 4)
      {
        str1 = "选择喜欢的运动";
        str2 = "喜欢的运动";
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      if (this.j != 1) {
        break;
      }
      str2 = "去过的旅行地";
      str1 = "选择去过的旅行地";
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      str3 = "搜索国家/国内城市";
      break;
      label348:
      str1 = str2;
    }
    label353:
    setLeftViewName(2131366637);
    this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(8);
  }
  
  private void a(int paramInt)
  {
    Object localObject;
    if ((this.k == 1) && (paramInt == 0))
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
        if (Build.VERSION.SDK_INT >= 11) {
          ((View)localObject).setAlpha(1.0F);
        }
      }
      this.k = 0;
    }
    do
    {
      return;
      if ((this.k == 0) && (paramInt == 1))
      {
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
          if (Build.VERSION.SDK_INT >= 11) {
            ((View)localObject).setAlpha(0.5F);
          }
        }
        this.k = 1;
        return;
      }
    } while (paramInt != 2);
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject = (InterestTagInfo)this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      b((InterestTagInfo)localObject);
      c((InterestTagInfo)localObject);
    }
    this.k = 0;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  private void a(InterestTagInfo paramInterestTagInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = this.m;
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = this.m;
        int n = (int)(this.jdField_a_of_type_Float * 10.0F + 0.5D);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = n;
        ((RelativeLayout.LayoutParams)localObject).topMargin = n;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      bool = true;
      paramInterestTagInfo = a(paramInterestTagInfo, bool);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramInterestTagInfo);
      localObject = new AlphaAnimation(0.1F, 1.0F);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setDuration(70L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new tjp(this));
      paramInterestTagInfo.startAnimation(localAnimationSet);
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label288;
      }
      this.rightViewText.setEnabled(false);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130839273), null, null, null);
      }
    }
    label288:
    do
    {
      return;
      bool = false;
      break;
      this.rightViewText.setEnabled(true);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(String paramString)
  {
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        int n = 0;
        if (n < paramList.size())
        {
          Object localObject = (InterestTagInfo)paramList.get(n);
          if (n == 0) {}
          for (boolean bool = true;; bool = false)
          {
            localObject = a((InterestTagInfo)localObject, bool);
            int i1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, i1);
            n += 1;
            break;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new tjo(this), 100L);
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break;
        }
        this.rightViewText.setEnabled(false);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130839273), null, null, null);
      return;
      this.rightViewText.setEnabled(true);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    if ((!paramBoolean2) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetListView.removeFooterView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    TextView localTextView;
    ProgressBar localProgressBar;
    for (this.jdField_e_of_type_Boolean = false;; this.jdField_e_of_type_Boolean = true)
    {
      do
      {
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298457);
        localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297005);
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298469);
        if (localImageView.getVisibility() != 8) {
          localImageView.setVisibility(8);
        }
        if (!paramBoolean1) {
          break;
        }
        localTextView.setTextColor(getResources().getColor(2131428302));
        localTextView.setText("正在加载");
        localProgressBar.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return;
      } while ((!paramBoolean2) || (this.jdField_e_of_type_Boolean));
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    if (paramBoolean2)
    {
      localTextView.setTextColor(getResources().getColor(2131428332));
      localTextView.setText("加载更多");
      localProgressBar.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    localTextView.setTextColor(getResources().getColor(2131428302));
    localTextView.setText("没有更多数据");
    localProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  private boolean a(InterestTagInfo paramInterestTagInfo)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.contains(paramInterestTagInfo);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131301894));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV = ((MonitorSizeChangeHSV)findViewById(2131299470));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301892));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131301897));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301893));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301898);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301900);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301899));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301901));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301890));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301891));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131301658);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301895));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131301896);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301902));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    int n = getResources().getColor(2131428199);
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(n);
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(n);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130903408, null));
    a(false, true);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.j) {
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setOnSizeChangeCallback(this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV$IOnSizeChangeCallback);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  private void b(InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo == null) {}
    label203:
    do
    {
      return;
      int i1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int n = 0;
      for (;;)
      {
        if (n < i1)
        {
          View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(n);
          if (((InterestTagInfo)localView.getTag()).equals(paramInterestTagInfo))
          {
            paramInterestTagInfo = new AlphaAnimation(1.0F, 0.1F);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
            AnimationSet localAnimationSet = new AnimationSet(true);
            localAnimationSet.addAnimation(paramInterestTagInfo);
            localAnimationSet.addAnimation(localScaleAnimation);
            localAnimationSet.setFillAfter(true);
            localAnimationSet.setDuration(70L);
            localAnimationSet.setInterpolator(new AccelerateInterpolator());
            localAnimationSet.setAnimationListener(new tjq(this, localView));
            localView.startAnimation(localAnimationSet);
          }
        }
        else
        {
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label203;
          }
          this.rightViewText.setEnabled(false);
          if (this.jdField_a_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130839273), null, null, null);
          return;
        }
        n += 1;
      }
      this.rightViewText.setEnabled(true);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void c()
  {
    int i1 = 0;
    Intent localIntent = getIntent();
    int n;
    boolean bool;
    label88:
    Object localObject;
    if (getIntent() == null)
    {
      n = -1;
      this.j = n;
      if ((this.j < 1) || (this.j > 7))
      {
        finish();
        if (QLog.isColorLevel()) {
          QLog.i("choose_interest_tag", 2, "tagType is wrong. " + this.j);
        }
      }
      if (getIntent() != null) {
        break label395;
      }
      bool = false;
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject = "";
        if (this.j != 3) {
          break label410;
        }
        localObject = "完成测试后，喜欢的品牌将会添加到交友资料";
        label124:
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if ((this.j != 2) && (this.j != 4)) {
        break label502;
      }
      bool = true;
      label151:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label508;
      }
      n = 10;
      label167:
      this.l = n;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams()).rightMargin = ((int)(this.jdField_a_of_type_Float * this.l + 0.5D));
      if (this.j != 5) {
        break label514;
      }
      this.m = ((int)(this.jdField_a_of_type_Float * 50.0F + 0.5D));
      label227:
      if (!this.jdField_a_of_type_Boolean) {
        break label588;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = 1;
      ((RelativeLayout.LayoutParams)localObject).width = 1;
      n = i1;
      if (this.jdField_b_of_type_Boolean) {
        n = (int)(this.jdField_a_of_type_Float * 7.0F + 0.5D);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = n;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = n;
    }
    for (;;)
    {
      if (localIntent != null)
      {
        localObject = localIntent.getParcelableArrayListExtra("choosed_interest_tags");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          Collections.reverse((List)localObject);
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        }
        d();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.app.a(60));
      ThreadManager.a().post(new tjh(this));
      return;
      n = getIntent().getIntExtra("interest_tag_type", -1);
      break;
      label395:
      bool = getIntent().getBooleanExtra("is_from_judge", false);
      break label88;
      label410:
      if (this.j == 5)
      {
        localObject = "完成测试后，喜欢的电影将会添加到交友资料";
        break label124;
      }
      if (this.j == 6)
      {
        localObject = "完成测试后，喜欢的歌手将会添加到交友资料";
        break label124;
      }
      if (this.j == 2)
      {
        localObject = "完成测试后，喜欢的美食将会添加到交友资料";
        break label124;
      }
      if (this.j == 7)
      {
        localObject = "完成测试后，喜欢的游戏将会添加到交友资料";
        break label124;
      }
      if (this.j == 4)
      {
        localObject = "完成测试后，喜欢的运动将会添加到交友资料";
        break label124;
      }
      if (this.j != 1) {
        break label124;
      }
      localObject = "完成测试后，喜欢的旅行地将会添加到交友资料";
      break label124;
      label502:
      bool = false;
      break label151;
      label508:
      n = 100;
      break label167;
      label514:
      if ((this.j == 1) || (this.j == 2) || (this.j == 3) || (this.j == 4))
      {
        this.m = ((int)(this.jdField_a_of_type_Float * 26.0F + 0.5D));
        break label227;
      }
      this.m = ((int)(this.jdField_a_of_type_Float * 40.0F + 0.5D));
      break label227;
      label588:
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = this.m;
      n = (int)(this.jdField_a_of_type_Float * 10.0F + 0.5D);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = n;
      ((RelativeLayout.LayoutParams)localObject).topMargin = n;
    }
  }
  
  private void c(InterestTagInfo paramInterestTagInfo)
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetListView.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_AndroidWidgetListView.getLastVisiblePosition();
    int n = i1;
    while (n <= i2)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(n - i1);
      if ((localView != null) && ((localView instanceof InterestTagItemView)) && (paramInterestTagInfo.equals(localView.getTag()))) {
        ((InterestTagItemView)localView).a();
      }
      n += 1;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(8);
      }
      this.rightViewText.setEnabled(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams();
        localLayoutParams.height = this.m;
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setLayoutParams(localLayoutParams);
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        localLayoutParams.height = this.m;
        int n = (int)(this.jdField_a_of_type_Float * 10.0F + 0.5D);
        localLayoutParams.bottomMargin = n;
        localLayoutParams.topMargin = n;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      }
    }
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      Intent localIntent2 = getIntent();
      Intent localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      Collections.reverse(this.jdField_a_of_type_JavaUtilArrayList);
      localIntent1.putParcelableArrayListExtra("choosed_interest_tags", this.jdField_a_of_type_JavaUtilArrayList);
      localIntent1.putExtra("interest_tag_type", this.j);
      setResult(-1, localIntent1);
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904226);
    getWindow().setBackgroundDrawable(getResources().getDrawable(2130840647));
    b();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    c();
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  public void finish()
  {
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\interestTag\ChooseInterestTagActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */