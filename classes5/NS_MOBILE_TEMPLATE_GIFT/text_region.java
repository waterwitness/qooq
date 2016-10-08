package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class text_region
  extends JceStruct
{
  public int height;
  public int width;
  public int x;
  public int y;
  
  public text_region()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public text_region(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.x = paramJceInputStream.read(this.x, 0, true);
    this.y = paramJceInputStream.read(this.y, 1, true);
    this.width = paramJceInputStream.read(this.width, 2, true);
    this.height = paramJceInputStream.read(this.height, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.x, 0);
    paramJceOutputStream.write(this.y, 1);
    paramJceOutputStream.write(this.width, 2);
    paramJceOutputStream.write(this.height, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_TEMPLATE_GIFT\text_region.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */