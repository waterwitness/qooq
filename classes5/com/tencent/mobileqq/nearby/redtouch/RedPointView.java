package com.tencent.mobileqq.nearby.redtouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RedPointView
  extends FrameLayout
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 5;
  public static final int e = 9;
  public static final int f = 99;
  public static final int g = 100;
  public static final int h = 10;
  public static final int i = 20;
  public static final int j = 30;
  public static final int k = 40;
  public static final int l = 0;
  public static final int m = 1;
  protected static int r = 1;
  protected int A;
  protected int B;
  protected int C;
  protected Context a;
  protected Handler a;
  protected View a;
  protected LinearLayout a;
  protected BusinessInfoCheckUpdate.RedTypeInfo a;
  protected List a;
  protected boolean a;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int s = 21;
  protected int t;
  protected int u;
  protected int v;
  protected int w;
  protected int x;
  protected int y;
  protected int z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = RedPointView.class.getSimpleName();
  }
  
  public RedPointView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedPointView(Context paramContext, View paramView)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
  }
  
  private View a(String paramString)
  {
    Object localObject = getResources().getDrawable(2130838582);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mRequestWidth = a(30);
    localURLDrawableOptions.mRequestHeight = a(30);
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    LinearLayout.LayoutParams localLayoutParams = a();
    localLayoutParams.width = a(36);
    localLayoutParams.height = a(36);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    ((ImageView)localObject).setPadding(a(3), a(3), a(3), a(3));
    ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    return (View)localObject;
  }
  
  private FrameLayout.LayoutParams a()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.x;
    localLayoutParams.leftMargin = this.y;
    localLayoutParams.rightMargin = this.z;
    localLayoutParams.topMargin = this.A;
    localLayoutParams.bottomMargin = this.B;
    return localLayoutParams;
  }
  
  private FrameLayout a(ImageView paramImageView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(a(30), a(30));
    localLayoutParams.gravity = 80;
    localLayoutParams.topMargin = a(16);
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    paramImageView.setImageResource(2130843321);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(a());
    return localFrameLayout;
  }
  
  private void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup == null) {
      return;
    }
    if ((localViewGroup instanceof RelativeLayout))
    {
      i1 = r;
      r = i1 + 1;
      setId(i1);
      int i3 = paramView.getId();
      RelativeLayout localRelativeLayout = (RelativeLayout)localViewGroup;
      i1 = 0;
      while (i1 < localRelativeLayout.getChildCount())
      {
        View localView = localRelativeLayout.getChildAt(i1);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        int[] arrayOfInt = localLayoutParams.getRules();
        int i2 = 0;
        while (i2 < arrayOfInt.length)
        {
          if (arrayOfInt[i2] == i3) {
            arrayOfInt[i2] = getId();
          }
          i2 += 1;
        }
        localView.setLayoutParams(localLayoutParams);
        i1 += 1;
      }
    }
    int i1 = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    setLayoutParams(paramView.getLayoutParams());
    localViewGroup.addView(this, i1);
  }
  
  private FrameLayout.LayoutParams b()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  private FrameLayout b(ImageView paramImageView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    paramImageView.setLayoutParams(new FrameLayout.LayoutParams(a(36), a(36)));
    paramImageView.setPadding(a(3), a(3), a(3), a(3));
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    paramImageView.setImageResource(2130843321);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 53;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(a());
    return localFrameLayout;
  }
  
  private void b(View paramView)
  {
    paramView.setLayoutParams(b());
    addView(paramView);
  }
  
  private void c()
  {
    this.x = this.s;
    this.y = this.t;
    this.z = this.u;
    this.A = this.v;
    this.B = this.w;
    this.C = 99;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.n = 10;
    this.o = 20;
    this.p = 30;
    this.q = 40;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(100);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  public int a()
  {
    return this.x;
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected View a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setBackgroundColor(paramInt3);
    if (paramInt4 != 0) {
      localURLImageView.setImageDrawable(getResources().getDrawable(paramInt4));
    }
    while (paramInt2 == 1) {
      if (this.d)
      {
        return a(localURLImageView);
        a(paramString, localURLImageView, paramInt1);
      }
      else
      {
        return b(localURLImageView);
      }
    }
    if (paramInt4 != 0)
    {
      localURLImageView.setLayoutParams(a());
      localURLImageView.setPadding(a(3), a(3), a(3), a(3));
      return localURLImageView;
    }
    paramString = a();
    paramString.width = a(36);
    paramString.height = a(36);
    localURLImageView.setLayoutParams(paramString);
    localURLImageView.setPadding(a(3), a(3), a(3), a(3));
    return localURLImageView;
  }
  
  protected ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130843321);
    localImageView.setBackgroundColor(paramInt);
    localImageView.setLayoutParams(a());
    return localImageView;
  }
  
  protected LinearLayout.LayoutParams a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  protected TextView a(String paramString, int paramInt1, int paramInt2)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      if (Integer.parseInt(paramString) > this.C) {
        localTextView.setText(this.C + "+");
      }
      for (;;)
      {
        localTextView.setTextColor(paramInt1);
        localTextView.setGravity(17);
        localTextView.setSingleLine(true);
        if (paramInt2 == 0) {
          break label179;
        }
        localTextView.setTextSize(11.0F);
        if (!this.c) {
          break;
        }
        localTextView.setIncludeFontPadding(false);
        localTextView.setBackgroundResource(2130843327);
        localTextView.setLayoutParams(a());
        if (this.b)
        {
          localTextView.measure(0, 0);
          this.y = (localTextView.getMeasuredWidth() / 2);
          a();
        }
        return localTextView;
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localTextView.setText(paramString.trim());
        continue;
        localTextView.setBackgroundResource(2130843325);
        continue;
        label179:
        localTextView.setTextSize(13.0F);
      }
    }
  }
  
  public RedPointView a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
      d();
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    a();
    return this;
  }
  
  public RedPointView a(int paramInt)
  {
    this.x = paramInt;
    return this;
  }
  
  public RedPointView a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    b();
    if ((paramRedTouchItem == null) || (!paramRedTouchItem.unReadFlag)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      try
      {
        int i1;
        switch (paramRedTouchItem.redtouchType)
        {
        case 1: 
          paramRedTouchItem = a(0);
          if (paramRedTouchItem != null)
          {
            i1 = this.n;
            this.n = (i1 + 1);
            paramRedTouchItem.setId(i1);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTouchItem);
            return;
          }
          break;
        case 3: 
          paramRedTouchItem = a(paramRedTouchItem.icon, 0, 1, 0, 0);
          if (paramRedTouchItem != null)
          {
            i1 = this.o;
            this.o = (i1 + 1);
            paramRedTouchItem.setId(i1);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTouchItem);
            return;
          }
          break;
        case 4: 
          paramRedTouchItem = a(paramRedTouchItem.tips, -1, 1);
          if (paramRedTouchItem != null)
          {
            i1 = this.p;
            this.p = (i1 + 1);
            paramRedTouchItem.setId(i1);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTouchItem);
            return;
          }
          break;
        case 2: 
          paramRedTouchItem = a(String.valueOf(paramRedTouchItem.count), -1, 1);
          if (paramRedTouchItem != null)
          {
            i1 = this.q;
            this.q = (i1 + 1);
            paramRedTouchItem.setId(i1);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTouchItem);
            return;
          }
          break;
        }
      }
      catch (Exception paramRedTouchItem) {}
    }
  }
  
  protected void a(String paramString, URLImageView paramURLImageView, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      Object localObject = getResources().getDrawable(2130838582);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mRequestWidth = a(30);
      localURLDrawableOptions.mRequestHeight = a(30);
      try
      {
        localObject = URLDrawable.getDrawable(new URL("redtouchPicDownloadProtoc", null, paramString), localURLDrawableOptions);
        ((URLDrawable)localObject).setTag(paramString);
        ((URLDrawable)localObject).addHeader("isCircle", String.valueOf(paramInt));
        paramURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "parse img exception : e = " + paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return this.y;
  }
  
  public RedPointView b(int paramInt)
  {
    this.y = a(paramInt);
    return this;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.n = 10;
      this.o = 20;
      this.p = 30;
      this.q = 40;
    }
  }
  
  public int c()
  {
    return this.z;
  }
  
  public RedPointView c(int paramInt)
  {
    this.z = a(paramInt);
    return this;
  }
  
  public int d()
  {
    return this.A;
  }
  
  public RedPointView d(int paramInt)
  {
    this.A = a(paramInt);
    return this;
  }
  
  public void setMaxNum(int paramInt)
  {
    this.C = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\redtouch\RedPointView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */