package com.tencent.mqq.shared_file_accessor;

public final class e
{
  public int a = 0;
  public String b = null;
  
  private e(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (!(paramObject instanceof Integer)) {
        break;
      }
    } while (this.a != ((Integer)paramObject).intValue());
    return true;
    if ((paramObject instanceof String)) {
      return this.b.equals(paramObject);
    }
    return super.equals(paramObject);
  }
  
  public final String toString()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mqq\shared_file_accessor\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */