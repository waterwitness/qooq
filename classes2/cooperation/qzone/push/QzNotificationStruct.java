package cooperation.qzone.push;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QzNotificationStruct
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public QzNotificationStruct(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
    this.d = paramString4;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\push\QzNotificationStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */