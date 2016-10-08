import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class izb
  implements Cloneable
{
  public double a;
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  
  public izb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
    this.c = -1;
    this.d = -1;
    this.e = -1;
    this.f = -1;
    this.jdField_a_of_type_Double = -1.0D;
    this.jdField_g_of_type_Int = 1;
    this.o = "0";
  }
  
  public izb(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
    this.c = -1;
    this.d = -1;
    this.e = -1;
    this.f = -1;
    this.jdField_a_of_type_Double = -1.0D;
    this.jdField_g_of_type_Int = 1;
    this.o = "0";
    this.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public izb a()
  {
    return (izb)super.clone();
  }
  
  public boolean a()
  {
    if (this.i != null) {
      return this.i.startsWith("image");
    }
    return false;
  }
  
  public boolean b()
  {
    if (this.i != null) {
      return this.i.startsWith("video");
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.i != null) {
      return this.i.startsWith("audio");
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */