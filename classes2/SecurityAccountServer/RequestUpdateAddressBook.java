package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RequestUpdateAddressBook
  extends JceStruct
{
  static ArrayList cache_AddressBookAddList;
  static ArrayList cache_AddressBookDelList;
  static byte[] cache_sessionSid;
  public ArrayList AddressBookAddList;
  public ArrayList AddressBookDelList;
  public String MobileUniqueNo;
  public long nextFlag;
  public byte[] sessionSid;
  
  public RequestUpdateAddressBook()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.MobileUniqueNo = "";
  }
  
  public RequestUpdateAddressBook(long paramLong, String paramString, byte[] paramArrayOfByte, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.MobileUniqueNo = "";
    this.nextFlag = paramLong;
    this.MobileUniqueNo = paramString;
    this.sessionSid = paramArrayOfByte;
    this.AddressBookAddList = paramArrayList1;
    this.AddressBookDelList = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.MobileUniqueNo = paramJceInputStream.readString(1, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    AddressBookItem localAddressBookItem;
    if (cache_AddressBookAddList == null)
    {
      cache_AddressBookAddList = new ArrayList();
      localAddressBookItem = new AddressBookItem();
      cache_AddressBookAddList.add(localAddressBookItem);
    }
    this.AddressBookAddList = ((ArrayList)paramJceInputStream.read(cache_AddressBookAddList, 3, true));
    if (cache_AddressBookDelList == null)
    {
      cache_AddressBookDelList = new ArrayList();
      localAddressBookItem = new AddressBookItem();
      cache_AddressBookDelList.add(localAddressBookItem);
    }
    this.AddressBookDelList = ((ArrayList)paramJceInputStream.read(cache_AddressBookDelList, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.MobileUniqueNo, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.AddressBookAddList, 3);
    paramJceOutputStream.write(this.AddressBookDelList, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestUpdateAddressBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */