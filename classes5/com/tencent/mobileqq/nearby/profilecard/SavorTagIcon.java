package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalLabelLayout;
import java.util.ArrayList;
import java.util.List;

public class SavorTagIcon
  extends HorizontalLabelLayout
  implements View.OnClickListener
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "#77C6F4", "#FFA366", "#333333", "#5DC2A2" };
  private static final boolean jdField_b_of_type_Boolean = true;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  OnTagClickListener jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener;
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SavorTagIcon(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public SavorTagIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SavorTagIcon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("兴趣标签,");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(this.jdField_a_of_type_JavaUtilList.size()).append("个");
    int m = 0;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localStringBuilder.append(",");
      localStringBuilder.append(((InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(m)).tagName);
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.j = ((int)(12.0F * this.jdField_a_of_type_Float));
      this.g = 0;
      return;
    }
    this.j = ((int)(15.0F * this.jdField_a_of_type_Float));
    this.g = ((int)(2.0F * this.jdField_a_of_type_Float));
  }
  
  public void a(String paramString, int paramInt, List paramList, OnTagClickListener paramOnTagClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener = paramOnTagClickListener;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = jdField_a_of_type_ArrayOfJavaLangString[0];
    switch (this.jdField_a_of_type_Int)
    {
    }
    try
    {
      for (;;)
      {
        this.d = Color.parseColor(paramString);
        a(paramList);
        return;
        paramString = jdField_a_of_type_ArrayOfJavaLangString[0];
        continue;
        paramString = jdField_a_of_type_ArrayOfJavaLangString[1];
        continue;
        paramString = jdField_a_of_type_ArrayOfJavaLangString[2];
        continue;
        paramString = jdField_a_of_type_ArrayOfJavaLangString[3];
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    int n = 1;
    int m;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      m = 1;
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label126;
      }
    }
    for (;;)
    {
      if (m != n)
      {
        a();
        setPadding(this.i, this.h, this.k, this.j);
        paramList = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((paramList instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)paramList).bottomMargin = this.g;
        }
      }
      c();
      return;
      m = 0;
      break;
      label126:
      n = 0;
    }
  }
  
  public boolean a()
  {
    Rect localRect = new Rect();
    int n = getChildCount();
    int m = 0;
    while ((m < n - 1) && (n > 1))
    {
      View localView = getChildAt(m + 1);
      if ((localView.getGlobalVisibleRect(localRect)) && (localRect.bottom - localRect.top >= 0.5D * localView.getMeasuredHeight())) {
        return true;
      }
      m += 1;
    }
    return false;
  }
  
  protected void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SavorTagIcon", 4, "initView");
    }
    removeAllViews();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_Float < 0.01F) {
      this.jdField_a_of_type_Float = 1.0F;
    }
    this.i = ((int)(this.jdField_a_of_type_Float * 15.0F));
    this.k = ((int)(this.jdField_a_of_type_Float * 15.0F));
    this.h = ((int)(12.0F * this.jdField_a_of_type_Float));
    this.e = ((int)(10.0F * this.jdField_a_of_type_Float));
    this.f = ((int)(6.0F * this.jdField_a_of_type_Float));
    a();
    setPadding(this.i, this.h, this.k, this.j);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList(2);
    this.c = getResources().getDimensionPixelSize(2131493510);
    this.b = getResources().getDimensionPixelSize(2131493509);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2130904256, null));
    FrameLayout.LayoutParams localLayoutParams = a();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.bottomMargin = this.g;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  protected void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SavorTagIcon", 4, "refreshView");
    }
    int n = this.jdField_a_of_type_JavaUtilList.size();
    int m = getChildCount() - 1;
    Object localObject1;
    if (m > n) {
      while (m > n)
      {
        localObject1 = getChildAt(m);
        ((View)localObject1).setOnClickListener(null);
        removeView((View)localObject1);
        m -= 1;
      }
    }
    Object localObject3;
    if (m < n) {
      while (m < n)
      {
        localObject1 = LayoutInflater.from(getContext()).inflate(2130904254, null);
        localObject3 = a();
        ((ViewGroup.MarginLayoutParams)localObject3).width = -2;
        ((ViewGroup.MarginLayoutParams)localObject3).height = -2;
        ((ViewGroup.MarginLayoutParams)localObject3).topMargin = this.e;
        ((ViewGroup.MarginLayoutParams)localObject3).rightMargin = this.f;
        addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        m += 1;
      }
    }
    if (n > 0)
    {
      localObject1 = new StringBuilder(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append('(').append(n).append(')');
      localObject3 = new SpannableString(((StringBuilder)localObject1).toString());
      ((Spannable)localObject3).setSpan(new ForegroundColorSpan(-7829368), this.jdField_a_of_type_JavaLangString.length(), ((StringBuilder)localObject1).length(), 17);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      int i1 = this.jdField_a_of_type_JavaUtilList.size();
      m = 0;
      label248:
      if (m >= i1) {
        return;
      }
      localObject3 = getChildAt(m + 1);
      if (localObject3 != null) {
        break label329;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("SavorTagIcon", 4, "refreshView child is null, index = " + String.valueOf(m + 1));
      }
    }
    for (;;)
    {
      m += 1;
      break label248;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      break;
      label329:
      InterestTagInfo localInterestTagInfo = (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(m);
      if (localInterestTagInfo == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("SavorTagIcon", 4, "refreshView item is null, index = " + String.valueOf(m));
        }
      }
      else
      {
        String str = localInterestTagInfo.tagName;
        Object localObject4 = localInterestTagInfo.tagIconUrl;
        n = this.d;
        try
        {
          n = Color.parseColor(localInterestTagInfo.tagBgColor);
          localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(n);
          localGradientDrawable.setCornerRadius(this.c);
        }
        catch (Exception localException1)
        {
          try
          {
            GradientDrawable localGradientDrawable;
            n = Color.parseColor(localInterestTagInfo.tagTextColor);
            try
            {
              localObject1 = new GradientDrawable();
              ((GradientDrawable)localObject1).setColor(getResources().getColor(2131427623));
              ((GradientDrawable)localObject1).setShape(1);
              ((GradientDrawable)localObject1).setSize(this.b, this.b);
              URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mRequestHeight = this.b;
              localURLDrawableOptions.mRequestWidth = this.b;
              localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
              localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
              if (!TextUtils.isEmpty((CharSequence)localObject4))
              {
                localObject1 = URLDrawable.getDrawable(NearbyImgDownloader.a((String)localObject4), localURLDrawableOptions);
                ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(this.b, this.b));
                ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
                ((URLDrawable)localObject1).setDownloadListener(new ImgDownloadListener(getContext(), "actInterestTagPicDownload"));
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                if (QLog.isDevelopLevel()) {
                  localException3.printStackTrace();
                }
                Object localObject2 = null;
              }
            }
            localObject4 = (URLImageView)((View)localObject3).findViewById(2131297535);
            if (localObject4 != null) {
              ((URLImageView)localObject4).setImageDrawable((Drawable)localObject1);
            }
            localObject1 = (TextView)((View)localObject3).findViewById(2131301921);
            if (localObject1 != null)
            {
              ((TextView)localObject1).setText(str);
              ((TextView)localObject1).setTextColor(n);
            }
            ((View)localObject3).setBackgroundDrawable(localGradientDrawable);
            ((View)localObject3).setTag(localInterestTagInfo);
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener != null)
            {
              ((View)localObject3).setOnClickListener(this);
              continue;
              localException1 = localException1;
              if (QLog.isDevelopLevel()) {
                localException1.printStackTrace();
              }
              n = this.d;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isDevelopLevel()) {
                localException2.printStackTrace();
              }
              n = -1;
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (Object localObject = null;; localObject = paramView.getTag())
    {
      if (((localObject instanceof InterestTagInfo)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardOnTagClickListener.a(paramView, this.jdField_a_of_type_Int, (InterestTagInfo)localObject);
      }
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    setPadding(this.i, this.h, this.k, this.j);
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838201, 0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\profilecard\SavorTagIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */