package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestHideContact
  extends JceStruct
{
  static AddressBookItem cache_contact = new AddressBookItem();
  public AddressBookItem contact;
  public boolean isHide = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RequestHideContact() {}
  
  public RequestHideContact(AddressBookItem paramAddressBookItem, boolean paramBoolean)
  {
    this.contact = paramAddressBookItem;
    this.isHide = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.contact = ((AddressBookItem)paramJceInputStream.read(cache_contact, 0, true));
    this.isHide = paramJceInputStream.read(this.isHide, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.contact, 0);
    paramJceOutputStream.write(this.isHide, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestHideContact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */