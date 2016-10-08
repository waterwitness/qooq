package com.facebook.systrace;

public final class SystraceMessage
{
  private static final Builder NOOP_BUILDER = new NoopBuilder(null);
  
  public static Builder beginSection(long paramLong, String paramString)
  {
    return NOOP_BUILDER;
  }
  
  public static Builder endSection(long paramLong)
  {
    return NOOP_BUILDER;
  }
  
  public static abstract class Builder
  {
    public abstract Builder arg(String paramString, double paramDouble);
    
    public abstract Builder arg(String paramString, int paramInt);
    
    public abstract Builder arg(String paramString, long paramLong);
    
    public abstract Builder arg(String paramString, Object paramObject);
    
    public abstract void flush();
  }
  
  private static abstract interface Flusher
  {
    public abstract void flush(StringBuilder paramStringBuilder);
  }
  
  private static class NoopBuilder
    extends SystraceMessage.Builder
  {
    public SystraceMessage.Builder arg(String paramString, double paramDouble)
    {
      return this;
    }
    
    public SystraceMessage.Builder arg(String paramString, int paramInt)
    {
      return this;
    }
    
    public SystraceMessage.Builder arg(String paramString, long paramLong)
    {
      return this;
    }
    
    public SystraceMessage.Builder arg(String paramString, Object paramObject)
    {
      return this;
    }
    
    public void flush() {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\systrace\SystraceMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */