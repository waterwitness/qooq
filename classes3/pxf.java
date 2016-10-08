import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class pxf
  implements Runnable
{
  public static final int a = 1;
  public static final int b = 3;
  public static final int c = 2;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int d;
  
  public pxf(DiscussionIconHelper paramDiscussionIconHelper, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 2;
    this.d = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (DiscussionIconHelper.a(paramString))
    {
      this.jdField_a_of_type_JavaLangString = DiscussionIconHelper.b(paramString);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaLangString == null) {}
    pxe localpxe1;
    do
    {
      do
      {
        return;
        localpxe1 = (pxe)DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).get(this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_Boolean) {
          localpxe1 = (pxe)DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).get(DiscussionIconHelper.a(this.jdField_a_of_type_JavaLangString));
        }
      } while ((localpxe1 == null) && (this.d != 3));
      switch (this.d)
      {
      default: 
        return;
      case 1: 
        localpxe1 = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString, true, localpxe1, false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + localpxe1.jdField_a_of_type_Boolean);
        }
        break;
      }
    } while (!localpxe1.jdField_a_of_type_Boolean);
    String str1;
    pxe localpxe2;
    int j;
    if (localpxe1.c)
    {
      DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, DiscussionIconHelper.a(this.jdField_a_of_type_JavaLangString));
      return;
      str1 = this.jdField_a_of_type_JavaLangString;
      localpxe2 = localpxe1;
      if (localpxe1 != null) {
        localpxe2 = localpxe1;
      }
      try
      {
        if (localpxe1.jdField_a_of_type_JavaLangString == null) {
          localpxe2 = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString, false, localpxe1, true);
        }
        if (localpxe2 == null) {
          return;
        }
      }
      finally {}
      if (!localpxe2.jdField_b_of_type_Boolean)
      {
        localpxe2.jdField_b_of_type_Boolean = true;
        localpxe2.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((localpxe2.jdField_a_of_type_JavaLangString != null) && (localpxe2.jdField_a_of_type_JavaLangString.length() > 1))
        {
          ??? = localpxe2.jdField_a_of_type_JavaLangString.split(";");
          if (??? != null) {
            j = ???.length;
          }
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        String str2 = ???[i];
        if ((str2 != null) && (str2.length() != 0)) {
          if (!DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a(1, str2, 0)) {
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a().a(str2, (byte)0, (byte)2);
          } else {
            localpxe2.jdField_a_of_type_JavaUtilArrayList.add(str2);
          }
        }
      }
      else
      {
        if ((localpxe2.jdField_a_of_type_Byte == 2) && (localpxe2.jdField_b_of_type_JavaLangString != null))
        {
          ??? = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, localpxe2.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, false);
          if (localpxe2.jdField_b_of_type_JavaLangString.equals(???)) {
            return;
          }
        }
        i = localpxe2.jdField_a_of_type_JavaUtilArrayList.size();
        if ((i >= localpxe2.jdField_a_of_type_Int) || ((localpxe2.jdField_a_of_type_Byte == 1) && (i >= 4) && (localpxe2.jdField_a_of_type_Int > 4)) || ((localpxe2.jdField_a_of_type_Byte == 2) && (i > 0)) || (localpxe2.d))
        {
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString, localpxe2, false);
          if (i >= localpxe2.jdField_a_of_type_Int) {
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).remove(this.jdField_a_of_type_JavaLangString);
          }
        }
        if ((i < localpxe2.jdField_a_of_type_Int) && (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper) == null)) {}
        synchronized (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper))
        {
          if (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper) == null)
          {
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, new pxc(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, null));
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).setName("CheckDisIconThread");
            DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).start();
          }
          return;
        }
        DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString);
        return;
        ??? = new pxe(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, null);
        ??? = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, this.jdField_a_of_type_JavaLangString, true, (pxe)???, true);
        boolean bool;
        if (((pxe)???).jdField_a_of_type_Boolean) {
          if (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).containsKey(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.e(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.b(this.jdField_a_of_type_JavaLangString);
            bool = true;
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + ((pxe)???).jdField_a_of_type_Boolean + ", isCreated=" + bool);
          return;
          File localFile = new File(DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).b.a(101, this.jdField_a_of_type_JavaLangString, 0));
          if ((localFile != null) && (localFile.exists())) {
            localFile.delete();
          }
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a(101, this.jdField_a_of_type_JavaLangString, 0);
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).remove(this.jdField_a_of_type_JavaLangString);
          bool = false;
          continue;
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).remove(this.jdField_a_of_type_JavaLangString);
          bool = false;
        }
        break;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */