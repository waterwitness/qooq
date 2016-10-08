package com.tencent.mobileqq.fts.tokenizer.cn;

import com.tencent.mobileqq.fts.tokenizer.Token;
import com.tencent.mobileqq.fts.tokenizer.Tokenizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Reader;

public final class ChineseTokenizer
  extends Tokenizer
{
  private static final int d = 255;
  private static final int e = 1024;
  private int jdField_a_of_type_Int;
  private final char[] jdField_a_of_type_ArrayOfChar;
  private int jdField_b_of_type_Int;
  private final char[] jdField_b_of_type_ArrayOfChar;
  private int c;
  private int f;
  private int g;
  private int h;
  
  public ChineseTokenizer(Reader paramReader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfChar = new char['ÿ'];
    this.jdField_b_of_type_ArrayOfChar = new char['Ѐ'];
    this.h = -1;
    this.jdField_a_of_type_JavaIoReader = paramReader;
  }
  
  private final void a(char paramChar)
  {
    if (this.f == 0) {
      this.g = (this.jdField_a_of_type_Int - 1);
    }
    char[] arrayOfChar = this.jdField_a_of_type_ArrayOfChar;
    int i = this.f;
    this.f = (i + 1);
    arrayOfChar[i] = Character.toLowerCase(paramChar);
  }
  
  private final Token b()
  {
    if (this.f > 0)
    {
      String str2 = "other";
      String str1 = str2;
      switch (Character.getType(this.jdField_a_of_type_ArrayOfChar[0]))
      {
      default: 
        str1 = str2;
      }
      for (;;)
      {
        return new Token(new String(this.jdField_a_of_type_ArrayOfChar, 0, this.f), this.g, this.g + this.f, str1);
        str1 = "num";
        continue;
        str1 = "en";
        continue;
        str1 = "cn";
      }
    }
    return null;
  }
  
  public final Token a()
  {
    this.f = 0;
    this.g = this.jdField_a_of_type_Int;
    char c1;
    do
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_b_of_type_Int >= this.c)
      {
        this.c = this.jdField_a_of_type_JavaIoReader.read(this.jdField_b_of_type_ArrayOfChar);
        this.jdField_b_of_type_Int = 0;
      }
      if (this.c == -1)
      {
        this.h = -1;
        return b();
      }
      char[] arrayOfChar = this.jdField_b_of_type_ArrayOfChar;
      int i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (i + 1);
      c1 = arrayOfChar[i];
      switch (Character.getType(c1))
      {
      }
    } while (this.f <= 0);
    return b();
    if (this.h == -1) {
      this.h = 0;
    }
    do
    {
      do
      {
        a(c1);
        if (this.f != 255) {
          break;
        }
        return b();
      } while (this.h == 0);
      this.h = 0;
    } while (this.f <= 0);
    this.jdField_b_of_type_Int -= 1;
    this.jdField_a_of_type_Int -= 1;
    return b();
    if (this.h == -1) {
      this.h = 1;
    }
    do
    {
      do
      {
        a(c1);
        if (this.f != 255) {
          break;
        }
        return b();
      } while (this.h == 1);
      this.h = 1;
    } while (this.f <= 0);
    this.jdField_b_of_type_Int -= 1;
    this.jdField_a_of_type_Int -= 1;
    return b();
    if (this.h == -1) {
      this.h = 2;
    }
    do
    {
      do
      {
        a(c1);
        return b();
      } while (this.h == 2);
      this.h = 2;
    } while (this.f <= 0);
    this.jdField_b_of_type_Int -= 1;
    this.jdField_a_of_type_Int -= 1;
    return b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\tokenizer\cn\ChineseTokenizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */