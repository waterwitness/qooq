import android.util.Pair;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class pxc
  extends Thread
{
  public boolean a;
  
  private pxc(DiscussionIconHelper paramDiscussionIconHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread start.");
    }
    int i;
    long l;
    String str1;
    label62:
    String str2;
    pxe localpxe;
    Object localObject7;
    label218:
    int j;
    boolean bool1;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 0;
      l = System.currentTimeMillis();
      str1 = null;
      Object localObject1 = null;
      synchronized (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper))
      {
        Iterator localIterator = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).keySet().iterator();
        if (!localIterator.hasNext()) {
          break label568;
        }
        str2 = (String)localIterator.next();
        localpxe = (pxe)DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).get(str2);
        if ((localpxe != null) && (localpxe.jdField_b_of_type_Int >= 8)) {
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a(false, true, str2);
        }
      }
      if ((localpxe == null) || (localpxe.jdField_a_of_type_JavaLangString == null) || (localpxe.jdField_a_of_type_Byte == 3)) {
        break label817;
      }
      if ((localpxe.jdField_a_of_type_Byte == 1) && (l - localpxe.jdField_a_of_type_Long >= DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper)))
      {
        localObject7 = str1;
        if (str1 == null) {
          localObject7 = new ArrayList();
        }
        if (!DiscussionIconHelper.a(str2)) {
          break label823;
        }
        str1 = DiscussionIconHelper.b(str2);
        j = localpxe.jdField_a_of_type_JavaUtilArrayList.size();
        localpxe.jdField_a_of_type_Byte = 2;
        if (j <= 0) {
          break label840;
        }
        bool2 = true;
        bool1 = bool2;
        if (localpxe.jdField_b_of_type_JavaLangString != null)
        {
          str2 = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, localpxe.jdField_a_of_type_JavaUtilArrayList, str1, false);
          bool1 = bool2;
          if (localpxe.jdField_b_of_type_JavaLangString.equals(str2)) {
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          ((ArrayList)localObject7).add(Pair.create(str1, localpxe));
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).remove(str1);
        }
      }
    }
    label568:
    label817:
    label820:
    label823:
    label829:
    label837:
    label840:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qqhead.dih", 2, "CheckDisIcon expired: " + str1 + ", iconCount: " + j + ", faceCount:" + localpxe.jdField_a_of_type_Int + ", isTryCreate: " + bool2 + ", faceUinSet: " + localpxe.jdField_a_of_type_JavaLangString + ",isPstnIcon: " + localpxe.c);
        break label829;
        if ((localpxe.jdField_a_of_type_Byte == 2) && (l - localpxe.jdField_a_of_type_Long >= DiscussionIconHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon timeout: " + str2 + ", iconCount: " + localpxe.jdField_a_of_type_JavaUtilArrayList.size() + ", faceCount:" + localpxe.jdField_a_of_type_Int + ", faceUinSet: " + localpxe.jdField_a_of_type_JavaLangString);
          }
          if (localObject2 != null) {
            break label820;
          }
          ??? = new ArrayList();
        }
        for (;;)
        {
          ((ArrayList)???).add(str2);
          i += 1;
          break label837;
          if (localpxe.jdField_a_of_type_Byte != 3)
          {
            i += 1;
            break label837;
            if ((this.jdField_a_of_type_Boolean) && (str1 != null))
            {
              j = 0;
              while ((j < str1.size()) && (this.jdField_a_of_type_Boolean))
              {
                localObject7 = (Pair)str1.get(j);
                DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, (String)((Pair)localObject7).first, (pxe)((Pair)localObject7).second, true);
                j += 1;
              }
            }
            if ((this.jdField_a_of_type_Boolean) && (??? != null))
            {
              j = 0;
              while ((j < ((ArrayList)???).size()) && (this.jdField_a_of_type_Boolean))
              {
                str1 = (String)((ArrayList)???).get(j);
                this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.c(str1);
                j += 1;
              }
            }
            if (i == 0) {}
            synchronized (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper))
            {
              DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, null);
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread exit. isRunning=" + this.jdField_a_of_type_Boolean);
              }
              return;
              if (!this.jdField_a_of_type_Boolean) {
                break;
              }
            }
            try
            {
              synchronized (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper))
              {
                DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).wait(DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper) / 10);
              }
              localObject5 = finally;
              throw ((Throwable)localObject5);
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;) {}
            }
          }
          break label837;
        }
        localObject6 = str2;
        break label218;
      }
      Object localObject6 = localObject7;
      i += 1;
      break label62;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */