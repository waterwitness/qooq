import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import java.util.ArrayList;

public class vsq
{
  public static final int a = 0;
  public static final String a = "...";
  public static final int b = 1;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private String b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public vsq(EllipsizingTextView paramEllipsizingTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private float a(int paramInt, TextUtils.TruncateAt paramTruncateAt)
  {
    int k = b() - (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("...");
    if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE)
    {
      if (this.j <= 0) {
        return k / 2;
      }
      if (paramInt == 1)
      {
        if (k < this.j) {
          return k;
        }
        return this.j;
      }
      if (k < this.j) {
        return 0.0F;
      }
      return k - this.j;
    }
    if (paramTruncateAt == TextUtils.TruncateAt.END)
    {
      if (this.j <= 0) {
        return k;
      }
      if (k < this.j) {
        return k;
      }
      return k - this.j;
    }
    return k;
  }
  
  private int a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt < 0) || (paramInt > paramString.length() - 1)) {
      return 0;
    }
    char c1 = paramString.charAt(paramInt);
    paramString = new float[1];
    this.jdField_a_of_type_AndroidTextTextPaint.getTextWidths(String.valueOf(c1), paramString);
    return (int)Math.ceil(paramString[0]);
  }
  
  private String a(int paramInt)
  {
    int n = (int)a(0, TextUtils.TruncateAt.MIDDLE);
    int i1 = this.b.length();
    int m = 0;
    int k = paramInt;
    for (;;)
    {
      if (k < i1)
      {
        m += a(this.b, k);
        if (m <= n) {}
      }
      else
      {
        return this.b.substring(paramInt, k);
      }
      k += 1;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i4 = b();
    int k = 0;
    int m = 0;
    int i1 = 0;
    if (k < this.b.length())
    {
      int n;
      int i2;
      if (this.b.charAt(k) == '\n')
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.b.substring(i1, k));
        n = k + 1;
        m = 0;
        i2 = k;
      }
      for (;;)
      {
        k = i2 + 1;
        i1 = n;
        break;
        int i3 = m + a(this.b, k);
        if (i3 > i4)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(this.b.substring(i1, k));
          n = k;
          i2 = k - 1;
          m = 0;
        }
        else
        {
          i2 = k;
          m = i3;
          n = i1;
          if (k == this.b.length() - 1)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(this.b.substring(i1, this.b.length()));
            i2 = k;
            m = i3;
            n = i1;
          }
        }
      }
    }
  }
  
  private int b()
  {
    return this.c - this.h - this.f;
  }
  
  private String b(int paramInt)
  {
    int n = (int)a(1, TextUtils.TruncateAt.MIDDLE);
    int m = 0;
    int k = paramInt;
    for (;;)
    {
      if (k > 0)
      {
        m += a(this.b, k);
        if (m <= n) {}
      }
      else
      {
        return this.b.substring(k + 1, paramInt + 1);
      }
      k -= 1;
    }
  }
  
  private String c(int paramInt)
  {
    int n = this.b.length();
    int i1 = (int)a(1, TextUtils.TruncateAt.END);
    int m = 0;
    int k = paramInt;
    for (;;)
    {
      if ((k >= n) || (m > i1)) {
        return this.b.substring(paramInt, k - 1);
      }
      m += a(this.b, k);
      k += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    int k = 0;
    int m = 0;
    while (k <= paramInt)
    {
      m += ((String)this.jdField_a_of_type_JavaUtilArrayList.get(k)).length();
      k += 1;
    }
    if (m <= 0) {
      return 0;
    }
    return m - 1;
  }
  
  public void a(Canvas paramCanvas, TextUtils.TruncateAt paramTruncateAt)
  {
    int k;
    int m;
    label30:
    String str2;
    int n;
    String str1;
    if ((this.e > 0) && (this.e <= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      k = this.e;
      m = 0;
      if (m >= k) {
        return;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(m);
      if (paramTruncateAt != TextUtils.TruncateAt.END) {
        break label237;
      }
      if ((k < 2) || (m != k - 1) || (m >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
        break label181;
      }
      n = a(k - 2);
      str1 = c(n + 1) + "...";
    }
    for (;;)
    {
      paramCanvas.drawText(str1, this.f, this.jdField_a_of_type_AndroidTextTextPaint.getTextSize() + this.d * m + this.g, this.jdField_a_of_type_AndroidTextTextPaint);
      m += 1;
      break label30;
      k = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label181:
      str1 = str2;
      if (m == k - 1)
      {
        str1 = str2;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
        {
          str1 = c(0) + "...";
          continue;
          label237:
          str1 = str2;
          if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE) {
            if ((k >= 2) && (m == k - 1) && (m < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
            {
              n = a(k - 2);
              str1 = a(n + 1) + "..." + b(this.b.length() - 1);
            }
            else
            {
              str1 = str2;
              if (m == k - 1)
              {
                str1 = str2;
                if (m < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
                  str1 = a(0) + "..." + b(this.b.length() - 1);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, TextView paramTextView, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramTextView == null)) {
      return;
    }
    this.b = paramString;
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextView.getPaint();
    this.c = paramTextView.getMeasuredWidth();
    this.d = paramTextView.getLineHeight();
    this.f = paramTextView.getPaddingLeft();
    this.g = paramTextView.getPaddingTop();
    this.h = paramTextView.getPaddingRight();
    this.i = paramTextView.getPaddingBottom();
    this.e = paramInt1;
    this.j = paramInt2;
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */