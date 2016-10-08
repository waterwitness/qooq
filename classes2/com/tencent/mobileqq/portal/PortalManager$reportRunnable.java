package com.tencent.mobileqq.portal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import mqq.app.AppRuntime;

public class PortalManager$reportRunnable
  implements Runnable
{
  public static final int a = 1;
  public static final int b = 2;
  private long jdField_a_of_type_Long;
  private SparseArrayCompat jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private boolean jdField_a_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public PortalManager$reportRunnable(PortalManager paramPortalManager, SparseArrayCompat paramSparseArrayCompat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = paramSparseArrayCompat;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) || (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() <= 0)) {
      return;
    }
    int i = 0;
    label21:
    Object localObject1;
    Object localObject2;
    int j;
    label170:
    int k;
    if (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localObject1 = new ArrayList(100);
      localObject2 = new LongSparseArray(60);
      int m = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i);
      Object localObject3 = ((ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(m)).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject3).next();
        if (this.c == 1) {}
        for (j = 1000;; j = 60000)
        {
          l = localLong.longValue() / j * j;
          if (((LongSparseArray)localObject2).a(l) == null) {
            break label170;
          }
          ((LongSparseArray)localObject2).a(l, Integer.valueOf(((Integer)((LongSparseArray)localObject2).a(l)).intValue() + 1));
          break;
        }
        ((LongSparseArray)localObject2).a(l, Integer.valueOf(1));
      }
      k = 0;
      j = 0;
      while (k < ((LongSparseArray)localObject2).a())
      {
        localObject3 = new RedPacketServlet.BrashReportItem();
        l = ((LongSparseArray)localObject2).a(k);
        ((RedPacketServlet.BrashReportItem)localObject3).time = l;
        ((RedPacketServlet.BrashReportItem)localObject3).count = ((int)((Integer)((LongSparseArray)localObject2).a(l)).intValue());
        ((ArrayList)localObject1).add(localObject3);
        j += ((RedPacketServlet.BrashReportItem)localObject3).count;
        k += 1;
      }
      localObject2 = PortalManager.a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager);
      if (this.c != 1) {
        break label497;
      }
      k = 1;
      label281:
      localObject2 = ((Handler)localObject2).obtainMessage(14, m, k, localObject1);
      if (this.c == 1)
      {
        localObject3 = new Bundle();
        if (this.d > 0) {
          ((Bundle)localObject3).putInt("k_e_ctr", this.d);
        }
        if (this.e > 0) {
          ((Bundle)localObject3).putInt("k_h_ctr", this.e);
        }
        if (this.f > 0) {
          ((Bundle)localObject3).putInt("k_c_ctr", this.f);
        }
        ((Bundle)localObject3).putLong("k_s_time", this.jdField_a_of_type_Long);
        ((Message)localObject2).setData((Bundle)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "reportRunnable " + this.d + ", " + this.e + ", " + this.f + ", " + j);
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label509;
      }
      localObject3 = PortalManager.a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager);
      j = ((Message)localObject2).arg1;
      if (((Message)localObject2).arg2 != 1) {
        break label503;
      }
      bool = true;
      RedPacketServlet.a((AppRuntime)localObject3, j, (ArrayList)localObject1, bool, ((Message)localObject2).getData());
    }
    label497:
    label503:
    label509:
    while (PortalManager.a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager)) {
      for (;;)
      {
        i += 1;
        break label21;
        break;
        k = 0;
        break label281;
        boolean bool = false;
      }
    }
    if (this.c == 1)
    {
      l = PortalManager.b;
      label532:
      j = (int)l;
      localObject1 = PortalManager.a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager);
      if (j > 0) {
        break label572;
      }
    }
    label572:
    for (long l = 0L;; l = new Random().nextInt(j))
    {
      ((Handler)localObject1).sendMessageDelayed((Message)localObject2, l);
      break;
      l = PortalManager.c;
      break label532;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\PortalManager$reportRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */