import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ugm
  implements Runnable
{
  /* Error */
  public ugm(DCShortVideo paramDCShortVideo, com.tencent.common.app.AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 18	ugm:jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo	Lcom/tencent/mobileqq/richmedia/dc/DCShortVideo;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 20	ugm:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   10: aload_0
    //   11: iload_3
    //   12: putfield 22	ugm:jdField_a_of_type_Int	I
    //   15: aload_0
    //   16: iload 4
    //   18: putfield 24	ugm:jdField_b_of_type_Int	I
    //   21: aload_0
    //   22: aload 5
    //   24: putfield 26	ugm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: aload_0
    //   28: iload 6
    //   30: putfield 28	ugm:c	I
    //   33: aload_0
    //   34: lload 7
    //   36: putfield 30	ugm:jdField_a_of_type_Long	J
    //   39: aload_0
    //   40: invokespecial 33	java/lang/Object:<init>	()V
    //   43: getstatic 39	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   46: istore 9
    //   48: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	ugm
    //   0	49	1	paramDCShortVideo	DCShortVideo
    //   0	49	2	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	49	3	paramInt1	int
    //   0	49	4	paramInt2	int
    //   0	49	5	paramString	String
    //   0	49	6	paramInt3	int
    //   0	49	7	paramLong	long
    //   46	1	9	bool	boolean
  }
  
  public void run()
  {
    Object localObject = new ugq();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, (ugs)localObject);
    ((ugq)localObject).jdField_a_of_type_Long = this.c;
    ((ugq)localObject).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    if (QLog.isDevelopLevel()) {
      QLog.d(DCShortVideo.jdField_a_of_type_JavaLangString, 4, "[reportFullscreenPreview]shortVideoType=" + ((ugq)localObject).f + ", duration=" + ((ugq)localObject).jdField_a_of_type_Long + ",uinType = " + ((ugq)localObject).jdField_b_of_type_Int + ",groupMemCount = " + ((ugq)localObject).c + ",age = " + ((ugq)localObject).d + ",gender = " + ((ugq)localObject).e + ",reprotHour = " + ((ugq)localObject).g + ",netType = " + ((ugq)localObject).h + ",playTimeCost = " + ((ugq)localObject).jdField_b_of_type_Long);
    }
    localObject = new ugy("ShortVideo.FullscreenPreview", ((ugq)localObject).a("ShortVideo.FullscreenPreview"));
    DataReport.a().a((ugy)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */