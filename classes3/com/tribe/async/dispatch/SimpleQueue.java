package com.tribe.async.dispatch;

public abstract interface SimpleQueue<ITEM>
{
  public abstract void dump();
  
  public abstract void enqueue(ITEM paramITEM);
  
  public abstract ITEM poll();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\dispatch\SimpleQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */