package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_part_error
  extends JceStruct
{
  public int is_happen;
  public String part_error_msg;
  public int part_error_place;
  
  public s_part_error()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.part_error_msg = "";
  }
  
  public s_part_error(int paramInt1, int paramInt2, String paramString)
  {
    this.part_error_msg = "";
    this.is_happen = paramInt1;
    this.part_error_place = paramInt2;
    this.part_error_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_happen = paramJceInputStream.read(this.is_happen, 0, false);
    this.part_error_place = paramJceInputStream.read(this.part_error_place, 1, false);
    this.part_error_msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_happen, 0);
    paramJceOutputStream.write(this.part_error_place, 1);
    if (this.part_error_msg != null) {
      paramJceOutputStream.write(this.part_error_msg, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_part_error.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */