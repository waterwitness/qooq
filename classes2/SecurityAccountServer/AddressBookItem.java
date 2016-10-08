package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AddressBookItem
  extends JceStruct
{
  public String mobileNo;
  public String name;
  
  public AddressBookItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mobileNo = "";
    this.name = "";
  }
  
  public AddressBookItem(String paramString1, String paramString2)
  {
    this.mobileNo = "";
    this.name = "";
    this.mobileNo = paramString1;
    this.name = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mobileNo = paramJceInputStream.readString(0, true);
    this.name = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mobileNo, 0);
    paramJceOutputStream.write(this.name, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\AddressBookItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */