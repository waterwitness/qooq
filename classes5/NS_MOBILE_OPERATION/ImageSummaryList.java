package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ImageSummaryList
  extends JceStruct
{
  static ArrayList cache_vecImageSummary;
  public ArrayList vecImageSummary;
  
  public ImageSummaryList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ImageSummaryList(ArrayList paramArrayList)
  {
    this.vecImageSummary = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecImageSummary == null)
    {
      cache_vecImageSummary = new ArrayList();
      ImageSummary localImageSummary = new ImageSummary();
      cache_vecImageSummary.add(localImageSummary);
    }
    this.vecImageSummary = ((ArrayList)paramJceInputStream.read(cache_vecImageSummary, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecImageSummary != null) {
      paramJceOutputStream.write(this.vecImageSummary, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\ImageSummaryList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */