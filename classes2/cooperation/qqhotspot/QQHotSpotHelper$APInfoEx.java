package cooperation.qqhotspot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QQHotSpotHelper$APInfoEx
  implements Serializable
{
  public String LogoURL_B;
  public String LogoURL_S;
  public String StoreAdUrl;
  public String StorebannerAdUrl;
  
  public QQHotSpotHelper$APInfoEx()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.StoreAdUrl = "";
    this.StorebannerAdUrl = "";
    this.LogoURL_S = "";
    this.LogoURL_B = "";
  }
  
  public String toString()
  {
    return " APInfoEx = {StoreAdUrl = " + this.StoreAdUrl + " ,StorebannerAdUrl = " + this.StorebannerAdUrl + " ,LogoURL_S = " + this.LogoURL_S + " ,LogoURL_B = " + this.LogoURL_B + " } ";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotHelper$APInfoEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */