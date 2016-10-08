package wns_proxy;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class HttpReq
  extends JceStruct
  implements Cloneable
{
  static int cache_method;
  public String body = "";
  public String domain = "";
  public String header = "";
  public int method;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!HttpReq.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public HttpReq() {}
  
  public HttpReq(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.method = paramInt;
    this.header = paramString1;
    this.body = paramString2;
    this.domain = paramString3;
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
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.method, "method");
    paramStringBuilder.display(this.header, "header");
    paramStringBuilder.display(this.body, "body");
    paramStringBuilder.display(this.domain, "domain");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.method, true);
    paramStringBuilder.displaySimple(this.header, true);
    paramStringBuilder.displaySimple(this.body, true);
    paramStringBuilder.displaySimple(this.domain, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (HttpReq)paramObject;
    } while ((!JceUtil.equals(this.method, ((HttpReq)paramObject).method)) || (!JceUtil.equals(this.header, ((HttpReq)paramObject).header)) || (!JceUtil.equals(this.body, ((HttpReq)paramObject).body)) || (!JceUtil.equals(this.domain, ((HttpReq)paramObject).domain)));
    return true;
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
    this.method = paramJceInputStream.read(this.method, 0, false);
    this.header = paramJceInputStream.readString(1, false);
    this.body = paramJceInputStream.readString(2, false);
    this.domain = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.method, 0);
    if (this.header != null) {
      paramJceOutputStream.write(this.header, 1);
    }
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 2);
    }
    if (this.domain != null) {
      paramJceOutputStream.write(this.domain, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wns_proxy\HttpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */