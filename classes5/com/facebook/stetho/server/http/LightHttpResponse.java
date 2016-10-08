package com.facebook.stetho.server.http;

public class LightHttpResponse
  extends LightHttpMessage
{
  public LightHttpBody body;
  public int code;
  public String reasonPhrase;
  
  public void prepare()
  {
    if (this.body != null)
    {
      addHeader("Content-Type", this.body.contentType());
      addHeader("Content-Length", String.valueOf(this.body.contentLength()));
    }
  }
  
  public void reset()
  {
    super.reset();
    this.code = -1;
    this.reasonPhrase = null;
    this.body = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */