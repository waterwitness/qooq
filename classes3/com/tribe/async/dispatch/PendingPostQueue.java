package com.tribe.async.dispatch;

final class PendingPostQueue
  implements SimpleQueue<PendingPost>
{
  private PendingPost mHead;
  private PendingPost mTail;
  
  public void dump() {}
  
  public void enqueue(PendingPost paramPendingPost)
  {
    if (paramPendingPost == null) {
      try
      {
        throw new NullPointerException("null cannot be enqueued");
      }
      finally {}
    }
    if (this.mTail != null)
    {
      this.mTail.next = paramPendingPost;
      this.mTail = paramPendingPost;
    }
    for (;;)
    {
      notifyAll();
      return;
      if (this.mHead != null) {
        break;
      }
      this.mTail = paramPendingPost;
      this.mHead = paramPendingPost;
    }
    throw new IllegalStateException("Head present, but no tail");
  }
  
  public PendingPost poll()
  {
    try
    {
      PendingPost localPendingPost = this.mHead;
      if (this.mHead != null)
      {
        this.mHead = this.mHead.next;
        if (this.mHead == null) {
          this.mTail = null;
        }
      }
      return localPendingPost;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public PendingPost poll(int paramInt)
    throws InterruptedException
  {
    try
    {
      if (this.mHead == null) {
        wait(paramInt);
      }
      PendingPost localPendingPost = poll();
      return localPendingPost;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\dispatch\PendingPostQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */