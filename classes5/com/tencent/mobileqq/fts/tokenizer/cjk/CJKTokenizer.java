package com.tencent.mobileqq.fts.tokenizer.cjk;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.tokenizer.Token;
import com.tencent.mobileqq.fts.tokenizer.Tokenizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Reader;

public final class CJKTokenizer
  extends Tokenizer
{
  private static final int jdField_a_of_type_Int = 255;
  public static final String a = "digit";
  private static final int jdField_b_of_type_Int = 1024;
  public static final String b = "letter";
  public static final String c = "double";
  private boolean jdField_a_of_type_Boolean;
  private final char[] jdField_a_of_type_ArrayOfChar;
  private final char[] jdField_b_of_type_ArrayOfChar;
  private int c;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int e;
  private int f;
  
  public CJKTokenizer(Reader paramReader, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfChar = new char['ÿ'];
    this.b = new char['Ѐ'];
    this.jdField_d_of_type_JavaLangString = "word";
    this.jdField_a_of_type_JavaIoReader = paramReader;
    this.c = paramInt;
  }
  
  public final Token a()
  {
    int m = this.jdField_d_of_type_Int;
    int k = 0;
    for (;;)
    {
      this.jdField_d_of_type_Int += 1;
      if (this.e >= this.f)
      {
        this.f = this.jdField_a_of_type_JavaIoReader.read(this.b);
        this.e = 0;
      }
      int n;
      if (this.f == -1) {
        if (k > 0)
        {
          n = m;
          if (this.jdField_a_of_type_Boolean == true)
          {
            this.jdField_a_of_type_Boolean = false;
            k = 0;
            n = m;
          }
        }
      }
      int i1;
      for (;;)
      {
        if ((n == this.c - 1) && (k == 0))
        {
          return null;
          return null;
          Object localObject = this.b;
          n = this.e;
          this.e = (n + 1);
          int j = localObject[n];
          localObject = Character.UnicodeBlock.of(j);
          if ((localObject == Character.UnicodeBlock.BASIC_LATIN) || (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
          {
            int i = j;
            char c1;
            if (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
              c1 = (char)(j - 65248);
            }
            if (Character.isLetter(c1))
            {
              if (k == 0) {
                n = this.jdField_d_of_type_Int - 1;
              }
              do
              {
                localObject = this.jdField_a_of_type_ArrayOfChar;
                m = k + 1;
                localObject[k] = Character.toLowerCase(c1);
                this.jdField_d_of_type_JavaLangString = "letter";
                i1 = n;
                k = m;
                if (m != 255) {
                  break label718;
                }
                k = m;
                break;
                if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, "double")) {
                  break label261;
                }
                n = m;
              } while (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, "digit"));
              label261:
              this.jdField_d_of_type_Int -= 1;
              this.e -= 1;
              this.jdField_d_of_type_JavaLangString = "letter";
              n = m;
              if (this.jdField_a_of_type_Boolean != true) {
                continue;
              }
              this.jdField_a_of_type_Boolean = false;
              k = 0;
              n = m;
              continue;
            }
            if (Character.isDigit(c1))
            {
              if (k == 0) {
                n = this.jdField_d_of_type_Int - 1;
              }
              do
              {
                localObject = this.jdField_a_of_type_ArrayOfChar;
                m = k + 1;
                localObject[k] = Character.toLowerCase(c1);
                this.jdField_d_of_type_JavaLangString = "digit";
                i1 = n;
                k = m;
                if (m != 255) {
                  break label718;
                }
                k = m;
                break;
                if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, "double")) {
                  break label410;
                }
                n = m;
              } while (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, "letter"));
              label410:
              this.jdField_d_of_type_Int -= 1;
              this.e -= 1;
              this.jdField_d_of_type_JavaLangString = "digit";
              n = m;
              if (this.jdField_a_of_type_Boolean != true) {
                continue;
              }
              this.jdField_a_of_type_Boolean = false;
              k = 0;
              n = m;
              continue;
            }
            if (k <= 0) {
              break;
            }
            n = m;
            if (this.jdField_a_of_type_Boolean != true) {
              continue;
            }
            this.jdField_a_of_type_Boolean = false;
            k = 0;
            break;
          }
          if (Character.isLetter(j))
          {
            if (k == 0)
            {
              m = this.jdField_d_of_type_Int - 1;
              this.jdField_a_of_type_ArrayOfChar[k] = j;
              this.jdField_d_of_type_JavaLangString = "double";
              k += 1;
              break;
            }
            if ((TextUtils.equals(this.jdField_d_of_type_JavaLangString, "letter")) || (TextUtils.equals(this.jdField_d_of_type_JavaLangString, "digit")))
            {
              this.jdField_d_of_type_Int -= 1;
              this.e -= 1;
              n = m;
              continue;
            }
            localObject = this.jdField_a_of_type_ArrayOfChar;
            n = k + 1;
            localObject[k] = j;
            this.jdField_d_of_type_JavaLangString = "double";
            i1 = m;
            k = n;
            if (n != 2) {
              break label718;
            }
            this.jdField_d_of_type_Int -= 1;
            this.e -= 1;
            this.jdField_a_of_type_Boolean = true;
            k = n;
            n = m;
            continue;
          }
          if (k <= 0) {
            break;
          }
          n = m;
          if (this.jdField_a_of_type_Boolean == true)
          {
            this.jdField_a_of_type_Boolean = false;
            k = 0;
            break;
          }
        }
      }
      return new Token(new String(this.jdField_a_of_type_ArrayOfChar, 0, k), n, k + n, this.jdField_d_of_type_JavaLangString);
      label718:
      m = i1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\tokenizer\cjk\CJKTokenizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */