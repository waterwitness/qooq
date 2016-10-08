package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FaceListItem
  extends LinearLayout
{
  public static final int a = 5;
  public static final int b = 3;
  private static final String b = "FaceListItem";
  public static final int c = 2;
  public String a;
  public int d;
  public int e;
  
  public FaceListItem(Context paramContext, int paramInt)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = paramInt;
    c();
  }
  
  public FaceListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void a()
  {
    int j = this.e / this.d;
    int k = DisplayUtil.b(getContext(), 3.0F);
    int i = 0;
    while (i < this.d)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2130904457, null);
      localView.setLayoutParams(new ViewGroup.LayoutParams(j - k * 2, j - k * 2));
      addView(localView);
      i += 1;
    }
  }
  
  private void b()
  {
    int k = 0;
    int n = this.e / this.d;
    int i;
    if (this.d == 3) {
      i = NormalFaceAdapter.b;
    }
    for (;;)
    {
      int m = (n - i) / 2;
      i = m;
      int j = k;
      if (m < 0)
      {
        i = 0;
        j = k;
      }
      for (;;)
      {
        if (j < this.d)
        {
          ImageView localImageView = new ImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, n);
          if (j == 0) {
            localLayoutParams.leftMargin = DisplayUtil.b(getContext(), 7.0F);
          }
          if (j == this.d - 1) {
            localLayoutParams.rightMargin = DisplayUtil.b(getContext(), 7.0F);
          }
          localImageView.setLayoutParams(localLayoutParams);
          localImageView.setPadding(i, i, i, i);
          addView(localImageView);
          j += 1;
          continue;
          if (this.d != 5) {
            break label170;
          }
          i = NormalFaceAdapter.c;
          break;
        }
      }
      return;
      label170:
      i = 0;
    }
  }
  
  private void c()
  {
    setOrientation(0);
    setGravity(17);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public View a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.d)) {
      throw new IndexOutOfBoundsException("Invalid index " + paramInt + ", size is " + this.d);
    }
    return getChildAt(paramInt);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString.equals("NormalFacePackage")) {
      if (paramInt == 0)
      {
        this.d = 5;
        b();
      }
    }
    while (!paramString.equals("LocationFacePackage")) {
      for (;;)
      {
        return;
        this.d = 3;
      }
    }
    this.d = 2;
    a();
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.a == null) || (!this.a.equals(paramString)))
    {
      removeAllViews();
      a(paramString, paramInt);
      this.a = paramString;
      return true;
    }
    this.a = paramString;
    return false;
  }
  
  public void setEffectiveChildCount(int paramInt)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = paramInt;
      if (i >= paramInt) {
        break;
      }
      j = paramInt;
      if (i >= getChildCount()) {
        break;
      }
      getChildAt(i).setVisibility(0);
      i += 1;
    }
    while ((j < this.d) && (j < getChildCount()))
    {
      getChildAt(j).setVisibility(4);
      j += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\FaceListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */