package com.tencent.biz.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.util.List;
import jfp;
import jfq;
import jfr;
import jfs;
import jft;
import jfu;

public class MenuViewFactory
{
  private static final int a = 1;
  private static final int b = 2;
  
  public MenuViewFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  static int a(Context paramContext, float paramFloat)
  {
    return AIOUtils.a(paramFloat, paramContext.getResources());
  }
  
  private static View a(Context paramContext, MenuItem paramMenuItem, int paramInt1, CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener, String paramString, int paramInt2)
  {
    if (paramInt1 == 1) {
      return b(paramContext, paramMenuItem, paramOnMenuItemClickListener, paramString, paramInt2);
    }
    return a(paramContext, paramMenuItem, paramOnMenuItemClickListener, paramString, paramInt2);
  }
  
  private static View a(Context paramContext, MenuItem paramMenuItem, CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener, String paramString, int paramInt)
  {
    boolean bool = false;
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(2, 16.0F);
    localTextView.setSingleLine();
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setText(paramMenuItem.a());
    localTextView.setGravity(17);
    if ((!TextUtils.isEmpty(paramMenuItem.b)) && (!TextUtils.isEmpty(paramMenuItem.c))) {}
    try
    {
      Object localObject = new int[2];
      localObject[0] = Color.parseColor(paramMenuItem.b);
      localObject[1] = Color.parseColor(paramMenuItem.c);
      if (localObject != null)
      {
        localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, (int[])localObject);
        ((GradientDrawable)localObject).setShape(0);
        ((GradientDrawable)localObject).setGradientType(0);
        ((GradientDrawable)localObject).setCornerRadius(a(paramContext, 6.0F));
        localTextView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    localTextView.setOnTouchListener(new jfp(paramContext, localTextView));
    localTextView.setOnClickListener(new jfq(paramOnMenuItemClickListener, paramMenuItem, paramString, paramInt));
    localRelativeLayout.addView(localTextView, localLayoutParams);
    paramOnMenuItemClickListener = new URLImageView(paramContext);
    if (TextUtils.isEmpty(paramMenuItem.d)) {
      return localRelativeLayout;
    }
    paramInt = paramContext.getResources().getDisplayMetrics().widthPixels;
    paramString = URLDrawable.getDrawable(paramMenuItem.d, paramInt, paramInt);
    if ((AbsDownloader.a(paramMenuItem.d)) || (!URLDrawableHelper.a(paramContext))) {
      bool = true;
    }
    paramString.setAutoDownload(bool);
    if ((paramString != null) && (paramString.getStatus() == 1)) {
      paramOnMenuItemClickListener.setBackgroundDrawable(null);
    }
    for (;;)
    {
      paramOnMenuItemClickListener.setImageDrawable(paramString);
      paramOnMenuItemClickListener.setScaleType(ImageView.ScaleType.CENTER);
      localRelativeLayout.addView(paramOnMenuItemClickListener, localLayoutParams);
      return localRelativeLayout;
      paramOnMenuItemClickListener.setURLDrawableDownListener(new jfr());
    }
  }
  
  public static CellLayout a(Context paramContext, List paramList, boolean paramBoolean, int paramInt, CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener, String paramString)
  {
    CellLayout localCellLayout = new CellLayout(paramContext);
    localCellLayout.setType(paramInt);
    localCellLayout.setCenterInLayout(paramBoolean);
    int i = 0;
    while (i < paramList.size())
    {
      localCellLayout.addView(a(paramContext, (MenuItem)paramList.get(i), paramInt, paramOnMenuItemClickListener, paramString, i + 1));
      i += 1;
    }
    if (paramBoolean) {
      localCellLayout.a();
    }
    localCellLayout.setClipChildren(false);
    return localCellLayout;
  }
  
  private static View b(Context paramContext, MenuItem paramMenuItem, CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener, String paramString, int paramInt)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    Object localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setId(1);
    ((TextView)localObject1).setText(paramMenuItem.a());
    ((TextView)localObject1).setTextSize(2, 14.0F);
    ((TextView)localObject1).setTextColor(Color.parseColor("#787374"));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject1).setGravity(17);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    URLImageView localURLImageView = new URLImageView(paramContext);
    String str = paramMenuItem.a;
    localObject1 = null;
    try
    {
      localObject2 = paramContext.getResources().getDrawable(2130838860);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label372:
      label415:
      for (;;) {}
    }
    if (TextUtils.isEmpty(str)) {
      localURLImageView.setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      localURLImageView.setId(2);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localURLImageView.setOnTouchListener(new jft(paramContext, localURLImageView));
      localURLImageView.setOnClickListener(new jfu(paramOnMenuItemClickListener, paramMenuItem, paramString, paramInt));
      paramOnMenuItemClickListener = new ImageView(paramContext);
      try
      {
        paramInt = Color.parseColor(paramMenuItem.b);
        paramMenuItem = new ShapeDrawable(new OvalShape());
        paramMenuItem.setIntrinsicWidth(100);
        paramMenuItem.setIntrinsicHeight(100);
        paramMenuItem.getPaint().setColor(paramInt);
        paramOnMenuItemClickListener.setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramOnMenuItemClickListener.setImageDrawable(paramMenuItem);
        paramMenuItem = new RelativeLayout.LayoutParams(-1, -1);
        paramMenuItem.addRule(2, 1);
        paramMenuItem.bottomMargin = a(paramContext, 9.0F);
        localRelativeLayout.addView(paramOnMenuItemClickListener, paramMenuItem);
        localRelativeLayout.addView(localURLImageView, paramMenuItem);
        localRelativeLayout.setClipChildren(false);
        return localRelativeLayout;
        int i = paramContext.getResources().getDisplayMetrics().widthPixels;
        localObject1 = URLDrawable.getDrawable(str, (Drawable)localObject1, (Drawable)localObject1);
        boolean bool;
        if ((AbsDownloader.a(str)) || (!URLDrawableHelper.a(paramContext)))
        {
          bool = true;
          ((URLDrawable)localObject1).setAutoDownload(bool);
          if ((localObject1 == null) || (((URLDrawable)localObject1).getStatus() != 1)) {
            break label415;
          }
          localURLImageView.setBackgroundDrawable(null);
        }
        for (;;)
        {
          localURLImageView.setImageDrawable((Drawable)localObject1);
          break;
          bool = false;
          break label372;
          localURLImageView.setURLDrawableDownListener(new jfs());
        }
      }
      catch (Exception paramMenuItem)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\MenuViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */