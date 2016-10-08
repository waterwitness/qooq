package wns_proxy;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class HttpRsp
  extends JceStruct
  implements Cloneable
{
  public static final String HTTP_HEADER_END = "\r\n\r\n";
  public static final String HTTP_HEADER_START = "HTTP";
  public String body = "";
  public String rspinfo = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!HttpRsp.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public HttpRsp() {}
  
  public HttpRsp(String paramString)
  {
    this.rspinfo = paramString;
  }
  
  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfByte.length;
    if ((paramInt1 < 0) || (paramInt1 > i)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).display(this.rspinfo, "rspinfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.rspinfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (HttpRsp)paramObject;
    return JceUtil.equals(this.rspinfo, ((HttpRsp)paramObject).rspinfo);
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rspinfo = paramJceInputStream.readString(0, true);
    if (this.rspinfo == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while (this.rspinfo.indexOf("HTTP") < 0);
      i = this.rspinfo.indexOf("\r\n\r\n");
    } while (i < 0);
    this.body = this.rspinfo.substring(i + "\r\n\r\n".length());
  }
  
  public int search(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= paramInt)) {
      return -1;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1.length < paramArrayOfByte2.length))
    {
      return -1;
      paramInt += 1;
    }
    if ((paramInt >= paramArrayOfByte1.length) || (paramArrayOfByte1.length < paramArrayOfByte2.length + paramInt) || (paramInt >= Integer.MAX_VALUE)) {
      return -1;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfByte2.length) || (paramArrayOfByte1[(paramInt + i)] != paramArrayOfByte2[i]))
      {
        if (i != paramArrayOfByte2.length) {
          break;
        }
        return paramInt;
      }
      i += 1;
    }
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rspinfo, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wns_proxy\HttpRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */