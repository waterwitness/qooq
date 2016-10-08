import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.smtt.sdk.stat.DesUtils;
import java.io.UnsupportedEncodingException;

public class wja
  implements Runnable
{
  public wja(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      byte[] arrayOfByte2;
      try
      {
        byte[] arrayOfByte1 = "65dRa93L".getBytes("utf-8");
        if (arrayOfByte1 == null) {
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        arrayOfByte2 = null;
        continue;
      }
      try
      {
        byte[] arrayOfByte3 = "mqq|icon|13".getBytes("utf-8");
        if (arrayOfByte3 == null) {
          continue;
        }
        arrayOfByte2 = DesUtils.DesEncrypt(arrayOfByte2, arrayOfByte3, 1);
        SwiftBrowserTBSHandler.a(this.a, "http://p.mb.qq.com/sdk", arrayOfByte2);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject = null;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */