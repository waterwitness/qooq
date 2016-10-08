package com.tencent.mobileqq.fts.tokenizer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Reader;

public abstract class Tokenizer
  extends TokenStream
{
  protected Reader a;
  
  public Tokenizer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Tokenizer(Reader paramReader)
  {
    this.a = paramReader;
  }
  
  public void a()
  {
    this.a.close();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\tokenizer\Tokenizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */