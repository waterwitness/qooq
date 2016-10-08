package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class QueryADBannerRsp
  extends JceStruct
{
  static ArrayList cache_vecAdBanner;
  public ArrayList vecAdBanner;
  
  public QueryADBannerRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QueryADBannerRsp(ArrayList paramArrayList)
  {
    this.vecAdBanner = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecAdBanner == null)
    {
      cache_vecAdBanner = new ArrayList();
      QueryADBannerUnit localQueryADBannerUnit = new QueryADBannerUnit();
      cache_vecAdBanner.add(localQueryADBannerUnit);
    }
    this.vecAdBanner = ((ArrayList)paramJceInputStream.read(cache_vecAdBanner, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecAdBanner, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_AD_BANNER\QueryADBannerRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */