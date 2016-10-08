package com.tencent.tmdownloader.internal.a;

import java.util.ArrayList;
import java.util.Iterator;

public class e
{
  protected static e a = null;
  protected final ArrayList<l> b = new ArrayList();
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  public void a(l paraml)
  {
    try
    {
      if (!this.b.contains(paraml)) {
        this.b.add(paraml);
      }
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).a(paramString);
      }
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).a(paramString1, paramInt1, paramInt2, paramString2);
      }
    }
    finally {}
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).a(paramString, paramLong1, paramLong2);
      }
    }
    finally {}
  }
  
  public void b(l paraml)
  {
    try
    {
      this.b.remove(paraml);
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */