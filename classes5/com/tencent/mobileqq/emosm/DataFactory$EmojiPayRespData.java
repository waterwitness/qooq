package com.tencent.mobileqq.emosm;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DataFactory$EmojiPayRespData
{
  public int a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public DataFactory$EmojiPayRespData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.c = -1;
    this.d = -1;
    this.e = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static EmojiPayRespData a(Bundle paramBundle)
  {
    int j = 0;
    int n = -1;
    String str = "";
    int i;
    int k;
    int m;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("result", -1);
      j = paramBundle.getInt("realSaveNum", 0);
      k = paramBundle.getInt("payChannel", -1);
      m = paramBundle.getInt("payState", -1);
      n = paramBundle.getInt("provideState", -1);
    }
    for (paramBundle = paramBundle.getString("message");; paramBundle = str)
    {
      return new EmojiPayRespData(i, j, k, m, n, paramBundle);
      m = -1;
      k = -1;
      i = -1;
    }
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", this.jdField_a_of_type_Int);
    localBundle.putInt("realSaveNum", this.b);
    localBundle.putInt("payChannel", this.c);
    localBundle.putInt("payState", this.d);
    localBundle.putInt("provideState", this.e);
    localBundle.putString("message", this.jdField_a_of_type_JavaLangString);
    return localBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\DataFactory$EmojiPayRespData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */