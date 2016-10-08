package mqq.observer;

public class ServerNotifyObserver
{
  private String key;
  private int seq;
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte) {}
  
  public void onVerifyClose() {}
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setSeq(int paramInt)
  {
    this.seq = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\observer\ServerNotifyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */