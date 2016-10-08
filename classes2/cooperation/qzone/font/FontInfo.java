package cooperation.qzone.font;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FontInfo
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public FontInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FontInfo(int paramInt)
  {
    this.a = paramInt;
    this.b = "";
    this.c = "";
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "[id=" + this.a + ",fTypePath=" + this.b + ", tTYpePath=" + this.c + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\font\FontInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */