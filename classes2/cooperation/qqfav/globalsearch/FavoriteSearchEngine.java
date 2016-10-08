package cooperation.qqfav.globalsearch;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.List;
import ygm;
import ygn;

public class FavoriteSearchEngine
  implements ISearchEngine
{
  public static final int a = 0;
  public static final String a = "bMore";
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  public static final String b = "iNumber";
  public static final int c = 2;
  public static final String c = "lModifyTime";
  public static final int d = 3;
  public static final String d = "bSearchNet";
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = -1;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  private long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Thread jdField_a_of_type_JavaLangThread;
  private List jdField_a_of_type_JavaUtilList;
  private final ygm jdField_a_of_type_Ygm;
  private final ygn jdField_a_of_type_Ygn;
  private Thread b;
  private String e;
  private int t;
  
  public FavoriteSearchEngine(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ygm = new ygm(this, null);
    this.jdField_a_of_type_Ygn = new ygn(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    int i1;
    long l1;
    boolean bool2;
    boolean bool1;
    label116:
    Object localObject1;
    for (;;)
    {
      try
      {
        if ((!jdField_a_of_type_Boolean) || (paramSearchRequest == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0))
        {
          if (!jdField_a_of_type_Boolean) {
            jdField_a_of_type_Boolean = QfavHelper.a(false);
          }
          paramSearchRequest = null;
          return paramSearchRequest;
        }
        this.jdField_a_of_type_Ygn.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
        if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
          break label1033;
        }
        i1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getInt("iNumber", 4);
        l1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getLong("lModifyTime", Long.MAX_VALUE);
        bool2 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("bMore", false);
        bool1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("bSearchNet", false);
        if ((!paramSearchRequest.jdField_a_of_type_JavaLangString.equals(this.e)) || ((bool1) && (this.t == 1)))
        {
          this.e = paramSearchRequest.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Long = Long.MAX_VALUE;
          this.jdField_a_of_type_JavaUtilList.clear();
          this.t = 0;
        }
        if ((this.t != 2) && ((bool1) || (this.t != 1))) {
          break;
        }
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        paramSearchRequest = (SearchRequest)localObject1;
        if (!bool2) {
          if (this.jdField_a_of_type_JavaUtilList.size() > 1)
          {
            ((ArrayList)localObject1).remove(((ArrayList)localObject1).size() - 1);
            paramSearchRequest = (SearchRequest)localObject1;
          }
          else
          {
            paramSearchRequest = null;
          }
        }
      }
      finally {}
    }
    label279:
    label422:
    boolean bool3;
    label599:
    int i2;
    label709:
    int i4;
    label743:
    int i3;
    if ((bool2) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      l1 = Math.min(l1, this.jdField_a_of_type_Long);
      this.t = 0;
      this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
      this.jdField_a_of_type_Ygm.jdField_a_of_type_JavaLangString = this.e;
      this.jdField_a_of_type_Ygm.jdField_a_of_type_Int = i1;
      this.jdField_a_of_type_Ygm.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Ygm.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Ygm.jdField_a_of_type_AndroidDatabaseCursor = null;
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Ygm)
        {
          this.b = new Thread(this.jdField_a_of_type_Ygm);
          this.b.start();
          try
          {
            this.jdField_a_of_type_Ygm.wait();
            localObject1 = this.jdField_a_of_type_Ygm.jdField_a_of_type_AndroidDatabaseCursor;
            if (localObject1 == null) {
              break label1017;
            }
            if (!((Cursor)localObject1).moveToFirst()) {
              break;
            }
            if ((this.jdField_a_of_type_JavaUtilList.size() >= 5) || (((Cursor)localObject1).getCount() <= 1)) {
              break label1080;
            }
            i1 = 1;
            if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
              this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
            }
            ??? = new FavoriteSearchResultModel();
            ((FavoriteSearchResultModel)???).jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
            ((FavoriteSearchResultModel)???).jdField_a_of_type_Long = ((Cursor)localObject1).getLong(0);
            ((FavoriteSearchResultModel)???).jdField_b_of_type_Long = ((Cursor)localObject1).getLong(4);
            ((FavoriteSearchResultModel)???).jdField_c_of_type_Long = ((Cursor)localObject1).getLong(5);
            ((FavoriteSearchResultModel)???).jdField_b_of_type_JavaLangString = ((Cursor)localObject1).getString(1);
            ((FavoriteSearchResultModel)???).jdField_c_of_type_JavaLangString = ((Cursor)localObject1).getString(2);
            ((FavoriteSearchResultModel)???).jdField_d_of_type_JavaLangString = ((Cursor)localObject1).getString(3);
            ((FavoriteSearchResultModel)???).e = ((Cursor)localObject1).getInt(6);
            ((FavoriteSearchResultModel)???).jdField_d_of_type_Int = ((Cursor)localObject1).getInt(8);
            ((FavoriteSearchResultModel)???).jdField_a_of_type_ArrayOfByte = ((Cursor)localObject1).getBlob(7);
            ((FavoriteSearchResultModel)???).f = ((Cursor)localObject1).getInt(9);
            if (((Cursor)localObject1).getInt(10) <= 0) {
              break label1086;
            }
            bool3 = true;
            ((FavoriteSearchResultModel)???).jdField_a_of_type_Boolean = bool3;
            ((FavoriteSearchResultModel)???).jdField_b_of_type_Int = ((Cursor)localObject1).getInt(11);
            ((FavoriteSearchResultModel)???).jdField_c_of_type_Int = ((Cursor)localObject1).getInt(12);
            ((FavoriteSearchResultModel)???).jdField_a_of_type_Int = ((Cursor)localObject1).getInt(13);
            ((FavoriteSearchResultModel)???).g = ((Cursor)localObject1).getInt(14);
            this.jdField_a_of_type_JavaUtilList.add(???);
            if (((Cursor)localObject1).moveToNext()) {
              continue;
            }
            if (((FavoriteSearchResultModel)???).jdField_a_of_type_Long < 0L)
            {
              if (((FavoriteSearchResultModel)???).jdField_a_of_type_Long != -2L) {
                break label870;
              }
              this.jdField_a_of_type_Long = ((FavoriteSearchResultModel)???).jdField_b_of_type_Long;
              if (!bool1) {
                break label1092;
              }
              i2 = 2;
              this.t = i2;
            }
            if (i1 == 0) {
              break label914;
            }
            i4 = Math.min(4, this.jdField_a_of_type_JavaUtilList.size() - 1);
            i1 = 0;
          }
          catch (InterruptedException localInterruptedException)
          {
            int i5;
            if (!QLog.isColorLevel()) {
              break label1075;
            }
          }
          if (i2 <= 0) {
            break label1098;
          }
          i5 = i3 - i2;
          paramSearchRequest = (FavoriteSearchResultModel)this.jdField_a_of_type_JavaUtilList.get(i5);
          if (paramSearchRequest.g > ((FavoriteSearchResultModel)this.jdField_a_of_type_JavaUtilList.get(i5 + 1)).g)
          {
            this.jdField_a_of_type_JavaUtilList.set(i5, this.jdField_a_of_type_JavaUtilList.get(i5 + 1));
            this.jdField_a_of_type_JavaUtilList.set(i5 + 1, paramSearchRequest);
          }
          i2 -= 1;
          continue;
          QLog.d("qqfav", 2, "InterruptedException, search cancel.");
        }
        label870:
        if ((localInterruptedException.getCount() > 1) || (l1 > ((FavoriteSearchResultModel)???).jdField_b_of_type_Long)) {
          this.jdField_a_of_type_Long = ((FavoriteSearchResultModel)???).jdField_b_of_type_Long;
        } else {
          this.t = -1;
        }
      }
      this.t = -1;
    }
    label914:
    label1017:
    label1025:
    label1033:
    label1075:
    label1080:
    label1086:
    label1092:
    label1098:
    label1105:
    for (;;)
    {
      localInterruptedException.close();
      ArrayList localArrayList;
      for (;;)
      {
        if ((this.t == -1) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
          ((FavoriteSearchResultModel)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_Long = -3L;
        }
        localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        paramSearchRequest = localArrayList;
        if (bool2) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
          break label1025;
        }
        localArrayList.remove(localArrayList.size() - 1);
        paramSearchRequest = localArrayList;
        break;
        this.t = -1;
      }
      paramSearchRequest = null;
      break;
      break label279;
      bool2 = false;
      i1 = 4;
      bool1 = false;
      l1 = Long.MAX_VALUE;
      break label116;
      for (;;)
      {
        if (i1 >= i4 - 1) {
          break label1105;
        }
        i3 = i4 - i1 - 1;
        i2 = i3;
        break label743;
        localArrayList = null;
        break;
        i1 = 0;
        break label422;
        bool3 = false;
        break label599;
        i2 = 1;
        break label709;
        i1 += 1;
      }
    }
  }
  
  public void a()
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = QfavHelper.a(false);
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    if ((paramSearchRequest == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_Ygn)
    {
      this.jdField_a_of_type_Ygn.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
      this.jdField_a_of_type_Ygn.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
      ThreadManager.a(this.jdField_a_of_type_Ygn);
      ThreadManager.a(this.jdField_a_of_type_Ygn, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_Ygn)
    {
      this.jdField_a_of_type_Ygn.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = null;
      this.jdField_a_of_type_Ygn.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
      ThreadManager.a(this.jdField_a_of_type_Ygn);
      if (this.jdField_a_of_type_JavaLangThread != null) {
        this.jdField_a_of_type_JavaLangThread.interrupt();
      }
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqfav\globalsearch\FavoriteSearchEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */