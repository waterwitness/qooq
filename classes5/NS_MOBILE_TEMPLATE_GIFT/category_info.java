package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class category_info
  extends JceStruct
{
  public int categoryId;
  public String name;
  
  public category_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = "";
  }
  
  public category_info(String paramString, int paramInt)
  {
    this.name = "";
    this.name = paramString;
    this.categoryId = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, true);
    this.categoryId = paramJceInputStream.read(this.categoryId, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.name, 0);
    paramJceOutputStream.write(this.categoryId, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_TEMPLATE_GIFT\category_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */