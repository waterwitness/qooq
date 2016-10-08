package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import java.util.ArrayList;
import tad;

public class LyricViewInternalDetail
  extends LyricViewInternal
{
  private static final String c = "LyricViewInternalDetail";
  
  public LyricViewInternalDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.x = this.c;
  }
  
  private int c(int paramInt)
  {
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a()))
    {
      Log.e("LyricViewInternalDetail", "computeHilightWhileScrolling -> mLineLyric == null");
      m = 0;
      return m;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a();
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      j = this.r;
      i = this.s;
    }
    for (;;)
    {
      int k = this.c;
      k = this.d;
      m = 0;
      k = j;
      j = m;
      m = i;
      if (k > i) {
        break;
      }
      m = ((Sentence)this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(k)).a();
      int n = this.c;
      j += (m - 1) * this.jdField_e_of_type_Int + n * m + this.d;
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric != null) && (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a() == this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a()))
      {
        m = ((Sentence)this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a.get(k)).a();
        n = this.c;
        j = (m - 1) * this.jdField_e_of_type_Int + n * m + this.d + j;
      }
      for (;;)
      {
        if (paramInt < j) {
          return k;
        }
        k += 1;
        break;
      }
      i -= 1;
      j = 0;
    }
  }
  
  public int a(int paramInt)
  {
    super.a(paramInt);
    this.t = c(this.x + paramInt);
    postInvalidate();
    return this.t;
  }
  
  public void a()
  {
    int m = 0;
    int n = this.c + this.d;
    int j = this.t;
    if (this.jdField_b_of_type_Boolean) {
      j -= this.r;
    }
    for (;;)
    {
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a;
      int i = localArrayList.size();
      int k;
      if (this.jdField_b_of_type_Boolean)
      {
        i = this.r;
        k = this.s;
      }
      for (;;)
      {
        if (j > k) {
          return;
        }
        k = i;
        i = m;
        if (k < j)
        {
          i += ((Sentence)localArrayList.get(k)).a();
          if ((!this.jdField_g_of_type_Boolean) || (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric == null) || (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a == null) || (k >= this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a.size())) {
            break label237;
          }
          if (k >= 0) {}
        }
        label237:
        for (;;)
        {
          k += 1;
          break;
          i = ((Sentence)this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a.get(k)).a() + i;
          continue;
          if (this.z >= 0)
          {
            this.v = (this.jdField_g_of_type_Int + (i + 1 - this.z) * n - this.d);
            return;
          }
          this.v = (this.jdField_g_of_type_Int + (i - this.y - this.z) * n - this.d);
          return;
        }
        k = i - 1;
        i = 0;
      }
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    int n = this.c + this.d;
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a;
    int k = localArrayList.size();
    int j = this.t;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    int i1;
    if (i >= k)
    {
      j = k - 1;
      if (localArrayList.isEmpty()) {
        break label394;
      }
      i1 = paramInt + b();
      i = this.jdField_g_of_type_Int;
      if (!this.jdField_b_of_type_Boolean) {
        break label395;
      }
      paramInt = this.r;
      k = this.s;
    }
    for (;;)
    {
      int m = paramInt;
      label98:
      if (m <= k)
      {
        Sentence localSentence = (Sentence)localArrayList.get(m);
        paramInt = Math.abs(m - j);
        if (paramInt == 0) {
          if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.d == 2) && (this.j))
          {
            a(localSentence, paramCanvas, i1, i);
            paramInt = i + localSentence.a() * n;
            label177:
            a(paramCanvas, i1, paramInt, true, m, null);
            label189:
            i = paramInt;
            if (this.jdField_g_of_type_Boolean)
            {
              i = paramInt;
              if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric != null)
              {
                i = paramInt;
                if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a != null)
                {
                  i = paramInt;
                  if (m < this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a.size()) {
                    if (m >= 0) {
                      break label366;
                    }
                  }
                }
              }
            }
          }
        }
        label366:
        for (i = paramInt;; i = paramInt + ((Sentence)this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a.get(m)).a() * n)
        {
          m += 1;
          break label98;
          j = i;
          break;
          a(localSentence, paramCanvas, i1, i, this.j);
          paramInt = i + localSentence.a() * n;
          break label177;
          if ((paramInt > 0) && (paramInt <= this.y))
          {
            a(localSentence, paramCanvas, i1, i, this.jdField_a_of_type_AndroidGraphicsPaint);
            paramInt = i + localSentence.a() * n;
            a(paramCanvas, i1, paramInt, false, m, this.jdField_a_of_type_AndroidGraphicsPaint);
            break label189;
          }
          paramInt = i + localSentence.a() * n;
          break label189;
        }
      }
      label394:
      return;
      label395:
      k -= 1;
      paramInt = 0;
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, Paint paramPaint)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric != null) && (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a != null))
    {
      paramPaint = this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a;
      if ((paramInt3 < paramPaint.size()) && (paramInt3 >= 0)) {}
    }
    else
    {
      return;
    }
    if ((paramBoolean) && (!this.jdField_e_of_type_Boolean))
    {
      a((Sentence)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2);
      return;
    }
    a((Sentence)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2, this.jdField_a_of_type_AndroidGraphicsPaint, this.i);
  }
  
  public void a(boolean paramBoolean)
  {
    Log.d("LyricViewInternalDetail", "showLyricPronounce:" + paramBoolean);
    if (this.jdField_g_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_g_of_type_Boolean = paramBoolean;
    this.f = false;
    post(new tad(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\widget\LyricViewInternalDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */