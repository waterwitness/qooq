package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import java.net.URLEncoder;

public class OpenWebview
{
  public static class Req
    extends BaseReq
  {
    private static final int MAX_URL_LENGHT = 10240;
    public String url;
    
    public boolean checkArgs()
    {
      if ((this.url == null) || (this.url.length() < 0)) {}
      while (this.url.length() > 10240) {
        return false;
      }
      return true;
    }
    
    public int getType()
    {
      return 12;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mm\sdk\modelbiz\OpenWebview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */