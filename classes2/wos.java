import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class wos
{
  public static final int a = 0;
  private static wos jdField_a_of_type_Wos;
  public static final int b = 1;
  private static wos b;
  private static final int c = 9000;
  private static final int d = 1800;
  private static final int e = 6000;
  private static final int f = 1200;
  private static final int g = 3;
  private static final int h = 100;
  private static final int i = 3;
  private long jdField_a_of_type_Long;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public wos(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 0;
    this.k = 0;
    this.l = 9000;
    this.m = 1800;
    this.j = paramInt;
    this.k = 0;
    if (this.j == 0) {
      this.l = 9000;
    }
    for (this.m = 1800;; this.m = 1200)
    {
      this.jdField_a_of_type_Long = 0L;
      this.n = 0;
      this.jdField_a_of_type_ArrayOfInt = new int[3];
      paramInt = 0;
      while (paramInt < 3)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
        paramInt += 1;
      }
      this.l = 6000;
    }
  }
  
  public static wos a(int paramInt)
  {
    if (paramInt == 0)
    {
      if (jdField_a_of_type_Wos == null) {
        jdField_a_of_type_Wos = new wos(0);
      }
      return jdField_a_of_type_Wos;
    }
    if (b == null) {
      b = new wos(1);
    }
    return b;
  }
  
  private void b()
  {
    int i1 = 0;
    while (i1 < 3)
    {
      this.jdField_a_of_type_ArrayOfInt[i1] = 0;
      i1 += 1;
    }
    this.n = 0;
  }
  
  private int c()
  {
    int i1 = 0;
    int i2 = 0;
    int i4;
    for (int i3 = 0; i1 < 3; i3 = i4)
    {
      int i5 = i2;
      i4 = i3;
      if (this.jdField_a_of_type_ArrayOfInt[i1] > 0)
      {
        i4 = i3 + 1;
        i5 = i2 + this.jdField_a_of_type_ArrayOfInt[i1];
      }
      i1 += 1;
      i2 = i5;
    }
    if (i3 > 0) {
      return i2 / i3;
    }
    return 0;
  }
  
  public int a()
  {
    if (2 == this.k) {
      return this.l;
    }
    return this.m;
  }
  
  public void a()
  {
    int i2 = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    int i3 = c();
    int i1;
    if (this.k == 2)
    {
      i1 = this.l;
      if (i3 != 0) {
        break label90;
      }
      i1 *= 3;
      label36:
      if (i2 > 100) {
        if (i2 <= i1) {
          break label97;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfInt[this.n] = ((int)(i1 * 1.2F));
      i1 = this.n + 1;
      this.n = i1;
      this.n = (i1 % 3);
      return;
      i1 = this.m;
      break;
      label90:
      i1 = i3 * 3;
      break label36;
      label97:
      i1 = i2;
    }
  }
  
  public int b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int i2 = HttpUtil.a();
    int i1;
    if (this.k != i2)
    {
      i1 = 1;
      this.k = i2;
      if (i1 == 0) {
        break label62;
      }
      if (this.k != 2) {
        break label54;
      }
      i1 = this.l;
      label43:
      b();
    }
    label54:
    label62:
    do
    {
      return i1;
      i1 = 0;
      break;
      i1 = this.m;
      break label43;
      i2 = c();
      i1 = i2;
    } while (i2 > 0);
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */