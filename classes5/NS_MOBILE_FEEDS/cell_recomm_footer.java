package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_recomm_footer
  extends JceStruct
{
  public String text;
  
  public cell_recomm_footer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.text = "";
  }
  
  public cell_recomm_footer(String paramString)
  {
    this.text = "";
    this.text = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.text = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_recomm_footer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */