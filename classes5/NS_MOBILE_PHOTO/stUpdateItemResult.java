package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stUpdateItemResult
  extends JceStruct
{
  static stFaceItem cache_faceitem;
  public stFaceItem faceitem;
  public String msg;
  public int ret;
  
  public stUpdateItemResult()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
  }
  
  public stUpdateItemResult(stFaceItem paramstFaceItem, int paramInt, String paramString)
  {
    this.msg = "";
    this.faceitem = paramstFaceItem;
    this.ret = paramInt;
    this.msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_faceitem == null) {
      cache_faceitem = new stFaceItem();
    }
    this.faceitem = ((stFaceItem)paramJceInputStream.read(cache_faceitem, 0, true));
    this.ret = paramJceInputStream.read(this.ret, 1, true);
    this.msg = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.faceitem, 0);
    paramJceOutputStream.write(this.ret, 1);
    paramJceOutputStream.write(this.msg, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\stUpdateItemResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */