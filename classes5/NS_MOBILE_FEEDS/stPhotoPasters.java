package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class stPhotoPasters
  extends JceStruct
{
  static ArrayList cache_photopaster;
  public ArrayList photopaster;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_photopaster = new ArrayList();
    stPhotoPaster localstPhotoPaster = new stPhotoPaster();
    cache_photopaster.add(localstPhotoPaster);
  }
  
  public stPhotoPasters() {}
  
  public stPhotoPasters(ArrayList paramArrayList)
  {
    this.photopaster = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photopaster = ((ArrayList)paramJceInputStream.read(cache_photopaster, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.photopaster != null) {
      paramJceOutputStream.write(this.photopaster, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\stPhotoPasters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */