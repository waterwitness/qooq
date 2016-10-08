package com.tencent.mobileqq.nearby.flat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.flat.adapter.FreshFeedPresenter;
import com.tencent.mobileqq.nearby.flat.canvas.ImageElement;
import com.tencent.mobileqq.nearby.flat.canvas.TextElement;
import com.tencent.mobileqq.nearby.flat.canvas.UIElement;
import com.tencent.mobileqq.nearby.flat.canvas.UIElementGroup;
import com.tencent.mobileqq.nearby.flat.canvas.UIElementHost;
import com.tencent.mobileqq.nearby.flat.canvas.UIElementInflater;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.List;

public class FreshElement
  extends UIElementGroup
  implements FreshFeedPresenter
{
  public ImageElement a;
  public TextElement a;
  public ImageElement b;
  public TextElement b;
  public ImageElement c;
  public TextElement c;
  public ImageElement d;
  public TextElement d;
  public ImageElement e;
  public TextElement e;
  public ImageElement f;
  
  public FreshElement(UIElementHost paramUIElementHost)
  {
    this(paramUIElementHost, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshElement(UIElementHost paramUIElementHost, AttributeSet paramAttributeSet)
  {
    super(paramUIElementHost, paramAttributeSet);
    if (!a()) {
      throw new IllegalStateException("Construct FreshElement error,mHost is null!");
    }
    a();
    UIElementInflater.a(a()).a(2130904175, paramUIElementHost, this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement = ((ImageElement)a(2131297019));
    this.f = ((ImageElement)a(2131301710));
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement = ((TextElement)a(2131296932));
    this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement = ((ImageElement)a(2131301663));
    this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement = ((TextElement)a(2131301664));
    this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement = ((TextElement)a(2131298506));
    this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement = ((TextElement)a(2131298722));
    this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement = ((TextElement)a(2131301714));
    this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement = ((ImageElement)a(2131301711));
    this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement = ((ImageElement)a(2131301712));
    this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement = ((ImageElement)a(2131301713));
  }
  
  int a(UIElement paramUIElement)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramUIElement.a();
    int i = paramUIElement.m();
    int j = localMarginLayoutParams.leftMargin;
    return localMarginLayoutParams.rightMargin + (i + j);
  }
  
  public void a(Context paramContext, FNDefaultItemData paramFNDefaultItemData, Bitmap paramBitmap, FNDefaultItemBuilder paramFNDefaultItemBuilder)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(paramBitmap);
    }
    if (paramFNDefaultItemData.jdField_a_of_type_AndroidTextStaticLayout != null)
    {
      if (NearbyAppInterface.a) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(paramFNDefaultItemData.jdField_a_of_type_AndroidTextStaticLayout);
      }
    }
    else
    {
      if (!paramFNDefaultItemData.jdField_c_of_type_Boolean) {
        break label223;
      }
      this.f.a(0);
      label51:
      if (!paramFNDefaultItemData.jdField_d_of_type_Boolean) {
        break label235;
      }
      this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
      label66:
      this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(paramFNDefaultItemData.jdField_b_of_type_JavaLangString);
      if ((paramFNDefaultItemData.e <= 0) || (TextUtils.isEmpty(paramFNDefaultItemData.jdField_c_of_type_JavaLangString))) {
        break label247;
      }
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(0);
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(paramFNDefaultItemData.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(Integer.valueOf(paramFNDefaultItemData.e));
      label127:
      if (paramFNDefaultItemData.jdField_b_of_type_AndroidTextStaticLayout == null) {
        break label284;
      }
      if (!NearbyAppInterface.a) {
        break label270;
      }
      this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(paramFNDefaultItemData.jdField_b_of_type_AndroidTextStaticLayout);
      label151:
      this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(0);
      label159:
      if (!TextUtils.isEmpty(paramFNDefaultItemData.jdField_b_of_type_JavaLangCharSequence)) {}
      a(paramFNDefaultItemData);
      if (paramFNDefaultItemData.jdField_a_of_type_Int != 1) {
        break label526;
      }
      if ((paramFNDefaultItemData.f <= 0) || ((paramFNDefaultItemData.jdField_a_of_type_JavaUtilList != null) && (paramFNDefaultItemData.jdField_a_of_type_JavaUtilList.size() != 0))) {
        break label296;
      }
    }
    label223:
    label235:
    label247:
    label270:
    label284:
    label296:
    label526:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(paramFNDefaultItemData.jdField_a_of_type_JavaLangCharSequence);
          break;
          this.f.a(8);
          break label51;
          this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(8);
          break label66;
          this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(Integer.valueOf(0));
          this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(8);
          break label127;
          this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(paramFNDefaultItemData.jdField_c_of_type_JavaLangCharSequence);
          break label151;
          this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(8);
          break label159;
          if (paramFNDefaultItemData.jdField_c_of_type_JavaUtilList != null) {}
          for (int i = paramFNDefaultItemData.jdField_c_of_type_JavaUtilList.size();; i = 0)
          {
            if (i > 0)
            {
              paramBitmap = paramFNDefaultItemBuilder.a(paramContext, paramFNDefaultItemData.f);
              paramBitmap = URLDrawable.getDrawable((URL)paramFNDefaultItemData.jdField_c_of_type_JavaUtilList.get(0), paramBitmap);
              paramBitmap.setDownloadListener(new ImgDownloadListener(paramContext));
              this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(paramBitmap);
            }
            if (i > 1)
            {
              paramBitmap = paramFNDefaultItemBuilder.a(paramContext, paramFNDefaultItemData.f);
              paramBitmap = URLDrawable.getDrawable((URL)paramFNDefaultItemData.jdField_c_of_type_JavaUtilList.get(1), paramBitmap);
              paramBitmap.setDownloadListener(new ImgDownloadListener(paramContext));
              this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(paramBitmap);
            }
            if (i <= 2) {
              break;
            }
            paramBitmap = paramFNDefaultItemBuilder.a(paramContext, paramFNDefaultItemData.f);
            paramFNDefaultItemData = URLDrawable.getDrawable((URL)paramFNDefaultItemData.jdField_c_of_type_JavaUtilList.get(2), paramBitmap);
            paramFNDefaultItemData.setDownloadListener(new ImgDownloadListener(paramContext));
            this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(paramFNDefaultItemData);
            if (i <= 3) {
              break;
            }
            this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(i + "张");
            return;
            QLog.d("FreshElement", 1, "itemData.picUrlList is null !!!");
          }
        } while ((paramFNDefaultItemData.f > 0) && ((paramFNDefaultItemData.jdField_d_of_type_JavaUtilList == null) || (paramFNDefaultItemData.jdField_d_of_type_JavaUtilList.size() == 0)));
        if (paramFNDefaultItemData.f > 0)
        {
          paramBitmap = paramFNDefaultItemBuilder.a(paramContext, paramFNDefaultItemData.f);
          paramBitmap = URLDrawable.getDrawable(new File((String)paramFNDefaultItemData.jdField_d_of_type_JavaUtilList.get(0)), paramBitmap);
          paramBitmap.setDownloadListener(new ImgDownloadListener(paramContext));
          this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(paramBitmap);
        }
        if (paramFNDefaultItemData.f > 1)
        {
          paramBitmap = paramFNDefaultItemBuilder.a(paramContext, paramFNDefaultItemData.f);
          paramBitmap = URLDrawable.getDrawable(new File((String)paramFNDefaultItemData.jdField_d_of_type_JavaUtilList.get(1)), paramBitmap);
          paramBitmap.setDownloadListener(new ImgDownloadListener(paramContext));
          this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(paramBitmap);
        }
      } while (paramFNDefaultItemData.f <= 2);
      paramBitmap = paramFNDefaultItemBuilder.a(paramContext, paramFNDefaultItemData.f);
      paramBitmap = URLDrawable.getDrawable(new File((String)paramFNDefaultItemData.jdField_d_of_type_JavaUtilList.get(2)), paramBitmap);
      paramBitmap.setDownloadListener(new ImgDownloadListener(paramContext));
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(paramBitmap);
    } while (paramFNDefaultItemData.f <= 3);
    this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(paramFNDefaultItemData.f + "张");
  }
  
  void a(FNDefaultItemData paramFNDefaultItemData)
  {
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a();
    ViewGroup.LayoutParams localLayoutParams2 = this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a();
    ViewGroup.LayoutParams localLayoutParams3 = this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a();
    if (paramFNDefaultItemData.f == 0)
    {
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(8);
      this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(8);
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(8);
      return;
    }
    if (paramFNDefaultItemData.f == 1)
    {
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
      this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(8);
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(8);
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(8);
      localLayoutParams1.width = FNDefaultItemBuilder.b;
      localLayoutParams1.height = FNDefaultItemBuilder.b;
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams1);
      return;
    }
    if (paramFNDefaultItemData.f == 2)
    {
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
      this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(8);
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(8);
      i = FNDefaultItemBuilder.c;
      localLayoutParams2.width = i;
      localLayoutParams1.width = i;
      i = FNDefaultItemBuilder.c;
      localLayoutParams2.height = i;
      localLayoutParams1.height = i;
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams1);
      this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams2);
      return;
    }
    if (paramFNDefaultItemData.f == 3)
    {
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
      this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(8);
      i = FNDefaultItemBuilder.d;
      localLayoutParams3.width = i;
      localLayoutParams2.width = i;
      localLayoutParams1.width = i;
      i = FNDefaultItemBuilder.d;
      localLayoutParams3.height = i;
      localLayoutParams2.height = i;
      localLayoutParams1.height = i;
      this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams1);
      this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams2);
      this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams3);
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
    this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
    this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(0);
    this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a(0);
    int i = FNDefaultItemBuilder.d;
    localLayoutParams3.width = i;
    localLayoutParams2.width = i;
    localLayoutParams1.width = i;
    i = FNDefaultItemBuilder.d;
    localLayoutParams3.height = i;
    localLayoutParams2.height = i;
    localLayoutParams1.height = i;
    this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams1);
    this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams2);
    this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.a(localLayoutParams3);
  }
  
  public boolean a(UIElementHost paramUIElementHost)
  {
    if (paramUIElementHost == null) {}
    return super.a(paramUIElementHost);
  }
  
  int b(UIElement paramUIElement)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramUIElement.a();
    int i = paramUIElement.c();
    int j = localMarginLayoutParams.topMargin;
    return localMarginLayoutParams.bottomMargin + (i + j);
  }
  
  void b(UIElement paramUIElement, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramUIElement.a();
    paramInt1 = localMarginLayoutParams.leftMargin + paramInt1;
    paramInt2 = localMarginLayoutParams.topMargin + paramInt2;
    paramUIElement.a(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  int c(UIElement paramUIElement)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramUIElement.a();
    int i = paramUIElement.b();
    int j = localMarginLayoutParams.leftMargin;
    return localMarginLayoutParams.rightMargin + (i + j);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getSize(paramInt1);
    if (this.f.h() != 8) {
      a(this.f, paramInt1, 0, paramInt2, 0);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt1, 0, paramInt2, 0);
    int j = 0 + c(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
    int i = c(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement) + 0;
    a(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt1, j, paramInt2, 0);
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.h() != 8) {
      a(this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt1, j, paramInt2, 0);
    }
    c(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement);
    j = 0 + d(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement);
    a(this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt1, i, paramInt2, j);
    int k = c(this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement);
    if (this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.h() != 8) {
      a(this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt1, i + k, paramInt2, j);
    }
    i = d(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
    a(this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt1, 0, paramInt2, i);
    j = i + d(this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement);
    if (this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.h() != 8)
    {
      a(this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt1, 0, paramInt2, j);
      i = c(this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
      j += d(this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
      i += 0;
    }
    for (;;)
    {
      k = i;
      if (this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.h() != 8)
      {
        a(this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt1, 0, paramInt2, j);
        k = i + c(this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
      }
      if (this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.h() != 8)
      {
        a(this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt1, 0, paramInt2, j);
        c(this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
        if (this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.h() != 8) {
          a(this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt1, 0, paramInt2, j);
        }
      }
      b(m, e() + j + g());
      return;
      i = 0;
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = d();
    paramInt1 = e();
    int i;
    if (this.f.h() != 8)
    {
      paramInt3 = ViewUtils.a();
      paramInt4 = f();
      i = this.f.b();
      b(this.f, paramInt3 - paramInt4 - i, paramInt1, this.f.b(), this.f.c());
    }
    b(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt2, paramInt1, this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(), this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.c());
    paramInt3 = a(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement) + paramInt2;
    b(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt3, paramInt1, this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.b(), this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.c());
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.h() != 8)
    {
      paramInt4 = ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a()).leftMargin;
      i = this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.r();
      b(this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt4 + paramInt3 + i, paramInt1, this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(), this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.c());
    }
    paramInt3 = paramInt1 + b(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement);
    paramInt4 = a(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
    b(this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt2 + paramInt4, paramInt3, this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.b(), this.jdField_b_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.c());
    if (this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.h() != 8)
    {
      paramInt2 = ViewUtils.a();
      paramInt4 = ((ViewGroup.MarginLayoutParams)this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.a()).rightMargin;
      i = this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.b();
      b(this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt2 - paramInt4 - i, paramInt3, this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.b(), this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.c());
    }
    paramInt2 = paramInt1 + b(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
    paramInt1 = 0;
    b(this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, 0, paramInt2, this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.b(), this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.c());
    paramInt3 = paramInt2 + b(this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement);
    if (this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.h() != 8)
    {
      b(this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, 0, paramInt3, this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(), this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.c());
      paramInt1 = 0 + a(this.jdField_c_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
    }
    paramInt2 = paramInt1;
    if (this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.h() != 8)
    {
      b(this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt1, paramInt3, this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(), this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.c());
      paramInt2 = paramInt1 + a(this.jdField_d_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement);
    }
    if (this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.h() != 8)
    {
      b(this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement, paramInt2, paramInt3, this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.b(), this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.c());
      if (this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.h() != 8)
      {
        paramInt1 = this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.k();
        paramInt2 = this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.b();
        paramInt3 = this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasImageElement.l();
        paramInt4 = this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.c();
        b(this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement, paramInt1 - paramInt2, paramInt3 - paramInt4, this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.b(), this.jdField_e_of_type_ComTencentMobileqqNearbyFlatCanvasTextElement.c());
      }
    }
  }
  
  int d(UIElement paramUIElement)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramUIElement.a();
    int i = paramUIElement.c();
    int j = localMarginLayoutParams.topMargin;
    return localMarginLayoutParams.bottomMargin + (i + j);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\widget\FreshElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */