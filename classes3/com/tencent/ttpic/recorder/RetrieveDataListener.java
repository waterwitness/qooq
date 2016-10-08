package com.tencent.ttpic.recorder;

public abstract interface RetrieveDataListener
{
  public abstract void retrieveData(int paramInt, byte[] paramArrayOfByte);
  
  public static enum DATA_TYPE
  {
    RGBA(0),  YUV(1);
    
    public int value;
    
    private DATA_TYPE(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\recorder\RetrieveDataListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */