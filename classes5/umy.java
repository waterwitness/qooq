import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class umy
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public umy(NetSearchEngine paramNetSearchEngine, String paramString, ArrayList paramArrayList, ISearchListener paramISearchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (paramISearchListener != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramISearchListener);
    }
  }
  
  private List a(String paramString, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(12);
    StringBuilder localStringBuilder = new StringBuilder(paramArrayList.size() * 64);
    int k = paramArrayList.size();
    int i = 0;
    if (i < k)
    {
      Object localObject = (byte[])paramArrayList.get(i);
      int j;
      if (localObject == null)
      {
        j = 0;
        label74:
        if (j > 10) {
          break label98;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = localObject.length;
        break label74;
        label98:
        int n = (int)PkgTools.a((byte[])localObject, 1);
        int m = (int)PkgTools.a((byte[])localObject, 5);
        if ((n > 0) && (n + 9 < j))
        {
          byte[] arrayOfByte = new byte[n];
          PkgTools.a(arrayOfByte, 0, (byte[])localObject, 9, n);
          j = n + 9;
          SummaryCardBusiEntry.comm localcomm = new SummaryCardBusiEntry.comm();
          try
          {
            localcomm.mergeFrom(arrayOfByte);
            n = localcomm.result.get();
            if (n != 0) {
              break label281;
            }
            n = localcomm.service.get();
            arrayOfByte = new byte[m];
            PkgTools.a(arrayOfByte, 0, (byte[])localObject, j, m);
            localObject = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine.a(paramString, n, localcomm, arrayOfByte);
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              continue;
            }
            localArrayList.addAll((Collection)localObject);
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel())
          {
            QLog.i("NetSearchEngine", 2, localException.toString());
            continue;
            label281:
            localStringBuilder.append(" |busi entry, [").append(localcomm.service.get()).append(",").append(n).append(",").append(localcomm.err_msg.get());
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("NetSearchEngine", 4, localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  public void run()
  {
    List localList = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      ISearchListener localISearchListener = (ISearchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localISearchListener != null) {
        localISearchListener.a(localList, 1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */