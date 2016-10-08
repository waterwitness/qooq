package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ParserFactory
{
  public static final int a = 80000000;
  public static final int b = 80000001;
  public static final int c = 80000002;
  public static final int d = 80000003;
  
  public ParserFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static INetSearchResultParser a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 80000000: 
      return new ContactParser();
    case 80000001: 
      return new TroopParser();
    case 80000002: 
      return new PublicAcntParser();
    }
    return new ArticleParser();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\net\parser\ParserFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */