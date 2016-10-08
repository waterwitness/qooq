package com.tencent.commonsdk.soload;

public abstract class BufferIterator
{
  public abstract int readInt();
  
  public abstract short readShort();
  
  public abstract void seek(int paramInt);
  
  public abstract void skip(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\soload\BufferIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */