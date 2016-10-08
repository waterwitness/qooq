package cooperation.qqhotspot;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QQHotSpotHelper$APInfo
  implements Serializable
{
  public String AuthType;
  public String AuthURL;
  public String BSSID;
  public String ClosePassURL;
  public String From;
  public String ManuID;
  public String QQAuthURL;
  public String QueryInterfaceURL;
  public String RequestPassUrl;
  public String SSID;
  public int SignLevel;
  public String StoreName;
  public String WiFiID;
  
  public QQHotSpotHelper$APInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.AuthType = "1";
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof APInfo)) {}
    do
    {
      return false;
      paramObject = (APInfo)paramObject;
    } while ((!TextUtils.equals(((APInfo)paramObject).SSID, this.SSID)) || (!TextUtils.equals(((APInfo)paramObject).WiFiID, this.WiFiID)) || (!TextUtils.equals(((APInfo)paramObject).AuthType, this.AuthType)) || (!TextUtils.equals(((APInfo)paramObject).StoreName, this.StoreName)) || (!TextUtils.equals(((APInfo)paramObject).ManuID, this.ManuID)));
    return true;
  }
  
  public String toString()
  {
    return " ApInfo = {SSID = " + this.SSID + " , WiFiID = " + this.WiFiID + " , AuthType = " + this.AuthType + " , StoreName = " + this.StoreName + " , From = " + this.From + " , ManuID = " + this.ManuID + " } ";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotHelper$APInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */