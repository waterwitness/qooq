package cooperation.qzone.share;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Friend
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public Friend()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.jdField_a_of_type_Int = -1;
    this.d = "";
  }
  
  public Friend(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.jdField_a_of_type_Int = -1;
    this.d = "";
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_b_of_type_Int = paramInt;
    this.d = paramString4;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\share\Friend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */