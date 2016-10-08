import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.IntentFactory;
import com.tencent.open.downloadnew.common.NoticeParam;

public final class wpo
  implements Runnable
{
  /* Error */
  public wpo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 19	wpo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 21	wpo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: aload_3
    //   12: putfield 23	wpo:c	Ljava/lang/String;
    //   15: aload_0
    //   16: aload 4
    //   18: putfield 25	wpo:d	Ljava/lang/String;
    //   21: aload_0
    //   22: aload 5
    //   24: putfield 27	wpo:e	Ljava/lang/String;
    //   27: aload_0
    //   28: aload 6
    //   30: putfield 29	wpo:f	Ljava/lang/String;
    //   33: aload_0
    //   34: aload 7
    //   36: putfield 31	wpo:g	Ljava/lang/String;
    //   39: aload_0
    //   40: iload 8
    //   42: putfield 33	wpo:jdField_a_of_type_Int	I
    //   45: aload_0
    //   46: invokespecial 36	java/lang/Object:<init>	()V
    //   49: getstatic 42	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   52: istore 9
    //   54: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	wpo
    //   0	55	1	paramString1	String
    //   0	55	2	paramString2	String
    //   0	55	3	paramString3	String
    //   0	55	4	paramString4	String
    //   0	55	5	paramString5	String
    //   0	55	6	paramString6	String
    //   0	55	7	paramString7	String
    //   0	55	8	paramInt	int
    //   52	1	9	bool	boolean
  }
  
  public void run()
  {
    NoticeParam localNoticeParam = new NoticeParam();
    localNoticeParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localNoticeParam.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localNoticeParam.d = this.c;
    localNoticeParam.f = this.d;
    localNoticeParam.c = "";
    localNoticeParam.e = this.e;
    localNoticeParam.jdField_b_of_type_Int = 4;
    localNoticeParam.jdField_a_of_type_AndroidContentIntent = IntentFactory.a(this.f, this.g, this.jdField_a_of_type_Int);
    AppNotificationManager.a().a(localNoticeParam);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */