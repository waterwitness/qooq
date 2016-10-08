package com.facebook.quicklog;

public class QuickPerformanceLoggerProvider
{
  private static final QuickPerformanceLogger sQuickPerformanceLogger = new QuickPerformanceLogger();
  
  public static QuickPerformanceLogger getQPLInstance()
  {
    return sQuickPerformanceLogger;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\quicklog\QuickPerformanceLoggerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */