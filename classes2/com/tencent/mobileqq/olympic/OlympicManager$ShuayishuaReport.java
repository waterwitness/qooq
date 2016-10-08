package com.tencent.mobileqq.olympic;

import android.os.Handler;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import trl;

public class OlympicManager$ShuayishuaReport
  implements Runnable
{
  public static final int a = 1;
  public static final int b = 2;
  private long jdField_a_of_type_Long;
  private SparseArrayCompat jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  
  public OlympicManager$ShuayishuaReport(OlympicManager paramOlympicManager, AppRuntime paramAppRuntime, SparseArrayCompat paramSparseArrayCompat, int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = paramSparseArrayCompat;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) || (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() <= 0)) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    int k;
    int j;
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
      {
        localArrayList1 = new ArrayList(100);
        localArrayList2 = new ArrayList(60);
        localArrayList3 = new ArrayList(1);
        localArrayList4 = new ArrayList(1);
        Object localObject1 = new LongSparseArray(60);
        k = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i);
        Object localObject2 = (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(k);
        if (localObject2 != null)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a, "CliOper", "", "", "0X80069C7", "0X80069C7", 0, 0, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a.a(), String.valueOf(((ArrayList)localObject2).size()), "", "");
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Long localLong = (Long)((Iterator)localObject2).next();
            if (this.c == 1) {}
            for (j = 1000;; j = 60000)
            {
              l = localLong.longValue() / j * j;
              if (((LongSparseArray)localObject1).a(l) == null) {
                break label259;
              }
              ((LongSparseArray)localObject1).a(l, Integer.valueOf(((Integer)((LongSparseArray)localObject1).a(l)).intValue() + 1));
              break;
            }
            label259:
            ((LongSparseArray)localObject1).a(l, Integer.valueOf(1));
          }
        }
        j = 0;
        if (j < ((LongSparseArray)localObject1).a())
        {
          localObject2 = new OlympicServlet.ReportRecord();
          l = ((LongSparseArray)localObject1).a(j);
          ((OlympicServlet.ReportRecord)localObject2).time_stamp = l;
          ((OlympicServlet.ReportRecord)localObject2).count = ((int)((Integer)((LongSparseArray)localObject1).a(l)).intValue());
          if (this.c == 1) {
            localArrayList2.add(localObject2);
          }
          for (;;)
          {
            j += 1;
            break;
            localArrayList1.add(localObject2);
          }
        }
        if (this.c == 1)
        {
          localObject1 = new OlympicServlet.ReportRecord();
          ((OlympicServlet.ReportRecord)localObject1).time_stamp = this.jdField_a_of_type_Long;
          ((OlympicServlet.ReportRecord)localObject1).count = this.d;
          localArrayList3.add(localObject1);
          localObject1 = new OlympicServlet.ReportRecord();
          ((OlympicServlet.ReportRecord)localObject1).time_stamp = this.jdField_a_of_type_Long;
          ((OlympicServlet.ReportRecord)localObject1).count = this.e;
          localArrayList4.add(localObject1);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label477;
        }
        OlympicServlet.a(this.jdField_a_of_type_MqqAppAppRuntime, k, localArrayList1, localArrayList2, localArrayList3, localArrayList4, null);
        i += 1;
      }
    }
    label477:
    if (this.c == 1) {}
    for (long l = OlympicManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager);; l = OlympicManager.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager))
    {
      j = (int)l;
      OlympicManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager).postDelayed(new trl(this, k, localArrayList1, localArrayList2, localArrayList3, localArrayList4), j);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicManager$ShuayishuaReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */