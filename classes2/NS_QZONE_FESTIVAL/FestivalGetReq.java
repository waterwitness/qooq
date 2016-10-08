package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class FestivalGetReq
  extends JceStruct
{
  static ArrayList cache__vec_festivals;
  public ArrayList _vec_festivals;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache__vec_festivals = new ArrayList();
    FestivalGetReqItem localFestivalGetReqItem = new FestivalGetReqItem();
    cache__vec_festivals.add(localFestivalGetReqItem);
  }
  
  public FestivalGetReq() {}
  
  public FestivalGetReq(ArrayList paramArrayList)
  {
    this._vec_festivals = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._vec_festivals = ((ArrayList)paramJceInputStream.read(cache__vec_festivals, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this._vec_festivals != null) {
      paramJceOutputStream.write(this._vec_festivals, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_QZONE_FESTIVAL\FestivalGetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */