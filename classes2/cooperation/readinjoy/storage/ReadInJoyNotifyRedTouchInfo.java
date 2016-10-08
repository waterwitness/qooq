package cooperation.readinjoy.storage;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReadInJoyNotifyRedTouchInfo
{
  public static final int a = 0;
  public static final long a = 1130L;
  public static final String a = Long.toString(1130L);
  public static final int b = 1;
  public static final long b = 3042L;
  public static final String b = Long.toString(3042L);
  public static final int c = 2;
  public static final long c = 1058L;
  public static final String c = Long.toString(1058L);
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public String d = "";
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    switch (this.o)
    {
    default: 
      return 0;
    }
    return this.p;
  }
  
  public int a(ReadInJoyNotifyRedTouchInfo paramReadInJoyNotifyRedTouchInfo)
  {
    int i3 = 1;
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo;
    if (this.o > paramReadInJoyNotifyRedTouchInfo.o)
    {
      localReadInJoyNotifyRedTouchInfo = paramReadInJoyNotifyRedTouchInfo;
      paramReadInJoyNotifyRedTouchInfo = this;
    }
    for (;;)
    {
      int i1;
      switch (localReadInJoyNotifyRedTouchInfo.o)
      {
      default: 
        i1 = 0;
        i2 = 0;
        label61:
        if (i2 == 0) {
          break;
        }
      }
      for (int i2 = i3;; i2 = 0)
      {
        i3 = i2;
        if (i1 != 0) {
          i3 = i2 | 0x2;
        }
        return i3;
        if (paramReadInJoyNotifyRedTouchInfo.o == 0) {
          break;
        }
        i1 = 1;
        i2 = 1;
        break label61;
        if ((paramReadInJoyNotifyRedTouchInfo.o == 1) && (localReadInJoyNotifyRedTouchInfo.p == paramReadInJoyNotifyRedTouchInfo.p)) {
          break;
        }
        i1 = 1;
        i2 = 1;
        break label61;
        if ((paramReadInJoyNotifyRedTouchInfo.o == 2) && (localReadInJoyNotifyRedTouchInfo.d.equals(paramReadInJoyNotifyRedTouchInfo.d))) {
          break;
        }
        i1 = 0;
        i2 = 1;
        break label61;
        if ((paramReadInJoyNotifyRedTouchInfo.o == 3) && (localReadInJoyNotifyRedTouchInfo.q == paramReadInJoyNotifyRedTouchInfo.q)) {
          break;
        }
        i1 = 0;
        i2 = 1;
        break label61;
        if ((paramReadInJoyNotifyRedTouchInfo.o == 4) && (localReadInJoyNotifyRedTouchInfo.d.equals(paramReadInJoyNotifyRedTouchInfo.d))) {
          break;
        }
        i1 = 0;
        i2 = 1;
        break label61;
      }
      localReadInJoyNotifyRedTouchInfo = this;
    }
  }
  
  public boolean a()
  {
    switch (this.o)
    {
    }
    do
    {
      return true;
      return false;
    } while (this.p > 0);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\readinjoy\storage\ReadInJoyNotifyRedTouchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */