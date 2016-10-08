import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qfc
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int c;
  int d;
  int e;
  int f;
  
  public qfc(QQHeadDownloadHandler paramQQHeadDownloadHandler, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.f = paramInt6;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    QQHeadDownloadHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.c, 4, this.e, this.jdField_b_of_type_JavaLangString, this.f, this.jdField_a_of_type_Long);
    String str = this.c + "_" + this.jdField_a_of_type_JavaLangString;
    if (this.c == 32) {
      str = "stranger_" + String.valueOf(this.jdField_b_of_type_Int) + "_" + this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QQHeadDownloadHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler).b(str, true);
      return;
      if (this.c == 16) {
        str = "qcall_" + String.valueOf(this.jdField_b_of_type_Int) + "_" + this.jdField_a_of_type_JavaLangString;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */