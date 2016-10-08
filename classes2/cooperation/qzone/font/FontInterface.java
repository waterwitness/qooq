package cooperation.qzone.font;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class FontInterface
{
  public FontInterface()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult)
  {
    return FontManager.a().a(paramInt, paramString1, paramString2, paramFullTypeResult);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    return a(paramInt, paramString1, paramString2, true, paramTrueTypeResult);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    return FontManager.a().a(paramInt, paramString1, paramString2, paramBoolean, paramTrueTypeResult);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\font\FontInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */