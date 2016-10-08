package com.tencent.mobileqq.search.searchengine;

import java.util.List;

public abstract interface ISearchListener
{
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  
  public abstract void a(List paramList);
  
  public abstract void a(List paramList, int paramInt);
  
  public abstract void b(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\searchengine\ISearchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */