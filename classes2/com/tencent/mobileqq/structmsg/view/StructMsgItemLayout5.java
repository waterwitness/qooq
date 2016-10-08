package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StructMsgItemLayout5
  extends AbsStructMsgItem
{
  public StructMsgItemLayout5()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StructMsgItemLayout5(int paramInt)
  {
    super(paramInt);
  }
  
  public StructMsgItemLayout5(Collection paramCollection)
  {
    super(paramCollection);
  }
  
  private RelativeLayout a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Resources localResources = paramContext.getResources();
    TextViewWrapLayout localTextViewWrapLayout = new TextViewWrapLayout(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    int i = localResources.getDimensionPixelSize(2131493081);
    int j = localResources.getDimensionPixelSize(2131493082);
    int k = AIOUtils.a(5.0F, localResources);
    localTextViewWrapLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localTextViewWrapLayout.setPadding(i, k, j, k);
    localObject = new AnyScaleTypeImageView(paramContext);
    ((AnyScaleTypeImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramString1 = URLDrawable.getDrawable(paramString1, null);
    ((AnyScaleTypeImageView)localObject).setId(2131296303);
    ((AnyScaleTypeImageView)localObject).setImageDrawable(paramString1);
    paramString1 = new RelativeLayout.LayoutParams(AIOUtils.a(70.0F, localResources), AIOUtils.a(70.0F, localResources));
    paramString1.addRule(9);
    paramString1.addRule(10);
    localTextViewWrapLayout.addView((View)localObject, paramString1);
    i = AIOUtils.a(10.0F, localResources);
    paramString1 = new TextView(paramContext);
    paramString1.setId(2131296360);
    paramString1.setText(paramString2);
    paramString1.setTextSize(14.0F);
    paramString1.setTextColor(-8355712);
    paramString1.setTypeface(Typeface.DEFAULT);
    paramString1.setMaxLines(2);
    paramString1.setEllipsize(TextUtils.TruncateAt.END);
    paramString2 = new RelativeLayout.LayoutParams(-1, -2);
    paramString2.topMargin = 0;
    paramString2.leftMargin = i;
    paramString2.addRule(10);
    paramString2.addRule(1, ((AnyScaleTypeImageView)localObject).getId());
    paramString2.addRule(11);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131296361);
    paramContext.setText(paramString3);
    paramContext.setTextSize(14.0F);
    paramContext.setTextColor(-8355712);
    paramContext.setTypeface(Typeface.DEFAULT);
    paramContext.setMaxLines(2);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramString3 = new RelativeLayout.LayoutParams(-1, -2);
    paramString3.topMargin = 0;
    paramString3.leftMargin = i;
    paramString3.addRule(3, paramString1.getId());
    paramString3.addRule(1, ((AnyScaleTypeImageView)localObject).getId());
    localTextViewWrapLayout.addView(paramString1, paramString2);
    localTextViewWrapLayout.addView(paramContext, paramString3);
    localTextViewWrapLayout.a(true);
    return localTextViewWrapLayout;
  }
  
  private RelativeLayout a(Context paramContext, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new RelativeLayout(paramContext);
    a(paramContext);
    d(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int j;
    int k;
    label60:
    int m;
    label76:
    int i;
    if (paramBoolean)
    {
      j = localResources.getDimensionPixelSize(2131493116);
      if (!paramBoolean) {
        break label131;
      }
      k = localResources.getDimensionPixelSize(2131493117);
      if (!a(1)) {
        break label142;
      }
      m = AIOUtils.a(15.0F, localResources);
      i = AIOUtils.a(6.0F, localResources);
      if (!a(2)) {
        break label153;
      }
      i = AIOUtils.a(15.0F, localResources);
    }
    for (;;)
    {
      paramContext.setPadding(j, m, k, i);
      paramContext.setLayoutParams(localLayoutParams);
      return paramContext;
      j = localResources.getDimensionPixelSize(2131493081);
      break;
      label131:
      k = localResources.getDimensionPixelSize(2131493082);
      break label60;
      label142:
      m = AIOUtils.a(6.0F, localResources);
      break label76;
      label153:
      if (a(1)) {
        i = AIOUtils.a(15.0F, localResources);
      }
    }
  }
  
  protected int b()
  {
    return 5;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject3 = paramBundle;
    if (paramBundle == null) {
      localObject3 = new Bundle();
    }
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject5;
    Object localObject4;
    if (((Bundle)localObject3).getBoolean("pre_dialog") == true)
    {
      paramBundle = null;
      localObject2 = null;
      localObject1 = null;
      i = 0;
      localObject5 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (((Iterator)localObject5).hasNext())
      {
        localObject4 = (AbsStructMsgElement)((Iterator)localObject5).next();
        if ((localObject4 instanceof StructMsgItemVideo))
        {
          localObject4 = (StructMsgItemVideo)localObject4;
          if (!((StructMsgItemVideo)localObject4).a()) {
            break label164;
          }
          localObject2 = ((StructMsgItemVideo)localObject4).s;
          localObject4 = ((StructMsgItemVideo)localObject4).da;
          paramBundle = (Bundle)localObject1;
          localObject1 = localObject4;
          i = 1;
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = paramBundle;
      paramBundle = (Bundle)localObject4;
      break;
      if ((localObject4 instanceof StructMsgItemTitle))
      {
        localObject4 = ((StructMsgItemTitle)localObject4).b();
        localObject1 = localObject2;
        localObject2 = paramBundle;
        paramBundle = (Bundle)localObject4;
        continue;
        label164:
        if (i != 0) {
          return a(paramContext, paramBundle, (String)localObject1, (String)localObject2);
        }
        localObject5 = paramContext.getResources();
        boolean bool;
        label219:
        int j;
        int m;
        label265:
        String str;
        label397:
        int n;
        int k;
        if (((Bundle)localObject3).getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA)
        {
          bool = true;
          if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
            break label537;
          }
          localObject2 = (RelativeLayout)paramView;
          ((RelativeLayout)localObject2).removeAllViews();
          localObject1 = null;
          paramView = null;
          paramBundle = "";
          i = -1;
          j = 0;
          m = (int)(TypedValue.applyDimension(1, 175.0F, ((Resources)localObject5).getDisplayMetrics()) + 0.5F);
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label887;
          }
          localObject4 = (AbsStructMsgElement)localIterator.next();
          ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          str = ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangString;
          if (!"title".equals(str)) {
            break label557;
          }
          localObject4 = (StructMsgItemTitle)localObject4;
          if (TextUtils.isEmpty(((StructMsgItemTitle)localObject4).b())) {
            break label1241;
          }
          paramView = new TextView(paramContext);
          paramView.setText(((StructMsgItemTitle)localObject4).b());
          paramBundle = ((StructMsgItemTitle)localObject4).b();
          paramView.setId(2131296360);
          paramView.setTag(localObject4);
          paramView.setGravity(3);
          paramView.setGravity(16);
          if (((Bundle)localObject3).getInt("accostType") != AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
            break label549;
          }
          paramView.setMaxLines(2);
          paramView.setEllipsize(TextUtils.TruncateAt.END);
          paramView.setTextColor(-1);
          paramView.setTextSize(2, 18.0F);
          paramView.setBackgroundColor(paramContext.getResources().getColor(2131427485));
          n = AIOUtils.a(10.0F, (Resources)localObject5);
          int i1 = AIOUtils.a(4.0F, (Resources)localObject5);
          int i2 = AIOUtils.a(5.0F, (Resources)localObject5);
          if (!((Bundle)localObject3).getBoolean("pre_dialog", false)) {
            break label1234;
          }
          k = n * 2;
          label476:
          paramView.setPadding(k, i1, n, i2);
        }
        label537:
        label549:
        label557:
        label685:
        label688:
        label837:
        label887:
        label938:
        label1177:
        label1192:
        label1204:
        label1234:
        label1241:
        for (;;)
        {
          localObject4 = paramBundle;
          k = j;
          paramBundle = paramView;
          paramView = (View)localObject4;
          j = i;
          i = k;
          for (;;)
          {
            localObject4 = paramBundle;
            k = j;
            j = i;
            i = k;
            paramBundle = paramView;
            paramView = (View)localObject4;
            break label265;
            bool = false;
            break;
            localObject2 = a(paramContext, bool);
            break label219;
            paramView.setMaxLines(1);
            break label397;
            if ("picture".equals(str))
            {
              localObject1 = ((AbsStructMsgElement)localObject4).a(paramContext, null, (Bundle)localObject3);
              localObject4 = ((View)localObject1).findViewById(2131296359);
              if ((localObject4 != null) && ((localObject4 instanceof AnyScaleTypeImageView))) {
                ((AnyScaleTypeImageView)localObject4).setTag(2131296575, Integer.valueOf(1));
              }
              k = i;
              localObject4 = paramView;
              i = j;
              j = k;
              paramView = paramBundle;
              paramBundle = (Bundle)localObject4;
            }
            else
            {
              if ("video".equals(str))
              {
                if ((localObject4 instanceof StructMsgItemVideo)) {
                  if (((StructMsgItemVideo)localObject4).a()) {
                    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4))
                    {
                      j = -2;
                      k = 0;
                      i = j;
                      if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
                      {
                        localObject1 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(k);
                        if (!"title".equals(((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString)) {
                          break label837;
                        }
                        ((Bundle)localObject3).putString("public_account_video_title", ((StructMsgItemTitle)localObject1).b());
                        i = j;
                      }
                    }
                  }
                }
                for (;;)
                {
                  ((RelativeLayout)localObject2).setPadding(0, 0, 0, 0);
                  ((RelativeLayout)localObject2).getLayoutParams().width = i;
                  if (((Bundle)localObject3).getBoolean("pre_dialog", false)) {
                    ((LinearLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams()).gravity = 1;
                  }
                  localObject4 = ((AbsStructMsgElement)localObject4).a(paramContext, null, (Bundle)localObject3);
                  k = 1;
                  localObject1 = paramView;
                  j = i;
                  paramView = paramBundle;
                  i = k;
                  paramBundle = (Bundle)localObject1;
                  localObject1 = localObject4;
                  break;
                  j = -1;
                  break label685;
                  k += 1;
                  break label688;
                  i = -2;
                  ((Bundle)localObject3).putBoolean("v_crap_ctn", true);
                  ((Bundle)localObject3).putBoolean("has_cnr", true);
                  ((Bundle)localObject3).putInt("v_height", m);
                  continue;
                  i = -1;
                }
                if (localObject1 != null)
                {
                  if (j != 0) {
                    break label1204;
                  }
                  if (!bool) {
                    break label1177;
                  }
                  i = ((Resources)localObject5).getDimensionPixelSize(2131493116);
                  k = BaseChatItemLayout.B;
                  if (((Bundle)localObject3).getBoolean("hasHeadIcon", true)) {
                    break label1192;
                  }
                  i = BaseChatItemLayout.i - i * 2;
                }
                for (k = (int)(i / 1.8F);; k = m)
                {
                  localObject3 = new RelativeLayout.LayoutParams(i, k);
                  if (j != 0) {
                    localObject3 = new RelativeLayout.LayoutParams(i, -2);
                  }
                  for (;;)
                  {
                    ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                    if ((j != 0) && (!TextUtils.isEmpty(paramBundle)) && ((localObject1 instanceof TitledImageView)))
                    {
                      localObject3 = (TitledImageView)localObject1;
                      ((TitledImageView)localObject3).setTitle(paramBundle);
                      ((TitledImageView)localObject3).setTextColor(-1);
                      ((TitledImageView)localObject3).setTextSize(AIOUtils.a(2, 18, (Resources)localObject5));
                      ((TitledImageView)localObject3).setTextBackground(paramContext.getResources().getColor(2131427485));
                      ((TitledImageView)localObject3).setTextPadding(AIOUtils.a(10.0F, (Resources)localObject5));
                      ((TitledImageView)localObject3).settextBgRadius(AIOUtils.a(12.0F, (Resources)localObject5));
                    }
                    if ((j != 0) && (!TextUtils.isEmpty(paramBundle)))
                    {
                      paramContext = ((View)localObject1).getTag(2131296577);
                      if ((paramContext != null) && ((paramContext instanceof StructMsgItemVideo.Holder))) {
                        ((StructMsgItemVideo.Holder)paramContext).a.setText(paramBundle);
                      }
                    }
                    if ((j == 0) && (paramView != null))
                    {
                      paramContext = new RelativeLayout.LayoutParams(-1, -2);
                      if (localObject1 != null) {
                        paramContext.addRule(8, ((View)localObject1).getId());
                      }
                      ((RelativeLayout)localObject2).addView(paramView, paramContext);
                    }
                    ((RelativeLayout)localObject2).setId(2131296582);
                    return (View)localObject2;
                    i = ((Resources)localObject5).getDimensionPixelSize(2131493081);
                    break;
                  }
                  i = k - i * 2;
                  break label938;
                }
              }
              k = i;
              localObject4 = paramView;
              i = j;
              j = k;
              paramView = paramBundle;
              paramBundle = (Bundle)localObject4;
            }
          }
          k = n;
          break label476;
        }
      }
      else
      {
        localObject4 = paramBundle;
        paramBundle = (Bundle)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
    }
  }
  
  public String b()
  {
    return "Layout5";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemLayout5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */