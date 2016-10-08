import com.tencent.bitapp.preDownload.RNEarlyDOwnloadListener;
import com.tencent.bitapp.preDownload.RNPreDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hea
  extends RNEarlyDOwnloadListener
{
  public hea(RNPreDownloadHandler paramRNPreDownloadHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(XmlData paramXmlData)
  {
    this.a.a = true;
    super.a(paramXmlData);
  }
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    super.a(paramXmlData, paramLong1, paramLong2);
    this.a.a(paramLong1, paramLong2);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    super.a(paramXmlData, paramBoolean1, paramInt, paramBoolean2, paramString);
    this.a.a = false;
    if (paramBoolean1)
    {
      this.a.a(true, 0);
      return;
    }
    this.a.a(false, paramInt);
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    this.a.a = false;
    this.a.a(false, -102);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */